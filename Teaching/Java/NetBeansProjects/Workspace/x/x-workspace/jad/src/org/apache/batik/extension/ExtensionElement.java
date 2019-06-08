// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.extension;

import org.apache.batik.dom.AbstractDocument;
import org.apache.batik.dom.svg.SVGOMElement;

public abstract class ExtensionElement extends SVGOMElement
{

    protected ExtensionElement()
    {
    }

    protected ExtensionElement(String s, AbstractDocument abstractdocument)
    {
        super(s, abstractdocument);
    }

    public boolean isReadonly()
    {
        return false;
    }

    public void setReadonly(boolean flag)
    {
    }
}
