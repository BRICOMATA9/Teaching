// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Reader;
import org.apache.batik.ext.awt.geom.ExtendedGeneralPath;

// Referenced classes of package org.apache.batik.parser:
//            PathHandler, ShapeProducer, ParseException, PathParser

public class AWTPathProducer
    implements PathHandler, ShapeProducer
{

    public AWTPathProducer()
    {
    }

    public static Shape createShape(Reader reader, int i)
        throws IOException, ParseException
    {
        PathParser pathparser = new PathParser();
        AWTPathProducer awtpathproducer = new AWTPathProducer();
        awtpathproducer.setWindingRule(i);
        pathparser.setPathHandler(awtpathproducer);
        pathparser.parse(reader);
        return awtpathproducer.getShape();
    }

    public void setWindingRule(int i)
    {
        windingRule = i;
    }

    public int getWindingRule()
    {
        return windingRule;
    }

    public Shape getShape()
    {
        return path;
    }

    public void startPath()
        throws ParseException
    {
        currentX = 0.0F;
        currentY = 0.0F;
        xCenter = 0.0F;
        yCenter = 0.0F;
        path = new ExtendedGeneralPath(windingRule);
    }

    public void endPath()
        throws ParseException
    {
    }

    public void movetoRel(float f, float f1)
        throws ParseException
    {
        path.moveTo(xCenter = currentX += f, yCenter = currentY += f1);
    }

    public void movetoAbs(float f, float f1)
        throws ParseException
    {
        path.moveTo(xCenter = currentX = f, yCenter = currentY = f1);
    }

    public void closePath()
        throws ParseException
    {
        path.closePath();
        Point2D point2d = path.getCurrentPoint();
        currentX = (float)point2d.getX();
        currentY = (float)point2d.getY();
    }

    public void linetoRel(float f, float f1)
        throws ParseException
    {
        path.lineTo(xCenter = currentX += f, yCenter = currentY += f1);
    }

    public void linetoAbs(float f, float f1)
        throws ParseException
    {
        path.lineTo(xCenter = currentX = f, yCenter = currentY = f1);
    }

    public void linetoHorizontalRel(float f)
        throws ParseException
    {
        path.lineTo(xCenter = currentX += f, yCenter = currentY);
    }

    public void linetoHorizontalAbs(float f)
        throws ParseException
    {
        path.lineTo(xCenter = currentX = f, yCenter = currentY);
    }

    public void linetoVerticalRel(float f)
        throws ParseException
    {
        path.lineTo(xCenter = currentX, yCenter = currentY += f);
    }

    public void linetoVerticalAbs(float f)
        throws ParseException
    {
        path.lineTo(xCenter = currentX, yCenter = currentY = f);
    }

    public void curvetoCubicRel(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
        path.curveTo(currentX + f, currentY + f1, xCenter = currentX + f2, yCenter = currentY + f3, currentX += f4, currentY += f5);
    }

    public void curvetoCubicAbs(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
        path.curveTo(f, f1, xCenter = f2, yCenter = f3, currentX = f4, currentY = f5);
    }

    public void curvetoCubicSmoothRel(float f, float f1, float f2, float f3)
        throws ParseException
    {
        path.curveTo(currentX * 2.0F - xCenter, currentY * 2.0F - yCenter, xCenter = currentX + f, yCenter = currentY + f1, currentX += f2, currentY += f3);
    }

    public void curvetoCubicSmoothAbs(float f, float f1, float f2, float f3)
        throws ParseException
    {
        path.curveTo(currentX * 2.0F - xCenter, currentY * 2.0F - yCenter, xCenter = f, yCenter = f1, currentX = f2, currentY = f3);
    }

    public void curvetoQuadraticRel(float f, float f1, float f2, float f3)
        throws ParseException
    {
        path.quadTo(xCenter = currentX + f, yCenter = currentY + f1, currentX += f2, currentY += f3);
    }

    public void curvetoQuadraticAbs(float f, float f1, float f2, float f3)
        throws ParseException
    {
        path.quadTo(xCenter = f, yCenter = f1, currentX = f2, currentY = f3);
    }

    public void curvetoQuadraticSmoothRel(float f, float f1)
        throws ParseException
    {
        path.quadTo(xCenter = currentX * 2.0F - xCenter, yCenter = currentY * 2.0F - yCenter, currentX += f, currentY += f1);
    }

    public void curvetoQuadraticSmoothAbs(float f, float f1)
        throws ParseException
    {
        path.quadTo(xCenter = currentX * 2.0F - xCenter, yCenter = currentY * 2.0F - yCenter, currentX = f, currentY = f1);
    }

    public void arcRel(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException
    {
        path.arcTo(f, f1, f2, flag, flag1, xCenter = currentX += f3, yCenter = currentY += f4);
    }

    public void arcAbs(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException
    {
        path.arcTo(f, f1, f2, flag, flag1, xCenter = currentX = f3, yCenter = currentY = f4);
    }

    protected ExtendedGeneralPath path;
    protected float currentX;
    protected float currentY;
    protected float xCenter;
    protected float yCenter;
    protected int windingRule;
}
