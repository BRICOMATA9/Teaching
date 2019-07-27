// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;


public class R
{

    public R()
    {
        this(true);
    }

    public R(boolean flag)
    {
        C = true;
        if(flag)
            C();
    }

    public void C()
    {
        if(C)
        {
            B = A();
            C = false;
        }
    }

    public long B()
    {
        if(C)
            return A;
        else
            return (A + A()) - B;
    }

    public final String toString()
    {
        long l = B();
        long l1 = l / 60000L;
        l -= 60000L * l1;
        long l2 = l / 1000L;
        l -= 1000L * l2;
        long l3 = l;
        String s = "";
        s = s + l1 + " Minutes ";
        s = s + l2 + " Seconds ";
        s = s + l3 + " Millisec.";
        return s;
    }

    private long A()
    {
        return System.currentTimeMillis();
    }

    private long B;
    private long A;
    private boolean C;
}
