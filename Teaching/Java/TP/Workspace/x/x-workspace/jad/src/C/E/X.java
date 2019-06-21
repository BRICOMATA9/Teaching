// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.io.Serializable;

public final class X
    implements Serializable
{

    public X(Object obj, Object obj1)
    {
        B = obj;
        A = obj1;
    }

    public final boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(obj instanceof X)
        {
            X x = (X)obj;
            return (B == null ? x.B == null : B.equals(x.B)) && (A == null ? x.A == null : A.equals(x.A));
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        if(B != null)
            if(A != null)
                return B.hashCode() ^ A.hashCode() >>> 1;
            else
                return B.hashCode();
        if(A != null)
            return A.hashCode() >>> 1;
        else
            return 666;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(50);
        stringbuffer.append('[');
        stringbuffer.append(B);
        stringbuffer.append(':');
        stringbuffer.append(A);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }

    public static final Object A(Object obj, Object obj1)
    {
        return new X(obj, obj1);
    }

    public final Object B;
    public final Object A;
}
