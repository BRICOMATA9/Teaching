// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.*;

public class SymbolShape
    implements Shape
{
    private class ArrayPathIterator
        implements PathIterator
    {

        public boolean isDone()
        {
            return currentPoint >= numberOfPoints;
        }

        public void next()
        {
            currentPoint++;
        }

        public int currentSegment(double ad[])
        {
            ad[0] = points[2 * currentPoint];
            ad[1] = points[2 * currentPoint + 1];
            return type[currentPoint];
        }

        public int currentSegment(float af[])
        {
            af[0] = (float)points[2 * currentPoint];
            af[1] = (float)points[2 * currentPoint + 1];
            return type[currentPoint];
        }

        public int getWindingRule()
        {
            return 1;
        }

        private void reset()
        {
            currentPoint = 0;
        }

        private void done()
        {
            currentPoint = numberOfPoints;
        }

        private int currentPoint;
        private double points[];
        private int type[];
        private int numberOfPoints;





        private ArrayPathIterator(double ad[], int ai[])
        {
            super();
            currentPoint = 0;
            points = ad;
            type = ai;
        }

    }


    public SymbolShape()
    {
        ensureNumberOfPoints(10);
        type[0] = 0;
        for(int i = 1; i < type.length; i++)
            type[i] = 1;

        pathIterator = new ArrayPathIterator(points, type);
    }

    public boolean contains(double d, double d1)
    {
        return getBounds2D().contains(d, d1);
    }

    public boolean contains(double d, double d1, double d2, double d3)
    {
        return contains(d, d1) && contains(d + d2, d1) && contains(d, d1 + d3) && contains(d + d2, d1 + d3);
    }

    public boolean contains(Point2D point2d)
    {
        return contains(point2d.getX(), point2d.getY());
    }

    public boolean contains(Rectangle2D rectangle2d)
    {
        return contains(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
    }

    public boolean intersects(double d, double d1, double d2, double d3)
    {
        return contains(d, d1) || contains(d + d2, d1) || contains(d, d1 + d3) || contains(d + d2, d1 + d3);
    }

    public boolean intersects(Rectangle2D rectangle2d)
    {
        return intersects(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
    }

    public PathIterator getPathIterator(AffineTransform affinetransform, double d)
    {
        return getPathIterator(affinetransform);
    }

    public Rectangle2D getBounds2D()
    {
        return new java.awt.geom.Rectangle2D.Double(x - size / 2D, y - size / 2D, size, size);
    }

    public Rectangle getBounds()
    {
        return getBounds2D().getBounds();
    }

    public PathIterator getPathIterator(AffineTransform affinetransform)
    {
        if(affinetransform != null)
            affinetransform.transform(points, 0, pathIterator.points, 0, points.length / 2);
        pathIterator.reset();
        return pathIterator;
    }

    private void createNew(int i)
    {
        ensureNumberOfPoints(i);
        pathIterator.numberOfPoints = i;
        pathIterator.done();
    }

    public void create(int i, double d, double d1, double d2)
    {
        symbol = i;
        x = d;
        y = d1;
        size = d2;
        switch(i)
        {
        case 0: // '\0'
            createVLine(d, d1, d2);
            break;

        case 1: // '\001'
            createHLine(d, d1, d2);
            break;

        case 2: // '\002'
            createPlus(d, d1, d2);
            break;

        case 3: // '\003'
            createCross(d, d1, d2);
            break;

        case 4: // '\004'
            createStar(d, d1, d2);
            break;

        case 6: // '\006'
            createBox(d, d1, d2);
            break;

        case 7: // '\007'
            createUpTriangle(d, d1, d2);
            break;

        case 8: // '\b'
            createDownTriangle(d, d1, d2);
            break;

        case 9: // '\t'
            createDiamond(d, d1, d2);
            break;
        }
    }

    public String toString()
    {
        return getClass() + ": " + symbol + " (" + x + ", " + y + ") size: " + size;
    }

    private void createHLine(double d, double d1, double d2)
    {
        createNew(2);
        type[0] = 0;
        points[0] = d - d2 / 2D;
        points[1] = d1;
        type[1] = 1;
        points[2] = d + d2 / 2D;
        points[3] = d1;
    }

    private void createVLine(double d, double d1, double d2)
    {
        createNew(2);
        type[0] = 0;
        points[0] = d;
        points[1] = d1 - d2 / 2D;
        type[1] = 1;
        points[2] = d;
        points[3] = d1 + d2 / 2D;
    }

    private void createPlus(double d, double d1, double d2)
    {
        createNew(4);
        double d3 = d2 / 2D;
        type[0] = 0;
        points[0] = d + d3;
        points[1] = d1;
        type[1] = 1;
        points[2] = d - d3;
        points[3] = d1;
        type[2] = 0;
        points[4] = d;
        points[5] = d1 + d3;
        type[3] = 1;
        points[6] = d;
        points[7] = d1 - d3;
    }

    private void createCross(double d, double d1, double d2)
    {
        createNew(4);
        double d3 = d2 / 2D / SQRT_2;
        type[0] = 0;
        points[0] = d - d3;
        points[1] = d1 - d3;
        type[1] = 1;
        points[2] = d + d3;
        points[3] = d1 + d3;
        type[2] = 0;
        points[4] = d + d3;
        points[5] = d1 - d3;
        type[3] = 1;
        points[6] = d - d3;
        points[7] = d1 + d3;
    }

    private void createStar(double d, double d1, double d2)
    {
        createNew(8);
        double d3 = d2 / 2D;
        type[0] = 0;
        points[0] = d;
        points[1] = d1 - d3;
        type[1] = 1;
        points[2] = d;
        points[3] = d1 + d3;
        type[2] = 0;
        points[4] = d - d3;
        points[5] = d1;
        type[3] = 1;
        points[6] = d + d3;
        points[7] = d1;
        d3 = d2 / 2D / SQRT_2;
        type[4] = 0;
        points[8] = d - d3;
        points[9] = d1 - d3;
        type[5] = 1;
        points[10] = d + d3;
        points[11] = d1 + d3;
        type[6] = 0;
        points[12] = d + d3;
        points[13] = d1 - d3;
        type[7] = 1;
        points[14] = d - d3;
        points[15] = d1 + d3;
    }

    private void createUpTriangle(double d, double d1, double d2)
    {
        createNew(4);
        type[0] = 0;
        points[0] = d;
        points[1] = d1 - d2 / SQRT_3;
        type[1] = 1;
        points[2] = d - d2 / 2D;
        points[3] = d1 + (-d2 / SQRT_3 + (d2 * SQRT_3) / 2D);
        type[2] = 1;
        points[4] = d + d2 / 2D;
        points[5] = d1 + (-d2 / SQRT_3 + (d2 * SQRT_3) / 2D);
        type[3] = 4;
    }

    private void createDownTriangle(double d, double d1, double d2)
    {
        createNew(4);
        type[0] = 0;
        points[0] = d;
        points[1] = d1 + d2 / SQRT_3;
        type[1] = 1;
        points[2] = d - d2 / 2D;
        points[3] = d1 - (-d2 / SQRT_3 + (d2 * SQRT_3) / 2D);
        type[2] = 1;
        points[4] = d + d2 / 2D;
        points[5] = d1 - (-d2 / SQRT_3 + (d2 * SQRT_3) / 2D);
        type[3] = 4;
    }

    private void createDiamond(double d, double d1, double d2)
    {
        createNew(5);
        double d3 = d2 / 2D;
        type[0] = 0;
        points[0] = d + d3;
        points[1] = d1;
        type[1] = 1;
        points[2] = d;
        points[3] = d1 + d3;
        type[2] = 1;
        points[4] = d - d3;
        points[5] = d1;
        type[3] = 1;
        points[6] = d;
        points[7] = d1 - d3;
        type[4] = 4;
    }

    private void createBox(double d, double d1, double d2)
    {
        createNew(5);
        double d3 = d2 / SQRT_2 / 2D;
        type[0] = 0;
        points[0] = d - d3;
        points[1] = d1 - d3;
        type[1] = 1;
        points[2] = d + d3 + 1.0D;
        points[3] = d1 - d3;
        type[2] = 1;
        points[4] = d + d3 + 1.0D;
        points[5] = d1 + d3 + 1.0D;
        type[3] = 1;
        points[6] = d - d3;
        points[7] = d1 + d3 + 1.0D;
        type[4] = 4;
    }

    private void ensureNumberOfPoints(int i)
    {
        if(type == null || type.length < i)
        {
            points = new double[i * 2];
            type = new int[i];
        }
    }

    private static final double SQRT_2 = Math.sqrt(2D);
    private static final double SQRT_3 = Math.sqrt(3D);
    private double points[];
    private int type[];
    private ArrayPathIterator pathIterator;
    private double x;
    private double y;
    private double size;
    private int symbol;

}
