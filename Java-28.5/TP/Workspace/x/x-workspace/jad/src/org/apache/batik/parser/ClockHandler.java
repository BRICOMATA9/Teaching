// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface ClockHandler
{

    public abstract void startClock()
        throws ParseException;

    public abstract void intValue(int i)
        throws ParseException;

    public abstract void colon()
        throws ParseException;

    public abstract void dot()
        throws ParseException;

    public abstract void h()
        throws ParseException;

    public abstract void min()
        throws ParseException;

    public abstract void s()
        throws ParseException;

    public abstract void ms()
        throws ParseException;

    public abstract void endClock()
        throws ParseException;
}
