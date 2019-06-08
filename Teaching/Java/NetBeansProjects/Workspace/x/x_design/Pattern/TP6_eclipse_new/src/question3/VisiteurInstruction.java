package question3;

import question1.Contexte;

/* Classe abstraite des Visiteurs,
 * Une methode par noeud concret du composite
 */
public abstract class VisiteurInstruction<T> {

	public abstract T visite(Affectation aff);
	public abstract T visite(Sequence seq);
	public abstract T visite(Selection sel);

	public abstract T visite(TantQue tq);
	// ajouter la visite de linstruction Pour

	public abstract T visite(Afficher a);
	public abstract T visite(Assertion a);

	public abstract Contexte contexte();

}
