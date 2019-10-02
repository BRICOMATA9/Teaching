// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            LengthHandler, ParseException

public class DefaultLengthHandler
    implements LengthHandler
{

    protected DefaultLengthHandler()
    {
    }

    public void startLength()
        throws ParseException
    {
    }

    public void lengthValue(float f)
        throws ParseException
    {
    }

    public void em()
        throws ParseException
    {
    }

    public void ex()
        throws ParseException
    {
    }

    public void in()
        throws ParseException
    {
    }

    public void cm()
        throws ParseException
    {
    }

    public void mm()
        throws ParseException
    {
    }

    public void pc()
        throws ParseException
    {
    }

    public void pt()
        throws ParseException
    {
    }

    public void px()
        throws ParseException
    {
    }

    public void percentage()
        throws ParseException
    {
    }

    public void endLength()
        throws ParseException
    {
    }

    public static final LengthHandler INSTANCE = new DefaultLengthHandler();

}
