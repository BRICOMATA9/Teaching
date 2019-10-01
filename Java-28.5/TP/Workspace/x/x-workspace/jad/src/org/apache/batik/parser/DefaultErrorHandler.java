// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ErrorHandler, ParseException

public class DefaultErrorHandler
    implements ErrorHandler
{

    public DefaultErrorHandler()
    {
    }

    public void error(ParseException parseexception)
        throws ParseException
    {
        throw parseexception;
    }
}
