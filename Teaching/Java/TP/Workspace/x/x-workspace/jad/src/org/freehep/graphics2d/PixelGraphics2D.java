// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.awt.image.renderable.RenderableImage;
import java.awt.print.PrinterGraphics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;
import org.freehep.graphics2d.font.FontEncoder;

// Referenced classes of package org.freehep.graphics2d:
//            AbstractVectorGraphics, GenericTagHandler, WebColor, VectorGraphics, 
//            ArrayPath

public class PixelGraphics2D extends AbstractVectorGraphics
{
    static class SymbolBlitKey extends java.awt.RenderingHints.Key
    {

        public boolean isCompatibleValue(Object obj)
        {
            if(obj.equals(PixelGraphics2D.VALUE_SYMBOL_BLIT_ON))
                return true;
            return obj.equals(PixelGraphics2D.VALUE_SYMBOL_BLIT_OFF);
        }

        public String toString()
        {
            return "Symbol Blitting enable key";
        }

        public SymbolBlitKey()
        {
            super(0x16f49);
        }
    }


    public PixelGraphics2D(Graphics g)
    {
        this();
        setHostGraphics(g);
    }

    protected PixelGraphics2D(PixelGraphics2D pixelgraphics2d)
    {
        super(pixelgraphics2d);
        setHostGraphics(pixelgraphics2d.hostGraphics.create());
    }

    protected PixelGraphics2D()
    {
    }

    protected void setHostGraphics(Graphics g)
    {
        hostGraphics = (Graphics2D)g;
        resolution = (g instanceof PrinterGraphics) ? 0 : 1;
        tagHandler = new GenericTagHandler(hostGraphics);
        super.setBackground(hostGraphics.getBackground());
        super.setColor(hostGraphics.getColor());
        super.setPaint(hostGraphics.getPaint());
        super.setFont(hostGraphics.getFont());
        Stroke stroke = hostGraphics.getStroke();
        if(stroke instanceof BasicStroke)
            lineWidth = ((BasicStroke)stroke).getLineWidth();
        webColor = WebColor.create(getColor());
        setRenderingHint(KEY_SYMBOL_BLIT, VALUE_SYMBOL_BLIT_ON);
    }

    public void startExport()
    {
    }

    public void endExport()
    {
    }

    public void printComment(String s)
    {
    }

    public Graphics create(double d, double d1, double d2, double d3)
    {
        PixelGraphics2D pixelgraphics2d = new PixelGraphics2D(this);
        pixelgraphics2d.translate(d, d1);
        pixelgraphics2d.clipRect(0.0D, 0.0D, d2, d3);
        return pixelgraphics2d;
    }

    public void clearRect(int i, int j, int k, int l)
    {
        hostGraphics.clearRect(i, j, k, l);
    }

    public void clipRect(int i, int j, int k, int l)
    {
        hostGraphics.clipRect(i, j, k, l);
    }

    public void copyArea(int i, int j, int k, int l, int i1, int j1)
    {
        hostGraphics.copyArea(i, j, k, l, i1, j1);
    }

    public Graphics create()
    {
        return new PixelGraphics2D(this);
    }

    public void dispose()
    {
        hostGraphics.dispose();
    }

    public void drawArc(int i, int j, int k, int l, int i1, int j1)
    {
        hostGraphics.drawArc(i, j, k, l, i1, j1);
    }

