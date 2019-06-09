package question3;

import question1.*;
import question2.*;

public class TestsAVerifier extends junit.framework.TestCase{


  private static int fact(int n){
    if(n==0) return 1;
    else return n*fact(n-1);
  }
  
	public void testFactoriel(){
	  Contexte m = new Memoire();
	  Variable x = new Variable(m,"x",5);
	  Variable fact = new Variable(m,"fact",1);
    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
    
    VisiteurExpression<String> ves = new VisiteurInfixe(m);
    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);
	  
  	Instruction i = 
  	  new TantQue(
        new Sup(x,new Constante(1)),
        new Sequence(
          new Affectation(fact,new Multiplication(fact,x)),
          new Affectation(x,new Soustraction(x,new Constante(1))))
        );
 	  
 	  i.accepter(vi);
 	  assertTrue((String)i.accepter(vs) + " ne donne pas le resultat attendu ...", m.lire("fact")== fact(5));
	}     
	
	private static int somme(int n){
	  int s=0; int i=0;
	  while(i<n){
	    i=i+1;
	    s=s+i;
	   }
	   return s;
	 }

	public void testSomme(){
	  Contexte m = new Memoire();
	  Variable n = new Variable(m,"n",100);
	  Variable s = new Variable(m,"s",0);
	  Variable i = new Variable(m,"i",0);
    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
    
    VisiteurExpression<String> ves = new VisiteurInfixe(m);
    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);
	
  	Instruction inst = 
  	  new TantQue(
        new Inf(i,n),
        new Sequence(
          new Affectation(i,new Addition(i,new Constante(1))),
          new Affectation(s,new Addition(s,i)))
        );

 	  inst.accepter(vi);
 	  assertTrue((String)inst.accepter(vs) + " ne donne pas le resultat attendu ...", m.lire("s")==somme(100));
 	}
 	  
 	
 	private static int mult(int a, int b){
 	  int z = 0 ;
 	  while (b > 0){
     if ((b -(b / 2)*2) == 1){
       z = z + a  ; b = b-1;
      }else{
       a = 2 * a ; b = b / 2;
      }
    }
    return z;
 	}

	public void testMult(){

	  Contexte m = new Memoire();
	  Variable a = new Variable(m,"a",7);
	  Variable b = new Variable(m,"b",85);
	  Variable z = new Variable(m,"z",0);
	  
    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
    
    VisiteurExpression<String> ves = new VisiteurInfixe(m);
    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

    
	  Instruction i = 
  	  new TantQue(
        new Sup(b,new Constante(0)),
        new Selection(
          new Egal(
            new Soustraction(b,new Multiplication(new Division(b,new Constante(2)),new Constante(2))),new Constante(1)),
          new Sequence(
            new Affectation(z,new Addition(z,a)),
            new Affectation(b,new Soustraction(b,new Constante(1))) 
          ),
          new Sequence(
            new Affectation(a,new Multiplication(a,new Constante(2))),
            new Affectation(b,new Division(b,new Constante(2)))
          )
        )
      );
     
 	  i.accepter(vi);
 	  assertTrue((String)i.accepter(vs) + " ne donne pas le resultat attendu ...",m.lire("z")==mult(7,85));
 	}
}
