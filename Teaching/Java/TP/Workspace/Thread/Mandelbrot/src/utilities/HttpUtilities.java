package utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
    public static final String         LINE_TO_REPLACE  = "<img id=\"img\" src=\"mandelbrotset.png?Xmin=-2&Ymin=-1&Xmax=1&Ymax=1&Iteration=50\"";
    public static final String         NOT_FOUND_STATUS = "HTTP/1.1 404 NOT FOUND\n";
    public static final String         OK_STATUS        = "HTTP/1.1 200 OK\n";
    public static final String         DATE_LINE        = "Date: Thu, 03 March 2016 00:45:12GMT\n";
    public static final String         SERVER_NAME      = "Server: ServerMandelBrot/1.0\n";
    public static final String         NOT_FOUND_BODY   = "<!DOCTYPE html><html><head><title>NOT FOUND</title></head><body><h3>FILE NOT FOUND</h3></body></html>";
    public static BufferedReader       br;
    private static BufferedInputStream bis;

    public static String extractFileName( String url ) {
        if ( url.equals( "/" ) || url.indexOf( "?" ) == 1 ) {
            return "index.html";
        } else if ( url.indexOf( "?" ) == -1 ) {
            return url.substring( 1, url.length() );
        } else {
            return url.substring( 1, url.indexOf( "?" ) );
        }
    }

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

    public static String contentType( String fileName ) {
        if ( fileName.endsWith( ".htm" ) || fileName.endsWith( ".html" ) )
            return "text/html";
        if ( fileName.endsWith( ".jpg" ) || fileName.endsWith( ".jpeg" ) )
            return "image/jpeg";
        if ( fileName.endsWith( ".gif" ) )
            return "image/gif";
        return "application/octet-stream";
    }

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
        header += "Connection: Keep-alive\n\n";
        return header;
    }

    public static void sendBytes( SocketChannel socket, File file, ByteBuffer buffer )
            throws IOException {
        bis = new BufferedInputStream( new FileInputStream( file ) );
        byte[] buff;
        while ( bis.available() > 0 ) {
            buffer.clear();
            if ( bis.available() > 4096 )
                buff = new byte[4096];
            else
                buff = new byte[bis.available()];
            bis.read( buff );
            buffer.put( buff );
            buffer.flip();
            socket.write( buffer );
        }
        bis.close();
    }

    public static String readFile( File file ) throws Exception {
        String str = "";
        br = new BufferedReader( new FileReader( file ) );
        String s;
        while ( ( s = br.readLine() ) != null ) {
            str += s + "\n";
        }
        br.close();
        return str;
    }

    public static String readFile( File file, String request ) throws Exception {
        String str = "";
        String imgLink = "<img id=\"img\" src=\"mandelbrotset.png?Xmin=-2&Ymin=-1&Xmax=1&Ymax=1&Iteration=50\"";
        br = new BufferedReader( new FileReader( file ) );
        String s;
        // Map<String, String> param = extractParameters( request );
        while ( ( s = br.readLine() ) != null ) {
            if ( s.equals( imgLink ) ) {
                s = "<img id=\"img\" src=\"mandelbrotset.png?"
                        + request.substring( request.indexOf( "?" ) + 1, request.lastIndexOf( "&" ) )
                        + "\" width=\"600\" height=\"400\" style=\"border: 1px solid #000;\">\n</img>";
                br.readLine();
                br.readLine();
                System.out.println( s );
            }
            str += s + "\n";
        }
        br.close();
        return str;
    }

    public static void sendTextFile( SocketChannel socket, File file, String request )
            throws Exception {
        String fileString = "";
        if ( file.getName().equals( "index.html" ) && hasParameters( request ) ) {
            fileString = readFile( file, request );
        } else {
            fileString = readFile( file );
        }
        ByteBuffer buffer = ByteBuffer.wrap( fileString.getBytes() );
        while ( buffer.hasRemaining() ) {
            socket.write( buffer );
        }
    }

    public static boolean hasParameters( String url ) {
        return url.indexOf( "?" ) > 0;
    }
}
