// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


class H
{

    protected H()
    {
    }

    void A(int i)
    {
        B = new Object[i];
    }

    H A()
    {
        return C;
    }

    H B()
    {
        return A;
    }

    void B(H h)
    {
        C = h;
    }

    void A(H h)
    {
        A = h;
    }

    H C;
    H A;
    Object B[];
}
