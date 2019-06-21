package question3;

import question2.ExpressionBooleenne;

public class Selection extends Instruction {

    protected ExpressionBooleenne cond;
    protected Instruction i1;
    protected Instruction i2;

    public Selection(ExpressionBooleenne cond, Instruction i1, Instruction i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }

    public Selection(ExpressionBooleenne cond, Instruction i1) {
        this(cond, i1, null);
    }

    public <T> T accepter(VisiteurInstruction<T> vi) {
        return vi.visite(this);
    }

    public ExpressionBooleenne cond() {
        return cond;
    }

    public Instruction i1() {
        return i1;
    }

    public Instruction i2() {
        return i2;
    }

}