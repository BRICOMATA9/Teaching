// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface LengthHandler
{

    public abstract void startLength()
        throws ParseException;

    public abstract void lengthValue(float f)
        throws ParseException;

    public abstract void em()
        throws ParseException;

    public abstract void ex()
        throws ParseException;

    public abstract void in()
        throws ParseException;

    public abstract void cm()
        throws ParseException;

    public abstract void mm()
        throws ParseException;

    public abstract void pc()
        throws ParseException;

    public abstract void pt()
        throws ParseException;

    public abstract void px()
        throws ParseException;

    public abstract void percentage()
        throws ParseException;

    public abstract void endLength()
        throws ParseException;
}
