// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.C;


// Referenced classes of package C.C:
//            B

class D
    implements B
{
    static class _A
        implements _B
    {

        public double A(double d)
        {
            if(0.0D >= d)
                return 0.0D;
            if(1.0D <= d)
                return 1.0D;
            if(A > d)
                return (B / (2D * A)) * d * d;
            if(C < d)
            {
                double d1 = 1.0D - d;
                return 1.0D - (B / (2D - 2D * C)) * d1 * d1;
            } else
            {
                return B * (d - A / 2D);
            }
        }

        private final double B;
        private final double A;
        private final double C;

        _A(double d, double d1)
        {
            B = 2D / ((1.0D - d) + d1);
            A = d;
            C = d1;
        }
    }

    public static interface _B
    {

        public abstract double A(double d);
    }


    D(B b, _B _pb)
    {
        A = b;
        B = _pb;
    }

    public void A()
    {
        A.A();
    }

    public void A(double d)
    {
        A.A(B.A(d));
    }

    public void C()
    {
        A.C();
    }

    public long B()
    {
        return A.B();
    }

    private final B A;
    private _B B;
}
