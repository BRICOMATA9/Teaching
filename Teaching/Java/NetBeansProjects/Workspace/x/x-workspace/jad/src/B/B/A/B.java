// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.A.C.C;
import B.B.A.C.M;
import C.A.T;
import C.J.A.F;
import C.J.A.G;
import C.J.Y;
import C.J.b;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;

// Referenced classes of package B.B.A:
//            M

public class B extends B.B.A.M
    implements F
{

    public B()
    {
        ED();
    }

    public B(Y y)
    {
        super(y);
        if(y instanceof B)
        {
            B b1 = (B)y;
            if(b1.E8 != null)
            {
                E9 = b1.E9;
                EA = new Insets(b1.EA.top, b1.EA.left, b1.EA.bottom, b1.EA.right);
                A((C)b1.F3().B(this));
                A((B.B.B.F)b1.E8.clone());
                F1();
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
        E8 = new B.B.B.F();
        E9 = true;
        EA = new Insets(0, 0, 0, 0);
        F1();
    }

    public Y A(Y y)
    {
        return new B(y);
    }

    public void A(C c)
    {
        E6 = c;
    }

    public C F3()
    {
        return (C)E6;
    }

    public void A(B.B.B.F f)
    {
        E8 = f;
    }

    public B.B.B.F F2()
    {
        return E8;
    }

    public void J(boolean flag)
    {
        if(!E9 && flag)
        {
            java.awt.geom.Rectangle2D.Double double1 = X();
            Rectangle2D rectangle2d = F4();
            if(double1.getWidth() > rectangle2d.getWidth())
            {
                EA.left += (int)Math.rint(Math.abs(rectangle2d.getMinX() - double1.getMinX()));
                EA.right += (int)Math.rint(Math.abs(double1.getMaxX() - rectangle2d.getMaxX()));
            }
            if(double1.getHeight() > rectangle2d.getHeight())
            {
                EA.top += (int)Math.rint(Math.abs(rectangle2d.getMinY() - double1.getMinY()));
                EA.bottom += (int)Math.rint(Math.abs(double1.getMaxY() - rectangle2d.getMaxY()));
            }
        }
        E9 = flag;
        if(flag)
            F1();
    }

    public boolean E7()
    {
        return E9;
    }

    public Rectangle2D F4()
    {
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(-1D, -1D, -1D, -1D);
        boolean flag = false;
        T t = Q();
        if(t != null)
        {
            b b1 = (b)t._();
            G g = G.H(b1);
            if(g != null && g.A(t))
            {
                for(C.A.F f = g.B(t); f.C(); f.B())
                {
                    b1.U(f.H()).A(double1);
                    flag = true;
                }

            }
        }
        if(flag)
            double1.setFrame(double1.getX() - (double)EA.left, double1.getY() - (double)EA.top, double1.getWidth() + (double)EA.left + (double)EA.right, double1.getHeight() + (double)EA.top + (double)EA.bottom);
        else
            double1.setFrame(C(), A(), B(), D());
        return double1;
    }

    public void A(Insets insets)
    {
        if(insets == null)
            throw new IllegalArgumentException("null");
        EA.top = insets.top;
        EA.left = insets.left;
        EA.bottom = insets.bottom;
        EA.right = insets.right;
        if(E9)
            F1();
    }

    public Insets E8()
    {
        return new Insets(EA.top, EA.left, EA.bottom, EA.right);
    }

    private void F1()
    {
        B(F4());
    }

    private double F0()
    {
        C c = F3();
        return c == null ? 0.0D : c.B().C(this);
    }

    public void A(Rectangle2D rectangle2d)
    {
        if(E7())
            F1();
        super.A(rectangle2d);
    }

    public void B(double d, double d1)
    {
        super.B(Math.max(d, F0()), d1);
    }

    protected void M(Graphics2D graphics2d)
    {
    }

    void P(Graphics2D graphics2d)
    {
        C c = F3();
        if(c != null)
            c.A(graphics2d, this, S, Q, F, T);
    }

    B.B.B.F E8;
    Insets EA;
    boolean E9;
}
