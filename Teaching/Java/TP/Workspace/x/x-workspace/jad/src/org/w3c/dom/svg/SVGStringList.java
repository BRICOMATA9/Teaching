// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException

public interface SVGStringList
{

    public abstract int getNumberOfItems();

    public abstract void clear()
        throws DOMException;

    public abstract String initialize(String s)
        throws DOMException, SVGException;

    public abstract String getItem(int i)
        throws DOMException;

    public abstract String insertItemBefore(String s, int i)
        throws DOMException, SVGException;

    public abstract String replaceItem(String s, int i)
        throws DOMException, SVGException;

    public abstract String removeItem(int i)
        throws DOMException;

    public abstract String appendItem(String s)
        throws DOMException, SVGException;
}
