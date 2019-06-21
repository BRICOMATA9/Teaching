// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedEnumeration

public interface SVGFEBlendElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedString getIn2();

    public abstract SVGAnimatedEnumeration getMode();

    public static final short SVG_FEBLEND_MODE_UNKNOWN = 0;
    public static final short SVG_FEBLEND_MODE_NORMAL = 1;
    public static final short SVG_FEBLEND_MODE_MULTIPLY = 2;
    public static final short SVG_FEBLEND_MODE_SCREEN = 3;
    public static final short SVG_FEBLEND_MODE_DARKEN = 4;
    public static final short SVG_FEBLEND_MODE_LIGHTEN = 5;
}
