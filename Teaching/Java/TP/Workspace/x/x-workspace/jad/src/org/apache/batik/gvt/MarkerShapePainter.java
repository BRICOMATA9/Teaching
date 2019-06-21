// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.util.List;
import java.util.Vector;
import org.apache.batik.ext.awt.geom.ExtendedGeneralPath;
import org.apache.batik.ext.awt.geom.ExtendedPathIterator;
import org.apache.batik.ext.awt.geom.ExtendedShape;
import org.apache.batik.ext.awt.geom.ShapeExtender;

// Referenced classes of package org.apache.batik.gvt:
//            ShapePainter, CompositeGraphicsNode, Marker, ProxyGraphicsNode

public class MarkerShapePainter
    implements ShapePainter
{

    public MarkerShapePainter(java.awt.Shape shape)
    {
        if(shape == null)
            throw new IllegalArgumentException();
        if(shape instanceof ExtendedShape)
            extShape = (ExtendedShape)shape;
        else
            extShape = new ShapeExtender(shape);
    }

    public void paint(java.awt.Graphics2D graphics2d)
    {
        if(markerGroup == null)
            buildMarkerGroup();
        if(markerGroup.getChildren().size() > 0)
            markerGroup.paint(graphics2d);
    }

    public java.awt.Shape getPaintedArea()
    {
        if(markerGroup == null)
            buildMarkerGroup();
        return markerGroup.getOutline();
    }

    public java.awt.geom.Rectangle2D getPaintedBounds2D()
    {
        if(markerGroup == null)
            buildMarkerGroup();
        return markerGroup.getPrimitiveBounds();
    }

    public boolean inPaintedArea(java.awt.geom.Point2D point2d)
    {
        if(markerGroup == null)
            buildMarkerGroup();
        GraphicsNode graphicsnode = markerGroup.nodeHitAt(point2d);
        return graphicsnode != null;
    }

    public java.awt.Shape getSensitiveArea()
    {
        return null;
    }

    public java.awt.geom.Rectangle2D getSensitiveBounds2D()
    {
        return null;
    }

    public boolean inSensitiveArea(java.awt.geom.Point2D point2d)
    {
        return false;
    }

    public void setShape(java.awt.Shape shape)
    {
        if(shape == null)
            throw new IllegalArgumentException();
        if(shape instanceof ExtendedShape)
            extShape = (ExtendedShape)shape;
        else
            extShape = new ShapeExtender(shape);
        startMarkerProxy = null;
        middleMarkerProxies = null;
        endMarkerProxy = null;
        markerGroup = null;
    }

    public ExtendedShape getExtShape()
    {
        return extShape;
    }

    public java.awt.Shape getShape()
    {
        return extShape;
    }

    public Marker getStartMarker()
    {
        return startMarker;
    }

    public void setStartMarker(Marker marker)
    {
        startMarker = marker;
        startMarkerProxy = null;
        markerGroup = null;
    }

    public Marker getMiddleMarker()
    {
        return middleMarker;
    }

    public void setMiddleMarker(Marker marker)
    {
        middleMarker = marker;
        middleMarkerProxies = null;
        markerGroup = null;
    }

    public Marker getEndMarker()
    {
        return endMarker;
    }

    public void setEndMarker(Marker marker)
    {
        endMarker = marker;
        endMarkerProxy = null;
        markerGroup = null;
    }

    protected void buildMarkerGroup()
    {
        if(startMarker != null && startMarkerProxy == null)
            startMarkerProxy = buildStartMarkerProxy();
        if(middleMarker != null && middleMarkerProxies == null)
            middleMarkerProxies = buildMiddleMarkerProxies();
        if(endMarker != null && endMarkerProxy == null)
            endMarkerProxy = buildEndMarkerProxy();
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        List list = compositegraphicsnode.getChildren();
        if(startMarkerProxy != null)
            list.add(startMarkerProxy);
        if(middleMarkerProxies != null)
        {
            for(int i = 0; i < middleMarkerProxies.length; i++)
                list.add(middleMarkerProxies[i]);

        }
        if(endMarkerProxy != null)
            list.add(endMarkerProxy);
        markerGroup = compositegraphicsnode;
    }

    protected ProxyGraphicsNode buildStartMarkerProxy()
    {
        ExtendedPathIterator extendedpathiterator = getExtShape().getExtendedPathIterator();
        double ad[] = new double[7];
        int i = 0;
        if(extendedpathiterator.isDone())
            return null;
        i = extendedpathiterator.currentSegment(ad);
        if(i != 0)
            return null;
        extendedpathiterator.next();
        java.awt.geom.Point2D.Double double1 = new java.awt.geom.Point2D.Double(ad[0], ad[1]);
        double d = startMarker.getOrient();
        if(Double.isNaN(d) && !extendedpathiterator.isDone())
        {
            double ad1[] = new double[7];
            int j = 0;
            j = extendedpathiterator.currentSegment(ad1);
            if(j == 4)
            {
                j = 1;
                ad1[0] = ad[0];
                ad1[1] = ad[1];
            }
            d = computeRotation(null, 0, ad, i, ad1, j);
        }
        java.awt.geom.AffineTransform affinetransform = computeMarkerTransform(startMarker, double1, d);
        ProxyGraphicsNode proxygraphicsnode = new ProxyGraphicsNode();
        proxygraphicsnode.setSource(startMarker.getMarkerNode());
        proxygraphicsnode.setTransform(affinetransform);
        return proxygraphicsnode;
    }

    protected ProxyGraphicsNode buildEndMarkerProxy()
    {
        ExtendedPathIterator extendedpathiterator = getExtShape().getExtendedPathIterator();
        int i = 0;
        if(extendedpathiterator.isDone())
            return null;
        double ad[] = new double[7];
        double ad1[] = new double[2];
        int j = 0;
        j = extendedpathiterator.currentSegment(ad);
        if(j != 0)
            return null;
        i++;
        ad1[0] = ad[0];
        ad1[1] = ad[1];
        extendedpathiterator.next();
        double ad2[] = new double[7];
        double ad3[] = {
            ad[0], ad[1], ad[2], ad[3], ad[4], ad[5], ad[6]
        };
        Object obj = null;
        int k = j;
        int l = 0;
        while(!extendedpathiterator.isDone()) 
        {
            double ad4[] = ad2;
            ad2 = ad3;
            ad3 = ad4;
            l = k;
            k = extendedpathiterator.currentSegment(ad3);
            if(k == 0)
            {
                ad1[0] = ad3[0];
                ad1[1] = ad3[1];
            } else
            if(k == 4)
            {
                k = 1;
                ad3[0] = ad1[0];
                ad3[1] = ad1[1];
            }
            extendedpathiterator.next();
            i++;
        }
        if(i < 2)
            return null;
        java.awt.geom.Point2D point2d = getSegmentTerminatingPoint(ad3, k);
        double d = endMarker.getOrient();
        if(Double.isNaN(d))
            d = computeRotation(ad2, l, ad3, k, null, 0);
        java.awt.geom.AffineTransform affinetransform = computeMarkerTransform(endMarker, point2d, d);
        ProxyGraphicsNode proxygraphicsnode = new ProxyGraphicsNode();
        proxygraphicsnode.setSource(endMarker.getMarkerNode());
        proxygraphicsnode.setTransform(affinetransform);
        return proxygraphicsnode;
    }

    protected ProxyGraphicsNode[] buildMiddleMarkerProxies()
    {
        ExtendedPathIterator extendedpathiterator = getExtShape().getExtendedPathIterator();
        double ad[] = new double[7];
        double ad1[] = new double[7];
        double ad2[] = new double[7];
        Object obj = null;
        int i = 0;
        int j = 0;
        boolean flag = false;
        if(extendedpathiterator.isDone())
            return null;
        i = extendedpathiterator.currentSegment(ad);
        double ad4[] = new double[2];
        if(i != 0)
            return null;
        ad4[0] = ad[0];
        ad4[1] = ad[1];
        extendedpathiterator.next();
        if(extendedpathiterator.isDone())
            return null;
        j = extendedpathiterator.currentSegment(ad1);
        if(j == 0)
        {
            ad4[0] = ad1[0];
            ad4[1] = ad1[1];
        } else
        if(j == 4)
        {
            j = 1;
            ad1[0] = ad4[0];
            ad1[1] = ad4[1];
        }
        extendedpathiterator.next();
        Vector vector = new Vector();
        for(; !extendedpathiterator.isDone(); extendedpathiterator.next())
        {
            int k = extendedpathiterator.currentSegment(ad2);
            if(k == 0)
            {
                ad4[0] = ad2[0];
                ad4[1] = ad2[1];
            } else
            if(k == 4)
            {
                k = 1;
                ad2[0] = ad4[0];
                ad2[1] = ad4[1];
            }
            vector.addElement(createMiddleMarker(ad, i, ad1, j, ad2, k));
            double ad3[] = ad;
            ad = ad1;
            i = j;
            ad1 = ad2;
            j = k;
            ad2 = ad3;
        }

        ProxyGraphicsNode aproxygraphicsnode[] = new ProxyGraphicsNode[vector.size()];
        vector.copyInto(aproxygraphicsnode);
        return aproxygraphicsnode;
    }

    private ProxyGraphicsNode createMiddleMarker(double ad[], int i, double ad1[], int j, double ad2[], int k)
    {
        java.awt.geom.Point2D point2d = getSegmentTerminatingPoint(ad1, j);
        double d = middleMarker.getOrient();
        if(Double.isNaN(d))
            d = computeRotation(ad, i, ad1, j, ad2, k);
        java.awt.geom.AffineTransform affinetransform = computeMarkerTransform(middleMarker, point2d, d);
        ProxyGraphicsNode proxygraphicsnode = new ProxyGraphicsNode();
        proxygraphicsnode.setSource(middleMarker.getMarkerNode());
        proxygraphicsnode.setTransform(affinetransform);
        return proxygraphicsnode;
    }

    private double computeRotation(double ad[], int i, double ad1[], int j, double ad2[], int k)
    {
        double ad3[] = computeInSlope(ad, i, ad1, j);
        double ad4[] = computeOutSlope(ad1, j, ad2, k);
        if(ad3 == null)
            ad3 = ad4;
        if(ad4 == null)
            ad4 = ad3;
        if(ad3 == null)
            return 0.0D;
        double d = ad3[0] + ad4[0];
        double d1 = ad3[1] + ad4[1];
        if(d == 0.0D && d1 == 0.0D)
            return (Math.atan2(ad3[1], ad3[0]) * 180D) / 3.1415926535897931D + 90D;
        else
            return (Math.atan2(d1, d) * 180D) / 3.1415926535897931D;
    }

    private double[] computeInSlope(double ad[], int i, double ad1[], int j)
    {
        java.awt.geom.Point2D point2d = getSegmentTerminatingPoint(ad1, j);
        double d = 0.0D;
        double d1 = 0.0D;
        switch(j)
        {
        case 1: // '\001'
            java.awt.geom.Point2D point2d1 = getSegmentTerminatingPoint(ad, i);
            d = point2d.getX() - point2d1.getX();
            d1 = point2d.getY() - point2d1.getY();
            break;

        case 2: // '\002'
            d = point2d.getX() - ad1[0];
            d1 = point2d.getY() - ad1[1];
            break;

        case 3: // '\003'
            d = point2d.getX() - ad1[2];
            d1 = point2d.getY() - ad1[3];
            break;

        case 4321: 
            java.awt.geom.Point2D point2d2 = getSegmentTerminatingPoint(ad, i);
            boolean flag = ad1[3] != 0.0D;
            boolean flag1 = ad1[4] != 0.0D;
            java.awt.geom.Arc2D arc2d = ExtendedGeneralPath.computeArc(point2d2.getX(), point2d2.getY(), ad1[0], ad1[1], ad1[2], flag, flag1, ad1[5], ad1[6]);
            double d2 = arc2d.getAngleStart() + arc2d.getAngleExtent();
            d2 = Math.toRadians(d2);
            d = (-arc2d.getWidth() / 2D) * Math.sin(d2);
            d1 = (arc2d.getHeight() / 2D) * Math.cos(d2);
            if(ad1[2] != 0.0D)
            {
                double d3 = Math.toRadians(-ad1[2]);
                double d4 = Math.sin(d3);
                double d5 = Math.cos(d3);
                double d6 = d * d5 - d1 * d4;
                double d7 = d * d4 + d1 * d5;
                d = d6;
                d1 = d7;
            }
            if(flag1)
                d = -d;
            else
                d1 = -d1;
            break;

        case 4: // '\004'
            throw new Error();

        case 0: // '\0'
        default:
            return null;
        }
        if(d == 0.0D && d1 == 0.0D)
            return null;
        else
            return normalize(new double[] {
                d, d1
            });
    }

    private double[] computeOutSlope(double ad[], int i, double ad1[], int j)
    {
        java.awt.geom.Point2D point2d = getSegmentTerminatingPoint(ad, i);
        double d = 0.0D;
        double d1 = 0.0D;
        switch(j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            d = ad1[0] - point2d.getX();
            d1 = ad1[1] - point2d.getY();
            break;

        case 4321: 
            boolean flag = ad1[3] != 0.0D;
            boolean flag1 = ad1[4] != 0.0D;
            java.awt.geom.Arc2D arc2d = ExtendedGeneralPath.computeArc(point2d.getX(), point2d.getY(), ad1[0], ad1[1], ad1[2], flag, flag1, ad1[5], ad1[6]);
            double d2 = arc2d.getAngleStart();
            d2 = Math.toRadians(d2);
            d = (-arc2d.getWidth() / 2D) * Math.sin(d2);
            d1 = (arc2d.getHeight() / 2D) * Math.cos(d2);
            if(ad1[2] != 0.0D)
            {
                double d3 = Math.toRadians(-ad1[2]);
                double d4 = Math.sin(d3);
                double d5 = Math.cos(d3);
                double d6 = d * d5 - d1 * d4;
                double d7 = d * d4 + d1 * d5;
                d = d6;
                d1 = d7;
            }
            if(flag1)
                d = -d;
            else
                d1 = -d1;
            break;

        case 0: // '\0'
        default:
            return null;

        case 4: // '\004'
            break;
        }
        if(d == 0.0D && d1 == 0.0D)
            return null;
        else
            return normalize(new double[] {
                d, d1
            });
    }

    public double[] normalize(double ad[])
    {
        double d = Math.sqrt(ad[0] * ad[0] + ad[1] * ad[1]);
        ad[0] /= d;
        ad[1] /= d;
        return ad;
    }

    private java.awt.geom.AffineTransform computeMarkerTransform(Marker marker, java.awt.geom.Point2D point2d, double d)
    {
        java.awt.geom.Point2D point2d1 = marker.getRef();
        java.awt.geom.AffineTransform affinetransform = new java.awt.geom.AffineTransform();
        affinetransform.translate(point2d.getX() - point2d1.getX(), point2d.getY() - point2d1.getY());
        if(!Double.isNaN(d))
            affinetransform.rotate((d * 3.1415926535897931D) / 180D, point2d1.getX(), point2d1.getY());
        return affinetransform;
    }

    protected java.awt.geom.Point2D getSegmentTerminatingPoint(double ad[], int i)
    {
        switch(i)
        {
        case 3: // '\003'
            return new java.awt.geom.Point2D.Double(ad[4], ad[5]);

        case 1: // '\001'
            return new java.awt.geom.Point2D.Double(ad[0], ad[1]);

        case 0: // '\0'
            return new java.awt.geom.Point2D.Double(ad[0], ad[1]);

        case 2: // '\002'
            return new java.awt.geom.Point2D.Double(ad[2], ad[3]);

        case 4321: 
            return new java.awt.geom.Point2D.Double(ad[5], ad[6]);

        case 4: // '\004'
        default:
            throw new Error();
        }
    }

    protected ExtendedShape extShape;
    protected Marker startMarker;
    protected Marker middleMarker;
    protected Marker endMarker;
    private ProxyGraphicsNode startMarkerProxy;
    private ProxyGraphicsNode middleMarkerProxies[];
    private ProxyGraphicsNode endMarkerProxy;
    private CompositeGraphicsNode markerGroup;
    private java.awt.geom.Rectangle2D dPrimitiveBounds;
    private java.awt.geom.Rectangle2D dGeometryBounds;
}
