package question2;

import question1.Expression;

public abstract class Relation extends ExpressionBooleenne {

	protected Expression op1;
	protected Expression op2;

	public Relation(Expression op1, Expression op2) {
		this.op1 = op1;
		this.op2 = op2;
	}

	public Expression op1() {
		return op1;
	}

	public Expression op2() {
		return op2;
	}

}