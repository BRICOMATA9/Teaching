/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept objet
#	Section  : La protection des données
#	Fichier  : CercleConrole.java
#	Class    : CercleControle 
*/
import java.util.*;
public class CercleControle	{
 private int x, y, r ; 
 public void créer()	  {
   Scanner lectureClavier = new Scanner(System.in);
   System.out.print("Position en x :  ");
   x = lectureClavier.nextInt();
   System.out.print("Position en y :  ");
   y = lectureClavier.nextInt();
   do  {
     System.out.print("Rayon         :  ");
     r = Lire.i();
   } while ( r < 0 || r >  600); 
 }
 public void afficher() 	{	
   System.out.println("Centre en " + x + ", " + y);
   System.out.println("Rayon : " + r);
 }
 public void agrandir(int nr) 	{		 
   if (r + nr < 0) r = 0;
   else if ( r + nr > 600) r = 600;
   else r = r + nr;									
 }
} // Fin de la classe CercleControle