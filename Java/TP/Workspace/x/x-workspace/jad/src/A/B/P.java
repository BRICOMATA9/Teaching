// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.*;
import C.G.E.A.*;
import C.G.I;

class P
    implements Z
{

    public P(Z z)
    {
        Q = z;
        P = false;
    }

    public void B(boolean flag)
    {
        P = flag;
    }

    public void A(I i, v v1, Q q)
    {
        if(Q == null)
        {
            return;
        } else
        {
            Q.A(i, v1, q);
            return;
        }
    }

    public void A(I i, v v1, Q q, R r)
    {
        if(Q == null)
            return;
        Q.A(i, v1, q, r);
        if(P)
        {
            double d = (1.0D / 0.0D);
            int j = 0;
            for(int l = q.B(); j < l; j++)
            {
                u u1 = q.B(j);
                S s = u1.A();
                if(s.isEmpty())
                    continue;
                F f = s.O();
                f.E();
                for(; f.C(); f.B())
                {
                    T t2 = f.H();
                    if(v1.A(t2).E() != 0)
                        continue;
                    double d2 = i.Q(f.H());
                    if(d > d2)
                        d = d2;
                }

            }

            j = 0;
            for(int i1 = q.B(); j < i1; j++)
            {
                u u2 = q.B(j);
                S s1 = u2.A();
                T t = null;
                F f2 = s1.O();
                f2.E();
                for(; f2.C(); f2.B())
                {
                    T t4 = f2.H();
                    H h = v1.A(t4);
                    if(h.E() == 0 && h.A() + t4.S() == 0)
                        i.B(t4, d, i.J(t4));
                }

                f2.E();
                for(; f2.C(); f2.B())
                {
                    T t5 = f2.H();
                    H h1 = v1.A(t5);
                    if(t != null && h1.E() == 0 && h1.A() + t5.S() == 0)
                    {
                        double d4 = r.A(i, u2, v1, t, t5);
                        i.B(t5, i.Q(t) + i.M(t) + d4, i.J(t5));
                    }
                    t = t5;
                }

            }

        } else
        {
            double d1 = (-1.0D / 0.0D);
            int k = 0;
            for(int j1 = q.B(); k < j1; k++)
            {
                u u3 = q.B(k);
                S s2 = u3.A();
                if(s2.isEmpty())
                    continue;
                F f1 = s2.O();
                f1.A();
                for(; f1.C(); f1.G())
                {
                    T t3 = f1.H();
                    if(v1.A(t3).E() != 0)
                        continue;
                    double d3 = i.Q(f1.H()) + i.M(f1.H());
                    if(d1 < d3)
                        d1 = d3;
                }

            }

            k = 0;
            for(int k1 = q.B(); k < k1; k++)
            {
                u u4 = q.B(k);
                S s3 = u4.A();
                T t1 = null;
                F f3 = s3.O();
                f3.A();
                do
                {
                    if(!f3.C())
                        break;
                    T t6 = f3.H();
                    H h2 = v1.A(t6);
                    if(h2.E() == 0 && h2.A() + t6.S() == 0)
                    {
                        i.B(t6, d1 - i.M(t6), i.J(t6));
                        break;
                    }
                    f3.G();
                } while(true);
                f3.A();
                for(; f3.C(); f3.G())
                {
                    T t7 = f3.H();
                    H h3 = v1.A(t7);
                    if(t1 != null && h3.E() == 0 && h3.A() + t7.S() == 0)
                    {
                        double d5 = r.A(i, u4, v1, t7, t1);
                        i.B(t7, i.Q(t1) - d5 - i.M(t7), i.J(t7));
                    }
                    t1 = t7;
                }

            }

        }
    }

    final Z Q;
    private boolean P;
}
