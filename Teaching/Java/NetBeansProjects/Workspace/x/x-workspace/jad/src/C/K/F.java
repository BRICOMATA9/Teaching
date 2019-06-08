// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;


// Referenced classes of package C.K:
//            M

public class F
{

    public F(double d, double d1)
    {
        B = d;
        A = d1;
    }

    public F(F f)
    {
        B = f.A();
        A = f.B();
    }

    public F(M m, M m1)
    {
        B = m.B() - m1.B();
        A = m.A() - m1.A();
    }

    public double A()
    {
        return B;
    }

    public double B()
    {
        return A;
    }

    public void C()
    {
        if(B == 0.0D && A == 0.0D)
        {
            return;
        } else
        {
            double d = D();
            B /= d;
            A /= d;
            return;
        }
    }

    public void A(F f)
    {
        B += f.A();
        A += f.B();
    }

    public static F A(F f, F f1)
    {
        F f2 = new F(f);
        f2.A(f1);
        return f2;
    }

    public static M A(M m, F f)
    {
        M m1 = new M(m.B() + f.A(), m.A() + f.B());
        return m1;
    }

    public void A(double d)
    {
        B *= d;
        A *= d;
    }

    public double D()
    {
        return Math.sqrt(B * B + A * A);
    }

    public static F B(F f)
    {
        F f1 = new F(f.A(), f.B());
        f1.C();
        return f1;
    }

    public static F C(F f)
    {
        double d = f.D();
        F f1 = new F(-f.B() / d, f.A() / d);
        return f1;
    }

    public String toString()
    {
        return new String("X: " + A() + " Y: " + B());
    }

    private double B;
    private double A;
}
