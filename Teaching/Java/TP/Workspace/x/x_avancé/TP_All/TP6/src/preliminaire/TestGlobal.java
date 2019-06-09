package preliminaire;


public class TestGlobal extends junit.framework.TestCase{
	private Memoire m;
	private Variable x,x1;
	
	public void setUp(){
	  m  = new Memoire();
	  x  = new Variable(m,"x",3);
	  x1 = new Variable(m,"x1",5);
	}
	 
	public void test_UneConstante(){
		Expression expr = new Constante(3);
    assertEquals(expr.interprete(m),3);	
	}
	
	public void test_DeVariables(){
		Memoire m1 = new Memoire();
		Expression expr = new Variable(m1,"i");
		assertEquals(0,expr.interprete(m1));
		expr = new Variable(m1,"j",55);
		assertEquals(55,expr.interprete(m1));
	}
	
	public void test_UneAddition1(){
		Expression expr = new Addition(new Constante(3), new Constante(2));
		assertEquals(5,expr.interprete(m));	
	}
	
	public void test_UneAutreAddition2(){
	  // (x + 2) + x
		Expression expr = new Addition(new Addition(x, new Constante(2)),x);
		assertEquals(8,expr.interprete(m));	
	}
	
	
	public void test_Multiplication(){
	  assertEquals(new Multiplication(x,x1).interprete(m),15);	
	}
	
	public void test_Division(){
	  assertEquals(5,m.lire("x1").intValue());
	  assertEquals(3,m.lire("x").intValue());
	  assertEquals(new Division(new Multiplication(x,x1),x).interprete(m),5);
	  
	  try{
	    new Division(x1,new Constante(0)).interprete(m);
	    fail();
	   }catch(ArithmeticException ae){
	   }
	 }
	 

	public void testFactorielEtMoins(){
	  assertEquals(5,m.lire("x1").intValue());
	  assertEquals(-120, new Moins(new Factoriel(x1)).interprete(m));
	 }
	
	 
	 public void testToString(){
	   Expression expr = new Addition(new Constante(3), new Constante(2));
	   assertEquals("(3 + 2)",expr.toString());
	   expr = new Addition(expr, new Constante(2));
	   assertEquals("((3 + 2) + 2)",expr.toString());
	   expr = new Addition(expr, new Factoriel(x1));
	   assertEquals(m.toString(),"{x=3, x1=5}");
	   assertEquals("(((3 + 2) + 2) + x1!)",expr.toString());
	   expr = new Soustraction(expr, new Factoriel(x1));
	   assertEquals("((((3 + 2) + 2) + x1!) - x1!)",expr.toString());
	 }
}
