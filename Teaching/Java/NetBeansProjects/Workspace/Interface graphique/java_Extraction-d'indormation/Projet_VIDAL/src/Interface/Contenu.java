package Interface;

import java.awt.BorderLayout;
import java.io.*;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;

class Contenu extends JFrame{// Cette classe affiche le contenu d'un fichier en entre

	private JPanel panel = new JPanel();
  private String Chemin_Fichier;// Chemin_Fichier recoit le chemin du fichier a lire
  private String Contenu_Fichier= "";
  private JTextArea Champ_Texte = new JTextArea();
  
  public Contenu(String chemin)throws IOException{// Ce constructeur ajoute un editeur de texte au panel
  	Chemin_Fichier = chemin;// Chemin_Fichier recoit le chemin du fichier a lire
    setTitle(chemin);  
    setSize(new Dimension(700, 700));//On donne une dimension a notre fenetre d'affichage
    panel.setLayout(new BorderLayout());
    Champ_Texte.setLineWrap(true);//on active le saute de ligne
    Champ_Texte.setWrapStyleWord(true);        
    panel.add(Champ_Texte);//on ajoute l'editeur de texte au panel     
    LireFichier();//on lis le fichier
    
    JScrollPane scrollPane = new JScrollPane(Champ_Texte,
    	JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
    panel.add(scrollPane);
    getContentPane().add(panel);
    setVisible (true);// On active l'affichage de la fenetre
	}

  private void LireFichier()throws IOException{//lecture du fichier
			BufferedReader lire = new BufferedReader(new InputStreamReader(new FileInputStream(Chemin_Fichier), "UTF-16"));  
      String ligne;
      while ( (ligne = lire.readLine()) != null)
      	Champ_Texte.append("\n  "+ligne);
      lire.close();
	}
}
