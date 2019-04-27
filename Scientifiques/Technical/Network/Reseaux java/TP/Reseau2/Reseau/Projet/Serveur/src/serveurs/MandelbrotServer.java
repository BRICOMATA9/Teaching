package serveurs;

/**
 * Classe de lancement de nos serveurs web et de calcul
 *
 */
public class MandelbrotServer {

	public static void main(String[] args) {
	int web,compute;
		  try {
            web = Integer.parseInt( args[0] );
						compute = Integer.parseInt( args[1] );
        } catch ( Exception e ) {
            web = 8080;
						compute = 9090;
        }
        ServerHttp s = new ServerHttp( web, compute );
        s.runWebServer();
    }

}
