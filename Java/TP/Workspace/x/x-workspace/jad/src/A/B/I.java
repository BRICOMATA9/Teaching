// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.F;
import C.A.M;
import C.G.E.A.a;
import C.G.E.A.b;
import C.G.E.A.h;
import C.G.E.A.m;
import C.G.E.C;
import C.G.H;
import C.G.f;
import C.G.j;

// Referenced classes of package A.B:
//            E, O

public class I extends E
{

    public I()
    {
        E = false;
        C c = new C();
        c.P(true);
        c.G(50D);
        c.J(25D);
        c.H(25D);
        c.I(50D);
        c.X(false);
        c._(true);
        c.J((byte)1);
        a a1 = c.D5();
        a1.C(false);
        a1.E(25D);
        a1.B(25D);
        a1.A(25D);
        a1.D(10D);
        a1.C(0.25D);
        a1.A(false);
        a1.B(false);
        b b1 = c.D1();
        b1.C(Math.min(c.C9(), c.C8()));
        b1.B(0.0D);
        b1.A(0.0D);
        b1.A((byte)2);
        H h1 = (H)c.P();
        h1.G((byte)2);
        O o = new O();
        o.S(true);
        o.H(h1.e());
        o.A(o.m());
        c.B(o);
        h h2 = new h();
        h2.A(true);
        c.B(h2);
        m m1 = new m();
        m1.B((byte)0);
        m1.D(true);
        c.B(m1);
        H = c;
    }

    public void A(C.G.I i)
    {
        M m1 = i.B(A.L);
        if(m1 != null)
        {
            for(F f1 = i.H(); f1.C(); f1.B())
            {
                C.A.T t = f1.H();
                A.C.A._D _ld = (A.C.A._D)m1.D(t);
                f f2 = i.E(t);
                f2.B(f2.B() >= _ld.D() ? f2.B() : _ld.D(), f2.D() >= _ld.H() ? f2.D() : _ld.H());
            }

        }
        super.A(i);
    }

    public void C(boolean flag)
    {
        a a1 = H.D5();
        a1.C(flag);
    }

    public boolean A()
    {
        a a1 = H.D5();
        return a1.A();
    }

    public void A(byte byte0)
    {
        H h1 = (H)H.P();
        h1.G(byte0);
        O o = (O)H.Q();
        o.H(byte0);
    }

    public byte E()
    {
        H h1 = (H)H.P();
        return h1.e();
    }

    j B()
    {
        return H;
    }

    private final C H;
}
