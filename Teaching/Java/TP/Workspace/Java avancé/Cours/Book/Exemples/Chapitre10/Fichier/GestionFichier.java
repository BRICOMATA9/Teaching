/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Les fichiers textes
#	Fichier  : GestionFichier.java
#	Class    : GestionFichier 
*/
import java.util.*;
import java.io.*;
public class GestionFichier	{
 public static void main (String [] arg) throws IOException  {
        Scanner lectureClavier = new Scanner(System.in);
	Fichier f = new Fichier();
	System.out.print(" Entrer le nom du fichier : ");
	String nomFichier = lectureClavier.next();
	f.ouvrir(nomFichier, "Ecriture");
	for (int i = 0; i < 5; i++)  f.ecrire(i);
	f.fermer();
	f.ouvrir(nomFichier,"Lecture");
	String chaine ="";
	do {
		chaine = f.lire();
		if (chaine != null) System.out.println(chaine);
	} while (chaine != null);
	f.fermer();
 }
}