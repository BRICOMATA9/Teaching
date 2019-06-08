// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.xml;

import java.io.*;
import org.apache.batik.util.EncodingUtilities;

// Referenced classes of package org.apache.batik.xml:
//            XMLCharacters

public class XMLUtilities extends XMLCharacters
{

    protected XMLUtilities()
    {
    }

    public static boolean isXMLSpace(char c)
    {
        return c <= ' ' && (0x100002600L >> c & 1L) != 0L;
    }

    public static boolean isXMLNameFirstCharacter(char c)
    {
        return (NAME_FIRST_CHARACTER[c / 32] & 1 << c % 32) != 0;
    }

    public static boolean isXMLNameCharacter(char c)
    {
        return (NAME_CHARACTER[c / 32] & 1 << c % 32) != 0;
    }

    public static boolean isXMLCharacter(int i)
    {
        return i >= 0x10000 && i <= 0x10ffff || (XML_CHARACTER[i / 32] & 1 << i % 32) != 0;
    }

    public static boolean isXMLPublicIdCharacter(char c)
    {
        return c < '\200' && (PUBLIC_ID_CHARACTER[c / 32] & 1 << c % 32) != 0;
    }

    public static boolean isXMLVersionCharacter(char c)
    {
        return c < '\200' && (VERSION_CHARACTER[c / 32] & 1 << c % 32) != 0;
    }

    public static boolean isXMLAlphabeticCharacter(char c)
    {
        return c < '\200' && (ALPHABETIC_CHARACTER[c / 32] & 1 << c % 32) != 0;
    }

    public static Reader createXMLDocumentReader(InputStream inputstream)
        throws IOException
    {
        PushbackInputStream pushbackinputstream = new PushbackInputStream(inputstream, 128);
        byte abyte0[] = new byte[4];
        int i = pushbackinputstream.read(abyte0);
        if(i > 0)
            pushbackinputstream.unread(abyte0, 0, i);
        if(i == 4)
label0:
            switch(abyte0[0] & 0xff)
            {
            default:
                break;

            case 0: // '\0'
                if(abyte0[1] == 60 && abyte0[2] == 0 && abyte0[3] == 63)
                    return new InputStreamReader(pushbackinputstream, "UnicodeBig");
                break;

            case 60: // '<'
                switch(abyte0[1] & 0xff)
                {
                default:
                    break;

                case 0: // '\0'
                    if(abyte0[2] == 63 && abyte0[3] == 0)
                        return new InputStreamReader(pushbackinputstream, "UnicodeLittle");
                    break label0;

                case 63: // '?'
                    if(abyte0[2] == 120 && abyte0[3] == 109)
                    {
                        Reader reader = createXMLDeclarationReader(pushbackinputstream, "UTF8");
                        String s = getXMLDeclarationEncoding(reader, "UTF8");
                        return new InputStreamReader(pushbackinputstream, s);
                    }
                    break;
                }
                break;

            case 76: // 'L'
                if(abyte0[1] == 111 && (abyte0[2] & 0xff) == 167 && (abyte0[3] & 0xff) == 148)
                {
                    Reader reader1 = createXMLDeclarationReader(pushbackinputstream, "CP037");
                    String s1 = getXMLDeclarationEncoding(reader1, "CP037");
                    return new InputStreamReader(pushbackinputstream, s1);
                }
                break;

            case 254: 
                if((abyte0[1] & 0xff) == 255)
                    return new InputStreamReader(pushbackinputstream, "Unicode");
                break;

            case 255: 
                if((abyte0[1] & 0xff) == 254)
                    return new InputStreamReader(pushbackinputstream, "Unicode");
                break;
            }
        return new InputStreamReader(pushbackinputstream, "UTF8");
    }

    protected static Reader createXMLDeclarationReader(PushbackInputStream pushbackinputstream, String s)
        throws IOException
    {
        byte abyte0[] = new byte[128];
        int i = pushbackinputstream.read(abyte0);
        if(i > 0)
            pushbackinputstream.unread(abyte0, 0, i);
        return new InputStreamReader(new ByteArrayInputStream(abyte0, 4, i), s);
    }

    protected static String getXMLDeclarationEncoding(Reader reader, String s)
        throws IOException
    {
        int i;
        if((i = reader.read()) != 108)
            return s;
        if(!isXMLSpace((char)(i = reader.read())))
            return s;
        while(isXMLSpace((char)(i = reader.read()))) ;
        if(i != 118)
            return s;
        if((i = reader.read()) != 101)
            return s;
        if((i = reader.read()) != 114)
            return s;
        if((i = reader.read()) != 115)
            return s;
        if((i = reader.read()) != 105)
            return s;
        if((i = reader.read()) != 111)
            return s;
        if((i = reader.read()) != 110)
            return s;
        for(i = reader.read(); isXMLSpace((char)i); i = reader.read());
        if(i != 61)
            return s;
        while(isXMLSpace((char)(i = reader.read()))) ;
        if(i != 34 && i != 39)
            return s;
        char c = (char)i;
        do
        {
            int j = reader.read();
            if(j != c)
            {
                if(!isXMLVersionCharacter((char)j))
                    return s;
            } else
            {
                int k;
                if(!isXMLSpace((char)(k = reader.read())))
                    return s;
                while(isXMLSpace((char)(k = reader.read()))) ;
                if(k != 101)
                    return s;
                if((k = reader.read()) != 110)
                    return s;
                if((k = reader.read()) != 99)
                    return s;
                if((k = reader.read()) != 111)
                    return s;
                if((k = reader.read()) != 100)
                    return s;
                if((k = reader.read()) != 105)
                    return s;
                if((k = reader.read()) != 110)
                    return s;
                if((k = reader.read()) != 103)
                    return s;
                for(k = reader.read(); isXMLSpace((char)k); k = reader.read());
                if(k != 61)
                    return s;
                while(isXMLSpace((char)(k = reader.read()))) ;
                if(k != 34 && k != 39)
                    return s;
                char c1 = (char)k;
                StringBuffer stringbuffer = new StringBuffer();
                do
                {
                    int l = reader.read();
                    if(l == -1)
                        return s;
                    if(l == c1)
                        return encodingToJavaEncoding(stringbuffer.toString(), s);
                    stringbuffer.append((char)l);
                } while(true);
            }
        } while(true);
    }

    public static String encodingToJavaEncoding(String s, String s1)
    {
        String s2 = EncodingUtilities.javaEncoding(s);
        return s2 != null ? s2 : s1;
    }
}