    public boolean drawImage(Image image, int i, int j, Color color, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, getPrintColor(color), imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, Color color, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, k, l, getPrintColor(color), imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, k, l, imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, Color color, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, k, l, i1, j1, k1, l1, getPrintColor(color), imageobserver);
    }

    public boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, i, j, k, l, i1, j1, k1, l1, imageobserver);
    }

    public void drawLine(int i, int j, int k, int l)
    {
        hostGraphics.drawLine(i, j, k, l);
    }

    public void drawOval(int i, int j, int k, int l)
    {
        hostGraphics.drawOval(i, j, k, l);
    }

    public void drawPolygon(int ai[], int ai1[], int i)
    {
        hostGraphics.drawPolygon(ai, ai1, i);
    }

    public void drawPolygon(Polygon polygon)
    {
        hostGraphics.drawPolygon(polygon);
    }

    public void drawPolyline(int ai[], int ai1[], int i)
    {
        hostGraphics.drawPolyline(ai, ai1, i);
    }

    public void drawRect(int i, int j, int k, int l)
    {
        hostGraphics.drawRect(i, j, k, l);
    }

    public void drawString(String s, int i, int j)
    {
        s = FontEncoder.getEncodedString(s, getFont().getName());
        hostGraphics.drawString(s, i, j);
    }

    public void fillArc(int i, int j, int k, int l, int i1, int j1)
    {
        hostGraphics.fillArc(i, j, k, l, i1, j1);
    }

    public void fillOval(int i, int j, int k, int l)
    {
        hostGraphics.fillOval(i, j, k, l);
    }

    public void fillPolygon(int ai[], int ai1[], int i)
    {
        hostGraphics.fillPolygon(ai, ai1, i);
    }

    public void fillPolygon(Polygon polygon)
    {
        hostGraphics.fillPolygon(polygon);
    }

    public void fillRect(int i, int j, int k, int l)
    {
        hostGraphics.fillRect(i, j, k, l);
    }

    public void drawSymbol(double d, double d1, double d2, int i)
    {
        if(d2 <= 0.0D)
            return;
        int j = (int)Math.ceil(d2);
        if(j > 32 || lineWidth != 1.0D || !isDisplayLocal() || getRenderingHint(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON || getRenderingHint(KEY_SYMBOL_BLIT) == VALUE_SYMBOL_BLIT_OFF)
        {
            super.drawSymbol(d, d1, d2, i);
            return;
        } else
        {
            blitSymbol(d, d1, j, i, false);
            return;
        }
    }

    public void fillSymbol(double d, double d1, double d2, int i)
    {
        if(d2 <= 0.0D)
            return;
        int j = (int)Math.ceil(d2);
        if(j > 32 || lineWidth != 1.0D || !isDisplayLocal() || getRenderingHint(RenderingHints.KEY_ANTIALIASING) == RenderingHints.VALUE_ANTIALIAS_ON || getRenderingHint(KEY_SYMBOL_BLIT) == VALUE_SYMBOL_BLIT_OFF)
        {
            super.fillSymbol(d, d1, d2, i);
            return;
        } else
        {
            blitSymbol(d, d1, j, i, true);
            return;
        }
    }

    public void fillAndDrawSymbol(double d, double d1, double d2, int i, 
            Color color)
    {
        Color color1 = getColor();
        setColor(color);
        super.fillSymbol(d, d1, d2, i);
        setColor(color1);
        super.drawSymbol(d, d1, d2, i);
    }

    private void blitSymbol(double d, double d1, int i, int j, boolean flag)
    {
        Image aimage[][][] = (Image[][][])(Image[][][])symbols.get(webColor);
        if(aimage == null)
        {
            aimage = new Image[2][10][32];
            symbols.put(webColor, aimage);
        }
        Object obj = aimage[flag ? 1 : 0][j][i - 1];
        int k = i + 1;
        double d2 = (double)k / 2D;
        if(obj == null)
        {
            obj = getDeviceConfiguration().createCompatibleImage(k + 1, k + 1, 2);
            VectorGraphics vectorgraphics = VectorGraphics.create(((Image) (obj)).getGraphics());
            Composite composite = vectorgraphics.getComposite();
            vectorgraphics.setComposite(AlphaComposite.Clear);
            vectorgraphics.fillRect(0, 0, i, i);
            vectorgraphics.setComposite(composite);
            vectorgraphics.setColor(getColor());
            if(flag)
                fillSymbol(vectorgraphics, d2, d2, i, j);
            else
                drawSymbol(vectorgraphics, d2, d2, i, j);
            aimage[flag ? 1 : 0][j][i - 1] = ((Image) (obj));
        }
        drawImage(((Image) (obj)), (int)(d - d2), (int)(d1 - d2), ((ImageObserver) (null)));
    }

    public void setLineWidth(double d)
    {
        super.setLineWidth(d);
        lineWidth = d;
    }

    public Shape getClip()
    {
        return hostGraphics.getClip();
    }

    public Rectangle getClipBounds()
    {
        return hostGraphics.getClipBounds();
    }

    public Rectangle getClipBounds(Rectangle rectangle)
    {
        return hostGraphics.getClipBounds(rectangle);
    }

    public FontMetrics getFontMetrics(Font font)
    {
        return hostGraphics.getFontMetrics(font);
    }

    public void setClip(int i, int j, int k, int l)
    {
        hostGraphics.setClip(i, j, k, l);
    }

    public void setClip(Shape shape)
    {
        hostGraphics.setClip(shape);
    }

    public void setFont(Font font)
    {
        if(font == null)
            return;
        super.setFont(font);
        if(font.getName().equals("Symbol") || font.getName().equals("ZapfDingbats"))
        {
            Font font1 = new Font("Serif", font.getSize(), font.getStyle());
            font = font1.deriveFont(font.getSize2D());
        }
        hostGraphics.setFont(font);
    }

    public void setColor(Color color)
    {
        if(color == null)
            return;
        if(color.equals(getColor()))
        {
            return;
        } else
        {
            super.setColor(color);
            hostGraphics.setColor(getPrintColor(color));
            webColor = WebColor.create(color);
            return;
        }
    }

    public void setPaint(Paint paint)
    {
        if(paint == null)
            return;
        if(paint.equals(getPaint()))
            return;
        if(paint instanceof Color)
        {
            setColor((Color)paint);
        } else
        {
            super.setPaint(paint);
            hostGraphics.setPaint(paint);
        }
    }

    public void setPaintMode()
    {
        hostGraphics.setPaintMode();
    }

    public void setXORMode(Color color)
    {
        hostGraphics.setXORMode(getPrintColor(color));
    }

    public void translate(int i, int j)
    {
        hostGraphics.translate(i, j);
    }

    public void addRenderingHints(Map map)
    {
        hostGraphics.addRenderingHints(map);
    }

    public void clip(Shape shape)
    {
        hostGraphics.clip(shape);
    }

    public void draw(Shape shape)
    {
        hostGraphics.draw(shape);
    }

    public void drawGlyphVector(GlyphVector glyphvector, float f, float f1)
    {
        hostGraphics.drawGlyphVector(glyphvector, f, f1);
    }

    public void drawImage(BufferedImage bufferedimage, BufferedImageOp bufferedimageop, int i, int j)
    {
        hostGraphics.drawImage(bufferedimage, bufferedimageop, i, j);
    }

    public boolean drawImage(Image image, AffineTransform affinetransform, ImageObserver imageobserver)
    {
        return hostGraphics.drawImage(image, affinetransform, imageobserver);
    }

    public void drawRenderableImage(RenderableImage renderableimage, AffineTransform affinetransform)
    {
        hostGraphics.drawRenderableImage(renderableimage, affinetransform);
    }

    public void drawRenderedImage(RenderedImage renderedimage, AffineTransform affinetransform)
    {
        hostGraphics.drawRenderedImage(renderedimage, affinetransform);
    }

    public void drawString(AttributedCharacterIterator attributedcharacteriterator, float f, float f1)
    {
        hostGraphics.drawString(attributedcharacteriterator, f, f1);
    }

    public void drawString(AttributedCharacterIterator attributedcharacteriterator, int i, int j)
    {
        hostGraphics.drawString(attributedcharacteriterator, i, j);
    }

    public void drawString(String s, float f, float f1)
    {
        s = FontEncoder.getEncodedString(s, getFont().getName());
        hostGraphics.drawString(s, f, f1);
    }

    public void fill(Shape shape)
    {
        hostGraphics.fill(shape);
    }

    public Composite getComposite()
    {
        return hostGraphics.getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration()
    {
        return hostGraphics.getDeviceConfiguration();
    }

    public FontRenderContext getFontRenderContext()
    {
        return hostGraphics.getFontRenderContext();
    }

    public Object getRenderingHint(java.awt.RenderingHints.Key key)
    {
        return hostGraphics.getRenderingHint(key);
    }

    public RenderingHints getRenderingHints()
    {
        return hostGraphics.getRenderingHints();
    }

    public Stroke getStroke()
    {
        return hostGraphics.getStroke();
    }

    public AffineTransform getTransform()
    {
        return hostGraphics.getTransform();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean flag)
    {
        return hostGraphics.hit(rectangle, shape, flag);
    }

    public void rotate(double d)
    {
        hostGraphics.rotate(d);
    }

    public void rotate(double d, double d1, double d2)
    {
        hostGraphics.rotate(d, d1, d2);
    }

    public void scale(double d, double d1)
    {
        hostGraphics.scale(d, d1);
    }

    public void setBackground(Color color)
    {
        super.setBackground(color);
        hostGraphics.setBackground(getPrintColor(color));
    }

    public void setComposite(Composite composite)
    {
        hostGraphics.setComposite(composite);
    }

    public void setRenderingHint(java.awt.RenderingHints.Key key, Object obj)
    {
        hostGraphics.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map map)
    {
        hostGraphics.setRenderingHints(map);
    }

    public void setStroke(Stroke stroke)
    {
        hostGraphics.setStroke(stroke);
    }

    public void setTransform(AffineTransform affinetransform)
    {
        hostGraphics.setTransform(affinetransform);
    }

    public void shear(double d, double d1)
    {
        hostGraphics.shear(d, d1);
    }

    public void transform(AffineTransform affinetransform)
    {
        hostGraphics.transform(affinetransform);
    }

    public void translate(double d, double d1)
    {
        hostGraphics.translate(d, d1);
    }

    public void clearRect(double d, double d1, double d2, double d3)
    {
        clearRect((int)d, (int)d1, (int)d2, (int)d3);
    }

    public void clipRect(double d, double d1, double d2, double d3)
    {
        clipRect((int)d, (int)d1, (int)d2, (int)d3);
    }

    public void drawString(String s, double d, double d1)
    {
        drawString(s, (int)Math.round(d), (int)Math.round(d1));
    }

    public void setClip(double d, double d1, double d2, double d3)
    {
        setClip(((Shape) (new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3))));
    }

    public String toString()
    {
        return "PixelGraphics2D[" + hostGraphics.toString() + "]";
    }

    public static boolean isDisplayX11()
    {
        return displayX11;
    }

    public static boolean isDisplayLocal()
    {
        return displayLocal;
    }

    protected Shape createShape(double ad[], double ad1[], int i, boolean flag)
    {
        return new ArrayPath(ad, ad1, i, flag, resolution);
    }

    public static final java.awt.RenderingHints.Key KEY_SYMBOL_BLIT = new SymbolBlitKey();
    public static final Object VALUE_SYMBOL_BLIT_ON;
    public static final Object VALUE_SYMBOL_BLIT_OFF;
    protected Graphics2D hostGraphics;
    protected double lineWidth;
    protected int resolution;
    protected GenericTagHandler tagHandler;
    private static final int MAX_BLIT_SIZE = 32;
    private static Map symbols = new HashMap();
    private WebColor webColor;
    private static boolean displayX11 = false;
    private static boolean displayLocal = false;

    static 
    {
        VALUE_SYMBOL_BLIT_ON = Boolean.TRUE;
        VALUE_SYMBOL_BLIT_OFF = Boolean.FALSE;
        try
        {
            Class class1 = Class.forName("sun.awt.X11GraphicsEnvironment");
            displayX11 = true;
            Method method = class1.getMethod("isDisplayLocal", null);
            Boolean boolean1 = (Boolean)method.invoke(null, null);
            displayLocal = boolean1.booleanValue();
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            displayLocal = true;
        }
        catch(IllegalAccessException illegalaccessexception) { }
        catch(NoSuchMethodException nosuchmethodexception) { }
        catch(InvocationTargetException invocationtargetexception) { }
        catch(ClassCastException classcastexception) { }
        catch(SecurityException securityexception) { }
    }
}
