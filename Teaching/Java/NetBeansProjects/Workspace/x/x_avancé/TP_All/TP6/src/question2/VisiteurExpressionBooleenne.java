package question2;

public abstract class VisiteurExpressionBooleenne<T> {

    public abstract T visite(Vrai v);
    public abstract T visite(Faux f);

    public abstract T visite(Non n);

    public abstract T visite(Ou ou);
    public abstract T visite(Et et);

    public abstract T visite(Sup sup);
    public abstract T visite(Egal eg);
    public abstract T visite(Inf inf);

}
