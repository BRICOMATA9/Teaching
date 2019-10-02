// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedEnumeration, 
//            SVGAnimatedNumber

public interface SVGFECompositeElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedString getIn2();

    public abstract SVGAnimatedEnumeration getOperator();

    public abstract SVGAnimatedNumber getK1();

    public abstract SVGAnimatedNumber getK2();

    public abstract SVGAnimatedNumber getK3();

    public abstract SVGAnimatedNumber getK4();

    public static final short SVG_FECOMPOSITE_OPERATOR_UNKNOWN = 0;
    public static final short SVG_FECOMPOSITE_OPERATOR_OVER = 1;
    public static final short SVG_FECOMPOSITE_OPERATOR_IN = 2;
    public static final short SVG_FECOMPOSITE_OPERATOR_OUT = 3;
    public static final short SVG_FECOMPOSITE_OPERATOR_ATOP = 4;
    public static final short SVG_FECOMPOSITE_OPERATOR_XOR = 5;
    public static final short SVG_FECOMPOSITE_OPERATOR_ARITHMETIC = 6;
}
