/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 7 : Les classes et les objets 
#	Exercice   : 7.6 et 7.7
#	Fichier    : FaireDesRectangles.java
#	Class      : FaireDesRectangles
*/
public class FaireDesRectangles {

	public static void main(String[] args) {
            Rectangle R  = new Rectangle();
	    R.afficher();
	    R.créer();
	    R.afficher();
	    R.deplacer(0, 200);
	    R.afficher();
	}
}
