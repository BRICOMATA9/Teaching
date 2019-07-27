// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            DefaultLengthHandler, LengthListHandler, ParseException

public class DefaultLengthListHandler extends DefaultLengthHandler
    implements LengthListHandler
{

    protected DefaultLengthListHandler()
    {
    }

    public void startLengthList()
        throws ParseException
    {
    }

    public void endLengthList()
        throws ParseException
    {
    }

    public static final LengthListHandler INSTANCE = new DefaultLengthListHandler();

}
