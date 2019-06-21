/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : Projet.java
#	Class    : Projet
*/
import java.util.*;
public class Projet	{
public static void main (String [] argument) {
	byte choix = 0 ;
	String numéroLu = "";
        Scanner lectureClavier = new Scanner(System.in);
	// Les classes ListeCompte et FichierCompte sont définies dans le dossier "commun"
	ListeCompte liste = new ListeCompte();
	FichierCompte F = new FichierCompte();
	if (F.ouvrir("L")) {
		liste = F.lire();
		F.fermer();
	}
	System.out.println("Affichage des statistiques");
	System.out.print ( "Quel compte souhaitez vous afficher ? : ");
	numéroLu = lectureClavier.next();
	Compte cpte = 	new Compte("");
	cpte = liste.quelCompte(numéroLu);
	if (cpte != null) {
		Stat s = new Stat(cpte);
		s.statParMotif();
	}
 }
}