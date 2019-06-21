import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Distance extends JPanel {
    public void paintComponent(Graphics gfx) {
	super.paintComponent(gfx);         // standard setup
	Graphics2D g = (Graphics2D) gfx;
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			   RenderingHints.VALUE_ANTIALIAS_ON);
	
	Point2D.Double p1 = new Point2D.Double(100, 100);
	Point2D.Double p2 = new Point2D.Double(200, 150);

	// define the elements we will draw
	Line2D.Double line = new Line2D.Double(p1, p2);
	double r1 = 40;  double r2 = 20;
	Ellipse2D.Double circle1 = 
	    new Ellipse2D.Double(p1.x - r1, p1.y - r1, 2*r1, 2*r1);
	Ellipse2D.Double circle2 = 
	    new Ellipse2D.Double(p2.x - r2, p2.y - r2, 2*r2, 2*r2);

	// draw line
	g.setPaint(Color.black);
	g.draw(line);

	// fill circles
	g.setPaint(new Color(0.2f, 0.2f, 0.8f));
	g.fill(circle1);  g.fill(circle2);

	// draw circles
	g.setPaint(Color.black);
	g.draw(circle1);  g.draw(circle2);
    }

    public static void main(String[] args) {
	Distance distance = new Distance();
	distance.setBackground(Color.white);
	distance.setPreferredSize(new Dimension(250, 250));
	JFrame frame = new JFrame("Distance");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().add(distance);
	frame.pack();
	frame.setVisible(true);
    }
}

	
