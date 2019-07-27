// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import com.sun.image.codec.jpeg.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.batik.svggen:
//            DefaultCachedImageHandler, ImageCacher, SVGGraphics2DIOException

public class CachedImageHandlerJPEGEncoder extends DefaultCachedImageHandler
{

    public CachedImageHandlerJPEGEncoder(String s, String s1)
        throws SVGGraphics2DIOException
    {
        refPrefix = "";
        refPrefix = s1 + "/";
        setImageCacher(new ImageCacher.External(s, "jpegImage", ".jpg"));
    }

    public void encodeImage(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        JPEGImageEncoder jpegimageencoder = JPEGCodec.createJPEGEncoder(outputstream);
        JPEGEncodeParam jpegencodeparam = jpegimageencoder.getDefaultJPEGEncodeParam(bufferedimage);
        jpegencodeparam.setQuality(1.0F, false);
        jpegimageencoder.encode(bufferedimage, jpegencodeparam);
    }

    public int getBufferedImageType()
    {
        return 1;
    }

    public String getRefPrefix()
    {
        return refPrefix;
    }

    public static final String CACHED_JPEG_PREFIX = "jpegImage";
    public static final String CACHED_JPEG_SUFFIX = ".jpg";
    protected String refPrefix;
}
