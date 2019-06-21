// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;

// Referenced classes of package org.apache.batik.gvt:
//            ShapePainter

public class CompositeShapePainter
    implements ShapePainter
{

    public CompositeShapePainter(Shape shape1)
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

    public void addShapePainter(ShapePainter shapepainter)
    {
        if(shapepainter == null)
            return;
        if(shape != shapepainter.getShape())
            shapepainter.setShape(shape);
        if(painters == null)
            painters = new ShapePainter[2];
        if(count == painters.length)
        {
            ShapePainter ashapepainter[] = new ShapePainter[(count * 3) / 2 + 1];
            System.arraycopy(painters, 0, ashapepainter, 0, count);
            painters = ashapepainter;
        }
        painters[count++] = shapepainter;
    }

    public ShapePainter getShapePainter(int i)
    {
        return painters[i];
    }

    public int getShapePainterCount()
    {
        return count;
    }

    public void paint(Graphics2D graphics2d)
    {
        if(painters != null)
        {
            for(int i = 0; i < count; i++)
                painters[i].paint(graphics2d);

        }
    }

    public Shape getPaintedArea()
    {
        if(painters == null)
            return null;
        Area area = new Area();
        for(int i = 0; i < count; i++)
        {
            Shape shape1 = painters[i].getPaintedArea();
            if(shape1 != null)
                area.add(new Area(shape1));
        }

        return area;
    }

    public Rectangle2D getPaintedBounds2D()
    {
        if(painters == null)
            return null;
        Rectangle2D rectangle2d = null;
        for(int i = 0; i < count; i++)
        {
            Rectangle2D rectangle2d1 = painters[i].getPaintedBounds2D();
            if(rectangle2d1 == null)
                continue;
            if(rectangle2d == null)
                rectangle2d = (Rectangle2D)rectangle2d1.clone();
            else
                rectangle2d.add(rectangle2d1);
        }

        return rectangle2d;
    }

    public boolean inPaintedArea(Point2D point2d)
    {
        if(painters == null)
            return false;
        for(int i = 0; i < count; i++)
            if(painters[i].inPaintedArea(point2d))
                return true;

        return false;
    }

    public Shape getSensitiveArea()
    {
        if(painters == null)
            return null;
        Area area = new Area();
        for(int i = 0; i < count; i++)
        {
            Shape shape1 = painters[i].getSensitiveArea();
            if(shape1 != null)
                area.add(new Area(shape1));
        }

        return area;
    }

    public Rectangle2D getSensitiveBounds2D()
    {
        if(painters == null)
            return null;
        Rectangle2D rectangle2d = null;
        for(int i = 0; i < count; i++)
        {
            Rectangle2D rectangle2d1 = painters[i].getSensitiveBounds2D();
            if(rectangle2d == null)
                rectangle2d = (Rectangle2D)rectangle2d1.clone();
            else
                rectangle2d.add(rectangle2d1);
        }

        return rectangle2d;
    }

    public boolean inSensitiveArea(Point2D point2d)
    {
        if(painters == null)
            return false;
        for(int i = 0; i < count; i++)
            if(painters[i].inSensitiveArea(point2d))
                return true;

        return false;
    }

    public void setShape(Shape shape1)
    {
        if(shape1 == null)
            throw new IllegalArgumentException();
        if(painters != null)
        {
            for(int i = 0; i < count; i++)
                painters[i].setShape(shape1);

        }
        shape = shape1;
    }

    public Shape getShape()
    {
        return shape;
    }

    protected Shape shape;
    protected ShapePainter painters[];
    protected int count;
}
