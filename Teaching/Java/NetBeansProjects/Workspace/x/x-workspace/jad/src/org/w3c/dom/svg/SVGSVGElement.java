// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.*;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGLocatable, SVGFitToViewBox, SVGZoomAndPan, 
//            SVGAnimatedLength, SVGRect, SVGViewSpec, SVGPoint, 
//            SVGNumber, SVGLength, SVGAngle, SVGMatrix, 
//            SVGTransform

public interface SVGSVGElement
    extends SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGLocatable, SVGFitToViewBox, SVGZoomAndPan, EventTarget, DocumentEvent, ViewCSS, DocumentCSS
{

    public abstract SVGAnimatedLength getX();

    public abstract SVGAnimatedLength getY();

    public abstract SVGAnimatedLength getWidth();

    public abstract SVGAnimatedLength getHeight();

    public abstract String getContentScriptType();

    public abstract void setContentScriptType(String s)
        throws DOMException;

    public abstract String getContentStyleType();

    public abstract void setContentStyleType(String s)
        throws DOMException;

    public abstract SVGRect getViewport();

    public abstract float getPixelUnitToMillimeterX();

    public abstract float getPixelUnitToMillimeterY();

    public abstract float getScreenPixelToMillimeterX();

    public abstract float getScreenPixelToMillimeterY();

    public abstract boolean getUseCurrentView();

    public abstract void setUseCurrentView(boolean flag)
        throws DOMException;

    public abstract SVGViewSpec getCurrentView();

    public abstract float getCurrentScale();

    public abstract void setCurrentScale(float f)
        throws DOMException;

    public abstract SVGPoint getCurrentTranslate();

    public abstract int suspendRedraw(int i);

    public abstract void unsuspendRedraw(int i)
        throws DOMException;

    public abstract void unsuspendRedrawAll();

    public abstract void forceRedraw();

    public abstract void pauseAnimations();

    public abstract void unpauseAnimations();

    public abstract boolean animationsPaused();

    public abstract float getCurrentTime();

    public abstract void setCurrentTime(float f);

    public abstract NodeList getIntersectionList(SVGRect svgrect, SVGElement svgelement);

    public abstract NodeList getEnclosureList(SVGRect svgrect, SVGElement svgelement);

    public abstract boolean checkIntersection(SVGElement svgelement, SVGRect svgrect);

    public abstract boolean checkEnclosure(SVGElement svgelement, SVGRect svgrect);

    public abstract void deselectAll();

    public abstract SVGNumber createSVGNumber();

    public abstract SVGLength createSVGLength();

    public abstract SVGAngle createSVGAngle();

    public abstract SVGPoint createSVGPoint();

    public abstract SVGMatrix createSVGMatrix();

    public abstract SVGRect createSVGRect();

    public abstract SVGTransform createSVGTransform();

    public abstract SVGTransform createSVGTransformFromMatrix(SVGMatrix svgmatrix);

    public abstract Element getElementById(String s);
}
