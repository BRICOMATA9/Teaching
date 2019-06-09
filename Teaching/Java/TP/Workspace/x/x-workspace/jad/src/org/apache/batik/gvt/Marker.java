// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.geom.Point2D;

// Referenced classes of package org.apache.batik.gvt:
//            GraphicsNode

public class Marker
{

    public Marker(GraphicsNode graphicsnode, Point2D point2d, double d)
    {
        if(graphicsnode == null)
            throw new IllegalArgumentException();
        if(point2d == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            markerNode = graphicsnode;
            ref = point2d;
            orient = d;
            return;
        }
    }

    public Point2D getRef()
    {
        return (Point2D)ref.clone();
    }

    public double getOrient()
    {
        return orient;
    }

    public GraphicsNode getMarkerNode()
    {
        return markerNode;
    }

    protected double orient;
    protected GraphicsNode markerNode;
    protected Point2D ref;
}
