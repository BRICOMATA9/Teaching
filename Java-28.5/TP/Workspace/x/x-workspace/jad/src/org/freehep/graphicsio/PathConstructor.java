// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.IOException;

public interface PathConstructor
{

    public abstract void move(double d, double d1)
        throws IOException;

    public abstract void line(double d, double d1)
        throws IOException;

    public abstract void quad(double d, double d1, double d2, double d3)
        throws IOException;

    public abstract void cubic(double d, double d1, double d2, double d3, double d4, double d5)
        throws IOException;

    public abstract void closePath(double d, double d1)
        throws IOException;

    public abstract void flush()
        throws IOException;

    public abstract boolean addPath(Shape shape)
        throws IOException;

    public abstract boolean addPath(Shape shape, AffineTransform affinetransform)
        throws IOException;
}
