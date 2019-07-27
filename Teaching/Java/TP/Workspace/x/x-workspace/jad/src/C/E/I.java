// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;


public class I
{

    public I(int i)
    {
        A = new Object[i];
        B = -1;
    }

    public Object B()
    {
        return A[B--];
    }

    public void A(Object obj)
    {
        A[++B] = obj;
    }

    public boolean A()
    {
        return B < 0;
    }

    private Object A[];
    private int B;
}
