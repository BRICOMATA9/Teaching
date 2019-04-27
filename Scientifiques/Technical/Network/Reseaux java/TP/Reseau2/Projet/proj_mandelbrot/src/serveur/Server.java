package serveur;

import static serveur.HttpUtilities.NOT_FOUND_BODY;
import static serveur.HttpUtilities.extractFileName;
import static serveur.HttpUtilities.makeResponseHead;
import static serveur.HttpUtilities.sendBytes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.StringTokenizer;

import clients.FractalRequest;

public class Server {
    public static int       CLIENT_ID;
    public static final int BUFFER_SIZE = 4096;
    ServerSocketChannel     webServer;
    Selector                webSelector;
    ByteBuffer              buffer;

    public Server( int webport ) {
        try {
            webServer = ServerSocketChannel.open();
            webServer.bind( new InetSocketAddress( webport ) );
            webSelector = Selector.open();
            webServer.configureBlocking( false );
            webServer.register( webSelector, SelectionKey.OP_ACCEPT );
            buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
            CLIENT_ID = 0;
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

    public void readWebRequest( SelectionKey client ) {
        SocketChannel socket = (SocketChannel) client.channel();
        try {
            buffer.clear();
            if ( socket.read( buffer ) > 0 ) {
                buffer.flip();
                String request = Charset.forName( "UTF-8" ).decode( buffer ).toString();
                request = request.substring( 0, request.indexOf( "\n" ) );
                StringTokenizer tokens = new StringTokenizer( request );
								System.out.println(request);
                if ( tokens.countTokens() < 3 )
                    throw new Exception( "Mauvais format de réquête." );
                tokens.nextToken();
                socket.register( webSelector, SelectionKey.OP_WRITE, tokens.nextToken() );
            }
        } catch ( Exception e ) {
            System.err.println( "Echec de lecture de la requete: " + e.getMessage() );
        }
    }

    public void writeWebResponse( SelectionKey client ) {
        SocketChannel socket = (SocketChannel) client.channel();
        String request = (String) client.attachment();
        String fileName = extractFileName( request );
        System.out.println( fileName );
        File fileRequested = new File( fileName );

        if ( fileName.equals( "index.html" ) ) {
            FractalRequest fr = FractalRequest.request( request );
            System.out.println( fr );
        }

        try {
            String responseHead = makeResponseHead( fileRequested );
            buffer.clear();
            buffer.put( responseHead.getBytes() );
            if ( !fileRequested.exists() )
                buffer.put( NOT_FOUND_BODY.getBytes() );
            buffer.flip();
            while ( buffer.hasRemaining() ) {
                socket.write( buffer );
            }
            if ( fileRequested.exists() ) {
                BufferedInputStream bis = new BufferedInputStream( new FileInputStream( fileRequested ) );
                sendBytes( bis, socket, buffer );
                bis.close();
            }
            socket.finishConnect();
            socket.close();
        } catch ( Exception e ) {
            System.err.println( "Erreur dans l'envoi de la réponse: " + e.getMessage() );
        }
    }

    public void runWebServer() {
        Set<SelectionKey> clientsWeb;
        while ( true ) {
            try {
                webSelector.select();
                clientsWeb = webSelector.selectedKeys();
                for ( SelectionKey c : clientsWeb ) {
                    if ( c.isValid() ) {
                        if ( c.isAcceptable() ) {
                            acceptWebClient();
                        } else if ( c.isReadable() ) {
                            readWebRequest( c );
                        } else {
                            writeWebResponse( c );
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
