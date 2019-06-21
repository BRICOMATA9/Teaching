// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.*;

public class ParsedURLData
{

    public static InputStream checkGZIP(InputStream inputstream)
        throws IOException
    {
        byte abyte0[];
        if(!inputstream.markSupported())
            inputstream = new BufferedInputStream(inputstream);
        abyte0 = new byte[2];
        try
        {
            inputstream.mark(2);
            inputstream.read(abyte0);
            inputstream.reset();
        }
        catch(Exception exception)
        {
            inputstream.reset();
            return inputstream;
        }
        if(abyte0[0] == GZIP_MAGIC[0] && abyte0[1] == GZIP_MAGIC[1])
            return new GZIPInputStream(inputstream);
        if((abyte0[0] & 0xf) != 8 || abyte0[0] >>> 4 > 7)
            break MISSING_BLOCK_LABEL_188;
        int i = (abyte0[0] & 0xff) * 256 + (abyte0[1] & 0xff);
        if(i % 31 != 0)
            break MISSING_BLOCK_LABEL_188;
        Object obj;
        inputstream.mark(100);
        obj = new InflaterInputStream(inputstream);
        if(!((InputStream) (obj)).markSupported())
            obj = new BufferedInputStream(((InputStream) (obj)));
        ((InputStream) (obj)).mark(2);
        ((InputStream) (obj)).read(abyte0);
        inputstream.reset();
        obj = new InflaterInputStream(inputstream);
        return ((InputStream) (obj));
        ZipException zipexception;
        zipexception;
        inputstream.reset();
        return inputstream;
        return inputstream;
    }

    public ParsedURLData()
    {
        HTTP_USER_AGENT_HEADER = "User-Agent";
        HTTP_ACCEPT_HEADER = "Accept";
        HTTP_ACCEPT_LANGUAGE_HEADER = "Accept-Language";
        HTTP_ACCEPT_ENCODING_HEADER = "Accept-Encoding";
        protocol = null;
        host = null;
        port = -1;
        path = null;
        ref = null;
        contentType = null;
        contentEncoding = null;
        stream = null;
        hasBeenOpened = false;
    }

    public ParsedURLData(URL url)
    {
        HTTP_USER_AGENT_HEADER = "User-Agent";
        HTTP_ACCEPT_HEADER = "Accept";
        HTTP_ACCEPT_LANGUAGE_HEADER = "Accept-Language";
        HTTP_ACCEPT_ENCODING_HEADER = "Accept-Encoding";
        protocol = null;
        host = null;
        port = -1;
        path = null;
        ref = null;
        contentType = null;
        contentEncoding = null;
        stream = null;
        hasBeenOpened = false;
        protocol = url.getProtocol();
        if(protocol != null && protocol.length() == 0)
            protocol = null;
        host = url.getHost();
        if(host != null && host.length() == 0)
            host = null;
        port = url.getPort();
        path = url.getFile();
        if(path != null && path.length() == 0)
            path = null;
        ref = url.getRef();
        if(ref != null && ref.length() == 0)
            ref = null;
    }

    protected URL buildURL()
        throws MalformedURLException
    {
        if(protocol != null && host != null)
        {
            String s = "";
            if(path != null)
                s = path;
            if(port == -1)
                return new URL(protocol, host, s);
            else
                return new URL(protocol, host, port, s);
        } else
        {
            return new URL(toString());
        }
    }

