// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G, D

public class I
    implements G
{

    public I()
    {
        D0 = 1.0F;
        D2 = Color.YELLOW;
        D4 = D2.darker();
        CF = Color.BLACK;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(10F * D0);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(8F * D0);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.H);
            if(obj != null && (obj instanceof Color))
            {
                D2 = (Color)obj;
                D4 = D2.darker();
            }
            obj = map.get(G.J);
            if(obj != null && (obj instanceof Color))
                CF = (Color)obj;
        }
    }

    public void A(float f)
    {
        D3 = new BasicStroke(1.0F * f);
        CD = new BasicStroke(2.0F * f);
        D0 = f;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.translate(i, j);
        java.awt.Stroke stroke = graphics2d.getStroke();
        Color color = graphics2d.getColor();
        graphics2d.setStroke(D3);
        if(D.i || graphics2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON)
            F(graphics2d);
        else
            E(graphics2d);
        graphics2d.translate(-i, -j);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(color);
    }

    private void E(Graphics2D graphics2d)
    {
        float f = D0 * 4F;
        float f1 = D0 * 3F;
        float f2 = D0 * 2.0F;
        float f3 = D0 * 1.0F;
        graphics2d.setColor(CF);
        D1.reset();
        D1.moveTo(f, f1);
        D1.lineTo(f + f2, f1);
        f = D0 * 2.0F;
        f1 = D0 * 2.0F;
        f2 = D0 * 6F;
        f3 = D0 * 2.0F;
        graphics2d.setColor(CF);
        D1.reset();
        D1.moveTo(f, f1 + f3);
        D1.lineTo(f, f1);
        D1.lineTo(f + f2, f1);
        D1.lineTo(f + f2, f1 + f3);
        D1.moveTo(f + D0 * 1.0F, f1 - D0 * 1.0F);
        D1.lineTo(f + (f2 - D0 * 1.0F), f1 - D0 * 1.0F);
        D1.moveTo(f + D0 * 2.0F, f1 - D0 * 2.0F);
        D1.lineTo(f + (f2 - D0 * 2.0F), f1 - D0 * 2.0F);
        graphics2d.draw(D1);
        f = D0 * 3F;
        f1 = D0 * 1.0F;
        f2 = D0 * 4F;
        f3 = D0 * 2.0F;
        graphics2d.setColor(D2);
        D1.reset();
        D1.moveTo(f, f1 + f3);
        D1.lineTo(f, (f1 + f3) - D0 * 1.0F);
        D1.lineTo(f + f2, (f1 + f3) - D0 * 1.0F);
        D1.lineTo(f + f2, f1 + f3);
        D1.moveTo(f + D0 * 1.0F, f1);
        D1.lineTo((f + f2) - D0 * 1.0F, f1);
        graphics2d.draw(D1);
        f = D0 * 1.0F;
        f1 = D0 * 4F;
        f2 = D0 * 8F;
        f3 = D0 * 6F;
        float f4 = D0 * 1.0F;
        graphics2d.setColor(CF);
        D5.setFrame(f, f1, f2, f3);
        graphics2d.draw(D5);
        graphics2d.setColor(D2);
        D5.setFrame(f, f1, f2, f3);
        graphics2d.fill(D5);
        graphics2d.setColor(D4);
        D5.setFrame(f + f4, f1 + f4, f2 - f4, f3 - f4);
        graphics2d.fill(D5);
        f = D0 * 4F;
        f1 = D0 * 5F;
        f2 = D0 * 2.0F;
        f3 = D0 * 4F;
        graphics2d.setColor(CF);
        D5.setFrame(f, f1 + D0 * 1.0F, f2, 0.6666667F * f3);
        graphics2d.fill(D5);
    }

    private void F(Graphics2D graphics2d)
    {
        float f = D0 * 2.0F;
        float f1 = D0 * 1.0F;
        float f2 = D0 * 6F;
        float f3 = D0 * 5F;
        graphics2d.setColor(CF);
        graphics2d.setStroke(CD);
        CC.setAngleStart(0.0D);
        CC.setAngleExtent(180D);
        CC.setFrame(f, f1, f2, f3);
        graphics2d.draw(CC);
        graphics2d.setColor(D2);
        graphics2d.setStroke(D3);
        CC.setAngleStart(0.0D);
        CC.setAngleExtent(180D);
        CC.setFrame(f, f1, f2, f3);
        graphics2d.draw(CC);
        f = D0 * 1.0F;
        f1 = D0 * 4F;
        f2 = D0 * 8F;
        f3 = D0 * 6F;
        float f4 = D0 * 1.0F;
        graphics2d.setColor(CF);
        D5.setFrame(f, f1, f2, f3);
        graphics2d.draw(D5);
        graphics2d.setColor(D2);
        D5.setFrame(f, f1, f2, f3);
        graphics2d.fill(D5);
        graphics2d.setColor(D4);
        D5.setFrame(f + f4, f1 + f4, f2 - f4, f3 - f4);
        graphics2d.fill(D5);
        f = D0 * 4F;
        f1 = D0 * 5F;
        f2 = D0 * 2.0F;
        f3 = D0 * 4F;
        graphics2d.setColor(CF);
        CE.setFrame(f, f1, f2, f3);
        graphics2d.fill(CE);
    }

    private float D0;
    private Color D2;
    private Color D4;
    private Color CF;
    private static BasicStroke D3 = new BasicStroke(1.0F);
    private static BasicStroke CD = new BasicStroke(2.0F);
    private static final GeneralPath D1 = new GeneralPath();
    private static final java.awt.geom.Rectangle2D.Float D5 = new java.awt.geom.Rectangle2D.Float();
    private static final java.awt.geom.Arc2D.Float CC = new java.awt.geom.Arc2D.Float(1);
    private static final java.awt.geom.Ellipse2D.Float CE = new java.awt.geom.Ellipse2D.Float();

}
