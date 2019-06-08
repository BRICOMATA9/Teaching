// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.B;


// Referenced classes of package B.B.B:
//            C

public class A
    implements C, Cloneable
{

    public A()
    {
        I = "";
    }

    public String H()
    {
        return I;
    }

    public void D(String s)
    {
        I = s;
    }

    public Object clone()
    {
        return super.clone();
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        throw new InternalError("clone operation not supported");
    }

    String I;
}
