/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 11 : Dessiner des objets
#	Section  : Les événements
#	Fichier  : Triangle.java
#	Class    : Triangle
*/
import java.awt.*;
public class Triangle {
	private	int pX = Fenetre.LG/2-50;
	private int pY = Fenetre.HT/2-50;
	private int [] xPoints = {0, 10, -10};
	private int [] yPoints = {-10, 10, 10};
	private int nPoints = 3;
	public Triangle(int col, int lig, Graphics g, Color c) {
		for (int i = 0; i < nPoints; i++) {
			xPoints[i] = xPoints[i]+(5*lig)+pX;
			yPoints[i] = yPoints[i]+(15*col)+pY;
		}
		g.setColor(c);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}