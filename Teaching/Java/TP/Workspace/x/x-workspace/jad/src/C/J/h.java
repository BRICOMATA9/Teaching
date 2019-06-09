// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.J;
import C.A.K;
import C.A.L;
import C.A.T;
import C.E.H;

// Referenced classes of package C.J:
//            b

public abstract class h
{
    private static final class _A extends C.E.K
    {

        public void A(Object obj, boolean flag)
        {
            O.A((J)obj, flag);
        }

        public boolean B(Object obj)
        {
            return O.S((J)obj);
        }

        private b O;

        _A(b b1)
        {
            O = b1;
        }
    }

    private static final class _B extends H
    {

        public void A(Object obj, boolean flag)
        {
            G.A((T)obj, flag);
        }

        public boolean B(Object obj)
        {
            return G.V((T)obj);
        }

        private b G;

        _B(b b1)
        {
            G = b1;
        }
    }


    public static K A(b b)
    {
        return new _B(b);
    }

    public static L B(b b)
    {
        return new _A(b);
    }
}
