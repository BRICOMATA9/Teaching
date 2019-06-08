/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.2 et 10.5 
#	Fichier    : ListeDeForme.java
#	Class      : ListeDeForme
*/
import java.util.*;
import java.io.IOException;

public class ListeDeFormes  {
 private ArrayList<Forme> listeFormes;

 public ListeDeFormes()	{
  listeFormes = new ArrayList<Forme>();  
 }
 
 public void ajouterUneForme(char type)  {
  if (type == 'C') {
  	  listeFormes.add(new Cercle());
  }
  else if(type == 'T'){
  	listeFormes.add(new Triangle());
  }
  else {
  	listeFormes.add(new Rectangle());
  }
 }

 
 public void afficherLesFormes() {
 	int nbFormes = listeFormes.size();
 	if (nbFormes > 0) {
 		for (Forme tmp : listeFormes) tmp.afficher();
 	}
 	else {
 		System.out.print("Il n'y a pas de forme dans cette liste ");
 	}
 }


public void enregistrerLesFormes(Fichier f)throws IOException {
	int nbFormes = listeFormes.size();
 	if (nbFormes > 0) {
           String chaine = "";
 	   for (Forme tmp : listeFormes)  {
                  tmp.afficher();
 		  chaine = tmp.getInfos();
 		  if (chaine != null)  f.ecrire(chaine);	
 	    }
 	}
  } 

public void lireLesFormes(Fichier f) throws IOException
 {
 
    String chaine;
    String [] mot = {"", "","", "", "","","",""};
    char tt;
    int cc, xx0, yy0, xx1, yy1, xx2, yy2, ll, hh, rr; 
    do {
      mot = f.lire(); 
      if (mot != null) {
        tt = mot[0].charAt(0); 
        if ( tt == 'C') {
      	  cc = Integer.parseInt(mot[1]); 
      	  xx0 = Integer.parseInt(mot[2]); 
          yy0 = Integer.parseInt(mot[3]); 
          rr = Integer.parseInt(mot[4]); 
          listeFormes.add(new Cercle( xx0, yy0, rr, cc));
        }
        else if (tt == 'T'){
    	  cc = Integer.parseInt(mot[1]); 
      	  xx0 = Integer.parseInt(mot[2]); 
          yy0 = Integer.parseInt(mot[3]); 
          xx1 = Integer.parseInt(mot[4]); 
          yy1 = Integer.parseInt(mot[5]); 
          xx2 = Integer.parseInt(mot[6]); 
          yy2 = Integer.parseInt(mot[7]);     	  
          listeFormes.add(new Triangle( xx0, yy0, xx1, yy1, xx2, yy2, cc));
        }
       else  if( tt == 'R') {
   	  cc = Integer.parseInt(mot[1]); 
      	  xx0 = Integer.parseInt(mot[2]); 
          yy0 = Integer.parseInt(mot[3]); 
          ll = Integer.parseInt(mot[4]); 
          hh = Integer.parseInt(mot[5]); 
      	  listeFormes.add(new Rectangle( xx0, yy0, ll, hh, cc));

       }
      }
    } while (mot != null);
 }
}

