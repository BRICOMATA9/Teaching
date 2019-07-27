/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Introduction : Naissance d'un programme
#	Exercice : I.2
#	Fichier  : Premier.java
#	Class    : Premier
*/
import java.util.*;
public class Premier {
 public static void main(String [] argument) {
  double a;
  Scanner lectureClavier = new Scanner(System.in);
  System.out.print("Entrer une valeur : ") ;
  a = lectureClavier.nextDouble();
  System.out.print("Vous avez entre : " + a) ;
 }
}