// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.P;
import C.H.H;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.io.*;

// Referenced classes of package C.J:
//            U, f, G, W, 
//            n, Q

public class e extends U
{

    public e()
    {
        C0 = new GeneralPath();
        BA = 0.10000000000000001D;
    }

    public e(U u)
    {
        super(u);
        C0 = new GeneralPath();
        BA = 0.10000000000000001D;
        if(u instanceof e)
            E(((e)u).CB());
    }

    public U A(U u)
    {
        return new e(u);
    }

    public f A(double d, double d1, f f1, int i)
    {
        f f2 = new f(this, d, d1);
        B(f2, f1, i);
        return f2;
    }

    public void B(f f1, f f2, int i)
    {
        if(i == 0)
            A2.A(f1, A2.C(f2));
        else
            A2.B(f1, A2.C(f2));
        C4();
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        if(i() == 0 || BA >= 1.0D)
            return W.A(this, r, point2d, point2d1);
        int i = i();
        float f1 = BA != 0.0D ? (float)(1.0D - BA) * 0.5F : 0.0F;
        float f2 = 1.0F - f1;
        r.reset();
        C0.reset();
        Y y = C2();
        n n1 = k();
        float f3;
        float f4;
        C0.moveTo(f3 = (float)n1.B(y), f4 = (float)n1.A(y));
        int j = 0;
        float f5 = f3;
        float f6 = f4;
        Q q = t();
        f f7 = q.J();
        f3 = (float)f7.A();
        f4 = (float)f7.C();
        q.B();
        for(j++; j < i; j++)
        {
            f f8 = q.J();
            float f10 = (float)f8.A();
            float f12 = (float)f8.C();
            if(f1 > 0.0F)
            {
                float f14 = f2 * f3 + f5 * f1;
                float f16 = f2 * f4 + f6 * f1;
                C0.lineTo(f14, f16);
                f14 = f1 * f10 + f3 * f2;
                f16 = f1 * f12 + f4 * f2;
                C0.quadTo(f3, f4, f14, f16);
                f5 = f3;
                f6 = f4;
                f3 = f10;
                f4 = f12;
            } else
            {
                C0.quadTo(f3, f4, (f3 + f10) * 0.5F, (f4 + f12) * 0.5F);
                f3 = f10;
                f4 = f12;
            }
            q.B();
        }

        y = m();
        n1 = s();
        float f9 = (float)n1.B(y);
        float f11 = (float)n1.A(y);
        if(f1 > 0.0F)
        {
            float f13 = f2 * f3 + f5 * f1;
            float f15 = f2 * f4 + f6 * f1;
            C0.lineTo(f13, f15);
            f13 = f1 * f9 + f3 * f2;
            f15 = f1 * f11 + f4 * f2;
            C0.quadTo(f3, f4, f13, f15);
            C0.lineTo(f9, f11);
        } else
        {
            C0.quadTo(f3, f4, f9, f11);
        }
        r.append(C0.getPathIterator(null, 0.5D), false);
        return W.A(this, r, r = new GeneralPath(1, i() + 4), point2d, point2d1);
    }

    public boolean D(Rectangle2D rectangle2d)
    {
        boolean flag = super.D(rectangle2d);
        if(!flag)
        {
            if(A4())
            {
                for(P p = A2.I(); p != null; p = p.C())
                {
                    f f1 = (f)p.A();
                    if(rectangle2d.contains(f1.A(), f1.C()))
                        return true;
                }

                Y y = C2();
                n n1 = k();
                if(rectangle2d.contains(n1.B(y), n1.A(y)))
                    return true;
                y = m();
                n1 = s();
                if(rectangle2d.contains(n1.B(y), n1.A(y)))
                    return true;
            } else
            {
                for(P p1 = A2.I(); p1 != null; p1 = p1.C())
                {
                    f f2 = (f)p1.A();
                    if(f2.B() && rectangle2d.contains(f2.A(), f2.C()))
                        return true;
                }

            }
            return false;
        } else
        {
            return true;
        }
    }

    public void C(Rectangle2D rectangle2d)
    {
        super.C(rectangle2d);
        if(A4())
        {
            for(P p = A2.I(); p != null; p = p.C())
            {
                f f1 = (f)p.A();
                rectangle2d.add(f1.A(), f1.C());
            }

            Y y = C2();
            n n1 = k();
            rectangle2d.add(n1.B(y), n1.A(y));
            y = m();
            n1 = s();
            rectangle2d.add(n1.B(y), n1.A(y));
        } else
        {
            for(P p1 = A2.I(); p1 != null; p1 = p1.C())
            {
                f f2 = (f)p1.A();
                if(f2.B())
                    rectangle2d.add(f2.A(), f2.C());
            }

        }
    }

    protected void I(Graphics2D graphics2d)
    {
        super.J(graphics2d);
        super.I(graphics2d);
    }

    public void B(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(0);
        super.B(objectoutputstream);
        objectoutputstream.writeDouble(CB());
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.G(objectinputstream);
            E(objectinputstream.readDouble());
            break;

        default:
            throw new H();
        }
    }

    public double CB()
    {
        return BA;
    }

    public void E(double d)
    {
        if(d < 0.0D || d > 1.0D)
            throw new IllegalArgumentException();
        if(BA != d)
        {
            BA = d;
            C4();
        }
    }

    private final GeneralPath C0;
    private double BA;
}
