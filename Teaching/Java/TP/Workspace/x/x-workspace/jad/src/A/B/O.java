// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import A.C.A;
import C.A.J;
import C.A.K;
import C.A.M;
import C.A.T;
import C.A.U;
import C.A.Y;
import C.G.D.F;
import C.G.I;
import C.G.w;
import C.K.B;
import C.K.G;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package A.B:
//            N

final class O extends w
{
    private final class _A
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            N n = (N)obj;
            N n1 = (N)obj1;
            Object obj2 = A.L;
            M m1 = n.E.B(obj2);
            A.C.A._D _ld = m1 == null ? null : (A.C.A._D)m1.D(O.this.A(n));
            A.C.A._A _la = _ld == null ? null : _ld.A();
            A.C.A._D _ld1 = m1 == null ? null : (A.C.A._D)m1.D(O.this.A(n1));
            A.C.A._A _la1 = _ld1 == null ? null : _ld1.A();
            int i = n.M();
            int j = n1.M();
            int k = j - i;
            if(_la == _la1)
                if(k == 0)
                {
                    String s = _ld == null ? null : _ld.E();
                    String s1 = _ld1 == null ? null : _ld1.E();
                    if(_ld != null && _ld1 != null)
                        return s.compareTo(s1);
                    if(_ld != null)
                        return 1;
                    return _ld1 == null ? 0 : -1;
                } else
                {
                    return k;
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

        private _A()
        {
        }

    }


    public O()
    {
        FF = _fld0101;
        _fld0100 = 0;
        _fld0102 = false;
    }

    public void S(boolean flag)
    {
        _fld0102 = flag;
    }

    public void A(Comparator comparator)
    {
        if(comparator == null)
        {
            throw new IllegalArgumentException("null");
        } else
        {
            FF = comparator;
            return;
        }
    }

    public void H(byte byte0)
    {
        _fld0100 = byte0;
    }

    public void A(I i)
    {
        if(i.J())
            return;
        HashMap hashmap = new HashMap();
        N n = new N(i, _fld0102);
        M m1 = i.B(F.A);
        M m2 = i.B(F.D);
        M m3 = i.B(F.B);
        if(m1 != null && m2 != null && m3 != null)
        {
            for(C.A.F f = i.H(); f.C(); f.B())
            {
                T t = f.H();
                Object obj = m3.D(t);
                if(obj != null)
                {
                    N n1 = (N)hashmap.get(obj);
                    if(n1 == null)
                    {
                        n1 = new N(i, _fld0102);
                        hashmap.put(obj, n1);
                    }
                    n1.B(t);
                }
                if(!m1.B(t))
                    continue;
                for(U u = t.R(); u.C(); u.B())
                {
                    n.A(u.I());
                    i.B(u.I());
                }

                n.B(t);
                i.G(t);
            }

        }
        K k = i.W();
        int j = C.F.I.A(i, k);
        N an[] = new N[j];
        for(int l = 0; l < j; l++)
            an[l] = new N(i, _fld0102);

        for(U u1 = i.M(); u1.C(); u1.B())
        {
            J j1 = u1.I();
            an[k.A(j1.G())].A(j1);
            i.B(j1);
        }

        for(C.A.F f1 = i.H(); f1.C(); f1.B())
        {
            T t1 = f1.H();
            an[k.A(t1)].B(t1);
            i.G(f1.H());
        }

        for(int i1 = 0; i1 < j; i1++)
        {
            for(C.A.F f2 = an[i1].L(); f2.C(); f2.B())
                i.H(f2.H());

            for(U u2 = an[i1].J(); u2.C(); u2.B())
                i.C(u2.I());

            D(i);
            for(U u3 = an[i1].J(); u3.C(); u3.B())
                i.B(u3.I());

            for(C.A.F f3 = an[i1].L(); f3.C(); f3.B())
                i.G(f3.H());

        }

        for(int k1 = 0; k1 < j; k1++)
        {
            for(C.A.F f4 = an[k1].L(); f4.C(); f4.B())
                i.H(f4.H());

        }

        for(int l1 = 0; l1 < j; l1++)
        {
            for(U u4 = an[l1].J(); u4.C(); u4.B())
                i.C(u4.I());

        }

        B b = i();
        double d = b.Q();
        double d1 = b.R();
        A(an, l(), d1 <= 1E-08D ? 1.0D : d / d1, 1);
        i.A(k);
        if(n.M() > 0 && m2 != null && m3 != null)
        {
            for(C.A.F f5 = n.L(); f5.C(); f5.B())
                i.H(f5.H());

            for(U u5 = n.J(); u5.C(); u5.B())
                i.C(u5.I());

            N n2 = new N(i, _fld0102);
            int i2 = n.M();
            C.E.O o = new C.E.O(n.L(), i2);
            HashSet hashset = new HashSet(i2);
            while(!o.B()) 
            {
                T t2 = (T)o.D();
                Object obj1 = m3.D(t2);
                if(obj1 != null && !hashset.contains(obj1))
                {
                    o.A(t2);
                } else
                {
                    hashset.add(m2.D(t2));
                    n2.B(t2);
                }
            }
            M m4 = i.B(F.C);
            C.A.F f6 = n2.L();
            f6.A();
            for(; f6.C(); f6.G())
            {
                T t3 = f6.H();
                Object obj2 = m2.D(t3);
                N n3 = (N)hashmap.get(obj2);
                if(n3 != null)
                {
                    Object obj3 = m4 == null ? null : m4.D(t3);
                    Insets insets = obj3 == null ? new Insets(0, 0, 0, 0) : (Insets)obj3;
                    G g = n3.I();
                    i.A(t3, g.J + (double)insets.left + (double)insets.right, g.I + (double)insets.top + (double)insets.bottom);
                    i.B(t3, g.K - (double)insets.left, g.M - (double)insets.top);
                }
            }

        }
    }

