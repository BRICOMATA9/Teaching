// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Stack;

// Referenced classes of package org.freehep.graphicsio:
//            QuadToCubicPathConstructor

public abstract class CubicToLinePathConstructor extends QuadToCubicPathConstructor
{
    class ControlSet
    {

        public double breadth()
        {
            double d = point0.getX();
            double d1 = point0.getY();
            double d2 = point1.getX();
            double d3 = point1.getY();
            double d4 = point2.getX();
            double d5 = point2.getY();
            double d6 = point3.getX();
            double d7 = point3.getY();
            if(Math.abs(d - d6) < resolution && Math.abs(d1 - d7) < resolution)
            {
                double d8 = Math.abs(d2 - d) + Math.abs(d3 - d1);
                double d10 = Math.abs(d4 - d) + Math.abs(d5 - d1);
                return Math.max(d10, d8);
            } else
            {
                double d9 = d1 - d7;
                double d11 = d6 - d;
                double d12 = Math.sqrt(d9 * d9 + d11 * d11);
                double d13 = d6 * d1 - d * d7;
                double d14 = Math.abs((d9 * d4 + d11 * d5) - d13) / d12;
                double d15 = Math.abs((d9 * d2 + d11 * d3) - d13) / d12;
                return Math.max(d14, d15);
            }
        }

        public ControlSet bisect()
        {
            Point2D point2d = average(point0, point1);
            Point2D point2d1 = average(point1, point2);
            Point2D point2d2 = average(point2, point3);
            Point2D point2d3 = average(point2d, point2d1);
            Point2D point2d4 = average(point2d1, point2d2);
            Point2D point2d5 = average(point2d3, point2d4);
            ControlSet controlset = new ControlSet(point2d5, point2d4, point2d2, point3);
            point1 = point2d;
            point2 = point2d3;
            point3 = point2d5;
            return controlset;
        }

        public Point2D average(Point2D point2d, Point2D point2d1)
        {
            return new java.awt.geom.Point2D.Double((point2d.getX() + point2d1.getX()) / 2D, (point2d.getY() + point2d1.getY()) / 2D);
        }

        public Point2D getPoint()
        {
            return point3;
        }

        private Point2D point0;
        private Point2D point1;
        private Point2D point2;
        private Point2D point3;

        public ControlSet(Point2D point2d, Point2D point2d1, Point2D point2d2, Point2D point2d3)
        {
            super();
            point0 = point2d;
            point1 = point2d1;
            point2 = point2d2;
            point3 = point2d3;
        }
    }


    protected CubicToLinePathConstructor()
    {
        this(0.025000000000000001D);
    }

    protected CubicToLinePathConstructor(double d)
    {
        resolution = Math.abs(d);
    }

    public void cubic(double d, double d1, double d2, double d3, double d4, double d5)
        throws IOException
    {
        Stack stack = new Stack();
        java.awt.geom.Point2D.Double double1 = new java.awt.geom.Point2D.Double(currentX, currentY);
        java.awt.geom.Point2D.Double double2 = new java.awt.geom.Point2D.Double(d, d1);
        java.awt.geom.Point2D.Double double3 = new java.awt.geom.Point2D.Double(d2, d3);
        java.awt.geom.Point2D.Double double4 = new java.awt.geom.Point2D.Double(d4, d5);
        Stack stack1 = new Stack();
        stack1.push(new ControlSet(double1, double2, double3, double4));
        while(!stack1.empty()) 
        {
            ControlSet controlset = (ControlSet)stack1.pop();
            if(controlset.breadth() > resolution)
            {
                stack1.push(controlset);
                stack1.push(controlset.bisect());
            } else
            {
                stack.push(controlset);
            }
        }
        Point2D point2d;
        for(; !stack.empty(); line(point2d.getX(), point2d.getY()))
            point2d = ((ControlSet)stack.pop()).getPoint();

        super.cubic(d, d1, d2, d3, d4, d5);
    }

    private double resolution;

}
