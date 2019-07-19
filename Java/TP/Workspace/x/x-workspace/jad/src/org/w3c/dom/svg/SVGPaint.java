// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


// Referenced classes of package org.w3c.dom.svg:
//            SVGColor, SVGException

public interface SVGPaint
    extends SVGColor
{

    public abstract short getPaintType();

    public abstract String getUri();

    public abstract void setUri(String s);

    public abstract void setPaint(short word0, String s, String s1, String s2)
        throws SVGException;

    public static final short SVG_PAINTTYPE_UNKNOWN = 0;
    public static final short SVG_PAINTTYPE_RGBCOLOR = 1;
    public static final short SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR = 2;
    public static final short SVG_PAINTTYPE_NONE = 101;
    public static final short SVG_PAINTTYPE_CURRENTCOLOR = 102;
    public static final short SVG_PAINTTYPE_URI_NONE = 103;
    public static final short SVG_PAINTTYPE_URI_CURRENTCOLOR = 104;
    public static final short SVG_PAINTTYPE_URI_RGBCOLOR = 105;
    public static final short SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR = 106;
    public static final short SVG_PAINTTYPE_URI = 107;
}
