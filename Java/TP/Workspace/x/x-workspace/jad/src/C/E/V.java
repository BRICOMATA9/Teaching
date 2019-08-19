// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.M;

// Referenced classes of package C.E:
//            T

public class V
{
    static class _A extends T
    {

        public Object D(Object obj)
        {
            return q;
        }

        public double C(Object obj)
        {
            return ((Number)q).doubleValue();
        }

        public int A(Object obj)
        {
            return ((Number)q).intValue();
        }

        public boolean B(Object obj)
        {
            return ((Boolean)q).booleanValue();
        }

        private Object q;

        _A(Object obj)
        {
            q = obj;
        }
    }


    public static M A(Object obj)
    {
        return new _A(obj);
    }
}
