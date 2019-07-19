/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.3 
#	Fichier    : Classe.java
#	Class      : Classe
*/
import java.util.*;
 public class Classe  {

 private HashMap<String, Etudiant> listeClassée;
 public Classe()   {
	listeClassée = new HashMap<String, Etudiant> ();		
 }
 
   private String créerUneClé(Etudiant e) {
  	 String tmp;
  	 tmp = (e.quelPrénom()).charAt(0)+ e.quelNom();
  	 tmp.toUpperCase();
  	 return tmp;
  }
 	
   private String créerUneClé(String p, String n ) {
  	 String tmp;
  	 tmp = p.charAt(0)+ n;
  	 tmp.toUpperCase();
  	 return tmp;
  }
 	
 public void ajouteUnEtudiant() {
	Etudiant nouveau = new Etudiant();
	String clé = créerUneClé(nouveau);
	if (listeClassée.get(clé) == null) listeClassée.put(clé, nouveau);
 	else System.out.println("Cet étudiant a deja ete saisi !");
 }
 	
  public void rechercheUnEtudiant(String p, String n) {
 	String clé = créerUneClé(p, n);
 	Etudiant eClassé = (Etudiant) listeClassée.get(clé);
 	if (eClassé != null)  
	   	eClassé.afficheUnEtudiant();
        else System.out.println(p + " " + n + " est inconnu ! ");
  }


  public void modifieUnEtudiant(String p, String n) {
 	String clé = créerUneClé(p, n);
 	if (listeClassée.get(clé) != null) {
 		 	Etudiant eModifié = new Etudiant(p, n) ;
			listeClassée.put(clé, eModifié);
 	}
 	else System.out.println(p + " " + n + " est inconnu ! ");
  }
 	

   public void supprimeUnEtudiant(String p, String n) {
  	String clé = créerUneClé(p, n);
    	Etudiant eClassé = (Etudiant) listeClassée.get(clé);
 	  if (eClassé != null)  {
 	   	listeClassée.remove(clé);
 	  	  	System.out.println(p + " " + n + " a été supprimé ");
 	  } 
 	  else System.out.println(p + " " + n + " est inconnu ! ");
  }


 public void afficheLesEtudiants() 	{
	if(listeClassée.size() != 0)  {
           Collection<Etudiant> c = listeClassée.values();
           for (  Etudiant e : c)   e.afficheUnEtudiant(); 	
	}
	else System.out.println("Il n'y a pas d'etudiant dans cette liste");
 }
 
}