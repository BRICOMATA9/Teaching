/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 4 : Faire des répétitions
#	Exercice : 4.7
#	Fichier  : Exercice7.java
#	Class    : Exercice7
*/
import java.util.*;
public class Exercice7 {
 public static void main (String [] paramètre) {
  long i, b = 1;
  int a;
  Scanner lectureClavier = new Scanner(System.in);
  System.out.print("Entrer un entier :");
  a = lectureClavier.nextInt();
  for (i = 2; i <= a; i++)
    b = b * i;
  System.out.println("La resultat vaut " + b);
 }
}