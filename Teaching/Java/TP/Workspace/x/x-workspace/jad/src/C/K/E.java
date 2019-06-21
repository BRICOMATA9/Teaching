// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import C.A.P;
import C.A.Y;

public class E
{
    public static class _A
    {

        static final _A A(double d, double d1)
        {
            return new _A(d, d1);
        }

        public final _A A()
        {
            if(A.B() != null)
                return (_A)A.B().A();
            else
                return null;
        }

        P A;
        double C;
        double B;

        _A(double d, double d1)
        {
            B = d;
            C = d1;
        }
    }


    public E(double d, double d1, double d2)
    {
        if(d > d1)
        {
            throw new IllegalArgumentException("min (" + d + ") must not be greater than max(" + d1 + ")");
        } else
        {
            A = new Y();
            _A _la = _A.A(d, d2);
            _la.A = A.B(_la);
            _A _la1 = _A.A(d1, 0.0D);
            _la1.A = A.E(_la1);
            return;
        }
    }

    private E()
    {
    }

    public E A(boolean flag, boolean flag1)
    {
        Y y = new Y();
        if(flag1)
        {
            for(P p = A.G().B(); p != null; p = p.B())
            {
                _A _la1;
                if(flag)
                    _la1 = _A.A(-A(p), -B(p));
                else
                    _la1 = _A.A(-A(p), B(p));
                _la1.A = y.E(_la1);
            }

            _A _la = _A.A(-A(), 0.0D);
            _la.A = y.E(_la);
        } else
        {
            for(P p1 = A.I(); p1 != null; p1 = p1.C())
            {
                _A _la2;
                if(flag)
                    _la2 = _A.A(C(p1), -B(p1));
                else
                    _la2 = _A.A(C(p1), B(p1));
                _la2.A = y.E(_la2);
            }

        }
        E e = new E();
        e.B = 0.0D;
        e.C = 0.0D;
        e.A = y;
        return e;
    }

    public void C(double d, double d1, double d2)
    {
        A(new E(d, d1, d2), false, true);
    }

    public void B(double d, double d1, double d2)
    {
        A(new E(d, d1, d2), true, true);
    }

    public void A(double d, double d1, double d2)
    {
        P p;
        P p1;
        if(d <= A())
        {
            if(d1 >= D())
            {
                A.clear();
                _A _la = _A.A(d, d2);
                _la.A = A.B(_la);
                _A _la5 = _A.A(d1, 0.0D);
                _la5.A = A.E(_la5);
                C = B = 0.0D;
                return;
            }
            p = null;
            d1 -= B;
            d -= B;
            p1 = D(d1);
        } else
        {
            d -= B;
            p = D(d);
            if(d1 >= D())
            {
                p1 = A.G();
                d1 -= B;
            } else
            {
                p1 = p.C();
                for(d1 -= B; ((_A)p1.A()).B <= d1; p1 = p1.C());
                p1 = p1.B();
            }
        }
        d2 -= C;
        if(p == p1)
        {
            _A _la1 = (_A)p1.A();
            _A _la6 = _A.A(d1, _la1.C);
            _la6.A = A.A(_la6, _la1.A);
            if(_la1.B == d)
            {
                _la1.C = d2;
            } else
            {
                _A _la8 = _A.A(d, d2);
                _la8.A = A.A(_la8, _la1.A);
            }
            return;
        }
        if(p == null)
        {
            _A _la2 = _A.A(d, d2);
            p = _la2.A = A.B(_la2);
        } else
        {
            _A _la3 = (_A)p.A();
            if(_la3.B == d)
            {
                _la3.C = d2;
            } else
            {
                _A _la7 = _A.A(d, d2);
                p = _la7.A = A.A(_la7, _la3.A);
            }
        }
        if(p1 != null)
        {
            _A _la4 = (_A)p1.A();
            _la4.B = d1;
        }
        if(p.B() != null && ((_A)p.B().A()).C == ((_A)p.A()).C)
            p = p.B();
        if(p1 != null && p1 != A.G() && ((_A)p1.B().A()).C == ((_A)p1.A()).C)
            p1 = p1.C();
        for(p = p.C(); p != p1; p = p.C())
            A.A(p);

    }

