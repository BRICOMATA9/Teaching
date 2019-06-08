// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface PreserveAspectRatioHandler
{

    public abstract void startPreserveAspectRatio()
        throws ParseException;

    public abstract void none()
        throws ParseException;

    public abstract void xMaxYMax()
        throws ParseException;

    public abstract void xMaxYMid()
        throws ParseException;

    public abstract void xMaxYMin()
        throws ParseException;

    public abstract void xMidYMax()
        throws ParseException;

    public abstract void xMidYMid()
        throws ParseException;

    public abstract void xMidYMin()
        throws ParseException;

    public abstract void xMinYMax()
        throws ParseException;

    public abstract void xMinYMid()
        throws ParseException;

    public abstract void xMinYMin()
        throws ParseException;

    public abstract void meet()
        throws ParseException;

    public abstract void slice()
        throws ParseException;

    public abstract void endPreserveAspectRatio()
        throws ParseException;
}
