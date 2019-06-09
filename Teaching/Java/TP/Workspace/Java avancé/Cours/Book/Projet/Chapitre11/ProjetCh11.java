/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : ProjetCh11.java
#	Class    : ProjetCh11
*/

public class ProjetCh11{
	public static void main (String [] argument)	{
		ListeCompte liste = new ListeCompte();
		FichierCompte F = new FichierCompte();
		if (F.ouvrir("L")) {
			liste = F.lire();
			F.fermer();
		}
		if (liste != null) 	new Saisie(liste);
	}
}	