// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.K.*;

// Referenced classes of package C.G:
//            N

public class t
    implements K
{

    public t(M m, B b, Object obj, N n)
    {
        this(m, b, obj, n, false);
    }

    public t(M m, B b, Object obj, N n, boolean flag)
    {
        E = false;
        F = 0.0D;
        D = 0.0D;
        C = false;
        H = new G(m, b);
        G = obj;
        B = n;
        C = flag;
    }

    public Object L()
    {
        return G;
    }

    public M I()
    {
        return H.S();
    }

    public B P()
    {
        return H;
    }

    public double D()
    {
        return I().B();
    }

    public double G()
    {
        return I().A();
    }

    public double C()
    {
        return P().Q();
    }

    public double E()
    {
        return P().R();
    }

    public G A()
    {
        return H;
    }

    public N H()
    {
        return B;
    }

    public boolean F()
    {
        return C;
    }

    public void O()
    {
        B.A(G);
        E = true;
    }

    public void B(double d)
    {
        F = d;
    }

    public void A(double d)
    {
        D = d;
    }

    public double N()
    {
        return F;
    }

    public double J()
    {
        return D;
    }

    public double M()
    {
        return F + D;
    }

    public Object K()
    {
        return G;
    }

    public String toString()
    {
        return "Label: " + B.toString() + " Location: " + I().toString();
    }

    private G H;
    private Object G;
    private N B;
    private boolean E;
    private double F;
    private double D;
    private boolean C;
}
