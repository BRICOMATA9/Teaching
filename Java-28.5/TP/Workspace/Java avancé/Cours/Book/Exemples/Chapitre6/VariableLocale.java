/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 6 : Fonctions, notions avancées
#	Section  : Variables locales à une fonction
#	Fichier  : VariableLocale.java
#	Class    : VariableLocale 
*/

public class VariableLocale {
  public static void main(String [] paramètre)   {
   // déclaration de variables locales
   int valeur = 2 ;
   System.out.println("Valeur = " + valeur + " avant modifier() ");
   modifier();
   System.out.println("Valeur = " + valeur + " apres modifier() ");
  } // fin de main()

  public static void modifier ()  {
   // déclaration de variables locales
   int valeur ;
   valeur = 3 ;
   System.out.println("Valeur = " + valeur + " dans modifier() ");
  } // fin de modifier
} //fin de class VariableLocale