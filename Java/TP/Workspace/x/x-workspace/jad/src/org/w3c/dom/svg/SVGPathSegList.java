// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGPathSeg

public interface SVGPathSegList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract SVGPathSeg initialize(SVGPathSeg svgpathseg)
        throws DOMException, SVGException;

    public abstract SVGPathSeg getItem(int i)
        throws DOMException;

    public abstract SVGPathSeg insertItemBefore(SVGPathSeg svgpathseg, int i)
        throws DOMException, SVGException;

    public abstract SVGPathSeg replaceItem(SVGPathSeg svgpathseg, int i)
        throws DOMException, SVGException;

    public abstract SVGPathSeg removeItem(int i)
        throws DOMException;

    public abstract SVGPathSeg appendItem(SVGPathSeg svgpathseg)
        throws DOMException, SVGException;
}
