// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;


public abstract class SVGException extends RuntimeException
{

    public SVGException(short word0, String s)
    {
        super(s);
        code = word0;
    }

    public short code;
    public static final short SVG_WRONG_TYPE_ERR = 0;
    public static final short SVG_INVALID_VALUE_ERR = 1;
    public static final short SVG_MATRIX_NOT_INVERTABLE = 2;
}
