package question1;

public class Soustraction extends Binaire {

    public Soustraction(Expression op1, Expression op2) {
        super(op1, op2);
    }

    public <T> T accepter(VisiteurExpression<T> v) {
        return v.visite(this);
    }

}