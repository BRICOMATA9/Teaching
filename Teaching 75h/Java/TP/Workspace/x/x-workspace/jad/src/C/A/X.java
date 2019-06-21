// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


// Referenced classes of package C.A:
//            L, H, O

final class X
    implements L
{

    X(int i, String s, O o)
    {
        L = false;
        N = i;
        J = s;
        K = o;
    }

    public void A(Object obj, Object obj1)
    {
        try
        {
            ((H)obj).B[N] = obj1;
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            K.A(h, h.B.length, K.B);
            A(obj, obj1);
        }
    }

    public Object D(Object obj)
    {
        return ((H)obj).B[N];
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        K.A(h, h.B.length, K.B);
        return null;
    }

    public void A(Object obj, boolean flag)
    {
        try
        {
            ((H)obj).B[N] = flag ? ((Object) (Boolean.TRUE)) : ((Object) (Boolean.FALSE));
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            K.A(h, h.B.length, K.B);
            A(obj, flag);
        }
    }

    public boolean B(Object obj)
    {
        Object obj1 = ((H)obj).B[N];
        if(obj1 == null)
            return false;
        return ((Boolean)obj1).booleanValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        K.A(h, h.B.length, K.B);
        return B(obj);
    }

    public void A(Object obj, int i)
    {
        try
        {
            if(i >= 0)
            {
                if(i < M.length)
                    ((H)obj).B[N] = M[i];
                else
                    ((H)obj).B[N] = new Integer(i);
            } else
            if(i > -I.length)
                ((H)obj).B[N] = I[-i];
            else
                ((H)obj).B[N] = new Integer(i);
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            K.A(h, h.B.length, K.B);
            A(obj, i);
        }
    }

    public int A(Object obj)
    {
        Object obj1 = ((H)obj).B[N];
        if(obj1 == null)
            return 0;
        return ((Number)obj1).intValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        K.A(h, h.B.length, K.B);
        return A(obj);
    }

    public void A(Object obj, double d)
    {
        try
        {
            ((H)obj).B[N] = new Double(d);
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            K.A(h, h.B.length, K.B);
            A(obj, d);
        }
    }

    public double C(Object obj)
    {
        Object obj1 = ((H)obj).B[N];
        if(obj1 == null)
            return 0.0D;
        return ((Number)obj1).doubleValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        K.A(h, h.B.length, K.B);
        return C(obj);
    }

    public String toString()
    {
        return getClass() + " : " + J + " : " + N;
    }

    public boolean C()
    {
        return L;
    }

    public void D()
    {
        L = true;
    }

    int N;
    String J;
    boolean L;
    O K;
    static final Integer M[];
    static final Integer I[];

    static 
    {
        M = new Integer[127];
        I = new Integer[127];
        for(int i = M.length - 1; i >= 0; i--)
            M[i] = new Integer(i);

        for(int j = I.length - 1; j >= 0; j--)
            I[j] = new Integer(-j);

    }
}
