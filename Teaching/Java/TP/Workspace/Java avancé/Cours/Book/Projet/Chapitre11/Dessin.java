/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : Dessin.java
#	Class    : Dessin
*/

import java.awt.*;

public class Dessin extends Canvas {
 private Color couleur = Color.green;
 public final static Color couleurFond = Color.white;	
	public Stat s;
	
	public Dessin(Stat s)	{
		setBackground(couleurFond);
  		setForeground(couleur);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); 
		this.s = s;
  }

  public void paint (Graphics g)  {
   	s.dessine(g);   
 }  	   


}