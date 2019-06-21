/*
#	Le livre de Java 1er Langage
#	A. Tasso
#	Chapitre 7 : Les classes et les objets
#	Exercice : 7.2 
#	Fichier : FaireDesTriangles.java
#	Class : FaireDesTriangles
*/

public class FaireDesTriangles {

	public static void main(String[] args) {
	    Triangle T  = new Triangle();
	    T.afficher();
	    T.créer();
	    T.afficher();
	    T.deplacer(100, 0);
	    T.afficher();
	}
}
