// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import org.freehep.graphics2d.PixelGraphics2D;
import org.freehep.graphicsio.raw.RawImageWriteParam;
import org.freehep.util.UserProperties;
import org.freehep.util.images.ImageUtilities;
import org.freehep.util.io.ASCII85OutputStream;
import org.freehep.util.io.FlateOutputStream;

// Referenced classes of package org.freehep.graphicsio:
//            ImageParamConverter

public class ImageGraphics2D extends PixelGraphics2D
{

    public static Properties getDefaultProperties(String s)
    {
        UserProperties userproperties = (UserProperties)defaultProperties.get(s);
        if(userproperties == null)
        {
            userproperties = new UserProperties();
            defaultProperties.put(s, userproperties);
            String s1 = "org.freehep.graphicsio." + s;
            if(canWriteTransparent(s))
            {
                userproperties.setProperty(s1 + ".Transparent", true);
                userproperties.setProperty(s1 + ".Background", false);
                userproperties.setProperty(s1 + ".BackgroundColor", Color.GRAY);
            } else
            {
                userproperties.setProperty(s1 + ".Background", false);
                userproperties.setProperty(s1 + ".BackgroundColor", Color.GRAY);
            }
            userproperties.setProperty(s1 + ".Antialias", true);
            userproperties.setProperty(s1 + ".AntialiasText", true);
            ImageWriter imagewriter = getPreferredImageWriter(s);
            if(imagewriter != null)
            {
                ImageWriteParam imagewriteparam = imagewriter.getDefaultWriteParam();
                if(imagewriteparam.canWriteCompressed())
                {
                    imagewriteparam.setCompressionMode(2);
                    userproperties.setProperty(s1 + ".Compress", true);
                    String as[] = imagewriteparam.getCompressionTypes();
                    String s2 = imagewriteparam.getCompressionType();
                    userproperties.setProperty(s1 + ".CompressMode", s2 == null ? as[0] : s2);
                    userproperties.setProperty(s1 + ".CompressDescription", "Custom");
                    float f = 0.0F;
                    try
                    {
                        f = imagewriteparam.getCompressionQuality();
                    }
                    catch(IllegalStateException illegalstateexception) { }
                    userproperties.setProperty(s1 + ".CompressQuality", f);
                } else
                {
                    userproperties.setProperty(s1 + ".Compress", false);
                    userproperties.setProperty(s1 + ".CompressMode", "");
                    userproperties.setProperty(s1 + ".CompressDescription", "Custom");
                    userproperties.setProperty(s1 + ".CompressQuality", 0.0F);
                }
                if(imagewriteparam.canWriteProgressive())
                    userproperties.setProperty(s1 + ".Progressive", imagewriteparam.getProgressiveMode() != 0);
                else
                    userproperties.setProperty(s1 + ".Progressive", false);
            } else
            {
                System.err.println((org.freehep.graphicsio.ImageGraphics2D.class) + ": No writer for format '" + s + "'.");
            }
        }
        return userproperties;
    }

    public void setProperties(Properties properties)
    {
        if(properties == null)
            return;
        String s = "org.freehep.graphicsio." + format;
        Properties properties1 = new Properties();
        String s1;
        String s2;
        for(Enumeration enumeration = properties.propertyNames(); enumeration.hasMoreElements(); properties1.setProperty(s1, s2))
        {
            s1 = (String)enumeration.nextElement();
            s2 = properties.getProperty(s1);
            if(s1.indexOf("." + format) < 0)
                s1 = s + s1;
        }

        super.setProperties(properties1);
        setPropertiesOnGraphics();
    }

    private void setPropertiesOnGraphics()
    {
        String s = "org.freehep.graphicsio." + format;
        if(isProperty(s + ".Antialias"))
            setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        else
            setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        if(isProperty(s + ".AntialiasText"))
            setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        else
            setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        if(isProperty(s + ".Transparent"))
            setBackground(null);
        else
        if(isProperty(s + ".Background"))
            setBackground(getPropertyColor(s + ".BackgroundColor"));
        else
            setBackground(component == null ? Color.WHITE : component.getBackground());
    }

    private void setHintsOnGraphics()
    {
        if(format.equalsIgnoreCase("JPG"))
            setRenderingHint(KEY_SYMBOL_BLIT, VALUE_SYMBOL_BLIT_OFF);
        else
            setRenderingHint(KEY_SYMBOL_BLIT, VALUE_SYMBOL_BLIT_ON);
    }

    public ImageGraphics2D(File file, Dimension dimension, String s)
        throws FileNotFoundException
    {
        this(((OutputStream) (new FileOutputStream(file))), dimension, s);
    }

    public ImageGraphics2D(File file, Component component1, String s)
        throws FileNotFoundException
    {
        this(((OutputStream) (new FileOutputStream(file))), component1, s);
    }

