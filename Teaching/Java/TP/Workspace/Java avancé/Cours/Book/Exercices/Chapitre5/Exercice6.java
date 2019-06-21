/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 5 : De l'algorithme paramétré à l'écriture de fonctions
#	Exercice : 5.6
#	Fichier  : Exercice6.java
#	Class    : Exercice6
*/
import java.util.*;
public class Exercice6 {
	public static void main(String [] parametre) {
		int valeur;
                valeur = verifier();
                System.out.println("valeur : " + valeur);
                valeur = verifierAvecBornes(10, 20);
                System.out.println("valeur : " + valeur);
        }
 
        // 5.6.b
	public static int verifier() {
	    int resultat;
            Scanner lectureClavier = new Scanner(System.in);
            do  {
                 System.out.print("Entrer un entier : ");
                 resultat= lectureClavier.nextInt();
            } while ( resultat < 0 || resultat > 100) ;
	    return resultat ;
	}

        // 5.6.c
	public static int verifierAvecBornes(int a, int b) {
	    int resultat;
            Scanner lectureClavier = new Scanner(System.in);
            do  {
                 System.out.print("Entrer un entier : ");
                 resultat= lectureClavier.nextInt();
            } while ( resultat < a || resultat > b) ;
	    return resultat ;
	}
}