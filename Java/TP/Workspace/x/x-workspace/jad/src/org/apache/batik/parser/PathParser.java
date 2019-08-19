// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultPathHandler, ParseException, PathHandler, 
//            ErrorHandler

public class PathParser extends NumberParser
{

    public PathParser()
    {
        pathHandler = DefaultPathHandler.INSTANCE;
    }

    public void setPathHandler(PathHandler pathhandler)
    {
        pathHandler = pathhandler;
    }

    public PathHandler getPathHandler()
    {
        return pathHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        pathHandler.startPath();
        current = reader.read();
_L23:
        current;
        JVM INSTR lookupswitch 25: default 396
    //                   -1: 393
    //                   9: 236
    //                   10: 236
    //                   13: 236
    //                   32: 236
    //                   65: 386
    //                   67: 330
    //                   72: 302
    //                   76: 288
    //                   77: 284
    //                   81: 344
    //                   83: 358
    //                   84: 372
    //                   86: 316
    //                   90: 250
    //                   97: 379
    //                   99: 323
    //                   104: 295
    //                   108: 277
    //                   109: 273
    //                   113: 337
    //                   115: 351
    //                   116: 365
    //                   118: 309
    //                   122: 250;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L13
_L3:
        current = reader.read();
          goto _L23
_L13:
        current = reader.read();
        pathHandler.closePath();
          goto _L23
_L18:
        parsem();
_L17:
        parsel();
          goto _L23
_L8:
        parseM();
_L7:
        parseL();
          goto _L23
_L16:
        parseh();
          goto _L23
_L6:
        parseH();
          goto _L23
_L22:
        parsev();
          goto _L23
_L12:
        parseV();
          goto _L23
_L15:
        parsec();
          goto _L23
_L5:
        parseC();
          goto _L23
_L19:
        parseq();
          goto _L23
_L9:
        parseQ();
          goto _L23
_L20:
        parses();
          goto _L23
_L10:
        parseS();
          goto _L23
_L21:
        parset();
          goto _L23
_L11:
        parseT();
          goto _L23
_L14:
        parsea();
          goto _L23
_L4:
        parseA();
          goto _L23
_L1:
        try
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            skipSubPath();
        }
        catch(ParseException parseexception)
        {
            errorHandler.error(parseexception);
            skipSubPath();
        }
          goto _L23
_L2:
        skipSpaces();
        if(current != -1)
            reportError("end.of.stream.expected", new Object[] {
                new Integer(current)
            });
        pathHandler.endPath();
        return;
    }

    protected void parsem()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipCommaSpaces();
        float f1 = parseFloat();
        pathHandler.movetoRel(f, f1);
        skipCommaSpaces();
    }

    protected void parsel()
        throws ParseException, IOException
    {
        if(current == 108)
            current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                skipCommaSpaces();
                float f1 = parseFloat();
                pathHandler.linetoRel(f, f1);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parseM()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        float f = parseFloat();
        skipCommaSpaces();
        float f1 = parseFloat();
        pathHandler.movetoAbs(f, f1);
        skipCommaSpaces();
    }

    protected void parseL()
        throws ParseException, IOException
    {
        if(current == 76)
            current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                skipCommaSpaces();
                float f1 = parseFloat();
                pathHandler.linetoAbs(f, f1);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parseh()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                pathHandler.linetoHorizontalRel(f);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parseH()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                pathHandler.linetoHorizontalAbs(f);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parsev()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                pathHandler.linetoVerticalRel(f);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parseV()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            switch(current)
            {
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                float f = parseFloat();
                pathHandler.linetoVerticalAbs(f);
                break;

            case 44: // ','
            case 47: // '/'
            default:
                return;
            }
            skipCommaSpaces();
        } while(true);
    }

    protected void parsec()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
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
            pathHandler.curvetoCubicRel(f, f1, f2, f3, f4, f5);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseC()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
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
            pathHandler.curvetoCubicAbs(f, f1, f2, f3, f4, f5);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseq()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            float f3 = parseFloat();
            pathHandler.curvetoQuadraticRel(f, f1, f2, f3);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseQ()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            float f3 = parseFloat();
            pathHandler.curvetoQuadraticAbs(f, f1, f2, f3);
            skipCommaSpaces();
        } while(true);
    }

    protected void parses()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            float f3 = parseFloat();
            pathHandler.curvetoCubicSmoothRel(f, f1, f2, f3);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseS()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            float f3 = parseFloat();
            pathHandler.curvetoCubicSmoothAbs(f, f1, f2, f3);
            skipCommaSpaces();
        } while(true);
    }

    protected void parset()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            pathHandler.curvetoQuadraticSmoothRel(f, f1);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseT()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            pathHandler.curvetoQuadraticSmoothAbs(f, f1);
            skipCommaSpaces();
        } while(true);
    }

    protected void parsea()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            boolean flag;
            switch(current)
            {
            case 48: // '0'
                flag = false;
                break;

            case 49: // '1'
                flag = true;
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipSubPath();
                return;
            }
            current = reader.read();
            skipCommaSpaces();
            boolean flag1;
            switch(current)
            {
            case 48: // '0'
                flag1 = false;
                break;

            case 49: // '1'
                flag1 = true;
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipSubPath();
                return;
            }
            current = reader.read();
            skipCommaSpaces();
            float f3 = parseFloat();
            skipCommaSpaces();
            float f4 = parseFloat();
            pathHandler.arcRel(f, f1, f2, flag, flag1, f3, f4);
            skipCommaSpaces();
        } while(true);
    }

    protected void parseA()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        do
        {
            float f;
            switch(current)
            {
            case 44: // ','
            case 47: // '/'
            default:
                return;

            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
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
                f = parseFloat();
                break;
            }
            skipCommaSpaces();
            float f1 = parseFloat();
            skipCommaSpaces();
            float f2 = parseFloat();
            skipCommaSpaces();
            boolean flag;
            switch(current)
            {
            case 48: // '0'
                flag = false;
                break;

            case 49: // '1'
                flag = true;
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipSubPath();
                return;
            }
            current = reader.read();
            skipCommaSpaces();
            boolean flag1;
            switch(current)
            {
            case 48: // '0'
                flag1 = false;
                break;

            case 49: // '1'
                flag1 = true;
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipSubPath();
                return;
            }
            current = reader.read();
            skipCommaSpaces();
            float f3 = parseFloat();
            skipCommaSpaces();
            float f4 = parseFloat();
            pathHandler.arcAbs(f, f1, f2, flag, flag1, f3, f4);
            skipCommaSpaces();
        } while(true);
    }

    protected void skipSubPath()
        throws ParseException, IOException
    {
        do
        {
            switch(current)
            {
            case 77: // 'M'
            case 109: // 'm'
                return;
            }
            if(current == -1)
                return;
            current = reader.read();
        } while(true);
    }

    protected PathHandler pathHandler;
}
