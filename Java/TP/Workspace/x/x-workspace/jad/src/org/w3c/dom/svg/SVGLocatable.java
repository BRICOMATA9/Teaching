// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGElement, SVGRect, SVGMatrix

public interface SVGLocatable
{

    public abstract SVGElement getNearestViewportElement();

    public abstract SVGElement getFarthestViewportElement();

    public abstract SVGRect getBBox();

    public abstract SVGMatrix getCTM();

    public abstract SVGMatrix getScreenCTM();

    public abstract SVGMatrix getTransformToElement(SVGElement svgelement)
        throws SVGException;
}
