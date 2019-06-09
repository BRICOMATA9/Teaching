package question1;

public class VisiteurPostfixe extends VisiteurParDefaut<String> {

    private Contexte c;

    public VisiteurPostfixe(Contexte c) {
        this.c = c;
    }

    // a completer
    // aucun warning, de type unsafe a la compilation ne doit apparaitre

    public Contexte contexte() {
        return c;
    }

}
