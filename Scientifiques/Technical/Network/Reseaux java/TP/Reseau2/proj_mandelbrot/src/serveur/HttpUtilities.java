package serveur;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe de methodes utilitaires pour les requetes/reponses http Classe
 * 
 * @author kouba
 */
public class HttpUtilities {

    public static final String NOT_FOUND_STATUS = "HTTP/1.1 404 NOT FOUND\n";
    public static final String OK_STATUS        = "HTTP/1.1 200 OK\n";
    public static final String DATE_LINE        = "Date: Thu, 03 March 2016 00:45:12GMT\n";
    public static final String SERVER_NAME      = "Server: ServerMandelBrot/1.0\n";
    public static final String NOT_FOUND_BODY   = "<!DOCTYPE html><html><head><title>NOT FOUND</title></head><body><h3>FILE NOT FOUND</h3></body></html>";

    /**
     * Methode static pour extraire le nom du fichier demandé dans l'url de la
     * requete http
     * 
     * @param url:
     *            url de la requete http
     * @return nom du fichier demandé
     */
    public static String extractFileName( String url ) {
        if ( url.equals( "/" ) || url.indexOf( "?" ) == 1 ) {
            return "index.html";
        } else if ( url.indexOf( "?" ) == -1 ) {
            return url.substring( 1, url.length() );
        } else {
            return url.substring( 1, url.indexOf( "?" ) );
        }
    }

    /**
     * Methode static pour extraire les parametres d'une requete GET
     * 
     * @param url:
     *            url de la requete
     * @return: map des parametres de la requete
     */
    public static Map<String, String> extractParameters( String url ) {
        if ( url.equals( "/" ) || url.indexOf( "?" ) == -1
                || url.substring( url.indexOf( "?" ) + 1, url.length() ).equals( "" ) )
            return null;
        else {
            Map<String, String> parameters = new HashMap<String, String>();
            url = url.substring( url.indexOf( "?" ) + 1, url.length() );
            String[] params = url.split( "&" );
            for ( String s : params ) {
                String name = s.split( "=" )[0].trim();
                String value = s.split( "=" )[1].trim();
                parameters.put( name, value );
            }
            return parameters;
        }
    }

    /**
     * Methode static pour generer l'attribut content-type pour l'entete de la
     * reponse http
     * 
     * @param fileName:
     *            nom du fichier demandé dans la requete http
     * @return: content-type pour la reponse http
     */
    public static String contentType( String fileName ) {
        if ( fileName.endsWith( ".htm" ) || fileName.endsWith( ".html" ) )
            return "text/html";
        if ( fileName.endsWith( ".jpg" ) || fileName.endsWith( ".jpeg" ) )
            return "image/jpeg";
        if ( fileName.endsWith( ".gif" ) )
            return "image/gif";
        return "application/octet-stream";
    }

    /**
     * Methode static pour generer l'entete d'une reponse http en fonction du
     * fichier demandé
     * 
     * @param file:
     *            fichier demandé
     * @return entete de la reponse http
     * 
     */
    public static String makeResponseHead( File file ) {
        String header = "";
        header += file.exists() ? OK_STATUS : NOT_FOUND_STATUS;
        header += DATE_LINE;
        header += SERVER_NAME;
        if ( !file.exists() ) {
            header += "Content-type: text/html\n";
            header += "Content-Length " + NOT_FOUND_BODY.length() + "\n";

        } else {
            header += "Content-type: " + contentType( file.getName() ) + "\n";
            header += "Content-Length: " + file.length() + "\n";
        }
        header += "Connection: keep-alive\n\n";
        return header;
    }

    /**
     * Methode static pour l'envoi du contenu d'un flux à une socket
     * 
     * @param bis:flux
     *            à envoyer à la socket
     * @param socket
     *            : socket à laquelle on envoie le flux.
     * @param buffer:
     *            buffer intermediaire pour le transfer
     * @throws IOException:
     *             Peut lever des exceptions d'I/O (IOException)
     */
    public static void sendBytes( BufferedInputStream bis, SocketChannel socket, ByteBuffer buffer )
            throws IOException {
        byte[] buff = new byte[1024];
        while ( bis.read( buff ) != -1 ) {
            buffer.clear();
            buffer.put( buff );
            buffer.flip();
            socket.write( buffer );
        }
    }
}
