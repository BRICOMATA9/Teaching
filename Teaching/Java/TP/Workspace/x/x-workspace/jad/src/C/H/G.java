// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.J.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

// Referenced classes of package C.H:
//            L

public abstract class G extends L
{

    protected G()
    {
        this(false);
    }

    protected G(boolean flag)
    {
        V = flag;
    }

    public void A(b b1, InputStream inputstream)
    {
        throw new UnsupportedOperationException("read operation not supported");
    }

    public void A(b b1, OutputStream outputstream)
        throws IOException
    {
        K k;
        K k1;
        k = (K)b1.i();
        k1 = k;
        if(k1 == null)
            k1 = E(b1);
        A(k1, outputstream);
        if(k == null)
            b1.B(k1);
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        if(k == null)
            b1.B(k1);
        throw exception;
    }

    public void A(K k, OutputStream outputstream)
        throws IOException
    {
        Dimension dimension = k.j();
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = A(dimension.width, dimension.height);
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            int i = (int)((double)(dimension.width * dimension.height * 4) / 1048576D);
            throw new OutOfMemoryError("Not enough memory (need approx. " + i + "mb) for temporary image of size [" + dimension.width + ", " + dimension.height + " ].");
        }
        Graphics2D graphics2d = (Graphics2D)bufferedimage.getGraphics();
        if(V)
            C.J.E.B(graphics2d);
        k.F(graphics2d);
        if(V)
            C.J.E.A(graphics2d);
        try
        {
            A(bufferedimage, outputstream);
        }
        catch(OutOfMemoryError outofmemoryerror1)
        {
            int j = (int)((double)(bufferedimage.getWidth() * bufferedimage.getHeight() * 4) / 1048576D);
            throw new OutOfMemoryError("Not enough memory (need more than " + j + "mb) to encode image of size [" + bufferedimage.getWidth() + ", " + bufferedimage.getHeight() + " ].");
        }
    }

    protected abstract BufferedImage A(int i, int j);

    public K E(b b1)
    {
        K k = new K(b1);
        Rectangle rectangle = b1.X();
        Dimension dimension = new Dimension(rectangle.width, rectangle.height);
        k.setSize(dimension);
        k.setPreferredSize(dimension);
        k.B(rectangle.x - 10, rectangle.y - 10, rectangle.width + 20, rectangle.height + 20);
        k.C(0.0D);
        return k;
    }

    protected abstract void A(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException;

    public void B(boolean flag)
    {
        V = flag;
    }

    private boolean V;
}
