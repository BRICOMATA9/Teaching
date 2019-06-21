package IO;
/**
 * A more interesting use of IO decorators.
 */
import java.io.*;

public class IO
{
 public static void main(String[] args) throws IOException {
  InputStream is = new FlameInputStream(new BufferedInputStream(new FileInputStream("file.txt")));
  int c;

  while ( (c = is.read()) >= 0)
   System.out.print((char)c);
 }
}
