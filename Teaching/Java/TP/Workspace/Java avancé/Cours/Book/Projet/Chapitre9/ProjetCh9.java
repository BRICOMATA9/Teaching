/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 9 : Collectionner un nombre fixe d'objets
#	Section  : Projet
#	Fichier  : ProjetCh9.java
#	Class    : ProjetCh9
*/
import java.util.*;
public class ProjetCh9 {
 public static void main (String [] argument) {
	byte choix = 0 ;
	String numéroLu = "", vide ="";
        Scanner lectureClavier = new Scanner(System.in);
	Compte 	C = new Compte(vide); 
	do   {
		choix = menuPrincipal();
		switch (choix)    {
			case 1 :
				System.out.print (" Compte Epargne (o/n) : ");
				if (lectureClavier.next().charAt(0) == 'o')		
                                     C = new CpteEpargne();
				else		
                                     C = new Compte();  
			break;
			case 2 :
				System.out.print ( "Quel compte souhaitez vous afficher ? : ");
				numéroLu = lectureClavier.next();
			        if ( numéroLu.equalsIgnoreCase(C.quelNuméroDeCompte()))
				   C.afficherCpte();
			        else
				  System.out.println("Le systeme ne connait pas le compte " + numéroLu);
		                break;
		        case 3 :
			       System.out.print ( "Pour quel compte souhaitez vous créer une ligne ? : ");
			       numéroLu = lectureClavier.next();
			       if ( numéroLu.equalsIgnoreCase(C.quelNuméroDeCompte()))
				   C.créerLigne();
			       else
				   System.out.println("Le systeme ne connait pas le compte " + numéroLu);
		               break;
		        case 4 :	
                               sortir();    
		               break;
		        case 5 :	
                               alAide();
		               break;
		        default :	
                               System.out.println("Cette option n'existe pas ");
	          }
          } while (choix != 4);
 }

 public static byte menuPrincipal() {
 	byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
 	System.out.println("1. Creation d'un compte");
 	System.out.println("2. Affichage d'un compte");
 	System.out.println("3. Ecrire une ligne comptable");
 	System.out.println("4. Sortir");
 	System.out.println("5. De l'aide");
 	System.out.println();
 	System.out.print("Votre choix : ");
 	tmp  = lectureClavier.nextByte();
 	return tmp;
 }
 public static void sortir( ) {
	System.out.println("Au revoir et a bientot");
	System.exit(0) ; 
 }
 public static void alAide( ) {
  System.out.println("Option 1. Pour creer un compte Courant entrer C ");
  System.out.println("          Pour creer un compte Joint entrer J ");
  System.out.println("          Pour creer un compte Epargne entrer E");
  System.out.print("            Puis, entrer le numero du compte, et"); 
  System.out.println(" sa premiere valeur creditee ");
  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
  System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
  System.out.println("Option 3. Ecrire une ligne comptable");
  System.out.println("Option 4. Pour quitter le programme");
  System.out.println("Option 5. Pour afficher de l'aide");
 } 
}