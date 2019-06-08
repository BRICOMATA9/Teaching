package preliminaire;

public class Plus extends Unaire {

    public Plus(Expression op) {
        super(op);
    }

    public String toString() {
        return "+" + op.toString();
    }

    public int interprete(Contexte c) {
        return +op.interprete(c);
    }

}
