package question3;

import question1.Expression;
import question1.Variable;

public class Affectation extends Instruction {

	private Variable v;
	private Expression exp;

	public Affectation(Variable v, Expression exp) {
		this.v = v;
		this.exp = exp;
	}

	public <T> T accepter(VisiteurInstruction<T> vi) {
		return vi.visite(this);
	}

	public Expression exp() {
		return exp;
	}

	public Variable v() {
		return v;
	}

}