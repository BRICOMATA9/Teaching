/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.5 
#	Fichier    : DessinerDesFormes.java
#	Class      : DessinerDesFormes
*/

import java.io.IOException;

public class DessinerDesFormes {

	public static void main(String[] args) throws IOException{

        ListeDeFormes LdF  = new ListeDeFormes();
        Fichier f = new Fichier();
    	 if(f.ouvrir("Formes.txt", "Lecture")){
	    LdF.lireLesFormes(f);
    	    LdF.dessinerLesFormes();	
	    f.fermer();
        }	

   }
}
