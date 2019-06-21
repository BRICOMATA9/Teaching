// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

// Referenced classes of package C.J:
//            Y, E, J

public class g extends Y
{

    public g()
    {
        this((byte)0, 0.0D, 0.0D, "");
    }

    public g(byte byte0, double d, double d1, String s)
    {
        super(d, d1, s);
        DA = 0;
        D9 = 0;
        DC = DB;
        D(byte0);
    }

    public g(Y y)
    {
        super(y);
        DA = 0;
        D9 = 0;
        DC = DB;
        if(y instanceof g)
        {
            g g1 = (g)y;
            D(g1.E3());
            DC = g1.DC;
            D9 = g1.D9;
            DA = g1.DA;
        } else
        {
            D((byte)0);
        }
    }

    public Y A(Y y)
    {
        return new g(y);
    }

    public void C(double d, double d1)
    {
        G(d - B() / 2D, d1 - D() / 2D);
    }

    public void A(double d, double d1)
    {
        G(d, d1);
    }

    private void G(double d, double d1)
    {
        if(DD instanceof RectangularShape)
        {
            super.A(d, d1);
            ((RectangularShape)DD).setFrame(S, Q, F, T);
        } else
        if(DD instanceof GeneralPath)
        {
            ((GeneralPath)DD).transform(AffineTransform.getTranslateInstance(d - S, d1 - Q));
            super.A(d, d1);
        }
    }

    public void B(double d, double d1)
    {
        if(d == F && d1 == T)
            return;
        if(DD instanceof RectangularShape)
        {
            super.B(d, d1);
            ((RectangularShape)DD).setFrame(S, Q, d, d1);
        } else
        if(DD instanceof GeneralPath)
        {
            if(F == 0.0D || T == 0.0D)
            {
                super.B(d, d1);
                D(E3());
            } else
            {
                AffineTransform affinetransform = AffineTransform.getTranslateInstance(N(), V());
                affinetransform.scale(d / F, d1 / T);
                affinetransform.translate(-N(), -V());
                ((GeneralPath)DD).transform(affinetransform);
                super.B(d, d1);
            }
        } else
        {
            super.B(d, d1);
        }
    }

    public void D(byte byte0)
    {
        switch(byte0)
        {
        case 2: // '\002'
            DD = new java.awt.geom.Ellipse2D.Double(S, Q, F, T);
            break;

        case 0: // '\0'
        case 6: // '\006'
            DD = new java.awt.geom.Rectangle2D.Double(S, Q, F, T);
            break;

        case 1: // '\001'
            DD = new java.awt.geom.RoundRectangle2D.Double(S, Q, F, T, 8D, 8D);
            break;

        case 3: // '\003'
            GeneralPath generalpath = new GeneralPath(0, 5);
            generalpath.moveTo((float)(S + F * 0.10000000000000001D), (float)Q);
            generalpath.lineTo((float)(S + F), (float)Q);
            generalpath.lineTo((float)(S + F * 0.90000000000000002D), (float)(Q + T));
            generalpath.lineTo((float)S, (float)(Q + T));
            generalpath.closePath();
            DD = generalpath;
            break;

        case 4: // '\004'
            GeneralPath generalpath1 = new GeneralPath(0, 6);
            generalpath1.moveTo((float)S, (float)(Q + T / 2D));
            generalpath1.lineTo((float)(S + F * 0.10000000000000001D), (float)Q);
            generalpath1.lineTo((float)(S + F * 0.90000000000000002D), (float)Q);
            generalpath1.lineTo((float)(S + F), (float)(Q + T / 2D));
            generalpath1.lineTo((float)(S + F * 0.90000000000000002D), (float)(Q + T));
            generalpath1.lineTo((float)(S + F * 0.10000000000000001D), (float)(Q + T));
            generalpath1.closePath();
            DD = generalpath1;
            break;

        case 5: // '\005'
            GeneralPath generalpath2 = new GeneralPath(0, 3);
            generalpath2.moveTo((float)(S + F / 2D), (float)Q);
            generalpath2.lineTo((float)(S + F), (float)(Q + T));
            generalpath2.lineTo((float)S, (float)(Q + T));
            generalpath2.closePath();
            DD = generalpath2;
            break;

        case 7: // '\007'
            double d = Math.sqrt(2D);
            double d1 = F / (2D + d);
            double d2 = T / (2D + d);
            GeneralPath generalpath3 = new GeneralPath(0, 8);
            generalpath3.moveTo((float)S, (float)(Q + d2));
            generalpath3.lineTo((float)(S + d1), (float)Q);
            generalpath3.lineTo((float)((S + F) - d1), (float)Q);
            generalpath3.lineTo((float)(S + F), (float)(Q + d2));
            generalpath3.lineTo((float)(S + F), (float)((Q + T) - d2));
            generalpath3.lineTo((float)((S + F) - d1), (float)(Q + T));
            generalpath3.lineTo((float)(S + d1), (float)(Q + T));
            generalpath3.lineTo((float)S, (float)((Q + T) - d2));
            generalpath3.closePath();
            DD = generalpath3;
            break;

        case 8: // '\b'
            GeneralPath generalpath4 = new GeneralPath(0, 4);
            generalpath4.moveTo((float)S, (float)(Q + T * 0.5D));
            generalpath4.lineTo((float)(S + F * 0.5D), (float)Q);
            generalpath4.lineTo((float)(S + F), (float)(Q + T * 0.5D));
            generalpath4.lineTo((float)(S + F * 0.5D), (float)(Q + T));
            generalpath4.closePath();
            DD = generalpath4;
            break;

        case 9: // '\t'
            GeneralPath generalpath5 = new GeneralPath(0, 4);
            generalpath5.moveTo((float)S, (float)(Q + T));
            generalpath5.lineTo((float)(S + F * 0.25D), (float)Q);
            generalpath5.lineTo((float)(S + F * 0.75D), (float)Q);
            generalpath5.lineTo((float)(S + F), (float)(Q + T));
            generalpath5.closePath();
            DD = generalpath5;
            break;

        case 10: // '\n'
            GeneralPath generalpath6 = new GeneralPath(0, 4);
            generalpath6.moveTo((float)S, (float)Q);
            generalpath6.lineTo((float)(S + F), (float)Q);
            generalpath6.lineTo((float)(S + F * 0.75D), (float)(Q + T));
            generalpath6.lineTo((float)(S + F * 0.25D), (float)(Q + T));
            generalpath6.closePath();
            DD = generalpath6;
            break;
        }
        DE = byte0;
        R();
    }

