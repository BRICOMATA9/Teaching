/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Gérer les exceptions
#	Fichier  : GestionClasse.java
#	Class    : GestionClasse
*/
import java.util.*;
import java.io.*;
public class GestionClasse  {
 public static void main (String [] argument) throws IOException { 
	byte choix = 0 ;
	Classe C = new Classe();
	FichierEtudiant F = new FichierEtudiant();
        Scanner lectureClavier = new Scanner(System.in);
	if (F.ouvrir("Lecture")) {
		C = F.lire();
		F.fermer();
	}
	String prénom, nom;
	do {
	  choix = menuPrincipal();
	  switch (choix) {
		case 1 :		C.ajouteUnEtudiant();
		break;
		case 2 :
			System.out.print("Entrer le prenom de l'étudiant a supprimer ");
			prénom = lectureClavier.next();
			System.out.print("Entrer le nom de l'étudiant a supprimer ");
			nom = lectureClavier.next();
			C.supprimeUnEtudiant(prénom, nom);
		break;
		case 3 :		C.afficheLesEtudiants(); 
		break;
		case 4 :
			System.out.print("Entrer le prenom de l'étudiant recherche ");
			prénom = lectureClavier.next();
			System.out.print("Entrer le nom de l'étudiant recherche ");
			nom = lectureClavier.next();
			C.rechercheUnEtudiant(prénom, nom);
		break;
		case 5 : //option 5,  le programme termine son exécution
			System.out.println("Sauvegarde des données dans Classe.dat");	
			F.ouvrir("Ecriture"); 
			F.ecrire(C);
			F.fermer();
			sortir();    
		break;
		default : System.out.println("Cette option n'existe pas ");
	}
  } while (choix != 5);
 }
 public static byte menuPrincipal() {
	byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
	System.out.println("1. Ajoute un etudiant");
	System.out.println("2. Supprime un etudiant");
	System.out.println("3. Affiche la classe");
	System.out.println("4. Affiche un etudiant");
	System.out.println("5. Sortir");
	System.out.println();
	System.out.print("Votre choix : ");
	tmp  = lectureClavier.nextByte();
	return tmp;
 }
 public static void sortir( ) {
	System.out.println("Au revoir et à bientôt");
	System.exit(0) ;
 }
}