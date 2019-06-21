// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            DefaultImageHandler, SVGGraphics2DIOException, SVGGraphics2DRuntimeException, SVGGeneratorContext, 
//            SVGIDGenerator

public abstract class AbstractImageHandlerEncoder extends DefaultImageHandler
{

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
            catch(ThreadDeath threaddeath)
            {
                throw threaddeath;
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

    public AbstractImageHandlerEncoder(String s, String s1)
        throws SVGGraphics2DIOException
    {
        imageDir = "";
        urlRoot = "";
        if(s == null)
            throw new SVGGraphics2DRuntimeException("imageDir should not be null");
        File file = new File(s);
        if(!file.exists())
            throw new SVGGraphics2DRuntimeException("imageDir does not exist");
        imageDir = s;
        if(s1 != null)
            urlRoot = s1;
        else
            try
            {
                urlRoot = file.toURL().toString();
            }
            catch(MalformedURLException malformedurlexception)
            {
                throw new SVGGraphics2DIOException("cannot convert imageDir to a URL value : " + malformedurlexception.getMessage(), malformedurlexception);
            }
    }

    protected void handleHREF(Image image, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        Dimension dimension = new Dimension(image.getWidth(null), image.getHeight(null));
        BufferedImage bufferedimage = buildBufferedImage(dimension);
        Graphics2D graphics2d = createGraphics(bufferedimage);
        graphics2d.drawImage(image, 0, 0, null);
        graphics2d.dispose();
        saveBufferedImageToFile(element, bufferedimage, svggeneratorcontext);
    }

    protected void handleHREF(RenderedImage renderedimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        Dimension dimension = new Dimension(renderedimage.getWidth(), renderedimage.getHeight());
        BufferedImage bufferedimage = buildBufferedImage(dimension);
        Graphics2D graphics2d = createGraphics(bufferedimage);
        graphics2d.drawRenderedImage(renderedimage, IDENTITY);
        graphics2d.dispose();
        saveBufferedImageToFile(element, bufferedimage, svggeneratorcontext);
    }

    protected void handleHREF(RenderableImage renderableimage, Element element, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        Dimension dimension = new Dimension((int)Math.ceil(renderableimage.getWidth()), (int)Math.ceil(renderableimage.getHeight()));
        BufferedImage bufferedimage = buildBufferedImage(dimension);
        Graphics2D graphics2d = createGraphics(bufferedimage);
        graphics2d.drawRenderableImage(renderableimage, IDENTITY);
        graphics2d.dispose();
        saveBufferedImageToFile(element, bufferedimage, svggeneratorcontext);
    }

    private void saveBufferedImageToFile(Element element, BufferedImage bufferedimage, SVGGeneratorContext svggeneratorcontext)
        throws SVGGraphics2DIOException
    {
        if(svggeneratorcontext == null)
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        File file = null;
        do
        {
            if(file != null)
                break;
            String s = svggeneratorcontext.idGenerator.generateID(getPrefix());
            file = new File(imageDir, s + getSuffix());
            if(file.exists())
                file = null;
        } while(true);
        encodeImage(bufferedimage, file);
        element.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", urlRoot + "/" + file.getName());
    }

    public abstract String getSuffix();

    public abstract String getPrefix();

    public abstract void encodeImage(BufferedImage bufferedimage, File file)
        throws SVGGraphics2DIOException;

    public abstract BufferedImage buildBufferedImage(Dimension dimension);

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private static final AffineTransform IDENTITY = new AffineTransform();
    private String imageDir;
    private String urlRoot;
    private static Method createGraphics = null;
    private static boolean initDone = false;
    private static final Class paramc[];
    private static Object paramo[] = null;

    static 
    {
        paramc = (new Class[] {
            java.awt.image.BufferedImage.class
        });
    }
}
