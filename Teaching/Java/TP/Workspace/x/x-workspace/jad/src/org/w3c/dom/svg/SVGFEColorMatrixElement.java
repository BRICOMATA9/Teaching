// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedEnumeration, 
//            SVGAnimatedNumberList

public interface SVGFEColorMatrixElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedEnumeration getType();

    public abstract SVGAnimatedNumberList getValues();

    public static final short SVG_FECOLORMATRIX_TYPE_UNKNOWN = 0;
    public static final short SVG_FECOLORMATRIX_TYPE_MATRIX = 1;
    public static final short SVG_FECOLORMATRIX_TYPE_SATURATE = 2;
    public static final short SVG_FECOLORMATRIX_TYPE_HUEROTATE = 3;
    public static final short SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA = 4;
}
