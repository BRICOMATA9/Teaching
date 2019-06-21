/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets 
#	Exercice   : 11.1 et 11.2 
#	Fichier    : Boule.java
#	Class      : Boule
*/

import java.awt.*;
public class Boule {
 	private	int centreX = Fenetre.LG/2-50;
	private int centreY = Fenetre.HT/2-50;
  private Color [] couleur = {Color.red, Color.blue, Color.yellow, Color.cyan, Color.magenta};
  public Boule(int col, int lig, Graphics g) {
		g.setColor(couleur[(int) (5*Math.random())]);
		g.fillOval(5 * lig + centreX,  15 * col - 3 + centreY , 10, 10);
	}
}