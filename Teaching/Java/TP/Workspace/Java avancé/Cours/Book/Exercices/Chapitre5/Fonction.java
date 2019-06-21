/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 5 : De l'algorithme paramétré à l'écriture de fonctions
#	Exercice : 5.2
#	Fichier  : Fonction.java
#	Class    : Fonction
*/
public class Fonction  {
  public static void main(String [] parametre)  {
   // Déclaration des variables
   int a,compteur;
   for (compteur = 0; compteur <= 5; compteur++)    {
     a = calculer(compteur);
     System.out.print(a + " a ");
   }
  } // fin de main()
  public static int calculer(int x)  {
    int y;
    y = x * x;
    return y ;
  } // fin de fonc1()
} //fin de class 