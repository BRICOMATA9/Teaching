// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.A;
import C.A.D;
import C.A.J;
import C.A.K;
import C.A.L;
import C.A.M;
import C.A.T;
import C.A.U;
import C.E.V;

// Referenced classes of package C.F:
//            H, E

public class F
{

    public static void B(D d, L l)
    {
        A(d, l, V.A(new Double(1.0D)));
    }

    public static void A(D d, L l, M m)
    {
        for(U u = d.M(); u.C(); u.B())
            l.A(u.I(), false);

        boolean aflag[] = new boolean[d.S()];
        double ad[] = new double[d.I()];
        double ad1[] = new double[d.I()];
        C.E.A.D d1 = new C.E.A.D(d);
        for(C.A.F f = d.H(); f.C(); f.B())
        {
            T t1 = f.H();
            double d2 = 0.0D;
            double d3 = 0.0D;
            for(J j4 = t1.T(); j4 != null; j4 = j4.F())
                d3 += m.C(j4);

            for(J j5 = t1.W(); j5 != null; j5 = j5.C())
                d2 += m.C(j5);

            d1.A(t1, Math.min(d3, d2));
            ad[t1.Q()] = d3;
            ad1[t1.Q()] = d2;
        }

        while(!d1.A()) 
        {
            T t = d1.B();
            int i = t.Q();
            if(ad1[i] >= ad[i])
            {
                for(J j = t.T(); j != null; j = j.F())
                {
                    int k = j.L();
                    if(!aflag[k])
                    {
                        T t2 = j.E();
                        int i2 = t2.Q();
                        ad1[i2] -= m.C(j);
                        l.A(j, true);
                        d1.B(t2, Math.min(ad1[i2], ad[i2]));
                        aflag[k] = true;
                    }
                }

                J j1 = t.W();
                while(j1 != null) 
                {
                    int i1 = j1.L();
                    if(!aflag[i1])
                    {
                        T t3 = j1.G();
                        int k2 = t3.Q();
                        ad[k2] -= m.C(j1);
                        d1.B(t3, Math.min(ad1[k2], ad[k2]));
                        aflag[i1] = true;
                    }
                    j1 = j1.C();
                }
            } else
            {
                for(J j2 = t.T(); j2 != null; j2 = j2.F())
                {
                    int k1 = j2.L();
                    if(!aflag[k1])
                    {
                        T t4 = j2.E();
                        int l2 = t4.Q();
                        ad1[l2] -= m.C(j2);
                        d1.B(t4, Math.min(ad1[l2], ad[l2]));
                        aflag[k1] = true;
                    }
                }

                J j3 = t.W();
                while(j3 != null) 
                {
                    int l1 = j3.L();
                    if(!aflag[l1])
                    {
                        T t5 = j3.G();
                        int i3 = t5.Q();
                        ad[i3] -= m.C(j3);
                        l.A(j3, true);
                        d1.B(t5, Math.min(ad1[i3], ad[i3]));
                        aflag[l1] = true;
                    }
                    j3 = j3.C();
                }
            }
        }
    }

    public static void A(D d, L l)
    {
        int ai[] = new int[d.I()];
        C.F.H.D(d, ai);
        for(U u = d.M(); u.C(); u.B())
        {
            J j = u.I();
            l.A(j, false);
            if(ai[j.G().Q()] < ai[j.E().Q()])
                l.A(j, true);
        }

    }

    public static A A(D d, boolean flag)
    {
        final A cycle = new A();
        E e = new E() {

            public void A(J j, T t, boolean flag1)
            {
                if(!K)
                    if(F.D(t) == G)
                    {
                        K = true;
                        int i = cycle.size();
                        U u = cycle.L();
                        u.A();
                        while(u.C() && u.I().G() != t && u.I().E() != t) 
                        {
                            u.G();
                            i--;
                        }
                        if(j.H())
                            cycle.clear();
                        else
                            while(--i > 0) 
                                cycle.C();
                        cycle.E(j);
                    } else
                    if(flag1)
                        cycle.E(j);
            }

            public void A(J j, T t)
            {
                if(!K)
                    cycle.A(cycle.G());
            }

            boolean K;

            
            {
                K = false;
            }
        };
        e.B(flag);
        e.A(d);
        return cycle;
    }
}
