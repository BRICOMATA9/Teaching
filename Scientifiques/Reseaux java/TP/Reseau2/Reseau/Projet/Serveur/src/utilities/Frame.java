package utilities;

public class Frame {
    private int largeur;
    private int hauteur;

    public Frame( int larg, int haut ) {
        this.largeur = larg;
        this.hauteur = haut;
    }

    /**
     * @return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @param largeur
     *            the largeur to set
     */
    public void setLargeur( int largeur ) {
        this.largeur = largeur;
    }

    /**
     * @return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @param hauteur
     *            the hauteur to set
     */
    public void setHauteur( int hauteur ) {
        this.hauteur = hauteur;
    }
}
