package com.upec.secu.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Scanner;

public class Client {
	public static final String ASYMETRI_ALGORITHME = "SHA1withRSA";

	public static final String KEYSTORE_FILE = "keystores/user_keystore.ks";
	public static final String PASSWORD = "passwd";

	public static final String USER_ALIAS = "myself";

	public static final String CA_ADDRESS = "localhost";
	public static final int CA_PORT = 7001;

	public static final String ALIA_CERT = "alice_certificat";
	public static final String ALIA_KEY = "alice_private";
	public static final String KEYPASS = "monpassP1";

	private X509Certificate myCert;
	private PrivateKey myKey;
	private KeyStore myKeyStore;
	ServerSocket server_sock;
	Socket s_cli;
	byte[] sessionkey;
	DataOutputStream out;
	DataInputStream in;
	ConnectionChat chat;
	NeedhamShroederClient needhamcli;

	public Client() {

	}

	public void chargeCertificat() throws Exception {

		myKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		myKeyStore.load(new FileInputStream(KEYSTORE_FILE), PASSWORD.toCharArray());

		if (myKeyStore.containsAlias(ALIA_CERT))
			myCert = (X509Certificate) myKeyStore.getCertificate(ALIA_CERT);
		if (myKeyStore.containsAlias(ALIA_KEY))
			myKey = (PrivateKey) myKeyStore.getKey(ALIA_KEY, KEYPASS.toCharArray());

	}

	public void createCertificat() throws Exception {

		myKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		myKeyStore.load(null, PASSWORD.toCharArray());
		CertificateRequest certRequest = new CertificateRequest(CA_ADDRESS, CA_PORT);
		certRequest.connect();
		certRequest.run();
		certRequest.storeCertAndKey(myKeyStore, ALIA_CERT, ALIA_KEY, KEYPASS);

		myKeyStore.load(new FileInputStream(KEYSTORE_FILE), PASSWORD.toCharArray());
		if (myKeyStore.containsAlias(ALIA_CERT))
			myCert = (X509Certificate) myKeyStore.getCertificate(ALIA_CERT);
		if (myKeyStore.containsAlias(ALIA_KEY))
			myKey = (PrivateKey) myKeyStore.getKey(ALIA_KEY, KEYPASS.toCharArray());

	}

	public void menuNumberHandler(int num) throws Exception {
		try {
			switch (num) {
			case (1):
				try {
					createCertificat();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case (2):
				break;
			case (3):
				try {
					chargeCertificat();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case (4):

				System.out.print("Please enter IP to connect to: ");
				String ip = "127.0.0.1";// ClientUtils.saisieString();
				Integer port = 7000;
				needhamcli = new NeedhamShroederClient(ip, port, s_cli, false, this.myCert, this.myKey);

				try {
					needhamcli.connect();
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
				needhamcli.run();

				sessionkey = needhamcli.getSessionKey();
				this.s_cli = needhamcli.getSocketBack();

				System.out.println("----- Chat -----");
				chat = new ConnectionChat(ip, port, this.s_cli, sessionkey);
				chat.bind();
				chat.run();
				chat.close();
				if (chat.finishedWell())
					System.out.println("Done.");
				else {
					System.out.println(chat.getErrorMessage());
					throw new Exception();
				}

				break;
			case (5):
				// --------------------------- Start session as SERVER

				if (this.server_sock != null) {
					this.s_cli.close();
					this.server_sock.close();
					this.server_sock = null;
				}

				this.server_sock = new ServerSocket(7000);

				System.out.println("Wait for a connection...");
				this.s_cli = this.server_sock.accept();
				System.out.println("Client accepted: " + s_cli.getLocalSocketAddress().toString());

				Integer p = 7000;
				needhamcli = new NeedhamShroederClient("localhost", p, s_cli, true, this.myCert, this.myKey);
				needhamcli.bind();

				needhamcli.run();
				this.in = needhamcli.getInputStream();
				this.out = needhamcli.getOutputStream();
				if (needhamcli.finishedWell())
					System.out.println("Needham Shroeder exchange OK");
				else {
					System.out.println(needhamcli.getErrorMessage());
					break;
				}
				sessionkey = needhamcli.getSessionKey();
				s_cli = needhamcli.getSocketBack();

				System.out.println("----- Chat -----");
				chat = new ConnectionChat("localhost", p, s_cli, sessionkey);
				chat.bind();
				chat.run();
				chat.close();
				if (chat.finishedWell())
					System.out.println("Done.");
				else {
					System.out.println(chat.getErrorMessage());
					throw new Exception();
				}
				this.server_sock.close();
				this.server_sock = null;
				s_cli.close();

				break;
			case (6):
				throw new Exception();
			default:
			}

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public X509Certificate getMyCert() {
		return myCert;
	}

	public void setMyCert(X509Certificate myCert) {
		this.myCert = myCert;
	}

	public PrivateKey getMyKey() {
		return myKey;
	}

	public void setMyKey(PrivateKey myKey) {
		this.myKey = myKey;
	}

	public KeyStore getMyKeyStore() {
		return myKeyStore;
	}

	public void setMyKeyStore(KeyStore myKeyStore) {
		this.myKeyStore = myKeyStore;
	}

	public boolean hasKeyStore() {
		File f = new File(KEYSTORE_FILE);
		return f.exists();
	}

	public void menuSelection() throws Exception {
		Integer val = null;
		boolean isOK = true;
		try {
			do {
				System.out.println("Menu: ");
				System.out.println("1 - Create certificate");
				System.out.println("2 - Revoke certificate");
				System.out.println("3 - Get a certificate");
				System.out.println("4 - Start chat as client");
				System.out.println("5 - Start chat as server");
				System.out.println("6 - Quit");
				System.out.print("Choice: ");
				Scanner sc = new Scanner(System.in);
				val = new Integer(sc.nextLine());
				if (val == null)
					continue;
				else if (val >= 1 && val <= 6)
					isOK = false;
			} while (isOK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.menuNumberHandler(val);
	}

	public void run() {
		for (;;) {
			try {
				this.menuSelection();
			} catch (Exception e) {
				System.out.println("End.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Client cli = new Client();
		cli.run();
	}

}
