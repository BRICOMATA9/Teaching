package preliminaire;

public class Constante extends Expression {

    private int i;

    public Constante(int i) {
        this.i = i;
    }

    public int valeur() {
        return i;
    }

    public String toString() {
        return Integer.toString(i);
    }

    public int interprete(Contexte c) {
        return valeur();
    }
}
