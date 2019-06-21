package Aspiration;

import Interface.*;
import javax.swing.JOptionPane;
import java.io.*;
                                 
public class Aspirateur{
	private String adresse;
	
	public Aspirateur(Windows win){ 
		adresse = JOptionPane.showInputDialog( "URL" );   		  
    while (adresse != null && adresse.equals("")) {//tant que l'utilisateur n'a pas annule la saisie et n'a pas saisie d'URL
    	new Dialogue("Vous n'avez pas saisi l'URL");//on affiche un message 
    	adresse = JOptionPane.showInputDialog( "URL" );
    }
    if(adresse == null) return;//si l'utilisateur a annule l'enregistrement on fait rien
		try{
    	Enregistrer fichier = new Enregistrer(win,"Choisir l’emplacement d'enregistrement du fichier aspire");
    	if(fichier.valide() == 0) new Telechargement(adresse, fichier.getNom()).start();
		}catch (IOException e) {// Si une erreur est detecte lors de la creation du fichier
			new Dialogue("Impossible de creer le fichier");//on affiche un message d'erreur
		}
  }
}

