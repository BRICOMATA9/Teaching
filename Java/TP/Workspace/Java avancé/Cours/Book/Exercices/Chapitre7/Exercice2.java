/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 7 : Les classes et les objets
#	Exercice : 7.2
#	Fichier  : Exercice2.java
#	Class    : Exercice2
*/
import java.util.*;
public class Exercice2 {
	public static void main(String [] argument) {
		String s1 = "", sPlusGrand = "", sPlusPetit = "";
                Scanner lectureClavier = new Scanner(System.in);              
		System.out.print("Entrez un mot : ");
		s1 = lectureClavier.next();
		sPlusGrand = s1 ;
		sPlusPetit = s1 ;
		do {
			if (s1.compareTo(sPlusGrand) < 0) sPlusGrand = s1 ;
			if (s1.compareTo(sPlusPetit) > 0) sPlusPetit = s1 ;
			System.out.print("Entrer une mot (FIN pour sortir) : ") ;
			s1 = Lire.S();
		} while ( ! s1.equalsIgnoreCase("FIN") );
		System.out.println("Le plus grand mot : " + sPlusGrand) ;
		System.out.println("Le plus petit mot : " + sPlusPetit) ;
	}
}