// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGURIReference, SVGExternalResourcesRequired, SVGStylable, 
//            SVGUnitTypes, SVGAnimatedEnumeration, SVGAnimatedTransformList

public interface SVGGradientElement
    extends SVGElement, SVGURIReference, SVGExternalResourcesRequired, SVGStylable, SVGUnitTypes
{

    public abstract SVGAnimatedEnumeration getGradientUnits();

    public abstract SVGAnimatedTransformList getGradientTransform();

    public abstract SVGAnimatedEnumeration getSpreadMethod();

    public static final short SVG_SPREADMETHOD_UNKNOWN = 0;
    public static final short SVG_SPREADMETHOD_PAD = 1;
    public static final short SVG_SPREADMETHOD_REFLECT = 2;
    public static final short SVG_SPREADMETHOD_REPEAT = 3;
}
