// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.J;
import C.A.M;
import java.util.Comparator;

public class C
{
    private static class _C
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            return A.A(obj) - A.A(obj1);
        }

        M A;

        public _C(M m)
        {
            A = m;
        }
    }

    private static class _A
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            double d = A.C(obj) - A.C(obj1);
            return d <= 0.0D ? d >= 0.0D ? 0 : -1 : 1;
        }

        M A;

        public _A(M m)
        {
            A = m;
        }
    }

    private static class _B
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            C.A.T t = ((J)obj).E();
            C.A.T t1 = ((J)obj1).E();
            return A.A(t) - A.A(t1);
        }

        M A;

        public _B(M m)
        {
            A = m;
        }
    }


    public static Comparator B(M m)
    {
        return new _B(m);
    }

    public static Comparator A(M m)
    {
        return new _C(m);
    }

    public static Comparator C(M m)
    {
        return new _A(m);
    }
}
