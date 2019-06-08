/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept objet
#	Section  : Les constructeurs
#	Fichier  : FaireDesCercles.java
#	Class    : FaireDesCercles 
*/
public class FaireDesCercles {
 public static void main(String [] arg) {
  Cercle A  = new Cercle(10, 10);
  A.afficher();
  A.agrandir(700);
  A.afficher();
 }
}