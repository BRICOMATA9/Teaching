/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté client : l'applet
#	Fichier  : Triangle.java
#	Class    : Triangle
*/

import java.awt.*;
public class Triangle {
    private	int centreX = Fenetre.LG/2;
    private int centreY = Fenetre.HT-100;
    private int [] xPoints = {centreX, centreX+10, centreX-10};
    private int [] yPoints = {centreY-10, centreY+10, centreY+10};
    private int nPoints = 3;
	
    public Triangle(int col, int lig, Graphics g, Color c) {
	      for (int i = 0; i < nPoints; i++) {
			 xPoints[i] = xPoints[i]+(5*lig);
			 yPoints[i] = yPoints[i]+(15*col);
   	      }
    	        g.setColor(c);
		g.fillPolygon(xPoints, yPoints, nPoints);
    }
}