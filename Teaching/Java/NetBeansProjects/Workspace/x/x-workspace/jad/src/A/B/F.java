// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.B;

import C.G.E.A.*;
import C.G.I;
import java.util.Comparator;

// Referenced classes of package A.B:
//            A, J

class F
    implements O
{

    public F(O o)
    {
        C = new A(o);
        A = 0;
    }

    public Comparator B()
    {
        return C.G();
    }

    public void A(Comparator comparator)
    {
        C.B(comparator);
    }

    public void A(boolean flag)
    {
        C.E(flag);
    }

    public void B(boolean flag)
    {
        C.D(flag);
    }

    public byte A()
    {
        return A;
    }

    public void A(byte byte0)
    {
        A = byte0;
    }

    public void A(I i, Q q, v v)
    {
        if(0 == A)
        {
            C.A(i, q, v);
        } else
        {
            J j = new J(C);
            j.C(1 == A);
            j.A(i, q, v);
        }
    }

    public static final Object B;
    private final A C;
    private byte A;

    static 
    {
        B = A.W;
    }
}