    public ImageGraphics2D(OutputStream outputstream, Dimension dimension, String s)
    {
        init(outputstream, dimension, s);
        component = null;
    }

    public ImageGraphics2D(OutputStream outputstream, Component component1, String s)
    {
        component = component1;
        init(outputstream, component1.getSize(), s);
        setColor(component1.getForeground());
        GraphicsConfiguration graphicsconfiguration = component1.getGraphicsConfiguration();
        if(graphicsconfiguration != null)
            setTransform(graphicsconfiguration.getDefaultTransform());
    }

    private void init(OutputStream outputstream, Dimension dimension, String s)
    {
        os = outputstream;
        format = s;
        initProperties(getDefaultProperties(s));
        image = createBufferedImage(s, dimension.width, dimension.height);
        setHostGraphics(image.getGraphics());
        setPropertiesOnGraphics();
        setHintsOnGraphics();
        hostGraphics.clipRect(0, 0, dimension.width, dimension.height);
    }

    protected ImageGraphics2D(ImageGraphics2D imagegraphics2d)
    {
        super(imagegraphics2d);
        image = imagegraphics2d.image;
        os = imagegraphics2d.os;
        format = imagegraphics2d.format;
        setHintsOnGraphics();
    }

    public Graphics create()
    {
        return new ImageGraphics2D(this);
    }

    public Graphics create(double d, double d1, double d2, double d3)
    {
        ImageGraphics2D imagegraphics2d = new ImageGraphics2D(this);
        imagegraphics2d.translate(d, d1);
        imagegraphics2d.clipRect(0.0D, 0.0D, d2, d3);
        return imagegraphics2d;
    }

    public void startExport()
    {
        if(getBackground() != null)
            clearRect(0.0D, 0.0D, image.getWidth(), image.getHeight());
    }

