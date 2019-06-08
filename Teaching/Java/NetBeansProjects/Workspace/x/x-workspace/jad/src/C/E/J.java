// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import C.A.*;

public class J
    implements M
{

    public J(M m, D d, Object obj)
    {
        a = m;
        A(d, obj);
        A(m);
    }

    private void A(M m)
    {
        if(m instanceof G)
            _ = new Q() {

                public Object D(Object obj)
                {
                    Object obj1 = Z.D(obj);
                    if(obj1 != null)
                        return obj1;
                    else
                        return a.D(obj);
                }

                public int A(Object obj)
                {
                    throw new IllegalStateException("Only get(Object) may be used");
                }

                public double C(Object obj)
                {
                    throw new IllegalStateException("Only get(Object) may be used");
                }

                public boolean B(Object obj)
                {
                    throw new IllegalStateException("Only get(Object) may be used");
                }

                public void A(Object obj, Object obj1)
                {
                    ((G)a).A(obj, obj1);
                }

                public void A(Object obj, int i)
                {
                    throw new IllegalStateException("Only set(Object) may be used");
                }

            };
    }

    public void A(D d, Object obj)
    {
        if(obj == null)
            throw new IllegalArgumentException("Key must be non-null!");
        Z = d.B(obj);
        X = obj;
        Y = d;
        if(Z != null)
        {
            d.D(obj);
            d.A(obj, this);
        } else
        {
            d.A(obj, a);
        }
    }

    public void E()
    {
        if(X == null)
            throw new IllegalStateException("Provider must have been wrapped previously!");
        M m = Y.B(X);
        if(m != null)
            Y.D(X);
        if(Z != null)
            Y.A(X, Z);
    }

    public Object D(Object obj)
    {
        Object obj1 = a.D(obj);
        if(obj1 != null)
            return obj1;
        if(Z != null)
            return Z.D(obj);
        else
            return null;
    }

    public boolean B(Object obj)
    {
        throw new UnsupportedOperationException("Object supported only!");
    }

    public double C(Object obj)
    {
        throw new UnsupportedOperationException("Object supported only!");
    }

    public int A(Object obj)
    {
        throw new UnsupportedOperationException("Object supported only!");
    }

    private M Z;
    private Object X;
    private D Y;
    private M a;
    private Q _;


}
