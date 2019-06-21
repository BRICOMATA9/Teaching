/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Les fichiers d'objets
#	Fichier  : FichierEtudiant.java
#	Class    : FichierEtudiant 
*/

import java.io.*;
 public class FichierEtudiant  {
  private ObjectOutputStream fWo;
  private ObjectInputStream fRo;
  private char mode;
  private String nomDuFichier = "Classe.dat";
  public void ouvrir(String s) throws IOException 	{
	 mode = (s.toUpperCase()).charAt(0);
	 if (mode == 'R' || mode == 'L') 
		fRo = new ObjectInputStream(new FileInputStream(nomDuFichier));
	 else 	if (mode == 'W' || mode == 'E') 
		fWo = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
  }
  public void fermer() throws IOException {
	if (mode == 'R' || mode == 'L') fRo.close();
	else	if (mode == 'W' || mode == 'E')  fWo.close();
  }
  public Classe lire() throws IOException, ClassNotFoundException  {
	Classe tmp = (Classe) fRo.readObject();
	return tmp;
  }
  public void ecrire(Classe tmp) throws IOException {
	if (tmp != null)  fWo.writeObject(tmp);
  }
}