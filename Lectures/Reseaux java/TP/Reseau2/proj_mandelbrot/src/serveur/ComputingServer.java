package serveur;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import clients.FractalRequest;

public class ComputingServer implements Runnable {
    public static final int     BUFFER_SIZE = 1024;
    // public static ConcurrentLinkedQueue<FractalRequest> fractalRequests;
    private ServerSocketChannel server;
    private Selector            selector;
    private ByteBuffer          buffer;

    public ComputingServer( int port ) {
        try {
            server = ServerSocketChannel.open();
            server.bind( new InetSocketAddress( port ) );
            server.configureBlocking( false );
            selector = Selector.open();
            server.register( selector, SelectionKey.OP_ACCEPT );
            buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
            // fractalRequests = new ConcurrentLinkedQueue<>();
            System.out.println( "Serveur de calcul à l'écoute sur le port " + port );
        } catch ( IOException e ) {
            System.err.println( "Echec de lancement du serveur de calcul: " + e.getMessage() );
        }
    }

    public void acceptComputer() {
        try {
            SocketChannel socket = server.accept();
            socket.configureBlocking( false );
            socket.register( selector, SelectionKey.OP_WRITE );
            System.out.println( "Un client de calcul s'est connecté!" );
        } catch ( IOException e ) {
            System.err.println( "Echec de connexion au client de calcul: " + e.getMessage() );
        }
    }

    public void sendData( SelectionKey k ) {
        SocketChannel channel = (SocketChannel) k.channel();
        System.out.println( k.toString() );
        try {
            channel.write( buffer );
            buffer.rewind();
        } catch ( IOException e ) {
            System.err.println( "Erreur dans l'envoi des données:" + e.getMessage() );
        }
    }

    public void readData( SelectionKey k ) {
        System.out.println( "Je recoit ca part du travail" );
    }

    public void run() {
        Set<SelectionKey> keys;

        while ( true ) {
            try {

                selector.select();
                keys = selector.selectedKeys();
                for ( SelectionKey k : keys ) {
                    if ( k.isValid() ) {
                        if ( k.isAcceptable() ) {
                            acceptComputer();

                        }
                    }
                }
                keys.clear();
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

    public synchronized BufferedImage getFractal( FractalRequest requete ) throws Exception {
        System.out.println( requete.toString() );
        List<Point> pixelsNoir = new ArrayList<Point>();
        Set<SelectionKey> clients;
        int r = 0, w = 0;
        do {
            selector.select();
            clients = selector.selectedKeys();
            for ( SelectionKey k : clients ) {
                if ( k.isValid() && k.isReadable() ) {
                    SocketChannel sc = (SocketChannel) k.channel();
                    ByteBuffer b = ByteBuffer.allocate( 1000 );
                    sc.read( b );

                    r++;
                    System.out.println( r );
                } else if ( k.isValid() && k.isWritable() ) {
                    SocketChannel sc = (SocketChannel) k.channel();

                    sc.write( buffer );
                    w++;
                    System.out.println( w );

                } else {
                    acceptComputer();
                }

            }
            clients.clear();

        } while ( r < 2 || w < 2 );

        return null;
    }

}
