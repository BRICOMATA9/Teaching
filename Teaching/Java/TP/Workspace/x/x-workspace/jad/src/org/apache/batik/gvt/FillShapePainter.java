// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

// Referenced classes of package org.apache.batik.gvt:
//            ShapePainter

public class FillShapePainter
    implements ShapePainter
{

    public FillShapePainter(Shape shape1)
    {
        if(shape1 == null)
        {
            throw new IllegalArgumentException("Shape can not be null!");
        } else
        {
            shape = shape1;
            return;
        }
    }

    public void setPaint(Paint paint1)
    {
        paint = paint1;
    }

    public void paint(Graphics2D graphics2d)
    {
        if(paint != null)
        {
            graphics2d.setPaint(paint);
            graphics2d.fill(shape);
        }
    }

    public Shape getPaintedArea()
    {
        if(paint == null)
            return null;
        else
            return shape;
    }

    public Rectangle2D getPaintedBounds2D()
    {
        if(paint == null || shape == null)
            return null;
        else
            return shape.getBounds2D();
    }

    public boolean inPaintedArea(Point2D point2d)
    {
        if(paint == null || shape == null)
            return false;
        else
            return shape.contains(point2d);
    }

    public Shape getSensitiveArea()
    {
        return shape;
    }

    public Rectangle2D getSensitiveBounds2D()
    {
        if(shape == null)
            return null;
        else
            return shape.getBounds2D();
    }

    public boolean inSensitiveArea(Point2D point2d)
    {
        if(shape == null)
            return false;
        else
            return shape.contains(point2d);
    }

    public void setShape(Shape shape1)
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

    public Shape getShape()
    {
        return shape;
    }

    protected Shape shape;
    protected Paint paint;
}
