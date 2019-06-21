package question2;

public class Non extends ExpressionBooleenne {

	private ExpressionBooleenne bop;

	public Non(ExpressionBooleenne bop) {
		this.bop = bop;
	}

	public ExpressionBooleenne bop() {
		return bop;
	}

	public <T> T accepter(VisiteurExpressionBooleenne<T> v) {
		return v.visite(this);
	}
	
}