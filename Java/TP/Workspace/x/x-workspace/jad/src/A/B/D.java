// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.U;
import C.G.I;
import C.G.M;
import C.G.g;
import C.G.j;

class D extends g
{

    D()
    {
    }

    public void A(I i)
    {
        j j1 = _();
        if(j1 != null)
            j1.A(i);
        F(i);
    }

    void F(I i)
    {
        for(U u = i.M(); u.C(); u.B())
        {
            C.A.J j1 = u.I();
            M m = i.H(j1);
            C.K.M m1 = i.O(j1);
            C.K.M m2 = i.K(j1);
            int k = m.e();
            C.K.M m3;
            C.K.M m4;
            if(k == 0)
            {
                m3 = m2;
                m4 = m1;
            } else
            {
                m3 = m.B(0);
                m4 = m.B(k - 1);
            }
            if(Math.abs(m1.B() - m3.B()) < 1.0D)
                m.A(new C.K.M(m.f().B(), 0.0D));
            if(Math.abs(m4.B() - m2.B()) < 1.0D)
                m.B(new C.K.M(m.g().B(), 0.0D));
            if(Math.abs(m1.A() - m3.A()) < 1.0D)
                m.A(new C.K.M(0.0D, m.f().A()));
            if(Math.abs(m4.A() - m2.A()) < 1.0D)
                m.B(new C.K.M(0.0D, m.g().A()));
        }

    }
}
