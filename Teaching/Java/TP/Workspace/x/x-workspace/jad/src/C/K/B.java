// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;


public class B
    implements Comparable
{

    public B(double d, double d1)
    {
        J = d;
        I = d1;
    }

    public final double Q()
    {
        return J;
    }

    public final double R()
    {
        return I;
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(!(obj instanceof B))
        {
            return false;
        } else
        {
            B b = (B)obj;
            return b.J == J && b.I == I;
        }
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(J) << 1 ^ Double.doubleToLongBits(I);
        return (int)(l ^ l >> 32);
    }

    public String toString()
    {
        return new String("W: " + J + " H: " + I);
    }

    public int compareTo(Object obj)
    {
        B b = (B)obj;
        if(equals(b))
            return 0;
        if(b.J > J)
            return -1;
        if(b.J < J)
            return 1;
        if(b.I > I)
            return -1;
        return b.I >= I ? 0 : 1;
    }

    public final double J;
    public final double I;
}
