// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G, D

public class H
    implements G
{

    public H()
    {
        CB = 1.0F;
        C4 = false;
        C9 = new Color(127, 127, 255);
        C5 = C9.darker().darker();
        CA = Color.WHITE;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(10F * CB);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(10F * CB);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.O);
            if(obj != null && (obj instanceof Color))
                C9 = (Color)obj;
            obj = map.get(G.N);
            if(obj != null && (obj instanceof Color))
                C5 = (Color)obj;
            obj = map.get(G.B);
            if(obj != null && (obj instanceof Color))
                CA = (Color)obj;
        }
    }

    public void A(float f)
    {
        C7 = new BasicStroke(1.0F * f);
        CB = f;
    }

    public void C(boolean flag)
    {
        C4 = flag;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        java.awt.Stroke stroke = graphics2d.getStroke();
        Color color = graphics2d.getColor();
        graphics2d.translate(i, j);
        graphics2d.setStroke(C7);
        if(D.i || graphics2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON)
            D(graphics2d);
        else
            C(graphics2d);
        graphics2d.setColor(color);
        graphics2d.setStroke(stroke);
        graphics2d.translate(-i, -j);
    }

    private void C(Graphics2D graphics2d)
    {
        float f = CB * 0.0F;
        float f1 = CB * 0.0F;
        float f2 = CB * 10F;
        float f3 = CB * 10F;
        float f4 = CB * 1.0F;
        if(C4)
            graphics2d.setColor(C5);
        else
            graphics2d.setColor(C9);
        C8.setFrame(f, f1, f2, f3);
        graphics2d.fill(C8);
    }

    private void D(Graphics2D graphics2d)
    {
        float f = CB * 0.0F;
        float f1 = CB * 0.0F;
        float f2 = CB * 10F;
        float f3 = CB * 10F;
        float f4 = CB * 1.0F;
        if(C4)
            graphics2d.setColor(C5);
        else
            graphics2d.setColor(C9);
        C8.setFrame(f, f1, f2, f3);
        graphics2d.fill(C8);
        graphics2d.setColor(CA);
        C6.setFrame(f + f4, f1 + f4, f2 - f4, f3 - f4);
        C6.setAngleStart(112.5D);
        C6.setAngleExtent(45D);
        graphics2d.draw(C6);
    }

    private float CB;
    private boolean C4;
    private Color C9;
    private Color C5;
    private Color CA;
    private static BasicStroke C7 = new BasicStroke(1.0F);
    private static final java.awt.geom.Ellipse2D.Float C8 = new java.awt.geom.Ellipse2D.Float();
    private static final java.awt.geom.Arc2D.Float C6 = new java.awt.geom.Arc2D.Float(1);

}
