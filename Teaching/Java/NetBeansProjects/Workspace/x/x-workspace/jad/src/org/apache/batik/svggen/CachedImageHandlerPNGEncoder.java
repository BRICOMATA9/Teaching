// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.batik.ext.awt.image.codec.ImageEncoder;
import org.apache.batik.ext.awt.image.codec.PNGImageEncoder;

// Referenced classes of package org.apache.batik.svggen:
//            DefaultCachedImageHandler, ImageCacher, SVGGraphics2DIOException

public class CachedImageHandlerPNGEncoder extends DefaultCachedImageHandler
{

    public CachedImageHandlerPNGEncoder(String s, String s1)
        throws SVGGraphics2DIOException
    {
        refPrefix = "";
        refPrefix = s1 + "/";
        setImageCacher(new ImageCacher.External(s, "pngImage", ".png"));
    }

    public void encodeImage(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        PNGImageEncoder pngimageencoder = new PNGImageEncoder(outputstream, null);
        pngimageencoder.encode(bufferedimage);
    }

    public int getBufferedImageType()
    {
        return 2;
    }

    public String getRefPrefix()
    {
        return refPrefix;
    }

    public static final String CACHED_PNG_PREFIX = "pngImage";
    public static final String CACHED_PNG_SUFFIX = ".png";
    protected String refPrefix;
}
