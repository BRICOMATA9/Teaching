// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.A;
import C.A.F;
import C.A.J;
import C.A.S;
import C.A.T;
import C.A.U;
import C.G.I;
import C.G.K;
import C.G.Q;
import C.G.V;
import C.G.o;
import C.K.C;
import C.K.G;
import C.K.M;

final class N
{

    N(I i, boolean flag)
    {
        E = i;
        F = flag;
        G = new G();
        D = false;
        C = false;
    }

    public void A(J j)
    {
        B.add(j);
        D = true;
    }

    public void B(T t)
    {
        A.add(t);
        C = true;
    }

    public T H()
    {
        if(M() == 1)
            return A.N();
        if(M() > 1)
        {
            T t = null;
            double d = (-1.0D / 0.0D);
            for(F f = L(); f.C(); f.B())
            {
                double d1 = A(f.H());
                if(d < d1)
                {
                    d = d1;
                    t = f.H();
                }
            }

            return t;
        } else
        {
            return null;
        }
    }

    public T G()
    {
        if(M() == 1)
            return A.N();
        if(M() > 1)
        {
            T t = null;
            double d = (1.0D / 0.0D);
            for(F f = L(); f.C(); f.B())
            {
                double d1 = A(f.H());
                if(d > d1)
                {
                    d = d1;
                    t = f.H();
                }
            }

            return t;
        } else
        {
            return null;
        }
    }

    public T C()
    {
        if(M() == 1)
            return A.N();
        if(M() > 1)
        {
            T t = null;
            double d = (-1.0D / 0.0D);
            for(F f = L(); f.C(); f.B())
            {
                double d1 = D(f.H());
                if(d < d1)
                {
                    d = d1;
                    t = f.H();
                }
            }

            return t;
        } else
        {
            return null;
        }
    }

    public T D()
    {
        if(M() == 1)
            return A.N();
        if(M() > 1)
        {
            T t = null;
            double d = (1.0D / 0.0D);
            for(F f = L(); f.C(); f.B())
            {
                double d1 = D(f.H());
                if(d > d1)
                {
                    d = d1;
                    t = f.H();
                }
            }

            return t;
        } else
        {
            return null;
        }
    }

    public int M()
    {
        return A.size();
    }

    public U J()
    {
        return B.L();
    }

    public F L()
    {
        return A.O();
    }

    private G K()
    {
        double d1;
        double d = d1 = (1.0D / 0.0D);
        double d3;
        double d2 = d3 = (-1.0D / 0.0D);
        for(F f = L(); f.C(); f.B())
        {
            G g = C(f.H());
            d = Math.min(g.T(), d);
            d1 = Math.min(g.U(), d1);
            d2 = Math.max(g.T() + g.Q(), d2);
            d3 = Math.max(g.U() + g.R(), d3);
        }

        for(U u = J(); u.C(); u.B())
        {
            for(C.A.I i = E.N(u.I()).B(); i.C(); i.B())
            {
                M m = (M)i.D();
                d = Math.min(m.B(), d);
                d1 = Math.min(m.A(), d1);
                d2 = Math.max(m.B(), d2);
                d3 = Math.max(m.A(), d3);
            }

        }

        G = new G(d, d1, d2 - d, d3 - d1);
        return G;
    }

    public G I()
    {
        if(C || D)
        {
            K();
            C = false;
            D = false;
        }
        return G;
    }

    public double B()
    {
        return I().T();
    }

    public double F()
    {
        return I().U();
    }

    public double A()
    {
        return I().Q();
    }

    public double E()
    {
        return I().R();
    }

    public void B(double d, double d1)
    {
        A(d - B(), d1 - F());
    }

    public void A(double d, double d1)
    {
        for(F f = L(); f.C(); f.B())
            E.C(f.H(), d, d1);

        for(U u = J(); u.C(); u.B())
        {
            J j = u.I();
            C c = E.N(j);
            M am[] = new M[c.D()];
            int k = 0;
            for(C.A.I l = c.B(); l.C();)
            {
                M m1 = (M)l.D();
                am[k] = new M(m1.B() + d, m1.A() + d1);
                l.B();
                k++;
            }

            E.A(j, new C(am));
        }

        C.A.M m = E.B(Q.C);
        if(m != null)
        {
            for(U u1 = J(); u1.C(); u1.B())
            {
                o ao[] = (o[])m.D(u1.I());
                if(ao == null)
                    continue;
                for(int i = 0; i < ao.length; i++)
                    ao[i].A(ao[i].E() + d, ao[i].H() + d1);

            }

        }
        C = true;
        D = true;
    }

    private double A(T t)
    {
        double d = E.Q(t);
        if(F)
        {
            C.G.f f = E.E(t);
            V av[] = E.G(t);
            for(int i = 0; i < av.length; i++)
            {
                M m = av[i].C().A(av[i].A(), f, av[i].B());
                if(d > m.A)
                    d = m.A;
            }

        }
        return d;
    }

    private double D(T t)
    {
        double d = E.J(t);
        if(F)
        {
            C.G.f f = E.E(t);
            V av[] = E.G(t);
            for(int i = 0; i < av.length; i++)
            {
                M m = av[i].C().A(av[i].A(), f, av[i].B());
                if(d > m.D)
                    d = m.D;
            }

        }
        return d;
    }

    private G C(T t)
    {
        G g = E.I(t);
        if(F)
        {
            double d = g.K;
            double d1 = g.M;
            double d2 = g.K + g.J;
            double d3 = g.M + g.I;
            C.G.f f = E.E(t);
            V av[] = E.G(t);
            for(int i = 0; i < av.length; i++)
            {
                G g1 = av[i].A();
                M m = av[i].C().A(g1, f, av[i].B());
                if(d > m.A)
                    d = m.A;
                double d4 = m.A + g1.Q();
                if(d2 < d4)
                    d2 = d4;
                if(d1 > m.D)
                    d1 = m.D;
                double d5 = m.D + g1.R();
                if(d3 < d5)
                    d3 = d5;
            }

            g = new G(d, d1, d2 - d, d3 - d1);
        }
        return g;
    }

    final A B = new A();
    final S A = new S();
    final I E;
    private G G;
    private boolean D;
    private boolean C;
    private final boolean F;
}
