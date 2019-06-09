// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.D;
import C.A.T;
import C.G.E.A.K;
import C.G.E.A.a;
import C.G.E.A.b;
import C.G.E.A.h;
import C.G.E.C;
import C.G.H;
import C.G.I;
import C.G.j;
import java.util.Comparator;

// Referenced classes of package A.B:
//            E, P, F, H, 
//            B, Q, J

public class M extends E
{
    private static final class _A
        implements Comparator
    {

        void A(boolean flag)
        {
            A = flag;
        }

        public int compare(Object obj, Object obj1)
        {
            T t = A ? (T)obj1 : (T)obj;
            T t1 = A ? (T)obj : (T)obj1;
            Object obj2 = A.L;
            C.A.M m = t._().B(obj2);
            A.C.A._D _ld = m == null ? null : (A.C.A._D)m.D(t);
            A.C.A._A _la = _ld == null ? null : _ld.A();
            A.C.A._D _ld1 = m == null ? null : (A.C.A._D)m.D(t1);
            A.C.A._A _la1 = _ld1 == null ? null : _ld1.A();
            if(_la == _la1)
            {
                String s = _ld == null ? null : _ld.E();
                String s1 = _ld1 == null ? null : _ld1.E();
                if(_ld != null && _ld1 != null)
                    return s.compareTo(s1);
                if(_ld != null)
                    return 1;
                return _ld1 == null ? 0 : -1;
            }
            byte byte0 = 0;
            if(_la == A.O)
                byte0 = 3;
            if(_la == A.Q)
                byte0 = 2;
            else
            if(_la == A.B)
                byte0 = 1;
            byte byte1 = 0;
            if(_la1 == A.O)
                byte1 = 3;
            if(_la1 == A.Q)
                byte1 = 2;
            else
            if(_la1 == A.B)
                byte1 = 1;
            return byte1 - byte0;
        }

        private boolean A;

        _A()
        {
            this(false);
        }

        _A(boolean flag)
        {
            A = flag;
        }
    }


    public M()
    {
        boolean flag = false;
        C c = new C();
        c.P(false);
        c.G(30D);
        c.J(15D);
        c.H(15D);
        c.I(30D);
        c.X(false);
        c._(true);
        c.Z(false);
        c.Y(false);
        c.I((byte)18);
        h h1 = new h();
        h1.A(true);
        h1.A(1);
        c.B(new P(h1));
        c.J((byte)1);
        F f = new F(c.C7());
        f.B(false);
        f.A(new _A());
        c.B(f);
        A.B.H h2 = new A.B.H(new B(c.D8()));
        h2.A(true);
        h2.A(new _A(true));
        c.B(h2);
        a a1 = c.D5();
        a1.C(true);
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
        H h3 = (H)c.P();
        h3.G((byte)1);
        K k = c.CD();
        k.A(new Q(k.AA()));
        J = c;
    }

    public void A(I i)
    {
        boolean flag = false;
        if(i.B(I) == null)
        {
            final C.A.M edgeInfos = i.B(A.D);
            if(edgeInfos != null)
            {
                C.E.T t = new C.E.T() {

                    public double C(Object obj)
                    {
                        A.C.A._F _lf = (A.C.A._F)edgeInfos.D(obj);
                        if(_lf != null)
                            return (double)_lf.A();
                        else
                            return 1.0D;
                    }

                };
                i.A(I, t);
                flag = true;
            }
        }
        super.A(i);
        if(flag)
            i.D(I);
    }

    public void F(boolean flag)
    {
        a a1 = J.D5();
        a1.C(flag);
    }

    public boolean A()
    {
        a a1 = J.D5();
        return a1.A();
    }

    public void B(byte byte0)
    {
        H h1 = (H)J.P();
        h1.G(byte0);
    }

    public byte F()
    {
        H h1 = (H)J.P();
        return h1.e();
    }

    public void J(boolean flag)
    {
        A.B.H h1 = (A.B.H)J.D8();
        h1.A(flag);
        P p = (P)J.CB();
        p.B(flag);
    }

    public void E(boolean flag)
    {
        A.B.H h1 = (A.B.H)J.D8();
        _A _la = (_A)h1.A();
        _la.A(flag);
    }

    public void G(boolean flag)
    {
        F f = (F)J.C7();
        _A _la = (_A)f.B();
        _la.A(flag);
    }

    public void I(boolean flag)
    {
        F f = (F)J.C7();
        f.A(flag);
    }

    public void H(boolean flag)
    {
        P p = (P)J.CB();
        h h1 = (h)p.Q;
        if(flag)
            h1.A(1);
        else
            h1.A(0);
    }

    public boolean H()
    {
        P p = (P)J.CB();
        h h1 = (h)p.Q;
        return h1.A() == 1;
    }

    public void D(boolean flag)
    {
        J.Z(flag);
        F f = (F)J.C7();
        f.B(flag);
    }

    public boolean G()
    {
        return J.CE();
    }

    public void C(byte byte0)
    {
        F f = (F)J.C7();
        f.A(byte0);
    }

    public byte I()
    {
        F f = (F)J.C7();
        return f.A();
    }

    j B()
    {
        return J;
    }

    private static final Object I;
    private final C J;

    static 
    {
        I = A.B.J.D;
    }
}
