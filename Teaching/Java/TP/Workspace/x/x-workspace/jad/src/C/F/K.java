// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;

public class K
{

    public static T A(D d, T t, boolean flag, S s)
    {
        if(s.size() == 0)
            return null;
        int ai[] = new int[d.I()];
        F f = s.O();
        T t1 = f.H();
        if(t1 == t)
            return t;
        int i = 1;
        for(; t1 != t; t1 = A(t1, flag))
            ai[t1.Q()] = i++;

        ai[t1.Q()] = i;
        T t3 = A(f.H(), flag);
        f.B();
        for(; t3 != t && f.C(); f.B())
        {
            T t2 = f.H();
            if(t2 == t)
                return t;
            if(ai[t2.Q()] >= ai[t3.Q()])
            {
                t3 = A(t2, flag);
                continue;
            }
            for(; ai[t2.Q()] == 0; t2 = A(t2, flag))
                ai[t2.Q()] = 1;

            if(ai[t2.Q()] != 1 && ai[t2.Q()] > ai[t3.Q()])
                t3 = t2;
        }

        return t3;
    }

    private static T A(T t, boolean flag)
    {
        return flag ? t.W().G() : t.T().E();
    }
}
