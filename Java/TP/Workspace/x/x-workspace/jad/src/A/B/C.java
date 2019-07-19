// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.U;
import C.G.I;
import C.G.M;
import C.G.g;
import C.G.j;

class C extends g
{

    C()
    {
    }

    public void A(I i)
    {
        j j1 = _();
        if(j1 != null)
        {
            E(i);
            j1.A(i);
            E(i);
        }
    }

    public void E(I i)
    {
        for(U u = i.M(); u.C(); u.B())
        {
            C.A.J j1 = u.I();
            M m = i.H(j1);
            C.K.M m1 = m.f();
            C.K.M m2 = m.g();
            int k = m.e();
            C.K.M am[] = new C.K.M[k];
            for(int l = 0; l < k; l++)
                am[l] = m.B(l);

            i.D(j1);
            m = i.H(j1);
            m.d();
            for(int i1 = k; i1-- > 0;)
                m.E(am[i1].A, am[i1].D);

            m.B(m1);
            m.A(m2);
        }

    }
}
