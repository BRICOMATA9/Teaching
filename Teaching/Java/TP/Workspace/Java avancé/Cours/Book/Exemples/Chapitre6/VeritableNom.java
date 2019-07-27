/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 6 : Fonctions, notions avancées
#	Section  : Queleques précisions sur les variables de classe
#	Fichier  : VeritableNom.java
#	Class    : VeritableNom 
*/
public class VeritableNom {
  // déclaration de la variable valeur
  static int valeur ;
  public static void main(String [] parametre) {
    VeritableNom.valeur = 2 ;
    System.out.println(VeritableNom.valeur + " avant modifier() ");
    modifier();
    System.out.println(VeritableNom.valeur + " après modifier() ");
  } // fin de main()

  public static void modifier () {
    System.out.println("Variable de classe : " + VeritableNom.valeur );
    int valeur = 3 ;
    System.out.println("Variable locale : " + valeur );
    VeritableNom.valeur = 3 ;
    System.out.println("Variable de classe : " + VeritableNom.valeur );
  } // fin de modifier
} //fin de class VeritableNom