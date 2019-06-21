// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G, D

public class E
    implements G
{

    public E()
    {
        u = 1.0F;
        w = Color.YELLOW;
        y = w.darker();
        t = Color.BLACK;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(10F * u);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(8F * u);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.M);
            if(obj != null && (obj instanceof Color))
            {
                w = (Color)obj;
                y = w.darker();
            }
            obj = map.get(G.P);
            if(obj != null && (obj instanceof Color))
                t = (Color)obj;
        }
    }

    public void A(float f)
    {
        x = new BasicStroke(1.0F * f);
        u = f;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.translate(i, j);
        java.awt.Stroke stroke = graphics2d.getStroke();
        Color color = graphics2d.getColor();
        graphics2d.setStroke(x);
        if(D.i || graphics2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON)
            B(graphics2d);
        else
            A(graphics2d);
        graphics2d.translate(-i, -j);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(color);
    }

    private void A(Graphics2D graphics2d)
    {
        float f = u * 4F;
        float f1 = u * 5F;
        float f2 = u * 2.0F;
        float f3 = u * 7F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 6F;
        f1 = u * 8F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 6F;
        f1 = u * 8F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(y);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 6F;
        f1 = u * 10F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 6F;
        f1 = u * 10F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(y);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 4F;
        f1 = u * 5F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(w);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 4F;
        f1 = u * 6F;
        f2 = u * 1.0F;
        f3 = u * 6F;
        graphics2d.setColor(w);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        graphics2d.setColor(y);
        z.setFrame(f + u * 1.0F, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 1.0F;
        f1 = u * 1.0F;
        f2 = u * 6F;
        f3 = u * 5F;
        graphics2d.setColor(t);
        v.reset();
        v.moveTo(f + u * 3F, f1);
        v.lineTo(f + u * 5F, f1);
        v.moveTo(f + u * 2.0F, f1 + u * 1.0F);
        v.lineTo(f + u * 6F, f1 + u * 1.0F);
        v.moveTo(f + u * 1.0F, f1 + u * 2.0F);
        v.lineTo(f + u * 7F, f1 + u * 2.0F);
        v.moveTo(f + u * 0.0F, f1 + u * 3F);
        v.lineTo(f + u * 8F, f1 + u * 3F);
        v.moveTo(f + u * 1.0F, f1 + u * 4F);
        v.lineTo(f + u * 7F, f1 + u * 4F);
        v.moveTo(f + u * 2.0F, f1 + u * 5F);
        v.lineTo(f + u * 6F, f1 + u * 5F);
        v.closePath();
        graphics2d.draw(v);
        graphics2d.setColor(w);
        v.reset();
        v.moveTo(f + u * 3F, f1 + u * 1.0F);
        v.lineTo(f + u * 4F, f1 + u * 1.0F);
        v.moveTo(f + u * 2.0F, f1 + u * 2.0F);
        v.lineTo(f + u * 4F, f1 + u * 2.0F);
        v.moveTo(f + u * 1.0F, f1 + u * 3F);
        v.lineTo(f + u * 4F, f1 + u * 3F);
        v.moveTo(f + u * 2.0F, f1 + u * 4F);
        v.lineTo(f + u * 4F, f1 + u * 4F);
        v.moveTo(f + u * 3F, f1 + u * 5F);
        v.lineTo(f + u * 4F, f1 + u * 5F);
        v.closePath();
        graphics2d.draw(v);
        graphics2d.setColor(y);
        v.reset();
        v.moveTo(f + u * 5F, f1 + u * 1.0F);
        v.lineTo(f + u * 5F, f1 + u * 1.0F);
        v.moveTo(f + u * 5F, f1 + u * 2.0F);
        v.lineTo(f + u * 6F, f1 + u * 2.0F);
        v.moveTo(f + u * 5F, f1 + u * 3F);
        v.lineTo(f + u * 7F, f1 + u * 3F);
        v.moveTo(f + u * 5F, f1 + u * 4F);
        v.lineTo(f + u * 6F, f1 + u * 4F);
        v.moveTo(f + u * 5F, f1 + u * 5F);
        v.lineTo(f + u * 5F, f1 + u * 5F);
        v.closePath();
        graphics2d.draw(v);
        f = u * 4F;
        f1 = u * 3F;
        f2 = u * 2.0F;
        f3 = u * 2.0F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
    }

    private void B(Graphics2D graphics2d)
    {
        float f = u * 1.0F;
        float f1 = u * 1.0F;
        float f2 = u * 6F;
        float f3 = u * 4F;
        graphics2d.setColor(t);
        s.setFrame(f, f1, f2, f3);
        graphics2d.draw(s);
        f = u * 3F;
        f1 = u * 4F;
        f2 = u * 2.0F;
        f3 = u * 7F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 5F;
        f1 = u * 7F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 5F;
        f1 = u * 7F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(y);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 5F;
        f1 = u * 9F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(t);
        z.setFrame(f, f1, f2, f3);
        graphics2d.draw(z);
        f = u * 5F;
        f1 = u * 9F;
        f2 = u * 2.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(y);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 1.0F;
        f1 = u * 1.0F;
        f2 = u * 6F;
        f3 = u * 4F;
        graphics2d.setColor(w);
        graphics2d.fill(s);
        graphics2d.setColor(y);
        r.setFrame(f, f1, f2, f3);
        r.setAngleStart(270D);
        r.setAngleExtent(180D);
        graphics2d.fill(r);
        f = u * 3F;
        f1 = u * 4F;
        f2 = u * 1.0F;
        f3 = u * 1.0F;
        graphics2d.setColor(w);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 3F;
        f1 = u * 5F;
        f2 = u * 1.0F;
        f3 = u * 6F;
        graphics2d.setColor(w);
        z.setFrame(f, f1, f2, f3);
        graphics2d.fill(z);
        graphics2d.setColor(y);
        z.setFrame(f + u * 1.0F, f1, f2, f3);
        graphics2d.fill(z);
        f = u * 3F;
        f1 = u * 2.0F;
        f2 = u * 2.0F;
        f3 = u * 2.0F;
        graphics2d.setColor(t);
        s.setFrame(f, f1, f2, f3);
        graphics2d.fill(s);
    }

    private float u;
    private Color w;
    private Color y;
    private Color t;
    private static BasicStroke x = new BasicStroke(1.0F);
    private static final java.awt.geom.Ellipse2D.Float s = new java.awt.geom.Ellipse2D.Float();
    private static final java.awt.geom.Rectangle2D.Float z = new java.awt.geom.Rectangle2D.Float();
    private static final GeneralPath v = new GeneralPath();
    private static final java.awt.geom.Arc2D.Float r = new java.awt.geom.Arc2D.Float(1);

}
