// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.C;

import C.A.M;
import C.J.DA;
import C.J.Y;

// Referenced classes of package B.B.A.C:
//            K, J, I, B, 
//            M, L

public class E extends K
{

    public E(B.B.B.E e, Y y, M m)
    {
        F = "iconified".equals(m.D("header.style"));
        if(F)
            A(new J(e, y, m));
        else
            A(new I(e, y, m));
    }

    protected E(E e, Y y)
    {
        super(e, y);
        F = e.F;
    }

    public B.B.A.C.M B(Y y)
    {
        return new E(this, y);
    }

    public DA D()
    {
        return ((B)A(0)).N();
    }

    public boolean E()
    {
        return F;
    }

    public void B(Y y, double d, double d1, double d2, 
            double d3)
    {
        double d4 = d1;
        int i = 0;
        for(int j = C(); i < j; i++)
        {
            B.B.A.C.M m = A(i);
            double d5 = m.A(y);
            if(i == j - 1)
                d5 = (d1 + d3) - d4;
            if(m instanceof L)
                ((L)m).C(y, d, d4, d2, d5);
            d4 += d5;
        }

    }

    final boolean F;
}
