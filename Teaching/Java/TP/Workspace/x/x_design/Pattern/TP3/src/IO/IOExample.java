package IO;
/**
 * This program example illustrates how the java.io package
 * uses the decorator package.
 */

import java.io.*;

public class IOExample
{
	public static void main(String[] args) throws java.io.IOException
	{
		int numberOfBytes = 0;

		// We decorate a FileInputStream with a BufferedInputStream
		InputStream isr = new BufferedInputStream(new FileInputStream("./ice-cream.jpg"));

		while ( (isr.read()) >= 0)
			++numberOfBytes;

		System.out.println("The number of bytes is " + numberOfBytes);
	}
}
