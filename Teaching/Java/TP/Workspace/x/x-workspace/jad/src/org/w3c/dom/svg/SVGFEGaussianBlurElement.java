// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGFilterPrimitiveStandardAttributes, SVGAnimatedString, SVGAnimatedNumber

public interface SVGFEGaussianBlurElement
    extends SVGElement, SVGFilterPrimitiveStandardAttributes
{

    public abstract SVGAnimatedString getIn1();

    public abstract SVGAnimatedNumber getStdDeviationX();

    public abstract SVGAnimatedNumber getStdDeviationY();

    public abstract void setStdDeviation(float f, float f1);
}
