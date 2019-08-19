/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Les listes
#	Fichier  : Classe.java
#	Class    : Classe
*/

import java.util.*;
 public class Classe  {
 private ArrayList<Etudiant>  liste;
 public Classe()   {
 	liste = new ArrayList<Etudiant>();		
 }
 public void ajouteUnEtudiant() {
	liste.add(new Etudiant());
 }
 public void afficheLesEtudiants() 	{
	int nbEtudiants = liste.size();
	if (nbEtudiants > 0) {
                  for (Etudiant e : liste) e.afficheUnEtudiant();
	}
	else System.out.println("Il n'y a pas d'etudiant dans cette liste");
 }
}