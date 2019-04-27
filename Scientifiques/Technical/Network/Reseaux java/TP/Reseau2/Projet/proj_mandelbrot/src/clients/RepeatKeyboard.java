package clients;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class RepeatKeyboard implements Runnable {
    public static final int     BUFFER_SIZE = 1024;
    private SocketChannel       socket;
    private Client              client;
    private ByteBuffer          buffer;
    private ReadableByteChannel byteChannel;

    public RepeatKeyboard( SocketChannel socket, Client client ) {
        this.socket = socket;
        this.client = client;
        this.buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
        byteChannel = Channels.newChannel( System.in );
    }

    @Override
    public void run() {
        try {
            while ( client.isConnected() ) {
                buffer.clear();
                if ( byteChannel.read( buffer ) == -1 ) {
                    throw new IOException( "Connexion fermée!" );
                }
                buffer.flip();
                CharBuffer c = Charset.defaultCharset().decode( buffer );

                ByteBuffer buff = Charset.forName( "UTF-8" ).encode( c );
                while ( buff.hasRemaining() ) {
                    socket.write( buff );
                }
            }
        } catch ( Exception e ) {
            client.disconnect();
        }

    }

}
