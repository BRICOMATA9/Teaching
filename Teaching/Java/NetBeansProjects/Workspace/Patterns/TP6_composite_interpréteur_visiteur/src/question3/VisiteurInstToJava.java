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
		return null; // a completer
	}

	public String visite(Selection sel) {
		return null; // a completer
	}

	public String visite(TantQue tq) {
		return null; // a completer
	}

	public String visite(Pour pour) {

		return null; // a completer
	}

	public String visite(Afficher a) {
		return null; // a completer
	}

	public String visite(Assertion a) {
		return null; // a completer
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
