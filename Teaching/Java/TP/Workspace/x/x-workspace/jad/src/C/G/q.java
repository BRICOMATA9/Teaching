// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.I;
import C.A.Y;
import C.K.M;

// Referenced classes of package C.G:
//            t

class q
{

    public static t A(Y y, M m)
    {
        double d = 1.7976931348623157E+308D;
        t t1 = null;
        for(I i = y.B(); i.C(); i.B())
        {
            t t2 = (t)i.D();
            double d1 = M.B(m, t2.I());
            if(d1 < d)
            {
                d = d1;
                t1 = t2;
            }
        }

        return t1;
    }
}
