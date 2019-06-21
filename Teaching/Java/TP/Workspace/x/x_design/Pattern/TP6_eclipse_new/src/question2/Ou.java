package question2;

public class Ou extends OperationBooleenne {

    public Ou(ExpressionBooleenne bop1, ExpressionBooleenne bop2) {
        super(bop1, bop2);
    }

    public <T> T accepter(VisiteurExpressionBooleenne<T> v) {
        return v.visite(this);
    }

}