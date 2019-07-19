package enigme;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Rien {
	
	private static InputStreamReader r;
	private static ByteArrayOutputStream baos;
	private static MessageDigest sha;
	private static OutputStreamWriter w;
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		
	r = new InputStreamReader(new FileInputStream(args[0]));
    baos = new ByteArrayOutputStream();
	while (r.ready()) baos.write(r.read());
	byte[] message1 = baos.toByteArray();
	r.close();
	
    sha = MessageDigest.getInstance("SHA");
    sha.update(message1);
    byte[] digest1 = sha.digest();
    
	w = new OutputStreamWriter(new FileOutputStream(args[1]));
	for(int i=0;i<digest1.length;i++) w.write(digest1[i]);
	w.close();    
	
	r = new InputStreamReader(new FileInputStream(args[0]));
    baos = new ByteArrayOutputStream();
	while (r.ready()) baos.write(r.read());
	byte[] message2 = baos.toByteArray();
	r.close();
	
    sha.reset();
    
    sha.update(message2);
    byte[] digest2 = sha.digest();
    
	OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(args[1]));
	for(int i=0;i<digest2.length;i++) w.write(digest2[i]);
	w.close();  
    
    if(MessageDigest.isEqual(digest1,digest2)) System.out.println("OK");

	}
}