    public byte E3()
    {
        return DE;
    }

    public Color E5()
    {
        return DC;
    }

    public void F(Color color)
    {
        DC = color;
    }

    public byte E6()
    {
        return D9;
    }

    public void C(byte byte0)
    {
        D9 = byte0;
    }

    public byte E4()
    {
        return DA;
    }

    public void B(byte byte0)
    {
        DA = byte0;
    }

    public boolean E2()
    {
        return DC != null && (DA != 0 || D9 != 0);
    }

    protected void D(Graphics2D graphics2d)
    {
        if(I())
            C(graphics2d);
        M(graphics2d);
        N(graphics2d);
        A(graphics2d);
        O(graphics2d);
    }

    protected void O(Graphics2D graphics2d)
    {
        byte byte0 = E3();
        if(byte0 == 6)
        {
            Color color = M();
            if(color != null)
            {
                graphics2d.setColor(color);
                A(graphics2d, true);
            }
        } else
        {
            Color color1 = Y();
            if(color1 != null)
            {
                java.awt.Stroke stroke = graphics2d.getStroke();
                graphics2d.setStroke(J());
                graphics2d.setColor(color1);
                if(byte0 == 2)
                {
                    C.J.E.B(graphics2d);
                    graphics2d.draw(DD);
                    C.J.E.A(graphics2d);
                } else
                {
                    graphics2d.draw(DD);
                }
                graphics2d.setStroke(stroke);
            }
        }
    }

    protected void N(Graphics2D graphics2d)
    {
        Color color = M();
        if(color != null && !W())
        {
            Color color1 = U();
            boolean flag = I();
            if(color1 != null)
            {
                if(flag)
                {
                    color1 = E(color1);
                    color = E(color);
                }
                graphics2d.setPaint(new GradientPaint((float)(S + F / 3D), (float)Q, color, (float)(S + F), (float)Q, color1, true));
            } else
            {
                graphics2d.setColor(flag ? E(color) : color);
            }
            graphics2d.fill(DD);
        }
    }

    protected Color E(Color color)
    {
        return new Color(Math.max((int)((double)color.getRed() * 0.69999999999999996D), 0), Math.max((int)((double)color.getGreen() * 0.69999999999999996D), 0), Math.max((int)((double)color.getBlue() * 0.69999999999999996D), 0), color.getAlpha());
    }

