/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 7 : Les classes et les objets
#	Section  : Construire et utiliser ses propres classes
#	Fichier  : FaireDesCercles.java
#	Class    : FaireDesCercles 
*/
import java.util.*;
public class FaireDesCercles {
 public static void main(String [] arg) {
  Cercle A  = new Cercle();
  Scanner lectureClavier = new Scanner(System.in);
  A.affiche();
  System.out.print(" Entrez la position en x : ") ;
  A.x = lectureClavier.nextInt();
  System.out.print(" Entrez la position en y : ") ;
  A.y = lectureClavier.nextInt();
  System.out.print(" Entrez le rayon : ");
  A.r = lectureClavier.nextInt();
  A.affiche();
  double p = A.périmètre();
  System.out.println(" Votre cercle a pour perimetre : " + p);
  A.déplacer(5, 10);
  System.out.println(" Apres deplacement : ");
  A.affiche();
  A.agrandir(10);
  System.out.println(" Apres agrandissement : ");
  A.affiche();
  Cercle B = new Cercle();
  B.x = 50;
  B.y = 50;
  B.r = 100;
  System.out.println("  Le cercle B : ");
  B. affiche();
  B.échange(A);
  System.out.println(" Après echange le cercle A : ");
  A.affiche();
  System.out.println("  Le cercle B : ");
  B.affiche();
 }
}