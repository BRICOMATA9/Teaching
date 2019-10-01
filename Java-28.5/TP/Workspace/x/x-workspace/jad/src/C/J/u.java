// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.J;
import C.A.T;

// Referenced classes of package C.J:
//            U, b

class u extends J
{

    protected u(b b, T t, J j, T t1, J j1, int i, int k, 
            U u1)
    {
        super(b, t, j, t1, j1, i, k);
        if(u1 != null)
        {
            L = u1;
            u1.A(this);
        }
    }

    protected void D()
    {
        super.D();
        if(L != null)
            L.C4();
    }

    U L;
}
