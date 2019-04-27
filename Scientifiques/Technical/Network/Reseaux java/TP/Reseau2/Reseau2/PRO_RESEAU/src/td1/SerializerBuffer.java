package td1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerializerBuffer {
    private Map<Integer, Integer>     objMap   = new HashMap<>();
    private ArrayList<MySerializable> objArray = new ArrayList<>();

    public ByteBuffer                 buffer;

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

    public void writeMySerializable( MySerializable ms ) {
        if ( ms == null ) {
            this.buffer.putInt( 0 );
        } else {

            int id = System.identityHashCode( ms );
            if ( !objMap.containsKey( id ) ) {
                this.buffer.putInt( 1 );
                ms.writeToBuff( this );
                objArray.add( ms );
                objMap.put( id, objArray.size() - 1 );

            } else {
                System.out.println( "L'objet a deja ete serialise" );
                this.buffer.putInt( 2 );
                this.buffer.putInt( objMap.get( id ) );
            }
        }

    }

    public <T extends MySerializable> T readMySerializable( Creator<T> creator ) {
        T t = null;
        int index = this.buffer.getInt();
        if ( index > 0 ) {

            if ( index == 1 ) {
                t = creator.init();
                t.readFromBuff( this );
            } else {
                System.out.println( "L'objet existe dans le array!" );
                int id = this.buffer.getInt();
                t = (T) objArray.get( id );
            }
        }
        return t;
    }

}
