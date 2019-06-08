// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGURIReference, SVGExternalResourcesRequired

public interface SVGScriptElement
    extends SVGElement, SVGURIReference, SVGExternalResourcesRequired
{

    public abstract String getType();

    public abstract void setType(String s)
        throws DOMException;
}
