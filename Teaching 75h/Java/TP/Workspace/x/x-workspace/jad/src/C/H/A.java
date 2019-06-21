// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.*;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.stream.ImageOutputStream;

// Referenced classes of package C.H:
//            G

public class A extends G
{

    public A(ImageWriter imagewriter)
    {
        A(imagewriter);
    }

    public void A(ImageWriter imagewriter)
    {
        if(imagewriter == null)
            throw new NullPointerException();
        if(X != imagewriter)
        {
            X = imagewriter;
            W = imagewriter.getDefaultWriteParam();
        }
    }

    protected void A(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        ImageOutputStream imageoutputstream = ImageIO.createImageOutputStream(outputstream);
        X.setOutput(imageoutputstream);
        X.write(null, new IIOImage(bufferedimage, null, null), J());
        imageoutputstream.close();
        break MISSING_BLOCK_LABEL_55;
        Exception exception;
        exception;
        imageoutputstream.close();
        throw exception;
    }

    public String A()
    {
        String as[] = X.getOriginatingProvider().getFileSuffixes();
        return as != null && as.length >= 1 ? as[0] : "bin";
    }

    protected BufferedImage A(int i, int j)
    {
        BufferedImage bufferedimage = new BufferedImage(i, j, 1);
        return bufferedimage;
    }

    public ImageWriteParam J()
    {
        return W;
    }

    public void A(ImageWriteParam imagewriteparam)
    {
        if(imagewriteparam == null)
        {
            throw new NullPointerException();
        } else
        {
            W = imagewriteparam;
            return;
        }
    }

    private ImageWriter X;
    private ImageWriteParam W;
}
