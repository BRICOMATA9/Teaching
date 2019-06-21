package question1;

public class Variable extends Expression {

	private String nom;

	public Variable(Contexte c, String nom, Integer valeur) {
		this.nom = nom;
		c.ecrire(nom, valeur);
	}

	public Variable(Contexte c, String nom) {
		this(c, nom, 0);
	}

	public String nom() {
		return nom;
	}

	public <T> T accepter(VisiteurExpression<T> v) {
		return v.visite(this);
	}
	
}
