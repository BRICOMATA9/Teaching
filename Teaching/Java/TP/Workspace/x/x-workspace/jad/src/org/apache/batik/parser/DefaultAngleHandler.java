// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            AngleHandler, ParseException

public class DefaultAngleHandler
    implements AngleHandler
{

    protected DefaultAngleHandler()
    {
    }

    public void startAngle()
        throws ParseException
    {
    }

    public void angleValue(float f)
        throws ParseException
    {
    }

    public void deg()
        throws ParseException
    {
    }

    public void grad()
        throws ParseException
    {
    }

    public void rad()
        throws ParseException
    {
    }

    public void endAngle()
        throws ParseException
    {
    }

    public static final AngleHandler INSTANCE = new DefaultAngleHandler();

}
