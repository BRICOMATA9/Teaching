/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Modifier les modèles de présentation de l'interface
#	Fichier  : Dessin.java
#	Class    : Dessin
*/

import java.awt.*;
import javax.swing.*;
public class Dessin extends JPanel {
 private Color couleur = Color.green;
 public final static Color couleurFond = Color.white;	
 private Arbre A;
 public Dessin()	{
	setBackground(couleurFond);
	setForeground(couleur);
	setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
	A = new Arbre(8, Color.yellow);
 }
 public void paintComponent (Graphics g)  {
 	super.paintComponent(g);
 	A.dessine(g);   
 }
 public void nouveau ()  {
	A = new Arbre(8, Color.red);
  repaint();
 }  	   
}