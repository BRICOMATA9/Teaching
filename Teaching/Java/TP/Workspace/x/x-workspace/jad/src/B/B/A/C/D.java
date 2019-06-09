// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import C.J.Y;
import java.awt.*;
import java.awt.geom.RectangularShape;

// Referenced classes of package B.B.A.C:
//            M

class D
    implements M
{

    D()
    {
        H = new java.awt.geom.Rectangle2D.Double();
    }

    D(D d, Y y)
    {
        K = d.J();
        J = d.I();
        I = d.F();
        G = d.G();
        H = d.H();
    }

    public double C(Y y)
    {
        return I;
    }

    public double A(Y y)
    {
        return G;
    }

    public void A(Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        ((RectangularShape)H).setFrame(d, d1, d2, d3);
        java.awt.Paint paint = graphics2d.getPaint();
        Color color = graphics2d.getColor();
        if(K != null)
        {
            if(J != null)
                graphics2d.setPaint(new GradientPaint((float)(d + d2 / 3D), (float)d1, K, (float)(d + d2), (float)d1, J, true));
            else
                graphics2d.setColor(K);
            graphics2d.fill(H);
        }
        graphics2d.setPaint(paint);
        graphics2d.setColor(color);
    }

    public Color J()
    {
        return K;
    }

    public void B(Color color)
    {
        K = color;
    }

    public Color I()
    {
        return J;
    }

    public void A(Color color)
    {
        J = color;
    }

    public double G()
    {
        return G;
    }

    public Shape H()
    {
        return H;
    }

    public double F()
    {
        return I;
    }

    public M B(Y y)
    {
        throw new InternalError("Badly shrinked");
    }

    Color K;
    Color J;
    double I;
    double G;
    Shape H;
}
