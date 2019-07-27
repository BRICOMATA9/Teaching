// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import C.A.*;
import C.E.R;
import java.util.Arrays;
import java.util.Comparator;

// Referenced classes of package C.K:
//            K, G

public class H
{
    static class _F
        implements _C
    {

        public void B(_A _pa)
        {
            int i = 0;
            double d = D;
            double d1 = B;
            do
            {
                if(i >= A)
                    break;
                double d2 = 0.5D * (d1 - d);
                if(_pa.C < d2)
                {
                    i = (i << 1) + 1;
                    d1 = d2;
                    continue;
                }
                if(_pa.D <= d2)
                    break;
                i = (i << 1) + 2;
                d = d2;
            } while(true);
            if(E != null)
            {
                P p = (P)E.A();
                E.A(_pa);
                F[i].B(E);
                _pa.A = E;
                E = p;
            } else
            {
                _pa.A = F[i].E(_pa);
            }
        }

        public void A(_A _pa)
        {
            int i = 0;
            double d = D;
            double d1 = B;
            do
            {
                if(i >= A)
                    break;
                double d2 = 0.5D * (d1 - d);
                if(_pa.C < d2)
                {
                    i = (i << 1) + 1;
                    d1 = d2;
                    continue;
                }
                if(_pa.D <= d2)
                    break;
                i = (i << 1) + 2;
                d = d2;
            } while(true);
            F[i].A(_pa.A);
            _pa.A.A(E);
            E = _pa.A;
        }

        void A(_A _pa, _D _pd, int i, double d, double d1)
        {
            double d2 = 0.5D * (d1 - d);
            Object obj = _pa.B;
            if(i < A)
            {
                if(_pa.C < d2)
                {
                    for(P p = F[i].I(); p != null; p = p.C())
                    {
                        _A _la = (_A)p.A();
                        if(_la.C >= _pa.D && _la.D <= _pa.C)
                            _pd.A(obj, _la.B);
                    }

                    A(_pa, _pd, (i << 1) + 1, d, d2);
                } else
                if(_pa.D > d2)
                {
                    for(P p1 = F[i].I(); p1 != null; p1 = p1.C())
                    {
                        _A _la1 = (_A)p1.A();
                        if(_la1.C >= _pa.D && _la1.D <= _pa.C)
                            _pd.A(obj, _la1.B);
                    }

                    A(_pa, _pd, (i << 1) + 2, d2, d1);
                } else
                {
                    for(P p2 = F[i].I(); p2 != null; p2 = p2.C())
                    {
                        _A _la2 = (_A)p2.A();
                        _pd.A(obj, _la2.B);
                    }

                    A(_pa, _pd, (i << 1) + 1, d, d2);
                    A(_pa, _pd, (i << 1) + 2, d2, d1);
                }
            } else
            {
                for(P p3 = F[i].I(); p3 != null; p3 = p3.C())
                {
                    _A _la3 = (_A)p3.A();
                    if(_la3.C >= _pa.D && _la3.D <= _pa.C)
                        _pd.A(obj, _la3.B);
                }

            }
        }

        public void A(_A _pa, _D _pd)
        {
            A(_pa, _pd, 0, D, B);
        }

        Y F[];
        P E;
        final double D;
        final double B;
        final double C;
        final int A;

        _F(double d, double d1, int i)
        {
            F = new Y[i];
            for(int j = 0; j < F.length; j++)
                F[j] = new Y();

            D = d;
            B = d1;
            C = (d1 - d) + 1.0D;
            A = F.length / 2;
        }
    }

    static interface _C
    {

        public abstract void B(_A _pa);

        public abstract void A(_A _pa);

        public abstract void A(_A _pa, _D _pd);
    }

    static class _A
    {

        final double D;
        final double C;
        final int E = 0;
        Object B;
        P A;

        public _A(double d, double d1, Object obj)
        {
            D = d;
            C = d1;
            B = obj;
        }
    }

    static class _B
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            _E _le = (_E)obj;
            _E _le1 = (_E)obj1;
            if(_le.C < _le1.C)
                return -1;
            if(_le.C > _le1.C)
                return 1;
            if(_le.B == 1 && _le1.B == 0)
                return 1;
            return _le.B != 0 || _le1.B != 1 ? 0 : -1;
        }

        public boolean equals(Object obj)
        {
            return false;
        }

        _B()
        {
        }
    }

    static class _E
        implements _G
    {

        final double C;
        final int B;
        final _A A;

        public _E(double d, int i, _A _pa)
        {
            A = _pa;
            C = d;
            B = i;
        }
    }

    static interface _G
    {
    }

    public static interface _D
    {

        public abstract void A(Object obj, Object obj1);
    }


    public static void A(Y y, _D _pd)
    {
        _E a_le[] = A(y);
        R r = new R();
        double d = 1.7976931348623157E+308D;
        double d1 = -1.7976931348623157E+308D;
        for(P p = y.I(); p != null; p = p.C())
        {
            G g = ((K)p.A()).A();
            double d2 = g.I;
            if(d2 >= 0.0D)
            {
                d = Math.min(d, g.M);
                d1 = Math.max(d1, g.M + d2);
            }
        }

        _F _lf = new _F(d, d1, 15);
        R r1 = new R();
        for(int i = 0; i < a_le.length; i++)
        {
            _E _le = a_le[i];
            switch(_le.B)
            {
            case 0: // '\0'
                _lf.A(_le.A, _pd);
                _lf.B(_le.A);
                break;

            case 1: // '\001'
                _lf.A(_le.A);
                break;
            }
        }

    }

    static _E[] A(Y y)
    {
        Y y1 = new Y();
        for(I i = y.B(); i.C(); i.B())
        {
            K k = (K)i.D();
            G g = k.A();
            double d = g.I;
            double d1 = g.J;
            if(d >= 0.0D && d1 >= 0.0D)
            {
                _A _la = new _A(g.M, g.M + d, k);
                _E _le = new _E(g.K, 0, _la);
                _E _le1 = new _E(g.K + d1, 1, _la);
                y1.add(_le);
                y1.add(_le1);
            }
        }

        _E a_le[] = new _E[y1.size()];
        y1.toArray(a_le);
        Arrays.sort(a_le, new _B());
        return a_le;
    }
}
