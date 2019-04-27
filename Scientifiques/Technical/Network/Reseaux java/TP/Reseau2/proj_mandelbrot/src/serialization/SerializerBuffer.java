package serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerializerBuffer {
    protected Map<Integer, Integer>     objMap   = new HashMap<>();
    protected ArrayList<MySerializable> objArray = new ArrayList<>();

    protected ByteBuffer                buffer;

    public SerializerBuffer( int size ) {
        this.buffer = ByteBuffer.allocate( size );
    }

    public void writeInt( int i ) {
        this.buffer.putInt( i );
    }

    public void writeFloat( float f ) {
        this.buffer.putFloat( f );
    }

    public void writeDouble( double d ) {
        this.buffer.putDouble( d );
    }

    public int readInt() {
        return this.buffer.getInt();
    }

    public float readFloat() {
        return this.buffer.getFloat();
    }

    public double readDouble() {
        return this.buffer.getDouble();
    }

    public void writeMySerializable( MySerializable ms ) {

        if ( ms == null ) {
            this.buffer.putInt( 0 );
        } else {

            int id = System.identityHashCode( ms );
            if ( !objMap.containsKey( id ) ) {
                this.buffer.putInt( 1 );
                ms.serialize( this );
                objArray.add( ms );
                objMap.put( id, objArray.size() - 1 );

            } else {
                // System.out.println( "L'objet a deja ete serialise" );
                this.buffer.putInt( 2 );
                this.buffer.putInt( objMap.get( id ) );
            }
        }

    }

    /**
     * @return the buffer
     */
    public ByteBuffer getBuffer() {
        return buffer;
    }

    /**
     * @param buffer
     *            the buffer to set
     */
    public void setBuffer( ByteBuffer buffer ) {
        this.buffer = buffer;
    }

    public <T extends MySerializable> T readMySerializable( Creator<T> creator ) {
        T t = null;
        int index = this.buffer.getInt();
        if ( index > 0 ) {

            if ( index == 1 ) {
                t = creator.init();
                t.deserialize( this );
            } else {
                // System.out.println( "L'objet existe dans le array!" );
                int id = this.buffer.getInt();
                t = (T) objArray.get( id );
            }
        }
        return t;
    }

}
