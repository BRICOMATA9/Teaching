// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;
import C.E.O;
import java.util.ArrayList;
import java.util.List;

class G
{

    public G()
    {
    }

    public int A(D d, int ai[], int ai1[])
    {
        H = new P[d.I()];
        D = new S();
        C = ai;
        G = ai1;
        A = new int[d.I()];
        B = 0;
        I = new O(H.length);
        E = new ArrayList(d.I() * 2);
        F = 0;
        T t = d.L();
        int i = t.Q();
        I.A(t);
        H[i] = D.B(t);
        do
        {
            if(I.B())
                break;
            B();
            if(D.size() + F < d.I())
                A();
        } while(true);
        int j = 0;
        for(int k = E.size() - 1; k >= 0; k--)
        {
            Object obj = E.get(k);
            if(obj instanceof Integer)
                j += ((Integer)obj).intValue();
            else
                C[((T)obj).Q()] += j;
        }

        int l = 0x7fffffff;
        int i1 = 0;
        for(int j1 = C.length - 1; j1 >= 0; j1--)
        {
            l = Math.min(l, C[j1]);
            i1 = Math.max(i1, C[j1]);
        }

        for(int k1 = ai.length - 1; k1 >= 0; k1--)
            ai[k1] = ai[k1] - l;

        H = null;
        D = null;
        E = null;
        G = null;
        I = null;
        C = null;
        return (i1 - l) + 1;
    }

    private void A()
    {
        B++;
        int i = 0x7fffffff;
        boolean flag = true;
        for(P p = D.I(); p != null; p = p.C())
        {
            T t = (T)p.A();
            boolean flag1 = true;
            for(J j1 = t.W(); j1 != null; j1 = j1.C())
            {
                T t2 = j1.G();
                if(H[t2.Q()] != null)
                    continue;
                flag1 = false;
                int l = C[t.Q()] - C[t2.Q()] - G[j1.L()];
                if(l <= 0)
                    continue;
                if(l < i)
                {
                    i = l;
                    I.A();
                    B++;
                    I.B(t2);
                    A[t2.Q()] = B;
                    flag = true;
                    continue;
                }
                if(flag && l == i && A[t2.Q()] < B)
                {
                    I.B(t2);
                    A[t2.Q()] = B;
                }
            }

            for(J j2 = t.T(); j2 != null; j2 = j2.F())
            {
                T t3 = j2.E();
                if(H[t3.Q()] != null)
                    continue;
                flag1 = false;
                int i1 = C[t3.Q()] - C[t.Q()] - G[j2.L()];
                if(i1 <= 0)
                    continue;
                if(i1 < i)
                {
                    i = i1;
                    I.A();
                    B++;
                    I.B(t3);
                    A[t3.Q()] = B;
                    flag = false;
                    continue;
                }
                if(!flag && i1 == i && A[t3.Q()] < B)
                {
                    I.B(t3);
                    A[t3.Q()] = B;
                }
            }

            if(flag1)
            {
                E.add(t);
                F++;
                D.A(H[t.Q()]);
            }
        }

        int j = flag ? -i : i;
        E.add(new Integer(j));
        for(P p1 = D.I(); p1 != null; p1 = p1.C())
            C[((T)p1.A()).Q()] += j;

        for(int k = I.C(); k > 0; k--)
        {
            T t1 = (T)I.E();
            H[t1.Q()] = D.B(t1);
            I.B(t1);
        }

    }

    private void B()
    {
        do
        {
            if(I.B())
                break;
            boolean flag = true;
            T t = (T)I.E();
            int i = t.Q();
            for(J j = t.T(); j != null; j = j.F())
            {
                T t1 = j.E();
                if(H[t1.Q()] != null)
                    continue;
                int k = C[t1.Q()] - C[i] - G[j.L()];
                if(k == 0)
                {
                    I.B(t1);
                    H[t1.Q()] = D.B(t1);
                } else
                {
                    flag = false;
                }
            }

            for(J j1 = t.W(); j1 != null; j1 = j1.C())
            {
                T t2 = j1.G();
                if(H[t2.Q()] != null)
                    continue;
                int l = C[i] - C[t2.Q()] - G[j1.L()];
                if(l == 0)
                {
                    I.B(t2);
                    H[t2.Q()] = D.B(t2);
                } else
                {
                    flag = false;
                }
            }

            if(flag)
            {
                E.add(t);
                F++;
                D.A(H[i]);
            }
        } while(true);
    }

    private S D;
    private P H[];
    private List E;
    private int F;
    private int C[];
    private int G[];
    private int A[];
    private int B;
    private O I;
}
