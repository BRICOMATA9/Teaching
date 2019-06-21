package IO;
/**
 * Caeshar Shift.
 * shift all letters one place to the right
 */

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlameInputStream extends FilterInputStream
{
 private InputStream is;	
	
 public FlameInputStream(InputStream is) {
  super(is);
  this.is=is;
 }

 public int read() throws IOException {
  int c = super.read();
  return (c == -1 ? -1 : Character.toUpperCase((char)c));
 }
}
