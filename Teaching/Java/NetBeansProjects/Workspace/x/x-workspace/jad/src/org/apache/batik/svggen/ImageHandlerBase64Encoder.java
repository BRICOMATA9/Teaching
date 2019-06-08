// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.*;
import org.apache.batik.ext.awt.image.codec.ImageEncoder;
import org.apache.batik.ext.awt.image.codec.PNGImageEncoder;
import org.apache.batik.util.Base64EncoderStream;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            DefaultImageHandler, SVGGraphics2DIOException, SVGGraphics2DRuntimeException, SVGGeneratorContext

public class ImageHandlerBase64Encoder extends DefaultImageHandler
{

    public ImageHandlerBase64Encoder()
    {
    }

    public void handleHREF(Image image, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        if(image == null)
            throw new SVGGraphics2DRuntimeException("image should not be null");
        int i = image.getWidth(null);
        int j = image.getHeight(null);
        if(i == 0 || j == 0)
            handleEmptyImage(element);
        else
        if(image instanceof RenderedImage)
        {
            handleHREF((RenderedImage)image, element, svggeneratorcontext);
        } else
        {
            BufferedImage bufferedimage = new BufferedImage(i, j, 2);
            Graphics2D graphics2d = bufferedimage.createGraphics();
            graphics2d.drawImage(image, 0, 0, null);
            graphics2d.dispose();
            handleHREF(((RenderedImage) (bufferedimage)), element, svggeneratorcontext);
        }
    }

    public void handleHREF(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        if(renderableimage == null)
            throw new SVGGraphics2DRuntimeException("image should not be null");
        RenderedImage renderedimage = renderableimage.createDefaultRendering();
        if(renderedimage == null)
            handleEmptyImage(element);
        else
            handleHREF(renderedimage, element, svggeneratorcontext);
    }

    protected void handleEmptyImage(Element element)
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", "data:image/png;base64,");
        element.setAttributeNS(null, "width", "0");
        element.setAttributeNS(null, "height", "0");
    }

    public void handleHREF(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Base64EncoderStream base64encoderstream = new Base64EncoderStream(bytearrayoutputstream);
        try
        {
            encodeImage(renderedimage, base64encoderstream);
            base64encoderstream.close();
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException("unexpected exception", ioexception);
        }
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", "data:image/png;base64," + bytearrayoutputstream.toString());
    }

    public void encodeImage(RenderedImage renderedimage, OutputStream outputstream)
        throws SVGGraphics2DIOException
    {
        try
        {
            PNGImageEncoder pngimageencoder = new PNGImageEncoder(outputstream, null);
            pngimageencoder.encode(renderedimage);
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException("unexpected exception");
        }
    }

    public BufferedImage buildBufferedImage(Dimension dimension)
    {
        return new BufferedImage(dimension.width, dimension.height, 2);
    }
}
