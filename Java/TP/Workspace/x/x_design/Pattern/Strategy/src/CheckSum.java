/**
 * Usage:
 * java CheckSum [CRC32 | Adler32] <input file>
 **/

import java.io.*;
import java.util.zip.*;

public class CheckSum
{
 public static void main(String[] args) throws IOException {
  if (args.length != 2) {
   System.err.println("Usage: java CheckSum [CRC32 | Adler32] <input file>");
   System.exit(0);
  }
  
  // generate the checksum using either the CRC32 or Adler32 algorithm
  // the chosen algorithm is delegated using the strategy pattern.
  Checksum cs = null;

  if (args[0].equalsIgnoreCase("CRC32"))
   cs = new CRC32();
  else if (args[0].equalsIgnoreCase("Adler32"))
   cs = new Adler32();
  else 
   throw new IllegalArgumentException("Must be CRC32 or Adler32");
   
  CheckedInputStream inFile = null;

  try {
   // see another pattern at work here???
   inFile = new CheckedInputStream(new FileInputStream(args[1]),cs);
   int data;
   while ( (data = inFile.read()) != -1)
     ;

   System.out.println("The checksum of the input file is " + inFile.getChecksum().getValue());
  }
  catch (FileNotFoundException fnfe) {
   System.err.println("File " + args[0] + " not found.");
  }
  finally {
   if (inFile != null)
    inFile.close();
  }
 }
}
