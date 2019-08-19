/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 7 : Les classes et les objets
#	Section  : Projet - L'application projet
#	Fichier  : ProjetCh7.java
#	Class    : ProjetCh7
*/
import java.util.*;
public class ProjetCh7 {
 // La fonction principale
 public static void main (String [] argument)	{
	byte choix = 0 ;
	String numéroLu = "";
	Compte 	C = new Compte(); 
        Scanner lectureClavier = new Scanner(System.in);
	do   {
		choix = menuPrincipal();
		switch (choix)    {
		case 1 :		
                        C.créerCpte() ;
		        break;
		case 2 :
			//demande à l'utilisateur de saisir le numéro du compte à afficher
			System.out.print ( "Quel compte souhaitez vous afficher ? : ");
			numéroLu = lectureClavier.next();
			// vérifie que le numéro du compte existe, 
			if ( numéroLu.equalsIgnoreCase(C.numéroCpte))	C.afficherCpte();
			else  System.out.println("Le systeme ne connait pas le compte " + numéroLu);
		        break;
		case 3 : 
                        //option 3, créer une ligne comptable
			System.out.print ( "Pour quel compte souhaitez vous creer une ligne ? : ");
			numéroLu = lectureClavier.next();
			if ( numéroLu.equalsIgnoreCase(C.numéroCpte))	C.créerLigne();
			else System.out.println("Le systeme ne connait pas le compte " + numéroLu);
		        break;
		case 4 :    
                        //option 4,  le programme termine son exécution
			sortir();    
		        break;
		case 5 :		
                        alAide();
		        break;
		default : System.out.println("Cette option n'existe pas ");
	}
  } while (choix != 4);
 }

 // Affiche le menu principal, retourne la valeur de l'option choisie
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