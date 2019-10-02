/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept objet
#	Section  : La protection des données
#	Fichier  : FaireDesCerclesPrives.java
#	Class    : FaireDesCerclesPrives 
*/

public class FaireDesCerclesPrives {
 public static void main(String [] arg) {
  CerclePrive A  = new CerclePrive();
  A.afficher();
  System.out.println("Entrez le rayon : ");
  A.r = Lire.i() ;
  System.out.println("Le cercle est de rayon : " + A.r) ;
 }
}