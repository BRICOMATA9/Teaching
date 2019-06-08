// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.freehep.graphicsio;

import java.io.IOException;
import java.util.Vector;

// Referenced classes of package org.freehep.graphicsio:
//            CubicToLinePathConstructor

public abstract class PolylinePathConstructor extends CubicToLinePathConstructor
{

    public PolylinePathConstructor(boolean flag)
    {
        this(flag, 0.025000000000000001D);
    }

    public PolylinePathConstructor(boolean flag, double d)
    {
        super(d);
        closed = false;
        fill = flag;
    }

    public void move(double d, double d1)
        throws IOException
    {
        writePolyline();
        polyline = new Vector();
        polyline.add(new java.awt.geom.Point2D.Double(d, d1));
        super.move(d, d1);
    }

    public void line(double d, double d1)
        throws IOException
    {
        polyline.add(new java.awt.geom.Point2D.Double(d, d1));
        super.line(d, d1);
    }

    public void closePath(double d, double d1)
        throws IOException
    {
        closed = true;
        writePolyline();
        super.closePath(d, d1);
    }

    public void writePolyline()
        throws IOException
    {
        if(polyline != null)
            writePolyline(polyline);
        closed = false;
        polyline = null;
    }

    protected abstract void writePolyline(Vector vector)
        throws IOException;

    private Vector polyline;
    protected boolean closed;
    protected boolean fill;
}
