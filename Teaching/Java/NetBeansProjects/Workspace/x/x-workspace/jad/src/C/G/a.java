// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.*;

// Referenced classes of package C.G:
//            g, I, n

public class a extends g
{

    public a()
    {
        E8 = false;
        EB = false;
        EA = 20D;
        EC = 0.10000000000000001D;
        E6 = true;
        E9 = new A();
        E5 = 10D;
    }

    public void A(I i)
    {
        E7 = i.V();
        G(i);
        D(i);
        F(i);
        A(i, E7);
        i.A(E7);
    }

    protected void A(I i, L l)
    {
        for(U u = i.M(); u.C(); u.B())
        {
            J j = u.I();
            if(l.D(j) == null)
                continue;
            A a1 = (A)l.D(j);
            if(j.H())
                C.G.n.A(i, j, a1, E5, E6, false, EA, EC);
            else
                C.G.n.A(i, j, a1, E5, E6, EB, EA, EC);
        }

    }

    protected void G(D d)
    {
        K k = d.W();
        for(F f = d.H(); f.C(); f.B())
        {
            T t = f.H();
            for(U u = E8 ? t.Z() : t.R(); u.C(); u.B())
            {
                J j = u.I();
                T t1 = j.A(t);
                J j2 = (J)k.D(t1);
                if(j2 == j)
                    continue;
                if(j2 == null)
                {
                    k.A(t1, j);
                    continue;
                }
                if(E7.D(j2) == null)
                    E7.A(j2, new A());
                A a1 = (A)E7.D(j2);
                a1.add(j);
                E9.A(j);
                d.B(j);
            }

            for(U u1 = t.R(); u1.C(); u1.B())
            {
                J j1 = u1.I();
                T t2 = j1.A(t);
                k.A(t2, null);
            }

        }

        d.A(k);
    }

    private void F(D d)
    {
        for(; !E9.isEmpty(); d.C(E9.J()));
    }

    protected A E9;
    public L E7;
    protected double E5;
    boolean E8;
    private boolean EB;
    private double EA;
    private double EC;
    private boolean E6;
}
