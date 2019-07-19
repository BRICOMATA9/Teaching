package des;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class Dechiffrement {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream(args[0]);
		OutputStream os = new FileOutputStream (args[1]);

		Cipher c = Cipher.getInstance("DES");
		
		KeyGenerator key = KeyGenerator.getInstance("DES");
			Key k = key.generateKey();

	    c.init(Cipher.DECRYPT_MODE, k);
	
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    byte[] input = new byte[256];
	
	    int bytesRead = is.read(input, 0, 256);
	    while (bytesRead > 0) {
	        byte[] output = c.update(input, 0, bytesRead);
	        if (output != null) {
	            baos.write(output);
	        }
	        bytesRead = is.read(input, 0, 256);
	    }
	
	    byte[] output = c.doFinal();
	    if (output != null) {
	        baos.write(output);
	    }
	    
		baos.writeTo(os);
	
	    is.close();
        os.close();
	}
}