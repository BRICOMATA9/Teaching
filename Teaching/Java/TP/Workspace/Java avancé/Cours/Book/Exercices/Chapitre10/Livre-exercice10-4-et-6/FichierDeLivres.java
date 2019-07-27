/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.4 et 10.6 
#	Fichier    : FichierDeLivres.java
#	Class      : FichierDeLivres
*/

import java.io.*;
public class FichierDeLivres  {
  private  String nomDuFichier = "Bibliotheque.dat";
  private   ObjectOutputStream fWo;
  private   ObjectInputStream fRo;
  private char mode;
	
  public boolean ouvrir(String s) {
   try {
   	mode = (s.toUpperCase()).charAt(0);
  		if (mode == 'R' || mode == 'L') 
   		fRo  = new ObjectInputStream(new FileInputStream(nomDuFichier));
  		else 	if (mode == 'W' || mode == 'E') 
    		fWo  = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
   	return true;
   }
   catch (IOException e)	{
   	return false;
  }
 }  
 public void fermer() {
  try   {
	  if (mode == 'R' || mode == 'L') fRo.close();
 	  else	if (mode == 'W' || mode == 'E')  fWo.close();
  }
  catch (IOException e)  {
   System.out.println(nomDuFichier+" : Erreur à la fermeture "); 
  }
 }
 public ListeDeLivres lire() {
   try {
   	ListeDeLivres tmp = (ListeDeLivres) fRo.readObject();
     return tmp;
   }
   catch (IOException e) { 
       System.out.println(nomDuFichier+" : Erreur  de lecture "); 
   }
   catch (ClassNotFoundException e) { 
       System.out.println(nomDuFichier+" n'est pas du bon format "); 
   }
   return null;
 }
 public void ecrire(ListeDeLivres tmp) {
  try {
    if (tmp != null)  fWo.writeObject(tmp);
  }
  catch (IOException e) {  
    System.out.println(nomDuFichier+" : Erreur en cours d'écriture "+e); 
  }
 }
}