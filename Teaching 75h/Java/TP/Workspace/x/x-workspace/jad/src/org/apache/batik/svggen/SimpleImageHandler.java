// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            GenericImageHandler, SVGSyntax, ErrorConstants, SVGGeneratorContext, 
//            ImageHandler, DOMTreeManager

public class SimpleImageHandler
    implements GenericImageHandler, SVGSyntax, ErrorConstants
{

    public SimpleImageHandler(ImageHandler imagehandler)
    {
        if(imagehandler == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            imageHandler = imagehandler;
            return;
        }
    }

    public void setDOMTreeManager(DOMTreeManager domtreemanager)
    {
    }

    public Element createElement(SVGGeneratorContext svggeneratorcontext)
    {
        Element element = svggeneratorcontext.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "image");
        return element;
    }

    public AffineTransform handleImage(Image image, Element element, int i, int j, int k, int l, SVGGeneratorContext svggeneratorcontext)
    {
        int i1 = image.getWidth(null);
        int j1 = image.getHeight(null);
        if(i1 == 0 || j1 == 0 || k == 0 || l == 0)
        {
            handleEmptyImage(element);
        } else
        {
            imageHandler.handleImage(image, element, svggeneratorcontext);
            setImageAttributes(element, i, j, k, l, svggeneratorcontext);
        }
        return null;
    }

    public AffineTransform handleImage(RenderedImage renderedimage, Element element, int i, int j, int k, int l, SVGGeneratorContext svggeneratorcontext)
    {
        int i1 = renderedimage.getWidth();
        int j1 = renderedimage.getHeight();
        if(i1 == 0 || j1 == 0 || k == 0 || l == 0)
        {
            handleEmptyImage(element);
        } else
        {
            imageHandler.handleImage(renderedimage, element, svggeneratorcontext);
            setImageAttributes(element, i, j, k, l, svggeneratorcontext);
        }
        return null;
    }

    public AffineTransform handleImage(RenderableImage renderableimage, Element element, double d, double d1, double d2, double d3, SVGGeneratorContext svggeneratorcontext)
    {
        double d4 = renderableimage.getWidth();
        double d5 = renderableimage.getHeight();
        if(d4 == 0.0D || d5 == 0.0D || d2 == 0.0D || d3 == 0.0D)
        {
            handleEmptyImage(element);
        } else
        {
            imageHandler.handleImage(renderableimage, element, svggeneratorcontext);
            setImageAttributes(element, d, d1, d2, d3, svggeneratorcontext);
        }
        return null;
    }

    protected void setImageAttributes(Element element, double d, double d1, double d2, 
            double d3, SVGGeneratorContext svggeneratorcontext)
    {
        element.setAttributeNS(null, "x", svggeneratorcontext.doubleString(d));
        element.setAttributeNS(null, "y", svggeneratorcontext.doubleString(d1));
        element.setAttributeNS(null, "width", svggeneratorcontext.doubleString(d2));
        element.setAttributeNS(null, "height", svggeneratorcontext.doubleString(d3));
        element.setAttributeNS(null, "preserveAspectRatio", "none");
    }

    protected void handleEmptyImage(Element element)
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", "");
        element.setAttributeNS(null, "width", "0");
        element.setAttributeNS(null, "height", "0");
    }

    static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    protected ImageHandler imageHandler;
}
