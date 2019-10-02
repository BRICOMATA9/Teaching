// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphics2d;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.*;

public class ArrayPath
    implements Shape
{
    private class ArrayPathIterator
        implements PathIterator
    {

        public boolean isDone()
        {
            return isDone;
        }

        public void next()
        {
            for(currentPoint++; currentPoint < nPoints - 1 && Math.abs(xPoints[currentPoint] - lastX) < (double)resolution && Math.abs(yPoints[currentPoint] - lastY) < (double)resolution; currentPoint++);
            if(closed && currentPoint == nPoints - 1 && Math.abs(xPoints[currentPoint] - xPoints[0]) < (double)resolution && Math.abs(yPoints[currentPoint] - yPoints[0]) < (double)resolution)
                currentPoint++;
            isDone = closed ? currentPoint > nPoints : currentPoint >= nPoints;
        }

        public int currentSegment(double ad[])
        {
            if(closed && currentPoint == nPoints)
            {
                return 4;
            } else
            {
                ad[0] = lastX = xPoints[currentPoint];
                ad[1] = lastY = yPoints[currentPoint];
                return currentPoint != 0 ? 1 : 0;
            }
        }

        public int currentSegment(float af[])
        {
            if(closed && currentPoint == nPoints)
            {
                return 4;
            } else
            {
                lastX = xPoints[currentPoint];
                lastY = yPoints[currentPoint];
                af[0] = (float)lastX;
                af[1] = (float)lastY;
                return currentPoint != 0 ? 1 : 0;
            }
        }

        public int getWindingRule()
        {
            return 1;
        }

        private double xPoints[];
        private double yPoints[];
        private double lastX;
        private double lastY;
        private int nPoints;
        private boolean closed;
        private int resolution;
        private int currentPoint;
        private boolean isDone;

        private ArrayPathIterator(double ad[], double ad1[], int i, boolean flag, int j)
        {
            super();
            xPoints = ad;
            yPoints = ad1;
            nPoints = i;
            closed = flag;
            resolution = j;
            currentPoint = 0;
            isDone = i == 0;
        }

    }


    public ArrayPath(double ad[], double ad1[], int i, boolean flag, int j)
    {
        xPoints = ad;
        yPoints = ad1;
        nPoints = i;
        closed = flag;
        resolution = j;
    }

    public boolean contains(double d, double d1)
    {
        return false;
    }

    public boolean contains(double d, double d1, double d2, double d3)
    {
        return false;
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
        return true;
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
        int i = nPoints;
        double d;
        double d1;
        double d2;
        double d3;
        if(i > 0)
        {
            i--;
            d1 = d3 = yPoints[i];
            d = d2 = xPoints[i];
            do
            {
                if(i <= 0)
                    break;
                i--;
                double d4 = yPoints[i];
                double d5 = xPoints[i];
                if(d5 < d)
                    d = d5;
                if(d4 < d1)
                    d1 = d4;
                if(d5 > d2)
                    d2 = d5;
                if(d4 > d3)
                    d3 = d4;
            } while(true);
        } else
        {
            d = d1 = d2 = d3 = 0.0D;
        }
        return new java.awt.geom.Rectangle2D.Double(d, d1, d2 - d, d3 - d1);
    }

    public Rectangle getBounds()
    {
        return getBounds2D().getBounds();
    }

    public PathIterator getPathIterator(AffineTransform affinetransform)
    {
        double ad[] = xPoints;
        double ad1[] = yPoints;
        if(affinetransform != null)
        {
            ad = new double[nPoints];
            ad1 = new double[nPoints];
            java.awt.geom.Point2D.Double double1 = new java.awt.geom.Point2D.Double();
            java.awt.geom.Point2D.Double double2 = new java.awt.geom.Point2D.Double();
            for(int i = 0; i < nPoints; i++)
            {
                double1.setLocation(xPoints[i], yPoints[i]);
                affinetransform.transform(double1, double2);
                ad[i] = double2.getX();
                ad1[i] = double2.getY();
            }

        }
        return new ArrayPathIterator(ad, ad1, nPoints, closed, resolution);
    }

    private double xPoints[];
    private double yPoints[];
    private int nPoints;
    private boolean closed;
    private int resolution;
}