    public int hashCode()
    {
        int i = port;
        if(protocol != null)
            i ^= protocol.hashCode();
        if(host != null)
            i ^= host.hashCode();
        if(path != null)
        {
            int j = path.length();
            if(j > 20)
                i ^= path.substring(j - 20).hashCode();
            else
                i ^= path.hashCode();
        }
        if(ref != null)
        {
            int k = ref.length();
            if(k > 20)
                i ^= ref.substring(k - 20).hashCode();
            else
                i ^= ref.hashCode();
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof ParsedURLData))
            return false;
        ParsedURLData parsedurldata = (ParsedURLData)obj;
        if(parsedurldata.port != port)
            return false;
        if(parsedurldata.protocol == null)
        {
            if(protocol != null)
                return false;
        } else
        {
            if(protocol == null)
                return false;
            if(!parsedurldata.protocol.equals(protocol))
                return false;
        }
        if(parsedurldata.host == null)
        {
            if(host != null)
                return false;
        } else
        {
            if(host == null)
                return false;
            if(!parsedurldata.host.equals(host))
                return false;
        }
        if(parsedurldata.ref == null)
        {
            if(ref != null)
                return false;
        } else
        {
            if(ref == null)
                return false;
            if(!parsedurldata.ref.equals(ref))
                return false;
        }
        if(parsedurldata.path == null)
        {
            if(path != null)
                return false;
        } else
        {
            if(path == null)
                return false;
            if(!parsedurldata.path.equals(path))
                return false;
        }
        return true;
    }

    public String getContentType(String s)
    {
        if(contentType != null)
            return contentType;
        if(!hasBeenOpened)
            try
            {
                openStreamInternal(s, null, null);
            }
            catch(IOException ioexception) { }
        return contentType;
    }

    public String getContentEncoding(String s)
    {
        if(contentEncoding != null)
            return contentEncoding;
        if(!hasBeenOpened)
            try
            {
                openStreamInternal(s, null, null);
            }
            catch(IOException ioexception) { }
        return contentEncoding;
    }

    public boolean complete()
    {
        try
        {
            buildURL();
        }
        catch(MalformedURLException malformedurlexception)
        {
            return false;
        }
        return true;
    }

    public InputStream openStream(String s, Iterator iterator)
        throws IOException
    {
        InputStream inputstream = openStreamInternal(s, iterator, acceptedEncodings.iterator());
        if(inputstream == null)
        {
            return null;
        } else
        {
            stream = null;
            return checkGZIP(inputstream);
        }
    }

    public InputStream openStreamRaw(String s, Iterator iterator)
        throws IOException
    {
        InputStream inputstream = openStreamInternal(s, iterator, null);
        stream = null;
        return inputstream;
    }

    protected InputStream openStreamInternal(String s, Iterator iterator, Iterator iterator1)
        throws IOException
    {
        if(stream != null)
            return stream;
        hasBeenOpened = true;
        URL url = null;
        try
        {
            url = buildURL();
        }
        catch(MalformedURLException malformedurlexception)
        {
            throw new IOException("Unable to make sense of URL for connection");
        }
        if(url == null)
            return null;
        URLConnection urlconnection = url.openConnection();
        if(urlconnection instanceof HttpURLConnection)
        {
            if(s != null)
                urlconnection.setRequestProperty(HTTP_USER_AGENT_HEADER, s);
            if(iterator != null)
            {
                String s1 = "";
                do
                {
                    if(!iterator.hasNext())
                        break;
                    s1 = s1 + iterator.next();
                    if(iterator.hasNext())
                        s1 = s1 + ",";
                } while(true);
                urlconnection.setRequestProperty(HTTP_ACCEPT_HEADER, s1);
            }
            if(iterator1 != null)
            {
                String s2 = "";
                do
                {
                    if(!iterator1.hasNext())
                        break;
                    s2 = s2 + iterator1.next();
                    if(iterator1.hasNext())
                        s2 = s2 + ",";
                } while(true);
                urlconnection.setRequestProperty(HTTP_ACCEPT_ENCODING_HEADER, s2);
            }
            contentType = urlconnection.getContentType();
            contentEncoding = urlconnection.getContentEncoding();
        }
        return stream = urlconnection.getInputStream();
    }

    public String getPortStr()
    {
        String s = "";
        if(protocol != null)
            s = s + protocol + ":";
        if(host != null || port != -1)
        {
            s = s + "//";
            if(host != null)
                s = s + host;
            if(port != -1)
                s = s + ":" + port;
        }
        return s;
    }

    protected boolean sameFile(ParsedURLData parsedurldata)
    {
        if(this == parsedurldata)
            return true;
        return port == parsedurldata.port && (path == parsedurldata.path || path != null && path.equals(parsedurldata.path)) && (host == parsedurldata.host || host != null && host.equals(parsedurldata.host)) && (protocol == parsedurldata.protocol || protocol != null && protocol.equals(parsedurldata.protocol));
    }

    public String toString()
    {
        String s = getPortStr();
        if(path != null)
            s = s + path;
        if(ref != null)
            s = s + "#" + ref;
        return s;
    }

    String HTTP_USER_AGENT_HEADER;
    String HTTP_ACCEPT_HEADER;
    String HTTP_ACCEPT_LANGUAGE_HEADER;
    String HTTP_ACCEPT_ENCODING_HEADER;
    protected static List acceptedEncodings;
    public static final byte GZIP_MAGIC[] = {
        31, -117
    };
    public String protocol;
    public String host;
    public int port;
    public String path;
    public String ref;
    public String contentType;
    public String contentEncoding;
    public InputStream stream;
    public boolean hasBeenOpened;

    static 
    {
        acceptedEncodings = new LinkedList();
        acceptedEncodings.add("gzip");
    }
}
