/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Le dessin
#	Fichier  : Fenetre.java
#	Class    : Fenetre 
*/

import java.awt.*;
class Fenetre {
 public	final static int HT = 300;
 public 	final static int LG = 300;
 public static void main(String [] arg) { 
	Frame F = new Frame();
	F.setTitle("Un triangle "); 		// met le titre
	F.setSize(HT, LG);     			// taille de la fenetre
	F.setBackground(Color.gray);
	F.add(new Dessin(), "Center"); 
	F.setVisible(true);         		// affiche la fenetre
 }
}