/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Modifier les modèles de présentation de l'interface
#	Fichier  : Fenetre.java
#	Class    : Fenetre
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Fenetre {
public	final static int HT = 300;
public 	final static int LG = 300;
public	final static int X = 150;
public 	final static int Y = 200;
	public static void main(String [] arg) {
    		JFrame F = new JFrame("Un sapin de Noel");
		Dessin page = new Dessin();
		F.setBounds(X, Y, HT, LG);   
		F.setBackground(Color.darkGray);
		F.addWindowListener(new GestionFenetre());
    		F.getContentPane().add(page, "Center"); 
		F.getContentPane().add(new DesBoutons(page, F), "South"); 
  		
		F.setVisible(true);
	}
}