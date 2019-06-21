// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.B.F;
import C.A.M;
import C.J.DA;
import C.J.Y;
import java.awt.Graphics2D;

// Referenced classes of package B.B.A.C:
//            M, A, H

public class C
    implements B.B.A.C.M
{

    public C(F f, Y y, M m)
    {
        B = new A(f, y, m);
        A = new H(B, m);
    }

    C(C c, Y y)
    {
        A = (H)c.A.B(y);
        B = A.K();
    }

    public DA A()
    {
        return B.B(0);
    }

    public B.B.A.C.M B()
    {
        return B;
    }

    public B.B.A.C.M B(Y y)
    {
        return new C(this, y);
    }

    public double C(Y y)
    {
        double d = 0.0D;
        d = Math.max(d, B.C(y));
        d = Math.max(d, A.C(y));
        return d;
    }

    public double A(Y y)
    {
        double d = 0.0D;
        d += B.A(y);
        d += A.A(y);
        return d;
    }

    public void A(Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        double d4 = d1;
        double d5 = B.A(y);
        B.A(graphics2d, y, d, d4, d2, d5);
        d4 += d5;
        d5 = (d1 + d3) - d4;
        A.A(graphics2d, y, d, d4, d2, d5);
    }

    public void A(Y y, double d, double d1, double d2, 
            double d3)
    {
        B.C(y, d, d1, d2, d3);
    }

    private final A B;
    private final H A;
}
