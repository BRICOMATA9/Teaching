package question3;

public class Sequence extends Instruction {

	private Instruction i1;
	private Instruction i2;

	public Sequence(Instruction i1, Instruction i2) {	    
		this.i1 = i1;
		this.i2 = i2;
	}

	public <T> T accepter(VisiteurInstruction<T> vi) {
		return vi.visite(this);
	}

	public Instruction i1() {
		return i1;
	}

	public Instruction i2() {
		return i2;
	}

}