    public void A(double d)
    {
        C += d;
    }

    public void B(double d)
    {
        B += d;
    }

    public double A()
    {
        return ((_A)A.F()).B + B;
    }

    public double D()
    {
        return ((_A)A.H()).B + B;
    }

    public double B()
    {
        return A(A(), D());
    }

    public double F()
    {
        return B(A(), D());
    }

    public void C(E e)
    {
        A(e, true, false);
    }

    public void B(E e)
    {
        A(e, false, false);
    }

    private void A(E e, boolean flag, boolean flag1)
    {
        double d = flag ? -1.7976931348623157E+308D : 1.7976931348623157E+308D;
        double d1 = A();
        double d2 = e.A();
        Y y = A;
        P p = y.I();
        P p1 = e.A.I();
        Y y1 = new Y();
        double d3 = d;
        double d4 = d;
        if(d1 <= d2)
        {
            P p2 = p;
            p = p.C();
            d3 = B(p2);
            y.A(p2);
            y1.B(p2);
            P p3;
            for(P p6 = y.G(); p != p6 && C(p) < d2; y1.B(p3))
            {
                p3 = p;
                p = p.C();
                y.A(p3);
            }

            d3 = p != null ? B(y1.G()) : d;
        } else
        {
            _A _la = _A.A(e.C(p1) - B, (d4 = e.B(p1)) - C);
            _la.A = y1.E(_la);
            p1 = p1.C();
        }
        do
        {
            if(p == null || p1 == null)
                break;
            if(C(p) <= e.C(p1))
            {
                d3 = B(p);
                P p4 = p;
                p = p.C();
                if(p == null)
                    d3 = d;
                double d6 = flag ? Math.max(d3, d4) : Math.min(d3, d4);
                y.A(p4);
                if(((_A)y1.H()).C != d6 - C)
                {
                    ((_A)p4.A()).C = d6 - C;
                    y1.B(p4);
                }
            } else
            {
                double d5 = e.C(p1);
                d4 = e.B(p1);
                P p7 = p1;
                p1 = p1.C();
                if(p1 == null)
                    d4 = d;
                double d7 = flag ? Math.max(d3, d4) : Math.min(d3, d4);
                if(((_A)y1.H()).B == d5 - B)
                    ((_A)y1.H()).C = d7 - C;
                else
                if(((_A)y1.H()).C != d7 - C)
                    if(flag1)
                    {
                        e.A.A(p7);
                        _A _la3 = (_A)p7.A();
                        _la3.C = d7 - C;
                        _la3.B = d5 - B;
                        y1.B(p7);
                    } else
                    {
                        _A _la4 = _A.A(d5 - B, d7 - C);
                        _la4.A = y1.E(_la4);
                    }
            }
        } while(true);
        if(p != null)
            y1.A(y);
        while(p1 != null) 
            if(((_A)y1.H()).B == e.C(p1) - B)
            {
                ((_A)y1.H()).C = e.B(p1) - C;
                p1 = p1.C();
            } else
            {
                P p5 = p1;
                p1 = p1.C();
                if(flag1)
                {
                    e.A.A(p5);
                    _A _la1 = (_A)p5.A();
                    _la1.C = e.B(p5) - C;
                    _la1.B = e.C(p5) - B;
                    y1.B(p5);
                } else
                {
                    _A _la2 = _A.A(e.C(p5) - B, e.B(p5) - C);
                    _la2.A = y1.E(_la2);
                }
            }
        A = y1;
    }

    private double B(P p)
    {
        return ((_A)p.A()).C + C;
    }

    private double C(P p)
    {
        return ((_A)p.A()).B + B;
    }

    private double A(P p)
    {
        if(p.C() == null)
            throw new IllegalArgumentException("Cell is unbound!");
        else
            return ((_A)p.C().A()).B + B;
    }

