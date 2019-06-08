package preliminaire;

public class Variable extends Expression {

	private String nom;

	public Variable(Contexte c, String nom, Integer valeur) {
		this.nom = nom;
		c.ecrire(nom, valeur);
	}

	public Variable(Contexte c, String nom) {
		this(c, nom, 0);
	}

	public String toString() {
		return nom;
	}

	public int interprete(Contexte c) {
		return c.lire(this.nom);
	}
}
