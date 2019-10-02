// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.*;
import C.G.E.A.*;
import C.G.I;
import C.G.f;
import java.util.*;

class A
    implements O
{
    private static final class _A
    {

        final T B;
        final S H;
        int C;
        int E;
        double D;
        double A;
        double G;
        final boolean F;

        _A(T t)
        {
            this(t, false);
        }

        _A(T t, boolean flag)
        {
            B = t;
            C = 0x7fffffff;
            E = 0x80000000;
            H = new S();
            D = 0.0D;
            A = 0.0D;
            G = 1.0D;
            F = flag;
        }
    }


    public A(O o)
    {
        U = o;
        T = null;
        V = false;
        X = false;
        S = false;
        R = true;
    }

    public Comparator G()
    {
        return T;
    }

    public void B(Comparator comparator)
    {
        T = comparator;
    }

    public void E(boolean flag)
    {
        V = flag;
    }

    public boolean F()
    {
        return R;
    }

    public void D(boolean flag)
    {
        R = flag;
    }

    public void A(I j, Q q, v v)
    {
        if(U == null)
            return;
        M m = j.B(W);
        if(m == null)
            U.A(j, q, v);
        else
            A(j, q, v, m);
    }

    private void A(I j, Q q, v v, M m)
    {
        i k = null;
        M m1 = j.B("groupingSupport");
        if(m1 != null)
        {
            k = (i)m1.D(j);
            if(k != null && !k.I())
                k = null;
        }
        S s = new S();
        for(F f1 = j.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            if(m.A(t) == 0 && (k == null || !k.B(t)))
            {
                j.G(t);
                s.add(t);
            }
        }

        U.A(j, q, v);
        if(s.isEmpty())
            return;
        if(F())
            A(j, q, s);
        else
            A(j, q, k, s);
    }

    private void A(I j, Q q, S s)
    {
        _A _la = new _A(null, true);
        _la.C = 0;
        _la.E = q.B() - 1;
        for(F f1 = s.O(); f1.C(); f1.B())
        {
            T t = f1.H();
            j.H(t);
            _la.H.add(t);
            f f2 = j.E(t);
            double d = f2.B();
            double d1 = f2.D();
            _la.D += d;
            _la.A += d1;
            if(d1 != 0.0D && _la.G < d / d1)
                _la.G = d / d1;
        }

        A(j, q, _la);
    }

    private void A(I j, Q q, i k, S s)
    {
        Object obj = new Object();
        HashMap hashmap = new HashMap();
        int l = 0;
        for(int i1 = q.B(); l < i1; l++)
        {
            u u1 = q.B(l);
            for(F f2 = u1.A().O(); f2.C(); f2.B())
            {
                T t2 = k == null ? null : k.C(f2.H());
                Object obj2 = t2 == null ? obj : ((Object) (t2));
                _A _la = (_A)hashmap.get(obj2);
                if(_la == null)
                {
                    _la = new _A(t2);
                    hashmap.put(obj2, _la);
                }
                if(_la.C > l)
                    _la.C = l;
                if(_la.E < l)
                    _la.E = l;
            }

        }

        for(F f1 = s.O(); f1.C(); f1.B())
        {
            T t = f1.H();
            j.H(t);
            T t1 = k == null ? null : k.C(t);
            Object obj1 = t1 == null ? obj : ((Object) (t1));
            _A _la1 = (_A)hashmap.get(obj1);
            if(_la1 == null)
            {
                _la1 = new _A(t1);
                hashmap.put(obj1, _la1);
            }
            _la1.H.add(t);
            f f3 = j.E(t);
            double d = f3.B();
            double d1 = f3.D();
            _la1.D += d;
            _la1.A += d1;
            if(d1 != 0.0D && _la1.G < d / d1)
                _la1.G = d / d1;
        }

        for(Iterator iterator = hashmap.values().iterator(); iterator.hasNext();)
        {
            _A _la2 = (_A)iterator.next();
            if(_la2.H.isEmpty())
                iterator.remove();
            else
                A(j, q, _la2);
        }

    }

    private void A(I j, Q q, _A _pa)
    {
        if(_pa.C > _pa.E)
        {
            _pa.C = 0;
            _pa.E = 0;
        }
        if(_pa.D < 1.0D)
            _pa.D = 1.0D;
        if(_pa.A < 1.0D)
            _pa.A = 1.0D;
        if(T != null)
            _pa.H.A(T);
        int k = 0;
        int l = 0;
        int i1 = _pa.C;
        for(int l1 = q.B(); i1 < l1; i1++)
        {
            u u1 = q.B(i1);
            if(u1.D() != 0)
                continue;
            k++;
            int j3 = u1.A().size();
            if(l < j3)
                l = j3;
        }

        if(!S && k > 0)
        {
            int j1 = _pa.H.size();
            if(j1 > k)
            {
                if(!V)
                {
                    int i2 = j1 % k;
                    int k3 = j1 / k;
                    F f4 = _pa.H.O();
                    int l4 = _pa.C;
                    for(int i6 = q.B(); f4.C() && l4 < i6; l4++)
                    {
                        u u2 = q.B(l4);
                        if(u2.D() == 0)
                        {
                            for(int k6 = 0; k6 < k3; k6++)
                            {
                                u2.A(f4.H());
                                f4.B();
                            }

                            if(i2 > 0)
                            {
                                u2.A(f4.H());
                                f4.B();
                                i2--;
                            }
                        }
                    }

                } else
                {
                    double d = _pa.D / (double)k;
                    F f5 = _pa.H.O();
                    int i5 = _pa.C;
                    for(int j6 = q.B(); f5.C() && i5 < j6; i5++)
                    {
                        u u3 = q.B(i5);
                        if(u3.D() != 0)
                            continue;
                        for(double d1 = 0.0D; f5.C() && d1 < d; f5.B())
                        {
                            T t = f5.H();
                            u3.A(t);
                            d1 += j.M(t);
                        }

                    }

                    if(f5.C())
                    {
                        u u4 = q.B(q.B() - 1);
                        for(; f5.C(); f5.B())
                            u4.A(f5.H());

                    }
                }
            } else
            {
                int j2 = _pa.C;
                Object obj = null;
                for(F f2 = _pa.H.O(); f2.C(); f2.B())
                {
                    u u5;
                    for(u5 = q.B(j2++); u5.D() != 0; u5 = q.B(j2++));
                    u5.A(f2.H());
                }

            }
        } else
        {
            if(X)
            {
                F f1 = _pa.H.O();
                int k2 = _pa.C;
                for(int l3 = q.B(); k2 < l3; k2++)
                {
                    u u6 = q.B(k2);
                    if(u6.D() != 0)
                        continue;
                    int j4 = 0;
                    for(int j5 = Math.min(l - u6.A().size(), _pa.H.size()); j4 < j5; j4++)
                    {
                        u6.A(f1.H());
                        _pa.H.B(f1);
                        f1.B();
                    }

                    if(_pa.H.isEmpty())
                        break;
                }

                k2 = _pa.H.size();
                if(k2 > 0 && k2 < l)
                {
                    u u7 = q.A((byte)0, q.B());
                    for(; f1.C(); f1.B())
                    {
                        u7.A(f1.H());
                        _pa.H.B(f1);
                    }

                }
            }
            int k1 = _pa.H.size();
            if(k1 > k)
            {
                int l2 = (int)Math.rint(Math.sqrt(k1));
                int i4;
                if(_pa.F)
                    i4 = Math.max((int)Math.rint((double)k1 / ((double)l2 * Math.ceil(1.0D / _pa.G))), k);
                else
                    i4 = (int)Math.ceil((double)k1 / ((double)l2 * Math.ceil(1.0D / _pa.G)));
                int k4 = q.B();
                for(int k5 = (q.B() + i4) - k; k4 < k5; k4++)
                    q.A((byte)0, k4);

                k4 = k1 % i4;
                int l5 = k1 / i4;
                F f6 = _pa.H.O();
                Object obj1 = null;
                int l6 = _pa.C;
                for(int i7 = q.B(); f6.C() && l6 < i7; l6++)
                {
                    u u8 = q.B(l6);
                    if(u8.D() == 0)
                    {
                        for(int j7 = 0; j7 < l5; j7++)
                        {
                            u8.A(f6.H());
                            f6.B();
                        }

                        if(k4 > 0)
                        {
                            u8.A(f6.H());
                            f6.B();
                            k4--;
                        }
                    }
                }

            } else
            {
                int i3 = _pa.C;
                Object obj2 = null;
                for(F f3 = _pa.H.O(); f3.C(); f3.B())
                {
                    u u9;
                    for(u9 = q.B(i3++); u9.D() != 0; u9 = q.B(i3++));
                    u9.A(f3.H());
                }

            }
        }
    }

    public static final Object W = "IsolatedNodesAwareLayerer.NODE_DEGREE_DP_KEY";
    private final O U;
    private Comparator T;
    private boolean X;
    private boolean V;
    private boolean S;
    private boolean R;

}
