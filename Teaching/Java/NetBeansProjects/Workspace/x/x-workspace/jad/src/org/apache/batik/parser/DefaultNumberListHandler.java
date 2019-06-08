// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            NumberListHandler, ParseException

public class DefaultNumberListHandler
    implements NumberListHandler
{

    protected DefaultNumberListHandler()
    {
    }

    public void startNumberList()
        throws ParseException
    {
    }

    public void endNumberList()
        throws ParseException
    {
    }

    public void startNumber()
        throws ParseException
    {
    }

    public void numberValue(float f)
        throws ParseException
    {
    }

    public void endNumber()
        throws ParseException
    {
    }

    public static final NumberListHandler INSTANCE = new DefaultNumberListHandler();

}
