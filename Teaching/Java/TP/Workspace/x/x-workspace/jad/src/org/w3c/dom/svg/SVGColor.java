// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;

// Referenced classes of package org.w3c.dom.svg:
//            SVGException, SVGICCColor

public interface SVGColor
    extends CSSValue
{

    public abstract short getColorType();

    public abstract RGBColor getRGBColor();

    public abstract SVGICCColor getICCColor();

    public abstract void setRGBColor(String s)
        throws SVGException;

    public abstract void setRGBColorICCColor(String s, String s1)
        throws SVGException;

    public abstract void setColor(short word0, String s, String s1)
        throws SVGException;

    public static final short SVG_COLORTYPE_UNKNOWN = 0;
    public static final short SVG_COLORTYPE_RGBCOLOR = 1;
    public static final short SVG_COLORTYPE_RGBCOLOR_ICCCOLOR = 2;
    public static final short SVG_COLORTYPE_CURRENTCOLOR = 3;
}
