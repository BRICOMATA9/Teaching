// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import C.J.Y;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package B.B.A.C:
//            M

class K
    implements M
{

    K()
    {
        E = new ArrayList();
    }

    K(K k, Y y)
    {
        int i = k.E.size();
        E = new ArrayList(i);
        for(int j = 0; j < i; j++)
            E.add(k.A(j).B(y));

    }

    public void A(java.awt.Graphics2D graphics2d, Y y, double d, double d1, double d2, double d3)
    {
        double d4 = d1;
        int i = 0;
        for(int j = E.size(); i < j; i++)
        {
            M m = A(i);
            double d5 = m.A(y);
            if(i == j - 1)
                d5 = (d1 + d3) - d4;
            m.A(graphics2d, y, d, d4, d2, d5);
            d4 += d5;
        }

    }

    public double A(Y y)
    {
        double d = 0.0D;
        int i = 0;
        for(int j = E.size(); i < j; i++)
            d += A(i).A(y);

        return d;
    }

    public double C(Y y)
    {
        double d = 0.0D;
        int i = 0;
        for(int j = E.size(); i < j; i++)
            d = Math.max(d, A(i).C(y));

        return d;
    }

    public M B(Y y)
    {
        throw new InternalError("Badly shrinked");
    }

    public boolean A(M m)
    {
        return E.add(m);
    }

    public M A(int i)
    {
        return (M)E.get(i);
    }

    public int C()
    {
        return E.size();
    }

    private final List E;
}
