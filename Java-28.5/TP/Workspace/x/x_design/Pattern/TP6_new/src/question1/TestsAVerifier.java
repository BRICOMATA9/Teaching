package question1;


public class TestsAVerifier extends junit.framework.TestCase{
	private Memoire m;
	private Variable i,j;
	private VisiteurExpression<Integer> ve;
	private VisiteurExpression<String>  vp,vi;
	
	
	public void setUp(){
	  m  = new Memoire();
	  i  = new Variable(m,"i",3);
	  j = new Variable(m,"j",5);
	  ve = new VisiteurEvaluation( m);
	  vi = new VisiteurInfixe( m);
	  vp = new VisiteurPostfixe( m);
	  assertNotNull(i);assertNotNull(j);
	  assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
	}
	 
	public void testUnConstante(){
	 	assertEquals("lecture memoire ?", 3, m.lire("i").intValue());
 	  assertEquals("lecture memoire ?", 5, m.lire("j").intValue());

		Expression expr = new Constante(3);
    assertEquals(" une Constante : 3 ?", 3, expr.accepter(ve).intValue());
	}
	
	public void testUneAddition1(){
		Expression expr = new Addition(new Constante(3), new Constante(2));
	  assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
	 }
	 
	 
	 // autres tests
	 
	 public void testVisiteurInfixe(){
	   Expression expr = new Addition(new Constante(3), new Constante(2));
	   assertEquals("(3 + 2) est attendu ","(3 + 2)",expr.accepter(vi));
	   expr = new Addition(expr, new Constante(2));
	   assertEquals("((3 + 2) + 2) est attendu ", "((3 + 2) + 2)", expr.accepter(vi));
	   assertEquals("{i=3, j=5}",m.toString());
	   expr = new Soustraction(expr, expr);
	   //System.out.println(expr.accepter(vi));
	   assertEquals("(((3 + 2) + 2) - ((3 + 2) + 2))", expr.accepter(vi));
	 }
	
	 public void testVisiteurPostfixe(){
	   Expression expr = new Addition(new Constante(3), new Constante(2));
	   assertEquals("(3,2)+",expr.accepter(vp));
	   expr = new Addition(expr, new Constante(2));
	   assertEquals("((3,2)+,2)+",expr.accepter(vp));
	   assertEquals("{i=3, j=5}", m.toString());
	   expr = new Soustraction(expr, expr);
	   assertEquals("(((3,2)+,2)+,((3,2)+,2)+)-", expr.accepter(vp));
	 }
}
