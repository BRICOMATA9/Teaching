package question2;

public abstract class OperationBooleenne extends ExpressionBooleenne {

	protected ExpressionBooleenne bop1;
	protected ExpressionBooleenne bop2;

	public OperationBooleenne(ExpressionBooleenne bop1, ExpressionBooleenne bop2) {
		this.bop1 = bop1;
		this.bop2 = bop2;
	}

	public ExpressionBooleenne bop1() {
		return bop1;
	}

	public ExpressionBooleenne bop2() {
		return bop2;
	}
	
}