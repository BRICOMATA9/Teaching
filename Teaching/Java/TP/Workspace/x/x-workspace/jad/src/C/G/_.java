// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.Y;
import C.K.*;

// Referenced classes of package C.G:
//            K, V, S, f, 
//            G, q, t

public class _
    implements K
{

    public _(int i, double d)
    {
        C = 0x1ff00;
        E = d;
        C = i;
    }

    public double B()
    {
        return E;
    }

    public void A(double d)
    {
        E = d;
    }

    public Object A()
    {
        if((C & 0x100) != 0)
            return H;
        if((C & 4) != 0)
            return F;
        if((C & 1) != 0)
            return G;
        if((C & 8) != 0)
            return I;
        else
            return H;
    }

    public boolean A(Object obj)
    {
        int i = ((Integer)obj).intValue();
        return (C & i) != 0;
    }

    public M A(B b, f f1, Object obj)
    {
        return A(b, f1, ((Integer)obj).intValue());
    }

    public Y A(V v, f f1)
    {
        Y y = new Y();
        G g = v.A();
        for(int i = 0; i < D.length; i++)
        {
            int j = D[i].intValue();
            if((C & j) == 0)
                continue;
            boolean flag = false;
            switch(j)
            {
            case 256: 
            case 512: 
            case 1024: 
            case 2048: 
            case 4096: 
            case 8192: 
            case 16384: 
            case 32768: 
            case 65536: 
                flag = true;
                break;
            }
            M m = A(((B) (g)), f1, j);
            y.add(new S(m, g, D[i], v, flag));
        }

        return y;
    }

    protected M A(B b, f f1, int i)
    {
        double d = (0.0D / 0.0D);
        double d1 = (0.0D / 0.0D);
        switch(i)
        {
        case 256: 
            d = f1.C() + (f1.B() - b.Q()) / 2D;
            d1 = f1.A() + (f1.D() - b.R()) / 2D;
            break;

        case 512: 
            d = f1.C() + (f1.B() - b.Q()) / 2D;
            d1 = (f1.A() + (f1.D() - b.R())) - B();
            break;

        case 1024: 
            d = f1.C() + (f1.B() - b.Q()) / 2D;
            d1 = f1.A() + B();
            break;

        case 2048: 
            d = f1.C() + B();
            d1 = f1.A() + (f1.D() - b.R()) / 2D;
            break;

        case 4096: 
            d = (f1.C() + (f1.B() - b.Q())) - B();
            d1 = f1.A() + (f1.D() - b.R()) / 2D;
            break;

        case 8192: 
            d = f1.C() + B();
            d1 = f1.A() + B();
            break;

        case 16384: 
            d = (f1.C() + (f1.B() - b.Q())) - B();
            d1 = f1.A() + B();
            break;

        case 32768: 
            d = f1.C() + B();
            d1 = (f1.A() + (f1.D() - b.R())) - B();
            break;

        case 65536: 
            d = (f1.C() + (f1.B() - b.Q())) - B();
            d1 = (f1.A() + (f1.D() - b.R())) - B();
            break;

        case 1: // '\001'
            d = f1.C() + (f1.B() - b.Q()) / 2D;
            d1 = f1.A() - b.R() - B();
            break;

        case 2: // '\002'
            d = f1.C() - b.Q() - B();
            d1 = f1.A() - b.R();
            break;

        case 4: // '\004'
            d = f1.C() + f1.B() + B();
            d1 = f1.A() - b.R();
            break;

        case 8: // '\b'
            d = f1.C() + f1.B() + B();
            d1 = f1.A() + (f1.D() - b.R()) / 2D;
            break;

        case 16: // '\020'
            d = f1.C() - b.Q() - B();
            d1 = f1.A() + (f1.D() - b.R()) / 2D;
            break;

        case 32: // ' '
            d = f1.C() + (f1.B() - b.Q()) / 2D;
            d1 = f1.A() + f1.D() + B();
            break;

        case 64: // '@'
            d = f1.C() - b.Q() - B();
            d1 = f1.A() + f1.D();
            break;

        case 128: 
            d = f1.C() + f1.B() + B();
            d1 = f1.A() + f1.D();
            break;
        }
        return new M(d, d1);
    }

    public Object A(G g, f f1)
    {
        C.G.G g1 = new C.G.G();
        g1.A(g);
        Y y = A(((V) (g1)), f1);
        if(y.isEmpty())
            return A();
        else
            return q.A(y, g.S()).L();
    }

    static final Integer D[] = {
        new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256), new Integer(512), 
        new Integer(1024), new Integer(2048), new Integer(4096), new Integer(8192), new Integer(16384), new Integer(32768), new Integer(0x10000)
    };
    private static final Object H = new Integer(256);
    private static final Object F = new Integer(4);
    private static final Object G = new Integer(1);
    private static final Object I = new Integer(8);
    private double E;
    private int C;

}
