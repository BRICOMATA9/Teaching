// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.image.renderable.RenderContext;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.io.PrintStream;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.Map;
import org.freehep.graphics2d.font.FontEncoder;
import org.freehep.graphics2d.font.FontUtilities;
import org.freehep.util.images.ImageUtilities;

// Referenced classes of package org.freehep.graphicsio:
//            VectorGraphicsIO, MultiPageDocument

public abstract class AbstractVectorGraphicsIO extends VectorGraphicsIO
{

    protected AbstractVectorGraphicsIO(Dimension dimension, boolean flag)
    {
        oldTransform = new AffineTransform();
        size = dimension;
        component = null;
        doRestoreOnDispose = flag;
        deviceClip = dimension == null ? null : new Rectangle(0, 0, dimension.width, dimension.height);
        userClip = null;
        currentTransform = new AffineTransform();
        currentComposite = AlphaComposite.getInstance(3);
        currentStroke = new BasicStroke(1.0F, 2, 0, 10F, null, 0.0F);
        super.setColor(Color.BLACK);
        super.setBackground(Color.BLACK);
        super.setFont(new Font("Dialog", 0, 12));
        hints = new RenderingHints(null);
    }

    protected AbstractVectorGraphicsIO(Component component1, boolean flag)
    {
        oldTransform = new AffineTransform();
        size = component1.getSize();
        component = component1;
        doRestoreOnDispose = flag;
        deviceClip = size == null ? null : new Rectangle(0, 0, size.width, size.height);
        userClip = null;
        GraphicsConfiguration graphicsconfiguration = component1.getGraphicsConfiguration();
        currentTransform = graphicsconfiguration == null ? new AffineTransform() : graphicsconfiguration.getDefaultTransform();
        currentComposite = AlphaComposite.getInstance(3);
        currentStroke = new BasicStroke(1.0F, 2, 0, 10F, null, 0.0F);
        super.setFont(component1.getFont());
        super.setBackground(component1.getBackground());
        super.setColor(component1.getForeground());
        hints = new RenderingHints(null);
    }

    protected AbstractVectorGraphicsIO(AbstractVectorGraphicsIO abstractvectorgraphicsio, boolean flag)
    {
        super(abstractvectorgraphicsio);
        oldTransform = new AffineTransform();
        doRestoreOnDispose = flag;
        size = new Dimension(abstractvectorgraphicsio.size);
        component = abstractvectorgraphicsio.component;
        deviceClip = new Rectangle(abstractvectorgraphicsio.deviceClip);
        userClip = abstractvectorgraphicsio.userClip == null ? null : new Area(abstractvectorgraphicsio.userClip);
        currentTransform = new AffineTransform(abstractvectorgraphicsio.currentTransform);
        currentComposite = abstractvectorgraphicsio.currentComposite;
        currentStroke = abstractvectorgraphicsio.currentStroke;
        hints = abstractvectorgraphicsio.hints;
    }

    public Dimension getSize()
    {
        return size;
    }

    public Component getComponent()
    {
        return component;
    }

