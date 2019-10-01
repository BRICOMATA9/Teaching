// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface TransformListHandler
{

    public abstract void startTransformList()
        throws ParseException;

    public abstract void matrix(float f, float f1, float f2, float f3, float f4, float f5)
        throws ParseException;

    public abstract void rotate(float f)
        throws ParseException;

    public abstract void rotate(float f, float f1, float f2)
        throws ParseException;

    public abstract void translate(float f)
        throws ParseException;

    public abstract void translate(float f, float f1)
        throws ParseException;

    public abstract void scale(float f)
        throws ParseException;

    public abstract void scale(float f, float f1)
        throws ParseException;

    public abstract void skewX(float f)
        throws ParseException;

    public abstract void skewY(float f)
        throws ParseException;

    public abstract void endTransformList()
        throws ParseException;
}
