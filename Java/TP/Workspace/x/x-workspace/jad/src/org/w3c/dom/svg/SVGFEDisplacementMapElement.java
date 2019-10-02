// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedNumber, 
//            SVGAnimatedEnumeration

public interface SVGFEDisplacementMapElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedString getIn2();

    public abstract SVGAnimatedNumber getScale();

    public abstract SVGAnimatedEnumeration getXChannelSelector();

    public abstract SVGAnimatedEnumeration getYChannelSelector();

    public static final short SVG_CHANNEL_UNKNOWN = 0;
    public static final short SVG_CHANNEL_R = 1;
    public static final short SVG_CHANNEL_G = 2;
    public static final short SVG_CHANNEL_B = 3;
    public static final short SVG_CHANNEL_A = 4;
}
