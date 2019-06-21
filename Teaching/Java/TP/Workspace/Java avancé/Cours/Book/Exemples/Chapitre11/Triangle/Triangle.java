/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Le dessin
#	Fichier  : Triangle.java
#	Class    : Triangle
*/
import java.awt.*;
public class Triangle {
	private int centreX = Fenetre.HT/2;
	private int centreY = Fenetre.LG/2;
	private int [] xPoints = {centreX, centreX+10, centreX-10};
	private int [] yPoints = {centreY-10, centreY+10, centreY+10};
	private int nPoints = 3;
	public Triangle(Graphics g) {
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}
