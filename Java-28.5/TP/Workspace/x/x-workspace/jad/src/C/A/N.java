// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


// Referenced classes of package C.A:
//            K, H, O, X

final class N
    implements K
{

    N(int i, String s, O o)
    {
        D = false;
        F = i;
        B = s;
        C = o;
    }

    public void A(Object obj, Object obj1)
    {
        try
        {
            ((H)obj).B[F] = obj1;
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            C.A(h, h.B.length, C.B);
            A(obj, obj1);
        }
    }

    public Object D(Object obj)
    {
        return ((H)obj).B[F];
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        C.A(h, h.B.length, C.B);
        return null;
    }

    public void A(Object obj, boolean flag)
    {
        try
        {
            ((H)obj).B[F] = flag ? ((Object) (Boolean.TRUE)) : ((Object) (Boolean.FALSE));
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            C.A(h, h.B.length, C.B);
            A(obj, flag);
        }
    }

    public boolean B(Object obj)
    {
        Object obj1 = ((H)obj).B[F];
        if(obj1 == null)
            return false;
        return ((Boolean)obj1).booleanValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        C.A(h, h.B.length, C.B);
        return B(obj);
    }

    public void A(Object obj, int i)
    {
        try
        {
            if(i >= 0)
            {
                if(i < E.length)
                    ((H)obj).B[F] = E[i];
                else
                    ((H)obj).B[F] = new Integer(i);
            } else
            if(i > -A.length)
                ((H)obj).B[F] = A[-i];
            else
                ((H)obj).B[F] = new Integer(i);
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            C.A(h, h.B.length, C.B);
            A(obj, i);
        }
    }

    public int A(Object obj)
    {
        Object obj1 = ((H)obj).B[F];
        if(obj1 == null)
            return 0;
        return ((Number)obj1).intValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        C.A(h, h.B.length, C.B);
        return A(obj);
    }

    public void A(Object obj, double d)
    {
        try
        {
            ((H)obj).B[F] = new Double(d);
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception)
        {
            H h = (H)obj;
            C.A(h, h.B.length, C.B);
            A(obj, d);
        }
    }

    public double C(Object obj)
    {
        Object obj1 = ((H)obj).B[F];
        if(obj1 == null)
            return 0.0D;
        return ((Number)obj1).doubleValue();
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        H h = (H)obj;
        C.A(h, h.B.length, C.B);
        return C(obj);
    }

    public String toString()
    {
        return getClass() + " : " + B + " : " + F;
    }

    public boolean A()
    {
        return D;
    }

    public void B()
    {
        D = true;
    }

    int F;
    String B;
    boolean D;
    O C;
    static final Integer E[];
    static final Integer A[];

    static 
    {
        E = X.M;
        A = X.I;
    }
}
