package serveur;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class Server {
    public static final String CRLF        = "\r\n";
    public static final int    BUFFER_SIZE = 1024;
    public static int          WEB_CLIENT_ID;
    ServerSocketChannel        webServer;
    Selector                   webSelector;
    ByteBuffer                 buffer;

    public Server( int webport ) {
        try {
            webServer = ServerSocketChannel.open();
            webServer.bind( new InetSocketAddress( webport ) );
            webSelector = Selector.open();
            webServer.configureBlocking( false );
            webServer.register( webSelector, SelectionKey.OP_ACCEPT );
            WEB_CLIENT_ID = 0;
            buffer = ByteBuffer.allocateDirect( BUFFER_SIZE );
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
            System.out.println( "La connexion au client a échoué: " + e.getMessage() );
        }
    }

    public void webClientResponse( SelectionKey client ) {
        SocketChannel socket = (SocketChannel) client.channel();
        try {
            buffer.clear();
            if ( socket.read( buffer ) > 0 ) {
                buffer.flip();
                String request = Charset.forName( "UTF-8" ).decode( buffer ).toString();
                request = getRequestURL( request );
                System.out.println( request );
                buffer.clear();
                response( request, socket );
                //socket.close();
            }
        } catch ( IOException e ) {
            System.out.println( "Echec de lecture de la requete: " + e.getMessage() );
        }
    }

    public void response( String request, SocketChannel socket ) throws IOException {
        System.out.println( "Reponse au client" );
        String status = CRLF + "HTTP/1.1 200 OK" + CRLF;
        String contenType = "Content-Type : text/html; Charset=ISO-8859-1" + CRLF;
        String body = "<html><head><title>OK</title></head><body><h3>OK</h3></body></html>";
        String contentLength = "Content-Length : " + body.length() + CRLF;
        buffer.put( status.getBytes() );
        buffer.put( contenType.getBytes() );
        buffer.put( contentLength.getBytes() );
        buffer.put( body.getBytes() );
        buffer.flip();
        while ( buffer.hasRemaining() ) {
            socket.write( buffer );
        }
        System.out.println("Fin de l'envoie du fichier");
    }

    public static String getRequestURL( String request ) {
        return request.substring( 0, request.indexOf( "\n" ) );
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
                        } else {
                            webClientResponse( c );
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
