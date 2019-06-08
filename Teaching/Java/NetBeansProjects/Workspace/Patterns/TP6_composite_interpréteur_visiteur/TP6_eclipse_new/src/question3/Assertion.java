package question3;

import question2.ExpressionBooleenne;

public class Assertion extends Instruction {

	private ExpressionBooleenne cond;
	private String message;

	public Assertion(ExpressionBooleenne cond) {
		this.cond = cond;
	}

	public <T> T accepter(VisiteurInstruction<T> vi) {
		return vi.visite(this);
	}

	public ExpressionBooleenne cond() {
		return cond;
	}

	public String message() {
		return message;
	}
	
}