package question2;

import question1.Expression;

public class Inf extends Relation {

    public Inf(Expression op1, Expression op2) {
        super(op1, op2);
    }

    public <T> T accepter(VisiteurExpressionBooleenne<T> v) {
        return v.visite(this);
    }
    
}