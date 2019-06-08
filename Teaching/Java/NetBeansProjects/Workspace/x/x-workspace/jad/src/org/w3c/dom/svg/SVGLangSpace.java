// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLangSpace
{

    public abstract String getXMLlang();

    public abstract void setXMLlang(String s)
        throws DOMException;

    public abstract String getXMLspace();

    public abstract void setXMLspace(String s)
        throws DOMException;
}
