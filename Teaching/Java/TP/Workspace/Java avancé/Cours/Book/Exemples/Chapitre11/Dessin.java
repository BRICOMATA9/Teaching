/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les éléments de communication graphique
#	Fichier  : Dessin.java
#	Class    : Dessin 
*/

import java.awt.*;

public class Dessin extends Canvas {
 private Color couleur = Color.green;
 public final static Color couleurFond = Color.white;	
	public Dessin()	{
		setBackground(couleurFond);
  		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
}
}