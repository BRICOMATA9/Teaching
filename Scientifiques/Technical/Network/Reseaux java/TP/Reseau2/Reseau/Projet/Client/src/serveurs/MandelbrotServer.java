package serveurs;

/**
 * Classe de lancement de nos serveurs web et de calcul
 *
 */
public class MandelbrotServer {

    public static void main( String[] args ) throws Exception {
        ServerHttp s = new ServerHttp( 8080 );
        s.runWebServer();
    }

}
