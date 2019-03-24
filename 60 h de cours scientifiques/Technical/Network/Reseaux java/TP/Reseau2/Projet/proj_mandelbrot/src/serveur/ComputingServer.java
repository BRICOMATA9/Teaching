package serveur;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

import clients.FractalRequest;

public class ComputingServer {
    public static final int           BUFFER_SIZE = 1024;
    public static Set<FractalRequest> requetes    = new HashSet<>();
    private ServerSocketChannel       server;
    private Selector                  selector;
    private ByteBuffer                buffer;

    public ComputingServer( int port ) {
        try {
            server = ServerSocketChannel.open();
            server.bind( new InetSocketAddress( port ) );
            server.configureBlocking( false );
            selector = Selector.open();
            server.register( selector, SelectionKey.OP_ACCEPT );
            buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
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

    public void runComputingServer() throws IOException {
        Set<SelectionKey> keys;
        while ( true ) {
            selector.select();
            keys = selector.selectedKeys();
            for ( SelectionKey k : keys ) {
                if ( k.isValid() ) {
                    if ( k.isAcceptable() ) {
                        acceptComputer();
                    } else if ( k.isWritable() ) {
                        // parcours de la liste des requetes de fractal et
                        // envoyé
                        // envoyé chaque reqquete et les dimension necessaire
                        // au client de calcul
                        sendData( k );
                    } else {
                        // Lecture des données du client web sur la requete
                        // dont la reponse du client de calcul envoie les
                        // resultats
                        // reconstituer la bonne image
                        // contacter le serveur web avec le bon nom de l'image
                        // corresponsdant à la requete du client
                        readData( k );
                    }
                }
                keys.remove( k );
            }
        }
    }
}
