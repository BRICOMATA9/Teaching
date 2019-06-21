// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.B.D;
import C.J.U;
import C.J.c;

public class J extends c
{

    public J()
    {
        C9();
    }

    public J(U u)
    {
        super(u);
        if(u instanceof J)
        {
            J j = (J)u;
            if(j.B5 != null)
                B5 = (D)j.B5.clone();
            else
                C9();
        } else
        {
            C9();
        }
    }

    void C9()
    {
        B5 = new D();
    }

    public U A(U u)
    {
        return new J(u);
    }

    public D CA()
    {
        return B5;
    }

    public void A(D d)
    {
        B5 = d;
    }

    D B5;
}
