// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.A;

import C.B.D;
import C.G.P;
import C.G.j;
import C.J.A.H;
import C.J.b;

public abstract class B extends D
{

    protected B(String s)
    {
        super(s, "yDoc Development Team", "");
    }

    public abstract j O();

    public void A(b b1)
    {
        B(b1);
        G();
    }

    protected void D()
    {
        b b1;
        H h;
        b1 = B();
        h = new H(b1);
        h.E();
        A(O());
        h.F();
        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        h.F();
        throw exception;
        b1.c();
        return;
    }

    protected void A(j j1, boolean flag)
    {
        b b1 = B();
        if(flag)
            (new P(j1)).A(b1);
        else
            j1.A(b1);
    }

    static int A(byte abyte0[], byte byte0)
    {
        for(int i = 0; i < abyte0.length; i++)
            if(abyte0[i] == byte0)
                return i;

        return 0;
    }
}
