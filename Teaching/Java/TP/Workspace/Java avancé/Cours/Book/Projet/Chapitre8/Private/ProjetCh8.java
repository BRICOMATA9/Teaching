/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - La protection privée
#	Fichier  : ProjetCh8.java
#	Class    : ProjetCh8
*/
import java.util.*;
public class ProjetCh8 {
	// La fonction principale
	public static void main (String [] argument)	{
                Scanner lectureClavier = new Scanner(System.in);
 		byte choix = 0 ;
 		String numéroLu = "";
   	        Compte 	C = new Compte(); 
 		do	{
   		  choix = menuPrincipal();
   		  switch (choix)	{
     		    case 1 :	
                        C.créerCpte() ;
     		        break;
     		    case 2 :
        		//demande à l'utilisateur de saisir le numéro du compte à afficher
        		System.out.print ( "Quel compte souhaitez vous afficher ? : ");
        		numéroLu = lectureClavier.next();
        		// vérifie que le numéro du compte existe, 
        		//if ( numéroLu.equalsIgnoreCase(C.numéroCpte)) -> numéroCpte inaccessible car private dans Compte
        		if ( numéroLu.equalsIgnoreCase(C.quelNuméroDeCompte()))
		         //Si oui, affiche le numéro du compte, le type, la valeur initiale
     			  C.afficherCpte();
          	        else
	          	// Sinon, il affiche un message indiquant que le numéro du compte n'est pas valide.
          		System.out.println("Le systeme ne connait pas le compte " + numéroLu);
      		        break;
     		case 3 :	
                        //option 3, créer une ligne comptable
        		System.out.print ( "Pour quel compte souhaitez vous créer une ligne ? : ");
        		numéroLu = lectureClavier.next();
        		if ( numéroLu.equalsIgnoreCase(C.quelNuméroDeCompte()))
       	   		    C.créerLigne();
        		else
          		    System.out.println("Le systeme ne connait pas le compte " + numéroLu);
      		        break;
     		case 4 :
       			//option 4,  le programme termine son exécution
       			sortir();    
                        break;
     		case 5 :
      			//le programme affiche une ligne d'explication pour chaque option du menu principal.
      			alAide();
      		        break;
     		default :		System.out.println("Cette option n'existe pas ");
   		}
 	 	} while (choix != 4);
 }
 // Affiche le menu principal, retourne la valeur de l'option choisie
 public static byte menuPrincipal() {
    byte tmp;
    Scanner lectureClavier = new Scanner(System.in);
    System.out.println("1. Création d'un compte");
    System.out.println("2. Affichage d'un compte");
    System.out.println("3. Ecrire une ligne comptable");
    System.out.println("4. Sortir");
    System.out.println("5. De l'aide");
    System.out.println();
    System.out.print("Votre choix : ");
    tmp  = lectureClavier.nextByte();
    return tmp;
 } 
  // pour sortir poliment du programme 
 public static void sortir( )	{
   System.out.println("Au revoir et à bientôt");
   System.exit(0) ;    
 }
  // Affiche une aide ...
  public static void alAide()	{
    System.out.println("Option 1. Pour créer un compte Courant entrer C ");
    System.out.println("                 Pour créer un compte Joint entrer J ");
    System.out.println("                 Pour créer un compte Epargne entrer E");       
    System.out.println("                 Entrer ensuite le numéro du compte, sa première valeur créditée");
    System.out.println("                 Dans le cas d'un compte épargne, entrer le taux ");
    System.out.println("Option 2. Le système affiche les données du compte de votre choix ");
    System.out.println("Option 3. Ecrire une ligne comptable");
    System.out.println("Option 4. Pour quitter le programme");
    System.out.println("Option 5. Pour afficher de l'aide");
  } 
}