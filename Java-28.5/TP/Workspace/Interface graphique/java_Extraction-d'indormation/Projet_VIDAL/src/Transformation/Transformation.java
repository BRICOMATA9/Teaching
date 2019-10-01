package Transformation;

import Interface.*;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;
                                 
public class Transformation{

	private String fichier_source;
	private String fichier_destination;
	
	public Transformation(Windows win){
		Ouvrir ouvrir=new Ouvrir(win,"Transformation au format DELA");
		if(ouvrir.valide()!=0) return;//si l'utilisateur a annule l'ouverture du fichier on fait rien
		fichier_source=ouvrir.getpath();//on sauvegarde le chemin du fichier a transformer 
		try{
			Enregistrer enregistrer =new Enregistrer(win,"Choisir l’emplacement d'enregistrement du fichier DELA");
			if(enregistrer.valide()!=0)return;//si l'utilisateur a annule la creation du fichier on fait rien
			fichier_destination=enregistrer.getNom();//on sauvegarde le chemin du fichier DELA
			fichier_destination+=".dic";//on ajoute l'extension .dic pour les dictionnaire 
			new Extraction(fichier_source,fichier_destination);
		}catch (IOException e) {// Si une erreur est detecte lors de la creation on affiche un message d'erreur
				new Dialogue("Impossible de creer le fichier");//on affiche un message d'erreur
		}
  }
}
