// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.A.*;
import C.E.P;
import C.E.W;
import C.G.E.A.*;
import C.G.I;
import C.G.w;
import java.util.Arrays;
import java.util.Comparator;

class B
    implements r
{
    private static final class _A extends w
    {

        protected int B(I j, K k)
        {
            return super.B(j, k);
        }

        private _A()
        {
        }

    }


    public B(r r1)
    {
        D0 = r1;
        D1 = false;
    }

    public void A(I j, Q q, v v1, AA aa)
    {
        if(D0 == null)
            return;
        boolean flag = false;
        M m = j.B("groupingSupport");
        if(m != null)
        {
            i k = (i)m.D(j);
            flag = k != null && k.I();
        }
        if(flag)
            D0.A(j, q, v1, aa);
        else
            B(j, q, v1, aa);
    }

    private void B(I j, Q q, v v1, AA aa)
    {
        P p = new P(j);
        for(F f = j.H(); f.C(); f.B())
        {
            T t = f.H();
            if(t.S() == 0)
                p.B(t);
        }

        K k = W.A();
        _A _la = new _A();
        int l = _la.B(j, k);
        Q aq[];
        if(p.B().F() == 0)
        {
            aq = new Q[l];
        } else
        {
            aq = new Q[l + 1];
            for(F f1 = p.B(); f1.C(); f1.B())
            {
                T t1 = f1.H();
                if(0 == v1.A(t1).E())
                    k.A(t1, l);
                else
                    k.A(t1, -1);
            }

        }
        p.D();
        int ai[][] = new int[aq.length][2];
        for(int i1 = 0; i1 < aq.length; i1++)
        {
            aq[i1] = q.A();
            ai[i1][0] = i1;
        }

        int j1 = 0;
        for(int k1 = q.B(); j1 < k1; j1++)
        {
            u u1 = q.B(j1);
            S s = u1.A();
            for(F f2 = s.O(); f2.C(); f2.B())
            {
                T t2 = f2.H();
                H h = v1.A(t2);
                int i4 = k.A(t2);
                if(0 == h.E() && i4 > -1)
                    ai[i4][1]++;
                Q q1;
                if(i4 > -1)
                {
                    q1 = aq[i4];
                } else
                {
                    T t3 = h.H();
                    if(t3 != null && (t3.S() > 0 || 0 == v1.A(t3).E()))
                    {
                        q1 = aq[k.A(t3)];
                    } else
                    {
                        J j5 = h.C();
                        if(j5 != null)
                            q1 = aq[k.A(j5.G())];
                        else
                            throw new IllegalStateException("Cannot determine layer for " + t2 + ".");
                    }
                }
                if(q1.B() < j1 + 1)
                {
                    for(int j4 = q1.B(); j4 < j1; j4++)
                        q1.A((byte)0, j4);

                    q1.A(u1.D(), u1.B());
                }
                q1.B(j1).A(t2);
            }

        }

        boolean aflag[][] = new boolean[aq.length][];
        for(int l1 = 0; l1 < aq.length; l1++)
        {
            aflag[l1] = new boolean[aq[l1].B()];
            for(int l2 = aq[l1].B(); l2-- > 0;)
                if(aq[l1].B(l2).A().isEmpty())
                {
                    aflag[l1][l2] = true;
                    aq[l1].A(l2);
                } else
                {
                    aflag[l1][l2] = false;
                }

        }

        for(int i2 = 0; i2 < aq.length; i2++)
            D0.A(j, aq[i2], v1, aa);

        for(int j2 = 0; j2 < aq.length; j2++)
        {
            for(int i3 = 0; i3 < aflag[j2].length; i3++)
                if(aflag[j2][i3])
                    aq[j2].A((byte)0, i3);

        }

        if(l < ai.length)
            ai[l][1] = 1;
        if(D1)
            Arrays.sort(ai, new Comparator() {

                public int compare(Object obj, Object obj1)
                {
                    return ((int[])obj)[1] - ((int[])obj1)[1];
                }

            });
        else
            Arrays.sort(ai, new Comparator() {

                public int compare(Object obj, Object obj1)
                {
                    return ((int[])obj1)[1] - ((int[])obj)[1];
                }

            });
        int k2 = 0;
        for(int j3 = q.B(); k2 < j3; k2++)
        {
            S s1 = new S();
            for(int k3 = 0; k3 < aq.length; k3++)
            {
                int l3 = ai[k3][0];
                if(k2 < aq[l3].B())
                    s1.A(aq[l3].B(k2).A());
            }

            q.B(k2).A(s1);
        }

    }

    private final r D0;
    private boolean D1;
}
