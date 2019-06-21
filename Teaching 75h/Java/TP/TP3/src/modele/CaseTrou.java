package modele;

public class CaseTrou extends CaseImplementee {
    // Constructeurs
    public CaseTrou(int lig, int col ) {
	super(lig, col) ; // appel du constructeur de la classe mère CaseImplementee
	moved=true ; // on peut visiter une CaseTrou
    }  
}
