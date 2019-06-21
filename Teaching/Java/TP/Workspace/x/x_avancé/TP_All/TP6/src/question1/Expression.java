package question1;

/**
 * Une expression arithmetique
 */
public abstract class Expression {

    public abstract <T> T accepter(VisiteurExpression<T> v);

}
