// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;

import C.E.M;

// Referenced classes of package C.K:
//            M

public class I
{

    public I(C.K.M m, C.K.M m1)
    {
        if(A(m.B(), m1.B()))
        {
            if(A(m.A(), m1.A()))
                M.A("AffineLine: Points are equal !!!");
            B = 1.0D;
            A = 0.0D;
            C = -m.B();
            return;
        } else
        {
            A = -1D;
            double d = (m1.A() - m.A()) / (m1.B() - m.B());
            double d1 = m.A() - m.B() * d;
            B = d;
            C = d1;
            return;
        }
    }

    public double C()
    {
        return B;
    }

    public double B()
    {
        return A;
    }

    public double A()
    {
        return C;
    }

    public String toString()
    {
        return new String("a: " + B + " b: " + A + " c: " + C);
    }

    public static C.K.M A(I i, I j)
    {
        if(A(i.C()) && A(j.C()))
            return null;
        if(A(i.B()) && A(j.B()))
            return null;
        if(A(j.B()))
        {
            I k = i;
            i = j;
            j = k;
        }
        double d4 = i.C();
        double d5 = i.B();
        double d6 = -i.A();
        if(!A(d4))
        {
            double d7 = j.B() - (j.C() / d4) * d5;
            double d8 = -j.A() - (j.C() / d4) * d6;
            double d2 = d8 / d7;
            double d = (d6 - d2 * d5) / d4;
            return new C.K.M(d, d2);
        } else
        {
            double d3 = d6 / d5;
            double d1 = (j.A() + j.B() * d3) / -j.C();
            return new C.K.M(d1, d3);
        }
    }

    private static boolean A(double d)
    {
        return A(d, 0.0D);
    }

    private static boolean A(double d, double d1)
    {
        return Math.abs(d - d1) < 1.0000000000000001E-05D;
    }

    private double B;
    private double A;
    private double C;
}
