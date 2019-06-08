// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGZoomAndPan
{

    public abstract short getZoomAndPan();

    public abstract void setZoomAndPan(short word0)
        throws DOMException;

    public static final short SVG_ZOOMANDPAN_UNKNOWN = 0;
    public static final short SVG_ZOOMANDPAN_DISABLE = 1;
    public static final short SVG_ZOOMANDPAN_MAGNIFY = 2;
}
