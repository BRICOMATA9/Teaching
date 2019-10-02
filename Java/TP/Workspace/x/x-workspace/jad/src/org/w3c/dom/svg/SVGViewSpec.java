// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGZoomAndPan, SVGFitToViewBox, SVGTransformList, SVGElement

public interface SVGViewSpec
    extends SVGZoomAndPan, SVGFitToViewBox
{

    public abstract SVGTransformList getTransform();

    public abstract SVGElement getViewTarget();

    public abstract String getViewBoxString();

    public abstract String getPreserveAspectRatioString();

    public abstract String getTransformString();

    public abstract String getViewTargetString();
}
