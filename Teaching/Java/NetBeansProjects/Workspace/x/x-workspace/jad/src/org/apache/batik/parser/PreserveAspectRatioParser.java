// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            AbstractParser, DefaultPreserveAspectRatioHandler, ParseException, PreserveAspectRatioHandler

public class PreserveAspectRatioParser extends AbstractParser
{

    public PreserveAspectRatioParser()
    {
        preserveAspectRatioHandler = DefaultPreserveAspectRatioHandler.INSTANCE;
    }

    public void setPreserveAspectRatioHandler(PreserveAspectRatioHandler preserveaspectratiohandler)
    {
        preserveAspectRatioHandler = preserveaspectratiohandler;
    }

    public PreserveAspectRatioHandler getPreserveAspectRatioHandler()
    {
        return preserveAspectRatioHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        current = reader.read();
        skipSpaces();
        parsePreserveAspectRatio();
    }

    protected void parsePreserveAspectRatio()
        throws ParseException, IOException
    {
        preserveAspectRatioHandler.startPreserveAspectRatio();
label0:
        switch(current)
        {
        case 110: // 'n'
            current = reader.read();
            if(current != 111)
            {
                reportError("character.expected", new Object[] {
                    new Character('o'), new Integer(current)
                });
                skipIdentifier();
            } else
            {
                current = reader.read();
                if(current != 110)
                {
                    reportError("character.expected", new Object[] {
                        new Character('n'), new Integer(current)
                    });
                    skipIdentifier();
                } else
                {
                    current = reader.read();
                    if(current != 101)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('e'), new Integer(current)
                        });
                        skipIdentifier();
                    } else
                    {
                        current = reader.read();
                        skipSpaces();
                        preserveAspectRatioHandler.none();
                    }
                }
            }
            break;

        case 120: // 'x'
            current = reader.read();
            if(current != 77)
            {
                reportError("character.expected", new Object[] {
                    new Character('M'), new Integer(current)
                });
                skipIdentifier();
                break;
            }
            current = reader.read();
            switch(current)
            {
            case 97: // 'a'
                current = reader.read();
                if(current != 120)
                {
                    reportError("character.expected", new Object[] {
                        new Character('x'), new Integer(current)
                    });
                    skipIdentifier();
                    break label0;
                }
                current = reader.read();
                if(current != 89)
                {
                    reportError("character.expected", new Object[] {
                        new Character('Y'), new Integer(current)
                    });
                    skipIdentifier();
                    break label0;
                }
                current = reader.read();
                if(current != 77)
                {
                    reportError("character.expected", new Object[] {
                        new Character('M'), new Integer(current)
                    });
                    skipIdentifier();
                    break label0;
                }
                current = reader.read();
                switch(current)
                {
                default:
                    break;

                case 97: // 'a'
                    current = reader.read();
                    if(current != 120)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('x'), new Integer(current)
                        });
                        skipIdentifier();
                    } else
                    {
                        preserveAspectRatioHandler.xMaxYMax();
                        current = reader.read();
                    }
                    break label0;

                case 105: // 'i'
                    current = reader.read();
                    switch(current)
                    {
                    case 100: // 'd'
                        preserveAspectRatioHandler.xMaxYMid();
                        current = reader.read();
                        break;

                    case 110: // 'n'
                        preserveAspectRatioHandler.xMaxYMin();
                        current = reader.read();
                        break;

                    default:
                        reportError("character.unexpected", new Object[] {
                            new Integer(current)
                        });
                        skipIdentifier();
                        break;
                    }
                    break;
                }
                break label0;

            case 105: // 'i'
                current = reader.read();
                switch(current)
                {
                case 100: // 'd'
                    current = reader.read();
                    if(current != 89)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('Y'), new Integer(current)
                        });
                        skipIdentifier();
                        break label0;
                    }
                    current = reader.read();
                    if(current != 77)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('M'), new Integer(current)
                        });
                        skipIdentifier();
                        break label0;
                    }
                    current = reader.read();
                    switch(current)
                    {
                    default:
                        break;

                    case 97: // 'a'
                        current = reader.read();
                        if(current != 120)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('x'), new Integer(current)
                            });
                            skipIdentifier();
                        } else
                        {
                            preserveAspectRatioHandler.xMidYMax();
                            current = reader.read();
                        }
                        break label0;

                    case 105: // 'i'
                        current = reader.read();
                        switch(current)
                        {
                        case 100: // 'd'
                            preserveAspectRatioHandler.xMidYMid();
                            current = reader.read();
                            break;

                        case 110: // 'n'
                            preserveAspectRatioHandler.xMidYMin();
                            current = reader.read();
                            break;

                        default:
                            reportError("character.unexpected", new Object[] {
                                new Integer(current)
                            });
                            skipIdentifier();
                            break;
                        }
                        break;
                    }
                    break label0;

                case 110: // 'n'
                    current = reader.read();
                    if(current != 89)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('Y'), new Integer(current)
                        });
                        skipIdentifier();
                        break label0;
                    }
                    current = reader.read();
                    if(current != 77)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('M'), new Integer(current)
                        });
                        skipIdentifier();
                        break label0;
                    }
                    current = reader.read();
                    switch(current)
                    {
                    default:
                        break;

                    case 97: // 'a'
                        current = reader.read();
                        if(current != 120)
                        {
                            reportError("character.expected", new Object[] {
                                new Character('x'), new Integer(current)
                            });
                            skipIdentifier();
                        } else
                        {
                            preserveAspectRatioHandler.xMinYMax();
                            current = reader.read();
                        }
                        break label0;

                    case 105: // 'i'
                        current = reader.read();
                        switch(current)
                        {
                        case 100: // 'd'
                            preserveAspectRatioHandler.xMinYMid();
                            current = reader.read();
                            break;

                        case 110: // 'n'
                            preserveAspectRatioHandler.xMinYMin();
                            current = reader.read();
                            break;

                        default:
                            reportError("character.unexpected", new Object[] {
                                new Integer(current)
                            });
                            skipIdentifier();
                            break;
                        }
                        break;
                    }
                    break;

                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    skipIdentifier();
                    break;
                }
                break;

            default:
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipIdentifier();
                break;
            }
            break;

        default:
            if(current != -1)
            {
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipIdentifier();
            }
            break;
        }
        skipCommaSpaces();
        switch(current)
        {
        case 109: // 'm'
            current = reader.read();
            if(current != 101)
            {
                reportError("character.expected", new Object[] {
                    new Character('e'), new Integer(current)
                });
                skipIdentifier();
            } else
            {
                current = reader.read();
                if(current != 101)
                {
                    reportError("character.expected", new Object[] {
                        new Character('e'), new Integer(current)
                    });
                    skipIdentifier();
                } else
                {
                    current = reader.read();
                    if(current != 116)
                    {
                        reportError("character.expected", new Object[] {
                            new Character('t'), new Integer(current)
                        });
                        skipIdentifier();
                    } else
                    {
                        preserveAspectRatioHandler.meet();
                        current = reader.read();
                    }
                }
            }
            break;

        case 115: // 's'
            current = reader.read();
            if(current != 108)
            {
                reportError("character.expected", new Object[] {
                    new Character('l'), new Integer(current)
                });
                skipIdentifier();
                break;
            }
            current = reader.read();
            if(current != 105)
            {
                reportError("character.expected", new Object[] {
                    new Character('i'), new Integer(current)
                });
                skipIdentifier();
                break;
            }
            current = reader.read();
            if(current != 99)
            {
                reportError("character.expected", new Object[] {
                    new Character('c'), new Integer(current)
                });
                skipIdentifier();
                break;
            }
            current = reader.read();
            if(current != 101)
            {
                reportError("character.expected", new Object[] {
                    new Character('e'), new Integer(current)
                });
                skipIdentifier();
            } else
            {
                preserveAspectRatioHandler.slice();
                current = reader.read();
            }
            break;

        default:
            if(current != -1)
            {
                reportError("character.unexpected", new Object[] {
                    new Integer(current)
                });
                skipIdentifier();
            }
            break;
        }
        skipSpaces();
        if(current != -1)
            reportError("end.of.stream.expected", new Object[] {
                new Integer(current)
            });
        preserveAspectRatioHandler.endPreserveAspectRatio();
    }

    protected void skipIdentifier()
        throws IOException
    {
        do
        {
            current = reader.read();
            switch(current)
            {
            default:
                continue;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                current = reader.read();
                break;
            }
            break;
        } while(current != -1);
    }

    protected PreserveAspectRatioHandler preserveAspectRatioHandler;
}
