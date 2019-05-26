package serveur;

public class Application {

    public static void main( String[] args ) {
        Server s = new Server( 8080 );
        s.runWebServer();

    }

}
