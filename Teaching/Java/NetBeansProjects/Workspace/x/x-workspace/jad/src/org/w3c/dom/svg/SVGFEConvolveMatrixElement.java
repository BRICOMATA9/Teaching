// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedInteger, SVGAnimatedNumberList, 
//            SVGAnimatedNumber, SVGAnimatedEnumeration, SVGAnimatedLength, SVGAnimatedBoolean

public interface SVGFEConvolveMatrixElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedInteger getOrderX();

    public abstract SVGAnimatedInteger getOrderY();

    public abstract SVGAnimatedNumberList getKernelMatrix();

    public abstract SVGAnimatedNumber getDivisor();

    public abstract SVGAnimatedNumber getBias();

    public abstract SVGAnimatedInteger getTargetX();

    public abstract SVGAnimatedInteger getTargetY();

    public abstract SVGAnimatedEnumeration getEdgeMode();

    public abstract SVGAnimatedLength getKernelUnitLengthX();

    public abstract SVGAnimatedLength getKernelUnitLengthY();

    public abstract SVGAnimatedBoolean getPreserveAlpha();

    public static final short SVG_EDGEMODE_UNKNOWN = 0;
    public static final short SVG_EDGEMODE_DUPLICATE = 1;
    public static final short SVG_EDGEMODE_WRAP = 2;
    public static final short SVG_EDGEMODE_NONE = 3;
}
