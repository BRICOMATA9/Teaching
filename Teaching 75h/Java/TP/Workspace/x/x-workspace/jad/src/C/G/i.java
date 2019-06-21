// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.A;
import C.A.F;
import C.A.J;
import C.A.P;
import C.A.T;
import C.A.U;
import C.A.Y;
import C.K.M;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package C.G:
//            g, I, f, M

public class i extends g
{

    public i()
    {
        F0 = new A();
    }

    public void A(I j)
    {
        C.A.M m = j.B(EF);
        if(m != null || EE)
        {
            F1 = new HashMap();
            for(F f1 = j.H(); f1.C(); f1.B())
                F1.put(f1.H(), j.L(f1.H()));

        }
        if(_() != null)
        {
            e(j);
            D(j);
            d(j);
            c(j);
        } else
        {
            c(j);
        }
        F1 = null;
    }

    protected void c(I j)
    {
        if(F1 != null || EE)
        {
            for(F f1 = j.H(); f1.C(); f1.B())
            {
                M m = j.L(f1.H());
                M m1 = (M)F1.get(f1.H());
                if(m.equals(m1) || m1 == null)
                    continue;
                double d1 = m.A - m1.A;
                double d2 = m.D - m1.D;
                for(U u1 = f1.H().M(); u1.C(); u1.B())
                {
                    if(!u1.I().H() || A(j, u1.I()))
                        continue;
                    Y y = j.L(u1.I());
                    if(y.size() <= 0)
                        continue;
                    for(P p = y.I(); p != null; p = p.C())
                    {
                        M m3 = (M)p.A();
                        m3 = new M(m3.A + d1, m3.D + d2);
                        p.A(m3);
                    }

                    j.A(u1.I(), y);
                }

            }

        }
        int ai[][] = new int[2][2];
        int ai1[] = new int[2];
        for(F f2 = j.H(); f2.C(); f2.B())
        {
            T t = f2.H();
            A(j, t, ai);
            int k = 0x7fffffff;
            ai1[0] = ai1[1] = 0;
            for(int l = 0; l < 2; l++)
            {
                for(int i1 = 0; i1 < 2; i1++)
                    if(ai[l][i1] < k)
                    {
                        ai1[0] = l != 0 ? 1 : -1;
                        ai1[1] = i1 != 0 ? 1 : -1;
                        k = ai[l][i1];
                    }

            }

            for(U u = t.Z(); u.C(); u.B())
            {
                J j1 = u.I();
                if(!j1.H() || !A(j, j1))
                    continue;
                C.G.M m2 = j.M(j1);
                f f3 = j.S(j1.G());
                double d3 = f3.C();
                double d4 = f3.A();
                double d5 = f3.B();
                double d6 = f3.D();
                M m4 = null;
                m2.d();
                if(ai1[0] == -1 && ai1[1] == -1)
                {
                    m4 = new M(-d5 / 4D, -d6 / 4D);
                    m2.E(d3 + d5 / 4D, d4 - 20D);
                    m2.E(d3 - 20D, d4 - 20D);
                    m2.E(d3 - 20D, d4 + d6 / 4D);
                } else
                if(ai1[0] == -1 && ai1[1] == 1)
                {
                    m4 = new M(-d5 / 4D, d6 / 4D);
                    m2.E(d3 + d5 / 4D, d4 + d6 + 20D);
                    m2.E(d3 - 20D, d4 + d6 + 20D);
                    m2.E(d3 - 20D, (d4 + d6) - d6 / 4D);
                } else
                if(ai1[0] == 1 && ai1[1] == -1)
                {
                    m4 = new M(d5 / 4D, -d6 / 4D);
                    m2.E((d3 + d5) - d5 / 4D, d4 - 20D);
                    m2.E(d3 + d5 + 20D, d4 - 20D);
                    m2.E(d3 + d5 + 20D, d4 + d6 / 4D);
                } else
                if(ai1[0] == 1 && ai1[1] == 1)
                {
                    m4 = new M(d5 / 4D, d6 / 4D);
                    m2.E((d3 + d5) - d5 / 4D, d4 + d6 + 20D);
                    m2.E(d3 + d5 + 20D, d4 + d6 + 20D);
                    m2.E(d3 + d5 + 20D, (d4 + d6) - d6 / 4D);
                }
                m2.A(m4);
                m2.B(m4);
            }

        }

    }

    private void A(I j, T t, int ai[][])
    {
        ai[0][0] = ai[0][1] = ai[1][0] = ai[1][1];
        for(U u = t.R(); u.C(); u.B())
        {
            J j1 = u.I();
            if(j1.H() && A(j, j1))
                continue;
            M m = j.L(t);
            C.G.M m2 = j.M(j1);
            M m1;
            if(m2.e() == 0)
            {
                if(j1.G() == t)
                    m1 = j.K(j1);
                else
                    m1 = j.O(j1);
            } else
            if(j1.G() == t)
                m1 = m2.B(0);
            else
                m1 = m2.B(m2.e() - 1);
            ai[m1.B() - m.B() >= 0.0D ? 1 : 0][m1.A() - m.A() >= 0.0D ? 1 : 0]++;
        }

    }

    private boolean A(I j, J j1)
    {
        if(EE)
            return false;
        if(F1 != null)
        {
            C.A.M m = j.B(EF);
            return m == null || !m.B(j1);
        } else
        {
            return true;
        }
    }

    private void e(I j)
    {
        for(U u = j.M(); u.C(); u.B())
            if(u.I().H())
            {
                F0.A(u.I());
                j.B(u.I());
            }

    }

    private void d(I j)
    {
        for(; !F0.isEmpty(); j.C(F0.J()));
    }

    private A F0;
    public static final Object EF = "y.layout.SelfLoopLayouter.KEEP_SELF_LOOP_LAYOUT_DPKEY";
    private Map F1;
    private boolean EE;

}
