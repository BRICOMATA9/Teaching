// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import java.text.DecimalFormat;

public final class M
    implements Comparable
{

    public M()
    {
        A = 0.0D;
        D = 0.0D;
    }

    public M(double d, double d1)
    {
        A = d;
        D = d1;
    }

    public final double B()
    {
        return A;
    }

    public final double A()
    {
        return D;
    }

    public static double B(M m, M m1)
    {
        return Math.sqrt((m.A - m1.A) * (m.A - m1.A) + (m.D - m1.D) * (m.D - m1.D));
    }

    public static M A(M m, M m1)
    {
        return new M(m.A + m1.A, m.D + m1.D);
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(!(obj instanceof M))
        {
            return false;
        } else
        {
            M m = (M)obj;
            return m.A == A && m.D == D;
        }
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(A) << 1 ^ Double.doubleToLongBits(D);
        return (int)(l >> 32 ^ l);
    }

    public String toString()
    {
        return "X: " + C.format(A) + " Y: " + C.format(D);
    }

    public int compareTo(Object obj)
    {
        if(this == obj)
            return 0;
        M m = (M)obj;
        if(A < m.A)
            return -1;
        if(A > m.A)
            return 1;
        if(D < m.D)
            return -1;
        return D <= m.D ? 0 : 1;
    }

    public final double A;
    public final double D;
    private static final DecimalFormat C = new DecimalFormat("#.###");
    public static final M B = new M(0.0D, 0.0D);

}
