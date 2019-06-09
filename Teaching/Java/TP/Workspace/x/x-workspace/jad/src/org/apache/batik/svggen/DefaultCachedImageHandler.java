// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.*;
import java.lang.reflect.Method;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            CachedImageHandler, SVGSyntax, ErrorConstants, ImageCacher, 
//            SVGGeneratorContext, SVGGraphics2DIOException, ErrorHandler, SVGGraphics2DRuntimeException, 
//            DOMTreeManager

public abstract class DefaultCachedImageHandler
    implements CachedImageHandler, SVGSyntax, ErrorConstants
{

    public DefaultCachedImageHandler()
    {
    }

    public ImageCacher getImageCacher()
    {
        return imageCacher;
    }

    void setImageCacher(ImageCacher imagecacher)
    {
        if(imagecacher == null)
            throw new IllegalArgumentException();
        DOMTreeManager domtreemanager = null;
        if(imageCacher != null)
            domtreemanager = imageCacher.getDOMTreeManager();
        imageCacher = imagecacher;
        if(domtreemanager != null)
            imageCacher.setDOMTreeManager(domtreemanager);
    }

    public void setDOMTreeManager(DOMTreeManager domtreemanager)
    {
        imageCacher.setDOMTreeManager(domtreemanager);
    }

    private static Graphics2D createGraphics(BufferedImage bufferedimage)
    {
label0:
        {
            if(initDone)
                break label0;
            try
            {
                Class class1 = Class.forName("org.apache.batik.ext.awt.image.GraphicsUtil");
                createGraphics = class1.getMethod("createGraphics", paramc);
                paramo = new Object[1];
            }
            catch(Throwable throwable)
            {
                initDone = true;
                break label0;
            }
            finally
            {
                initDone = true;
                throw exception;
            }
            initDone = true;
            break label0;
        }
        if(createGraphics == null)
            return bufferedimage.createGraphics();
        paramo[0] = bufferedimage;
        Graphics2D graphics2d = null;
        try
        {
            graphics2d = (Graphics2D)createGraphics.invoke(null, paramo);
        }
        catch(Exception exception1) { }
        return graphics2d;
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
        AffineTransform affinetransform = null;
        if(i1 == 0 || j1 == 0 || k == 0 || l == 0)
        {
            handleEmptyImage(element);
        } else
        {
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
            affinetransform = handleTransform(element, i, j, i1, j1, k, l, svggeneratorcontext);
        }
        return affinetransform;
    }

    public AffineTransform handleImage(RenderedImage renderedimage, Element element, int i, int j, int k, int l, SVGGeneratorContext svggeneratorcontext)
    {
        int i1 = renderedimage.getWidth();
        int j1 = renderedimage.getHeight();
        AffineTransform affinetransform = null;
        if(i1 == 0 || j1 == 0 || k == 0 || l == 0)
        {
            handleEmptyImage(element);
        } else
        {
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
            affinetransform = handleTransform(element, i, j, i1, j1, k, l, svggeneratorcontext);
        }
        return affinetransform;
    }

    public AffineTransform handleImage(RenderableImage renderableimage, Element element, double d, double d1, double d2, double d3, SVGGeneratorContext svggeneratorcontext)
    {
        double d4 = renderableimage.getWidth();
        double d5 = renderableimage.getHeight();
        AffineTransform affinetransform = null;
        if(d4 == 0.0D || d5 == 0.0D || d2 == 0.0D || d3 == 0.0D)
        {
            handleEmptyImage(element);
        } else
        {
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
            affinetransform = handleTransform(element, d, d1, d4, d5, d2, d3, svggeneratorcontext);
        }
        return affinetransform;
    }

    protected AffineTransform handleTransform(Element element, double d, double d1, double d2, 
            double d3, double d4, double d5, SVGGeneratorContext svggeneratorcontext)
    {
        element.setAttributeNS(null, "x", svggeneratorcontext.doubleString(d));
        element.setAttributeNS(null, "y", svggeneratorcontext.doubleString(d1));
        element.setAttributeNS(null, "width", svggeneratorcontext.doubleString(d4));
        element.setAttributeNS(null, "height", svggeneratorcontext.doubleString(d5));
        return null;
    }

    protected void handleEmptyImage(Element element)
    {
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", "");
        element.setAttributeNS(null, "width", "0");
        element.setAttributeNS(null, "height", "0");
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
            BufferedImage bufferedimage = buildBufferedImage(new Dimension(i, j));
            Graphics2D graphics2d = createGraphics(bufferedimage);
            graphics2d.drawImage(image, 0, 0, null);
            graphics2d.dispose();
            handleHREF(((RenderedImage) (bufferedimage)), element, svggeneratorcontext);
        }
    }

    public BufferedImage buildBufferedImage(Dimension dimension)
    {
        return new BufferedImage(dimension.width, dimension.height, getBufferedImageType());
    }

    protected void handleHREF(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        BufferedImage bufferedimage = null;
        if((renderedimage instanceof BufferedImage) && ((BufferedImage)renderedimage).getType() == getBufferedImageType())
        {
            bufferedimage = (BufferedImage)renderedimage;
        } else
        {
            Dimension dimension = new Dimension(renderedimage.getWidth(), renderedimage.getHeight());
            bufferedimage = buildBufferedImage(dimension);
            Graphics2D graphics2d = createGraphics(bufferedimage);
            graphics2d.drawRenderedImage(renderedimage, IDENTITY);
            graphics2d.dispose();
        }
        cacheBufferedImage(element, bufferedimage, svggeneratorcontext);
    }

    protected void handleHREF(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        Dimension dimension = new Dimension((int)Math.ceil(renderableimage.getWidth()), (int)Math.ceil(renderableimage.getHeight()));
        BufferedImage bufferedimage = buildBufferedImage(dimension);
        Graphics2D graphics2d = createGraphics(bufferedimage);
        graphics2d.drawRenderableImage(renderableimage, IDENTITY);
        graphics2d.dispose();
        handleHREF(((RenderedImage) (bufferedimage)), element, svggeneratorcontext);
    }

    protected void cacheBufferedImage(Element element, BufferedImage bufferedimage, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        if(svggeneratorcontext == null)
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
            encodeImage(bufferedimage, bytearrayoutputstream);
            bytearrayoutputstream.flush();
            bytearrayoutputstream.close();
        }
        catch(IOException ioexception)
        {
            throw new SVGGraphics2DIOException("unexpected exception", ioexception);
        }
        String s = imageCacher.lookup(bytearrayoutputstream, bufferedimage.getWidth(), bufferedimage.getHeight(), svggeneratorcontext);
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", getRefPrefix() + s);
    }

    public abstract String getRefPrefix();

    public abstract void encodeImage(BufferedImage bufferedimage, OutputStream outputstream)
        throws IOException;

    public abstract int getBufferedImageType();

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    static final AffineTransform IDENTITY = new AffineTransform();
    private static Method createGraphics = null;
    private static boolean initDone = false;
    private static final Class paramc[];
    private static Object paramo[] = null;
    protected ImageCacher imageCacher;

    static 
    {
        paramc = (new Class[] {
            java.awt.image.BufferedImage.class
        });
    }
}
