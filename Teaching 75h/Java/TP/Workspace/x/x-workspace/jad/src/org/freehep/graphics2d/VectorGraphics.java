// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.*;

// Referenced classes of package org.freehep.graphics2d:
//            VectorGraphicsConstants, PixelGraphics2D, TagString

public abstract class VectorGraphics extends Graphics2D
    implements VectorGraphicsConstants
{

    public VectorGraphics()
    {
    }

    public abstract void setProperties(Properties properties);

    protected abstract void initProperties(Properties properties);

    protected abstract Properties getProperties();

    public abstract String getProperty(String s);

    public abstract Color getPropertyColor(String s);

    public abstract Rectangle getPropertyRectangle(String s);

    public abstract Dimension getPropertyDimension(String s);

    public abstract int getPropertyInt(String s);

    public abstract double getPropertyDouble(String s);

    public abstract boolean isProperty(String s);

    public abstract void clearRect(int i, int j, int k, int l);

    public abstract void clipRect(int i, int j, int k, int l);

    public abstract void copyArea(int i, int j, int k, int l, int i1, int j1);

    public abstract Graphics create();

    public Graphics create(int i, int j, int k, int l)
    {
        return super.create(i, j, k, l);
    }

    public abstract void dispose();

    public abstract void drawArc(int i, int j, int k, int l, int i1, int j1);

    public abstract boolean drawImage(Image image, int i, int j, ImageObserver imageobserver);

    public abstract boolean drawImage(Image image, int i, int j, int k, int l, ImageObserver imageobserver);

    public abstract boolean drawImage(Image image, int i, int j, Color color, ImageObserver imageobserver);

    public abstract boolean drawImage(Image image, int i, int j, int k, int l, Color color, ImageObserver imageobserver);

    public abstract boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, ImageObserver imageobserver);

    public abstract boolean drawImage(Image image, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, Color color, ImageObserver imageobserver);

    public abstract void drawLine(int i, int j, int k, int l);

    public abstract void drawOval(int i, int j, int k, int l);

    public abstract void drawPolygon(int ai[], int ai1[], int i);

    public abstract void drawPolyline(int ai[], int ai1[], int i);

    public abstract void drawRect(int i, int j, int k, int l);

    public abstract void drawRoundRect(int i, int j, int k, int l, int i1, int j1);

    public abstract void drawString(AttributedCharacterIterator attributedcharacteriterator, int i, int j);

    public abstract void drawString(String s, int i, int j);

    public abstract void fillArc(int i, int j, int k, int l, int i1, int j1);

    public abstract void fillOval(int i, int j, int k, int l);

    public abstract void fillPolygon(int ai[], int ai1[], int i);

    public abstract void fillRect(int i, int j, int k, int l);

    public abstract void fillRoundRect(int i, int j, int k, int l, int i1, int j1);

    public abstract Shape getClip();

    public abstract Rectangle getClipBounds();

    public abstract Rectangle getClipBounds(Rectangle rectangle);

    public abstract Color getColor();

    public abstract Font getFont();

    public abstract FontMetrics getFontMetrics(Font font);

    public abstract void setClip(int i, int j, int k, int l);

    public abstract void setClip(Shape shape);

    public abstract void setColor(Color color);

    public abstract void setFont(Font font);

    public abstract void setPaintMode();

    public abstract void setXORMode(Color color);

    public abstract String toString();

    public abstract void translate(int i, int j);

    public abstract void addRenderingHints(Map map);

    public abstract void clip(Shape shape);

    public abstract void draw(Shape shape);

    public abstract void drawGlyphVector(GlyphVector glyphvector, float f, float f1);

    public abstract void drawImage(BufferedImage bufferedimage, BufferedImageOp bufferedimageop, int i, int j);

    public abstract boolean drawImage(Image image, AffineTransform affinetransform, ImageObserver imageobserver);

    public abstract void drawRenderableImage(RenderableImage renderableimage, AffineTransform affinetransform);

    public abstract void drawRenderedImage(RenderedImage renderedimage, AffineTransform affinetransform);

    public abstract void drawString(AttributedCharacterIterator attributedcharacteriterator, float f, float f1);

    public abstract void drawString(String s, float f, float f1);

    public abstract void fill(Shape shape);

    protected void fill(Shape shape, Paint paint)
    {
        Rectangle2D rectangle2d = shape.getBounds2D();
        BufferedImage bufferedimage = new BufferedImage((int)Math.ceil(rectangle2d.getWidth()) + 1, (int)Math.ceil(rectangle2d.getHeight()) + 1, 2);
        Graphics2D graphics2d = bufferedimage.createGraphics();
        graphics2d.setComposite(AlphaComposite.getInstance(1, 0.0F));
        graphics2d.fill(graphics2d.getDeviceConfiguration().getBounds());
        graphics2d.setComposite(AlphaComposite.SrcOver);
        graphics2d.setPaint(paint);
        graphics2d.translate(-rectangle2d.getMinX(), -rectangle2d.getMinY());
        graphics2d.fill(shape);
        graphics2d.dispose();
        Shape shape1 = getClip();
        clip(shape);
        drawImage(bufferedimage, (int)rectangle2d.getX(), (int)rectangle2d.getY(), ((ImageObserver) (null)));
        setClip(shape1);
    }

    public abstract Color getBackground();

    public abstract Composite getComposite();

    public abstract GraphicsConfiguration getDeviceConfiguration();

    public abstract FontRenderContext getFontRenderContext();

    public abstract Paint getPaint();

    public abstract Object getRenderingHint(java.awt.RenderingHints.Key key);

    public abstract RenderingHints getRenderingHints();

    public abstract Stroke getStroke();

    public abstract AffineTransform getTransform();

    public abstract boolean hit(Rectangle rectangle, Shape shape, boolean flag);

    public abstract void rotate(double d);

    public abstract void rotate(double d, double d1, double d2);

    public abstract void scale(double d, double d1);

    public abstract void setBackground(Color color);

    public abstract void setComposite(Composite composite);

    public abstract void setPaint(Paint paint);

    public abstract void setRenderingHint(java.awt.RenderingHints.Key key, Object obj);

    public abstract void setRenderingHints(Map map);

    public abstract void setStroke(Stroke stroke);

    public abstract void setTransform(AffineTransform affinetransform);

    public abstract void shear(double d, double d1);

    public abstract void transform(AffineTransform affinetransform);

    public abstract void translate(double d, double d1);

    public abstract void clearRect(double d, double d1, double d2, double d3);

    public abstract void clipRect(double d, double d1, double d2, double d3);

    public abstract Graphics create(double d, double d1, double d2, double d3);

    public abstract void drawArc(double d, double d1, double d2, double d3, double d4, double d5);

    public abstract void drawLine(double d, double d1, double d2, double d3);

    public abstract void drawOval(double d, double d1, double d2, double d3);

    public abstract void drawPolygon(double ad[], double ad1[], int i);

    public abstract void drawPolyline(double ad[], double ad1[], int i);

    public abstract void drawRect(double d, double d1, double d2, double d3);

    public abstract void drawRoundRect(double d, double d1, double d2, double d3, double d4, double d5);

    public abstract void drawSymbol(int i, int j, int k, int l);

    public abstract void drawSymbol(double d, double d1, double d2, int i);

    public abstract void fillSymbol(int i, int j, int k, int l);

    public abstract void fillSymbol(double d, double d1, double d2, int i);

    public abstract void fillAndDrawSymbol(int i, int j, int k, int l, Color color);

    public abstract void fillAndDrawSymbol(double d, double d1, double d2, int i, 
            Color color);

    public abstract void drawString(String s, double d, double d1);

    public abstract void drawString(TagString tagstring, double d, double d1);

    public abstract void drawString(String s, double d, double d1, int i, int j);

    public abstract void drawString(TagString tagstring, double d, double d1, int i, int j);

    public abstract void drawString(String s, double d, double d1, int i, int j, 
            boolean flag, Color color, double d2, boolean flag1, Color color1);

    public abstract void drawString(TagString tagstring, double d, double d1, int i, int j, 
            boolean flag, Color color, double d2, boolean flag1, Color color1);

    public abstract void endExport();

    public abstract void fillAndDraw(Shape shape, Color color);

    public abstract void fillArc(double d, double d1, double d2, double d3, double d4, double d5);

    public abstract void fillOval(double d, double d1, double d2, double d3);

    public abstract void fillPolygon(double ad[], double ad1[], int i);

    public abstract void fillRect(double d, double d1, double d2, double d3);

    public abstract void fillRoundRect(double d, double d1, double d2, double d3, double d4, double d5);

    public abstract int getColorMode();

    public abstract String getCreator();

    public abstract boolean isDeviceIndependent();

    public abstract void printComment(String s);

    public abstract void setClip(double d, double d1, double d2, double d3);

    public abstract void setColorMode(int i);

    public abstract void setCreator(String s);

    public abstract void setDeviceIndependent(boolean flag);

    public abstract void setLineWidth(int i);

    public abstract void setLineWidth(double d);

    public abstract void startExport();

    public static VectorGraphics create(Graphics g)
    {
        if(g != null && !(g instanceof VectorGraphics))
            return new PixelGraphics2D(g);
        else
            return (VectorGraphics)g;
    }

    public static int getTextAlignment(String s)
    {
        Integer integer = (Integer)alignments.get(s.toLowerCase());
        return integer == null ? 2 : integer.intValue();
    }

    public static int getSymbol(String s)
    {
        Integer integer = (Integer)symbols.get(s.toLowerCase());
        return integer == null ? 2 : integer.intValue();
    }

    public static double getYalignment(double d, double d1, double d2, int i)
    {
        switch(i)
        {
        case 1: // '\001'
            d = (d + d1) - d2;
            break;

        case 2: // '\002'
            d = (d + (d1 + d2) / 2D) - d2;
            break;

        case 3: // '\003'
            d -= d2;
            break;
        }
        return d;
    }

    public static double getXalignment(double d, double d1, int i)
    {
        switch(i)
        {
        case 2: // '\002'
            d -= d1 / 2D;
            break;

        case 3: // '\003'
            d -= d1;
            break;
        }
        return d;
    }

    private static Hashtable symbols;
    private static Hashtable alignments;

    static 
    {
        symbols = new Hashtable(15);
        symbols.put("vline", new Integer(0));
        symbols.put("hline", new Integer(1));
        symbols.put("plus", new Integer(2));
        symbols.put("cross", new Integer(3));
        symbols.put("star", new Integer(4));
        symbols.put("circle", new Integer(5));
        symbols.put("box", new Integer(6));
        symbols.put("up_triangle", new Integer(7));
        symbols.put("dn_triangle", new Integer(8));
        symbols.put("diamond", new Integer(9));
        alignments = new Hashtable(6);
        alignments.put("baseline", new Integer(0));
        alignments.put("left", new Integer(1));
        alignments.put("top", new Integer(1));
        alignments.put("middle", new Integer(2));
        alignments.put("center", new Integer(2));
        alignments.put("right", new Integer(3));
        alignments.put("bottom", new Integer(3));
    }
}
