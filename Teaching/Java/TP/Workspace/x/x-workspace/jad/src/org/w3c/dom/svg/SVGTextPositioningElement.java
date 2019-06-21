// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGTextContentElement, SVGAnimatedLengthList, SVGAnimatedNumberList

public interface SVGTextPositioningElement
    extends SVGTextContentElement
{

    public abstract SVGAnimatedLengthList getX();

    public abstract SVGAnimatedLengthList getY();

    public abstract SVGAnimatedLengthList getDx();

    public abstract SVGAnimatedLengthList getDy();

    public abstract SVGAnimatedNumberList getRotate();
}
