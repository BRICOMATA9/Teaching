// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G

public class A
    implements G
{

    public A()
    {
        E3 = 1.0F;
        E2 = new Color(127, 127, 255);
        E4 = Color.BLACK;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(12F * E3);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(12F * E3);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.F);
            if(obj != null && (obj instanceof Color))
                E2 = (Color)obj;
            obj = map.get(G.R);
            if(obj != null && (obj instanceof Color))
                E4 = (Color)obj;
        }
    }

    public void A(float f)
    {
        E0 = new BasicStroke(1.0F * f);
        E3 = f;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g.create();
        graphics2d.translate(i, j);
        graphics2d.setStroke(E0);
        float f = E3 * 1.0F;
        float f1 = E3 * 1.0F;
        float f2 = E3 * 2.0F;
        float f3 = E3 * 10F;
        graphics2d.setColor(E4);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.draw(DF);
        graphics2d.setColor(E2);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.fill(DF);
        f = E3 * 4F;
        f1 = E3 * 5F;
        f2 = E3 * 2.0F;
        f3 = E3 * 2.0F;
        graphics2d.setColor(E4);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.draw(DF);
        graphics2d.setColor(E2);
        DF.setFrame(f - E3 * 1.0F, f1, f2 + E3 * 1.0F, f3);
        graphics2d.fill(DF);
        f = E3 * 9F;
        f1 = E3 * 1.0F;
        f2 = E3 * 2.0F;
        f3 = E3 * 10F;
        graphics2d.setColor(E4);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.draw(DF);
        graphics2d.setColor(E2);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.fill(DF);
        f = E3 * 6F;
        f1 = E3 * 1.0F;
        f2 = E3 * 2.0F;
        f3 = E3 * 2.0F;
        graphics2d.setColor(E4);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.draw(DF);
        graphics2d.setColor(E2);
        DF.setFrame(f, f1, f2 + E3 * 1.0F, f3);
        graphics2d.fill(DF);
        f = E3 * 6F;
        f1 = E3 * 9F;
        f2 = E3 * 2.0F;
        f3 = E3 * 2.0F;
        graphics2d.setColor(E4);
        DF.setFrame(f, f1, f2, f3);
        graphics2d.draw(DF);
        graphics2d.setColor(E2);
        DF.setFrame(f, f1, f2 + E3 * 1.0F, f3);
        graphics2d.fill(DF);
        graphics2d.dispose();
    }

    private float E3;
    private static BasicStroke E0 = new BasicStroke(1.0F);
    private Color E2;
    private Color E4;
    private static final java.awt.geom.Rectangle2D.Float DF = new java.awt.geom.Rectangle2D.Float();
    private static final java.awt.geom.Ellipse2D.Float E1 = new java.awt.geom.Ellipse2D.Float();

}
