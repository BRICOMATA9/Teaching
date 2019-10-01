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

public class z extends U
{

    public z()
    {
        D1 = new GeneralPath();
    }

    public z(U u)
    {
        super(u);
        D1 = new GeneralPath();
    }

    public U A(U u)
    {
        return new z(u);
    }

    public f A(double d, double d1, f f1, int i)
    {
        f f2 = new f(this, d, d1);
        C(f2, f1, i);
        return f2;
    }

    public void C(f f1, f f2, int i)
    {
        if(i == 0)
            A2.A(f1, A2.C(f2));
        else
            A2.B(f1, A2.C(f2));
        C4();
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        if(i() == 0)
            return W.A(this, r, point2d, point2d1);
        int i = 2;
        if((i() & 1) == 1)
            i += 3 * i() + 1 >> 1;
        else
            i += 3 * (i() >> 1) - 1;
        float af[] = new float[i];
        float af1[] = new float[i];
        Y y = C2();
        n n1 = k();
        af[0] = (float)n1.B(y);
        af1[0] = (float)n1.A(y);
        int j = 1;
        for(Q q = t(); q.C();)
        {
            f f1 = q.J();
            if(j % 3 == 0)
            {
                af[j] = (float)(f1.A() + (double)af[j - 1]) / 2.0F;
                af1[j] = (float)(f1.C() + (double)af1[j - 1]) / 2.0F;
                j++;
            }
            af[j] = (float)f1.A();
            af1[j] = (float)f1.C();
            q.B();
            j++;
        }

        if(j % 3 == 2)
        {
            af[j] = af[j - 1];
            af1[j] = af1[j - 1];
        }
        y = m();
        n1 = s();
        af[i - 1] = (float)n1.B(y);
        af1[i - 1] = (float)n1.A(y);
        r.reset();
        D1.reset();
        D1.moveTo(af[0], af1[0]);
        for(int k = 0; k < i - 3; k += 3)
            D1.curveTo(af[k + 1], af1[k + 1], af[k + 2], af1[k + 2], af[k + 3], af1[k + 3]);

        r.append(D1.getPathIterator(null, 0.75D), false);
        return W.A(this, r, r = new GeneralPath(1, i() + 4), point2d, point2d1);
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
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.G(objectinputstream);
            break;

        default:
            throw new H();
        }
    }

    private final GeneralPath D1;
}
