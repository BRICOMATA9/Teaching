package preliminaire;

public class Moins extends Unaire {

    public Moins(Expression op) {
        super(op);
    }

    public String toString() {
        return "-" + op.toString();
    }

    public int interprete(Contexte c) {
        return -op.interprete(c);
    }

}