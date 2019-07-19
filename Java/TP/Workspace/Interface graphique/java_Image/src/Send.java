import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class Send {

	public static void main(String[] args) throws IOException {
		BufferedImage capture = new BufferedImage(0, 0, 0);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(capture, "jpg", baos);
		
		byte[] data = baos.toByteArray();
		
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeByte(0);
		dos.writeInt(data.length);
		dos.write(data);
		
		OutputStream outputStream = new DataOutputStream(out);
			
		outputStream.write(baos.toByteArray());
		outputStream.flush();
		
		DataInputStream dis = new DataInputStream(in);
		
		int dataSize = dis.readInt();
		byte[] data1 = new byte[dataSize];
		dis.readFully(data1);
		
		BufferedImage capturée = ImageIO.read(dis);
		
	}
}
