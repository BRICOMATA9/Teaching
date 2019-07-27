// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            AbstractParser, DefaultLengthHandler, ParseException, LengthHandler, 
//            NumberParser

public class LengthParser extends AbstractParser
{

    public LengthParser()
    {
        lengthHandler = DefaultLengthHandler.INSTANCE;
    }

    public void setLengthHandler(LengthHandler lengthhandler)
    {
        lengthHandler = lengthhandler;
    }

    public LengthHandler getLengthHandler()
    {
        return lengthHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        lengthHandler.startLength();
        current = reader.read();
        skipSpaces();
        parseLength();
        skipSpaces();
        if(current != -1)
            reportError("end.of.stream.expected", new Object[] {
                new Integer(current)
            });
        lengthHandler.endLength();
    }

    protected void parseLength()
        throws ParseException, IOException
    {
        int i;
        int j;
        boolean flag;
        boolean flag1;
        int k;
        int l;
        int i1;
        boolean flag2;
        byte byte0;
label0:
        {
            i = 0;
            j = 0;
            flag = true;
            flag1 = false;
            k = 0;
            l = 0;
            i1 = 0;
            flag2 = true;
            byte0 = 0;
            switch(current)
            {
            case 45: // '-'
                flag = false;
                // fall through

            case 43: // '+'
                current = reader.read();
                // fall through

            default:
                switch(current)
                {
                case 47: // '/'
                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return;

                case 46: // '.'
                    break;

                case 48: // '0'
                    flag1 = true;
label1:
                    do
                    {
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label0;

                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label1;
                        }
                    } while(true);
                    // fall through

                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
                    flag1 = true;
label2:
                    do
                    {
                        if(j < 9)
                        {
                            j++;
                            i = i * 10 + (current - 48);
                        } else
                        {
                            i1++;
                        }
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label2;

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
                            break;
                        }
                    } while(true);
                    break;
                }
                break;
            }
        }
        if(current == 46)
        {
            current = reader.read();
label3:
            switch(current)
            {
            case 69: // 'E'
            case 101: // 'e'
            default:
                if(!flag1)
                {
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return;
                }
                break;

            case 48: // '0'
                if(j == 0)
label4:
                    do
                    {
                        current = reader.read();
                        i1--;
                        switch(current)
                        {
                        default:
                            break label3;

                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label4;
                        }
                    } while(true);
                // fall through

            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
                while(true) 
                {
                    if(j < 9)
                    {
                        j++;
                        i = i * 10 + (current - 48);
                        i1--;
                    }
                    current = reader.read();
                    switch(current)
                    {
                    default:
                        break label3;

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
                        break;
                    }
                }
                break;
            }
        }
        boolean flag3 = false;
        switch(current)
        {
        case 101: // 'e'
            flag3 = true;
            // fall through

        case 69: // 'E'
            current = reader.read();
label5:
            switch(current)
            {
            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                return;

            case 109: // 'm'
                if(!flag3)
                {
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return;
                }
                byte0 = 1;
                break;

            case 120: // 'x'
                if(!flag3)
                {
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return;
                }
                byte0 = 2;
                break;

            case 45: // '-'
                flag2 = false;
                // fall through

            case 43: // '+'
                current = reader.read();
                switch(current)
                {
                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    return;

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
                    break;
                }
                // fall through

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
                switch(current)
                {
                default:
                    break label5;

                case 48: // '0'
label6:
                    while(true) 
                    {
                        current = reader.read();
                        switch(current)
                        {
                        default:
                            break label5;

                        case 48: // '0'
                            break;

                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            break label6;
                        }
                    }
                    break;

                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
                    break;
                }
                while(true) 
                {
                    if(l < 3)
                    {
                        l++;
                        k = k * 10 + (current - 48);
                    }
                    current = reader.read();
                    switch(current)
                    {
                    default:
                        break label5;

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
                        break;
                    }
                }
                break;
            }
            break;
        }
        if(!flag2)
            k = -k;
        k += i1;
        if(!flag)
            i = -i;
        lengthHandler.lengthValue(NumberParser.buildFloat(i, k));
        switch(byte0)
        {
        case 1: // '\001'
            lengthHandler.em();
            current = reader.read();
            return;

        case 2: // '\002'
            lengthHandler.ex();
            current = reader.read();
            return;
        }
        switch(current)
        {
        default:
            break;

        case 101: // 'e'
            current = reader.read();
            switch(current)
            {
            case 109: // 'm'
                lengthHandler.em();
                current = reader.read();
                break;

            case 120: // 'x'
                lengthHandler.ex();
                current = reader.read();
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                break;
            }
            break;

        case 112: // 'p'
            current = reader.read();
            switch(current)
            {
            case 99: // 'c'
                lengthHandler.pc();
                current = reader.read();
                break;

            case 116: // 't'
                lengthHandler.pt();
                current = reader.read();
                break;

            case 120: // 'x'
                lengthHandler.px();
                current = reader.read();
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                break;
            }
            break;

        case 105: // 'i'
            current = reader.read();
            if(current != 110)
            {
                reportError("character.expected", new Object[] {
                    new Character('n'), new Integer(current)
                });
            } else
            {
                lengthHandler.in();
                current = reader.read();
            }
            break;

        case 99: // 'c'
            current = reader.read();
            if(current != 109)
            {
                reportError("character.expected", new Object[] {
                    new Character('m'), new Integer(current)
                });
            } else
            {
                lengthHandler.cm();
                current = reader.read();
            }
            break;

        case 109: // 'm'
            current = reader.read();
            if(current != 109)
            {
                reportError("character.expected", new Object[] {
                    new Character('m'), new Integer(current)
                });
            } else
            {
                lengthHandler.mm();
                current = reader.read();
            }
            break;

        case 37: // '%'
            lengthHandler.percentage();
            current = reader.read();
            break;
        }
    }

    protected LengthHandler lengthHandler;
}
