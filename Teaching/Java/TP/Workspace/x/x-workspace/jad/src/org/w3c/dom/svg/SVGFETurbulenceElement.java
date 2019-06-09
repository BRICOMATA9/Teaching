// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedNumber, SVGAnimatedInteger, 
//            SVGAnimatedEnumeration

public interface SVGFETurbulenceElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedNumber getBaseFrequencyX();

    public abstract SVGAnimatedNumber getBaseFrequencyY();

    public abstract SVGAnimatedInteger getNumOctaves();

    public abstract SVGAnimatedNumber getSeed();

    public abstract SVGAnimatedEnumeration getStitchTiles();

    public abstract SVGAnimatedEnumeration getType();

    public static final short SVG_TURBULENCE_TYPE_UNKNOWN = 0;
    public static final short SVG_TURBULENCE_TYPE_FRACTALNOISE = 1;
    public static final short SVG_TURBULENCE_TYPE_TURBULENCE = 2;
    public static final short SVG_STITCHTYPE_UNKNOWN = 0;
    public static final short SVG_STITCHTYPE_STITCH = 1;
    public static final short SVG_STITCHTYPE_NOSTITCH = 2;
}
