// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGUnitTypes, SVGAnimatedEnumeration, SVGAnimatedLength

public interface SVGMaskElement
    extends SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGUnitTypes
{

    public abstract SVGAnimatedEnumeration getMaskUnits();

    public abstract SVGAnimatedEnumeration getMaskContentUnits();

    public abstract SVGAnimatedLength getX();

    public abstract SVGAnimatedLength getY();

    public abstract SVGAnimatedLength getWidth();

    public abstract SVGAnimatedLength getHeight();
}
