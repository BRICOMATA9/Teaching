package question3;

import question1.*;
import question2.*;

public class ClasseJavaTest extends junit.framework.TestCase {

	public void testFactoriel() throws Exception {
		Contexte m = new Memoire();
		Variable x = new Variable(m, "x", 5);
		Variable fact = new Variable(m, "fact", 1);

		Instruction inst = new TantQue(new Sup(x, new Constante(1)),
				new Sequence(
						new Affectation(fact, new Multiplication(fact, x)),
						new Affectation(x,
								new Soustraction(x, new Constante(1)))));

		VisiteurExpression<String> ves = new VisiteurInfixe(m);
		VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToJava(ves);
		VisiteurInstruction<String> vs = new VisiteurInstToJava(ves, vbs, 4);

		ClasseJava cj = new ClasseJava("Fact", inst, vs);
		System.out.println(cj.sourceComplet());
		cj.enFichier(); // notez que votre source sera compile a la volee lors
						// des tests

		// ci dessous un exemple de ce qui pourrait etre genere voir le fichier
		// Fact.java

		//
		// /** NFP121/2006 question3, tp6
		// source Java genere par lintermediaire de votre visiteur
		// "VisiteurInstToJava"
		// */
		// public class Fact{
		//
		// public static void main(String[] args)throws Exception{
		// int fact=1;
		// int x=5;
		//
		// while(x > 1){
		// fact=(fact * x);
		// x=(x - 1);
		// }
		// }
		//
		// }
		//
	}
}
