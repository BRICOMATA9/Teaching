// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.J;
import C.A.M;
import C.A.U;

// Referenced classes of package C.G:
//            g, k, j, c, 
//            I, E, M, X

public class u extends g
    implements k
{

    public u()
    {
        super(null);
        F2 = 0.20000000000000001D;
    }

    public void A(I i)
    {
        j j1 = _();
        if(j1 != null)
            j1.A(i);
        f(i);
    }

    protected void f(I i)
    {
        M m = i.B(c.A);
        M m1 = i.B(c.B);
        M m2 = i.B(E.C);
        M m3 = i.B(E.D);
        for(U u1 = i.M(); u1.C(); u1.B())
        {
            J j1 = u1.I();
            C.G.M m4 = i.H(j1);
            c c1 = null;
            if(m != null && !A(m2, j1))
                c1 = (c)m.D(j1);
            if(c1 != null)
            {
                C.A.T t = j1.G();
                C.K.M m6;
                if(m4.e() > 0)
                    m6 = m4.B(0);
                else
                    m6 = i.K(j1);
                C.K.M m8 = i.O(j1);
                double d1 = m8.A;
                double d3 = m8.D;
                double d5 = d1 - m6.A;
                double d7 = d3 - m6.D;
                double d9 = Math.sqrt(d5 * d5 + d7 * d7);
                if(d9 > 0.001D)
                {
                    d5 /= d9;
                    d7 /= d9;
                    C.K.M m9 = i.L(t);
                    C.K.M m11 = c1.A(i.E(t), d1 - m9.A, d3 - m9.D, d5, d7);
                    if(m11 != null && !A(m9.A + m11.A, m9.D + m11.D, d1, d3))
                    {
                        double d10 = d7 * ((m9.A + m11.A) - m6.A) - d5 * ((m9.D + m11.D) - m6.D);
                        if(Math.abs(d10) > 0.001D)
                        {
                            m4.E(m8.A, m8.D);
                            for(int l = m4.e() - 1; l > 0; l--)
                            {
                                C.K.M m13 = m4.B(l - 1);
                                m4.A(l, m13.A, m13.D);
                            }

                            m4.A(0, m8.A, m8.D);
                        }
                        i.A(j1, m11);
                    }
                }
            }
            c1 = null;
            if(m1 != null && !A(m3, j1))
                c1 = (c)m1.D(j1);
            if(c1 == null)
                continue;
            C.K.M m5;
            if(m4.e() > 0)
                m5 = m4.B(m4.e() - 1);
            else
                m5 = i.O(j1);
            C.K.M m7 = i.K(j1);
            double d = m7.A;
            double d2 = m7.D;
            double d4 = d - m5.A;
            double d6 = d2 - m5.D;
            double d8 = Math.sqrt(d4 * d4 + d6 * d6);
            if(d8 <= 0.001D)
                continue;
            d4 /= d8;
            d6 /= d8;
            C.A.T t1 = j1.E();
            C.K.M m10 = i.L(t1);
            C.K.M m12 = c1.A(i.E(t1), d - m10.A, d2 - m10.D, d4, d6);
            if(m12 == null || A(m10.A + m12.A, m10.D + m12.D, d, d2))
                continue;
            double d11 = d6 * ((m10.A + m12.A) - m5.A) - d4 * ((m10.D + m12.D) - m5.D);
            if(Math.abs(d11) > 0.001D)
                m4.E(m7.A, m7.D);
            i.C(j1, m12);
        }

    }

    protected boolean A(double d, double d1, double d2, double d3)
    {
        return Math.abs(d - d2) < F2 && Math.abs(d1 - d3) < F2;
    }

    boolean A(M m, J j1)
    {
        if(m != null && (m.D(j1) instanceof X))
            return ((X)m.D(j1)).E();
        else
            return false;
    }

    protected double F2;
}
