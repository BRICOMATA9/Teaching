// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.Y;
import C.K.*;

// Referenced classes of package C.G:
//            Z, M, f, D, 
//            l

public class x
    implements Z
{
    public static class _A
    {

        public String toString()
        {
            return getClass() + " radius=" + A + "  theta(deg)=" + C.K.A.A(B);
        }

        double A;
        double B;

        public _A(double d, double d1)
        {
            A = d;
            B = d1;
        }
    }


    public x()
    {
    }

    public Object A()
    {
        return new _A(20D, 20D);
    }

    public Object A(G g, C.G.M m, f f1, f f2)
    {
        M m1 = m.f();
        m1 = new M(m1.B() + f1.C() + f1.B() / 2D, m1.A() + f1.A() + f1.D() / 2D);
        M m2;
        if(m.e() == 0)
        {
            m2 = m.g();
            m2 = new M(m2.B() + f2.C() + f2.B() / 2D, m2.A() + f2.A() + f2.D() / 2D);
        } else
        {
            m2 = m.B(0);
        }
        double d = A(m1, m2);
        M m3 = new M(g.T() + g.Q() / 2D, g.U() + g.R() / 2D);
        double d1 = A(m1, m3);
        double d2 = d1 - d;
        double d3 = m3.B() - m1.B();
        double d4 = m3.A() - m1.A();
        double d5 = d3 == 0.0D && d4 == 0.0D ? 0.0D : Math.sqrt(d3 * d3 + d4 * d4);
        Object obj = A(d5, d2);
        return obj;
    }

    private Object A(double d, double d1)
    {
        return new _A(d, d1);
    }

    private double A(M m, M m1)
    {
        double d = m1.B() - m.B();
        double d1 = m1.A() - m.A();
        double d2 = d == 0.0D && d1 == 0.0D ? 0.0D : Math.atan2(d1, d);
        return d2;
    }

    public M A(B b, C.G.M m, f f1, f f2, Object obj)
    {
        M m1 = m.f();
        m1 = new M(m1.B() + f1.C() + f1.B() / 2D, m1.A() + f1.A() + f1.D() / 2D);
        M m2;
        if(m.e() == 0)
        {
            m2 = m.g();
            m2 = new M(m2.B() + f2.C() + f2.B() / 2D, m2.A() + f2.A() + f2.D() / 2D);
        } else
        {
            m2 = m.B(0);
        }
        double d = A(m1, m2);
        _A _la = obj == null ? (_A)A() : (_A)obj;
        double d1 = d + _la.B;
        double d2 = Math.cos(d1);
        double d3 = Math.sin(d1);
        M m3 = new M((m1.B() + d2 * _la.A) - b.Q() / 2D, (m1.A() + d3 * _la.A) - b.R() / 2D);
        return m3;
    }

    public Y A(D d, C.G.M m, f f1, f f2)
    {
        G g = d.A();
        Y y = new Y();
        y.add(new l(g.S(), g, d.B(), d));
        return y;
    }
}
