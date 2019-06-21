// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public interface ShapePainter
{

    public abstract void paint(Graphics2D graphics2d);

    public abstract Shape getPaintedArea();

    public abstract Rectangle2D getPaintedBounds2D();

    public abstract boolean inPaintedArea(Point2D point2d);

    public abstract Shape getSensitiveArea();

    public abstract Rectangle2D getSensitiveBounds2D();

    public abstract boolean inSensitiveArea(Point2D point2d);

    public abstract void setShape(Shape shape);

    public abstract Shape getShape();
}
