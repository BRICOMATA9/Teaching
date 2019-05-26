package clients;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    private SocketChannel socket;
    private boolean       connected = false;

    public Client( String address, int port ) throws Exception {
        InetSocketAddress inetAddress = new InetSocketAddress( address, port );
        if ( inetAddress.isUnresolved() ) {
            throw new Exception( "Echec de resolution de l'adresse " + inetAddress );
        }
        socket = SocketChannel.open();
        socket.configureBlocking( true );
        socket.connect( inetAddress );
        this.connected = true;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void disconnect() {
        this.connected = false;
    }

    public void star() {
        Thread rn = new Thread( new RepeatNetwork( socket, this ) );
        Thread rk = new Thread( new RepeatKeyboard( socket, this ) );
        rn.start();
        rk.start();
        try {
            rn.join();
            rk.join();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

    }

    public static void main( String[] args ) {
        try {
            Client client = new Client( "127.0.0.1", 8080 );
            client.star();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
