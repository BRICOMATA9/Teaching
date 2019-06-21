// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import com.sun.image.codec.jpeg.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package C.H:
//            G

public class I extends G
{

    public I()
    {
        super(true);
        Y = 1.0F;
    }

    public String A()
    {
        return "jpg";
    }

    protected BufferedImage A(int i, int j)
    {
        BufferedImage bufferedimage = new BufferedImage(i, j, 1);
        return bufferedimage;
    }

    protected void A(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        JPEGImageEncoder jpegimageencoder = JPEGCodec.createJPEGEncoder(outputstream);
        JPEGEncodeParam jpegencodeparam = jpegimageencoder.getDefaultJPEGEncodeParam(bufferedimage);
        jpegencodeparam.setQuality(Y, true);
        jpegimageencoder.encode(bufferedimage, jpegencodeparam);
    }

    public void A(float f)
    {
        Y = f;
    }

    private float Y;
}
