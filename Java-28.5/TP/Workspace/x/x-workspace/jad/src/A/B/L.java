// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.F;
import C.A.U;
import C.G.I;
import C.G.M;
import C.G.f;
import C.G.g;
import C.G.j;
import java.awt.Rectangle;

class L extends g
{

    L()
    {
    }

    public void A(I i)
    {
        j j1 = _();
        if(j1 != null)
            j1.A(i);
        G(i);
    }

    private void G(I i)
    {
        Rectangle rectangle = i.X();
        double d = -rectangle.getX();
        double d1 = -rectangle.getY();
        for(F f1 = i.H(); f1.C(); f1.B())
        {
            f f2 = i.E(f1.H());
            f2.A(f2.C() + d, f2.A() + d1);
        }

        for(U u = i.M(); u.C(); u.B())
        {
            M m = i.H(u.I());
            int k = 0;
            for(int l = m.e(); k < l; k++)
            {
                C.K.M m1 = m.B(k);
                m.A(k, m1.A + d, m1.D + d1);
            }

        }

    }
}
