// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.A;
import C.A.D;
import C.A.F;
import C.A.J;
import C.A.K;
import C.A.S;
import C.A.T;
import C.E.W;

public class I
{

    public static S[] B(D d)
    {
        K k = W.A(new int[d.I()]);
        return A(d, k, A(d, k));
    }

    public static int A(D d, K k)
    {
        for(F f = d.H(); f.C(); f.B())
            k.A(f.H(), -1);

        int i = 0;
        C.E.I j = new C.E.I(d.I());
        for(F f1 = d.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            if(k.A(t) == -1)
                A(t, j, k, i++);
        }

        return i;
    }

    public static A A(D d)
    {
        A a = new A();
        S as[] = B(d);
        for(int i = 0; i < as.length - 1; i++)
        {
            J j = d.B(as[i].N(), as[i + 1].M());
            a.add(j);
        }

        return a;
    }

    public static S[] A(D d, K k, int i)
    {
        S as[] = new S[i];
        for(int j = 0; j < i; j++)
            as[j] = new S();

        for(F f = d.H(); f.C(); f.B())
            as[k.A(f.H())].E(f.H());

        return as;
    }

    private static void A(T t, C.E.I i, K k, int j)
    {
        i.A(t);
        k.A(t, j);
        while(!i.A()) 
        {
            t = (T)i.B();
            for(J j1 = t.T(); j1 != null; j1 = j1.F())
            {
                T t1 = j1.E();
                if(k.A(t1) == -1)
                {
                    k.A(t1, j);
                    i.A(t1);
                }
            }

            J j2 = t.W();
            while(j2 != null) 
            {
                T t2 = j2.G();
                if(k.A(t2) == -1)
                {
                    k.A(t2, j);
                    i.A(t2);
                }
                j2 = j2.C();
            }
        }
    }
}
