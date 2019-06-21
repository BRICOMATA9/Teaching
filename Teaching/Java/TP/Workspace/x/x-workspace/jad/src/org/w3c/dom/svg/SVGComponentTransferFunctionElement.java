// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGAnimatedEnumeration, SVGAnimatedNumberList, SVGAnimatedNumber

public interface SVGComponentTransferFunctionElement
    extends SVGElement
{

    public abstract SVGAnimatedEnumeration getType();

    public abstract SVGAnimatedNumberList getTableValues();

    public abstract SVGAnimatedNumber getSlope();

    public abstract SVGAnimatedNumber getIntercept();

    public abstract SVGAnimatedNumber getAmplitude();

    public abstract SVGAnimatedNumber getExponent();

    public abstract SVGAnimatedNumber getOffset();

    public static final short SVG_FECOMPONENTTRANSFER_TYPE_UNKNOWN = 0;
    public static final short SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY = 1;
    public static final short SVG_FECOMPONENTTRANSFER_TYPE_TABLE = 2;
    public static final short SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE = 3;
    public static final short SVG_FECOMPONENTTRANSFER_TYPE_LINEAR = 4;
    public static final short SVG_FECOMPONENTTRANSFER_TYPE_GAMMA = 5;
}
