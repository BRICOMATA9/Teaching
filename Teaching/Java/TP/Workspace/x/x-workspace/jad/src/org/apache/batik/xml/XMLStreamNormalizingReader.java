// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.xml;

import java.io.*;
import org.apache.batik.util.io.StreamNormalizingReader;
import org.apache.batik.util.io.UTF16Decoder;

// Referenced classes of package org.apache.batik.xml:
//            XMLUtilities

public class XMLStreamNormalizingReader extends StreamNormalizingReader
{

    public XMLStreamNormalizingReader(InputStream inputstream, String s)
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
                {
                    charDecoder = new UTF16Decoder(pushbackinputstream, true);
                    return;
                }
                break;

            case 60: // '<'
                switch(abyte0[1] & 0xff)
                {
                default:
                    break;

                case 0: // '\0'
                    if(abyte0[2] == 63 && abyte0[3] == 0)
                    {
                        charDecoder = new UTF16Decoder(pushbackinputstream, false);
                        return;
                    }
                    break label0;

                case 63: // '?'
                    if(abyte0[2] == 120 && abyte0[3] == 109)
                    {
                        java.io.Reader reader = XMLUtilities.createXMLDeclarationReader(pushbackinputstream, "UTF8");
                        String s1 = XMLUtilities.getXMLDeclarationEncoding(reader, "UTF-8");
                        charDecoder = createCharDecoder(pushbackinputstream, s1);
                        return;
                    }
                    break;
                }
                break;

            case 76: // 'L'
                if(abyte0[1] == 111 && (abyte0[2] & 0xff) == 167 && (abyte0[3] & 0xff) == 148)
                {
                    java.io.Reader reader1 = XMLUtilities.createXMLDeclarationReader(pushbackinputstream, "CP037");
                    String s2 = XMLUtilities.getXMLDeclarationEncoding(reader1, "EBCDIC-CP-US");
                    charDecoder = createCharDecoder(pushbackinputstream, s2);
                    return;
                }
                break;

            case 254: 
                if((abyte0[1] & 0xff) == 255)
                {
                    charDecoder = createCharDecoder(pushbackinputstream, "UTF-16");
                    return;
                }
                break;

            case 255: 
                if((abyte0[1] & 0xff) == 254)
                {
                    charDecoder = createCharDecoder(pushbackinputstream, "UTF-16");
                    return;
                }
                break;
            }
        s = s != null ? s : "UTF-8";
        charDecoder = createCharDecoder(pushbackinputstream, s);
    }
}
