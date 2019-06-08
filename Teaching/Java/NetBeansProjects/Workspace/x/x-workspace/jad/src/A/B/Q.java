// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.M;
import C.A.T;
import C.G.E.A.H;
import C.G.E.A.R;
import C.G.E.A.u;
import C.G.E.A.v;
import C.G.I;

class Q
    implements R
{

    Q(R r)
    {
        X = r;
    }

    public void A(I i, C.G.E.A.Q q, v v1)
    {
        if(X != null)
            X.A(i, q, v1);
    }

    public double A(I i, u u, v v1, T t, T t1)
    {
        if(t != null && t1 != null && v1.A(t).E() == 12 && v1.A(t1).E() == 13)
        {
            M m = i.B(A.L);
            if(m != null)
                return ((A.C.A._D)m.D(v1.A(t).H())).D();
            else
                return 0.0D;
        }
        if(X != null)
            return X.A(i, u, v1, t, t1);
        else
            return 0.0D;
    }

    public void B(I i, C.G.E.A.Q q, v v1)
    {
        if(X != null)
            X.B(i, q, v1);
    }

    private final R X;
}
