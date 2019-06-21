/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les éléments de communication graphique
#	Fichier  : FenetreBouton.java
#	Class    : FenetreBouton 
*/

import java.awt.*;
class FenetreBouton {
public	final static int HT = 300;
public 	final static int LG = 300;
 public static void main(String [] arg) {
	Frame F = new Frame();
	F.setTitle("Un sapin de Noel"); // met le titre
	F.setSize(HT, LG);     		// taille de la fenetre
	F.setBackground(Color.darkGray);
	F.add(new Dessin(), "Center"); 
	F.add(new Button("Quitter"), "South"); 
	F.add(new Button("Nouveau"), "South"); 
 	F.setVisible(true);             // affiche la fenetre
 }
}