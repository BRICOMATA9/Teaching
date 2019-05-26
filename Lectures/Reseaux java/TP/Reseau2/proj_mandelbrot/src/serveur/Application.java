package serveur;

public class Application {

    public static void main( String[] args ) throws Exception {
        ComputingServer s = new ComputingServer( 9090 );
        s.run();

    }

}
