import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class RectangleComponent extends JComponent
{
    private Color color;
    private int width;
    private int height;
    private int origWidth;
    private JLabel label;
    private Rectangle2D rectangle;
    private boolean wantLabel;
    private int xCoord;
    private int yCoord;

    public RectangleComponent(int x, int y, Color color, int width, int height, boolean wantLabel)
    {
        this.width = width;
        this.height = height;
        this.color = color;
        origWidth = width;
        xCoord = x;
        yCoord = y;
        this.wantLabel = wantLabel;
        if(wantLabel)
        {
            label = new JLabel(this.width + "/" + origWidth);
            label.setLabelFor(this);
        }
        setBounds(xCoord, yCoord, width, height);
        rectangle = new Rectangle2D.Float(xCoord, yCoord, width, height);
    }

    public RectangleComponent(int x, int y, Color color, boolean wantLabel)
    {
        width = 125;
        height = 18;
        xCoord = x;
        yCoord = y;
        this.color = color;
        origWidth = width;
        this.wantLabel = wantLabel;
        if(wantLabel)
        {
            label = new JLabel(this.width + "/" + origWidth);
            label.setLabelFor(this);
        }
        setBounds(xCoord, yCoord, width, height);
        rectangle = new Rectangle2D.Float(xCoord, yCoord, width, height);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D graphics2 = (Graphics2D) g;
        rectangle = new Rectangle2D.Float(xCoord, yCoord, width, height);
        graphics2.setPaint(color);
        graphics2.fill(rectangle);
        graphics2.draw(rectangle); 
        if(wantLabel)
            label.setText(this.width + "/" + origWidth);
    }

    public Dimension getPreferredSize()
    {
        return (new Dimension(width, height));
    }

    public void subtractLife(int amount)
    {
        width -= amount;
        if(width > 0)
        {
            rectangle.setRect(xCoord, yCoord, width, height);
            repaint();
        }
        else
            width = 0;
    }

    public void addLife(int amount)
    {
        width += amount;
        if(width < origWidth)
        {
            rectangle.setRect(xCoord, yCoord, width, height);
            repaint();
        }
        else width = origWidth;
    }
}

