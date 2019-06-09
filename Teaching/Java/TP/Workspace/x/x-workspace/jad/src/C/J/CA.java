// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import javax.swing.Icon;

// Referenced classes of package C.J:
//            n, Y, U

public class CA extends n
{

    public CA(Icon icon)
    {
        F = null;
        F = icon;
    }

    public CA(n n1)
    {
        super(n1);
        F = null;
        if(n1 instanceof CA)
        {
            CA ca = (CA)n1;
            F = ca.F;
        }
    }

    public n C()
    {
        return new CA(this);
    }

    public Icon G()
    {
        return F;
    }

    public void A(Rectangle2D rectangle2d, Y y)
    {
        double d = E();
        double d1 = F();
        double d2 = B(y) - d / 2D;
        double d3 = A(y) - d1 / 2D;
        rectangle2d.add(d2, d3);
        rectangle2d.add(d2 + d, d3 + d1);
        rectangle2d.add(d2, d3 + d1);
        rectangle2d.add(d2 + d, d3);
    }

    public boolean A(Y y, double d, double d1, double d2, 
            double d3, Point2D point2d)
    {
        if(y.A(d, d1, d2, d3, point2d))
        {
            double d4 = Math.max(E(), F());
            double d5 = d2 - point2d.getX();
            double d6 = d3 - point2d.getY();
            double d7 = d5 * d5 + d6 * d6;
            if(d7 > 0.0D)
            {
                d7 = Math.sqrt(d7);
                d5 = (d5 * d4) / d7;
                d6 = (d6 * d4) / d7;
                point2d.setLocation(point2d.getX() + d5, point2d.getY() + d6);
                E = (float)(d5 / 2D);
                D = (float)(d6 / 2D);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void A(Graphics2D graphics2d, Y y)
    {
        if(F != null)
        {
            Point2D point2d;
            if(B.k() == this)
                point2d = B.u();
            else
                point2d = B.BA();
            F.paintIcon(null, graphics2d, (int)(point2d.getX() - E() / 2D - (double)E), (int)(point2d.getY() - F() / 2D - (double)D));
            if(B.A4())
                super.A(graphics2d, y);
        } else
        {
            super.A(graphics2d, y);
        }
    }

    double E()
    {
        if(F != null)
            return (double)F.getIconWidth();
        else
            return 1.0D;
    }

    double F()
    {
        if(F != null)
            return (double)F.getIconHeight();
        else
            return 1.0D;
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(0);
        super.A(objectoutputstream);
        if(F != null && (F instanceof Serializable))
        {
            objectoutputstream.writeBoolean(true);
            objectoutputstream.writeObject(F);
        } else
        {
            objectoutputstream.writeBoolean(false);
        }
    }

    public void A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.A(objectinputstream);
            if(objectinputstream.readBoolean())
                F = (Icon)objectinputstream.readObject();
            break;

        default:
            throw new H();
        }
    }

    public String toString()
    {
        return "InterfacePort: (" + D() + ',' + A() + ')';
    }

    Icon F;
    float E;
    float D;
}
