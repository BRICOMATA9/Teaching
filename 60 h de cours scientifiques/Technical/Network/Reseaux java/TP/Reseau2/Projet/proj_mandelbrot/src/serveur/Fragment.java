package serveur;

/**
 * Represente le fragment à envoyé à un client de calcul L'idee c'est de diviser
 * la largeur de l'image par DIVISEUR_HORIZONTAL et la hauteur par ... x et y
 * represente et identifie de facon unique chaque bloque. On peut meme generer
 * l'id du fragment comme indiquer dans le constructeur
 * 
 * @author kouba
 *
 */
public class Fragment {
    public static final int DIVISEUR_HORIZONTAL = 6;
    public static final int DIVISEUR_VERTICAL   = 4;
    private int             x;
    private int             y;
    private int             id;

    public Fragment( int i, int j ) {
        this.x = i;
        this.y = j;
        id = x + y * DIVISEUR_HORIZONTAL;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY( int y ) {
        this.y = y;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId( int id ) {
        this.id = id;
    }

}
