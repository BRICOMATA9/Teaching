package clients;

import static serveur.HttpUtilities.extractParameters;

import java.util.Map;

import serveur.Point;

/**
 * Cette classe constitue la requete que le serveur web transfere au serveur de
 * calcul
 * 
 * @author kouba
 *
 */
public class FractalRequest {
    private int   iteration;// represente le nombre d'iteration
    private Point infGauche;// le point inferieur gauche
    private Point supDroit; // le point superieur droit
    private int   idClient; // id du client ayant envoyé la requete
                            // Cet attribut est important pour la reconstitution

    public FractalRequest() {

    }

    public FractalRequest( Point infGauche, Point supDroit, int iteration, int idClient ) {
        this.infGauche = infGauche;
        this.supDroit = supDroit;
        this.iteration = iteration;
        this.idClient = 0;
    }

    /**
     * @return the infGauche
     */
    public Point getInfGauche() {
        return infGauche;
    }

    /**
     * @param infGauche
     *            the infGauche to set
     */
    public void setInfGauche( Point infGauche ) {
        this.infGauche = infGauche;
    }

    /**
     * @return the supDroit
     */
    public Point getSupDroit() {
        return supDroit;
    }

    /**
     * @param supDroit
     *            the supDroit to set
     */
    public void setSupDroit( Point supDroit ) {
        this.supDroit = supDroit;
    }

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient
     *            the idClient to set
     */
    public void setIdClient( int idClient ) {
        this.idClient = idClient;
    }

    /**
     * @return the iteration
     */
    public int getIteration() {
        return iteration;
    }

    /**
     * @param iteration
     *            the iteration to set
     */
    public void setIteration( int iteration ) {
        this.iteration = iteration;
    }

    /**
     * Methode static pour la generation de la requete de fractal à partir des
     * parametres d'une requete GET
     * 
     * @param url:
     *            l'url de la requete get
     * @return : objet de type fractalRequest
     */
    public static FractalRequest request( String url ) {
        Map<String, String> params = extractParameters( url );
        if ( params == null )
            return null;
        double Xmin = Double.parseDouble( params.get( "Xmin" ) );
        double Ymin = Double.parseDouble( params.get( "Ymin" ) );
        double Xmax = Double.parseDouble( params.get( "Xmax" ) );
        double Ymax = Double.parseDouble( params.get( "Ymax" ) );
        int iteration = Integer.parseInt( params.get( "Iteration" ) );
        Point infGauche = new Point( Xmin, Ymin );
        Point supDroit = new Point( Xmax, Ymax );
        return new FractalRequest( infGauche, supDroit, iteration, 0 );
    }

    @Override
    public String toString() {
        return "Requete du client " + idClient + " avec les coordonnées suivantes :" + infGauche.toString() + " et "
                + supDroit.toString() + " et " + iteration + " itérations";
    }

}