    private int A(N an[], double d, double d1, int i)
    {
        if(an == null || an.length < 1)
            return 0;
        Arrays.sort(an, FF);
        double d2 = 1.7976931348623157E+308D;
        double d3 = 4.9406564584124654E-324D;
        double d4 = 1.7976931348623157E+308D;
        double d5 = 4.9406564584124654E-324D;
        for(int j = 0; j < an.length; j++)
        {
            double d6 = an[j].A();
            d2 = Math.min(d2, d6);
            d3 = Math.max(d3, d6);
            double d8 = an[j].E();
            d4 = Math.min(d4, d8);
            d5 = Math.max(d5, d8);
        }

        if(d4 / d5 > 0.94999999999999996D && d2 / d3 > 0.94999999999999996D)
            return A(an, d, d1).height;
        d3 += d;
        d2 += d;
        d5 += d;
        d4 += d;
        int k = 0;
        for(int l = 0; l < an.length; l++)
            k = (int)((double)k + (an[l].A() + d) * (an[l].E() + d));

        double d7 = 0.0D;
        double d9 = 0.0D;
        int i1 = (int)(d1 * Math.sqrt((double)k / d1));
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        int i2 = i1;
        int j2 = 0;
        boolean flag3 = false;
        A.C.A._A _la = null;
        A.C.A._A _la1 = null;
        int k2 = 0;
        int l2 = k2;
        I i3 = an[0].E;
        M m1 = i3.B(A.L);
        Y y = new Y();
        do
        {
            Y y1 = new Y();
            y.add(y1);
            int j1;
            int k1;
            int l1 = j1 = k1 = 0;
            for(int j3 = 0; j3 < an.length; j3++)
            {
                double d10 = an[j3].A() + d;
                A.C.A._D _ld = (A.C.A._D)m1.D(A(an[j3]));
                A.C.A._A _la2 = _ld.A();
                boolean flag4;
                if(A.S != _la2 && A.R != _la2 && A.M != _la2)
                {
                    _la1 = _la2;
                    flag4 = _la1 != _la;
                } else
                {
                    l2 = an[j3].M();
                    flag4 = l2 == 1 && k2 != true;
                }
                if((flag4 || (double)l1 + d10 > (double)i2) && y1.size() > 0)
                {
                    k1 = Math.max(k1, l1);
                    y1 = new Y();
                    y1.add(an[j3]);
                    y.add(y1);
                    l1 = (int)d10;
                } else
                {
                    y1.add(an[j3]);
                    l1 = (int)((double)l1 + d10);
                }
                if(y1.size() == 1)
                    j1 = (int)((double)j1 + (((N)y1.F()).E() + d));
                k2 = l2;
                _la = _la1;
            }

            k1 = Math.max(k1, l1);
            if(d1 * (double)j1 > (double)k1 && j2 != k1)
            {
                y.clear();
                i2 = (int)((double)i2 * 1.1000000000000001D);
                j2 = k1;
            }
        } while(y.isEmpty());
        double d11 = 0.0D;
        for(C.A.I k3 = y.B(); k3.C(); k3.B())
        {
            double d12 = 0.0D;
            Y y4 = (Y)k3.D();
            for(C.A.I k4 = y4.B(); k4.C(); k4.B())
            {
                N n = (N)k4.D();
                n.B(d12, d11);
                d12 += n.A() + d;
            }

            d7 = Math.max(d7, d12);
            d11 += A(y4, d);
            d9 = Math.max(d9, d11);
        }

label0:
        switch(i)
        {
        default:
            break;

        case 2: // '\002'
            for(C.A.I l3 = y.B(); l3.C(); l3.B())
            {
                Y y2 = (Y)l3.D();
                double d14 = d7 - B(y2, d);
                for(C.A.I l4 = y2.B(); l4.C(); l4.B())
                {
                    N n1 = (N)l4.D();
                    n1.A(d14, 0.0D);
                }

            }

            break;

        case 3: // '\003'
            C.A.I i4 = y.B();
            do
            {
                if(!i4.C())
                    break label0;
                double d13 = 0.0D;
                Y y5 = (Y)i4.D();
                if(y5.size() > 1)
                {
                    double d16 = (d7 - B(y5, d)) / (double)(y5.size() - 1);
                    for(C.A.I j5 = y5.B(); j5.C(); j5.B())
                    {
                        N n3 = (N)j5.D();
                        n3.B(d13, n3.F());
                        d13 += n3.A() + d + d16;
                    }

                }
                i4.B();
            } while(true);

        case 4: // '\004'
            C.A.I j4 = y.B();
            do
            {
                if(!j4.C())
                    break label0;
                Y y3 = (Y)j4.D();
                double d15 = (d7 - B(y3, d)) / 2D;
                for(C.A.I i5 = y3.B(); i5.C(); i5.B())
                {
                    N n2 = (N)i5.D();
                    n2.A(d15, 0.0D);
                }

                j4.B();
            } while(true);
        }
        return y.size();
    }

