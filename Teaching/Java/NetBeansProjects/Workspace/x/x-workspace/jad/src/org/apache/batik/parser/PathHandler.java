// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface PathHandler
{

    public abstract void startPath()
        throws ParseException;

    public abstract void endPath()
        throws ParseException;

    public abstract void movetoRel(float f, float f1)
        throws ParseException;

    public abstract void movetoAbs(float f, float f1)
        throws ParseException;

    public abstract void closePath()
        throws ParseException;

    public abstract void linetoRel(float f, float f1)
        throws ParseException;

    public abstract void linetoAbs(float f, float f1)
        throws ParseException;

    public abstract void linetoHorizontalRel(float f)
        throws ParseException;

    public abstract void linetoHorizontalAbs(float f)
        throws ParseException;

    public abstract void linetoVerticalRel(float f)
        throws ParseException;

    public abstract void linetoVerticalAbs(float f)
        throws ParseException;

    public abstract void curvetoCubicRel(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException;

    public abstract void curvetoCubicAbs(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException;

    public abstract void curvetoCubicSmoothRel(float f, float f1, float f2, float f3)
        throws ParseException;

    public abstract void curvetoCubicSmoothAbs(float f, float f1, float f2, float f3)
        throws ParseException;

    public abstract void curvetoQuadraticRel(float f, float f1, float f2, float f3)
        throws ParseException;

    public abstract void curvetoQuadraticAbs(float f, float f1, float f2, float f3)
        throws ParseException;

    public abstract void curvetoQuadraticSmoothRel(float f, float f1)
        throws ParseException;

    public abstract void curvetoQuadraticSmoothAbs(float f, float f1)
        throws ParseException;

    public abstract void arcRel(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException;

    public abstract void arcAbs(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException;
}
