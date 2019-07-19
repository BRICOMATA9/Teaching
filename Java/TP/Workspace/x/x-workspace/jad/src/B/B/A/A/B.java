// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G

public class B
    implements G
{

    public B()
    {
        X = 1.0F;
        W = Color.YELLOW;
        S = W.darker();
        Y = Color.black;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(9F * X);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(9F * X);
    }

    public void A(Map map)
    {
        if(map != null)
        {
            Object obj = map.get(G.Q);
            if(obj != null && (obj instanceof Color))
            {
                W = (Color)obj;
                S = W.darker();
            }
            obj = map.get(G.I);
            if(obj != null && (obj instanceof Color))
                Y = (Color)obj;
        }
    }

    public void A(float f)
    {
        U = new BasicStroke(1.0F * f);
        X = f;
    }

    public void paintIcon(Component component, Graphics g, int i, int j)
    {
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.translate(i, j);
        java.awt.Stroke stroke = graphics2d.getStroke();
        Color color = graphics2d.getColor();
        graphics2d.setStroke(U);
        float f = X * 1.0F;
        float f1 = X * 1.0F;
        float f2 = X * 8F;
        float f3 = X * 8F;
        graphics2d.setColor(Y);
        T.setFrame(f, f1, f2, f3);
        graphics2d.draw(T);
        graphics2d.setColor(W);
        graphics2d.fill(T);
        f = X * 2.0F;
        f1 = X * 2.0F;
        f2 = X * 7F;
        f3 = X * 7F;
        graphics2d.setColor(S);
        T.setFrame(f, f1, f2, f3);
        graphics2d.fill(T);
        graphics2d.setColor(Y);
        V.reset();
        V.moveTo(f + X * 3F, f1 - X * 1.0F);
        V.lineTo(f + X * 3F, f1 + f3);
        V.moveTo(f - X * 1.0F, f1 + X * 3F);
        V.lineTo(f + f2, f1 + X * 3F);
        graphics2d.draw(V);
        graphics2d.translate(-i, -j);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(color);
    }

    private float X;
    private Color W;
    private Color S;
    private Color Y;
    private static BasicStroke U = new BasicStroke(1.0F);
    private static java.awt.geom.Rectangle2D.Float T = new java.awt.geom.Rectangle2D.Float();
    private static GeneralPath V = new GeneralPath();

}
