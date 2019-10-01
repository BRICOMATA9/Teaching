/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté client : l'applet
#	Fichier  : Dessin.java
#	Class    : Dessin
*/

import java.awt.*;
public class Dessin extends Canvas {
 private Color couleur = Color.green;
 public final static Color couleurFond = Color.white;	
 private Arbre A;
 public Dessin()	{
	setBackground(couleurFond);
	setForeground(couleur);
	setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
        A = new Arbre(8, Color.red);
  }

  public void paint (Graphics g)  {
    A.dessine(g);   
  }  	   
  public void nouveau ()  {
    A = new Arbre(8, Color.red);
    repaint();
  }  	   
}