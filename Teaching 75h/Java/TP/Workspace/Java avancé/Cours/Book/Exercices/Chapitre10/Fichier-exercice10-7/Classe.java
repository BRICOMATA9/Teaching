/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.7 
#	Fichier    : Classe.java
#	Class      : Classe
*/

import java.util.*;
import java.io.*;
public class Classe implements Serializable {
 private HashMap<String, Etudiant> listeClassée;
 public Classe()   {
	listeClassée = new HashMap<String, Etudiant> ();		
 }
  public String créerUneClé(Etudiant e) {
  	 String tmp;
  	 tmp = (e.quelPrénom()).charAt(0)+ e.quelNom();
  	 tmp.toUpperCase();
  	 return tmp;
  }
  public String créerUneClé(String p, String n ) {
  	 String tmp;
  	 tmp = p.charAt(0)+ n;
  	 tmp.toUpperCase();
  	 return tmp;
  }	
  public void ajouteUnEtudiant() {
	 Etudiant e = new Etudiant();
 	 String clé = créerUneClé(e);	
 	 Etudiant nouveau = (Etudiant) listeClassée.get(clé);
 	 if (nouveau == null) listeClassée.put(clé, e);
  }	
  public void rechercheUnEtudiant(String p, String n) {
 	 String clé = créerUneClé(p, n);
 	 Etudiant e = (Etudiant) listeClassée.get(clé);
 	 if (e != null)  	e.afficheUnEtudiant();
   else System.out.println(p + " " + n + " est inconnu ! ");
  }
 	public void supprimeUnEtudiant(String p, String n) {
	  	String clé = créerUneClé(p, n);
    	Etudiant e = (Etudiant) listeClassée.get(clé);
 	  if (e != null)  {
 	   	listeClassée.remove(clé);
 	  	  	System.out.println(p + " " + n + " a été supprimé ");
 	  } 
 	  else System.out.println(p + " " + n + " est inconnu ! ");
  }
  public void afficheLesEtudiants() 	{
	if(listeClassée.size() != 0)
	{
           Collection<Etudiant> c = listeClassée.values();
 
           for (  Etudiant e : c) {
  		  e.afficheUnEtudiant(); 	
        }
	}
	else System.out.println("Il n'y a pas d'etudiant dans cette liste");
 }
}