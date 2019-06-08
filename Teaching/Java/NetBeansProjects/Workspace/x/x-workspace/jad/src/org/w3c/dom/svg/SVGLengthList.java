// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGLength

public interface SVGLengthList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract SVGLength initialize(SVGLength svglength)
        throws DOMException, SVGException;

    public abstract SVGLength getItem(int i)
        throws DOMException;

    public abstract SVGLength insertItemBefore(SVGLength svglength, int i)
        throws DOMException, SVGException;

    public abstract SVGLength replaceItem(SVGLength svglength, int i)
        throws DOMException, SVGException;

    public abstract SVGLength removeItem(int i)
        throws DOMException;

    public abstract SVGLength appendItem(SVGLength svglength)
        throws DOMException, SVGException;
}
