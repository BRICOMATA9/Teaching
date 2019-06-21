package question2;

public class Faux extends ExpressionBooleenne {

    public <T> T  accepter(VisiteurExpressionBooleenne<T> v) {
        return v.visite(this);
    }

}