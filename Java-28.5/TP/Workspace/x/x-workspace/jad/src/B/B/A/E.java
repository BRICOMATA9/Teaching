// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.A.C.M;
import C.J.Y;
import java.awt.Graphics2D;

// Referenced classes of package B.B.A:
//            M

public class E extends B.B.A.M
{

    public E()
    {
        ED();
    }

    public E(Y y)
    {
        super(y);
        if(y instanceof E)
        {
            E e = (E)y;
            if(e.E7 != null)
            {
                A((B.B.A.C.E)e.EF().B(this));
                A((B.B.B.E)e.E7.clone());
            } else
            {
                ED();
            }
        } else
        {
            ED();
        }
    }

    void ED()
    {
        E7 = new B.B.B.E();
    }

    public Y A(Y y)
    {
        return new E(y);
    }

    public void A(B.B.A.C.E e)
    {
        E6 = e;
    }

    public B.B.A.C.E EF()
    {
        return (B.B.A.C.E)E6;
    }

    public void A(B.B.B.E e)
    {
        E7 = e;
    }

    public B.B.B.E EE()
    {
        return E7;
    }

    protected void D(Graphics2D graphics2d)
    {
        if(E6 != null && ((B.B.A.C.E)E6).E())
        {
            if(I())
                C(graphics2d);
            E6.A(graphics2d, this, S, Q, F, T);
        } else
        {
            super.D(graphics2d);
        }
    }

    B.B.B.E E7;
}
