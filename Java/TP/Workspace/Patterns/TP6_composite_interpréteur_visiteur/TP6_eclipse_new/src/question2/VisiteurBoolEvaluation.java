package question2;

import question1.VisiteurExpression;

public class VisiteurBoolEvaluation extends VisiteurExpressionBooleenne<Boolean> {

    private VisiteurExpression<Integer> ve;

    public VisiteurBoolEvaluation(VisiteurExpression<Integer> ve) {
        this.ve = ve;
    }

    public Boolean visite(Vrai v) {
        return true;
    }

    public Boolean visite(Faux f) {
        return false;
    }

    public Boolean visite(Non n) { 
    	return ! n.bop().accepter(this);
    }
    
	public Boolean visite(Ou ou) {
		return ou.bop1().accepter(this) || ou.bop2().accepter(this);
	}

	public Boolean visite(Et et) {
		return et.bop1().accepter(this) && et.bop2().accepter(this);
	}

	public Boolean visite(Sup sup) {
		return sup.op1().accepter(this.ve) > sup.op2().accepter(this.ve);
	}

	public Boolean visite(Egal eg) {
		return eg.op1().accepter(this.ve) == eg.op2().accepter(this.ve);
	}

	public Boolean visite(Inf inf) {
		return inf.op1().accepter(this.ve) < inf.op2().accepter(this.ve);
	}

}
