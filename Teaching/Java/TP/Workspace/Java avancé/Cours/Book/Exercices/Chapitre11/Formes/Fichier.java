/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.5 
#	Fichier    : Fichier.java
#	Class      : Fichier
*/


import java.io.*;
import java.util.*;
public class Fichier {
 private   BufferedWriter fW;
 private   BufferedReader fR;
 private char mode;  
 public boolean ouvrir(String nomDuFichier, String s) throws IOException{
   try {
        mode = (s.toUpperCase()).charAt(0);
	File f = new File(nomDuFichier);
	if (mode == 'R' || mode == 'L') 
		fR  = new BufferedReader(new FileReader(f));
	else 	if (mode == 'W' || mode == 'E') 
		fW = new BufferedWriter(new FileWriter(f)); 
        return true;
    } 
    catch (IOException e)	{
   	return false;
    }
 }


 public void fermer() throws IOException {
	if (mode == 'R' || mode == 'L') fR.close();
	else 	if (mode == 'W' || mode == 'E')	 fW.close();
 }
 
 public String [] lire() throws IOException {
    String ligne;
    ligne = fR.readLine();
    if (ligne != null) {
      StringTokenizer st = new StringTokenizer(ligne,";");
      int i=0;
      String mot[] = new String[st.countTokens()];
      while (st.hasMoreTokens()) {
         mot[i] = st.nextToken();
         i++;
       }
       return mot;
     }
     else return null; 
 }
 
 
 public void ecrire(String chaine) throws IOException {
 	System.out.println("chaine = " +chaine);
	fW.write(chaine,0,chaine.length());
	fW.newLine();
  }
 

}