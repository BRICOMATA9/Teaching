package question3;

import question1.Expression;

public class Afficher extends Instruction {

	private Expression exp;

	public Afficher(Expression exp) {
		this.exp = exp;
	}

	public <T> T accepter(VisiteurInstruction<T> vi) {
		return vi.visite(this);
	}

	public Expression exp() {
		return exp;
	}
	
}