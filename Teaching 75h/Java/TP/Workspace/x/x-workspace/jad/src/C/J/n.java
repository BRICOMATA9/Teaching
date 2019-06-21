// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;

// Referenced classes of package C.J:
//            Y, U, J

public class n
{

    public n()
    {
        this(0.0D, 0.0D);
    }

    public n(double d, double d1)
    {
        A = d;
        C = d1;
    }

    public n(n n1)
    {
        this(n1.A, n1.C);
    }

    public n C()
    {
        return new n(A, C);
    }

    void A(U u)
    {
        B = u;
    }

    public boolean A(Y y, double d, double d1, double d2, 
            double d3, Point2D point2d)
    {
        return y.A(d, d1, d2, d3, point2d);
    }

    public void A(Graphics2D graphics2d, Y y)
    {
        if(B.A4())
        {
            java.awt.geom.Rectangle2D.Double double1 = J.A().J;
            double1.width = double1.height = 6D;
            double1.x = B(y) - 3D;
            double1.y = A(y) - 3D;
            graphics2d.setColor(Color.black);
            graphics2d.fill(double1);
        }
    }

    protected void B()
    {
        if(B != null)
            B.C4();
    }

    public void A(Rectangle2D rectangle2d, Y y)
    {
        rectangle2d.add(B(y), A(y));
    }

    public double D()
    {
        return A;
    }

    public double A()
    {
        return C;
    }

    public double B(Y y)
    {
        return y.N() + A;
    }

    public double A(Y y)
    {
        return y.V() + C;
    }

    public void A(double d, double d1)
    {
        B();
        A = d;
        C = d1;
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(1);
        objectoutputstream.writeFloat((float)A);
        objectoutputstream.writeFloat((float)C);
    }

    public void A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            objectinputstream.readByte();
            A = objectinputstream.readFloat();
            C = objectinputstream.readFloat();
            break;

        case 1: // '\001'
            A = objectinputstream.readFloat();
            C = objectinputstream.readFloat();
            break;

        default:
            throw new H();
        }
    }

    public String toString()
    {
        return "Port: (" + D() + ',' + A() + ')';
    }

    protected double A;
    protected double C;
    protected U B;
}