    private final P D(double d)
    {
        P p = A.I();
        double d1 = ((_A)p.A()).B;
        double d3 = ((_A)A.H()).B;
        if(d < d1 || d > d3)
            return null;
        if(d == d3)
            return A.G();
        for(double d4 = ((_A)p.C().A()).B; d >= d4; d4 = ((_A)p.C().A()).B)
        {
            double d2 = d4;
            p = p.C();
        }

        return p;
    }

    public double D(_A _pa)
    {
        return C + _pa.C;
    }

    public double C(_A _pa)
    {
        return _pa.B + B;
    }

    public _A C(double d)
    {
        return (_A)D(d - B).A();
    }

    public double A(_A _pa)
    {
        if(_pa.A.C() == null)
            throw new IllegalArgumentException("Segment is unbound!");
        else
            return ((_A)_pa.A.C().A()).B + B;
    }

    public _A C()
    {
        P p = A.I();
        return p == null ? null : (_A)p.A();
    }

    public _A E()
    {
        P p = A.G().B();
        return (_A)p.A();
    }

    public _A B(_A _pa)
    {
        if(_pa.A.C() != A.G())
            return (_A)_pa.A.C().A();
        else
            return null;
    }

    public double B(double d, double d1)
    {
        double d2 = A();
        double d3 = D();
        double d4 = d;
        double d5 = d1;
        if(d3 <= d2 || d5 <= d4)
            return 1.7976931348623157E+308D;
        double d6 = Math.max(d2, d4);
        double d7 = Math.min(d3, d5);
        if(d6 >= d7)
            return -1.7976931348623157E+308D;
        double d8 = d6;
        _A _la;
        if(d2 == d4)
            _la = C();
        else
        if(d2 < d4)
            _la = C(d8);
        else
            _la = C();
        double d9 = -1.7976931348623157E+308D;
        for(; d8 < d7 && _la != A.H(); _la = B(_la))
        {
            d9 = Math.max(d9, D(_la));
            d8 = A(_la);
        }

        return d9;
    }

    public double A(double d, double d1)
    {
        double d2 = A();
        double d3 = D();
        double d4 = d;
        double d5 = d1;
        if(d3 <= d2 || d5 <= d4)
            return 1.7976931348623157E+308D;
        double d6 = Math.max(d2, d4);
        double d7 = Math.min(d3, d5);
        if(d6 >= d7)
            return 1.7976931348623157E+308D;
        double d8 = d6;
        _A _la;
        if(d2 == d4)
            _la = C();
        else
        if(d2 < d4)
            _la = C(d8);
        else
            _la = C();
        double d9 = 1.7976931348623157E+308D;
        for(; d8 < d7 && _la != A.H(); _la = B(_la))
        {
            d9 = Math.min(d9, D(_la));
            d8 = A(_la);
        }

        return d9;
    }

    public double A(E e)
    {
        double d = A();
        double d1 = e.A();
        double d2 = D();
        double d3 = e.D();
        if(d2 <= d || d3 <= d1)
            return 1.7976931348623157E+308D;
        double d4 = Math.max(d, d1);
        double d5 = Math.min(d2, d3);
        if(d4 >= d5)
            return 1.7976931348623157E+308D;
        double d6 = d4;
        _A _la;
        _A _la1;
        if(d == d1)
        {
            _la = C();
            _la1 = e.C();
        } else
        if(d < d1)
        {
            _la = C(d6);
            _la1 = e.C();
        } else
        {
            _la = C();
            _la1 = e.C(d6);
        }
        double d7 = 1.7976931348623157E+308D;
        while(d6 < d5) 
        {
            d7 = Math.min(d7, e.D(_la1) - D(_la));
            if(e.A(_la1) < A(_la))
            {
                d6 = e.A(_la1);
                _la1 = e.B(_la1);
            } else
            {
                d6 = A(_la);
                _la = B(_la);
            }
        }
        return d7;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(A.size() * 20);
        for(_A _la = (_A)A.F(); _la != null; _la = B(_la))
        {
            stringbuffer.append(C(_la)).append(" -> ").append(A(_la)).append(" : ").append(D(_la));
            stringbuffer.append('\n');
        }

        return stringbuffer.toString();
    }

    private double C;
    private Y A;
    private double B;
}
