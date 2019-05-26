package tp1;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Server {
    ServerSocketChannel channel;
    Selector            selector;

    public Server( int port ) {
        try {
            channel = ServerSocketChannel.open();
            channel.bind( new InetSocketAddress( port ) );
            selector = Selector.open();
            channel.configureBlocking( false );
            channel.register( selector, SelectionKey.OP_ACCEPT );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    public void accept() {

        SocketChannel sc;
        try {
            sc = channel.accept();
            sc.configureBlocking( false );
            sc.register( selector, SelectionKey.OP_READ );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    public void repeat( SelectionKey key ) {
        System.out.println( "Nouveau message" );

    }

    public void boucle() throws Exception {
        Set<SelectionKey> keys;
        while ( true ) {
            selector.select();
            keys = selector.selectedKeys();
            for ( SelectionKey sk : keys ) {
                if ( sk.isValid() ) {
                    if ( sk.isAcceptable() ) {
                        accept();

                    }
                    if ( sk.isReadable() ) {
                        repeat( sk );
                    }
                }
                keys.remove( sk );
            }
        }
    }

    public static void main( String[] args ) throws Exception {
        Server server = new Server( 8889 );
        server.boucle();
    }

}
