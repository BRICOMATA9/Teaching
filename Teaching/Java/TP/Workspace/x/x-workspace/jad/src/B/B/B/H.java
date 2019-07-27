// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.B;


public abstract class H
    implements Cloneable
{

    protected H()
    {
        B = "";
        D = "";
        A = 62;
    }

    public int D()
    {
        return C;
    }

    public void A(int i)
    {
        C = i;
    }

    public String C()
    {
        return B;
    }

    public void B(String s)
    {
        B = s;
    }

    public String B()
    {
        return D;
    }

    public void A(String s)
    {
        D = s;
    }

    public int A()
    {
        return A;
    }

    public Object clone()
    {
        return super.clone();
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        return null;
    }

    private int C;
    private String B;
    private String D;
    private int A;
}
