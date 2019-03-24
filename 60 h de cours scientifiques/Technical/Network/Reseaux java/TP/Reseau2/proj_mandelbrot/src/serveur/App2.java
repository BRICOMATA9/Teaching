package serveur;

public class App2 {

    public static void main( String[] args ) throws Exception {
        Server s = new Server( 8080 );
        s.runWebServer();

    }
}
