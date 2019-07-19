// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

// Referenced classes of package org.w3c.dom.svg:
//            SVGSVGElement

public interface SVGElement
    extends Element
{

    public abstract String getId();

    public abstract void setId(String s)
        throws DOMException;

    public abstract String getXMLbase();

    public abstract void setXMLbase(String s)
        throws DOMException;

    public abstract SVGSVGElement getOwnerSVGElement();

    public abstract SVGElement getViewportElement();
}
