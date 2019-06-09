// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.batik.ext.awt.image.codec.ImageEncoder;
import org.apache.batik.ext.awt.image.codec.PNGImageEncoder;
import org.apache.batik.util.Base64EncoderStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            DefaultCachedImageHandler, ImageCacher, SVGGeneratorContext

public class CachedImageHandlerBase64Encoder extends DefaultCachedImageHandler
{

    public CachedImageHandlerBase64Encoder()
    {
        setImageCacher(new ImageCacher.Embedded());
    }

    public Element createElement(SVGGeneratorContext svggeneratorcontext)
    {
        Element element = svggeneratorcontext.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "use");
        return element;
    }

    public String getRefPrefix()
    {
        return "";
    }

    protected AffineTransform handleTransform(Element element, double d, double d1, double d2, 
            double d3, double d4, double d5, SVGGeneratorContext svggeneratorcontext)
    {
        AffineTransform affinetransform = new AffineTransform();
        double d6 = d4 / d2;
        double d7 = d5 / d3;
        affinetransform.translate(d, d1);
        if(d6 != 1.0D || d7 != 1.0D)
            affinetransform.scale(d6, d7);
        if(!affinetransform.isIdentity())
            return affinetransform;
        else
            return null;
    }

    public void encodeImage(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException
    {
        Base64EncoderStream base64encoderstream = new Base64EncoderStream(outputstream);
        PNGImageEncoder pngimageencoder = new PNGImageEncoder(base64encoderstream, null);
        pngimageencoder.encode(bufferedimage);
        base64encoderstream.close();
    }

    public int getBufferedImageType()
    {
        return 2;
    }
}