    public void startExport()
    {
        try
        {
            writeHeader();
            if(!(this instanceof MultiPageDocument))
            {
                writeGraphicsState();
                writeBackground();
            }
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void endExport()
    {
        try
        {
            dispose();
            writeTrailer();
            closeStream();
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public abstract void writeHeader()
        throws IOException;

    public void writeGraphicsState()
        throws IOException
    {
        writePaint(getPrintColor(getColor()));
        writeSetTransform(getTransform());
        setClip(getClip());
    }

    public abstract void writeBackground()
        throws IOException;

    public abstract void writeTrailer()
        throws IOException;

    public abstract void closeStream()
        throws IOException;

    public void printComment(String s)
    {
        try
        {
            writeComment(s);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public abstract void writeComment(String s)
        throws IOException;

    protected void resetClip(Rectangle rectangle)
    {
        deviceClip = rectangle;
        userClip = null;
    }

    public void dispose()
    {
        try
        {
            if(doRestoreOnDispose)
            {
                writeGraphicsRestore();
                doRestoreOnDispose = false;
            }
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected abstract void writeGraphicsSave()
        throws IOException;

    protected abstract void writeGraphicsRestore()
        throws IOException;

    public boolean drawImage(Image image, int i, int j, ImageObserver imageobserver)
    {
        int k = image.getWidth(imageobserver);
        int l = image.getHeight(imageobserver);
        return drawImage(image, i, j, i + k, j + l, 0, 0, k, l, null, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, ImageObserver imageobserver)
    {
        int i1 = image.getWidth(imageobserver);
        int j1 = image.getHeight(imageobserver);
        return drawImage(image, i, j, i + k, j + l, 0, 0, i1, j1, null, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, Color color, ImageObserver imageobserver)
    {
        int i1 = image.getWidth(imageobserver);
        int j1 = image.getHeight(imageobserver);
        return drawImage(image, i, j, i + k, j + l, 0, 0, i1, j1, color, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, Color color, ImageObserver imageobserver)
    {
        int k = image.getWidth(imageobserver);
        int l = image.getHeight(imageobserver);
        return drawImage(image, i, j, i + k, j + l, 0, 0, k, l, color, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, ImageObserver imageobserver)
    {
        return drawImage(image, i, j, k, l, i1, j1, k1, l1, null, imageobserver);
    }

    public boolean drawImage(Image image, AffineTransform affinetransform, ImageObserver imageobserver)
    {
        drawRenderedImage(ImageUtilities.createRenderedImage(image, imageobserver, null), affinetransform);
        return true;
    }

    public void drawImage(BufferedImage bufferedimage, BufferedImageOp bufferedimageop, int i, int j)
    {
        drawImage(((Image) (bufferedimageop.filter(bufferedimage, null))), i, j, ((ImageObserver) (null)));
    }

    public void drawRenderableImage(RenderableImage renderableimage, AffineTransform affinetransform)
    {
        drawRenderedImage(renderableimage.createRendering(new RenderContext(new AffineTransform(), getRenderingHints())), affinetransform);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, Color color, ImageObserver imageobserver)
    {
        int i2 = Math.min(i1, k1);
        int j2 = Math.min(j1, l1);
        int k2 = Math.abs(k1 - i1);
        int l2 = Math.abs(l1 - j1);
        int i3 = Math.abs(k - i);
        int j3 = Math.abs(l - j);
        if(i2 != 0 || j2 != 0 || k2 != image.getWidth(imageobserver) || l2 != image.getHeight(imageobserver))
        {
            CropImageFilter cropimagefilter = new CropImageFilter(i2, j2, k2, l2);
            image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropimagefilter));
            MediaTracker mediatracker = new MediaTracker(new Panel());
            mediatracker.addImage(image, 0);
            try
            {
                mediatracker.waitForAll();
            }
            catch(InterruptedException interruptedexception)
            {
                handleException(interruptedexception);
            }
        }
        boolean flag = (k < i) ^ (k1 < i1);
        boolean flag1 = (l < j) ^ (l1 < j1);
        double d = flag ? k : i;
        double d1 = flag1 ? l : j;
        double d2 = (double)i3 / (double)k2;
        d2 = flag ? -1D * d2 : d2;
        double d3 = (double)j3 / (double)l2;
        d3 = flag1 ? -1D * d3 : d3;
        writeImage(ImageUtilities.createRenderedImage(image, imageobserver, color), new AffineTransform(d2, 0.0D, 0.0D, d3, d, d1), color);
        return true;
        IOException ioexception;
        ioexception;
        handleException(ioexception);
        return false;
    }

    public void drawRenderedImage(RenderedImage renderedimage, AffineTransform affinetransform)
    {
        try
        {
            writeImage(renderedimage, affinetransform, null);
        }
        catch(Exception exception)
        {
            handleException(exception);
        }
    }

    protected abstract void writeImage(RenderedImage renderedimage, AffineTransform affinetransform, Color color)
        throws IOException;

    public void clearRect(double d, double d1, double d2, double d3)
    {
        Paint paint = getPaint();
        setPaint(getBackground());
        fillRect(d, d1, d2, d3);
        setPaint(paint);
    }

    public void drawString(String s, double d, double d1)
    {
        if(s == null || s.equals(""))
            return;
        if(isProperty(TEXT_AS_SHAPES))
        {
            Font font = getFont();
            String s1 = font.getName();
            if(s1.equals("Symbol") || s1.equals("ZapfDingbats"))
            {
                s = FontEncoder.getEncodedString(s, s1);
                font = new Font("Serif", font.getStyle(), font.getSize());
            }
            GlyphVector glyphvector = font.createGlyphVector(getFontRenderContext(), s);
            drawGlyphVector(glyphvector, (float)d, (float)d1);
        } else
        {
            try
            {
                writeString(s, d, d1);
            }
            catch(IOException ioexception)
            {
                handleException(ioexception);
            }
        }
    }

    protected abstract void writeString(String s, double d, double d1)
        throws IOException;

    public void drawGlyphVector(GlyphVector glyphvector, float f, float f1)
    {
        fill(glyphvector.getOutline(f, f1));
    }

    public void drawString(AttributedCharacterIterator attributedcharacteriterator, float f, float f1)
    {
        if(isProperty(TEXT_AS_SHAPES))
        {
            TextLayout textlayout = new TextLayout(attributedcharacteriterator, getFontRenderContext());
            textlayout.draw(this, f, f1);
        } else
        {
            Font font = getFont();
            Object obj = FontUtilities.getAttributes(font);
            StringBuffer stringbuffer = new StringBuffer();
            for(char c = attributedcharacteriterator.first(); c != '\uFFFF'; c = attributedcharacteriterator.next())
            {
                if(obj.equals(attributedcharacteriterator.getAttributes()))
                {
                    stringbuffer.append(c);
                    continue;
                }
                if(stringbuffer.length() > 0)
                {
                    drawString(stringbuffer.toString(), f, f1);
                    TextLayout textlayout1 = new TextLayout(stringbuffer.toString(), ((Map) (obj)), getFontRenderContext());
                    f += Math.max(textlayout1.getAdvance(), (float)textlayout1.getBounds().getWidth());
                }
                stringbuffer = new StringBuffer();
                stringbuffer.append(c);
                obj = attributedcharacteriterator.getAttributes();
                setFont(new Font(((Map) (obj))));
            }

            if(stringbuffer.length() > 0)
                drawString(stringbuffer.toString(), f, f1);
            setFont(font);
        }
    }

    public AffineTransform getTransform()
    {
        return new AffineTransform(currentTransform);
    }

    public void setTransform(AffineTransform affinetransform)
    {
        oldTransform.setTransform(currentTransform);
        currentTransform.setTransform(affinetransform);
        try
        {
            writeSetTransform(affinetransform);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void transform(AffineTransform affinetransform)
    {
        currentTransform.concatenate(affinetransform);
        try
        {
            writeTransform(affinetransform);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void translate(double d, double d1)
    {
        currentTransform.translate(d, d1);
        try
        {
            writeTransform(new AffineTransform(1.0D, 0.0D, 0.0D, 1.0D, d, d1));
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void rotate(double d)
    {
        currentTransform.rotate(d);
        try
        {
            writeTransform(new AffineTransform(Math.cos(d), Math.sin(d), -Math.sin(d), Math.cos(d), 0.0D, 0.0D));
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void scale(double d, double d1)
    {
        currentTransform.scale(d, d1);
        try
        {
            writeTransform(new AffineTransform(d, 0.0D, 0.0D, d1, 0.0D, 0.0D));
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void shear(double d, double d1)
    {
        currentTransform.shear(d, d1);
        try
        {
            writeTransform(new AffineTransform(1.0D, d1, d, 1.0D, 0.0D, 0.0D));
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected abstract void writeTransform(AffineTransform affinetransform)
        throws IOException;

    protected void writeSetTransform(AffineTransform affinetransform)
        throws IOException
    {
        try
        {
            AffineTransform affinetransform1 = new AffineTransform(affinetransform);
            affinetransform1.concatenate(oldTransform.createInverse());
            writeTransform(affinetransform1);
        }
        catch(NoninvertibleTransformException noninvertibletransformexception)
        {
            System.err.println("Warning: (ignored) Could not invert matrix: " + oldTransform);
        }
    }

    public Shape getClip()
    {
        return userClip == null ? null : new Area(untransformShape(userClip));
    }

    public Rectangle getClipBounds()
    {
        Shape shape = getClip();
        return shape == null ? null : getClip().getBounds();
    }

    public Rectangle getClipBounds(Rectangle rectangle)
    {
        Rectangle rectangle1 = getClipBounds();
        if(rectangle1 != null)
            rectangle.setBounds(rectangle1);
        return rectangle;
    }

    public void clipRect(int i, int j, int k, int l)
    {
        clip(new Rectangle(i, j, k, l));
    }

    public void clipRect(double d, double d1, double d2, double d3)
    {
        clip(new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3));
    }

    public void setClip(int i, int j, int k, int l)
    {
        setClip(((Shape) (new Rectangle(i, j, k, l))));
    }

    public void setClip(double d, double d1, double d2, double d3)
    {
        setClip(((Shape) (new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3))));
    }

    public void setClip(Shape shape)
    {
        Shape shape1 = transformShape(shape);
        userClip = shape1 == null ? null : new Area(shape1);
        try
        {
            writeSetClip(shape);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void clip(Shape shape)
    {
        Shape shape1 = transformShape(shape);
        if(userClip != null)
        {
            if(shape1 != null)
                userClip.intersect(new Area(shape1));
            else
                userClip = null;
        } else
        {
            userClip = shape1 == null ? null : new Area(shape1);
        }
        try
        {
            writeClip(shape);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected abstract void writeClip(Shape shape)
        throws IOException;

    protected abstract void writeSetClip(Shape shape)
        throws IOException;

    public Stroke getStroke()
    {
        return currentStroke;
    }

    public void setStroke(Stroke stroke)
    {
        if(stroke.equals(currentStroke))
            return;
        try
        {
            writeStroke(stroke);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
        currentStroke = stroke;
    }

    protected void writeStroke(Stroke stroke)
        throws IOException
    {
        if(stroke instanceof BasicStroke)
        {
            BasicStroke basicstroke = (BasicStroke)stroke;
            int i = -1;
            int j = -1;
            float f = -1F;
            float f1 = -1F;
            float f2 = -1F;
            float af[] = null;
            if(currentStroke != null && (currentStroke instanceof BasicStroke))
            {
                BasicStroke basicstroke1 = (BasicStroke)currentStroke;
                i = basicstroke1.getEndCap();
                j = basicstroke1.getLineJoin();
                f = basicstroke1.getLineWidth();
                f1 = basicstroke1.getMiterLimit();
                af = basicstroke1.getDashArray();
                f2 = basicstroke1.getDashPhase();
            }
            float f3 = basicstroke.getLineWidth();
            if(f != f3)
                writeWidth(f3);
            int k = basicstroke.getEndCap();
            if(i != k)
                writeCap(k);
            int l = basicstroke.getLineJoin();
            if(j != l)
                writeJoin(l);
            float f4 = basicstroke.getMiterLimit();
            if(f1 != f4 && f4 >= 1.0F)
                writeMiterLimit(f4);
            if(!Arrays.equals(af, basicstroke.getDashArray()) || f2 != basicstroke.getDashPhase())
                if(basicstroke.getDashArray() != null)
                    writeDash(basicstroke.getDashArray(), basicstroke.getDashPhase());
                else
                    writeDash(new float[0], basicstroke.getDashPhase());
        }
    }

    protected void writeWidth(float f)
        throws IOException
    {
        writeWarning(getClass() + ": writeWidth() not implemented.");
    }

    protected void writeCap(int i)
        throws IOException
    {
        writeWarning(getClass() + ": writeCap() not implemented.");
    }

    protected void writeJoin(int i)
        throws IOException
    {
        writeWarning(getClass() + ": writeJoin() not implemented.");
    }

    protected void writeMiterLimit(float f)
        throws IOException
    {
        writeWarning(getClass() + ": writeMiterLimit() not implemented.");
    }

    protected void writeDash(float af[], float f)
        throws IOException
    {
        double ad[] = new double[af.length];
        for(int i = 0; i < af.length; i++)
            ad[i] = af[i];

        writeDash(ad, f);
    }

    protected void writeDash(double ad[], double d)
        throws IOException
    {
        writeWarning(getClass() + ": writeDash() not implemented.");
    }

    public void setColor(Color color)
    {
        if(color == null)
            return;
        if(color.equals(getColor()))
            return;
        try
        {
            super.setColor(color);
            writePaint(getPrintColor(color));
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    public void setPaint(Paint paint)
    {
        if(paint == null)
            return;
        if(paint.equals(getPaint()))
            return;
        try
        {
            if(paint instanceof Color)
                setColor((Color)paint);
            else
            if(paint instanceof GradientPaint)
            {
                super.setPaint(paint);
                writePaint((GradientPaint)paint);
            } else
            if(paint instanceof TexturePaint)
            {
                super.setPaint(paint);
                writePaint((TexturePaint)paint);
            } else
            {
                super.setPaint(paint);
                writePaint(paint);
            }
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected abstract void writePaint(Color color)
        throws IOException;

    protected abstract void writePaint(GradientPaint gradientpaint)
        throws IOException;

    protected abstract void writePaint(TexturePaint texturepaint)
        throws IOException;

    protected abstract void writePaint(Paint paint)
        throws IOException;

    public FontRenderContext getFontRenderContext()
    {
        return new FontRenderContext(new AffineTransform(1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F), true, true);
    }

    public FontMetrics getFontMetrics(Font font)
    {
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }

    public RenderingHints getRenderingHints()
    {
        return (RenderingHints)hints.clone();
    }

    public void addRenderingHints(Map map)
    {
        map.putAll(map);
    }

    public void setRenderingHints(Map map)
    {
        map.clear();
        map.putAll(map);
    }

    public Object getRenderingHint(java.awt.RenderingHints.Key key)
    {
        return hints.get(key);
    }

    public void setRenderingHint(java.awt.RenderingHints.Key key, Object obj)
    {
        if(key == null || obj == null)
        {
            return;
        } else
        {
            hints.put(key, obj);
            return;
        }
    }

    public void setFont(Font font)
    {
        if(font == null)
            return;
        super.setFont(font);
        try
        {
            writeFont(font);
        }
        catch(IOException ioexception)
        {
            handleException(ioexception);
        }
    }

    protected abstract void writeFont(Font font)
        throws IOException;

    public Composite getComposite()
    {
        return currentComposite;
    }

    public void setComposite(Composite composite)
    {
        currentComposite = composite;
    }

    protected void handleException(Exception exception)
    {
        if(exception instanceof UnsupportedOperationException)
            writeWarning(exception);
        else
            writeError(exception);
    }

    protected void writeWarning(Exception exception)
    {
        writeWarning(exception.getMessage());
    }

    protected void writeWarning(String s)
    {
        if(isProperty(EMIT_WARNINGS))
            System.err.println(s);
    }

    protected void writeError(Exception exception)
    {
        throw new RuntimeException(exception);
    }

    protected Shape createShape(double ad[], double ad1[], int i, boolean flag)
    {
        GeneralPath generalpath = new GeneralPath(0);
        if(i > 0)
        {
            generalpath.moveTo((float)ad[0], (float)ad1[0]);
            for(int j = 1; j < i; j++)
                generalpath.lineTo((float)ad[j], (float)ad1[j]);

            if(flag)
                generalpath.closePath();
        }
        return generalpath;
    }

    private Shape transformShape(AffineTransform affinetransform, Shape shape)
    {
        if(shape == null)
            return null;
        else
            return affinetransform.createTransformedShape(shape);
    }

    private Shape transformShape(Shape shape)
    {
        return transformShape(getTransform(), shape);
    }

    private Shape untransformShape(Shape shape)
    {
        if(shape == null)
            return null;
        return transformShape(getTransform().createInverse(), shape);
        NoninvertibleTransformException noninvertibletransformexception;
        noninvertibletransformexception;
        return null;
    }

    protected void overLine(String s, Font font, float f, float f1)
    {
        TextLayout textlayout = new TextLayout(s, font, getFontRenderContext());
        float f2 = Math.max(textlayout.getAdvance(), (float)textlayout.getBounds().getWidth());
        GeneralPath generalpath = new GeneralPath();
        generalpath.moveTo(f, (f1 + (float)textlayout.getBounds().getY()) - textlayout.getAscent());
        generalpath.lineTo(f + f2, (f1 + (float)textlayout.getBounds().getY()) - textlayout.getAscent() - textlayout.getAscent());
        draw(generalpath);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw (new NoClassDefFoundError()).initCause(classnotfoundexception);
    }

    private static final String rootKey;
    public static final String EMIT_WARNINGS;
    public static final String TEXT_AS_SHAPES;
    public static final String EMIT_ERRORS;
    public static final String CLIP;
    private Dimension size;
    private Component component;
    private boolean doRestoreOnDispose;
    private Rectangle deviceClip;
    private Area userClip;
    private AffineTransform currentTransform;
    private AffineTransform oldTransform;
    private Composite currentComposite;
    private Stroke currentStroke;
    private RenderingHints hints;

    static 
    {
        rootKey = (org.freehep.graphicsio.AbstractVectorGraphicsIO.class).getName();
        EMIT_WARNINGS = rootKey + ".EMIT_WARNINGS";
        TEXT_AS_SHAPES = rootKey + "." + "TEXT_AS_SHAPES";
        EMIT_ERRORS = rootKey + ".EMIT_ERRORS";
        CLIP = rootKey + ".CLIP";
    }
}
