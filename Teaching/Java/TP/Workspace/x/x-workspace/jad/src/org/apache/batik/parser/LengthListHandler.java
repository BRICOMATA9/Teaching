// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            LengthHandler, ParseException

public interface LengthListHandler
    extends LengthHandler
{

    public abstract void startLengthList()
        throws ParseException;

    public abstract void endLengthList()
        throws ParseException;
}
