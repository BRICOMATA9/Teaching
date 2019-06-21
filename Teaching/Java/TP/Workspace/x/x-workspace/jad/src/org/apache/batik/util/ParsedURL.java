// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import org.apache.batik.Version;

// Referenced classes of package org.apache.batik.util:
//            ParsedURLDataProtocolHandler, ParsedURLJarProtocolHandler, Service, ParsedURLProtocolHandler, 
//            ParsedURLData, ParsedURLDefaultProtocolHandler

public class ParsedURL
{

    public static String getGlobalUserAgent()
    {
        return globalUserAgent;
    }

    public static void setGlobalUserAgent(String s)
    {
        globalUserAgent = s;
    }

    private static synchronized Map getHandlersMap()
    {
        if(handlersMap != null)
            return handlersMap;
        handlersMap = new HashMap();
        registerHandler(new ParsedURLDataProtocolHandler());
        registerHandler(new ParsedURLJarProtocolHandler());
        ParsedURLProtocolHandler parsedurlprotocolhandler;
        for(Iterator iterator = Service.providers(org.apache.batik.util.ParsedURLProtocolHandler.class); iterator.hasNext(); registerHandler(parsedurlprotocolhandler))
            parsedurlprotocolhandler = (ParsedURLProtocolHandler)iterator.next();

        return handlersMap;
    }

    public static synchronized ParsedURLProtocolHandler getHandler(String s)
    {
        if(s == null)
            return defaultHandler;
        Map map = getHandlersMap();
        ParsedURLProtocolHandler parsedurlprotocolhandler = (ParsedURLProtocolHandler)map.get(s);
        if(parsedurlprotocolhandler == null)
            parsedurlprotocolhandler = defaultHandler;
        return parsedurlprotocolhandler;
    }

    public static synchronized void registerHandler(ParsedURLProtocolHandler parsedurlprotocolhandler)
    {
        if(parsedurlprotocolhandler.getProtocolHandled() == null)
        {
            defaultHandler = parsedurlprotocolhandler;
            return;
        } else
        {
            Map map = getHandlersMap();
            map.put(parsedurlprotocolhandler.getProtocolHandled(), parsedurlprotocolhandler);
            return;
        }
    }

    public static InputStream checkGZIP(InputStream inputstream)
        throws IOException
    {
        return ParsedURLData.checkGZIP(inputstream);
    }

    public ParsedURL(String s)
    {
        userAgent = getGlobalUserAgent();
        data = parseURL(s);
    }

    public ParsedURL(URL url)
    {
        userAgent = getGlobalUserAgent();
        data = new ParsedURLData(url);
    }

    public ParsedURL(String s, String s1)
    {
        userAgent = getGlobalUserAgent();
        if(s != null)
            data = parseURL(s, s1);
        else
            data = parseURL(s1);
    }

    public ParsedURL(URL url, String s)
    {
        userAgent = getGlobalUserAgent();
        if(url != null)
            data = parseURL(new ParsedURL(url), s);
        else
            data = parseURL(s);
    }

    public ParsedURL(ParsedURL parsedurl, String s)
    {
        userAgent = parsedurl.getUserAgent();
        if(parsedurl != null)
            data = parseURL(parsedurl, s);
        else
            data = parseURL(s);
    }

    public String toString()
    {
        return data.toString();
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof ParsedURL))
        {
            return false;
        } else
        {
            ParsedURL parsedurl = (ParsedURL)obj;
            return data.equals(parsedurl.data);
        }
    }

    public int hashCode()
    {
        return data.hashCode();
    }

    public boolean complete()
    {
        return data.complete();
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }

    public String getProtocol()
    {
        if(data.protocol == null)
            return null;
        else
            return new String(data.protocol);
    }

    public String getHost()
    {
        if(data.host == null)
            return null;
        else
            return new String(data.host);
    }

    public int getPort()
    {
        return data.port;
    }

    public String getPath()
    {
        if(data.path == null)
            return null;
        else
            return new String(data.path);
    }

    public String getRef()
    {
        if(data.ref == null)
            return null;
        else
            return new String(data.ref);
    }

    public String getPortStr()
    {
        return data.getPortStr();
    }

    public String getContentType()
    {
        return data.getContentType(userAgent);
    }

    public String getContentEncoding()
    {
        return data.getContentEncoding(userAgent);
    }

    public InputStream openStream()
        throws IOException
    {
        return data.openStream(userAgent, null);
    }

    public InputStream openStream(String s)
        throws IOException
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(s);
        return data.openStream(userAgent, arraylist.iterator());
    }

    public InputStream openStream(String as[])
        throws IOException
    {
        ArrayList arraylist = new ArrayList(as.length);
        for(int i = 0; i < as.length; i++)
            arraylist.add(as[i]);

        return data.openStream(userAgent, arraylist.iterator());
    }

    public InputStream openStream(Iterator iterator)
        throws IOException
    {
        return data.openStream(userAgent, iterator);
    }

    public InputStream openStreamRaw()
        throws IOException
    {
        return data.openStreamRaw(userAgent, null);
    }

    public InputStream openStreamRaw(String s)
        throws IOException
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(s);
        return data.openStreamRaw(userAgent, arraylist.iterator());
    }

    public InputStream openStreamRaw(String as[])
        throws IOException
    {
        ArrayList arraylist = new ArrayList(as.length);
        for(int i = 0; i < as.length; i++)
            arraylist.add(as[i]);

        return data.openStreamRaw(userAgent, arraylist.iterator());
    }

    public InputStream openStreamRaw(Iterator iterator)
        throws IOException
    {
        return data.openStreamRaw(userAgent, iterator);
    }

    public boolean sameFile(ParsedURL parsedurl)
    {
        return data.sameFile(parsedurl.data);
    }

    protected static String getProtocol(String s)
    {
        if(s == null)
            return null;
        int i = 0;
        int j = s.length();
        if(j == 0)
            return null;
        char c = s.charAt(i);
        do
        {
            if(c != '-' && c != '+' && c != '.' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                break;
            if(++i == j)
            {
                c = '\0';
                break;
            }
            c = s.charAt(i);
        } while(true);
        if(c == ':')
            return s.substring(0, i).toLowerCase();
        else
            return null;
    }

    public static ParsedURLData parseURL(String s)
    {
        ParsedURLProtocolHandler parsedurlprotocolhandler = getHandler(getProtocol(s));
        return parsedurlprotocolhandler.parseURL(s);
    }

    public static ParsedURLData parseURL(String s, String s1)
    {
        if(s == null)
        {
            return parseURL(s1);
        } else
        {
            ParsedURL parsedurl = new ParsedURL(s);
            return parseURL(parsedurl, s1);
        }
    }

    public static ParsedURLData parseURL(ParsedURL parsedurl, String s)
    {
        if(parsedurl == null)
            return parseURL(s);
        String s1 = getProtocol(s);
        if(s1 == null)
            s1 = parsedurl.getProtocol();
        ParsedURLProtocolHandler parsedurlprotocolhandler = getHandler(s1);
        return parsedurlprotocolhandler.parseURL(parsedurl, s);
    }

    ParsedURLData data;
    String userAgent;
    private static Map handlersMap = null;
    private static ParsedURLProtocolHandler defaultHandler = new ParsedURLDefaultProtocolHandler();
    private static String globalUserAgent = "Batik/" + Version.getVersion();

}
