/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets 
#	Exercice   : 9.5 
#	Fichier    : Exercice5.java
#	Class      : Exercice5  
*/
public class Exercice5 {
 public static void main(String  [] arg)  {
	int [][] Etoile = new int[7][7];
	// a. Initialisation du tableau
	for (int i = 0; i < Etoile.length; i++) {	 
		for (int j = 0; j < Etoile[0].length; j++) {
			Etoile[i][i] = 1;
			Etoile[3][i] = 1;
			Etoile[i][3] = 1;
			Etoile[i][6-i] = 1;
		}
	}
	// b. Affichage du tableau
	for (int i = 0; i < Etoile.length; i++) {	 
		for (int j = 0; j < Etoile[0].length; j++) {
			if(Etoile[i][j] == 0) 	System.out.print(" ");
			else	System.out.print("*");
		}
		System.out.println();
	}
 } // Fin de la fonction main()
} // Fin de la classe Exercice5