package com.upec.secu.clients;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Random;
import org.bouncycastle.cms.CMSSignedData;
import java.security.MessageDigest;

public class NeedhamSchroeder {

	BigInteger na;

	public static byte[] step1nonceAToB(X509Certificate certA, PrivateKey keyA, X509Certificate certB,
			BigInteger nonce) {
		// M3: A --> B: {Na,A}Kb                en fait: { {Na}Ka', A }Kb
		try {
			CMSSignedData nonceSigned = CMSDataManager.signMessage(certA, keyA, nonce.toByteArray());
			byte[] nonceEncrypted = CMSDataManager.encryptMessage(nonceSigned.getEncoded(), certB);
			return nonceEncrypted;
		} catch (Exception e) {
			System.out.println("erreur");
			return null;
		}
	}

	public static byte[] step2nonceAnonceBToA(X509Certificate certA, PrivateKey keyB, BigInteger nonceB,
			byte[] nonceEncrypted, boolean requireValidSig) {
		// M6: B --> A: {Na,Nb}Ka
		try {
			CMSSignedData nonceSigned = new CMSSignedData((byte[]) CMSDataManager.decryptMessage(nonceEncrypted, keyB));
			byte[] rawnonceA = (byte[]) CMSDataManager.verifySignedMessage(nonceSigned);
			if (rawnonceA == null && requireValidSig) {
				return null;
			}
			byte[] rawnonceB = nonceB.toByteArray();
			byte[] container = new byte[rawnonceA.length + rawnonceB.length];

			System.arraycopy(rawnonceA, 0, container, 0, rawnonceA.length);
			System.arraycopy(rawnonceB, 0, container, rawnonceA.length, rawnonceB.length);

			byte[] nonceAnonceBEncrypted = CMSDataManager.encryptMessage(container, certA);
			return nonceAnonceBEncrypted;
		} catch (Exception e) {
		}
		return null;
	}

	public static BigInteger getnonceAFromStep1(PrivateKey keyB, byte[] nonceEncrypted) {
		try {
			CMSSignedData nonceSigned = new CMSSignedData((byte[]) CMSDataManager.decryptMessage(nonceEncrypted, keyB));
			byte[] rawnonceA = (byte[]) CMSDataManager.verifySignedMessage(nonceSigned);
			return new BigInteger(rawnonceA);
		} catch (Exception e) {
			return null;
		}
	}

	public static byte[] step3nonceBToB(PrivateKey keyA, X509Certificate certB, byte[] dataEncrypted,
			BigInteger nonceAOrig) {
		try {
			byte[] container = (byte[]) CMSDataManager.decryptMessage(dataEncrypted, keyA);
			byte[] nonceA = Arrays.copyOf(container, nonceAOrig.toByteArray().length);
			byte[] nonceB = Arrays.copyOfRange(container, nonceAOrig.toByteArray().length, container.length);
			if (nonceAOrig.equals(new BigInteger(nonceA))) {
				System.out.println("OK");
				byte[] nonceBEncrypted = CMSDataManager.encryptMessage(nonceB, certB);
				return nonceBEncrypted;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static BigInteger getNonceBFromStep2(PrivateKey keyA, byte[] dataEncrypted, BigInteger nonceAOrig) {
		try {
			byte[] container = (byte[]) CMSDataManager.decryptMessage(dataEncrypted, keyA);
			byte[] nonceB = Arrays.copyOfRange(container, nonceAOrig.toByteArray().length, container.length);
			return new BigInteger(nonceB);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean step3received(PrivateKey keyB, BigInteger nonceBOrig, byte[] nonceBEnc) {
		try {
			byte[] nonceB = (byte[]) CMSDataManager.decryptMessage(nonceBEnc, keyB);
			if (nonceBOrig.equals(new BigInteger(nonceB))) {
				System.out.println("OK");
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static BigInteger generateNonce() {

		Random randomGenerator = new Random();
		return new BigInteger(53, randomGenerator);
	}

	public static byte[] generateSessionKey(BigInteger nonceA, BigInteger nonceB) {
		try {
			byte[] rawA = nonceA.toByteArray();
			byte[] rawB = nonceB.toByteArray();
			byte[] seed = new byte[rawA.length + rawB.length];

			System.arraycopy(rawA, 0, seed, 0, rawA.length);
			System.arraycopy(rawB, 0, seed, rawA.length, rawB.length);
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(seed);
			return md.digest();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
