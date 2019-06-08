/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets
#	Section  : Quelques techniques utiles
#	Fichier  : GestionClasse.java
#	Class    : GestionClasse  
*/

public class GestionClasse  {
	public static void main(String [] argument)  {
		Classe C = new Classe();
		System.out.println("------------  Récapitulatif  --------------");
		C.afficheLesEtudiants();
		C.classerParMoyenne();
		System.out.println("--------------  Classement  ---------------");
		C.afficheLesEtudiants();
	}
}