// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.A;
import C.A.D;
import C.A.F;
import C.A.J;
import C.A.R;
import C.A.S;
import C.A.T;
import C.A.U;
import C.A.Y;
import C.E.W;

// Referenced classes of package C.F:
//            H

public class C
{

    public static void A(D d)
    {
        B(d, null);
    }

    public static void B(D d, A a)
    {
        int ai[] = C(d);
        S s = H.C(d, ai);
        Y y = new Y();
        A(s, y);
        S as[] = new S[y.size()];
        y.toArray(as);
        int ai1[][] = A(as, H.C(d, ai), ai);
        for(F f = d.H(); f.C(); f.B())
        {
            T t = f.H();
            int i = ai[t.Q()];
            for(int j = 0; j < as.length; j++)
            {
                for(F f1 = as[j].O(); f1.C(); f1.B())
                {
                    T t1 = f1.H();
                    if(ai1[j][i] > ai[t1.Q()] || t == t1 || d.A(t, t1))
                        continue;
                    J j1 = d.B(t, t1);
                    if(a != null)
                        a.add(j1);
                }

            }

        }

    }

    public static void B(D d)
    {
        A(d, ((A) (null)));
    }

    public static void A(D d, A a)
    {
        int ai[] = C(d);
        S s = H.C(d, ai);
        T at[] = s.Q();
        int i = ai.length;
        boolean aflag[][] = new boolean[i][i];
        boolean aflag1[] = new boolean[i];
        boolean aflag2[];
        if(a != null)
            aflag2 = new boolean[d.S()];
        else
            aflag2 = null;
        for(int j = i - 1; j > -1; j--)
        {
            for(int k = 0; k < i; k++)
                aflag[j][k] = false;

            aflag[j][j] = true;
            aflag1[j] = true;
            T t = at[j];
            for(J j1 = t.T(); j1 != null; j1 = j1.F())
            {
                T t1 = j1.E();
                int i1 = ai[t1.Q()];
                if(!aflag1[i1])
                {
                    for(int k1 = i1; k1 < i; k1++)
                        if(aflag[i1][k1] && !aflag1[k1])
                        {
                            aflag1[k1] = true;
                            aflag[j][k1] = true;
                        }

                }
label0:
                for(int l1 = j + 1; l1 < i1; l1++)
                {
                    if(!aflag[j][l1] || !aflag[l1][i1])
                        continue;
                    if(a != null)
                    {
                        if(t1.P() < t.Y())
                        {
                            J j2 = t1.W();
                            do
                            {
                                if(j2 == null)
                                    continue label0;
                                if(j2.G() == t && !aflag2[j2.L()])
                                {
                                    aflag2[j2.L()] = true;
                                    a.add(j2);
                                }
                                j2 = j2.C();
                            } while(true);
                        }
                        J j3 = t.T();
                        do
                        {
                            if(j3 == null)
                                continue label0;
                            if(j3.E() == t1 && !aflag2[j3.L()])
                            {
                                aflag2[j3.L()] = true;
                                a.add(j3);
                            }
                            j3 = j3.F();
                        } while(true);
                    }
                    if(t1.P() < t.Y())
                    {
                        J j4 = t1.W();
                        do
                        {
                            if(j4 == null)
                                continue label0;
                            if(j4.G() == t)
                                d.E(j4);
                            j4 = j4.C();
                        } while(true);
                    }
                    for(J j5 = t.T(); j5 != null; j5 = j5.F())
                        if(j5.E() == t1)
                            d.E(j5);

                }

            }

            for(int l = j; l < i; l++)
                if(aflag[j][l])
                    aflag1[l] = false;

        }

    }

    private static void A(S s, Y y)
    {
        S s1;
        for(; !s.isEmpty(); y.add(s1))
        {
            s1 = new S();
            T t = s.N();
            s.remove(t);
            s1.add(t);
            for(F f = s.O(); f.C(); f.B())
            {
                T t1 = f.H();
                if(t.D(t1) != null)
                {
                    s.remove(t1);
                    s1.add(t1);
                    t = t1;
                }
            }

        }

    }

    private static int[][] A(S as[], S s, int ai[])
    {
        int ai1[] = new int[ai.length];
        for(int i = 0; i < as.length; i++)
        {
            for(F f = as[i].O(); f.C(); f.B())
                ai1[ai[f.H().Q()]] = i;

        }

        int ai2[][] = new int[as.length][ai1.length];
        for(int j = 0; j < as.length; j++)
        {
            for(int k = 0; k < ai1.length; k++)
                ai2[j][k] = 0x7fffffff;

        }

        F f1 = s.O();
        f1.A();
        for(; f1.C(); f1.G())
        {
            int l = ai[f1.H().Q()];
            for(U u = f1.H().Z(); u.C(); u.B())
            {
                int i1 = ai[u.I().E().Q()];
                if(i1 > ai2[ai1[i1]][i1])
                    continue;
                for(int j1 = 0; j1 < as.length; j1++)
                    ai2[j1][l] = Math.min(ai2[j1][l], ai2[j1][i1]);

            }

            ai2[ai1[l]][l] = l;
        }

        return ai2;
    }

    private static int[] C(D d)
    {
        int ai[] = new int[d.G()];
        boolean flag = H.B(d, ai);
        if(!flag)
        {
            throw new R("Graph must be acyclic for this operation");
        } else
        {
            d.A(null, C.E.C.B(W.A(ai)));
            return ai;
        }
    }
}
