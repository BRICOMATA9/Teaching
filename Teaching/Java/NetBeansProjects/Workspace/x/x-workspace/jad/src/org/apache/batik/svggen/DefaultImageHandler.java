// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            ImageHandler, ErrorConstants, SVGGraphics2DIOException, SVGGeneratorContext, 
//            ErrorHandler, SVGGraphics2DRuntimeException

public class DefaultImageHandler
    implements ImageHandler, ErrorConstants
{

    public DefaultImageHandler()
    {
    }

    public void handleImage(Image image, Element element, SVGGeneratorContext svggeneratorcontext)
    {
        element.setAttributeNS(null, "width", "" + image.getWidth(null));
        element.setAttributeNS(null, "height", "" + image.getHeight(null));
        try
        {
            handleHREF(image, element, svggeneratorcontext);
        }
        catch(SVGGraphics2DIOException svggraphics2dioexception)
        {
            try
            {
                svggeneratorcontext.errorHandler.handleError(svggraphics2dioexception);
            }
            catch(SVGGraphics2DIOException svggraphics2dioexception1)
            {
                throw new SVGGraphics2DRuntimeException(svggraphics2dioexception1);
            }
        }
    }

    public void handleImage(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext)
    {
        element.setAttributeNS(null, "width", "" + renderedimage.getWidth());
        element.setAttributeNS(null, "height", "" + renderedimage.getHeight());
        try
        {
            handleHREF(renderedimage, element, svggeneratorcontext);
        }
        catch(SVGGraphics2DIOException svggraphics2dioexception)
        {
            try
            {
                svggeneratorcontext.errorHandler.handleError(svggraphics2dioexception);
            }
            catch(SVGGraphics2DIOException svggraphics2dioexception1)
            {
                throw new SVGGraphics2DRuntimeException(svggraphics2dioexception1);
            }
        }
    }

    public void handleImage(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext)
    {
        element.setAttributeNS(null, "width", "" + renderableimage.getWidth());
        element.setAttributeNS(null, "height", "" + renderableimage.getHeight());
        try
        {
            handleHREF(renderableimage, element, svggeneratorcontext);
        }
        catch(SVGGraphics2DIOException svggraphics2dioexception)
        {
            try
            {
                svggeneratorcontext.errorHandler.handleError(svggraphics2dioexception);
            }
            catch(SVGGraphics2DIOException svggraphics2dioexception1)
            {
                throw new SVGGraphics2DRuntimeException(svggraphics2dioexception1);
            }
        }
    }

    protected void handleHREF(Image image, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", image.toString());
    }

    protected void handleHREF(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", renderedimage.toString());
    }

    protected void handleHREF(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", renderableimage.toString());
    }

    static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
}
