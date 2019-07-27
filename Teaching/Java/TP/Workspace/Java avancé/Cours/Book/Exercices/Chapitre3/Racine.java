/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 3 : Faire des choix
#	Exercice : 3.1
#	Fichier  : Racine.java
#	Class    : Racine
*/
import java.util.*;
public class Racine  {
  public static void main (String [] parametre)  { 
    double  x, r ;
    Scanner lectureClavier = new Scanner(System.in);
    System.out.print("Entrer un chiffre : ") ;
    x = lectureClavier.nextDouble();
    if (x >= 0)     {
      r = Math.sqrt(x) ;
    }
    else    {
      r = Math.sqrt(-x) ;
    }
    System.out.print("Pour " + x + " Le resultat est : " + r) ;
  } // Fin du main ()
} // Fin de la Class Racine