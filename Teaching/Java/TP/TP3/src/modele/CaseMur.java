package modele;

public class CaseMur extends CaseImplementee {

    // Constructeurs
    public CaseMur(int lig, int col) {
        super(lig, col); // appel du constructeur de la classe mère CaseImplementee
        moved = false; // on ne peut pas visiter une CaseMur
    }

}
