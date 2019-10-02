// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedEnumeration, 
//            SVGAnimatedLength

public interface SVGFEMorphologyElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedEnumeration getOperator();

    public abstract SVGAnimatedLength getRadiusX();

    public abstract SVGAnimatedLength getRadiusY();

    public static final short SVG_MORPHOLOGY_OPERATOR_UNKNOWN = 0;
    public static final short SVG_MORPHOLOGY_OPERATOR_ERODE = 1;
    public static final short SVG_MORPHOLOGY_OPERATOR_DILATE = 2;
}
