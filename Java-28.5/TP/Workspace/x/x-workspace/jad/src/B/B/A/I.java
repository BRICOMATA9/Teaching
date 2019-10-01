// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import C.J.HA;
import C.J.Y;
import java.awt.*;
import java.awt.image.*;

public class I
    implements C.J.HA._H
{

    public I(C.J.HA._H _ph)
    {
        F = _ph;
        Kernel kernel = new Kernel(1, 9, A(2D, 9));
        I = new ConvolveOp(kernel, 1, null);
        Kernel kernel1 = new Kernel(9, 1, A(2D, 9));
        H = new ConvolveOp(kernel1, 1, null);
        E = 3;
        C = 3;
        J = Color.BLACK;
    }

    public void A(Color color)
    {
        J = color;
    }

    public void B(byte byte0)
    {
        E = byte0;
    }

    public void A(byte byte0)
    {
        C = byte0;
    }

    public void B(Y y, Graphics2D graphics2d)
    {
        int i;
        int j;
        int k;
        int l;
        double d;
        Graphics2D graphics2d1;
        i = (int)(y.B() + 20D);
        j = (int)(y.D() + 20D);
        if(i > 1400 || j > 1400)
        {
            double d1 = Math.max(i, j);
            d = 1400D / d1;
            k = (int)((double)i * d);
            l = (int)((double)j * d);
        } else
        {
            d = 1.0D;
            k = i;
            l = j;
        }
        if(D == null || D.getWidth() < k || D.getHeight() < l)
            try
            {
                GraphicsConfiguration graphicsconfiguration = graphics2d.getDeviceConfiguration();
                if(graphicsconfiguration != null)
                {
                    D = graphicsconfiguration.createCompatibleImage(k, l, 3);
                    B = graphicsconfiguration.createCompatibleImage(k, l, 3);
                } else
                {
                    D = new BufferedImage(k, l, 2);
                    B = new BufferedImage(k, l, 2);
                }
            }
            catch(OutOfMemoryError outofmemoryerror)
            {
                int i1 = (int)((double)(k * l * 4) / 1048576D);
                throw new OutOfMemoryError("Not enough memory (need approx. " + i1 + "mb) for temporary image of size [" + k + ", " + l + " ].");
            }
        graphics2d1 = D.createGraphics();
        java.awt.geom.AffineTransform affinetransform = graphics2d1.getTransform();
        int j1 = Math.min(k + 1 + 4, D.getWidth());
        int k1 = Math.min(l + 1 + 4, D.getHeight());
        graphics2d1.setBackground(A);
        graphics2d1.clearRect(0, 0, j1, k1);
        graphics2d1.scale(d, d);
        int l1 = (int)(y.C() - 10D);
        int i2 = (int)(y.A() - 10D);
        graphics2d1.translate(-l1, -i2);
        graphics2d1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boolean flag = y.I();
        y.A(false);
        F.B(y, graphics2d1);
        y.A(flag);
        graphics2d1.setTransform(affinetransform);
        graphics2d1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
        graphics2d1.setComposite(G);
        graphics2d1.setColor(J);
        graphics2d1.fillRect(0, 0, j1, k1);
        H.filter(D, B);
        I.filter(B, D);
        graphics2d.drawImage(D, l1 + E, i2 + C, l1 + E + i, i2 + C + j, 0, 0, k, l, null);
        graphics2d1.dispose();
        break MISSING_BLOCK_LABEL_565;
        Exception exception;
        exception;
        graphics2d1.dispose();
        throw exception;
        F.B(y, graphics2d);
        return;
    }

    public void A(Y y, Graphics2D graphics2d)
    {
        F.A(y, graphics2d);
    }

    static float[] A(double d, int i)
    {
        float af[] = new float[i];
        float f = 0.0F;
        for(int j = 0; j < i; j++)
        {
            float f1 = (float)A(d, (double)j - (double)i * 0.5D);
            af[j] = f1;
            f += f1;
        }

        for(int k = 0; k < af.length; k++)
            af[k] /= f;

        return af;
    }

    static final double A(double d, double d1)
    {
        double d2 = 1.0D / (Math.sqrt(6.2831853071795862D) * d);
        double d3 = 0.0D;
        for(double d4 = d1 - 0.5D; d4 < d1 + 0.59999999999999998D; d4 += 0.10000000000000001D)
            d3 += d2 * Math.pow(2.7182818284590451D, (-d4 * d4) / (2D * d * d));

        d3 /= 11D;
        return d3;
    }

    private static final Color A = new Color(255, 255, 255, 0);
    private static final AlphaComposite G = AlphaComposite.getInstance(5, 0.3F);
    private final C.J.HA._H F;
    private BufferedImage D;
    private BufferedImage B;
    private final ConvolveOp I;
    private final ConvolveOp H;
    private byte E;
    private byte C;
    private Color J;

}
