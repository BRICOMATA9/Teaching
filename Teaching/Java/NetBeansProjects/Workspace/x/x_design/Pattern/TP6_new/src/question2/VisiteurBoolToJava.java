package question2;

import question1.VisiteurExpression;

public class VisiteurBoolToJava extends VisiteurExpressionBooleenne<String> {

	private VisiteurExpression<String> ve;

	public VisiteurBoolToJava(VisiteurExpression<String> ve) {
		this.ve = ve;
	}

	public String visite(Vrai v) {
		return "null";
	}

	public String visite(Faux f) {
		return "null";
	}

	public String visite(Non n) {
		return "!(" + "null" + ")";
	}

	public String visite(Ou ou) {
		return "(" + "null" + ")";
	}

	public String visite(Et et) {
		return "(" + "null" + ")";
	}

	public String visite(Sup sup) {
		return "(" + "null" + ")";
	}

	public String visite(Egal eg) {
		return "(" + "null" + ")";
	}

	public String visite(Inf inf) {
		return "(" + "null" + ")";
	}
	
}
