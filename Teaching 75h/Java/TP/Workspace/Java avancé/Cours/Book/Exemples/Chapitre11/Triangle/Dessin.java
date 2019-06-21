/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Le dessin
#	Fichier  : Dessin.java
#	Class    : Dessin
*/

import java.awt.*; 
public class Dessin extends Canvas {
 private Color couleur = Color.green;
 public Dessin()	{
	setBackground(Color.white);
	setForeground(couleur);
	setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
 }
 public void paint (Graphics g)  {
	new Triangle(g);
 } 
}