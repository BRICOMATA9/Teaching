/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.2 et 10.5
#	Fichier    : FaireDesListesDeFormes.java
#	Class      : FaireDesListesDeFormes
*/
import java.io.IOException;
import java.util.*;
public class FaireDesListesDeFormes {

	public static void main(String[] args) throws IOException{
        Scanner lectureClavier = new Scanner(System.in);
        ListeDeFormes LdF  = new ListeDeFormes();
        Fichier f = new Fichier();
    	 if(f.ouvrir("Formes.txt", "Lecture")){
	    LdF.lireLesFormes(f);
	    f.fermer();
        }
		
		byte choix = 0;
	    do{
	    	System.out.println("1. Ajouter un cercle");
	    	System.out.println("2. Ajouter un triangle");
	    	System.out.println("3. Ajouter un rectangle");
	    	System.out.println("4. Afficher la liste");
	    	System.out.println("5. Pour sortir");
	    	System.out.print("Votre choix : ");
	    	choix = lectureClavier.nextByte();
	    	switch(choix) {
	    		case 1: LdF.ajouterUneForme('C');
	    		break;
	    		case 2: LdF.ajouterUneForme('T');
	    		break;
	    		case 3: LdF.ajouterUneForme('R');
	    		break;
	    		case 4: LdF.afficherLesFormes();
	    		break;
	    		case 5 : f.ouvrir("Formes.txt", "Ecriture");
	    			LdF.enregistrerLesFormes(f);
	    			f.fermer();
                                System.exit(0);
	    		default : System.out.println("Cette option n'existe pas");
	    	}
	    }while (choix != 5);
	}
}
