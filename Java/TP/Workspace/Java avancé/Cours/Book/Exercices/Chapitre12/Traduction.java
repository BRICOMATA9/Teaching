/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Exercice 12.1
#	Fichier  : Traduction.java
#	Class    : Traduction
*/
import java.util.*;
public class Traduction {
 public static void main(String [] arg) {
        Scanner lectureClavier = new Scanner(System.in);
	String phrase = "";
	System.out.print("Entrez une phrase : ");
	phrase = lectureClavier.next();
	phrase = phrase.replace('a', '*');
	phrase = phrase.replace('o', '!');
	phrase = phrase.replace('e', '%');
	System.out.println("Reponse :" + phrase);
 }
} // Fin de Traduction
