// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.E.M;
import C.H.H;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.JLabel;

// Referenced classes of package C.J:
//            Y

public class y extends Y
{

    public y()
    {
    }

    public y(Y y1)
    {
        super(y1);
        if(y1 instanceof y)
        {
            y y2 = (y)y1;
            X = y2.X;
            a = y2.a;
            Y = y2.Y;
        }
    }

    public boolean D(double d1, double d2)
    {
        if(a != null)
        {
            d1 -= C();
            d2 -= A();
            d1 *= (double)a.getWidth() / B();
            d2 *= (double)a.getHeight() / D();
            if(d1 >= 0.0D && d2 >= 0.0D && d1 < (double)a.getWidth() && d2 < (double)a.getHeight())
                return (a.getRGB((int)d1, (int)d2) >> 24 & 0xff) > 127;
            else
                return false;
        } else
        {
            return super.D(d1, d2);
        }
    }

    public void D(boolean flag)
    {
        E(flag);
        R();
    }

    private void E(boolean flag)
    {
        BufferedImage bufferedimage;
        BufferedImage bufferedimage1;
        Graphics2D graphics2d1;
        if(!flag)
        {
            a = null;
            break MISSING_BLOCK_LABEL_390;
        }
        if(X == null)
        {
            a = _;
            return;
        }
        a = (BufferedImage)V.get(X);
        if(a != null)
            break MISSING_BLOCK_LABEL_390;
        if(X == null)
        {
            a = _;
            break MISSING_BLOCK_LABEL_390;
        }
        if(X instanceof BufferedImage)
        {
            a = (BufferedImage)X;
            break MISSING_BLOCK_LABEL_375;
        }
        int i = (int)((double)X.getWidth(b) * 1.0D);
        int j = (int)((double)X.getHeight(b) * 1.0D);
        if(i <= 0 || j <= 0)
            break MISSING_BLOCK_LABEL_375;
        bufferedimage = new BufferedImage(i, j, 2);
        Graphics2D graphics2d = bufferedimage.createGraphics();
        graphics2d.drawImage(X, AffineTransform.getScaleInstance(1.0D, 1.0D), null);
        graphics2d.setComposite(AlphaComposite.getInstance(5, 1.0F));
        graphics2d.setColor(new Color(128, 128, 128));
        graphics2d.fillRect(0, 0, i, j);
        graphics2d.dispose();
        Color color = new Color(128, 128, 128, 0);
        Color color1 = new Color(0, 0, 0, 0);
        IndexColorModel indexcolormodel = new IndexColorModel(1, 2, new byte[] {
            (byte)color1.getRed(), (byte)color.getRed()
        }, new byte[] {
            (byte)color1.getGreen(), (byte)color.getGreen()
        }, new byte[] {
            (byte)color1.getBlue(), (byte)color.getBlue()
        }, 0);
        bufferedimage1 = new BufferedImage(i, j, 13, indexcolormodel);
        graphics2d1 = bufferedimage1.createGraphics();
        graphics2d1.drawImage(bufferedimage, 0, 0, null, null);
        graphics2d1.dispose();
        break MISSING_BLOCK_LABEL_369;
        Exception exception;
        exception;
        graphics2d1.dispose();
        throw exception;
        a = bufferedimage1;
        V.put(X, a);
    }

    public boolean Z()
    {
        return a != null;
    }

    public Y A(Y y1)
    {
        return new y(y1);
    }

    public static Image B(URL url)
    {
        if(url == null)
            throw new NullPointerException("imageURL must not be null");
        Image image = (Image)Z.get(url);
        if(image == null)
        {
            image = A(url);
            if(image != null)
                Z.put(url, image);
        }
        return image;
    }

    public static Hashtable a()
    {
        return Z;
    }

    public static Image D(URL url)
    {
        return (Image)Z.get(url);
    }

    public void C(URL url)
    {
        X = B(url);
        Y = url;
        if(a != null)
        {
            a = null;
            D(true);
        }
    }

    public void B(Image image)
    {
        A(image);
        X = image;
        Y = null;
        if(a != null)
        {
            a = null;
            D(true);
        }
    }

    public Image c()
    {
        return X;
    }

    public URL _()
    {
        return Y;
    }

    public void b()
    {
        if(c() != null)
            B(c().getWidth(null), c().getHeight(null));
    }

