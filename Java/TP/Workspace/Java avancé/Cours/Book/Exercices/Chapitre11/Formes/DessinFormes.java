/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.5 
#	Fichier    : DessinFormes.java
#	Class      : DesinFormes
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

 public int trouverLeXMin(){
	  int nbFormes = listeFormes.size();
	  int min = Forme.largeurEcran ; 
	  if (nbFormes > 0) {
		for (Forme tmp : listeFormes) {
                     if (tmp.x < min) min = tmp.x;
                     if (tmp instanceof Triangle) {
                          tmp = (Triangle) tmp;
                         int minT = tmp.trouverLeXMin();
                         if (minT < min) min = minT;
                     }
                }
           }
 	   return min;
 }
 
 public void deplacer(int Xref){
 
 	int nbFormes = listeFormes.size();
 	if (nbFormes > 0) {
 		for (Forme tmp : listeFormes) 
                           if ( tmp instanceof Triangle) {
                                tmp = (Triangle) tmp;
			        int decalageEnX = tmp.trouverLeXMin();
				tmp.deplacer(Xref - decalageEnX, 0);
                           }
                           else
                             tmp.deplacer(Xref-tmp.x,0);            
 	}
 }
 
 public void deplacerGaucheScene(){
 	deplacer(0);
 	repaint();
 	
 } 
 public void deplacerGaucheFormes(){
	  int Xmin = trouverLeXMin();
	  deplacer(Xmin);
 	repaint();
 	
 }




}