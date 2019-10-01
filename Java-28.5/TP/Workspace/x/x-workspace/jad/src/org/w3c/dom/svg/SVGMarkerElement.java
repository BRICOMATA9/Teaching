// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, 
//            SVGFitToViewBox, SVGAnimatedLength, SVGAnimatedEnumeration, SVGAnimatedAngle, 
//            SVGAngle

public interface SVGMarkerElement
    extends SVGElement, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGFitToViewBox
{

    public abstract SVGAnimatedLength getRefX();

    public abstract SVGAnimatedLength getRefY();

    public abstract SVGAnimatedEnumeration getMarkerUnits();

    public abstract SVGAnimatedLength getMarkerWidth();

    public abstract SVGAnimatedLength getMarkerHeight();

    public abstract SVGAnimatedEnumeration getOrientType();

    public abstract SVGAnimatedAngle getOrientAngle();

    public abstract void setOrientToAuto();

    public abstract void setOrientToAngle(SVGAngle svgangle);

    public static final short SVG_MARKERUNITS_UNKNOWN = 0;
    public static final short SVG_MARKERUNITS_USERSPACEONUSE = 1;
    public static final short SVG_MARKERUNITS_STROKEWIDTH = 2;
    public static final short SVG_MARKER_ORIENT_UNKNOWN = 0;
    public static final short SVG_MARKER_ORIENT_AUTO = 1;
    public static final short SVG_MARKER_ORIENT_ANGLE = 2;
}
