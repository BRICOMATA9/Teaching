// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGPoint

public interface SVGPointList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract SVGPoint initialize(SVGPoint svgpoint)
        throws DOMException, SVGException;

    public abstract SVGPoint getItem(int i)
        throws DOMException;

    public abstract SVGPoint insertItemBefore(SVGPoint svgpoint, int i)
        throws DOMException, SVGException;

    public abstract SVGPoint replaceItem(SVGPoint svgpoint, int i)
        throws DOMException, SVGException;

    public abstract SVGPoint removeItem(int i)
        throws DOMException;

    public abstract SVGPoint appendItem(SVGPoint svgpoint)
        throws DOMException, SVGException;
}
