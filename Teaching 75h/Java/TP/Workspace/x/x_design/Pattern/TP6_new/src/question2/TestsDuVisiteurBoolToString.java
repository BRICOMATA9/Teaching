package question2;

import question1.*;

public class TestsDuVisiteurBoolToString extends junit.framework.TestCase {

    protected Contexte m;
    protected VisiteurExpressionBooleenne<String> vbs;

    public void setUp(){
        m = new Memoire();
        vbs = new VisiteurBoolToString(new VisiteurInfixe(m));
    }

    public void testVisiteurBoolString(){
        assertEquals("vrai", new Vrai().accepter(vbs));
        assertEquals("faux", new Faux().accepter(vbs));
        assertEquals("(5 > 8)", new Sup(new Constante(5),new Constante(8)).accepter(vbs));
        assertEquals( "((5 + 3) = 8)", new Egal(new Addition(new Constante(5),new Constante(3)),new Constante(8)).accepter(vbs));
        assertEquals( "(i < j)", new Inf(new Variable(m,"i"),new Variable(m,"j")).accepter(vbs));
        assertEquals( "(i < (j + 1))", new Inf(new Variable(m,"i"),new Addition(new Variable(m,"j"),new Constante(1))).accepter(vbs));
        assertEquals( "((i > j) ou (i < j))", new Ou(new Sup(new Variable(m,"i"),new Variable(m,"j")), new Inf(new Variable(m,"i"),new Variable(m,"j"))).accepter(vbs));
        assertEquals( "((i > j) et (i < j))", new Et(new Sup(new Variable(m,"i"),new Variable(m,"j")), new Inf(new Variable(m,"i"),new Variable(m,"j"))).accepter(vbs));
        assertEquals( "((vrai ou vrai) et (vrai et vrai))", new Et(new Ou(new Vrai(),new Vrai()), new Et(new Vrai(),new Vrai())).accepter(vbs));
    }
    
}
