// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;

import C.A.*;

// Referenced classes of package C.F:
//            B, G

public class A
{

    public static int A(D d, K k, M m, M m1)
    {
        return A(d, k, m, m1, null, null, false);
    }

    public static int A(D d, K k, M m, M m1, L l, T t, boolean flag)
    {
        B b = new B();
        return b.A(d, k, m, m1, l, t, flag);
    }

    public static int A(D d, int ai[], int ai1[])
    {
        G g = new G();
        return g.A(d, ai, ai1);
    }
}
