// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.awt.Image;
import java.awt.image.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

abstract class J
    implements ImageConsumer
{

    protected J(Image image, OutputStream outputstream)
        throws IOException
    {
        this(image.getSource(), outputstream);
    }

    protected J(ImageProducer imageproducer, OutputStream outputstream)
        throws IOException
    {
        A = -1;
        I = -1;
        E = 0;
        F = false;
        G = null;
        J = false;
        K = imageproducer;
        D = outputstream;
    }

    protected abstract void A(int i, int j)
        throws IOException;

    protected abstract void A(int i, int j, int k, int l, int ai[], int i1, int j1)
        throws IOException;

    protected abstract void B()
        throws IOException;

    public synchronized void A()
        throws IOException
    {
        B = true;
        L = null;
        K.startProduction(this);
        while(B) 
            try
            {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
        if(L != null)
            throw L;
        else
            return;
    }

    private void B(int i, int j, int k, int l, int ai[], int i1, int j1)
        throws IOException
    {
        if(!F)
        {
            F = true;
            A(A, I);
            if((E & 2) == 0)
            {
                J = true;
                C = new int[A * I];
            }
        }
        if(J)
        {
            for(int k1 = 0; k1 < l; k1++)
                System.arraycopy(ai, k1 * j1 + i1, C, (j + k1) * A + i, k);

        } else
        {
            A(i, j, k, l, ai, i1, j1);
        }
    }

    private void C()
        throws IOException
    {
        if(J)
        {
            A(0, 0, A, I, C, 0, A);
            C = null;
            J = false;
        }
    }

    private synchronized void D()
    {
        B = false;
        notifyAll();
    }

    public void setDimensions(int i, int j)
    {
        A = i;
        I = j;
    }

    public void setProperties(Hashtable hashtable)
    {
        G = hashtable;
    }

    public void setColorModel(ColorModel colormodel)
    {
    }

    public void setHints(int i)
    {
        E = i;
    }

    public void setPixels(int i, int j, int k, int l, ColorModel colormodel, byte abyte0[], int i1, 
            int j1)
    {
        int ai[] = new int[k];
        for(int k1 = 0; k1 < l; k1++)
        {
            int l1 = i1 + k1 * j1;
            for(int i2 = 0; i2 < k; i2++)
                ai[i2] = colormodel.getRGB(abyte0[l1 + i2] & 0xff);

            try
            {
                B(i, j + k1, k, 1, ai, 0, k);
            }
            catch(IOException ioexception)
            {
                L = ioexception;
                D();
                return;
            }
        }

    }

    public void setPixels(int i, int j, int k, int l, ColorModel colormodel, int ai[], int i1, 
            int j1)
    {
        if(colormodel == H)
        {
            try
            {
                B(i, j, k, l, ai, i1, j1);
            }
            catch(IOException ioexception)
            {
                L = ioexception;
                D();
                return;
            }
        } else
        {
            int ai1[] = new int[k];
            for(int k1 = 0; k1 < l; k1++)
            {
                int l1 = i1 + k1 * j1;
                for(int i2 = 0; i2 < k; i2++)
                    ai1[i2] = colormodel.getRGB(ai[l1 + i2]);

                try
                {
                    B(i, j + k1, k, 1, ai1, 0, k);
                }
                catch(IOException ioexception1)
                {
                    L = ioexception1;
                    D();
                    return;
                }
            }

        }
    }

    public void imageComplete(int i)
    {
        K.removeConsumer(this);
        if(i == 4)
            L = new IOException("image aborted");
        else
            try
            {
                C();
                B();
            }
            catch(IOException ioexception)
            {
                L = ioexception;
            }
        D();
    }

    protected OutputStream D;
    private ImageProducer K;
    private int A;
    private int I;
    private int E;
    private boolean F;
    private boolean B;
    private IOException L;
    private static final ColorModel H = ColorModel.getRGBdefault();
    private Hashtable G;
    private boolean J;
    private int C[];

}
