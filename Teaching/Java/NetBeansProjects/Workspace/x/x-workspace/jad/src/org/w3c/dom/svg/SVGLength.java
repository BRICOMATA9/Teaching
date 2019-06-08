// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLength
{

    public abstract short getUnitType();

    public abstract float getValue();

    public abstract void setValue(float f)
        throws DOMException;

    public abstract float getValueInSpecifiedUnits();

    public abstract void setValueInSpecifiedUnits(float f)
        throws DOMException;

    public abstract String getValueAsString();

    public abstract void setValueAsString(String s)
        throws DOMException;

    public abstract void newValueSpecifiedUnits(short word0, float f);

    public abstract void convertToSpecifiedUnits(short word0);

    public static final short SVG_LENGTHTYPE_UNKNOWN = 0;
    public static final short SVG_LENGTHTYPE_NUMBER = 1;
    public static final short SVG_LENGTHTYPE_PERCENTAGE = 2;
    public static final short SVG_LENGTHTYPE_EMS = 3;
    public static final short SVG_LENGTHTYPE_EXS = 4;
    public static final short SVG_LENGTHTYPE_PX = 5;
    public static final short SVG_LENGTHTYPE_CM = 6;
    public static final short SVG_LENGTHTYPE_MM = 7;
    public static final short SVG_LENGTHTYPE_IN = 8;
    public static final short SVG_LENGTHTYPE_PT = 9;
    public static final short SVG_LENGTHTYPE_PC = 10;
}
