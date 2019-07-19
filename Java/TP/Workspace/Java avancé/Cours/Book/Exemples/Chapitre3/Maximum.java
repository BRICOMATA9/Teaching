/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 3 : Faire des choix
#	Section  : Rechercher le plus grand de deux éléments
#	Fichier  : Maximum.java
#	Class    : Maximum
*/
import java.util.*;
public class Maximum { // Le fichier s'appelle Maximum.java
  public static void main (String [] parametre)  {
   int première, deuxième, laPlusGrande ;

   Scanner lectureClavier = new Scanner(System.in);

   System.out.print("Entrer une valeur :") ;
   première =  lectureClavier.nextInt();
   System.out.print("Entrer une deuxieme valeur :") ;
   deuxième =  lectureClavier.nextInt();
   if (première > deuxième)    {
     System.out.println(deuxième + "  " + première) ;
     laPlusGrande = première ;
   }
   else   {
     System.out.println(première + " " + deuxième) ;
     laPlusGrande = deuxième ;
   }
  System.out.println("La plus grande valeur est : " + laPlusGrande) ;
  } // Fin du main ()
} // Fin de la classe Maximum