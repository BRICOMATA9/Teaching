// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.F;
import C.A.J;
import C.A.M;
import C.A.T;
import C.A.U;
import C.G.D.D;
import C.G.I;
import C.G.K;
import C.G.V;
import C.G.f;
import C.G.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class G
    implements j
{
    private static final class _A
    {

        double C;
        double B;
        final double D;
        final double A;

        _A(double d, double d1, double d2, double d3)
        {
            C = d;
            D = d1;
            B = d2;
            A = d3;
        }
    }


    public G()
    {
        U = 30D;
        O = 10D;
        R = 50D;
        M = 10D;
        Q = true;
        N = 0;
        S = 0;
        L = null;
        P = null;
        K = null;
        T = null;
    }

    public double N()
    {
        return U;
    }

    public void A(double d)
    {
        U = d;
    }

    public double M()
    {
        return R;
    }

    public void C(double d)
    {
        R = d;
    }

    public double J()
    {
        return M;
    }

    public void B(double d)
    {
        M = d;
    }

    public boolean O()
    {
        return Q;
    }

    public void K(boolean flag)
    {
        Q = flag;
    }

    public byte K()
    {
        return N;
    }

    public void D(byte byte0)
    {
        N = byte0;
    }

    public byte L()
    {
        return S;
    }

    public void E(byte byte0)
    {
        S = byte0;
    }

    public void A(I i)
    {
        T t = null;
        P = i.B(A.L);
        if(P == null)
            throw new IllegalStateException("UML_NODE_INFO_DP_KEY not bound.");
        F f1 = i.H();
        do
        {
            if(!f1.C())
                break;
            A.C.A._D _ld = (A.C.A._D)P.D(f1.H());
            if(_ld.F())
            {
                t = f1.H();
                break;
            }
            f1.B();
        } while(true);
        if(t == null)
            throw new IllegalStateException("No node marked as \"detailed\".");
        L = i.B(A.D);
        if(L == null)
            throw new IllegalStateException("UML_EDGE_INFO_DP_KEY not bound.");
        K = i.B(C.G.D.F.C);
        T = new D(i);
        int k = i.F();
        ArrayList arraylist = new ArrayList(k);
        ArrayList arraylist1 = new ArrayList(k);
        ArrayList arraylist2 = new ArrayList(k);
        ArrayList arraylist3 = new ArrayList(k);
        for(U u = i.M(); u.C(); u.B())
        {
            A.C.A._C _lc = ((A.C.A._F)L.D(u.I())).B();
            if(A.W == _lc)
            {
                arraylist.add(u.I());
                continue;
            }
            if(A.E == _lc)
            {
                arraylist1.add(u.I());
                continue;
            }
            if(A.J == _lc)
            {
                arraylist3.add(u.I());
                continue;
            }
            if(A.P == _lc)
                arraylist2.add(u.I());
        }

        int l = arraylist2.size() + arraylist3.size();
        f f2 = i.E(t);
        f2.A(0.0D, 0.0D);
        double d = f2.C();
        double d1 = f2.B();
        double d2 = d + 0.5D * d1;
        double d3 = f2.A();
        double d4 = f2.D();
        double d5 = d3 + 0.5D * d4;
        T t1 = T.B(t);
        double d6 = 0.80000000000000004D * R;
        java.awt.Insets insets;
        if(t1 != null && K != null)
        {
            java.awt.Insets insets1 = (java.awt.Insets)K.D(t1);
            insets = insets1 == null ? new java.awt.Insets(0, 0, 0, 0) : insets1;
        } else
        {
            insets = new java.awt.Insets(0, 0, 0, 0);
        }
        double d7 = d3 - (double)insets.top - 0.10000000000000001D * R - d6;
        double d8 = d6 / (double)l;
        double d9 = Q ? d7 + 0.5D * d6 : d7 + d8 * 0.5D;
        double d10 = Math.min(d2 + 0.5D * d6, d + d1);
        double d11 = ((d + d1) - d10) / (double)l;
        _A _la = new _A(Q ? d2 : d10 + d11 * 0.5D, d11, d9, d8);
        double d12 = (-1.0D / 0.0D);
        d12 = A(((Collection) (arraylist2)), d12, d3 - (double)insets.top, d2, _la, 0);
        if(Q && !arraylist2.isEmpty())
            _la.C += 0.5D * ((d + d1) - d2);
        d12 = A(((Collection) (arraylist3)), d12, d3 - (double)insets.top, d2, _la, arraylist2.size());
        if(t1 != null)
        {
            A.C.A._D _ld1 = (A.C.A._D)P.D(t1);
            f2 = i.E(t1);
            f2.B(Math.max(d1 + (double)insets.left + (double)insets.right, _ld1.D()), Math.max(d4 + (double)insets.top + (double)insets.bottom, _ld1.H()));
            f2.A(d - (double)insets.left, d3 - (double)insets.top);
        }
        double d13 = Math.max(A(((Collection) (arraylist)), f2.C() - R, f2.A(), d5, 1.0D), A(((Collection) (arraylist1)), f2.C() + f2.B() + R, f2.A(), d5, 0.0D));
        if(d13 > d3 + d4)
        {
            double d14 = d13 - d3 - d4;
            i.A(t, d1, d4 + d14);
            i.B(t, d, d3);
            double d15 = f2.A();
            f2.B(f2.B(), f2.D() + d14);
            f2.A(f2.C(), d15);
            for(U u1 = i.M(); u1.C(); u1.B())
            {
                C.K.M m = i.O(u1.I());
                i.B(u1.I(), new C.K.M(m.B(), m.A() - 0.5D * d14));
            }

        }
        T.B();
        T = null;
        P = null;
        L = null;
    }

    private double A(Collection collection, double d, double d1, double d2, 
            double d3)
    {
        double d4 = 0.0D;
        if(!collection.isEmpty())
        {
            I i = T.D();
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            J j1;
            Object obj;
            for(Iterator iterator = collection.iterator(); iterator.hasNext(); ((List) (obj)).add(j1))
            {
                j1 = (J)iterator.next();
                T t = T.B(j1.E());
                obj = (List)linkedhashmap.get(t);
                if(obj == null)
                {
                    obj = new ArrayList();
                    linkedhashmap.put(t, obj);
                }
            }

            java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double();
            double d5 = d1;
            for(Iterator iterator1 = linkedhashmap.entrySet().iterator(); iterator1.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                T t1 = (T)entry.getKey();
                java.awt.Insets insets;
                if(t1 != null && K != null)
                {
                    java.awt.Insets insets1 = (java.awt.Insets)K.D(t1);
                    insets = insets1 == null ? new java.awt.Insets(0, 0, 0, 0) : insets1;
                } else
                {
                    insets = new java.awt.Insets(0, 0, 0, 0);
                }
                double d6 = 0.0D;
                double d7 = 0.0D;
                for(Iterator iterator2 = ((Collection)entry.getValue()).iterator(); iterator2.hasNext();)
                {
                    T t2 = ((J)iterator2.next()).E();
                    A(i, t2, ((java.awt.geom.Rectangle2D) (double1)));
                    f f1 = i.E(t2);
                    if(N == 1 && !A(f1, ((java.awt.geom.Rectangle2D) (double1))))
                    {
                        double d9 = double1.getX();
                        double d10 = double1.getY();
                        if(d3 == 1.0D)
                            double1.setFrame(f1.C() - double1.getWidth() - 2D, (f1.A() + 0.5D * f1.D()) - 0.5D * double1.getHeight(), double1.getWidth(), double1.getHeight());
                        else
                            double1.setFrame(f1.C() + f1.B() + 2D, (f1.A() + 0.5D * f1.D()) - 0.5D * double1.getHeight(), double1.getWidth(), double1.getHeight());
                        double d12 = double1.getX() - d9;
                        double d13 = double1.getY() - d10;
                        double1.setFrame(f1.C(), f1.A(), f1.B(), f1.D());
                        V av[] = i.G(t2);
                        for(int k = 0; k < av.length; k++)
                        {
                            C.K.G g = av[k].A();
                            C.K.M m1 = av[k].C().A(g, f1, av[k].B());
                            C.K.G g1 = new C.K.G(m1.A + d12, m1.D + d13, g.J, g.I);
                            av[k].A(av[k].C().A(g1, f1));
                            double1.add(g1.K, g1.M);
                            double1.add(g1.K + g1.J, g1.M + g1.I);
                        }

                    } else
                    {
                        B(i, t2, double1);
                    }
                    d6 = Math.max(d6, double1.getWidth());
                    d7 += double1.getHeight() + M;
                }

                d6 += insets.left + insets.right;
                d7 += (double)(insets.top + insets.bottom) - M;
                double d8;
                if(t1 != null)
                {
                    f f2 = i.E(t1);
                    A.C.A._D _ld = (A.C.A._D)P.D(t1);
                    f2.B(Math.max(_ld.D() + O, d6), Math.max(_ld.H(), d7));
                    f2.A(d - d3 * f2.B(), d5);
                    d5 += f2.D() + U;
                    d8 = f2.C() + (double)insets.left;
                    d4 = f2.A() + (double)insets.top;
                } else
                {
                    d8 = d - d3 * d6;
                    d4 = d5 + (double)insets.top;
                    d5 += d7 + U;
                }
                for(Iterator iterator3 = ((Collection)entry.getValue()).iterator(); iterator3.hasNext();)
                {
                    J j2 = (J)iterator3.next();
                    T t3 = j2.E();
                    B(i, t3, double1);
                    f f3 = i.E(t3);
                    switch(S)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        f3.A((d8 - double1.getX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        break;

                    case 1: // '\001'
                        f3.A(((d8 + 0.5D * (d6 - (double)insets.left - (double)insets.right)) - 0.5D * double1.getWidth() - double1.getX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        break;

                    case 2: // '\002'
                        f3.A((((d8 - (double)insets.left) + d6) - (double)insets.right - double1.getMaxX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        break;

                    case 3: // '\003'
                        if(d3 == 1.0D)
                            f3.A((((d8 - (double)insets.left) + d6) - (double)insets.right - double1.getMaxX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        else
                            f3.A((d8 - double1.getX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        break;

                    case 4: // '\004'
                        if(d3 == 1.0D)
                            f3.A((d8 - double1.getX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        else
                            f3.A((((d8 - (double)insets.left) + d6) - (double)insets.right - double1.getMaxX()) + f3.C(), (d4 - double1.getY()) + f3.A());
                        break;
                    }
                    double d11 = double1.getHeight();
                    C.G.M m = i.H(j2);
                    m.d();
                    m.A(new C.K.M(0.0D, (f3.A() + 0.5D * f3.D()) - d2));
                    m.B(new C.K.M(0.0D, 0.0D));
                    d4 += d11 + M;
                }

                d4 += (double)insets.bottom - M;
            }

        }
        return d4;
    }

    private double A(Collection collection, double d, double d1, double d2, 
            _A _pa, int i)
    {
        double d3 = d;
        if(!collection.isEmpty())
        {
            I k = T.D();
            java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double();
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            final class _cls1PackageInfo
            {

                final List D = new ArrayList(4);
                final java.awt.Insets B;
                final double F;
                final double C;
                double A;
                double E;

            public _cls1PackageInfo(java.awt.Insets insets, double d, double d1)
            {
                B = insets;
                F = d;
                C = d1;
                A = 0.0D;
                E = 0.0D;
            }
            }

            for(Iterator iterator = collection.iterator(); iterator.hasNext();)
            {
                J j1 = (J)iterator.next();
                T t = T.B(j1.E());
                _cls1PackageInfo _lcls1packageinfo1 = (_cls1PackageInfo)linkedhashmap.get(t);
                if(_lcls1packageinfo1 == null)
                {
                    if(t == null)
                    {
                        _lcls1packageinfo1 = new _cls1PackageInfo(new java.awt.Insets(0, 0, 0, 0), 0.0D, 0.0D);
                    } else
                    {
                        A.C.A._D _ld = (A.C.A._D)P.D(t);
                        if(K != null)
                        {
                            java.awt.Insets insets = (java.awt.Insets)K.D(t);
                            _lcls1packageinfo1 = new _cls1PackageInfo(insets == null ? new java.awt.Insets(0, 0, 0, 0) : insets, _ld.D(), _ld.H());
                        } else
                        {
                            _lcls1packageinfo1 = new _cls1PackageInfo(new java.awt.Insets(0, 0, 0, 0), _ld.D(), _ld.H());
                        }
                    }
                    linkedhashmap.put(t, _lcls1packageinfo1);
                }
                B(k, j1.E(), double1);
                _lcls1packageinfo1.D.add(j1);
                _lcls1packageinfo1.A += double1.getWidth();
                _lcls1packageinfo1.E = Math.max(_lcls1packageinfo1.E, double1.getHeight());
            }

            _cls1PackageInfo _lcls1packageinfo = (_cls1PackageInfo)linkedhashmap.values().iterator().next();
            if(d3 == (-1.0D / 0.0D))
            {
                int l = _lcls1packageinfo.D.size() - 1;
                d3 = d2 - 0.5D * Math.max(_lcls1packageinfo.F, (double)_lcls1packageinfo.B.left + _lcls1packageinfo.A + (double)l * M + (double)_lcls1packageinfo.B.right);
                _pa.C = d2 - 0.5D * (double)l * _pa.D;
                if(!Q && l % 2 == 1)
                    _pa.B += _pa.A;
            }
            double d4 = d1 - R;
            for(Iterator iterator1 = linkedhashmap.entrySet().iterator(); iterator1.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                T t1 = (T)entry.getKey();
                _cls1PackageInfo _lcls1packageinfo2 = (_cls1PackageInfo)entry.getValue();
                double d5 = (double)_lcls1packageinfo2.B.left + _lcls1packageinfo2.A + (double)(_lcls1packageinfo2.D.size() - 1) * M + (double)_lcls1packageinfo2.B.right;
                double d6;
                double d7;
                if(_lcls1packageinfo2.F > d5)
                {
                    d7 = _lcls1packageinfo2.F;
                    d6 = d3 + 0.5D * (_lcls1packageinfo2.F - _lcls1packageinfo2.A - (double)(_lcls1packageinfo2.D.size() - 1) * M);
                } else
                {
                    d7 = d5;
                    d6 = d3 + (double)_lcls1packageinfo2.B.left;
                }
                double d8 = (double)_lcls1packageinfo2.B.top + _lcls1packageinfo2.C + (double)_lcls1packageinfo2.B.bottom;
                int i1 = _lcls1packageinfo2.D.size();
                byte abyte0[] = new byte[i1];
                int k1 = -1;
                double d9 = (1.0D / 0.0D);
                double ad[] = new double[i1];
                for(int l1 = 0; l1 < i1; l1++)
                {
                    J j3 = (J)_lcls1packageinfo2.D.get(l1);
                    T t2 = j3.E();
                    B(k, t2, double1);
                    f f1 = k.E(t2);
                    f1.A((d6 + f1.C()) - double1.getX(), ((d4 - (double)_lcls1packageinfo2.B.bottom - double1.getHeight()) + f1.A()) - double1.getY());
                    d6 += double1.getWidth() + M;
                    ad[l1] = k.O(t2);
                    double d12 = ad[l1] - d2;
                    if(d12 < -0.5D * _pa.D)
                        abyte0[l1] = -1;
                    else
                    if(d12 > 0.5D * _pa.D)
                        abyte0[l1] = 1;
                    else
                        abyte0[l1] = 0;
                    if(d9 > Math.abs(d12))
                    {
                        d9 = Math.abs(d12);
                        k1 = l1;
                    }
                }

                J j2 = (J)_lcls1packageinfo2.D.get(k1);
                C.G.M m = k.H(j2);
                m.d();
                if(abyte0[k1] == 0)
                {
                    _pa.C = ad[k1];
                    m.A(new C.K.M(ad[k1] - d2, 0.0D));
                } else
                {
                    _pa.C += (double)k1 * _pa.D;
                    m.A(new C.K.M(_pa.C - d2, 0.0D));
                    m.E(_pa.C, _pa.B);
                    m.E(ad[k1], _pa.B);
                }
                double d10 = _pa.C;
                double d11 = _pa.B;
                if(!Q)
                {
                    _pa.C += _pa.D;
                    if(abyte0[k1] > -1)
                        _pa.B += _pa.A;
                }
                for(int i2 = k1 + 1; i2 < i1; i2++)
                {
                    J j4 = (J)_lcls1packageinfo2.D.get(i2);
                    C.G.M m1 = k.H(j4);
                    m1.d();
                    m1.A(new C.K.M(_pa.C - d2, 0.0D));
                    m1.E(_pa.C, _pa.B);
                    m1.E(ad[i2], _pa.B);
                    if(!Q)
                    {
                        _pa.C += _pa.D;
                        _pa.B += _pa.A;
                    }
                }

                if(!Q && k1 > 0)
                {
                    _pa.C = d10 - _pa.D;
                    _pa.B = d11 + _pa.A;
                }
                int k2 = k1;
                do
                {
                    if(k2-- <= 0)
                        break;
                    J j5 = (J)_lcls1packageinfo2.D.get(k2);
                    C.G.M m2 = k.H(j5);
                    m2.d();
                    m2.A(new C.K.M(_pa.C - d2, 0.0D));
                    m2.E(_pa.C, _pa.B);
                    m2.E(ad[k2], _pa.B);
                    if(!Q)
                    {
                        _pa.C -= _pa.D;
                        _pa.B += _pa.A;
                    }
                } while(true);
                if(t1 != null)
                {
                    f f2 = k.E(t1);
                    f2.B(d7, d8);
                    f2.A(d3, d4 - f2.D());
                    d3 = f2.C() + f2.B() + U;
                } else
                {
                    d3 += d7 + U;
                }
            }

        }
        return d3;
    }

    private static void B(I i, T t, java.awt.geom.Rectangle2D rectangle2d)
    {
        f f1 = i.E(t);
        rectangle2d.setFrame(f1.C(), f1.A(), f1.B(), f1.D());
        V av[] = i.G(t);
        for(int k = 0; k < av.length; k++)
        {
            C.K.G g = av[k].A();
            C.K.M m = av[k].C().A(g, f1, av[k].B());
            rectangle2d.add(m.A, m.D);
            rectangle2d.add(m.A + g.J, m.D + g.I);
        }

    }

    private static void A(I i, T t, java.awt.geom.Rectangle2D rectangle2d)
    {
        V av[] = i.G(t);
        if(av.length == 0)
        {
            rectangle2d.setFrame(0.0D, 0.0D, -1D, -1D);
        } else
        {
            f f1 = i.E(t);
            C.K.G g = av[0].A();
            C.K.M m = av[0].C().A(g, f1, av[0].B());
            rectangle2d.setFrame(m.A, m.D, g.J, g.I);
            for(int k = 1; k < av.length; k++)
            {
                C.K.G g1 = av[k].A();
                C.K.M m1 = av[k].C().A(g1, f1, av[k].B());
                rectangle2d.add(m1.A, m1.D);
                rectangle2d.add(m1.A + g1.J, m1.D + g1.I);
            }

        }
    }

    private static boolean A(f f1, java.awt.geom.Rectangle2D rectangle2d)
    {
        return A(f1, rectangle2d.getMinX(), rectangle2d.getMinY()) && A(f1, rectangle2d.getMaxX(), rectangle2d.getMaxY());
    }

    private static boolean A(f f1, double d, double d1)
    {
        return d >= f1.C() && d - f1.C() <= f1.B() && d1 >= f1.A() && d1 - f1.A() <= f1.D();
    }

    private double U;
    private double O;
    private double R;
    private double M;
    private boolean Q;
    private byte N;
    private byte S;
    private M L;
    private M P;
    private M K;
    private D T;
}
