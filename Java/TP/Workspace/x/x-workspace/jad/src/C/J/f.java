// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.awt.Color;
import java.awt.Graphics2D;

// Referenced classes of package C.J:
//            U, b, J, O

public class f
{

    public void A(double d, double d1)
    {
        A = d;
        D = d1;
        B.C4();
    }

    public void B(double d, double d1)
    {
        A += d;
        D += d1;
        B.A(this, A - d, D - d1);
        B.C4();
    }

    public double A()
    {
        return A;
    }

    public double C()
    {
        return D;
    }

    public boolean B()
    {
        return C;
    }

    public void A(boolean flag)
    {
        if(flag != C)
        {
            C = flag;
            b b1 = B.C3();
            if(b1 != null)
                b1.K(this);
        }
    }

    public void A(Graphics2D graphics2d)
    {
        A(graphics2d, A, D, Color.black);
    }

    public static void A(Graphics2D graphics2d, double d, double d1, Color color)
    {
        Color color1 = graphics2d.getColor();
        java.awt.geom.Rectangle2D.Double double1 = J.A().J;
        double1.width = double1.height = 4D;
        java.awt.Stroke stroke = graphics2d.getStroke();
        graphics2d.setStroke(O.I);
        graphics2d.setColor(color);
        double1.x = d - 5D;
        double1.y = d1 - 5D;
        graphics2d.fill(double1);
        double1.x = d + 1.0D;
        double1.y = d1 + 1.0D;
        graphics2d.fill(double1);
        double1.x = d - 5D;
        double1.y = d1 + 1.0D;
        graphics2d.fill(double1);
        double1.x = d + 1.0D;
        double1.y = d1 - 5D;
        graphics2d.fill(double1);
        graphics2d.setColor(color1);
        graphics2d.setStroke(stroke);
    }

    protected f(U u, double d, double d1)
    {
        B = u;
        A = d;
        D = d1;
    }

    public String toString()
    {
        return "(" + A + ' ' + D + ')';
    }

    private U B;
    double A;
    double D;
    private boolean C;
}
