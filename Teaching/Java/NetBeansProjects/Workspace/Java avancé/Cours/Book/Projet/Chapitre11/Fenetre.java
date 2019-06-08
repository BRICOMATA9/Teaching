/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Projet  - Les types utilisés dans cette applications sont définis dans le répertoire commun
#	Fichier  : Fenetre.java
#	Class    : Fenetre
*/

import java.awt.*;
class Fenetre extends Frame {
  public	final static int HT = 300;
  public 	final static int LG = 300;
  public Fenetre(Stat s)  {
	setTitle("Les statistiques du compte " ); 
	setSize(HT, LG);    
	setBackground(Color.darkGray);
	addWindowListener(new GestionQuitter());
	// La zone de dessin
	Dessin page = new Dessin(s);
	add(page , "Center"); 
	// Le bouton quitter
	Button bQuitter = new Button ("Quitter");
	bQuitter.addActionListener(new GestionQuitter());
	add(bQuitter, "South");
	setVisible(true); 
  }
}