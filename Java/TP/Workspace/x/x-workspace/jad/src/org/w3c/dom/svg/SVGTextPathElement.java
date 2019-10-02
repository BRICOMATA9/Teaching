// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGTextContentElement, SVGURIReference, SVGAnimatedLength, SVGAnimatedEnumeration

public interface SVGTextPathElement
    extends SVGTextContentElement, SVGURIReference
{

    public abstract SVGAnimatedLength getStartOffset();

    public abstract SVGAnimatedEnumeration getMethod();

    public abstract SVGAnimatedEnumeration getSpacing();

    public static final short TEXTPATH_METHODTYPE_UNKNOWN = 0;
    public static final short TEXTPATH_METHODTYPE_ALIGN = 1;
    public static final short TEXTPATH_METHODTYPE_STRETCH = 2;
    public static final short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
    public static final short TEXTPATH_SPACINGTYPE_AUTO = 1;
    public static final short TEXTPATH_SPACINGTYPE_EXACT = 2;
}
