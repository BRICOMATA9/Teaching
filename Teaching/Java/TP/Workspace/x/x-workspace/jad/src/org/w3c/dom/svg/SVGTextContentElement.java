// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGAnimatedLength, SVGAnimatedEnumeration, SVGPoint, 
//            SVGRect

public interface SVGTextContentElement
    extends SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, EventTarget
{

    public abstract SVGAnimatedLength getTextLength();

    public abstract SVGAnimatedEnumeration getLengthAdjust();

    public abstract int getNumberOfChars();

    public abstract float getComputedTextLength();

    public abstract float getSubStringLength(int i, int j)
        throws DOMException;

    public abstract SVGPoint getStartPositionOfChar(int i)
        throws DOMException;

    public abstract SVGPoint getEndPositionOfChar(int i)
        throws DOMException;

    public abstract SVGRect getExtentOfChar(int i)
        throws DOMException;

    public abstract float getRotationOfChar(int i)
        throws DOMException;

    public abstract int getCharNumAtPosition(SVGPoint svgpoint);

    public abstract void selectSubString(int i, int j)
        throws DOMException;

    public static final short LENGTHADJUST_UNKNOWN = 0;
    public static final short LENGTHADJUST_SPACING = 1;
    public static final short LENGTHADJUST_SPACINGANDGLYPHS = 2;
}
