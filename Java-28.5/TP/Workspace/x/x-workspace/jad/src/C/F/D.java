// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.F;


public class D extends RuntimeException
{

    public D(String s)
    {
        super(s);
    }

    public static void A()
    {
        A("");
    }

    public static void A(String s)
    {
        if(Thread.interrupted())
            throw new D(s);
        else
            return;
    }
}
