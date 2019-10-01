package com.upec.secu.clients;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricKeyManager {

	public static byte[] cipher(byte[] key, byte[] data) throws Exception {
			key = Arrays.copyOf(key, 16); // use only first 128 bit
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES"); // Instantiate the cipher
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			return cipher.doFinal(data);
	}
	
	public static byte[] decipher(byte[] key, byte[] data) throws Exception {
			key = Arrays.copyOf(key, 16); // use only first 128 bit
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES"); // Instantiate the cipher
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			return cipher.doFinal(data);
	}

}
