package question1;

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c;

    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }

    // a completer
    // aucun warning, de type unsafe a la compilation ne doit apparaitre

    public Contexte contexte() {
        return c;
    }

}
