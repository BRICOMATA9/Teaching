/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 4 : Faire des répétitions
#	Exercice : 4.8
#	Fichier  : Exercice8.java
#	Class    : Exercice8
*/
public class Exercice8  {
  public static void main (String [] parametre)  {
  	
  	char c;
  	for (c = 'a'; c <= 'z'; c++) System.out.print(c + " ");
  	System.out.println();
  	for (c = 'z'; c >= 'a'; c--) System.out.print(c + " ");
  	System.out.println();
 }
}