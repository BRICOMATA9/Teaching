// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.B.A;
import C.J.Y;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

// Referenced classes of package B.B.A:
//            G

public class K extends G
{

    public K()
    {
        EB();
    }

    public K(Y y)
    {
        super(y);
        if(y instanceof K)
        {
            K k = (K)y;
            E1 = k.E1;
            E3 = k.E3;
            E5 = k.E5;
            E2 = k.E2;
            E4 = (A)k.E4.clone();
        }
    }

    void EB()
    {
        E4 = new A();
        E1 = 8D;
        E3 = 8D;
        E5 = 20D;
        E2 = Color.LIGHT_GRAY;
        D((byte)1);
    }

    public Y A(Y y)
    {
        return new K(y);
    }

    public void B(double d, double d1)
    {
        super.B(d, d1);
        EA();
    }

    public void D(byte byte0)
    {
        super.D(byte0);
        EA();
    }

    void EA()
    {
        double d = Math.min(Math.min(E5, 0.5D * F), 0.5D * T);
        switch(E3())
        {
        default:
            break;

        case 0: // '\0'
            GeneralPath generalpath = new GeneralPath(1, 5);
            generalpath.moveTo((float)S, (float)(Q + d));
            generalpath.lineTo((float)S, (float)(Q + T));
            generalpath.lineTo((float)(S + F), (float)(Q + T));
            generalpath.lineTo((float)(S + F), (float)Q);
            generalpath.lineTo((float)(S + d), (float)Q);
            generalpath.closePath();
            DD = generalpath;
            break;

        case 1: // '\001'
            double d1 = Math.min(E1, F / 2D);
            double d2 = Math.min(E3, T / 2D);
            GeneralPath generalpath1 = new GeneralPath(1, 7);
            java.awt.geom.RoundRectangle2D.Double double1 = new java.awt.geom.RoundRectangle2D.Double(S, Q, F, T, E1, E3);
            PathIterator pathiterator = double1.getPathIterator(null);
            generalpath1.moveTo((float)S, (float)(Q + d));
            pathiterator.next();
            for(int i = 0; i < 6; i++)
            {
                float af[] = new float[6];
                int j = pathiterator.currentSegment(af);
                pathiterator.next();
                switch(j)
                {
                case 1: // '\001'
                    generalpath1.lineTo(af[0], af[1]);
                    break;

                case 3: // '\003'
                    generalpath1.curveTo(af[0], af[1], af[2], af[3], af[4], af[5]);
                    break;
                }
            }

            generalpath1.lineTo((float)(S + d), (float)Q);
            generalpath1.closePath();
            DD = generalpath1;
            break;
        }
    }

    public void D(Graphics2D graphics2d)
    {
        super.D(graphics2d);
        double d = Math.min(Math.min(E5, 0.5D * F), 0.5D * T);
        E0.reset();
        E0.moveTo((float)(S + d), (float)Q);
        E0.lineTo((float)S, (float)(Q + d));
        E0.lineTo((float)(S + d), (float)(Q + d));
        E0.closePath();
        if(E2 != null)
        {
            graphics2d.setColor(E2);
            graphics2d.fill(E0);
        }
        if(Y() != null)
        {
            graphics2d.setColor(Y());
            graphics2d.draw(E0);
        }
    }

    public A EC()
    {
        return E4;
    }

    public void A(A a)
    {
        E4 = a;
    }

    public void G(Color color)
    {
        E2 = color;
    }

    private static final GeneralPath E0 = new GeneralPath(1, 3);
    A E4;
    double E1;
    double E3;
    double E5;
    Color E2;

}
