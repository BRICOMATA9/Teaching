package clients;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class RepeatNetwork implements Runnable {
    public static final int BUFFER_SIZE = 1024;
    private SocketChannel   socket;
    private ByteBuffer      buffer;
    private Client          client;

    public RepeatNetwork( SocketChannel socket, Client client ) {
        this.socket = socket;
        this.client = client;
        this.buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
    }

    @Override
    public void run() {
        try {
            while ( client.isConnected() ) {
                buffer.clear();
                if ( socket.read( buffer ) == -1 ) {
                    throw new IOException( "Connection fermée!" );
                }
                buffer.flip();
                String str = Charset.forName( "UTF-8" ).decode( buffer ).toString();
                System.out.println( str );
            }
        } catch ( Exception e ) {
            client.disconnect();
        }
    }
}
