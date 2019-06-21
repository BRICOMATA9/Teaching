/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets 
#	Exercice   : 9.1 
#	Fichier    : Exercice1.java
#	Class      : Exercice1  
*/

public class Exercice1  {
	public static void main(String  [] arg)  {
		int i ;
		int [] 	valeur = new int[6] ;
		valeur [0] = 1;
		for (i = 1; i < valeur.length; i++)
			valeur[i] = valeur[i-1]+2;
		for (i = 0; i < valeur.length; i++)
			System.out.println("valeur["+i+"] = "+valeur[i]); 		
 		for (int v : valeur)
  			System.out.println("valeur = " + v); 

	}
}