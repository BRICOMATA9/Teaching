// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.xml;

import java.io.*;
import java.util.Locale;
import java.util.MissingResourceException;
import org.apache.batik.i18n.Localizable;
import org.apache.batik.i18n.LocalizableSupport;
import org.apache.batik.util.io.*;

// Referenced classes of package org.apache.batik.xml:
//            XMLException, XMLUtilities

public class XMLScanner
    implements Localizable
{

    public XMLScanner(Reader reader1)
        throws XMLException
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.xml.resources.Messages", (org.apache.batik.xml.XMLScanner.class).getClassLoader());
        buffer = new char[1024];
        context = 0;
        try
        {
            reader = new StreamNormalizingReader(reader1);
            current = nextChar();
        }
        catch(IOException ioexception)
        {
            throw new XMLException(ioexception);
        }
    }

    public XMLScanner(InputStream inputstream, String s)
        throws XMLException
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.xml.resources.Messages", (org.apache.batik.xml.XMLScanner.class).getClassLoader());
        buffer = new char[1024];
        context = 0;
        try
        {
            reader = new StreamNormalizingReader(inputstream, s);
            current = nextChar();
        }
        catch(IOException ioexception)
        {
            throw new XMLException(ioexception);
        }
    }

    public XMLScanner(String s)
        throws XMLException
    {
        localizableSupport = new LocalizableSupport("org.apache.batik.xml.resources.Messages", (org.apache.batik.xml.XMLScanner.class).getClassLoader());
        buffer = new char[1024];
        context = 0;
        try
        {
            reader = new StringNormalizingReader(s);
            current = nextChar();
        }
        catch(IOException ioexception)
        {
            throw new XMLException(ioexception);
        }
    }

    public void setLocale(Locale locale)
    {
        localizableSupport.setLocale(locale);
    }

    public Locale getLocale()
    {
        return localizableSupport.getLocale();
    }

    public String formatMessage(String s, Object aobj[])
        throws MissingResourceException
    {
        return localizableSupport.formatMessage(s, aobj);
    }

    public void setDepth(int i)
    {
        depth = i;
    }

    public int getDepth()
    {
        return depth;
    }

    public void setContext(int i)
    {
        context = i;
    }

    public int getContext()
    {
        return context;
    }

    public int getType()
    {
        return type;
    }

    public int getLine()
    {
        return reader.getLine();
    }

    public int getColumn()
    {
        return reader.getColumn();
    }

    public char[] getBuffer()
    {
        return buffer;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }

    public char getStringDelimiter()
    {
        return attrDelimiter;
    }

    public int getStartOffset()
    {
        switch(type)
        {
        case 21: // '\025'
            return -3;

        case 7: // '\007'
            return -2;

        case 9: // '\t'
        case 13: // '\r'
        case 16: // '\020'
        case 25: // '\031'
        case 34: // '"'
            return 1;

        case 5: // '\005'
        case 10: // '\n'
        case 12: // '\f'
            return 2;

        case 4: // '\004'
            return 4;

        case 6: // '\006'
        case 8: // '\b'
        case 11: // '\013'
        case 14: // '\016'
        case 15: // '\017'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        default:
            return 0;
        }
    }

    public int getEndOffset()
    {
        switch(type)
        {
        case 12: // '\f'
        case 13: // '\r'
        case 18: // '\022'
        case 25: // '\031'
        case 34: // '"'
            return -1;

        case 6: // '\006'
            return -2;

        case 4: // '\004'
            return -3;

        case 8: // '\b'
            return !cdataEndRead ? 0 : -3;
        }
        return 0;
    }

    public void clearBuffer()
    {
        if(position <= 0)
        {
            position = 0;
        } else
        {
            buffer[0] = buffer[position - 1];
            position = 1;
        }
    }

    public int next()
        throws XMLException
    {
        return next(context);
    }

    public int next(int i)
        throws XMLException
    {
        start = position - 1;
        i;
        JVM INSTR tableswitch 0 17: default 276
    //                   0 96
    //                   1 107
    //                   2 118
    //                   3 184
    //                   4 195
    //                   5 129
    //                   6 151
    //                   7 206
    //                   8 173
    //                   9 162
    //                   10 140
    //                   11 228
    //                   12 217
    //                   13 250
    //                   14 239
    //                   15 266
    //                   16 271
    //                   17 261;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L2:
        type = nextInDocumentStart();
        break; /* Loop/switch isn't completed */
_L3:
        type = nextInTopLevel();
        break; /* Loop/switch isn't completed */
_L4:
        type = nextInPI();
        break; /* Loop/switch isn't completed */
_L7:
        type = nextInStartTag();
        break; /* Loop/switch isn't completed */
_L12:
        type = nextInAttributeValue();
        break; /* Loop/switch isn't completed */
_L8:
        type = nextInContent();
        break; /* Loop/switch isn't completed */
_L11:
        type = nextInEndTag();
        break; /* Loop/switch isn't completed */
_L10:
        type = nextInCDATASection();
        break; /* Loop/switch isn't completed */
_L5:
        type = nextInXMLDecl();
        break; /* Loop/switch isn't completed */
_L6:
        type = nextInDoctype();
        break; /* Loop/switch isn't completed */
_L9:
        type = nextInDTDDeclarations();
        break; /* Loop/switch isn't completed */
_L14:
        type = nextInElementDeclaration();
        break; /* Loop/switch isn't completed */
_L13:
        type = nextInAttList();
        break; /* Loop/switch isn't completed */
_L16:
        type = nextInNotation();
        break; /* Loop/switch isn't completed */
_L15:
        type = nextInEntity();
        break; /* Loop/switch isn't completed */
_L19:
        return nextInEntityValue();
_L17:
        return nextInNotationType();
_L18:
        return nextInEnumeration();
_L1:
        try
        {
            throw new InternalError();
        }
        catch(IOException ioexception)
        {
            throw new XMLException(ioexception);
        }
        end = position - (current != -1 ? 1 : 0);
        return type;
    }

    protected int nextInDocumentStart()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            context = depth != 0 ? 6 : 1;
            return 1;

        case 60: // '<'
            switch(nextChar())
            {
            case 63: // '?'
                int i = nextChar();
                if(i == -1 || !XMLUtilities.isXMLNameFirstCharacter((char)i))
                    throw createXMLException("invalid.pi.target");
                context = 2;
                int j = nextChar();
                if(j == -1 || !XMLUtilities.isXMLNameCharacter((char)j))
                    return 5;
                int k = nextChar();
                if(k == -1 || !XMLUtilities.isXMLNameCharacter((char)k))
                    return 5;
                int l = nextChar();
                if(l != -1 && XMLUtilities.isXMLNameCharacter((char)l))
                {
                    do
                        nextChar();
                    while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                    return 5;
                }
                if(i == 120 && j == 109 && k == 108)
                {
                    context = 3;
                    return 2;
                }
                if((i == 120 || i == 88) && (j == 109 || j == 77) && (k == 108 || k == 76))
                    throw createXMLException("xml.reserved");
                else
                    return 5;

            case 33: // '!'
                switch(nextChar())
                {
                case 45: // '-'
                    return readComment();

                case 68: // 'D'
                    context = 4;
                    return readIdentifier("OCTYPE", 3, -1);
                }
                throw createXMLException("invalid.doctype");
            }
            context = 5;
            depth++;
            return readName(9);

        case -1: 
            return 0;
        }
        if(depth == 0)
            throw createXMLException("invalid.character");
        else
            return nextInContent();
    }

    protected int nextInTopLevel()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 60: // '<'
            switch(nextChar())
            {
            case 63: // '?'
                context = 2;
                return readPIStart();

            case 33: // '!'
                switch(nextChar())
                {
                case 45: // '-'
                    return readComment();

                case 68: // 'D'
                    context = 4;
                    return readIdentifier("OCTYPE", 3, -1);
                }
                throw createXMLException("invalid.character");
            }
            context = 5;
            depth++;
            return readName(9);

        case -1: 
            return 0;
        }
        throw createXMLException("invalid.character");
    }

    protected int nextInPI()
        throws IOException, XMLException
    {
        if(piEndRead)
        {
            piEndRead = false;
            context = depth != 0 ? 6 : 1;
            return 7;
        }
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 63: // '?'
            if(nextChar() != 62)
                throw createXMLException("pi.end.expected");
            nextChar();
            if(inDTD)
                context = 7;
            else
            if(depth == 0)
                context = 1;
            else
                context = 6;
            return 7;
        }
        do
        {
            do
                nextChar();
            while(current != -1 && current != 63);
            nextChar();
        } while(current != -1 && current != 62);
        nextChar();
        piEndRead = true;
        return 6;
    }

    protected int nextInStartTag()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 47: // '/'
            if(nextChar() != 62)
            {
                throw createXMLException("malformed.tag.end");
            } else
            {
                nextChar();
                context = --depth != 0 ? 6 : 1;
                return 19;
            }

        case 62: // '>'
            nextChar();
            context = 6;
            return 20;

        case 61: // '='
            nextChar();
            return 15;

        case 34: // '"'
            attrDelimiter = '"';
            nextChar();
            do
            {
                switch(current)
                {
                case 34: // '"'
                    nextChar();
                    return 25;

                case 38: // '&'
                    context = 10;
                    return 16;

                case 60: // '<'
                    throw createXMLException("invalid.character");

                case -1: 
                    throw createXMLException("unexpected.eof");
                }
                nextChar();
            } while(true);

        case 39: // '\''
            attrDelimiter = '\'';
            nextChar();
            do
            {
                switch(current)
                {
                case 39: // '\''
                    nextChar();
                    return 25;

                case 38: // '&'
                    context = 10;
                    return 16;

                case 60: // '<'
                    throw createXMLException("invalid.character");

                case -1: 
                    throw createXMLException("unexpected.eof");
                }
                nextChar();
            } while(true);
        }
        return readName(14);
    }

    protected int nextInAttributeValue()
        throws IOException, XMLException
    {
        if(current == -1)
            return 0;
        if(current == 38)
            return readReference();
_L4:
        current;
        JVM INSTR lookupswitch 5: default 97
    //                   -1: 80
    //                   34: 83
    //                   38: 80
    //                   39: 83
    //                   60: 80;
           goto _L1 _L2 _L3 _L2 _L3 _L2
_L3:
        if(current != attrDelimiter) goto _L1; else goto _L2
_L1:
        nextChar();
          goto _L4
_L2:
        switch(current)
        {
        case 60: // '<'
            throw createXMLException("invalid.character");

        case 38: // '&'
            return 17;

        case 34: // '"'
        case 39: // '\''
            nextChar();
            if(inDTD)
                context = 11;
            else
                context = 5;
            break;
        }
        return 18;
    }

    protected int nextInContent()
        throws IOException, XMLException
    {
        switch(current)
        {
        case -1: 
            return 0;

        case 38: // '&'
            return readReference();

        case 60: // '<'
            switch(nextChar())
            {
            case 63: // '?'
                context = 2;
                return readPIStart();

            case 33: // '!'
                switch(nextChar())
                {
                case 45: // '-'
                    return readComment();

                case 91: // '['
                    context = 8;
                    return readIdentifier("CDATA[", 11, -1);
                }
                throw createXMLException("invalid.character");

            case 47: // '/'
                nextChar();
                context = 9;
                return readName(10);
            }
            depth++;
            context = 5;
            return readName(9);
        }
        do
            switch(current)
            {
            default:
                nextChar();
                break;

            case -1: 
            case 38: // '&'
            case 60: // '<'
                return 8;
            }
        while(true);
    }

    protected int nextInEndTag()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            if(--depth < 0)
                throw createXMLException("unexpected.end.tag");
            if(depth == 0)
                context = 1;
            else
                context = 6;
            nextChar();
            return 20;
        }
        throw createXMLException("invalid.character");
    }

    protected int nextInCDATASection()
        throws IOException, XMLException
    {
        if(cdataEndRead)
        {
            cdataEndRead = false;
            context = 6;
            return 21;
        }
label0:
        do
        {
            do
            {
                do
                {
                    if(current == -1)
                        break label0;
                    while(current != 93 && current != -1) 
                        nextChar();
                } while(current == -1);
                nextChar();
            } while(current != 93);
            nextChar();
        } while(current != 62);
        if(current == -1)
        {
            throw createXMLException("unexpected.eof");
        } else
        {
            nextChar();
            cdataEndRead = true;
            return 8;
        }
    }

    protected int nextInXMLDecl()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 118: // 'v'
            return readIdentifier("ersion", 22, -1);

        case 101: // 'e'
            return readIdentifier("ncoding", 23, -1);

        case 115: // 's'
            return readIdentifier("tandalone", 24, -1);

        case 61: // '='
            nextChar();
            return 15;

        case 63: // '?'
            nextChar();
            if(current != 62)
            {
                throw createXMLException("pi.end.expected");
            } else
            {
                nextChar();
                context = 1;
                return 7;
            }

        case 34: // '"'
            attrDelimiter = '"';
            return readString();

        case 39: // '\''
            attrDelimiter = '\'';
            return readString();
        }
        throw createXMLException("invalid.character");
    }

    protected int nextInDoctype()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            nextChar();
            context = 1;
            return 20;

        case 83: // 'S'
            return readIdentifier("YSTEM", 26, 14);

        case 80: // 'P'
            return readIdentifier("UBLIC", 27, 14);

        case 34: // '"'
            attrDelimiter = '"';
            return readString();

        case 39: // '\''
            attrDelimiter = '\'';
            return readString();

        case 91: // '['
            nextChar();
            context = 7;
            inDTD = true;
            return 28;
        }
        return readName(14);
    }

    protected int nextInDTDDeclarations()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 93: // ']'
            nextChar();
            context = 4;
            inDTD = false;
            return 29;

        case 37: // '%'
            return readPEReference();

        case 60: // '<'
            switch(nextChar())
            {
            case 63: // '?'
                context = 2;
                return readPIStart();

            case 33: // '!'
                switch(nextChar())
                {
                case 45: // '-'
                    return readComment();

                case 69: // 'E'
                    switch(nextChar())
                    {
                    case 76: // 'L'
                        context = 12;
                        return readIdentifier("EMENT", 30, -1);

                    case 78: // 'N'
                        context = 13;
                        return readIdentifier("TITY", 32, -1);
                    }
                    throw createXMLException("invalid.character");

                case 65: // 'A'
                    context = 11;
                    return readIdentifier("TTLIST", 31, -1);

                case 78: // 'N'
                    context = 14;
                    return readIdentifier("OTATION", 33, -1);
                }
                throw createXMLException("invalid.character");
            }
            throw createXMLException("invalid.character");
        }
        throw createXMLException("invalid.character");
    }

    protected int readString()
        throws IOException, XMLException
    {
        do
            nextChar();
        while(current != -1 && current != attrDelimiter);
        if(current == -1)
        {
            throw createXMLException("unexpected.eof");
        } else
        {
            nextChar();
            return 25;
        }
    }

    protected int readComment()
        throws IOException, XMLException
    {
        if(nextChar() != 45)
            throw createXMLException("malformed.comment");
        int i = nextChar();
        do
        {
            if(i == -1)
                break;
            for(; i != -1 && i != 45; i = nextChar());
            i = nextChar();
        } while(i != 45);
        if(i == -1)
            throw createXMLException("unexpected.eof");
        i = nextChar();
        if(i != 62)
        {
            throw createXMLException("malformed.comment");
        } else
        {
            nextChar();
            return 4;
        }
    }

    protected int readIdentifier(String s, int i, int j)
        throws IOException, XMLException
    {
        int k = s.length();
        for(int l = 0; l < k; l++)
        {
            nextChar();
            if(current != s.charAt(l))
            {
                if(j == -1)
                    throw createXMLException("invalid.character");
                for(; current != -1 && XMLUtilities.isXMLNameCharacter((char)current); nextChar());
                return j;
            }
        }

        nextChar();
        return i;
    }

    protected int readName(int i)
        throws IOException, XMLException
    {
        if(current == -1)
            throw createXMLException("unexpected.eof");
        if(!XMLUtilities.isXMLNameFirstCharacter((char)current))
            throw createXMLException("invalid.name");
        do
            nextChar();
        while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
        return i;
    }

    protected int readPIStart()
        throws IOException, XMLException
    {
        int i = nextChar();
        if(i == -1)
            throw createXMLException("unexpected.eof");
        if(!XMLUtilities.isXMLNameFirstCharacter((char)current))
            throw createXMLException("malformed.pi.target");
        int j = nextChar();
        if(j == -1 || !XMLUtilities.isXMLNameCharacter((char)j))
            return 5;
        int k = nextChar();
        if(k == -1 || !XMLUtilities.isXMLNameCharacter((char)k))
            return 5;
        int l = nextChar();
        if(l != -1 && XMLUtilities.isXMLNameCharacter((char)l))
        {
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
            return 5;
        }
        if((i == 120 || i == 88) && (j == 109 || j == 77) && (k == 108 || k == 76))
            throw createXMLException("xml.reserved");
        else
            return 5;
    }

    protected int nextInElementDeclaration()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            nextChar();
            context = 7;
            return 20;

        case 37: // '%'
            nextChar();
            int i = readName(34);
            if(current != 59)
            {
                throw createXMLException("malformed.parameter.entity");
            } else
            {
                nextChar();
                return i;
            }

        case 69: // 'E'
            return readIdentifier("MPTY", 35, 14);

        case 65: // 'A'
            return readIdentifier("NY", 36, 14);

        case 63: // '?'
            nextChar();
            return 37;

        case 43: // '+'
            nextChar();
            return 38;

        case 42: // '*'
            nextChar();
            return 39;

        case 40: // '('
            nextChar();
            return 40;

        case 41: // ')'
            nextChar();
            return 41;

        case 124: // '|'
            nextChar();
            return 42;

        case 44: // ','
            nextChar();
            return 43;

        case 35: // '#'
            return readIdentifier("PCDATA", 44, -1);
        }
        return readName(14);
    }

    protected int nextInAttList()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            nextChar();
            context = 7;
            return type = 20;

        case 37: // '%'
            int i = readName(34);
            if(current != 59)
            {
                throw createXMLException("malformed.parameter.entity");
            } else
            {
                nextChar();
                return i;
            }

        case 67: // 'C'
            return readIdentifier("DATA", 45, 14);

        case 73: // 'I'
            nextChar();
            if(current != 68)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 46;
            if(current != 82)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 69)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 70)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 47;
            if(current != 83)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 48;
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
            return type = 14;

        case 78: // 'N'
            switch(nextChar())
            {
            default:
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;

            case 79: // 'O'
                context = 15;
                return readIdentifier("TATION", 57, 14);

            case 77: // 'M'
                nextChar();
                break;
            }
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 84)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 79)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 75)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 69)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 78)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 49;
            if(current != 83)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 50;
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
            return 14;

        case 69: // 'E'
            nextChar();
            if(current != 78)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 84)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 73)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            if(current != 84)
            {
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return type = 14;
            }
            nextChar();
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            switch(current)
            {
            case 89: // 'Y'
                nextChar();
                if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                    return 51;
                do
                    nextChar();
                while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                return 14;

            case 73: // 'I'
                nextChar();
                if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                    return 14;
                if(current != 69)
                {
                    do
                        nextChar();
                    while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                    return 14;
                }
                nextChar();
                if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                    return 14;
                if(current != 83)
                {
                    do
                        nextChar();
                    while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
                    return 14;
                } else
                {
                    return 52;
                }
            }
            if(current == -1 || !XMLUtilities.isXMLNameCharacter((char)current))
                return 14;
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
            return 14;

        case 34: // '"'
            attrDelimiter = '"';
            nextChar();
            if(current == -1)
                throw createXMLException("unexpected.eof");
            if(current != 34 && current != 38)
                do
                    nextChar();
                while(current != -1 && current != 34 && current != 38);
            switch(current)
            {
            case 38: // '&'
                context = 10;
                return 16;

            case 34: // '"'
                nextChar();
                return 25;
            }
            throw createXMLException("invalid.character");

        case 39: // '\''
            attrDelimiter = '\'';
            nextChar();
            if(current == -1)
                throw createXMLException("unexpected.eof");
            if(current != 39 && current != 38)
                do
                    nextChar();
                while(current != -1 && current != 39 && current != 38);
            switch(current)
            {
            case 38: // '&'
                context = 10;
                return 16;

            case 39: // '\''
                nextChar();
                return 25;
            }
            throw createXMLException("invalid.character");

        case 35: // '#'
            switch(nextChar())
            {
            case 82: // 'R'
                return readIdentifier("EQUIRED", 53, -1);

            case 73: // 'I'
                return readIdentifier("MPLIED", 54, -1);

            case 70: // 'F'
                return readIdentifier("IXED", 55, -1);
            }
            throw createXMLException("invalid.character");

        case 40: // '('
            nextChar();
            context = 16;
            return 40;
        }
        return readName(14);
    }

    protected int nextInNotation()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            nextChar();
            context = 7;
            return 20;

        case 37: // '%'
            int i = readName(34);
            if(current != 59)
            {
                throw createXMLException("malformed.parameter.entity");
            } else
            {
                nextChar();
                return i;
            }

        case 83: // 'S'
            return readIdentifier("YSTEM", 26, 14);

        case 80: // 'P'
            return readIdentifier("UBLIC", 27, 14);

        case 34: // '"'
            attrDelimiter = '"';
            return readString();

        case 39: // '\''
            attrDelimiter = '\'';
            return readString();
        }
        return readName(14);
    }

    protected int nextInEntity()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 62: // '>'
            nextChar();
            context = 7;
            return 20;

        case 37: // '%'
            nextChar();
            return 58;

        case 83: // 'S'
            return readIdentifier("YSTEM", 26, 14);

        case 80: // 'P'
            return readIdentifier("UBLIC", 27, 14);

        case 78: // 'N'
            return readIdentifier("DATA", 59, 14);

        case 34: // '"'
            attrDelimiter = '"';
            nextChar();
            if(current == -1)
                throw createXMLException("unexpected.eof");
            if(current != 34 && current != 38 && current != 37)
                do
                    nextChar();
                while(current != -1 && current != 34 && current != 38 && current != 37);
            switch(current)
            {
            case 35: // '#'
            case 36: // '$'
            default:
                throw createXMLException("invalid.character");

            case 37: // '%'
            case 38: // '&'
                context = 17;
                break;

            case 34: // '"'
                nextChar();
                return 25;
            }
            return 16;

        case 39: // '\''
            attrDelimiter = '\'';
            nextChar();
            if(current == -1)
                throw createXMLException("unexpected.eof");
            if(current != 39 && current != 38 && current != 37)
                do
                    nextChar();
                while(current != -1 && current != 39 && current != 38 && current != 37);
            switch(current)
            {
            default:
                throw createXMLException("invalid.character");

            case 37: // '%'
            case 38: // '&'
                context = 17;
                break;

            case 39: // '\''
                nextChar();
                return 25;
            }
            return 16;
        }
        return readName(14);
    }

    protected int nextInEntityValue()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 38: // '&'
            return readReference();

        case 37: // '%'
            int i = nextChar();
            readName(34);
            if(current != 59)
            {
                throw createXMLException("invalid.parameter.entity");
            } else
            {
                nextChar();
                return i;
            }
        }
        while(current != -1 && current != attrDelimiter && current != 38 && current != 37) 
            nextChar();
        switch(current)
        {
        case -1: 
            throw createXMLException("unexpected.eof");

        case 34: // '"'
        case 39: // '\''
            nextChar();
            context = 13;
            return 25;
        }
        return 16;
    }

    protected int nextInNotationType()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 124: // '|'
            nextChar();
            return 42;

        case 40: // '('
            nextChar();
            return 40;

        case 41: // ')'
            nextChar();
            context = 11;
            return 41;
        }
        return readName(14);
    }

    protected int nextInEnumeration()
        throws IOException, XMLException
    {
        switch(current)
        {
        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
        case 32: // ' '
            do
                nextChar();
            while(current != -1 && XMLUtilities.isXMLSpace((char)current));
            return 1;

        case 124: // '|'
            nextChar();
            return 42;

        case 41: // ')'
            nextChar();
            context = 11;
            return 41;
        }
        return readNmtoken();
    }

    protected int readReference()
        throws IOException, XMLException
    {
        nextChar();
        if(current == 35)
        {
            nextChar();
            int i = 0;
            switch(current)
            {
            case 120: // 'x'
                do
                {
                    i++;
                    nextChar();
                } while(current >= 48 && current <= 57 || current >= 97 && current <= 102 || current >= 65 && current <= 70);
                break;

            default:
                do
                {
                    i++;
                    nextChar();
                } while(current >= 48 && current <= 57);
                break;

            case -1: 
                throw createXMLException("unexpected.eof");
            }
            if(i == 1 || current != 59)
            {
                throw createXMLException("character.reference");
            } else
            {
                nextChar();
                return 12;
            }
        }
        int j = readName(13);
        if(current != 59)
        {
            throw createXMLException("character.reference");
        } else
        {
            nextChar();
            return j;
        }
    }

    protected int readPEReference()
        throws IOException, XMLException
    {
        nextChar();
        if(current == -1)
            throw createXMLException("unexpected.eof");
        if(!XMLUtilities.isXMLNameFirstCharacter((char)current))
            throw createXMLException("invalid.parameter.entity");
        do
            nextChar();
        while(current != -1 && XMLUtilities.isXMLNameCharacter((char)current));
        if(current != 59)
        {
            throw createXMLException("invalid.parameter.entity");
        } else
        {
            nextChar();
            return 34;
        }
    }

    protected int readNmtoken()
        throws IOException, XMLException
    {
        if(current == -1)
            throw createXMLException("unexpected.eof");
        for(; XMLUtilities.isXMLNameCharacter((char)current); nextChar());
        return 56;
    }

    protected int nextChar()
        throws IOException
    {
        current = reader.read();
        if(current == -1)
            return current;
        if(position == buffer.length)
        {
            char ac[] = new char[(position * 3) / 2];
            for(int i = 0; i < position; i++)
                ac[i] = buffer[i];

            buffer = ac;
        }
        return buffer[position++] = (char)current;
    }

    protected XMLException createXMLException(String s)
    {
        String s1;
        try
        {
            s1 = formatMessage(s, new Object[] {
                new Integer(reader.getLine()), new Integer(reader.getColumn())
            });
        }
        catch(MissingResourceException missingresourceexception)
        {
            s1 = s;
        }
        return new XMLException(s1);
    }

    public static final int DOCUMENT_START_CONTEXT = 0;
    public static final int TOP_LEVEL_CONTEXT = 1;
    public static final int PI_CONTEXT = 2;
    public static final int XML_DECL_CONTEXT = 3;
    public static final int DOCTYPE_CONTEXT = 4;
    public static final int START_TAG_CONTEXT = 5;
    public static final int CONTENT_CONTEXT = 6;
    public static final int DTD_DECLARATIONS_CONTEXT = 7;
    public static final int CDATA_SECTION_CONTEXT = 8;
    public static final int END_TAG_CONTEXT = 9;
    public static final int ATTRIBUTE_VALUE_CONTEXT = 10;
    public static final int ATTLIST_CONTEXT = 11;
    public static final int ELEMENT_DECLARATION_CONTEXT = 12;
    public static final int ENTITY_CONTEXT = 13;
    public static final int NOTATION_CONTEXT = 14;
    public static final int NOTATION_TYPE_CONTEXT = 15;
    public static final int ENUMERATION_CONTEXT = 16;
    public static final int ENTITY_VALUE_CONTEXT = 17;
    protected static final String BUNDLE_CLASSNAME = "org.apache.batik.xml.resources.Messages";
    protected LocalizableSupport localizableSupport;
    protected NormalizingReader reader;
    protected int current;
    protected int type;
    protected char buffer[];
    protected int position;
    protected int start;
    protected int end;
    protected int context;
    protected int depth;
    protected boolean piEndRead;
    protected boolean inDTD;
    protected char attrDelimiter;
    protected boolean cdataEndRead;
}
