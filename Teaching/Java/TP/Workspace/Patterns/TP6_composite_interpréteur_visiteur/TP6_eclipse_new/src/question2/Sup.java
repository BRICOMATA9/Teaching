package question2;

import question1.Expression;

public class Sup extends Relation {
	public Sup(Expression op1, Expression op2) {
		super(op1, op2);
	}

	public <T> T accepter(VisiteurExpressionBooleenne<T> v) {
		return v.visite(this);
	}
	
}