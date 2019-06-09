// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface AngleHandler
{

    public abstract void startAngle()
        throws ParseException;

    public abstract void angleValue(float f)
        throws ParseException;

    public abstract void deg()
        throws ParseException;

    public abstract void grad()
        throws ParseException;

    public abstract void rad()
        throws ParseException;

    public abstract void endAngle()
        throws ParseException;
}
