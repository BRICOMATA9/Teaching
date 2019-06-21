package question2;

import question1.VisiteurExpression;

public class VisiteurBoolToString extends VisiteurExpressionBooleenne<String> {

	private VisiteurExpression<String> ve;

	public VisiteurBoolToString(VisiteurExpression<String> ve) {
		this.ve = ve;
	}

	public String visite(Vrai v) {
		return "vrai";
	}

	public String visite(Faux f) {
		return "faux";
	}

	public String visite(Non n) {
		return "non(" + n.bop().accepter(this) + ")";
	}

	public String visite(Ou ou) {
		return "(" + ou.bop1().accepter(this) + " ou " + ou.bop2().accepter(this) + ")";
	}

	public String visite(Et et) {
		return "(" + et.bop1().accepter(this) + " et " + et.bop2().accepter(this) + ")";
	}

	public String visite(Sup sup) {
		return "(" + sup.op1().accepter(this.ve) + " > " + sup.op2().accepter(this.ve) + ")";
	}

	public String visite(Egal eg) {
		return "(" + eg.op1().accepter(this.ve) + " = " + eg.op2().accepter(this.ve) + ")";
	}

	public String visite(Inf inf) {
		return "(" + inf.op1().accepter(this.ve) + " < " + inf.op2().accepter(this.ve) + ")";
	}
	
}
