// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.E;
import C.A.M;
import C.J.DA;
import C.J.Y;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package B.B.A.C:
//            B, F, O, M

class J extends B
{

    J(E e, Y y, M m)
    {
        super(e, y, m);
    }

    J(B b, Y y)
    {
        super(b, y);
    }

    public B.B.A.C.M B(Y y)
    {
        return new J(this, y);
    }

    public double C(Y y)
    {
        return 10D;
    }

    public double A(Y y)
    {
        return 10D;
    }

    public void A(java.awt.Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        O o = F.A().B;
        o.B((d + 0.5D * d2) - 5D, d1 + 0.0D, 10D, 10D);
        o.B(y);
        o.B(J());
        o.C(I());
        B(null);
        A(null);
        super.A(graphics2d, y, d, d1, d2, d3);
        o.D(graphics2d);
        A(o.U());
        B(o.M());
    }

    protected void C(Y y, double d, double d1, double d2, 
            double d3)
    {
        double d4 = 0.0D;
        double d5 = 2D;
        for(Iterator iterator = O.iterator(); iterator.hasNext();)
        {
            DA da = (DA)iterator.next();
            d4 = Math.max(da.g(), d4);
            d5 += da.V();
        }

        double d6 = (d + 0.5D * d2) - 0.5D * d4;
        super.C(y, d6, d1 - d5, d4, d5);
    }
}
