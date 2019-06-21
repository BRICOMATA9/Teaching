// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGStringList

public interface SVGTests
{

    public abstract SVGStringList getRequiredFeatures();

    public abstract SVGStringList getRequiredExtensions();

    public abstract SVGStringList getSystemLanguage();

    public abstract boolean hasExtension(String s);
}
