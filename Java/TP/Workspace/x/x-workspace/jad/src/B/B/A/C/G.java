// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import C.J.Y;
import java.awt.*;
import java.awt.geom.Line2D;

// Referenced classes of package B.B.A.C:
//            M, F

public class G
    implements M
{

    public G(Color color)
    {
        D = color;
    }

    public double C(Y y)
    {
        return y.B();
    }

    public double A(Y y)
    {
        return 1.0D;
    }

    public void A(Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        if(D != null)
        {
            Line2D line2d = F.A().C;
            line2d.setLine(d, d1, d + y.B(), d1);
            Color color = graphics2d.getColor();
            Stroke stroke = graphics2d.getStroke();
            graphics2d.setColor(D);
            graphics2d.setStroke(C);
            graphics2d.draw(line2d);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(color);
        }
    }

    public M B(Y y)
    {
        return new G(D);
    }

    static final Stroke C = new BasicStroke(1.0F);
    Color D;

}
