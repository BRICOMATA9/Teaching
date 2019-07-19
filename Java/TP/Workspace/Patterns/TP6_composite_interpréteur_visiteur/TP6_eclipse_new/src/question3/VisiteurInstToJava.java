package question3;

import java.io.*;

import question1.*;
import question2.*;

/**
 * 
 */
public class VisiteurInstToJava extends VisiteurInstruction<String> {

	private final static int TAB = 2;
	private static final String lineSeparator = System.getProperties().getProperty("line.separator");

	private VisiteurExpression<String> vi;
	private VisiteurExpressionBooleenne<String> vb;

	private int tabulations;

	/**
	 * Creation dun visiteur dinstructions
	 * 
	 * @param vi
	 *            le visiteur dexpressions arithmetiques
	 * @param vb
	 *            le visiteur dexpression booleennes
	 * @param tabulations
	 *            tabulations initiales
	 */
	public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb, int tabulations) {
		this.vi = vi;
		this.vb = vb;
		this.tabulations = tabulations;
	}

	/**
	 * Creation d'un visiteur d'instructions
	 * 
	 * @param vi
	 *            le visiteur d'expressions arithmetiques
	 * @param vb
	 *            le visiteur d'expression booleennes
	 */
	public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb) {
		this(vi, vb, 0);
	}

	/**
	 * obtention du contexte, ici celui du visiteur d'expression arithmetiques
	 * 
	 * @return le contexte ici de vi(le visiteur d'expression)
	 */
	public Contexte contexte() {
		return this.vi.contexte();
	}

	/**
	 * Visite d'une instance de la classe Affectation.
	 * 
	 * 
	 * @param a
	 *            une affectation
	 * @return a := exp
	 */
	public String visite(Affectation a) {
		return a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi);
	}

	/**
	 * Visiste d'une sequence seq(I1,I2) <br>
	 * 
	 * @param seq
	 *            une sequence
	 * @return i1;i2
	 */
	public String visite(Sequence seq) {
		return seq.i1().accepter(this) + " ; " + seq.i2().accepter(this); // a completer
	}

	public String visite(Selection sel) {
		String str = "if" + sel.cond().accepter(this.vb) + " then " + sel.i1().accepter(this);
		if (sel.i2() != null) str = str + " else " + sel.i2().accepter(this);

		return str;
	}

	public String visite(TantQue tq) {
		return "while" + tq.cond().accepter(this.vb) + tq.i1().accepter(this);
	}

	public String visite(Pour pour) {
		return "for(" + pour.init().accepter(this) + ";" + pour.cond().accepter(this.vb) + ";"
				+ pour.inc().accepter(this) + ") " + pour.i1().accepter(this);
	}

	public String visite(Afficher a) {
		return "System.out.println(" + a.exp().accepter(this.vi) + ")";
	}

	public String visite(Assertion a) {
		return "assert(" + a.cond().accepter(this.vb) + ")";
	}

	private String tab(int n) {
		String str = new String();

		str = str + lineSeparator;
		for (int i = 0; i < this.tabulations + n; i++) {
			str = str + " ";
		}
		this.tabulations += n;
		return str;
	}

}
