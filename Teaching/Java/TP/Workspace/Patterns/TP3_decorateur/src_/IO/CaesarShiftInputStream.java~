/**
 * Caeshar Shift.
 * shift all letters one place to the right
 */

import java.io.*;

public class CaesarShiftInputStream extends FilterInputStream
{
 public CaesarShiftInputStream(InputStream is) {
  super(is);
 }

 public int read() throws IOException {
  int c = super.read();
  if (c >= 0)
   c++;

  return c;
 }
}
