package question1;


public class TestsACompleter extends junit.framework.TestCase{
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
	
	
	public void testUneAddition(){
		  Expression expr = new Addition(new Constante(3), new Constante(2));
		  assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
	}
	
	public void testMultiplication(){
		  Expression expr = new Multiplication(new Constante(3), new Constante(2));
		  assertEquals(" 3*2 != 6 ?, curieux ",6,expr.accepter(ve).intValue());
	}

	public void testSoustraction(){
		  Expression expr = new Soustraction(new Constante(3), new Constante(2));
		  assertEquals(" 3-2 != 1 ?, curieux ",1,expr.accepter(ve).intValue());
	}
	
	public void testDivision(){
		  Expression expr = new Division(new Constante(4), new Constante(2));
		  
/*		  try{
			  new Division(i,new Constante(0)).accepter(ve);
			  fail("division par zero ? possible ");
		  }catch(ArithmeticException ae){}*/
		  
		  assertEquals(" 4/2 != 2 ?, curieux ",2,expr.accepter(ve).intValue());
	 }
	 
	 public void testVisiteurInfixe(){
	  // a completer
	  // a completer
	  // a completer
	 }
	
	 public void testVisiteurPostfixe(){
	  // a completer
	  // a completer
	  // a completer
	 }
	 
	 
	 	// a completer
	  // a completer
	  // a completer

}
