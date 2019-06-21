// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultTransformListHandler, ParseException, TransformListHandler, 
//            ErrorHandler

public class TransformListParser extends NumberParser
{

    public TransformListParser()
    {
        transformListHandler = DefaultTransformListHandler.INSTANCE;
    }

    public void setTransformListHandler(TransformListHandler transformlisthandler)
    {
        transformListHandler = transformlisthandler;
    }

    public TransformListHandler getTransformListHandler()
    {
        return transformListHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        transformListHandler.startTransformList();
_L9:
        current = reader.read();
        current;
        JVM INSTR lookupswitch 10: default 228
    //                   -1: 225
    //                   9: 116
    //                   10: 116
    //                   13: 116
    //                   32: 116
    //                   44: 116
    //                   109: 119
    //                   114: 126
    //                   115: 140
    //                   116: 133;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L5 _L6 _L7
_L4:
        parseMatrix();
          goto _L3
_L5:
        parseRotate();
          goto _L3
_L7:
        parseTranslate();
          goto _L3
_L6:
        current = reader.read();
        switch(current)
        {
        case 99: // 'c'
            parseScale();
            break;

        case 107: // 'k'
            parseSkew();
            break;

        default:
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            skipTransform();
            break;
        }
_L3:
        if(true) goto _L9; else goto _L8
_L8:
_L1:
        try
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            skipTransform();
        }
        catch(ParseException parseexception)
        {
            errorHandler.error(parseexception);
            skipTransform();
        }
          goto _L9
_L2:
        skipSpaces();
        if(current != -1)
            reportError("end.of.stream.expected", new Object[] {
                new Integer(current)
            });
        transformListHandler.endTransformList();
        return;
    }

    protected void parseMatrix()
        throws ParseException, IOException
    {
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 105)
        {
            reportError("character.expected", new Object[] {
                new Character('i'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 120)
        {
            reportError("character.expected", new Object[] {
                new Character('x'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipCommaSpaces();
        float f1 = parseFloat();
        skipCommaSpaces();
        float f2 = parseFloat();
        skipCommaSpaces();
        float f3 = parseFloat();
        skipCommaSpaces();
        float f4 = parseFloat();
        skipCommaSpaces();
        float f5 = parseFloat();
        skipSpaces();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            skipTransform();
            return;
        } else
        {
            transformListHandler.matrix(f, f1, f2, f3, f4, f5);
            return;
        }
    }

    protected void parseRotate()
        throws ParseException, IOException
    {
        current = reader.read();
        if(current != 111)
        {
            reportError("character.expected", new Object[] {
                new Character('o'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipSpaces();
        switch(current)
        {
        case 41: // ')'
            transformListHandler.rotate(f);
            return;

        case 44: // ','
            current = reader.read();
            skipSpaces();
            break;
        }
        float f1 = parseFloat();
        skipCommaSpaces();
        float f2 = parseFloat();
        skipSpaces();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            skipTransform();
            return;
        } else
        {
            transformListHandler.rotate(f, f1, f2);
            return;
        }
    }

    protected void parseTranslate()
        throws ParseException, IOException
    {
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 110)
        {
            reportError("character.expected", new Object[] {
                new Character('n'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 115)
        {
            reportError("character.expected", new Object[] {
                new Character('s'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 108)
        {
            reportError("character.expected", new Object[] {
                new Character('l'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipSpaces();
        switch(current)
        {
        case 41: // ')'
            transformListHandler.translate(f);
            return;

        case 44: // ','
            current = reader.read();
            skipSpaces();
            break;
        }
        float f1 = parseFloat();
        skipSpaces();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            skipTransform();
            return;
        } else
        {
            transformListHandler.translate(f, f1);
            return;
        }
    }

    protected void parseScale()
        throws ParseException, IOException
    {
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 108)
        {
            reportError("character.expected", new Object[] {
                new Character('l'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipSpaces();
        switch(current)
        {
        case 41: // ')'
            transformListHandler.scale(f);
            return;

        case 44: // ','
            current = reader.read();
            skipSpaces();
            break;
        }
        float f1 = parseFloat();
        skipSpaces();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            skipTransform();
            return;
        } else
        {
            transformListHandler.scale(f, f1);
            return;
        }
    }

    protected void parseSkew()
        throws ParseException, IOException
    {
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        if(current != 119)
        {
            reportError("character.expected", new Object[] {
                new Character('w'), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        boolean flag = false;
        switch(current)
        {
        default:
            reportError("character.expected", new Object[] {
                new Character('X'), new Integer(current)
            });
            skipTransform();
            return;

        case 88: // 'X'
            flag = true;
            // fall through

        case 89: // 'Y'
            current = reader.read();
            break;
        }
        skipSpaces();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            skipTransform();
            return;
        }
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipSpaces();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            skipTransform();
            return;
        }
        if(flag)
            transformListHandler.skewX(f);
        else
            transformListHandler.skewY(f);
    }

    protected void skipTransform()
        throws IOException
    {
label0:
        do
        {
            current = reader.read();
            switch(current)
            {
            case 41: // ')'
                break label0;
            }
        } while(current != -1);
    }

    protected TransformListHandler transformListHandler;
}
