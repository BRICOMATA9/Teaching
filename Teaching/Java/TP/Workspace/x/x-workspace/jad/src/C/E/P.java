// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.*;

public class P
{

    public P(D d)
    {
        A = true;
        D = d;
        C = new A();
        B = new S();
    }

    public void D()
    {
        A();
        E();
    }

    public void A()
    {
        do
        {
            if(B.isEmpty())
                break;
            T t = B.P();
            if(!D.E(t))
                A(t);
        } while(true);
    }

    public void E()
    {
        do
        {
            if(C.isEmpty())
                break;
            J j = C.J();
            if(!D.A(j))
                B(j);
        } while(true);
    }

    public void B(T t)
    {
        for(J j = t.W(); j != null;)
        {
            J j2 = j;
            j = j.C();
            C.A(j2);
            if(A)
                D.B(j2);
            else
                D.E(j2);
        }

        for(J j1 = t.T(); j1 != null;)
        {
            J j3 = j1;
            j1 = j1.F();
            C.A(j3);
            if(A)
                D.B(j3);
            else
                D.E(j3);
        }

        B.A(t);
        if(A)
            D.G(t);
        else
            D.A(t);
    }

    public void A(J j)
    {
        C.A(j);
        if(A)
            D.B(j);
        else
            D.E(j);
    }

    public void A(U u)
    {
        for(; u.C(); u.B())
            A(u.I());

    }

    public D C()
    {
        return D;
    }

    protected void B(J j)
    {
        if(A)
            D.C(j);
        else
            D.G(j);
    }

    protected void A(T t)
    {
        if(A)
            D.H(t);
        else
            D.D(t);
    }

    public F B()
    {
        return B.O();
    }

    private D D;
    protected A C;
    protected S B;
    private boolean A;
}
