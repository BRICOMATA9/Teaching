package com.upec.secu.clients;

import java.security.KeyPair;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.Certificate;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import java.security.KeyPairGenerator;

public class CertificateRequest extends Connection {

    public static final String ASYMETRIC_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    public static final String PROVIDER            = "BC";
    X509Certificate            mycert;
    PrivateKey                 key;

    public CertificateRequest( String addr, Integer port ) {
        super( addr, port );
    }

    @Override
    public void run() throws Exception {
        Security.addProvider( new BouncyCastleProvider() );
		    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance( ASYMETRIC_ALGORITHM );
		    KeyPair kp = keyPairGenerator.generateKeyPair();
        this.key = kp.getPrivate();
        //String identite = readIdentity();
        //System.out.print( "Please enter your password: " );
        PKCS10CertificationRequest request = generateCertificateRequest( "identite", kp );
        byte[] bytes = request.getEncoded();
        out.write( bytes );
        byte[] rep = this.read();
				X509Certificate cert = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(rep));

        if ( cert == null ) {
            this.errormessage = new String( rep );
            throw new Exception();
        } else {
            this.mycert = cert;
						System.out.println("well");
        }
        this.close();
    }

    public static PKCS10CertificationRequest generateCertificateRequest( String name, KeyPair kp ) throws Exception {
        Security.addProvider( new BouncyCastleProvider() );
        KeyPair keys = kp;
        X500Name subjectName = new X500Name( "cn=" + name );
        SubjectPublicKeyInfo keyInfo = SubjectPublicKeyInfo.getInstance( keys.getPublic().getEncoded() );
        PKCS10CertificationRequestBuilder csrgen = new PKCS10CertificationRequestBuilder( subjectName, keyInfo );
        ContentSigner contentSigner = new JcaContentSignerBuilder( SIGNATURE_ALGORITHM ).setProvider( PROVIDER ).build( keys.getPrivate() );
        return csrgen.build( contentSigner );
    }

		public boolean storeCertAndKey(KeyStore ks, String alcert, String alkey, String alpass) { 
			// Store the certificate and the key using the aliases given in parameter
			try {
				ks.setCertificateEntry(alcert, this.mycert);
				ks.setKeyEntry(alkey, this.key,alpass.toCharArray(), new Certificate[] {this.mycert});
				ks.store(new FileOutputStream( "keystores/user_keystore.ks" ), "passwd".toCharArray());
				return true;
			}
			catch(Exception e) {
				return false;
			}
		}
}
