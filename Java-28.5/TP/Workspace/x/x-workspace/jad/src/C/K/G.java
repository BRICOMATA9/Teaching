// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.K;


// Referenced classes of package C.K:
//            B, K, M

public class G extends B
    implements K
{

    public G()
    {
        super(0.0D, 0.0D);
        K = M = 0.0D;
    }

    public G(M m, B b)
    {
        super(b.J, b.I);
        K = m.A;
        M = m.D;
        L = m;
    }

    public G(double d, double d1, double d2, double d3)
    {
        super(d2, d3);
        K = d;
        M = d1;
    }

    public final double T()
    {
        return K;
    }

    public final double U()
    {
        return M;
    }

    public final M S()
    {
        if(L == null)
            L = new M(K, M);
        return L;
    }

    public G A()
    {
        return this;
    }

    public boolean A(double d, double d1)
    {
        return d >= K && d - K < J && d1 >= M && d1 - M < I;
    }

    public boolean A(M m)
    {
        return A(m.A, m.D);
    }

    public String toString()
    {
        return "[" + K + ',' + M + ',' + J + ',' + I + ']';
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(K) >> 1 ^ Double.doubleToLongBits(M);
        return super.hashCode() << 1 ^ (int)(l ^ l >> 32);
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(!(obj instanceof G))
        {
            return false;
        } else
        {
            G g = (G)obj;
            return g.K == K && g.M == M && g.J == J && g.I == I;
        }
    }

    public int compareTo(Object obj)
    {
        G g = (G)obj;
        if(K < g.K)
            return -1;
        if(K > g.K)
            return 1;
        if(M < g.M)
            return -1;
        if(M > g.M)
            return 1;
        else
            return super.compareTo(obj);
    }

    public final double K;
    public final double M;
    private M L;
}
