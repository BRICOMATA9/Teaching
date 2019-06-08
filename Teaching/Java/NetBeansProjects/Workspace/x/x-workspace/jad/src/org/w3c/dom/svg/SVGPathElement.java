// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGTransformable, SVGAnimatedPathData, SVGAnimatedNumber, 
//            SVGPoint, SVGPathSegClosePath, SVGPathSegMovetoAbs, SVGPathSegMovetoRel, 
//            SVGPathSegLinetoAbs, SVGPathSegLinetoRel, SVGPathSegCurvetoCubicAbs, SVGPathSegCurvetoCubicRel, 
//            SVGPathSegCurvetoQuadraticAbs, SVGPathSegCurvetoQuadraticRel, SVGPathSegArcAbs, SVGPathSegArcRel, 
//            SVGPathSegLinetoHorizontalAbs, SVGPathSegLinetoHorizontalRel, SVGPathSegLinetoVerticalAbs, SVGPathSegLinetoVerticalRel, 
//            SVGPathSegCurvetoCubicSmoothAbs, SVGPathSegCurvetoCubicSmoothRel, SVGPathSegCurvetoQuadraticSmoothAbs, SVGPathSegCurvetoQuadraticSmoothRel

public interface SVGPathElement
    extends SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGTransformable, EventTarget, SVGAnimatedPathData
{

    public abstract SVGAnimatedNumber getPathLength();

    public abstract float getTotalLength();

    public abstract SVGPoint getPointAtLength(float f);

    public abstract int getPathSegAtLength(float f);

    public abstract SVGPathSegClosePath createSVGPathSegClosePath();

    public abstract SVGPathSegMovetoAbs createSVGPathSegMovetoAbs(float f, float f1);

    public abstract SVGPathSegMovetoRel createSVGPathSegMovetoRel(float f, float f1);

    public abstract SVGPathSegLinetoAbs createSVGPathSegLinetoAbs(float f, float f1);

    public abstract SVGPathSegLinetoRel createSVGPathSegLinetoRel(float f, float f1);

    public abstract SVGPathSegCurvetoCubicAbs createSVGPathSegCurvetoCubicAbs(float f, float f1, float f2, float f3, float f4, float f5);

    public abstract SVGPathSegCurvetoCubicRel createSVGPathSegCurvetoCubicRel(float f, float f1, float f2, float f3, float f4, float f5);

    public abstract SVGPathSegCurvetoQuadraticAbs createSVGPathSegCurvetoQuadraticAbs(float f, float f1, float f2, float f3);

    public abstract SVGPathSegCurvetoQuadraticRel createSVGPathSegCurvetoQuadraticRel(float f, float f1, float f2, float f3);

    public abstract SVGPathSegArcAbs createSVGPathSegArcAbs(float f, float f1, float f2, float f3, float f4, boolean flag, boolean flag1);

    public abstract SVGPathSegArcRel createSVGPathSegArcRel(float f, float f1, float f2, float f3, float f4, boolean flag, boolean flag1);

    public abstract SVGPathSegLinetoHorizontalAbs createSVGPathSegLinetoHorizontalAbs(float f);

    public abstract SVGPathSegLinetoHorizontalRel createSVGPathSegLinetoHorizontalRel(float f);

    public abstract SVGPathSegLinetoVerticalAbs createSVGPathSegLinetoVerticalAbs(float f);

    public abstract SVGPathSegLinetoVerticalRel createSVGPathSegLinetoVerticalRel(float f);

    public abstract SVGPathSegCurvetoCubicSmoothAbs createSVGPathSegCurvetoCubicSmoothAbs(float f, float f1, float f2, float f3);

    public abstract SVGPathSegCurvetoCubicSmoothRel createSVGPathSegCurvetoCubicSmoothRel(float f, float f1, float f2, float f3);

    public abstract SVGPathSegCurvetoQuadraticSmoothAbs createSVGPathSegCurvetoQuadraticSmoothAbs(float f, float f1);

    public abstract SVGPathSegCurvetoQuadraticSmoothRel createSVGPathSegCurvetoQuadraticSmoothRel(float f, float f1);
}