    protected void A(Graphics2D graphics2d, boolean flag)
    {
        java.awt.Paint paint = graphics2d.getPaint();
        Color color = graphics2d.getColor();
        Color color1 = color.brighter();
        Color color2 = color.darker();
        if(!flag)
            graphics2d.setColor(color2);
        else
        if(paint != color)
            graphics2d.setColor(color);
        graphics2d.setColor(flag ? color1 : color2);
        java.awt.geom.Rectangle2D.Double double1 = J.A().J;
        double1.setFrame(S, Q, 1.0D, T);
        graphics2d.fill(double1);
        double1.setFrame(S + 1.0D, Q, F - 2D, 1.0D);
        graphics2d.fill(double1);
        graphics2d.setColor(flag ? color2 : color1);
        double1.setFrame(S + 1.0D, (Q + T) - 1.0D, F - 1.0D, 1.0D);
        graphics2d.fill(double1);
        double1.setFrame((S + F) - 1.0D, Q, 1.0D, T - 1.0D);
        graphics2d.fill(double1);
        graphics2d.setPaint(paint);
    }

    protected void M(Graphics2D graphics2d)
    {
        if(DC == null || DA == 0 && D9 == 0)
        {
            return;
        } else
        {
            Color color = graphics2d.getColor();
            AffineTransform affinetransform = graphics2d.getTransform();
            graphics2d.setColor(DC);
            graphics2d.translate(DA, D9);
            graphics2d.fill(DD);
            graphics2d.setColor(color);
            graphics2d.setTransform(affinetransform);
            return;
        }
    }

    public boolean D(double d, double d1)
    {
        if(W())
        {
            java.awt.geom.Rectangle2D.Double double1 = J.A().J;
            double1.setRect(d - 5D, d1 - 5D, 10D, 10D);
            return DD.intersects(double1) && (!DD.contains(d - 5D, d1 - 5D) || !DD.contains(d + 5D, d1 - 5D) || !DD.contains(d - 5D, d1 + 5D) || !DD.contains(d + 5D, d1 + 5D));
        } else
        {
            return DD.contains(d, d1);
        }
    }

    public boolean A(double d, double d1, double d2, double d3, Point2D point2d)
    {
        if(d == d2 && d1 == d3)
            return false;
        if(!D(d, d1) || D(d2, d3))
            return false;
        if(DE == 2 && d == N() && d1 == V())
        {
            double d4 = d2 - N();
            double d5 = d3 - V();
            double d6;
            double d7;
            if(F < 9.9999999999999995E-07D || T < 9.9999999999999995E-07D)
            {
                d6 = 0.0D;
                d7 = 0.0D;
            } else
            {
                double d8 = F / T;
                double d9 = 1.0D / Math.sqrt(d4 * d4 + d5 * d5 * d8 * d8);
                d6 = d4 * (F * 0.5D) * d9;
                d7 = d8 * d5 * (T * 0.5D) * d9;
            }
            point2d.setLocation(N() + d6, V() + d7);
        } else
        {
            if(DE == 0 && d == N() && d1 == V())
                if(D(d2, d3))
                    return false;
                else
                    return B(d, d1, d2, d3, point2d);
            super.A(d, d1, d2, d3, point2d);
        }
        return true;
    }

    public void A(Rectangle2D rectangle2d)
    {
        super.A(rectangle2d);
        if((DA != 0 || D9 != 0) && DC != null)
            if(DA > 0)
            {
                if(D9 > 0)
                    rectangle2d.add(S + F + (double)DA, Q + T + (double)D9);
                else
                    rectangle2d.add(S + F + (double)DA, Q + (double)D9);
            } else
            if(D9 > 0)
                rectangle2d.add(S + (double)DA, Q + T + (double)D9);
            else
                rectangle2d.add(S + (double)DA, Q + (double)D9);
    }

    public void C(Graphics2D graphics2d)
    {
        if((DA != 0 || D9 != 0) && DC != null)
        {
            double d = F;
            double d1 = T;
            double d2 = S;
            double d3 = Q;
            if(DA >= 0)
            {
                F += DA;
            } else
            {
                F -= DA;
                S += DA;
            }
            if(D9 >= 0)
            {
                T += D9;
            } else
            {
                Q += D9;
                T -= D9;
            }
            super.C(graphics2d);
            F = d;
            T = d1;
            S = d2;
            Q = d3;
        } else
        {
            super.C(graphics2d);
        }
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(1);
        super.A(objectoutputstream);
        objectoutputstream.writeByte(DE);
        objectoutputstream.writeByte(DA);
        objectoutputstream.writeByte(D9);
        objectoutputstream.writeObject(DC);
    }

    public void A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            super.A(objectinputstream);
            D(objectinputstream.readByte());
            break;

        case 1: // '\001'
            super.A(objectinputstream);
            D(objectinputstream.readByte());
            DA = objectinputstream.readByte();
            D9 = objectinputstream.readByte();
            DC = (Color)objectinputstream.readObject();
            break;

        default:
            throw new H();
        }
    }

    protected Shape DD;
    private byte DE;
    private static Color DB = new Color(179, 166, 145);
    private byte DA;
    private byte D9;
    private Color DC;

}
