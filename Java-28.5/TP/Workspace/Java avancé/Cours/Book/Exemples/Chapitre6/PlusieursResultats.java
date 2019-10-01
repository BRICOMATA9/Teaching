/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 6 : Fonctions, notions avancées
#	Section  : Lorsqu'il y a plusieurs résultats à retourner
#	Fichier  : PlusieursResultats.java
#	Class    : PlusieursResultats 
*/
import java.util.*;
public class PlusieursResultats {
	public static void main (String [] arg) {
		int a, b;	
                Scanner lectureClavier = new Scanner(System.in);	
		System.out.print("Entrer une valeur pour a : ");
		a = lectureClavier.nextInt();
		System.out.print("Entrer une valeur pour b : ");
		b = lectureClavier.nextInt();
		System.out.println(" a = "+a+" b = "+b);
	        echange (a,b);	
		System.out.println("Apres echange,");
		System.out.println(" a = "+ a +" b = "+b);
	}
	public static void echange(int x, int  y) {
		int tmp = x;
		x = y;
		y = tmp;
	}
}