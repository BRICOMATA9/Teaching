// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;


// Referenced classes of package C.K:
//            K, M, F, G

public class J
    implements K
{

    public J(M m, M m1)
    {
        S = m;
        Q = m1;
        if(m1.A == m.A)
        {
            if(m.D < m1.D)
            {
                P = 1.7976931348623157E+308D;
                O = (0.0D / 0.0D);
            } else
            {
                P = -1.7976931348623157E+308D;
                O = (0.0D / 0.0D);
            }
        } else
        {
            P = (m1.D - m.D) / (m1.A - m.A);
            O = m.D - m.A * P;
        }
    }

    public M Y()
    {
        return S;
    }

    public M W()
    {
        return Q;
    }

    public double V()
    {
        return X().D();
    }

    public G A()
    {
        double d = S.A >= Q.A ? Q.A : S.A;
        double d1 = S.A <= Q.A ? Q.A : S.A;
        double d2 = S.D >= Q.D ? Q.D : S.D;
        double d3 = S.D <= Q.D ? Q.D : S.D;
        return new G(d, d2, d1 - d, d3 - d2);
    }

    public boolean A(G g)
    {
        return A(g, S.A, S.D, Q.A, Q.D);
    }

    public static final boolean A(G g, double d, double d1, double d2, double d3)
    {
        double d4 = g.K;
        double d5 = g.K + g.Q();
        double d6 = g.M;
        double d7 = g.M + g.R();
        int i = 0;
        int j = 0;
        if(d <= d4)
            i |= 1;
        if(d >= d5)
            i |= 2;
        if(d1 <= d6)
            i |= 4;
        if(d1 >= d7)
            i |= 8;
        if(d2 <= d4)
            j |= 1;
        if(d2 >= d5)
            j |= 2;
        if(d3 <= d6)
            j |= 4;
        if(d3 >= d7)
            j |= 8;
        if((i & j) != 0)
            return false;
        if((i | j) == 0)
            return true;
        double d8 = (d3 - d1) / (d2 - d);
        double d9 = d + (d7 - d1) / d8;
        if(d9 > d4 && d9 < d5)
            return true;
        double d10 = d + (d6 - d1) / d8;
        if(d10 > d4 && d10 < d5)
            return true;
        double d11 = d1 + (d4 - d) * d8;
        if(d11 > d6 && d11 < d7)
            return true;
        double d12 = d1 + (d5 - d) * d8;
        return d12 > d6 && d12 < d7;
    }

    public F X()
    {
        return new F(Q, S);
    }

    public String toString()
    {
        return "SP: " + S.toString() + " TP: " + Q.toString();
    }

    private M S;
    private M Q;
    private double P;
    private double O;
    private static double R = 1E-08D;

}
