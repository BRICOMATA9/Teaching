// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGURIReference, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGUnitTypes, SVGAnimatedEnumeration, SVGAnimatedLength, 
//            SVGAnimatedInteger

public interface SVGFilterElement
    extends SVGElement, SVGURIReference, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGUnitTypes
{

    public abstract SVGAnimatedEnumeration getFilterUnits();

    public abstract SVGAnimatedEnumeration getPrimitiveUnits();

    public abstract SVGAnimatedLength getX();

    public abstract SVGAnimatedLength getY();

    public abstract SVGAnimatedLength getWidth();

    public abstract SVGAnimatedLength getHeight();

    public abstract SVGAnimatedInteger getFilterResX();

    public abstract SVGAnimatedInteger getFilterResY();

    public abstract void setFilterRes(int i, int j);
}
