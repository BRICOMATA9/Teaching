// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            PathHandler, ParseException

public class DefaultPathHandler
    implements PathHandler
{

    protected DefaultPathHandler()
    {
    }

    public void startPath()
        throws ParseException
    {
    }

    public void endPath()
        throws ParseException
    {
    }

    public void movetoRel(float f, float f1)
        throws ParseException
    {
    }

    public void movetoAbs(float f, float f1)
        throws ParseException
    {
    }

    public void closePath()
        throws ParseException
    {
    }

    public void linetoRel(float f, float f1)
        throws ParseException
    {
    }

    public void linetoAbs(float f, float f1)
        throws ParseException
    {
    }

    public void linetoHorizontalRel(float f)
        throws ParseException
    {
    }

    public void linetoHorizontalAbs(float f)
        throws ParseException
    {
    }

    public void linetoVerticalRel(float f)
        throws ParseException
    {
    }

    public void linetoVerticalAbs(float f)
        throws ParseException
    {
    }

    public void curvetoCubicRel(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
    }

    public void curvetoCubicAbs(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
    }

    public void curvetoCubicSmoothRel(float f, float f1, float f2, float f3)
        throws ParseException
    {
    }

    public void curvetoCubicSmoothAbs(float f, float f1, float f2, float f3)
        throws ParseException
    {
    }

    public void curvetoQuadraticRel(float f, float f1, float f2, float f3)
        throws ParseException
    {
    }

    public void curvetoQuadraticAbs(float f, float f1, float f2, float f3)
        throws ParseException
    {
    }

    public void curvetoQuadraticSmoothRel(float f, float f1)
        throws ParseException
    {
    }

    public void curvetoQuadraticSmoothAbs(float f, float f1)
        throws ParseException
    {
    }

    public void arcRel(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException
    {
    }

    public void arcAbs(float f, float f1, float f2, boolean flag, boolean flag1, float f3, float f4)
        throws ParseException
    {
    }

    public static final PathHandler INSTANCE = new DefaultPathHandler();

}
