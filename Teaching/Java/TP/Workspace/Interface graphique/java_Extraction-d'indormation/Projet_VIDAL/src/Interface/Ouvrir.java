package Interface;

import java.io.File;
import javax.swing.JFileChooser;

public class Ouvrir{// La class ouvrir permet de selectioné un fichier et afficher son contenu  
		private String path;
		private int valide =1;
		private JFileChooser fileChooser; // Cet attribut recoit le fichier selectionné 		
    public Ouvrir (Windows windows,String titre) {// Le Constructeur prend en parametre la fenetre d'accueil 
        File file = new File("./download");//On ouvre le repertoir download de l'utilisateur qui contient les fichier asspiré
        if(!file.exists()) file.mkdir();//Si un tel repertoire n'existe pas on cree ce repertoir
        
        fileChooser = new JFileChooser("./download");// On affiche le contenu du repertoir download 
        fileChooser.setDialogTitle(titre);
        
        FiltreExtensible filtre = new FiltreExtensible("DELA");
				filtre.addExtension(".dic");        
        fileChooser.addChoosableFileFilter(filtre);
        
        valide = fileChooser.showOpenDialog(windows);// ouvre une boîte de dialogue d'ouverture de fichier.
        if(valide == 0) { // Si un fichier a ete selectionné 
        		path = fileChooser.getSelectedFile().getPath();            
        }       
    }
    
    public int valide(){
    	return valide;
    }
       
    public String getpath(){
    	return path;
    }
}