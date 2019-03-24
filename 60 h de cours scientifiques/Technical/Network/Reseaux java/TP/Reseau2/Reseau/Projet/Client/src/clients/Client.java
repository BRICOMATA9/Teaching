package clients;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * 
 * Cette classe represente le client de calcul
 *
 */
public class Client extends Thread {
    public static final String COMPUTER_SERVER_ADDR = "localhost";
    public static final int    COMPUTER_SERVER_PORT = 9090;
    private SocketChannel      computer;
    public boolean             connected;

    public Client( String address, int port ) throws Exception {
        InetSocketAddress isa = new InetSocketAddress( address, port );
        if ( isa.isUnresolved() )
            throw new Exception( "Serveur inconnu!" );
        computer = SocketChannel.open();
        computer.configureBlocking( true );
        computer.connect( isa );
        connected = true;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void disconnect() {
        this.connected = false;
    }

    @Override
    public void run() {
        System.out.println( "client lancé!" );
        ComputeFragment computeFragment = new ComputeFragment( computer, this );
        computeFragment.start();
    }

    /**
     * On passe en parametre à la methode main le nombre de clients qu'on
     * souhaite lancé. Par défaut cette valeur est de 5
     * 
     * @param args:
     */
    public static void main( String[] args ) {
        int nbClients,port;
				String adresse;
        try {
						adresse = args[0];
						port = Integer.parseInt( args[1] );
            nbClients = Integer.parseInt( args[2] );
        } catch ( Exception e ) {
						adresse = COMPUTER_SERVER_ADDR;
						port = COMPUTER_SERVER_PORT;
            nbClients = 1;
        }
        try {
            for ( int i = 0; i < nbClients; i++ ) {
                new Client( adresse , port ).start();
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
