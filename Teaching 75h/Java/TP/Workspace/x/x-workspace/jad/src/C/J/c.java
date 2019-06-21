// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.A.J;
import C.A.P;
import C.H.H;
import C.K.G;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.*;

// Referenced classes of package C.J:
//            U, f, G, n, 
//            N, Y, W, M

public class c extends U
{

    public c()
    {
        AA = false;
    }

    public c(U u)
    {
        super(u);
        if(u instanceof c)
            AA = ((c)u).C8();
        else
            AA = false;
    }

    public U A(U u)
    {
        c c1 = new c(u);
        return c1;
    }

    public void I(boolean flag)
    {
        if(flag != AA)
        {
            AA = flag;
            C4();
        }
    }

    public boolean C8()
    {
        return AA;
    }

    public f A(double d, double d1, f f1, int i)
    {
        f f2 = new f(this, d, d1);
        A(f2, f1, i);
        return f2;
    }

    public void A(f f1, f f2, int i)
    {
        if(i == 0)
        {
            if(A2.size() > 0 && f2 == A2.H())
                A2.A(f1, A2.G());
            else
                A2.A(f1, A2.C(f2));
        } else
        if(A2.size() > 0 && f2 == A2.F())
            A2.B(f1, A2.I());
        else
            A2.B(f1, A2.C(f2));
        C4();
    }

    java.awt.geom.Rectangle2D.Float A(java.awt.geom.Rectangle2D.Float float1)
    {
        if(C6().H() && i() < 2)
        {
            float1 = super.A(float1);
            if(i() == 1)
            {
                f f1 = A2.S();
                float1.add(f1.A(), f1.C());
            }
            return float1;
        }
        Point2D point2d = BA();
        if(float1 != null)
            float1.setFrame(point2d.getX(), point2d.getY(), 1.0D, 1.0D);
        else
            float1 = new java.awt.geom.Rectangle2D.Float((float)point2d.getX(), (float)point2d.getY(), 1.0F, 1.0F);
        for(P p = A2.I(); p != null; p = p.C())
        {
            f f2 = (f)p.A();
            float1.add(f2.A(), f2.C());
        }

        n n1 = k();
        n n2 = s();
        n1.A(float1, C2());
        n2.A(float1, m());
        double d = float1.getX();
        double d1 = d + float1.getWidth();
        double d2 = float1.getY();
        double d3 = d2 + float1.getHeight();
        for(int i = w() - 1; i >= 0; i--)
        {
            N n3 = D(i);
            if(n3.b() && (n3.f().length() != 0 || n3.j() != null))
            {
                G g = n3.A();
                d1 = Math.max(g.K + g.J, d1);
                d = Math.min(g.K, d);
                d3 = Math.max(g.M + g.I, d3);
                d2 = Math.min(g.M, d2);
            }
        }

        float1.setFrame(d, d2, d1 - d, d3 - d2);
        return float1;
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        boolean flag = false;
        if(C6().H())
            if(i() == 0)
            {
                Y y = C2();
                F(k().B(y), k().A(y) - 10D - y.D());
                flag = true;
            } else
            if(i() == 1)
                flag = true;
        if(flag)
            return W.C(this, r, point2d, point2d1);
        if(AA)
            return W.B(this, r, point2d, point2d1);
        else
            return W.A(this, r, point2d, point2d1);
    }

    public void A(M m)
    {
        m.A(B5().getPathIterator(null));
    }

    public void B(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(1);
        super.B(objectoutputstream);
        objectoutputstream.writeBoolean(AA);
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.G(objectinputstream);
            AA = false;
            break;

        case 1: // '\001'
            super.G(objectinputstream);
            AA = objectinputstream.readBoolean();
            break;

        default:
            throw new H();
        }
    }

    private boolean AA;
}
