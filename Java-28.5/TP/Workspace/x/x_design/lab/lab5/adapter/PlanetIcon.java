/**
 * Embarrassingly simple technique of drawing a planet.
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Color;

import javax.swing.Icon;

public class PlanetIcon implements Icon {
	private int size;
	
	public PlanetIcon(int size) {
		this.size = size;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double planet = new Ellipse2D.Double(x,y,size,size);
        
        /* Draw Mars */
		g2.setColor(Color.RED);
		g2.fill(planet);
	}

	public int getIconWidth() {
		return size;
	}

	public int getIconHeight() {
		return size;
	}
}
