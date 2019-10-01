// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGURIReference, SVGStylable

public interface SVGGlyphRefElement
    extends SVGElement, SVGURIReference, SVGStylable
{

    public abstract String getGlyphRef();

    public abstract void setGlyphRef(String s)
        throws DOMException;

    public abstract String getFormat();

    public abstract void setFormat(String s)
        throws DOMException;

    public abstract float getX();

    public abstract void setX(float f)
        throws DOMException;

    public abstract float getY();

    public abstract void setY(float f)
        throws DOMException;

    public abstract float getDx();

    public abstract void setDx(float f)
        throws DOMException;

    public abstract float getDy();

    public abstract void setDy(float f)
        throws DOMException;
}
