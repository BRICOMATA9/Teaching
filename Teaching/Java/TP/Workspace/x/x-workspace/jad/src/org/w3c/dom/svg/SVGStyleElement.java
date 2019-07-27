// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement

public interface SVGStyleElement
    extends SVGElement
{

    public abstract String getXMLspace();

    public abstract void setXMLspace(String s)
        throws DOMException;

    public abstract String getType();

    public abstract void setType(String s)
        throws DOMException;

    public abstract String getMedia();

    public abstract void setMedia(String s)
        throws DOMException;

    public abstract String getTitle();

    public abstract void setTitle(String s)
        throws DOMException;
}
