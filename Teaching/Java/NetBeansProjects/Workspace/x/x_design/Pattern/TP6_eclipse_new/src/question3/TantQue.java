package question3;

import question2.ExpressionBooleenne;

public class TantQue extends Iteration {

	public TantQue(ExpressionBooleenne cond, Instruction i1) {
		super(cond, i1);
	}

	public <T> T accepter(VisiteurInstruction<T> vi) {
		return vi.visite(this);
	}
	
}
