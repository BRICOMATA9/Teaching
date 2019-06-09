/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets
#	Section  : Quelques techniques utiles
#	Fichier  : Calculette.java
#	Class    : Calculette 
*/
import java.util.*;
public class Calculette {
 public static void main( String [] argument) {
  int a, b;
  char opérateur;
  double calcul;
  if (argument.length > 0) {
	  a = Integer.parseInt(argument[0]);
	  opérateur = argument[1].charAt(0);
	  b = Integer.parseInt(argument[2]);
  }
  else {
    Scanner lectureClavier = new Scanner(System.in);
    opérateur = menu();
    System.out.println("Entrer la première valeur ");
    a = lectureClavier.nextInt();
    System.out.println("Entrer la seconde valeur ");
    b = lectureClavier.nextInt();
  }
    calcul = calculer(a, b, opérateur );
   afficher(a, b, opérateur, calcul); 
 }
 public static double calculer (int x, int y, char o) {
  double résultat =0;
  switch (o) {
   case '+' : résultat = x + y;
              break;
   case '-' : résultat = x - y;
              break;
   case '/' : résultat = x / y;
              break;
   case '*' : résultat = x * y ; 
              break;
    }
    return résultat;
 }
 public static void afficher(int x, int y, char o, double r) {
   System.out.println(x + "  " +o+ " "+ y + " =  " + r);  
 }
 public static char menu() {
  char opération ;
  Scanner lectureClavier = new Scanner(System.in);
  System.out.println("Entrer en premier l'opération choisie : ");
  System.out.print(" (+, -, *, /)  ? : ");
  opération = lectureClavier.next().charAt(0);
  return opération ;
 }
}