// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;


// Referenced classes of package org.apache.batik.util:
//            ParsedURLData, ParsedURL

public interface ParsedURLProtocolHandler
{

    public abstract String getProtocolHandled();

    public abstract ParsedURLData parseURL(String s);

    public abstract ParsedURLData parseURL(ParsedURL parsedurl, String s);
}