    public void D(Graphics2D graphics2d)
    {
        if(X != null)
            graphics2d.drawImage(X, (int)S, (int)Q, (int)F, (int)T, null);
        if(I())
            C(graphics2d);
        A(graphics2d);
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        if(Z())
            objectoutputstream.writeByte(1);
        else
            objectoutputstream.writeByte(0);
        super.A(objectoutputstream);
        objectoutputstream.writeObject(Y);
        if(W != objectoutputstream)
        {
            d.clear();
            W = objectoutputstream;
        }
        if(Y != null && d.contains(Y))
        {
            objectoutputstream.writeBoolean(false);
        } else
        {
            objectoutputstream.writeBoolean(true);
            if(X == null)
            {
                objectoutputstream.writeInt(0);
                objectoutputstream.writeInt(0);
                objectoutputstream.write(new byte[0]);
            } else
            {
                try
                {
                    int i = X.getWidth(b);
                    int j = X.getHeight(b);
                    int ai[] = new int[i * j];
                    PixelGrabber pixelgrabber = new PixelGrabber(X, 0, 0, i, j, ai, 0, i);
                    pixelgrabber.grabPixels();
                    objectoutputstream.writeInt(i);
                    objectoutputstream.writeInt(j);
                    byte abyte0[] = new byte[ai.length * 4];
                    for(int k = 0; k < ai.length; k++)
                    {
                        int l = ai[k];
                        int i1 = k * 4;
                        abyte0[i1 + 3] = (byte)(l & 0xff);
                        abyte0[i1 + 2] = (byte)(l >>> 8 & 0xff);
                        abyte0[i1 + 1] = (byte)(l >>> 16 & 0xff);
                        abyte0[i1] = (byte)(l >>> 24 & 0xff);
                    }

                    objectoutputstream.write(abyte0);
                    if(Y != null)
                        d.add(Y);
                }
                catch(InterruptedException interruptedexception)
                {
                    M.A("grabbing interrupted while serializing");
                }
            }
        }
    }

    public void A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        byte byte0 = objectinputstream.readByte();
        switch(byte0)
        {
        case 0: // '\0'
        case 1: // '\001'
            super.A(objectinputstream);
            Y = (URL)objectinputstream.readObject();
            if(objectinputstream.readBoolean())
            {
                int i = objectinputstream.readInt();
                int j = objectinputstream.readInt();
                byte abyte0[] = new byte[i * j * 4];
                int l;
                for(int k = 0; k < abyte0.length - 1; k += l)
                {
                    l = objectinputstream.read(abyte0, k, abyte0.length - k);
                    if(l < 0)
                        throw new EOFException("Unexpected end of file");
                }

                int ai[] = new int[i * j];
                for(int i1 = 0; i1 < ai.length; i1++)
                {
                    int j1 = i1 * 4;
                    ai[i1] = ((abyte0[j1] & 0xff) << 24) + ((abyte0[j1 + 1] & 0xff) << 16) + ((abyte0[j1 + 2] & 0xff) << 8) + ((abyte0[j1 + 3] & 0xff) << 0);
                }

                X = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(i, j, ai, 0, i));
                if(Y != null)
                    Z.put(Y, X);
                A(X);
            } else
            if(Y != null)
                X = D(Y);
            D(byte0 == 1);
            break;

        default:
            throw new H();
        }
    }

    private static Image A(URL url)
    {
        Image image = Toolkit.getDefaultToolkit().createImage(url);
        image = A(image);
        return image;
    }

    private static Image A(Image image)
    {
        MediaTracker mediatracker = c;
        JVM INSTR monitorenter ;
        int i;
        c.addImage(image, 0);
        try
        {
            c.waitForID(0, 5000L);
        }
        catch(InterruptedException interruptedexception)
        {
            M.A("INTERRUPTED while loading Image");
        }
        i = c.statusID(0, false);
        c.removeImage(image, 0);
        i;
        JVM INSTR lookupswitch 2: default 88
    //                   2: 80
    //                   4: 84;
           goto _L1 _L2 _L3
_L2:
        return null;
_L3:
        null;
        mediatracker;
        JVM INSTR monitorexit ;
        return;
_L1:
        image;
        mediatracker;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final Hashtable Z = new Hashtable(11);
    private static final Hashtable V = new Hashtable(11);
    private static final Set d = new HashSet(11);
    private static OutputStream W = null;
    private static final Component b;
    private static final MediaTracker c;
    private URL Y;
    private Image X;
    private BufferedImage a;
    private static final BufferedImage _;

    static 
    {
        b = new JLabel();
        c = new MediaTracker(b);
        _ = new BufferedImage(1, 1, 12);
        _.setRGB(0, 0, Color.black.getRGB());
    }
}
