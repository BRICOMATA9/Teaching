// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package org.apache.batik.util:
//            ParsedURLDefaultProtocolHandler, ParsedURL, ParsedURLData

public class ParsedURLJarProtocolHandler extends ParsedURLDefaultProtocolHandler
{

    public ParsedURLJarProtocolHandler()
    {
        ParsedURLDefaultProtocolHandler("jar");
    }

    public ParsedURLData parseURL(ParsedURL parsedurl, String s)
    {
        String s1 = s.substring(0, "jar".length() + 1).toLowerCase();
        if(s1.equals("jar:"))
            return parseURL(s);
        URL url1;
        URL url = new URL(parsedurl.toString());
        url1 = new URL(url, s);
        return constructParsedURLData(url1);
        MalformedURLException malformedurlexception;
        malformedurlexception;
        return parseURL(parsedurl, s);
    }

    public static final String JAR = "jar";
}
