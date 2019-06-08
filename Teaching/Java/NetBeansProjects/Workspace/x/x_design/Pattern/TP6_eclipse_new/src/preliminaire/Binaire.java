package preliminaire;

public abstract class Binaire extends Expression {

	protected Expression op1;
	protected Expression op2;

	public Binaire(Expression op1, Expression op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
}