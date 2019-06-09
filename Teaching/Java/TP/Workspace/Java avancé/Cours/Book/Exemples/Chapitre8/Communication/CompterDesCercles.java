/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept objet
#	Section  : La communication objet
#	Fichier  : CompterDesCercles.java
#	Class    : CompterDesCercles 
*/

public class CompterDesCercles {
 public static void main(String [] arg) {
  Cercle A  = new Cercle();
  A.créer();
  System.out.println("Nombre de cercle(s) : " + Cercle.nombre);
  Cercle B = new Cercle();
  B.créer();
  System.out.println("Nombre de cercle(s) : " + Cercle.nombre);
 }
} // Fin de la classe CompterDesCercles