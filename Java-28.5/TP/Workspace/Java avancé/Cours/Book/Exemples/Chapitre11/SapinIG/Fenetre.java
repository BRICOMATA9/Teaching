/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les événements
#	Fichier  : Fenetre.java
#	Class    : Fenetre
*/
import java.awt.*;
import java.awt.event.*;
class Fenetre {
	public	final static int HT = 300;
	public 	final static int LG = 300;
	public static void main(String [] arg) {
		Frame F = new Frame();
		Dessin page = new Dessin();
		F.setTitle("Un sapin de Noel"); 
		F.setSize(HT, LG);   
		F.setBackground(Color.darkGray);
		F.addWindowListener(new GestionFenetre());
		F.add(page , "Center"); 
		F.add(new DesBoutons(page), "South"); 
		F.setVisible(true);
	}
}