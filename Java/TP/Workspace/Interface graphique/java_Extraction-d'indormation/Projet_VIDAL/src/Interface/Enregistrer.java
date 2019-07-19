package Interface;

import java.io.*;
import javax.swing.JFileChooser;

public class Enregistrer{ //Cette classe permet de creer un fichier et lui donne un nom

		private String Nom;//cette variable contiendra le nom du fichier a creer
		private JFileChooser fileChooser;
		private int valide = 1;//On suppose que l'uttilisateur n'a pas validé son choix
		
    public Enregistrer(Windows windows,String titre) throws IOException{ 
    // Le constructeur recoit en parametre la fenetre d'accueil pour afficher la boite d'enregistrement
    		File file = new File("./download");//On ouvre le repertoir download de l'utilisateur
        if(!file.exists()) file.mkdir();//Si un tel repertoir n'existe pas on cree ce repertoir
        fileChooser = new JFileChooser("./download");// On affiche le contenu du repertoir download
        fileChooser.setDialogTitle(titre);
        valide = fileChooser.showSaveDialog(windows); //ouvre une boîte de dialogue de sauvegarde de fichier.
        if(valide == 0) {//Si l'utilisateur a validé son choix 
        		Nom = fileChooser.getSelectedFile().getPath();// on affecte le nom coisit par l'utilisateur a celui du fichier a enregistrer
        }
    }
    
    public int valide(){
    	return valide;
    }
        
     public String getNom(){ //getter du Nom
       return Nom;
     }
}
