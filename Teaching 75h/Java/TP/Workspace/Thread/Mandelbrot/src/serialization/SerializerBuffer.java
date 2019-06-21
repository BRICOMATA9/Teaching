package serialization;

import java.nio.ByteBuffer;

public class SerializerBuffer {
    protected ByteBuffer buffer;

    public SerializerBuffer( int size ) {
        this.buffer = ByteBuffer.allocateDirect( size );
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
            this.buffer.putInt( 1 );
            ms.serialize( this );
        }
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer( ByteBuffer buffer ) {
        this.buffer = buffer;
    }

    public <T extends MySerializable> T readMySerializable( Creator<T> creator ) {
        T t = null;
        int index = this.buffer.getInt();
        if ( index == 1 ) {
            t = creator.init();
            t.deserialize( this );
        }
        return t;
    }
}
