package serveurs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Serveur web à l'écoute des requetes des clients web Il lance le serveur de
 * calcul quand il se lance
 */
public class ServerHttp {
    public static final int BUFFER_SIZE = 4096;
    ServerSocketChannel     webServer;
    Selector                webSelector;
    ComputingServer         computer;

    public ServerHttp( int webport, int calculPort ) {
        try {
            webServer = ServerSocketChannel.open();
            webServer.bind( new InetSocketAddress( webport ) );
            webSelector = Selector.open();
            webServer.configureBlocking( false );
            webServer.register( webSelector, SelectionKey.OP_ACCEPT );
            computer = new ComputingServer( calculPort );
            System.out.println( "Serveur web à l'écoute sur le port " + webport );
        } catch ( IOException e ) {
            System.out.println( "Echec de lancement du server: " + e.getMessage() );
        }
    }

    public void acceptWebClient() {
        try {
            SocketChannel webConnection = webServer.accept();
            System.out.println( "Client accepté " + webConnection );
            webConnection.configureBlocking( false );
            webConnection.register( webSelector, SelectionKey.OP_READ );
        } catch ( IOException e ) {
            System.err.println( "La connexion au client a échoué: " + e.getMessage() );
        }
    }

    public void runWebServer() {
        Set<SelectionKey> clientsWeb;
				// on lance le serveur de calcule
        computer.start();
        while ( true ) {
            try {
                webSelector.select();
                clientsWeb = webSelector.selectedKeys();
                for ( SelectionKey c : clientsWeb ) {
                    if ( c.isValid() ) {
                        if ( c.isAcceptable() ) {
                            acceptWebClient();
                        } else if ( c.isReadable() ) {
                            SocketChannel sc = (SocketChannel) c.channel();
                            c.cancel();
                            Thread requestManager = new Thread( new HttpRequestManager( sc, computer ) );
														// on lance le thread qui s'occupe de la requete
                            requestManager.start();
                        }
                    }
                }
                clientsWeb.clear();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