    private T A(N n)
    {
        switch(_fld0100)
        {
        case 0: // '\0'
            return n.C();

        case 1: // '\001'
            return n.H();

        case 2: // '\002'
            return n.D();

        case 3: // '\003'
            return n.G();
        }
        return n.D();
    }

    public Dimension A(N an[], double d, double d1)
    {
        if(an == null || an.length < 1)
            return new Dimension(0, 0);
        double d2 = 0.0D;
        double d3 = 0.0D;
        for(int i = 0; i < an.length; i++)
        {
            d2 = Math.max(d2, an[i].A());
            d3 = Math.max(d3, an[i].E());
        }

        d2 += d;
        d3 += d;
        double d4 = d2 * d3 * (double)an.length;
        double d5 = Math.sqrt(d4 / d1);
        double d6 = d4 / d5;
        int j = (int)Math.floor(d6 / d2);
        int k = (int)Math.ceil(d6 / d2);
        int l = (int)Math.ceil((double)an.length / (double)j);
        int i1 = (int)Math.ceil((double)an.length / (double)k);
        int j1;
        int k1;
        if(j * l < k * i1)
        {
            j1 = j;
            k1 = l;
        } else
        {
            j1 = k;
            k1 = i1;
        }
        int l1 = 0;
        int i2 = 0;
        double d7 = 0.0D;
        double d8 = 0.0D;
        if(d2 > d3)
        {
            for(int j2 = 0; j2 < an.length; j2++)
            {
                an[j2].B((double)i2 * d2, (double)l1 * d3);
                d7 = Math.max(d7, an[j2].B() + an[j2].E() + d);
                d8 = Math.max(d8, an[j2].F() + an[j2].A() + d);
                if(++i2 >= j1)
                {
                    l1++;
                    i2 = 0;
                }
            }

        } else
        {
            for(int k2 = 0; k2 < an.length; k2++)
            {
                an[k2].B((double)i2 * d2, (double)l1 * d3);
                d7 = Math.max(d7, an[k2].B() + an[k2].E() + d);
                d8 = Math.max(d8, an[k2].F() + an[k2].A() + d);
                if(++l1 >= k1)
                {
                    i2++;
                    l1 = 0;
                }
            }

        }
        return new Dimension(j1, k1);
    }

    private static double A(Y y, double d)
    {
        double d1 = 0.0D;
        for(C.A.I i = y.B(); i.C(); i.B())
            d1 = Math.max(((N)i.D()).E(), d1);

        return d1 + d;
    }

    private static double B(Y y, double d)
    {
        double d1 = 0.0D;
        for(C.A.I i = y.B(); i.C(); i.B())
            d1 += ((N)i.D()).A() + d;

        return d1;
    }

    public Comparator m()
    {
        return new _A();
    }

    private static final Comparator _fld0101 = new Comparator() {

        public int compare(Object obj, Object obj1)
        {
            N n = (N)obj;
            N n1 = (N)obj1;
            int i = (int)n1.E() - (int)n.E();
            if(i == 0)
                return (int)n1.A() - (int)n.A();
            else
                return i;
        }

    };
    private Comparator FF;
    private byte _fld0100;
    private boolean _fld0102;


}
