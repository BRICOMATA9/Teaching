import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class SerializerBuffer {

    public ByteBuffer buffer;

    public SerializerBuffer( int capacity ) {
        this.buffer = ByteBuffer.allocateDirect( capacity );
    }

    public void writeInt( int i ) {
        buffer.putInt( i );
    }

    public void writeFloat( float f ) {
        buffer.putFloat( f );
    }

    public int readInt() {
        return buffer.getInt();
    }

    public float readFloat() {
        return buffer.getFloat();
    }

    public void writeString( String s ) {
        Charset c = Charset.forName( "UTF-8" );
        ByteBuffer bb = c.encode( s );
        buffer.putInt( bb.remaining() );
        buffer.put( bb );
    }

    public String readString() {
        int length = buffer.getInt(); // get the string's length
        Charset c = Charset.forName( "UTF-8" );
        int limit = buffer.limit(); // get the buffer limit
        buffer.limit( buffer.position() + length ); // limit the buffer length
                                                    // to the string length
        String str = c.decode( buffer ).toString(); // read and decode the
                                                    // string
        buffer.limit( limit ); // reset the buffer limit to the initial limit
        return str; // return the string read
    }

}
