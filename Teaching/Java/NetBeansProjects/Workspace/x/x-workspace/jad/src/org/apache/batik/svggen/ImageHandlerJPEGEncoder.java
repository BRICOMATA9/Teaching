// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import com.sun.image.codec.jpeg.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractImageHandlerEncoder, SVGGraphics2DIOException

public class ImageHandlerJPEGEncoder extends AbstractImageHandlerEncoder
{

    public ImageHandlerJPEGEncoder(String s, String s1)
        throws SVGGraphics2DIOException
    {
        super(s, s1);
    }

    public final String getSuffix()
    {
        return ".jpg";
    }

    public final String getPrefix()
    {
        return "jpegImage";
    }

    public void encodeImage(BufferedImage bufferedimage, File file)
        throws SVGGraphics2DIOException
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            JPEGImageEncoder jpegimageencoder = JPEGCodec.createJPEGEncoder(fileoutputstream);
            JPEGEncodeParam jpegencodeparam = jpegimageencoder.getDefaultJPEGEncodeParam(bufferedimage);
            jpegencodeparam.setQuality(1.0F, false);
            jpegimageencoder.encode(bufferedimage, jpegencodeparam);
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException("could not write image File " + file.getName());
        }
    }

    public BufferedImage buildBufferedImage(Dimension dimension)
    {
        return new BufferedImage(dimension.width, dimension.height, 1);
    }
}
