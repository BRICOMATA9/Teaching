// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;

public class L
{

    public static S[] A(D d, S s, K k)
    {
        return A(d, s, false, k);
    }

    public static S[] A(D d, S s, boolean flag, K k)
    {
        return A(d, s, flag, k, 0);
    }

    public static S[] A(D d, S s, boolean flag, K k, int i)
    {
        Y y = new Y();
        if(d.J())
            return new S[0];
        S s1 = new S();
        int j = 0;
        for(F f = d.H(); f.C(); f.B())
        {
            T t = f.H();
            k.A(t, -1);
        }

        for(F f1 = s.O(); f1.C(); f1.B())
        {
            T t1 = f1.H();
            k.A(t1, j);
            s1.E(t1);
        }

        do
        {
            if(s1.isEmpty())
                break;
            S s2 = s1;
            y.E(s2);
            s1 = new S();
            j++;
            for(F f2 = s2.O(); f2.C(); f2.B())
            {
                T t2 = f2.H();
                for(F f3 = flag ? t2.a() : t2.X(); f3.C(); f3.B())
                {
                    T t3 = f3.H();
                    if(k.A(t3) == -1)
                    {
                        k.A(t3, j);
                        s1.E(t3);
                    }
                }

            }

        } while(i <= 0 || i != j);
        return (S[])y.toArray(new S[y.size()]);
    }
}
