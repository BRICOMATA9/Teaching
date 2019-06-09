// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultAngleHandler, ParseException, AngleHandler

public class AngleParser extends NumberParser
{

    public AngleParser()
    {
        angleHandler = DefaultAngleHandler.INSTANCE;
    }

    public void setAngleHandler(AngleHandler anglehandler)
    {
        angleHandler = anglehandler;
    }

    public AngleHandler getAngleHandler()
    {
        return angleHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        angleHandler.startAngle();
        current = reader.read();
        skipSpaces();
        try
        {
            float f = parseFloat();
            angleHandler.angleValue(f);
            if(current != -1)
                switch(current)
                {
                default:
                    switch(current)
                    {
                    case 100: // 'd'
                        current = reader.read();
                        if(current != 101)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('e'), new Integer(current)
                            });
                            break;
                        }
                        current = reader.read();
                        if(current != 103)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('g'), new Integer(current)
                            });
                        } else
                        {
                            angleHandler.deg();
                            current = reader.read();
                        }
                        break;

                    case 103: // 'g'
                        current = reader.read();
                        if(current != 114)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('r'), new Integer(current)
                            });
                            break;
                        }
                        current = reader.read();
                        if(current != 97)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('a'), new Integer(current)
                            });
                            break;
                        }
                        current = reader.read();
                        if(current != 100)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('d'), new Integer(current)
                            });
                        } else
                        {
                            angleHandler.grad();
                            current = reader.read();
                        }
                        break;

                    case 114: // 'r'
                        current = reader.read();
                        if(current != 97)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('a'), new Integer(current)
                            });
                            break;
                        }
                        current = reader.read();
                        if(current != 100)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('d'), new Integer(current)
                            });
                        } else
                        {
                            angleHandler.rad();
                            current = reader.read();
                        }
                        break;

                    default:
                        reportError("character.unexpected", new Object[] {
                            new Integer(current)
                        });
                        break;
                    }
                    break;

                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    break;
                }
            skipSpaces();
            if(current != -1)
                reportError("end.of.stream.expected", new Object[] {
                    new Integer(current)
                });
        }
        catch(NumberFormatException numberformatexception)
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
        }
        angleHandler.endAngle();
    }

    protected AngleHandler angleHandler;
}
