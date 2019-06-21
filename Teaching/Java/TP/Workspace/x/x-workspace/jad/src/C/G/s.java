// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.G;

import C.A.Y;
import C.K.*;

// Referenced classes of package C.G:
//            Z, J, W, q, 
//            t, D, l, n, 
//            f, M

public class s
    implements Z
{

    public s(int i)
    {
        B = 63;
        H = 2D;
        B = i;
        if(i == 128 || i == 448)
            E = new C.G.J((byte)0);
        else
            E = new C.G.J((byte)1);
    }

    public void A(double d)
    {
        H = d;
    }

    public Object A()
    {
        if((B & 0x80) != 0)
            return G;
        if((B & 0x40) != 0)
            return D;
        if((B & 0x10) != 0)
            return A;
        if((B & 8) != 0)
            return F;
        else
            return G;
    }

    public Object A(G g, C.G.M m, f f1, f f2)
    {
        W w = new W();
        w.A(g);
        Y y = A(((D) (w)), m, f1, f2);
        if(y.isEmpty())
            return A();
        else
            return q.A(y, g.S()).L();
    }

    public boolean A(Object obj)
    {
        int i = ((Integer)obj).intValue();
        return (B & i) != 0;
    }

    public M A(B b, C.G.M m, f f1, f f2, Object obj)
    {
        int i = obj == null ? ((Number)A()).intValue() : ((Number)obj).intValue();
        return A(b, m, f1, f2, i);
    }

    public Y A(D d, C.G.M m, f f1, f f2)
    {
        Y y = new Y();
        G g = d.A();
        for(int i = 0; i < C.length; i++)
        {
            int j = C[i].intValue();
            if((B & j) == 0)
                continue;
            boolean flag = false;
            if(j == 128)
                flag = true;
            else
            if(j == 64)
                flag = true;
            else
            if(j == 256)
                flag = true;
            M m1 = A(((B) (g)), m, f1, f2, j);
            y.add(new l(m1, g, C[i], d, flag));
        }

        return y;
    }

    protected M A(B b, C.G.M m, f f1, f f2, int i)
    {
        C c = n.A(m, f1, f2, 10D);
        boolean flag = false;
        int j = 0;
        double d = 0.0D;
        int k = -1;
        for(L l1 = c.A(); l1.C(); l1.B())
        {
            k++;
            J j1 = l1.L();
            double d1 = j1.V();
            if(d1 > d)
            {
                d = d1;
                j = k;
            }
        }

        int i1 = 0;
        byte byte0 = 3;
        double d2 = 0.0D;
        switch(i)
        {
        case 1: // '\001'
            byte0 = 2;
            i1 = 0;
            d2 = 0.0D;
            break;

        case 2: // '\002'
            byte0 = 2;
            i1 = j;
            d2 = 0.5D;
            break;

        case 4: // '\004'
            byte0 = 2;
            i1 = k;
            d2 = 1.0D;
            break;

        case 64: // '@'
            byte0 = 0;
            i1 = 0;
            d2 = 0.0D;
            break;

        case 128: 
            byte0 = 0;
            i1 = j;
            d2 = 0.5D;
            break;

        case 256: 
            byte0 = 0;
            i1 = k;
            d2 = 1.0D;
            break;

        case 8: // '\b'
            byte0 = 1;
            i1 = 0;
            d2 = 0.0D;
            break;

        case 16: // '\020'
            byte0 = 1;
            i1 = j;
            d2 = 0.5D;
            break;

        case 32: // ' '
            byte0 = 1;
            i1 = k;
            d2 = 1.0D;
            break;
        }
        J j2 = c.A(i1);
        if(j2 == null)
            return new M(f1.C(), f1.A() - b.R());
        M m1 = j2.Y();
        M m2 = j2.W();
        double d3 = m2.B() - m1.B();
        double d4 = m2.A() - m1.A();
        if(d3 == 0.0D && d4 == 0.0D)
        {
            d3 = (f1.C() + f1.B() * 0.5D + m.f().A) - (f2.C() + f2.B() * 0.5D + m.g().A);
            d4 = (f1.A() + f1.D() * 0.5D + m.f().D) - (f2.A() + f2.D() * 0.5D + m.g().D);
            if(d3 == 0.0D && d4 == 0.0D)
                d3 = 9.9999999999999995E-07D;
        }
        F f3 = E.A(d3, d4, b.Q(), b.R(), byte0);
        f3.C();
        f3.A(H);
        J._A _la = new J._A(i1, d2, f3, byte0, d2);
        return E.A(b, m, f1, f2, _la);
    }

    static final Integer C[] = {
        new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256)
    };
    private static final Object G = new Integer(128);
    private static final Object D = new Integer(64);
    private static final Object A = new Integer(16);
    private static final Object F = new Integer(8);
    private int B;
    private C.G.J E;
    private double H;

}
