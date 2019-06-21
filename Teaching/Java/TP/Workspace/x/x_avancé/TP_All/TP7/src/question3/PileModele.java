package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;
import java.util.Observable;

public class PileModele<T> extends Observable implements PileI<T> {

    private PileI<T> pile;

    /* � compl�ter */

    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }

    public void empiler(T o) throws PilePleineException {
        try{
            this.pile.empiler(o);
        }catch(Exception e){
        
        }finally{
            setChanged();
            notifyObservers(this);
        }
    }

    public T depiler() throws PileVideException {
        return null;
    }

    public T sommet() throws PileVideException {
        return null;
    }

    public int taille() {
        return pile.taille();
    }

    public int capacite() {
        return pile.capacite();
    }

    public boolean estVide() {
        return pile.estVide();
    }

    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }
}
