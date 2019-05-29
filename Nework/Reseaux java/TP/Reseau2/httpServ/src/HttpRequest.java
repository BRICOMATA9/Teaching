import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequest implements Runnable {
    public static final String CRLF = "\r\n";
    private Socket             socket;

    public HttpRequest( Socket socket ) {

        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            processRequest();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private void processRequest() throws IOException {

        InputStream inputStream = socket.getInputStream();
        DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
        BufferedReader br = new BufferedReader( new InputStreamReader( inputStream ) );
        String request = br.readLine();
        System.out.println();
        System.out.println( request );
        StringTokenizer tokens = new StringTokenizer( request );
        tokens.nextToken();
        String fileName = tokens.nextToken();
        fileName = "." + fileName;
        FileInputStream fis = null;
        boolean fileExist = true;
        try {
            fis = new FileInputStream( fileName );
        } catch ( Exception e ) {
            System.out.println( "N'existe pas!" );
            fileExist = false;
        }

        String statusLine = null;
        String contentTypeLine = null;
        String entityBody = null;

        if ( fileExist ) {
            statusLine = "HTTP/1.0 200 OK " + CRLF;
            contentTypeLine = "Content-Type: " + contentType( fileName ) + CRLF;

        } else {
            statusLine = "HTTP/1.0 404 NotFound " + CRLF;
            contentTypeLine = "Content-Type: " + "text/html; Charset=ISO-8859-1" + CRLF;

            entityBody = "<html><head><title>Page not found</title></head><body><h3>NOT FOUND<h3></body></html>";
        }

        dos.writeBytes( CRLF );
        if ( fileExist ) {
            dos.writeBytes( statusLine );
            dos.writeBytes( contentTypeLine );
            sendBytes( fis, dos );
            fis.close();
        } else {
            dos.writeBytes( statusLine );
            dos.writeBytes( contentTypeLine );
            dos.writeBytes( entityBody );
        }

        System.out.println( "**********************************" );
        System.out.println( fileName );
        System.out.println( "**********************************" );
        String headLine = null;
        while ( ( headLine = br.readLine() ).length() != 0 ) {
            System.out.println( headLine );
        }
        dos.close();
        br.close();

    }

    public static void sendBytes( FileInputStream fis, DataOutputStream dos ) {
        byte[] buffer = new byte[1024];
        int bytes = 0;
        try {
            while ( ( bytes = fis.read( buffer ) ) != -1 ) {
                dos.write( buffer, 0, bytes );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
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
}
