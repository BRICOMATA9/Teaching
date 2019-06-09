package preliminaire;

public class Factoriel extends Unaire {

	public Factoriel(Expression op) {
		super(op);
	}

	public String toString() {
		return op.toString() + "!";
	}

	public int interprete(Contexte c) {
		int n = op.interprete(c);
		if (n >= 0)
			return fact(n);
		else
			throw new ArithmeticException();
	}

	private static Integer fact(int n) {
		if (n == 0)
			return 1;
		else
			return n * (fact(n - 1));
	}
}
