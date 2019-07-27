// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGNumberList

public interface SVGICCColor
{

    public abstract String getColorProfile();

    public abstract void setColorProfile(String s)
        throws DOMException;

    public abstract SVGNumberList getColors();
}
