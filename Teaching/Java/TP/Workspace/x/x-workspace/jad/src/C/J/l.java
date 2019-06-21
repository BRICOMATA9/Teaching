// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.geom.*;
import java.io.*;

// Referenced classes of package C.J:
//            U, f, G, Y, 
//            n, J, W

public class l extends U
{

    public l()
    {
        this((byte)1);
    }

    public l(byte byte0)
    {
        CD();
        C7 = byte0;
    }

    public l(U u)
    {
        super(u);
        if(u instanceof l)
        {
            l l1 = (l)u;
            C7 = l1.D0();
            C6 = l1.CE();
            CE = l1.CC();
            if(l1.i() != 1)
            {
                CA = new f(this, 0.0D, 0.0D);
            } else
            {
                CA = new f(this, l1.CA.A(), l1.CA.C());
                C4 = l1.C4;
                C9 = l1.C9;
                C3 = l1.C3;
                C8 = l1.C8;
                C2 = l1.C2;
                C1 = l1.C1;
                D0 = l1.D0;
                CF = l1.CF;
                CD = l1.CD;
                C5 = l1.C5;
                CC = l1.CC;
                CB = l1.CB;
            }
            A2.clear();
            A2.E(CA);
        } else
        {
            CD();
        }
    }

    public U A(U u)
    {
        return new l(u);
    }

    private void CD()
    {
        C6 = 1.0F;
        CE = 30F;
        CA = new f(this, 0.0D, 0.0D);
        A2.clear();
        A2.E(CA);
        C7 = 1;
    }

    public void A(byte byte0)
    {
        if(C7 != byte0)
        {
            C7 = byte0;
            CF();
            C4();
        }
    }

    public byte D0()
    {
        return C7;
    }

    public float CE()
    {
        return C6;
    }

    public void A(float f1)
    {
        C6 = f1;
        C4();
    }

    public void B(float f1)
    {
        CE = f1;
        C4();
    }

    public float CC()
    {
        return CE;
    }

    public f A(double d, double d1, f f1, int i)
    {
        return null;
    }

    public void A(f f1, double d, double d1)
    {
        if(!f1.B())
            return;
        if(m().I() || C2().I())
            return;
        double d2 = Line2D.ptLineDist(C4, C3, C9, C8, CA.A(), CA.C());
        if(Double.isNaN(d2))
            d2 = (float)Math.sqrt(((double)C4 - CA.A()) * ((double)C4 - CA.A()) + ((double)C3 - CA.C()) * ((double)C3 - CA.C()));
        int i = Line2D.relativeCCW(C4, C3, C9, C8, CA.A(), CA.C());
        double d3 = (float)Math.sqrt(D0 * D0 + CF * CF);
        switch(C7)
        {
        default:
            break;

        case 0: // '\0'
            if(i != 0)
                CE = (float)i * (float)d2;
            else
                CE = (float)d2;
            break;

        case 1: // '\001'
            if(d3 > 0.0D)
                C6 = (float)i * (float)((4D * d2) / d3);
            break;
        }
        CF();
    }

    private void CF()
    {
        Y y = C2();
        Y y1 = m();
        n n1 = k();
        n n2 = s();
        C4 = (float)n1.B(y);
        C3 = (float)n1.A(y);
        C9 = (float)n2.B(y1);
        C8 = (float)n2.A(y1);
        D0 = C9 - C4;
        CF = C8 - C3;
        C2 = C4 + D0 / 2.0F;
        C1 = C3 + CF / 2.0F;
        switch(C7)
        {
        default:
            break;

        case 1: // '\001'
            CD = (CF * C6) / 4F;
            C5 = (-D0 * C6) / 4F;
            CE = (float)Math.sqrt(CD * CD + C5 * C5);
            if(C6 < 0.0F)
                CE = -CE;
            break;

        case 0: // '\0'
            double d = Math.sqrt(D0 * D0 + CF * CF);
            if(d > 0.0D)
            {
                C6 = (float)((double)CE / d);
                CD = CF * C6;
                C5 = -D0 * C6;
                C6 *= 4F;
            } else
            {
                CD = 0.0F;
                C5 = 0.0F;
            }
            break;
        }
        CA.A = C2 + CD;
        CA.D = C1 + C5;
        CC = (float)(CA.A() + (double)CD);
        CB = (float)(CA.C() + (double)C5);
    }

    protected byte A(Point2D point2d, Point2D point2d1)
    {
        CF();
        GeneralPath generalpath = new GeneralPath(1, 5);
        generalpath.moveTo(C4, C3);
        generalpath.quadTo(CC, CB, C9, C8);
        PathIterator pathiterator = generalpath.getPathIterator(null, 1.0D);
        float af[] = J.A().E;
        pathiterator.currentSegment(af);
        pathiterator.next();
        r.reset();
        r.moveTo(af[0], af[1]);
        for(; !pathiterator.isDone(); r.lineTo(af[0], af[1]))
        {
            pathiterator.currentSegment(af);
            pathiterator.next();
        }

        return W.A(this, r, r = new GeneralPath(1, i() + 4), point2d, point2d1);
    }

    public void B(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(1);
        super.B(objectoutputstream);
        objectoutputstream.writeByte(C7);
        objectoutputstream.writeFloat(C6);
        objectoutputstream.writeFloat(CE);
    }

    public void G(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            objectinputstream.readByte();
            super.G(objectinputstream);
            byte byte0 = objectinputstream.readByte();
            C6 = objectinputstream.readFloat();
            CE = objectinputstream.readFloat();
            A(byte0);
            break;

        case 1: // '\001'
            super.G(objectinputstream);
            byte byte1 = objectinputstream.readByte();
            C6 = objectinputstream.readFloat();
            CE = objectinputstream.readFloat();
            A(byte1);
            break;

        default:
            throw new H();
        }
        CF();
        C4();
    }

    private float C4;
    private float C3;
    private float C9;
    private float C8;
    private float C6;
    private float CE;
    private float C2;
    private float C1;
    private float D0;
    private float CF;
    private float C5;
    private float CD;
    private float CC;
    private float CB;
    private byte C7;
    f CA;
}
