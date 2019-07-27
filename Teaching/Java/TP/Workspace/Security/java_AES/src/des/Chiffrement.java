package des;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class Chiffrement {

	public static void main(String[] args) throws Exception{

		InputStream is = new FileInputStream(args[0]);						// Ouvrir le fichier clair
		OutputStream os = new FileOutputStream (args[1]);					// Créer le fichier chiffré

		Cipher c = Cipher.getInstance("DES");											// Algorithme/Mode_Operatoir/Bourrage
		
		KeyGenerator key = KeyGenerator.getInstance("DES");
			Key k = key.generateKey();

			c.init(Cipher.ENCRYPT_MODE, k);

			ByteArrayOutputStream baos = new ByteArrayOutputStream(); // Créer un buffer qui contiendra le message chiffré
			byte[] input = new byte[256];

			int bytesRead = is.read(input, 0, 256);										// Lire la taille des blocs d'octet du fichier clair
			while (bytesRead > 0) {
					byte[] output = c.update(input, 0, bytesRead);				// chiffré les bloc d'octet 
					if (output != null) {
							baos.write(output);																// Ecrir le résultat de chiffremment sur un buffer
					}
					bytesRead = is.read(input, 0, 256);
			}
			
			byte[] output = c.doFinal();															// Chiffré le dernier bloc
			if (output != null) {
					baos.write(output);																		// Ecrir le dernier bloc
			}
			
			baos.writeTo(os);																					// mettre les blocs chiffré dans un fichier de sortie

			is.close();																								// Fermer le fichier clair
			os.close();																								// Fermer le fichier chiffré
	}
}