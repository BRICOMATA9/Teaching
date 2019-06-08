package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

public class PileModele<T> /* extends à compléter */implements PileI<T> {

    private PileI<T> pile;

    /* à compléter */

    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }

    public void empiler(T o) throws PilePleineException {
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

/**
 * notez qu'un message d'alerte subsiste à la compilation (unsafe ...) dû à
 * l'emploi de notifyObservers, incontournable et sans conséquence ici
 */
