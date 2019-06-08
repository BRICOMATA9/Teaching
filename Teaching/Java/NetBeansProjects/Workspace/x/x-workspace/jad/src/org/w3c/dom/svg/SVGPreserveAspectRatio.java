// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGPreserveAspectRatio
{

    public abstract short getAlign();

    public abstract void setAlign(short word0)
        throws DOMException;

    public abstract short getMeetOrSlice();

    public abstract void setMeetOrSlice(short word0)
        throws DOMException;

    public static final short SVG_PRESERVEASPECTRATIO_UNKNOWN = 0;
    public static final short SVG_PRESERVEASPECTRATIO_NONE = 1;
    public static final short SVG_PRESERVEASPECTRATIO_XMINYMIN = 2;
    public static final short SVG_PRESERVEASPECTRATIO_XMIDYMIN = 3;
    public static final short SVG_PRESERVEASPECTRATIO_XMAXYMIN = 4;
    public static final short SVG_PRESERVEASPECTRATIO_XMINYMID = 5;
    public static final short SVG_PRESERVEASPECTRATIO_XMIDYMID = 6;
    public static final short SVG_PRESERVEASPECTRATIO_XMAXYMID = 7;
    public static final short SVG_PRESERVEASPECTRATIO_XMINYMAX = 8;
    public static final short SVG_PRESERVEASPECTRATIO_XMIDYMAX = 9;
    public static final short SVG_PRESERVEASPECTRATIO_XMAXYMAX = 10;
    public static final short SVG_MEETORSLICE_UNKNOWN = 0;
    public static final short SVG_MEETORSLICE_MEET = 1;
    public static final short SVG_MEETORSLICE_SLICE = 2;
}
