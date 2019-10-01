package question3;

import question1.*;
import question2.*;

public class TestsDesAssertionsAVerifier extends junit.framework.TestCase{

 
	public void testAssertionSucces(){
	  Contexte m = new Memoire();
	  Variable x = new Variable(m,"x",5);
    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
    
    VisiteurExpression<String> ves = new VisiteurInfixe(m);
    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);
	  
  	Instruction i = new Assertion(new Egal(x,new Constante(5)));
 	  try{
 	    i.accepter(vi);
 	  }catch(AssertionError ae){
 	    fail("attention, assert a leve une exception ???");
 	  }
 	}
  
	public void testAssertionError(){
	  Contexte m = new Memoire();
	  Variable x = new Variable(m,"x",5);
    VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
    VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
    VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);
    
    VisiteurExpression<String> ves = new VisiteurInfixe(m);
    VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
    VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);
	  
  	Instruction i = new Assertion(new Egal(x,new Constante(6)));
 	  try{
 	    i.accepter(vi);
 	    fail("attention, " + i.accepter(vs) + " est sans effet ???, installer loption \"-ea\" ligne 480 de bluej.defs soit bluej.vm.args=-ea ");
 	  }catch(Throwable e){
 	    assertTrue(e instanceof AssertionError);
 	  }
	}     
	

}
