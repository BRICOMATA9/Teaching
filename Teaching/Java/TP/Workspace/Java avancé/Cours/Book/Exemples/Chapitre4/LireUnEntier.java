/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 4 : Faire des répétitions
#	Section  : La boucle while
#	Fichier  : LireUnEntier.java
#	Class    : LireUnEntier
*/


public class LireUnEntier  {
  public static void main (String [] param) throws java.io.IOException  {
   String tmp = "";
   char C= '\0';
   int valeur ;
   System.out.print("Entrez des chiffres et appuyez sur ");
   System.out.println("la touche Entree, pour valider la saisie : ");
   while (C != '\n')   {
    C = (char) System.in.read() ;
    if (C != '\r' && C != '\n') tmp = tmp + C;
   }
   System.out.println("Vous avez entre : " + tmp);
   valeur = Integer.parseInt(tmp);
   System.out.println("C'est a dire : " + valeur + " en entier");
  } // Fin du main ()
} // Fin de la Class LireUnEntier