    public void endExport()
    {
        try
        {
            write();
            closeStream();
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected void write()
        throws IOException
    {
        writeImage(image, format, getProperties(), os);
    }

    public void closeStream()
        throws IOException
    {
        os.close();
    }

    protected void handleException(Exception exception)
    {
        System.err.println(exception);
    }

    public static BufferedImage createBufferedImage(String s, int i, int j)
    {
        if("WBMP".equalsIgnoreCase(s))
            return new BufferedImage(i, j, 12);
        if("JPG".equalsIgnoreCase(s))
            return new BufferedImage(i, j, 1);
        if("BMP".equalsIgnoreCase(s))
            return new BufferedImage(i, j, 1);
        else
            return new BufferedImage(i, j, 2);
    }

    public static BufferedImage generateThumbnail(Component component1, Dimension dimension)
    {
        int i = Math.max(dimension.width, dimension.height);
        if(i < 0)
            return null;
        int j = component1.getBounds().width;
        int k = component1.getBounds().height;
        BufferedImage bufferedimage = new BufferedImage(j, k, 2);
        Graphics g = bufferedimage.getGraphics();
        component1.print(g);
        int l = i;
        int i1 = i;
        if(j < k)
            l = (j * dimension.height) / k;
        else
            i1 = (k * dimension.width) / j;
        BufferedImage bufferedimage1 = new BufferedImage(l, i1, 2);
        Graphics g1 = bufferedimage1.getGraphics();
        g1.drawImage(bufferedimage, 0, 0, l, i1, null);
        return bufferedimage1;
    }

    public static void writeImage(Image image1, String s, Properties properties, OutputStream outputstream)
        throws IOException
    {
        writeImage(ImageUtilities.createRenderedImage(image1, null, Color.black), s, properties, outputstream);
    }

    public static void writeImage(RenderedImage renderedimage, String s, Properties properties, OutputStream outputstream)
        throws IOException
    {
        ImageWriter imagewriter = getPreferredImageWriter(s);
        if(imagewriter == null)
            throw new IOException((org.freehep.graphicsio.ImageGraphics2D.class) + ": No writer for format '" + s + "'.");
        UserProperties userproperties = new UserProperties(properties);
        ImageWriteParam imagewriteparam = imagewriter.getDefaultWriteParam();
        if(imagewriteparam instanceof ImageParamConverter)
            imagewriteparam = ((ImageParamConverter)imagewriteparam).getWriteParam(userproperties);
        String s1 = "org.freehep.graphicsio." + s;
        if(imagewriteparam.canWriteCompressed())
            if(userproperties.isProperty(s1 + ".Compress"))
            {
                if(userproperties.getProperty(s1 + ".CompressMode").equals(""))
                {
                    imagewriteparam.setCompressionMode(1);
                } else
                {
                    imagewriteparam.setCompressionMode(2);
                    imagewriteparam.setCompressionType(userproperties.getProperty(s1 + ".CompressMode"));
                    imagewriteparam.setCompressionQuality(userproperties.getPropertyFloat(s1 + ".CompressQuality"));
                }
            } else
            if(canWriteUncompressed(s))
                imagewriteparam.setCompressionMode(0);
        if(imagewriteparam.canWriteProgressive())
            if(userproperties.isProperty(s1 + ".Progressive"))
                imagewriteparam.setProgressiveMode(1);
            else
                imagewriteparam.setProgressiveMode(0);
        ImageOutputStream imageoutputstream = ImageIO.createImageOutputStream(outputstream);
        imagewriter.setOutput(imageoutputstream);
        imagewriter.write(null, new IIOImage(renderedimage, null, null), imagewriteparam);
        imagewriter.dispose();
        imageoutputstream.close();
    }

    public static ImageWriter getPreferredImageWriter(String s)
    {
        return (ImageWriter)getImageWriters(ImageIO.getImageWritersByFormatName(s)).first();
    }

    public static ImageWriter getPreferredImageWriterForMIMEType(String s)
    {
        return (ImageWriter)getImageWriters(ImageIO.getImageWritersByMIMEType(s)).first();
    }

    public static SortedSet getImageWriters(Iterator iterator)
    {
        TreeSet treeset = new TreeSet(new Comparator() {

            private int order(Object obj)
            {
                String s = obj.getClass().getName();
                if(s.startsWith("org.freehep."))
                    return 0;
                if(s.startsWith("com.sun.imageio."))
                    return 1;
                return !s.startsWith("com.sun.media.") ? 3 : 2;
            }

            public int compare(Object obj, Object obj1)
            {
                int i = order(obj);
                int j = order(obj1);
                return i >= j ? ((int) (i <= j ? 0 : 1)) : -1;
            }

        });
        for(; iterator.hasNext(); treeset.add((ImageWriter)iterator.next()));
        return treeset;
    }

    public static BufferedImage readImage(String s, InputStream inputstream)
        throws IOException
    {
        Iterator iterator = ImageIO.getImageReadersByFormatName(s.toLowerCase());
        if(!iterator.hasNext())
        {
            throw new IOException((org.freehep.graphicsio.ImageGraphics2D.class) + ": No reader for format '" + s + "'.");
        } else
        {
            ImageReader imagereader = (ImageReader)iterator.next();
            ImageInputStream imageinputstream = ImageIO.createImageInputStream(inputstream);
            imagereader.setInput(imageinputstream, true);
            BufferedImage bufferedimage = imagereader.read(0);
            imagereader.dispose();
            imageinputstream.close();
            return bufferedimage;
        }
    }

    public static boolean canWriteUncompressed(String s)
    {
        return !Arrays.asList(alwaysCompressedFormats).contains(s.toLowerCase());
    }

    public static boolean canWriteTransparent(String s)
    {
        return !Arrays.asList(nonTransparentFormats).contains(s.toLowerCase());
    }

    public static UserProperties getRAWProperties(Color color, String s)
    {
        UserProperties userproperties = new UserProperties();
        userproperties.setProperty(RawImageWriteParam.BACKGROUND, color);
        userproperties.setProperty(RawImageWriteParam.CODE, s);
        userproperties.setProperty(RawImageWriteParam.PAD, 1);
        return userproperties;
    }

    public static byte[] toByteArray(RenderedImage renderedimage, String s, String s1, Properties properties)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Object obj = bytearrayoutputstream;
        if("ASCII85".equals(s1) || "Flate-ASCII85".equals(s1))
            obj = new ASCII85OutputStream(((OutputStream) (obj)));
        if("Flate".equals(s1) || "Flate-ASCII85".equals(s1))
            obj = new FlateOutputStream(((OutputStream) (obj)));
        if(properties == null)
            properties = new Properties();
        writeImage(renderedimage, s.toLowerCase(), properties, ((OutputStream) (obj)));
        ((OutputStream) (obj)).close();
        return bytearrayoutputstream.toByteArray();
    }

    private static final String alwaysCompressedFormats[] = {
        "JPG".toLowerCase(), "JPEG".toLowerCase(), "GIF".toLowerCase()
    };
    private static final String nonTransparentFormats[] = {
        "JPG".toLowerCase(), "JPEG".toLowerCase(), "PPM".toLowerCase()
    };
    public static final String rootKey = "org.freehep.graphicsio";
    public static final String TRANSPARENT = ".Transparent";
    public static final String BACKGROUND = ".Background";
    public static final String BACKGROUND_COLOR = ".BackgroundColor";
    public static final String ANTIALIAS = ".Antialias";
    public static final String ANTIALIAS_TEXT = ".AntialiasText";
    public static final String PROGRESSIVE = ".Progressive";
    public static final String COMPRESS = ".Compress";
    public static final String COMPRESS_MODE = ".CompressMode";
    public static final String COMPRESS_DESCRIPTION = ".CompressDescription";
    public static final String COMPRESS_QUALITY = ".CompressQuality";
    private static final Map defaultProperties = new HashMap();
    protected OutputStream os;
    protected BufferedImage image;
    protected String format;
    protected Component component;

}
