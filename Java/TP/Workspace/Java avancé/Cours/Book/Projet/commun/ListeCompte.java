/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 - 11 : Fichiers communs au projet
#	Section  : Projet
#	Fichier  : ListeCompte.java
#	Class    : ListeCompte
*/

import java.util.*;
import java.io.*;
public class ListeCompte implements Serializable {
	private HashMap<String, Compte> liste;  
	public ListeCompte()   {
		liste = new HashMap<String, Compte>();		
	}
	public void ajouteUnCompte(String t) {
		Compte nouveau = new Compte("");
		if (t.equalsIgnoreCase("A")) nouveau = new Compte();
		else if (t.equalsIgnoreCase("E"))  nouveau = new CpteEpargne();
		String clé = nouveau.quelNuméroDeCompte();
		if (liste.get(clé) == null) liste.put(clé, nouveau);
		else System.out.println("Ce compte existe deja !");
	}
	public void ajouteUneLigne(String n) {
		String clé = n;
		Compte c = (Compte) liste.get(clé);
		if (c != null)		c.créerLigne();
		else System.out.println("Le systeme ne connait pas le compte "+n);
	}
	public Compte  quelCompte(String n){
		String clé = n;
		Compte c = (Compte) liste.get(clé);
		if (c == null)  
		System.out.println("Le systeme ne connait pas le compte "+n);
		return(c);
	}
	public void rechercheUnCompte (String n) {
		String clé = n;
		Compte c = (Compte) liste.get(clé);
		if (c != null)		c.afficherCpte();
		else System.out.println("Le systeme ne connait pas le compte "+n);
	}
	public void supprimeUnCompte(String n) {
		String clé = n;
		Compte c = (Compte) liste.get(clé);
		if (c != null)  {
			liste.remove(clé);
			System.out.println(n + " a été supprimé ");
		} 
		else System.out.println(n + " est inconnu ! ");
	}
	public void afficheLesComptes() 	{
	  if(liste.size() != 0)	{
	      Collection<Compte> colCompte = liste.values();
              for (Compte c: colCompte )  c.afficherCpte();	
	  }
	  else System.out.println("Aucun compte n'a ete cree, dans cette liste");
	}

}
