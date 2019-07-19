// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            TransformListHandler, ParseException

public class DefaultTransformListHandler
    implements TransformListHandler
{

    protected DefaultTransformListHandler()
    {
    }

    public void startTransformList()
        throws ParseException
    {
    }

    public void matrix(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException
    {
    }

    public void rotate(float f)
        throws ParseException
    {
    }

    public void rotate(float f, float f1, float f2)
        throws ParseException
    {
    }

    public void translate(float f)
        throws ParseException
    {
    }

    public void translate(float f, float f1)
        throws ParseException
    {
    }

    public void scale(float f)
        throws ParseException
    {
    }

    public void scale(float f, float f1)
        throws ParseException
    {
    }

    public void skewX(float f)
        throws ParseException
    {
    }

    public void skewY(float f)
        throws ParseException
    {
    }

    public void endTransformList()
        throws ParseException
    {
    }

    public static final TransformListHandler INSTANCE = new DefaultTransformListHandler();

}
