package com.upec.secu.ca;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

public class CA {

	public static final String ASYMETRIC_ALGORITHM = "RSA";
	public static final int BUFFER_SIZE = 1024;

	public static final String CA_KEYSTORE = "keystores/ca_keystore.ks";
	public static final String PASSWORD = "passwd";
	public static final String ALIA_CERT = "CA_Certificat";
	public static final String ALIA_KEY = "CA_Private";
	public static final String KEYPASS = "passwd";

	ServerSocketChannel service;
	Selector selector;
	ByteBuffer caBuffer;

	PrivateKey caKey;
	X509Certificate caCert;
	KeyStore caKeyStore;

	public CA(int port) {
		try {
			service = ServerSocketChannel.open();
			service.bind(new InetSocketAddress(port));
			selector = Selector.open();
			service.configureBlocking(false);
			service.register(selector, SelectionKey.OP_ACCEPT);

			caKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			if (!hasKeyStore()) {
				KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ASYMETRIC_ALGORITHM);
				KeyPair kp = keyPairGenerator.generateKeyPair();
				X509Certificate caCert = CertificateManager.createSelfSignedCertificate("CA", kp);
				caKeyStore.load(null, PASSWORD.toCharArray());
				caKeyStore.setCertificateEntry(ALIA_CERT, caCert);
				caKeyStore.setKeyEntry(ALIA_KEY, kp.getPrivate(), KEYPASS.toCharArray(), new Certificate[] { caCert });
				caKeyStore.store(new FileOutputStream(CA_KEYSTORE), PASSWORD.toCharArray());
			}

			caKeyStore.load(new FileInputStream(CA_KEYSTORE), PASSWORD.toCharArray());

			caKey = (PrivateKey) caKeyStore.getKey(ALIA_KEY, KEYPASS.toCharArray());
			caCert = (X509Certificate) caKeyStore.getCertificate(ALIA_CERT);
			caBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
			System.out.println("Autorité de certification à l'écoute!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void accept() {
		try {
			SocketChannel socket = service.accept();
			System.out.println("Demandeur de service de certification: " + socket);
			socket.configureBlocking(false);
			socket.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> i = keys.iterator();
				while (i.hasNext()) {
					SelectionKey k = (SelectionKey) i.next();
					i.remove();
					if (k.isValid()) {
						if (k.isAcceptable()) {
							accept();
						}
						if (k.isReadable()) {
							read(k);
						} else if (k.isWritable()) {
							write(k);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read(SelectionKey key) throws IOException {
		SocketChannel client = (SocketChannel) key.channel();
		this.caBuffer.clear();
		try {
			int byteread = client.read(this.caBuffer);
			if (byteread == -1) {
				client.close();
			} else {
				System.out.println("CSR received from: " + client.socket().getInetAddress().toString());
				PKCS10CertificationRequest csr = new PKCS10CertificationRequest(readBuff(byteread));
				BigInteger bigInt = new BigInteger(String.valueOf(System.currentTimeMillis()));
				X509Certificate c = retrieveCertificateFromCSR(csr, caKey, caCert, bigInt);
				key.attach(c.getEncoded());
				key.interestOps(SelectionKey.OP_WRITE);
			}
		} catch (Exception e) {
			System.err.println("Client closed unexpectedly!");
			client.close();
		}
	}

	public void write(SelectionKey sk) throws IOException {
		byte[] attachment = (byte[]) sk.attachment();
		SocketChannel client = (SocketChannel) sk.channel();
		client.write(ByteBuffer.wrap(attachment));
		sk.interestOps(SelectionKey.OP_READ);
	}

	public boolean hasKeyStore() {
		File f = new File(CA_KEYSTORE);
		return f.exists();
	}

	private byte[] readBuff(int val) {
		this.caBuffer.flip();
		byte myarray[] = new byte[val];
		for (int i = 0; this.caBuffer.hasRemaining(); i++) {
			myarray[i] = this.caBuffer.get();
		}
		return myarray;
	}

	public static X509Certificate retrieveCertificateFromCSR(PKCS10CertificationRequest inputCSR, PrivateKey caPrivate,
			X509Certificate caPublic, BigInteger serial) throws Exception {
		AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find("SHA1withRSA");
		AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId);
		AsymmetricKeyParameter parameterCa = PrivateKeyFactory.createKey(caPrivate.getEncoded());
		SubjectPublicKeyInfo keyInfo = inputCSR.getSubjectPublicKeyInfo();
		Calendar cal = Calendar.getInstance();
		Date notbefore = cal.getTime();
		cal.add(Calendar.YEAR, 2);
		Date notafter = cal.getTime();
		X509v3CertificateBuilder myCertificateGenerator = new X509v3CertificateBuilder(
				new X500Name(caPublic.getSubjectDN().getName()), serial, notbefore, notafter, inputCSR.getSubject(),
				keyInfo);
		ContentSigner sigGen = new BcRSAContentSignerBuilder(sigAlgId, digAlgId).build(parameterCa);
		X509CertificateHolder holder = myCertificateGenerator.build(sigGen);
		return (X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509", "BC")
				.generateCertificate(new ByteArrayInputStream(holder.getEncoded()));
	}

	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
		CA s = new CA(7001);
		s.run();
	}
}
