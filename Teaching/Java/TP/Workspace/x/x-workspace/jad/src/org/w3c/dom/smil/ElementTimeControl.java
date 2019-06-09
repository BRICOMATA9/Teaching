// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.smil;

import org.w3c.dom.DOMException;

public interface ElementTimeControl
{

    public abstract boolean beginElement()
        throws DOMException;

    public abstract boolean beginElementAt(float f)
        throws DOMException;

    public abstract boolean endElement()
        throws DOMException;

    public abstract boolean endElementAt(float f)
        throws DOMException;
}
