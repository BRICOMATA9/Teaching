// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;
import org.apache.batik.ext.awt.image.codec.ImageEncoder;
import org.apache.batik.ext.awt.image.codec.PNGImageEncoder;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractImageHandlerEncoder, SVGGraphics2DIOException

public class ImageHandlerPNGEncoder extends AbstractImageHandlerEncoder
{

    public ImageHandlerPNGEncoder(String s, String s1)
        throws SVGGraphics2DIOException
    {
        super(s, s1);
    }

    public final String getSuffix()
    {
        return ".png";
    }

    public final String getPrefix()
    {
        return "pngImage";
    }

    public void encodeImage(BufferedImage bufferedimage, File file)
        throws SVGGraphics2DIOException
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            PNGImageEncoder pngimageencoder = new PNGImageEncoder(fileoutputstream, null);
            pngimageencoder.encode(bufferedimage);
            fileoutputstream.close();
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException("could not write image File " + file.getName());
        }
    }

    public BufferedImage buildBufferedImage(Dimension dimension)
    {
        return new BufferedImage(dimension.width, dimension.height, 2);
    }
}
