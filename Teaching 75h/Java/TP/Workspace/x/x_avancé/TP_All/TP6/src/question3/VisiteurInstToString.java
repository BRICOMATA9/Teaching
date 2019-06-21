package question3;

import question1.*;
import question2.*;

/**
 * Visisteur dinstruction, chaque classe concrete possede une implementation de
 * la visite
 * 
 */
public class VisiteurInstToString extends VisiteurInstruction<String> {

	private VisiteurExpression<String> vi;
	private VisiteurExpressionBooleenne<String> vb;

	/**
	 * Creation dun visiteur dinstructions
	 * 
	 * @param vi
	 *            le visiteur dexpressions arithmetiques
	 * @param vb
	 *            le visiteur dexpression booleennes
	 */
	public VisiteurInstToString(VisiteurExpression<String> vi,
			VisiteurExpressionBooleenne<String> vb) {
		this.vi = vi;
		this.vb = vb;
	}

	/**
	 * obtention du contexte, ici celui du visiteur dexpression arithmetiques
	 * 
	 * @return le contexte ici de vi(le visiteur dexpression)
	 */
	public Contexte contexte() {
		return this.vi.contexte();
	}

	/**
	 * Visite dune instance de la classe Affectation.
	 * 
	 * 
	 * @param a
	 *            une affectation
	 * @return a := exp
	 */
	public String visite(Affectation a) {
		return a.v().accepter(this.vi) + " := " + a.exp().accepter(this.vi);
	}

	/**
	 * Visiste dune sequence seq(I1,I2) <br>
	 * 
	 * @param seq
	 *            une sequence
	 * @return i1;i2
	 */
	public String visite(Sequence seq) {
		return seq.i1().accepter(this) + " ; " + seq.i2().accepter(this);
	}

	public String visite(Selection sel) {
		String str = "si" + sel.cond().accepter(this.vb) + " alors " + sel.i1().accepter(this);
		if (sel.i2() != null) str = str + " sinon " + sel.i2().accepter(this);

		return str + " fsi";
	}

	public String visite(TantQue tq) {
		return "tantque" + tq.cond().accepter(this.vb) + " faire " + tq.i1().accepter(this) + " ftq";
	}

	public String visite(Pour pour) {
		return "pour(" + pour.init().accepter(this) + "," + pour.cond().accepter(this.vb) + ","
				+ pour.inc().accepter(this) + ") " + pour.i1().accepter(this)
				+ " fpour";
	}

	public String visite(Afficher a) {
		return "afficher(" + a.exp().accepter(this.vi) + ")";
	}

	public String visite(Assertion a) {
		return "assertion(" + a.cond().accepter(this.vb) + ")";
	}

}
