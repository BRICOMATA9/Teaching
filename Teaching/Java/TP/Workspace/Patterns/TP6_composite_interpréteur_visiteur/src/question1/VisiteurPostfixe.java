package question1;

public class VisiteurPostfixe extends VisiteurParDefaut<String> {

  private Contexte c;

  public VisiteurPostfixe(Contexte c) {
      this.c = c;
  }

	public String visite(Constante c) {
		return Integer.toString(c.valeur());
	}

	public String visite(Variable v) {
		return v.nom();
	}

	public String visite(Division d) {
		return "(" + d.op1().accepter(this) + "," +d.op2().accepter(this) + ")/";
	}

	public String visite(Addition a) {
		return "(" + a.op1().accepter(this) + "," +a.op2().accepter(this) + ")+";
	}

	public String visite(Multiplication m) {
		return "(" + m.op1().accepter(this) + "," +m.op2().accepter(this) + ")*";
	}

	public String visite(Soustraction s) {
		return "(" + s.op1().accepter(this) + "," +s.op2().accepter(this) + ")-";
	}

    public Contexte contexte() {
        return c;
    }

}
