// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGNumber

public interface SVGNumberList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract SVGNumber initialize(SVGNumber svgnumber)
        throws DOMException, SVGException;

    public abstract SVGNumber getItem(int i)
        throws DOMException;

    public abstract SVGNumber insertItemBefore(SVGNumber svgnumber, int i)
        throws DOMException, SVGException;

    public abstract SVGNumber replaceItem(SVGNumber svgnumber, int i)
        throws DOMException, SVGException;

    public abstract SVGNumber removeItem(int i)
        throws DOMException;

    public abstract SVGNumber appendItem(SVGNumber svgnumber)
        throws DOMException, SVGException;
}
