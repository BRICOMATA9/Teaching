/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : ProjetCh10.java
#	Class    : ProjetCh10
*/
import java.util.*;
public class ProjetCh10{
	public static void main (String [] argument) {
		byte choix = 0 ;
		String numéroLu = "";
	        // Les classes ListeCompte et FichierCompte sont définies dans le dossier "commun"
		ListeCompte C = new ListeCompte();
		FichierCompte F = new FichierCompte();
                Scanner lectureClavier = new Scanner(System.in);
		if (F.ouvrir("L")) {
			C = F.lire();
			F.fermer();
		}
		do {
			choix = menuPrincipal();
			switch (choix)	{
			case 1 :
				System.out.print (" Compte Epargne (o/n) : ");
				if (lectureClavier.next().charAt(0) == 'o')	
                                   C.ajouteUnCompte("E") ;
				else      		
                                   C.ajouteUnCompte("A");  
			        break;
			case 2 :
				System.out.print ( "Quel compte souhaitez vous afficher ? : ");
				numéroLu = lectureClavier.next();
				C.rechercheUnCompte(numéroLu);
			        break;
			case 3 :
				C.afficheLesComptes(); 
			        break;
			case 4 :
				System.out.print ( "Pour quel compte souhaitez vous créer une ligne ? : ");
				numéroLu = lectureClavier.next();
				C.ajouteUneLigne(numéroLu);
			        break;
			case 5 :
				System.out.print ( "Quel compte souhaitez vous supprimer ? : ");
				numéroLu = lectureClavier.next();
				C.supprimeUnCompte(numéroLu);
			        break;
			case 6 :
				System.out.println("Sauvegarde des données dans Compte.dat");	
				F.ouvrir("E"); 
				F.ecrire(C);
				F.fermer();
				sortir();    
			        break;
			case 7 :		
                                alAide();
			        break;
			default :	
                                System.out.println("Cette option n'existe pas ");
		}
	} while (choix != 6);
 }
 public static byte menuPrincipal() {
	byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
	System.out.println("1. Création d'un compte");
	System.out.println("2. Affichage d'un compte");
	System.out.println("3. Affichage de tous les comptes");
	System.out.println("4. Ecrire une ligne comptable");
	System.out.println("5. Supprimer un compte ");
	System.out.println("6. Sortir");
	System.out.println("7. De l'aide");
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