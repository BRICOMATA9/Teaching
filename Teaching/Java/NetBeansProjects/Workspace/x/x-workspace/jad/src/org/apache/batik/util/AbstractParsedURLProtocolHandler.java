// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;


// Referenced classes of package org.apache.batik.util:
//            ParsedURLProtocolHandler

public abstract class AbstractParsedURLProtocolHandler
    implements ParsedURLProtocolHandler
{

    public AbstractParsedURLProtocolHandler(String s)
    {
        protocol = s;
    }

    public String getProtocolHandled()
    {
        return protocol;
    }

    protected String protocol;
}
