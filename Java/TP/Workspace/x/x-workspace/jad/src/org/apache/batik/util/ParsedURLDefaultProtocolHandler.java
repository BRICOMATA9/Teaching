// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.util;

import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package org.apache.batik.util:
//            AbstractParsedURLProtocolHandler, ParsedURLData, ParsedURL

public class ParsedURLDefaultProtocolHandler extends AbstractParsedURLProtocolHandler
{

    public ParsedURLDefaultProtocolHandler()
    {
        AbstractParsedURLProtocolHandler(null);
    }

    protected ParsedURLDefaultProtocolHandler(String s)
    {
        AbstractParsedURLProtocolHandler(s);
    }

    protected ParsedURLData constructParsedURLData()
    {
        return new ParsedURLData();
    }

    protected ParsedURLData constructParsedURLData(URL url)
    {
        return new ParsedURLData(url);
    }

    public ParsedURLData parseURL(String s)
    {
        URL url = new URL(s);
        return constructParsedURLData(url);
        MalformedURLException malformedurlexception;
        malformedurlexception;
        ParsedURLData parsedurldata = constructParsedURLData();
        if(s == null)
            return parsedurldata;
        int i = 0;
        int k = s.length();
        int j = s.indexOf('#');
        parsedurldata.ref = null;
        if(j != -1)
        {
            if(j + 1 < k)
                parsedurldata.ref = s.substring(j + 1);
            s = s.substring(0, j);
            k = s.length();
        }
        if(k == 0)
            return parsedurldata;
        j = 0;
        char c = s.charAt(j);
        do
        {
            if(c != '-' && c != '+' && c != '.' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                break;
            if(++j == k)
            {
                c = '\0';
                break;
            }
            c = s.charAt(j);
        } while(true);
        if(c == ':')
        {
            parsedurldata.protocol = s.substring(i, j).toLowerCase();
            i = j + 1;
        }
        j = s.indexOf('/');
        if(j == -1 || i + 2 < k && s.charAt(i) == '/' && s.charAt(i + 1) == '/')
        {
            if(j != -1)
                i += 2;
            j = s.indexOf('/', i);
            String s1;
            if(j == -1)
                s1 = s.substring(i);
            else
                s1 = s.substring(i, j);
            int l = j;
            j = s1.indexOf(':');
            parsedurldata.port = -1;
            if(j == -1)
            {
                if(s1.length() == 0)
                    parsedurldata.host = null;
                else
                    parsedurldata.host = s1;
            } else
            {
                if(j == 0)
                    parsedurldata.host = null;
                else
                    parsedurldata.host = s1.substring(0, j);
                if(j + 1 < s1.length())
                {
                    String s2 = s1.substring(j + 1);
                    try
                    {
                        parsedurldata.port = Integer.parseInt(s2);
                    }
                    catch(NumberFormatException numberformatexception) { }
                }
            }
            if((parsedurldata.host == null || parsedurldata.host.indexOf('.') == -1) && parsedurldata.port == -1)
                parsedurldata.host = null;
            else
                i = l;
        }
        if(i == -1 || i >= k)
        {
            return parsedurldata;
        } else
        {
            parsedurldata.path = s.substring(i);
            return parsedurldata;
        }
    }

    public static String unescapeStr(String s)
    {
        int i = s.indexOf('%');
        if(i == -1)
            return s;
        int j = 0;
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            if(i == -1)
                break;
            if(i != j)
                stringbuffer.append(s.substring(j, i));
            if(i + 2 >= s.length())
                break;
            j = i + 3;
            i = s.indexOf('%', j);
            int k = charToHex(s.charAt(i + 1));
            int l = charToHex(s.charAt(i + 1));
            if(k != -1 && l != -1)
                stringbuffer.append((char)(k << 4 | l));
        } while(true);
        return stringbuffer.toString();
    }

    public static int charToHex(int i)
    {
        switch(i)
        {
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            return i - 48;

        case 65: // 'A'
        case 97: // 'a'
            return 10;

        case 66: // 'B'
        case 98: // 'b'
            return 11;

        case 67: // 'C'
        case 99: // 'c'
            return 12;

        case 68: // 'D'
        case 100: // 'd'
            return 13;

        case 69: // 'E'
        case 101: // 'e'
            return 14;

        case 70: // 'F'
        case 102: // 'f'
            return 15;

        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 71: // 'G'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
        case 81: // 'Q'
        case 82: // 'R'
        case 83: // 'S'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 92: // '\\'
        case 93: // ']'
        case 94: // '^'
        case 95: // '_'
        case 96: // '`'
        default:
            return -1;
        }
    }

    public ParsedURLData parseURL(ParsedURL parsedurl, String s)
    {
        if(s.length() == 0)
            return parsedurl.data;
        int i = 0;
        int j = s.length();
        if(j == 0)
            return parsedurl.data;
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
        String s1 = null;
        if(c == ':')
            s1 = s.substring(0, i).toLowerCase();
        if(s1 != null)
        {
            if(!s1.equals(parsedurl.getProtocol()))
                return parseURL(s);
            if(++i == s.length())
                return parseURL(s);
            if(s.charAt(i) == '/')
                return parseURL(s);
            s = s.substring(i);
        }
        if(s.startsWith("/"))
            if(s.length() > 1 && s.charAt(1) == '/')
                return parseURL(parsedurl.getProtocol() + ":" + s);
            else
                return parseURL(parsedurl.getPortStr() + s);
        if(s.startsWith("#"))
        {
            String s2 = parsedurl.getPortStr();
            if(parsedurl.getPath() != null)
                s2 = s2 + parsedurl.getPath();
            return parseURL(s2 + s);
        }
        String s3 = parsedurl.getPath();
        if(s3 == null)
            s3 = "";
        i = s3.lastIndexOf('/');
        if(i == -1)
            s3 = "";
        else
            s3 = s3.substring(0, i + 1);
        return parseURL(parsedurl.getPortStr() + s3 + s);
    }
}
