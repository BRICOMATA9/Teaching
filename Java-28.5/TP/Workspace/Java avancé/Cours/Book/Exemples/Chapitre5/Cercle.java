/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 5 : De l'algorithme paramétré à l'écriture de fonction
#	Section  : Les fonctions au sein d'un programme Java
#	Fichier  : Cercle.java
#	Class    : Cercle
*/
import java.util.*;
public class Cercle  {  
public static void main(String [] parametre)  {
   // Déclaration des variables
   int valeur ;
   double résultat ;
   Scanner lectureClavier = new Scanner(System.in);
   System.out.print("Valeur du rayon : ") ;
   valeur = lectureClavier.nextInt() ;
   résultat = périmètre (valeur) ;
   System.out.println("rayon = " + valeur + " perimetre = " + résultat);
  } // fin de main()

  public static double périmètre (int r)  {
	double p ;
	p = 2 * Math.PI * r ;
	return p ;
  } // fin de périmètre()
} //fin de class Cercle