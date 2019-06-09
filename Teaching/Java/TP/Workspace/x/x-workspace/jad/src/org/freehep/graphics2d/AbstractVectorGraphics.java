// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.*;
import java.text.AttributedCharacterIterator;
import java.util.Properties;
import org.freehep.graphics2d.font.FontUtilities;
import org.freehep.util.UserProperties;

// Referenced classes of package org.freehep.graphics2d:
//            VectorGraphics, SymbolShape, GenericTagHandler, PrintColor, 
//            TagString

public abstract class AbstractVectorGraphics extends VectorGraphics
{

    public AbstractVectorGraphics()
    {
        properties = new UserProperties();
        creator = "FreeHEP Graphics2D Driver";
        isDeviceIndependent = false;
        cachedShape = new SymbolShape();
        colorMode = 0;
        currentFont = null;
        backgroundColor = null;
        currentColor = null;
        currentPaint = null;
    }

    protected AbstractVectorGraphics(AbstractVectorGraphics abstractvectorgraphics)
    {
        properties = abstractvectorgraphics.properties;
        creator = abstractvectorgraphics.creator;
        isDeviceIndependent = abstractvectorgraphics.isDeviceIndependent;
        cachedShape = abstractvectorgraphics.cachedShape;
        backgroundColor = abstractvectorgraphics.backgroundColor;
        currentColor = abstractvectorgraphics.currentColor;
        currentPaint = abstractvectorgraphics.currentPaint;
        colorMode = abstractvectorgraphics.colorMode;
        currentFont = abstractvectorgraphics.currentFont;
    }

    public void setProperties(Properties properties1)
    {
        if(properties1 == null)
        {
            return;
        } else
        {
            properties.setProperties(properties1);
            return;
        }
    }

    protected void initProperties(Properties properties1)
    {
        properties = new UserProperties();
        properties.setProperties(properties1);
    }

    protected Properties getProperties()
    {
        return properties;
    }

    public String getProperty(String s)
    {
        return properties.getProperty(s);
    }

    public Color getPropertyColor(String s)
    {
        return properties.getPropertyColor(s);
    }

    public Rectangle getPropertyRectangle(String s)
    {
        return properties.getPropertyRectangle(s);
    }

    public Insets getPropertyInsets(String s)
    {
        return properties.getPropertyInsets(s);
    }

    public Dimension getPropertyDimension(String s)
    {
        return properties.getPropertyDimension(s);
    }

    public int getPropertyInt(String s)
    {
        return properties.getPropertyInt(s);
    }

    public double getPropertyDouble(String s)
    {
        return properties.getPropertyDouble(s);
    }

    public boolean isProperty(String s)
    {
        return properties.isProperty(s);
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String s)
    {
        if(s != null)
            creator = s;
    }

    public boolean isDeviceIndependent()
    {
        return isDeviceIndependent;
    }

    public void setDeviceIndependent(boolean flag)
    {
        isDeviceIndependent = flag;
    }

    public Font getFont()
    {
        return currentFont;
    }

    public void setFont(Font font)
    {
        if(font == null)
        {
            return;
        } else
        {
            currentFont = font;
            return;
        }
    }

    public void drawSymbol(int i, int j, int k, int l)
    {
        drawSymbol(i, j, k, l);
    }

    public void fillSymbol(int i, int j, int k, int l)
    {
        fillSymbol(i, j, k, l);
    }

    public void fillAndDrawSymbol(int i, int j, int k, int l, Color color)
    {
        fillAndDrawSymbol(i, j, k, l, color);
    }

    public void drawSymbol(double d, double d1, double d2, int i)
    {
        if(d2 <= 0.0D)
        {
            return;
        } else
        {
            drawSymbol(((VectorGraphics) (this)), d, d1, d2, i);
            return;
        }
    }

