// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package org.freehep.graphicsio:
//            AbstractPathConstructor, PathConstructor

public abstract class CubicToQuadPathConstructor extends AbstractPathConstructor
{
    static class Test extends CubicToQuadPathConstructor
    {

        public void quad(double d, double d1, double d2, double d3)
        {
            System.out.println("Quad: (" + currentX + ", " + currentY + ") (" + d + ", " + d1 + ") (" + d2 + ", " + d3 + ")");
            currentX = d2;
            currentY = d3;
        }

        public Test(double d)
        {
            super(d);
        }
    }


    protected CubicToQuadPathConstructor(double d)
    {
        resolutionSq = d * d;
    }

    public void move(double d, double d1)
        throws IOException
    {
        currentX = d;
        currentY = d1;
    }

    public void line(double d, double d1)
        throws IOException
    {
        currentX = d;
        currentY = d1;
    }

    public void cubic(double d, double d1, double d2, double d3, double d4, double d5)
        throws IOException
    {
        quadratify(new java.awt.geom.Point2D.Double(currentX, currentY), new java.awt.geom.Point2D.Double(d, d1), new java.awt.geom.Point2D.Double(d2, d3), new java.awt.geom.Point2D.Double(d4, d5));
        currentX = d4;
        currentY = d5;
    }

    public void closePath(double d, double d1)
        throws IOException
    {
        currentX = 0.0D;
        currentY = 0.0D;
    }

    public static Point2D intersect(Point2D point2d, Point2D point2d1, Point2D point2d2, Point2D point2d3)
    {
        double d = point2d1.getX() - point2d.getX();
        double d1 = point2d2.getX() - point2d3.getX();
        if(d == 0.0D && d1 == 0.0D)
            return null;
        double d2 = point2d1.getY() - point2d.getY();
        double d3 = point2d2.getY() - point2d3.getY();
        if(d2 == 0.0D && d3 == 0.0D)
            return null;
        double d4 = (point2d1.getY() - point2d.getY()) / d;
        double d5 = (point2d2.getY() - point2d3.getY()) / d1;
        if(d == 0.0D)
            return new java.awt.geom.Point2D.Double(point2d.getX(), d5 * (point2d.getX() - point2d3.getX()) + point2d3.getY());
        if(d1 == 0.0D)
            return new java.awt.geom.Point2D.Double(point2d3.getX(), d4 * (point2d3.getX() - point2d.getX()) + point2d.getY());
        if(d4 == d5)
        {
            return null;
        } else
        {
            double d6 = ((-d5 * point2d3.getX() + point2d3.getY() + d4 * point2d.getX()) - point2d.getY()) / (d4 - d5);
            double d7 = d4 * (d6 - point2d.getX()) + point2d.getY();
            return new java.awt.geom.Point2D.Double(d6, d7);
        }
    }

    public static Point2D midPoint(Point2D point2d, Point2D point2d1)
    {
        return new java.awt.geom.Point2D.Double((point2d.getX() + point2d1.getX()) / 2D, (point2d.getY() + point2d1.getY()) / 2D);
    }

    public void quadratify(Point2D point2d, Point2D point2d1, Point2D point2d2, Point2D point2d3)
        throws IOException
    {
        Point2D point2d4 = intersect(point2d, point2d1, point2d2, point2d3);
        if(point2d4 == null)
            return;
        double d = ((point2d.getX() + point2d3.getX() + point2d4.getX() * 4D) - (point2d1.getX() + point2d2.getX()) * 3D) * 0.125D;
        double d1 = ((point2d.getY() + point2d3.getY() + point2d4.getY() * 4D) - (point2d1.getY() + point2d2.getY()) * 3D) * 0.125D;
        if(d * d + d1 * d1 > resolutionSq)
        {
            Point2D point2d5 = midPoint(point2d, point2d1);
            Point2D point2d6 = midPoint(point2d1, point2d2);
            Point2D point2d7 = midPoint(point2d2, point2d3);
            Point2D point2d8 = midPoint(point2d5, point2d6);
            Point2D point2d9 = midPoint(point2d6, point2d7);
            Point2D point2d10 = midPoint(point2d8, point2d9);
            quadratify(point2d, point2d5, point2d8, point2d10);
            quadratify(point2d10, point2d9, point2d7, point2d3);
        } else
        {
            quad(point2d4.getX(), point2d4.getY(), point2d3.getX(), point2d3.getY());
        }
    }

    public static void main(String args[])
        throws Exception
    {
        Test test = new Test(0.5D);
        test.move(20D, 20D);
        test.cubic(20D, 40D, 40D, 60D, 60D, 60D);
        test.move(20D, 20D);
        test.cubic(20D, 40D, 60D, 60D, 40D, 60D);
        test.move(183D, 149D);
        test.cubic(189D, 291D, 256D, 347D, 295D, 244D);
        test.cubic(334D, 141D, 286D, 216D, 214D, 228D);
        test.cubic(142D, 240D, 142D, 256D, 176D, 284D);
    }

    private double resolutionSq;
}
