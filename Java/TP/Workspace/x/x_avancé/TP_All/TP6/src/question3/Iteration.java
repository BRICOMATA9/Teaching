package question3;

import question2.ExpressionBooleenne;

public abstract class Iteration extends Instruction {

    private ExpressionBooleenne cond;
    private Instruction i1;

    public Iteration(ExpressionBooleenne cond, Instruction i1) {
        this.cond = cond;
        this.i1 = i1;
    }

    public ExpressionBooleenne cond() {
        return cond;
    }

    public Instruction i1() {
        return i1;
    }

}