    protected void drawSymbol(VectorGraphics vectorgraphics, double d, double d1, double d2, 
            int i)
    {
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            cachedShape.create(i, d, d1, d2);
            vectorgraphics.draw(cachedShape);
            break;

        case 5: // '\005'
            double d3 = Math.max(1.0D, d2);
            d3 += d3 % 2D;
            vectorgraphics.drawOval(d - d3 / 2D, d1 - d3 / 2D, d3, d3);
            break;
        }
    }

    public void fillSymbol(double d, double d1, double d2, int i)
    {
        if(d2 <= 0.0D)
        {
            return;
        } else
        {
            fillSymbol(((VectorGraphics) (this)), d, d1, d2, i);
            return;
        }
    }

    protected void fillSymbol(VectorGraphics vectorgraphics, double d, double d1, double d2, 
            int i)
    {
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            cachedShape.create(i, d, d1, d2);
            vectorgraphics.draw(cachedShape);
            break;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            cachedShape.create(i, d, d1, d2);
            vectorgraphics.fill(cachedShape);
            break;

        case 5: // '\005'
            double d3 = Math.max(1.0D, d2);
            d3 += d3 % 2D;
            vectorgraphics.fillOval(d - d3 / 2D, d1 - d3 / 2D, d3, d3);
            break;
        }
    }

    public void fillAndDrawSymbol(double d, double d1, double d2, int i, 
            Color color)
    {
        Color color1 = getColor();
        setColor(color);
        fillSymbol(d, d1, d2, i);
        setColor(color1);
        drawSymbol(d, d1, d2, i);
    }

    public void fillAndDraw(Shape shape, Color color)
    {
        Color color1 = getColor();
        setColor(color);
        fill(shape);
        setColor(color1);
        draw(shape);
    }

    public void clearRect(int i, int j, int k, int l)
    {
        clearRect((double)i + 0.5D, (double)j + 0.5D, k, l);
    }

    public void drawLine(int i, int j, int k, int l)
    {
        drawLine((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, (double)l + 0.5D);
    }

    public void drawRect(int i, int j, int k, int l)
    {
        drawRect((double)i + 0.5D, (double)j + 0.5D, k, l);
    }

    public void fillRect(int i, int j, int k, int l)
    {
        fillRect(i, j, k, l);
    }

    public void drawArc(int i, int j, int k, int l, int i1, int j1)
    {
        drawArc((double)i + 0.5D, (double)j + 0.5D, k, l, i1, j1);
    }

    public void fillArc(int i, int j, int k, int l, int i1, int j1)
    {
        fillArc(i, j, k, l, i1, j1);
    }

    public void drawOval(int i, int j, int k, int l)
    {
        drawOval((double)i + 0.5D, (double)j + 0.5D, k, l);
    }

    public void fillOval(int i, int j, int k, int l)
    {
        fillOval(i, j, k, l);
    }

    public void drawRoundRect(int i, int j, int k, int l, int i1, int j1)
    {
        drawRoundRect((double)i + 0.5D, (double)j + 0.5D, k, l, i1, j1);
    }

    public void fillRoundRect(int i, int j, int k, int l, int i1, int j1)
    {
        fillRoundRect(i, j, k, l, i1, j1);
    }

    public void translate(int i, int j)
    {
        translate(i, j);
    }

    public void setLineWidth(int i)
    {
        setLineWidth(i);
    }

    public void setLineWidth(double d)
    {
        Stroke stroke = getStroke();
        if(stroke instanceof BasicStroke)
        {
            BasicStroke basicstroke2 = (BasicStroke)stroke;
            if((double)basicstroke2.getLineWidth() != d)
            {
                BasicStroke basicstroke = new BasicStroke((float)d, basicstroke2.getEndCap(), basicstroke2.getLineJoin(), basicstroke2.getMiterLimit(), basicstroke2.getDashArray(), basicstroke2.getDashPhase());
                setStroke(basicstroke);
            }
        } else
        {
            BasicStroke basicstroke1 = new BasicStroke((float)d);
            setStroke(basicstroke1);
        }
    }

    public void drawString(String s, int i, int j)
    {
        drawString(s, i, j);
    }

    public void drawString(String s, float f, float f1)
    {
        drawString(s, f, f1);
    }

    public void drawString(AttributedCharacterIterator attributedcharacteriterator, int i, int j)
    {
        drawString(attributedcharacteriterator, i, j);
    }

    private Point2D drawFrameAndBanner(TextLayout textlayout, double d, double d1, int i, int j, 
            boolean flag, Color color, double d2, boolean flag1, Color color1)
    {
        Rectangle2D rectangle2d = textlayout.getBounds();
        rectangle2d.setRect(rectangle2d.getX(), rectangle2d.getY(), Math.max(textlayout.getAdvance(), rectangle2d.getWidth()), rectangle2d.getHeight());
        AffineTransform affinetransform = AffineTransform.getTranslateInstance(d, d1);
        if(i == 3)
            affinetransform.translate(-rectangle2d.getWidth(), 0.0D);
        else
        if(i == 2)
            affinetransform.translate(-rectangle2d.getWidth() / 2D, 0.0D);
        if(j != 0)
            if(j == 1)
                affinetransform.translate(0.0D, -rectangle2d.getY());
            else
            if(j == 2)
                affinetransform.translate(0.0D, textlayout.getDescent());
            else
            if(j == 3)
                affinetransform.translate(0.0D, -rectangle2d.getHeight() - rectangle2d.getY());
        rectangle2d = affinetransform.createTransformedShape(rectangle2d).getBounds2D();
        Point2D point2d = affinetransform.transform(new java.awt.geom.Point2D.Double(0.0D, 0.0D), new java.awt.geom.Point2D.Double());
        double d3 = (getFont().getSize2D() * 2.0F) / 10F;
        rectangle2d.setRect(rectangle2d.getX() - d3, rectangle2d.getY() - d3, rectangle2d.getWidth() + 2D * d3, rectangle2d.getHeight() + 2D * d3);
        if(flag1)
        {
            Paint paint = getPaint();
            setColor(color1);
            fill(rectangle2d);
            setPaint(paint);
        }
        if(flag)
        {
            Paint paint1 = getPaint();
            Stroke stroke = getStroke();
            setColor(color);
            setLineWidth(d2);
            draw(rectangle2d);
            setPaint(paint1);
            setStroke(stroke);
        }
        return point2d;
    }

    public void drawString(String s, double d, double d1, int i, int j, 
            boolean flag, Color color, double d2, boolean flag1, Color color1)
    {
        TextLayout textlayout = new TextLayout(s, FontUtilities.getAttributes(getFont()), getFontRenderContext());
        Point2D point2d = drawFrameAndBanner(textlayout, d, d1, i, j, flag, color, d2, flag1, color1);
        drawString(s, point2d.getX(), point2d.getY());
    }

    public void drawString(TagString tagstring, double d, double d1, int i, int j, 
            boolean flag, Color color, double d2, boolean flag1, Color color1)
    {
        GenericTagHandler generictaghandler = new GenericTagHandler(this);
        TextLayout textlayout = generictaghandler.createTextLayout(tagstring, (double)getFont().getSize2D() / 7.5D);
        Point2D point2d = drawFrameAndBanner(textlayout, d, d1, i, j, flag, color, d2, flag1, color1);
        generictaghandler.print(tagstring, point2d.getX(), point2d.getY(), (double)getFont().getSize2D() / 7.5D);
    }

    public void drawString(String s, double d, double d1, int i, int j)
    {
        drawString(s, d, d1, i, j, false, null, 0.0D, false, null);
    }

    public void drawString(TagString tagstring, double d, double d1)
    {
        drawString(tagstring, d, d1, 1, 0);
    }

    public void drawString(TagString tagstring, double d, double d1, int i, int j)
    {
        drawString(tagstring, d, d1, i, j, false, null, 0.0D, false, null);
    }

    public int getColorMode()
    {
        return colorMode;
    }

    public void setColorMode(int i)
    {
        colorMode = i;
    }

    public Color getBackground()
    {
        return backgroundColor;
    }

    public void setBackground(Color color)
    {
        backgroundColor = color;
    }

    public void setColor(Color color)
    {
        if(color == null)
        {
            return;
        } else
        {
            currentColor = color;
            currentPaint = color;
            return;
        }
    }

    public Color getColor()
    {
        return currentColor;
    }

    public void setPaint(Paint paint)
    {
        if(paint == null)
            return;
        if(!(paint instanceof Color))
            currentColor = null;
        currentPaint = paint;
    }

    public Paint getPaint()
    {
        return currentPaint;
    }

    protected Color getPrintColor(Color color)
    {
        if(colorMode == 0)
        {
            return color;
        } else
        {
            PrintColor printcolor = PrintColor.createPrintColor(color);
            return printcolor.getColor(colorMode);
        }
    }

    public void rotate(double d, double d1, double d2)
    {
        translate(d1, d2);
        rotate(d);
        translate(-d1, -d2);
    }

    public void drawArc(double d, double d1, double d2, double d3, double d4, double d5)
    {
        draw(new java.awt.geom.Arc2D.Double(d, d1, d2, d3, d4, d5, 0));
    }

    public void drawLine(double d, double d1, double d2, double d3)
    {
        draw(new java.awt.geom.Line2D.Double(d, d1, d2, d3));
    }

    public void drawOval(double d, double d1, double d2, double d3)
    {
        draw(new java.awt.geom.Ellipse2D.Double(d, d1, d2, d3));
    }

    public void drawPolyline(int ai[], int ai1[], int i)
    {
        draw(createShape(ai, ai1, i, false, true));
    }

    public void drawPolyline(double ad[], double ad1[], int i)
    {
        draw(createShape(ad, ad1, i, false));
    }

    public void drawPolygon(int ai[], int ai1[], int i)
    {
        draw(createShape(ai, ai1, i, true, true));
    }

    public void drawPolygon(double ad[], double ad1[], int i)
    {
        draw(createShape(ad, ad1, i, true));
    }

    public void drawRect(double d, double d1, double d2, double d3)
    {
        draw(new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3));
    }

    public void drawRoundRect(double d, double d1, double d2, double d3, double d4, double d5)
    {
        draw(new java.awt.geom.RoundRectangle2D.Double(d, d1, d2, d3, d4, d5));
    }

    public void fillArc(double d, double d1, double d2, double d3, double d4, double d5)
    {
        fill(new java.awt.geom.Arc2D.Double(d, d1, d2, d3, d4, d5, 2));
    }

    public void fillOval(double d, double d1, double d2, double d3)
    {
        fill(new java.awt.geom.Ellipse2D.Double(d, d1, d2, d3));
    }

    public void fillPolygon(int ai[], int ai1[], int i)
    {
        fill(createShape(ai, ai1, i, true, false));
    }

    public void fillPolygon(double ad[], double ad1[], int i)
    {
        fill(createShape(ad, ad1, i, true));
    }

    public void fillRect(double d, double d1, double d2, double d3)
    {
        fill(new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3));
    }

    public void fillRoundRect(double d, double d1, double d2, double d3, double d4, double d5)
    {
        fill(new java.awt.geom.RoundRectangle2D.Double(d, d1, d2, d3, d4, d5));
    }

    protected abstract Shape createShape(double ad[], double ad1[], int i, boolean flag);

    protected Shape createShape(int ai[], int ai1[], int i, boolean flag, boolean flag1)
    {
        float f = flag1 ? 0.5F : 0.0F;
        GeneralPath generalpath = new GeneralPath(0);
        if(i > 0)
        {
            generalpath.moveTo((float)ai[0] + f, (float)ai1[0] + f);
            int j = ai[0];
            int k = ai1[0];
            if(flag && Math.abs(ai[i - 1] - j) < 1 && Math.abs(ai1[i - 1] - k) < 1)
                i--;
            for(int l = 1; l < i; l++)
                if(Math.abs(ai[l] - j) > 1 || Math.abs(ai1[l] - k) > 1)
                {
                    generalpath.lineTo((float)ai[l] + f, (float)ai1[l] + f);
                    j = ai[l];
                    k = ai1[l];
                }

            if(flag)
                generalpath.closePath();
        }
        return generalpath;
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean flag)
    {
        if(flag && getStroke() != null)
            shape = getStroke().createStrokedShape(shape);
        if(getTransform() != null)
            shape = getTransform().createTransformedShape(shape);
        Area area = new Area(shape);
        if(getClip() != null)
            area.intersect(new Area(getClip()));
        return area.intersects(rectangle);
    }

    private UserProperties properties;
    private String creator;
    private boolean isDeviceIndependent;
    private SymbolShape cachedShape;
    private int colorMode;
    private Color backgroundColor;
    private Color currentColor;
    private Paint currentPaint;
    private Font currentFont;
    private static final double bias = 0.5D;
}
