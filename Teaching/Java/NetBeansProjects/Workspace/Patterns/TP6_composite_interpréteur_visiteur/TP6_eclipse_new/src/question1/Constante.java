package question1;

public class Constante extends Expression {

	private int i;

	public Constante(int i) {
		this.i = i;
	}

	public int valeur() {
		return i;
	}

	public <T> T accepter(VisiteurExpression<T> v) {
		return v.visite(this);
	}
	
}
