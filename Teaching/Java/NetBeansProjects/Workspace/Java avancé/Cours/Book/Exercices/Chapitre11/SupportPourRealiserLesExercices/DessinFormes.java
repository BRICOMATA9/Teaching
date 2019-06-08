/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   :  Support pour réaliser l'exercice 11.5 
#	Fichier    : DessinFormes.java
#	Class      : DessinFormes
*/


import java.awt.*;
import java.util.*;
import javax.swing.*;
public class DessinFormes extends JPanel {
 private Color couleur = Color.green;
 public final static Color couleurFond = Color.white;	
 private ArrayList<Forme> listeFormes;

 public DessinFormes(ArrayList<Forme>  liste)	{
	setBackground(couleurFond);
	setForeground(couleur);
	setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); 
        listeFormes = liste; 

 }
 public void paintComponent (Graphics g)  {
  super.paintComponent(g);
 	int nbFormes = listeFormes.size();
 	if (nbFormes > 0) {
 		for (Forme tmp : listeFormes) 
                           tmp.dessiner(g);            
 	}
  
 }





 
 

 
 public void deplacerGaucheScene(){
 	// Deplacer les formes sur le bord gauche de la scène

 	repaint();
 	
 } 
 public void deplacerGaucheFormes(){
	 // Aligner les formes sur celle se situant le plus à gauche



 	repaint();
 	
 }




}