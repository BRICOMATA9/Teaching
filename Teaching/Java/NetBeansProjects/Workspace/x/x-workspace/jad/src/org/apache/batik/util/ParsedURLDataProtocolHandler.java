// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.io.*;
import java.util.Iterator;

// Referenced classes of package org.apache.batik.util:
//            AbstractParsedURLProtocolHandler, ParsedURL, ParsedURLData, Base64DecodeStream

public class ParsedURLDataProtocolHandler extends AbstractParsedURLProtocolHandler
{
    static class DataParsedURLData extends ParsedURLData
    {

        public boolean complete()
        {
            return path != null;
        }

        public String getPortStr()
        {
            String s = "data:";
            if(host != null)
                s = s + host;
            s = s + ",";
            return s;
        }

        public String toString()
        {
            String s = getPortStr();
            if(path != null)
                s = s + path;
            return s;
        }

        public String getContentType(String s)
        {
            return contentType;
        }

        public String getContentEncoding(String s)
        {
            return contentEncoding;
        }

        protected InputStream openStreamInternal(String s, Iterator iterator, Iterator iterator1)
            throws IOException
        {
            if("base64".equals(contentEncoding))
            {
                byte abyte0[] = path.getBytes();
                stream = new ByteArrayInputStream(abyte0);
                stream = new Base64DecodeStream(stream);
            } else
            {
                stream = decode(path);
            }
            return stream;
        }

        public static InputStream decode(String s)
        {
            int i = s.length();
            byte abyte0[] = new byte[i];
            int j = 0;
            for(int k = 0; k < i; k++)
            {
                char c = s.charAt(k);
                switch(c)
                {
                default:
                    abyte0[j++] = (byte)c;
                    break;

                case 37: // '%'
                    if(k + 2 >= i)
                        break;
                    k += 2;
                    char c1 = s.charAt(k - 1);
                    byte byte0;
                    if(c1 >= '0' && c1 <= '9')
                        byte0 = (byte)(c1 - 48);
                    else
                    if(c1 >= 'a' && c1 <= 'z')
                    {
                        byte0 = (byte)((c1 - 97) + 10);
                    } else
                    {
                        if(c1 < 'A' || c1 > 'Z')
                            break;
                        byte0 = (byte)((c1 - 65) + 10);
                    }
                    byte0 *= 16;
                    char c2 = s.charAt(k);
                    if(c2 >= '0' && c2 <= '9')
                        byte0 += (byte)(c2 - 48);
                    else
                    if(c2 >= 'a' && c2 <= 'z')
                    {
                        byte0 += (byte)((c2 - 97) + 10);
                    } else
                    {
                        if(c2 < 'A' || c2 > 'Z')
                            break;
                        byte0 += (byte)((c2 - 65) + 10);
                    }
                    abyte0[j++] = byte0;
                    break;
                }
            }

            return new ByteArrayInputStream(abyte0, 0, j);
        }

        String charset;

        DataParsedURLData()
        {
            charset = null;
        }
    }


    public ParsedURLDataProtocolHandler()
    {
        AbstractParsedURLProtocolHandler("data");
    }

    public ParsedURLData parseURL(ParsedURL parsedurl, String s)
    {
        return parseURL(s);
    }

    public ParsedURLData parseURL(String s)
    {
        DataParsedURLData dataparsedurldata = new DataParsedURLData();
        int i = 0;
        int j = s.indexOf(':');
        if(j != -1)
        {
            dataparsedurldata.protocol = s.substring(i, j);
            if(dataparsedurldata.protocol.indexOf('/') == -1)
            {
                i = j + 1;
            } else
            {
                dataparsedurldata.protocol = null;
                i = 0;
            }
        }
        j = s.indexOf(',', i);
        if(j != -1 && j != i)
        {
            dataparsedurldata.host = s.substring(i, j);
            i = j + 1;
            int l = dataparsedurldata.host.lastIndexOf(';');
            if(l == -1 || l == dataparsedurldata.host.length())
            {
                dataparsedurldata.contentType = dataparsedurldata.host;
            } else
            {
                String s1 = dataparsedurldata.host.substring(l + 1);
                int k = s1.indexOf('=');
                if(k == -1)
                {
                    dataparsedurldata.contentEncoding = s1;
                    dataparsedurldata.contentType = dataparsedurldata.host.substring(0, l);
                } else
                {
                    dataparsedurldata.contentType = dataparsedurldata.host;
                }
                l = 0;
                k = dataparsedurldata.contentType.indexOf(';', l);
                if(k != -1)
                {
                    for(int i1 = k + 1; i1 < dataparsedurldata.contentType.length(); i1 = k + 1)
                    {
                        k = dataparsedurldata.contentType.indexOf(';', i1);
                        if(k == -1)
                            k = dataparsedurldata.contentType.length();
                        String s2 = dataparsedurldata.contentType.substring(i1, k);
                        int j1 = s2.indexOf('=');
                        if(j1 != -1 && "charset".equals(s2.substring(0, j1)))
                            dataparsedurldata.charset = s2.substring(j1 + 1);
                    }

                }
            }
        }
        if(i != s.length())
            dataparsedurldata.path = s.substring(i);
        return dataparsedurldata;
    }

    static final String DATA_PROTOCOL = "data";
    static final String BASE64 = "base64";
    static final String CHARSET = "charset";
}
