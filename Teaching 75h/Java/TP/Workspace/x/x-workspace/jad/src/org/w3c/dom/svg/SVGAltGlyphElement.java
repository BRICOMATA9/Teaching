// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGTextPositioningElement, SVGURIReference

public interface SVGAltGlyphElement
    extends SVGTextPositioningElement, SVGURIReference
{

    public abstract String getGlyphRef();

    public abstract void setGlyphRef(String s)
        throws DOMException;

    public abstract String getFormat();

    public abstract void setFormat(String s)
        throws DOMException;
}
