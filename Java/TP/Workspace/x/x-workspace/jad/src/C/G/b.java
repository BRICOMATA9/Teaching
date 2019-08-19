// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.Y;
import C.K.*;

// Referenced classes of package C.G:
//            K, f, S, V

public class b
    implements K
{
    public static class _A
    {

        public void A(double d, double d1)
        {
            A = d;
            B = d1;
        }

        double A;
        double B;

        public _A(double d, double d1)
        {
            A = d;
            B = d1;
        }
    }


    public b()
    {
        J = new _A(-20D, -20D);
    }

    public Object A()
    {
        return J;
    }

    public M A(B b1, f f1, Object obj)
    {
        _A _la = (_A)obj;
        return new M(f1.C() + _la.A, f1.A() + _la.B);
    }

    public Y A(V v, f f1)
    {
        Y y = new Y();
        y.add(new S(A(((B) (v.A())), f1, J), v.A(), J, v));
        return y;
    }

    public void A(double d, double d1)
    {
        J.A(d, d1);
    }

    public Object A(G g, f f1)
    {
        return new _A(g.K - f1.C(), g.M - f1.A());
    }

    _A J;
}
