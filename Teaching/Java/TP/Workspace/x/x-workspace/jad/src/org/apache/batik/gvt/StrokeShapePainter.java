// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

// Referenced classes of package org.apache.batik.gvt:
//            ShapePainter

public class StrokeShapePainter
    implements ShapePainter
{

    public StrokeShapePainter(Shape shape1)
    {
        if(shape1 == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            shape = shape1;
            return;
        }
    }

    public void setStroke(Stroke stroke1)
    {
        stroke = stroke1;
        strokedShape = null;
    }

    public void setPaint(Paint paint1)
    {
        paint = paint1;
    }

    public void paint(Graphics2D graphics2d)
    {
        if(stroke != null && paint != null)
        {
            graphics2d.setPaint(paint);
            graphics2d.setStroke(stroke);
            graphics2d.draw(shape);
        }
    }

    public Shape getPaintedArea()
    {
        if(paint == null || stroke == null)
            return null;
        if(strokedShape == null)
            strokedShape = stroke.createStrokedShape(shape);
        return strokedShape;
    }

    public Rectangle2D getPaintedBounds2D()
    {
        Shape shape1 = getPaintedArea();
        if(shape1 == null)
            return null;
        else
            return shape1.getBounds2D();
    }

    public boolean inPaintedArea(Point2D point2d)
    {
        Shape shape1 = getPaintedArea();
        if(shape1 == null)
            return false;
        else
            return shape1.contains(point2d);
    }

    public Shape getSensitiveArea()
    {
        if(stroke == null)
            return null;
        if(strokedShape == null)
            strokedShape = stroke.createStrokedShape(shape);
        return strokedShape;
    }

    public Rectangle2D getSensitiveBounds2D()
    {
        Shape shape1 = getSensitiveArea();
        if(shape1 == null)
            return null;
        else
            return shape1.getBounds2D();
    }

    public boolean inSensitiveArea(Point2D point2d)
    {
        Shape shape1 = getSensitiveArea();
        if(shape1 == null)
            return false;
        else
            return shape1.contains(point2d);
    }

    public void setShape(Shape shape1)
    {
        if(shape1 == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            shape = shape1;
            strokedShape = null;
            return;
        }
    }

    public Shape getShape()
    {
        return shape;
    }

    protected Shape shape;
    protected Shape strokedShape;
    protected Stroke stroke;
    protected Paint paint;
}
