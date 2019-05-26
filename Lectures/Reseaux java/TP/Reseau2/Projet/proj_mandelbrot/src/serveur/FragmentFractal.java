package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Represente le fragment d'image renvoyé par un client de calcul. idClient
 * represente ici l'id de client web ayant envoyé la requete idFragment
 * represente ici l'id du fragment cad celui obtenu dans Fragment
 * fractalElements: sont les pixels qui appartiennent à la fractal de mandelbrot
 * 
 * @author kouba
 *
 */
public class FragmentFractal {
    private int         idclient;
    private int         idFragment;
    private List<Point> fractalElements;

    public FragmentFractal( int idClient, int idFragment ) {
        this.idclient = idClient;
        this.idFragment = idFragment;
        fractalElements = new ArrayList<Point>();
    }

    /**
     * @return the idclient
     */
    public int getIdclient() {
        return idclient;
    }

    /**
     * @param idclient
     *            the idclient to set
     */
    public void setIdclient( int idclient ) {
        this.idclient = idclient;
    }

    /**
     * @return the idFragment
     */
    public int getIdFragment() {
        return idFragment;
    }

    /**
     * @param idFragment
     *            the idFragment to set
     */
    public void setIdFragment( int idFragment ) {
        this.idFragment = idFragment;
    }

    /**
     * @return the fractalElements
     */
    public List<Point> getFractalElements() {
        return fractalElements;
    }

    /**
     * @param fractalElements
     *            the fractalElements to set
     */
    public void setFractalElements( List<Point> fractalElements ) {
        this.fractalElements = fractalElements;
    }

    public void addPixel( Point px ) {
        this.fractalElements.add( px );
    }

    public void removePixel( Point px ) {
        this.fractalElements.remove( px );
    }
}
