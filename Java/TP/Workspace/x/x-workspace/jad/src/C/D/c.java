// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.D;


class c
{

    static boolean A(Object obj, Object obj1)
    {
        return obj1 != null && !obj1.equals(obj) || obj != null && !obj.equals(obj1);
    }

    static Boolean A(boolean flag)
    {
        return flag ? Boolean.TRUE : Boolean.FALSE;
    }

    static Boolean A(Object obj)
    {
        if(obj instanceof Boolean)
            return (Boolean)obj;
        if(obj instanceof String)
            return Boolean.valueOf((String)obj);
        else
            return Boolean.FALSE;
    }

    private static final Double B = new Double(0.0D);
    private static final Integer A = new Integer(0);

}
