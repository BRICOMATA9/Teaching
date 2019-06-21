// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import B.B.A.B;
import C.A.M;
import C.J.Y;
import java.awt.Color;
import java.awt.Graphics2D;

// Referenced classes of package B.B.A.C:
//            D, A, C, M, 
//            F, O

class H extends D
{

    H(A a, M m)
    {
        B((Color)m.D("section.fill.color"));
        A((Color)m.D("section.gradient.color"));
        N = a;
        M = A(m.D("separator.style"));
        L = !"soft".equals(m.D("shadow.style"));
    }

    H(H h, Y y)
    {
        super(h, y);
        N = (A)h.N.B(y);
        M = h.M;
        L = h.L;
    }

    A K()
    {
        return N;
    }

    public B.B.A.C.M B(Y y)
    {
        return new H(this, y);
    }

    public double A(Y y)
    {
        B.B.A.C.M m = ((B)y).F3().B();
        return Math.max(20D, y.D() - m.A(y));
    }

    public void A(Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        O o = F.A().B;
        o.B(d, d1, d2, d3);
        o.B(y);
        o.B(J());
        o.C(I());
        if(1 == M && 1 == o.E3())
        {
            byte byte0 = N.M();
            if(0 == byte0)
                o.E(12);
            else
            if(N.C(y) < d2)
                switch(byte0)
                {
                case 1: // '\001'
                    o.E(8);
                    break;

                case 4: // '\004'
                    o.E(4);
                    break;
                }
            else
                o.E(12);
        }
        if(L)
            o.M(graphics2d);
        o.N(graphics2d);
        o.O(graphics2d);
    }

    private static byte A(Object obj)
    {
        if(obj instanceof String)
        {
            String s = ((String)obj).toLowerCase();
            if("dynamic".equals(s))
                return 1;
        }
        return 0;
    }

    private final A N;
    private byte M;
    private final boolean L;
}
