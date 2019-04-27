import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main( String[] args ) {
        int port = 8080;
        try {
            ServerSocket incomingSocket = new ServerSocket( port );
            while ( true ) {
                Socket socket = incomingSocket.accept();
                HttpRequest request = new HttpRequest( socket );
                Thread thread = new Thread( request );
                thread.start();
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

}
