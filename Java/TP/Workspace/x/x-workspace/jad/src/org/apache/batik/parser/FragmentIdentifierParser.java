// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;
import org.apache.batik.xml.XMLUtilities;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultFragmentIdentifierHandler, ParseException, FragmentIdentifierHandler, 
//            ErrorHandler

public class FragmentIdentifierParser extends NumberParser
{

    public FragmentIdentifierParser()
    {
        buffer = new char[16];
        fragmentIdentifierHandler = DefaultFragmentIdentifierHandler.INSTANCE;
    }

    public void setFragmentIdentifierHandler(FragmentIdentifierHandler fragmentidentifierhandler)
    {
        fragmentIdentifierHandler = fragmentidentifierhandler;
    }

    public FragmentIdentifierHandler getFragmentIdentifierHandler()
    {
        return fragmentIdentifierHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
label0:
        {
            bufferSize = 0;
            current = reader.read();
            fragmentIdentifierHandler.startFragmentIdentifier();
            String s = null;
            switch(current)
            {
            case 120: // 'x'
                bufferize();
                current = reader.read();
                if(current != 112)
                {
                    parseIdentifier();
                } else
                {
                    bufferize();
                    current = reader.read();
                    if(current != 111)
                    {
                        parseIdentifier();
                    } else
                    {
                        bufferize();
                        current = reader.read();
                        if(current != 105)
                        {
                            parseIdentifier();
                        } else
                        {
                            bufferize();
                            current = reader.read();
                            if(current != 110)
                            {
                                parseIdentifier();
                            } else
                            {
                                bufferize();
                                current = reader.read();
                                if(current != 116)
                                {
                                    parseIdentifier();
                                } else
                                {
                                    bufferize();
                                    current = reader.read();
                                    if(current != 101)
                                    {
                                        parseIdentifier();
                                    } else
                                    {
                                        bufferize();
                                        current = reader.read();
                                        if(current != 114)
                                        {
                                            parseIdentifier();
                                        } else
                                        {
                                            bufferize();
                                            current = reader.read();
                                            if(current != 40)
                                            {
                                                parseIdentifier();
                                            } else
                                            {
                                                bufferSize = 0;
                                                current = reader.read();
                                                if(current != 105)
                                                {
                                                    reportError("character.expected", new Object[] {
                                                        new Character('i'), new Integer(current)
                                                    });
                                                } else
                                                {
                                                    current = reader.read();
                                                    if(current != 100)
                                                    {
                                                        reportError("character.expected", new Object[] {
                                                            new Character('d'), new Integer(current)
                                                        });
                                                    } else
                                                    {
                                                        current = reader.read();
                                                        if(current != 40)
                                                        {
                                                            reportError("character.expected", new Object[] {
                                                                new Character('('), new Integer(current)
                                                            });
                                                        } else
                                                        {
                                                            current = reader.read();
                                                            if(current != 34 && current != 39)
                                                            {
                                                                reportError("character.expected", new Object[] {
                                                                    new Character('\''), new Integer(current)
                                                                });
                                                            } else
                                                            {
                                                                char c = (char)current;
                                                                current = reader.read();
                                                                parseIdentifier();
                                                                s = getBufferContent();
                                                                bufferSize = 0;
                                                                fragmentIdentifierHandler.idReference(s);
                                                                if(current != c)
                                                                {
                                                                    reportError("character.expected", new Object[] {
                                                                        new Character(c), new Integer(current)
                                                                    });
                                                                } else
                                                                {
                                                                    current = reader.read();
                                                                    if(current != 41)
                                                                    {
                                                                        reportError("character.expected", new Object[] {
                                                                            new Character(')'), new Integer(current)
                                                                        });
                                                                    } else
                                                                    {
                                                                        current = reader.read();
                                                                        if(current != 41)
                                                                            reportError("character.expected", new Object[] {
                                                                                new Character(')'), new Integer(current)
                                                                            });
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                break label0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;

            case 115: // 's'
                bufferize();
                current = reader.read();
                if(current != 118)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 103)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 86)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 105)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 101)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 119)
                {
                    parseIdentifier();
                    break;
                }
                bufferize();
                current = reader.read();
                if(current != 40)
                {
                    parseIdentifier();
                    break;
                }
                bufferSize = 0;
                current = reader.read();
                parseViewAttributes();
                if(current != 41)
                    reportError("character.expected", new Object[] {
                        new Character(')'), new Integer(current)
                    });
                break label0;

            default:
                if(current == -1 || !XMLUtilities.isXMLNameFirstCharacter((char)current))
                    break label0;
                bufferize();
                current = reader.read();
                parseIdentifier();
                break;
            }
            s = getBufferContent();
            fragmentIdentifierHandler.idReference(s);
        }
        fragmentIdentifierHandler.endFragmentIdentifier();
    }

    protected void parseViewAttributes()
        throws ParseException, IOException
    {
        boolean flag = true;
_L15:
        current;
        JVM INSTR lookupswitch 7: default 103
    //                   -1: 72
    //                   41: 72
    //                   59: 106
    //                   112: 1490
    //                   116: 2690
    //                   118: 151
    //                   122: 3441;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        if(flag)
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
        break; /* Loop/switch isn't completed */
_L3:
        if(flag)
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        continue; /* Loop/switch isn't completed */
_L6:
        flag = false;
        current = reader.read();
        if(current != 105)
        {
            reportError("character.expected", new Object[] {
                new Character('i'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 119)
        {
            reportError("character.expected", new Object[] {
                new Character('w'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        switch(current)
        {
        case 66: // 'B'
            current = reader.read();
            if(current != 111)
            {
                reportError("character.expected", new Object[] {
                    new Character('o'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 120)
            {
                reportError("character.expected", new Object[] {
                    new Character('x'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 40)
            {
                reportError("character.expected", new Object[] {
                    new Character('('), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            float f = parseFloat();
            if(current != 44)
            {
                reportError("character.expected", new Object[] {
                    new Character(','), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            float f1 = parseFloat();
            if(current != 44)
            {
                reportError("character.expected", new Object[] {
                    new Character(','), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            float f2 = parseFloat();
            if(current != 44)
            {
                reportError("character.expected", new Object[] {
                    new Character(','), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            float f3 = parseFloat();
            if(current != 41)
            {
                reportError("character.expected", new Object[] {
                    new Character(')'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            fragmentIdentifierHandler.viewBox(f, f1, f2, f3);
            if(current == 41 || current == 59)
                continue; /* Loop/switch isn't completed */
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */

        case 84: // 'T'
            current = reader.read();
            if(current != 97)
            {
                reportError("character.expected", new Object[] {
                    new Character('a'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 114)
            {
                reportError("character.expected", new Object[] {
                    new Character('r'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 103)
            {
                reportError("character.expected", new Object[] {
                    new Character('g'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 101)
            {
                reportError("character.expected", new Object[] {
                    new Character('e'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 116)
            {
                reportError("character.expected", new Object[] {
                    new Character('t'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 40)
            {
                reportError("character.expected", new Object[] {
                    new Character('('), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            fragmentIdentifierHandler.startViewTarget();
label0:
            do
            {
                bufferSize = 0;
                if(current == -1 || !XMLUtilities.isXMLNameFirstCharacter((char)current))
                {
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    break; /* Loop/switch isn't completed */
                }
                bufferize();
                current = reader.read();
                parseIdentifier();
                String s = getBufferContent();
                fragmentIdentifierHandler.viewTarget(s);
                bufferSize = 0;
                switch(current)
                {
                case 41: // ')'
                    current = reader.read();
                    break label0;

                case 44: // ','
                case 59: // ';'
                    current = reader.read();
                    break;

                default:
                    reportError("character.unexpected", new Object[] {
                        new Integer(current)
                    });
                    break; /* Loop/switch isn't completed */
                }
            } while(true);
            fragmentIdentifierHandler.endViewTarget();
            continue; /* Loop/switch isn't completed */

        default:
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            break;
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag = false;
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 115)
        {
            reportError("character.expected", new Object[] {
                new Character('s'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 118)
        {
            reportError("character.expected", new Object[] {
                new Character('v'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 65)
        {
            reportError("character.expected", new Object[] {
                new Character('A'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 115)
        {
            reportError("character.expected", new Object[] {
                new Character('s'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 112)
        {
            reportError("character.expected", new Object[] {
                new Character('p'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 101)
        {
            reportError("character.expected", new Object[] {
                new Character('e'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 99)
        {
            reportError("character.expected", new Object[] {
                new Character('c'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 82)
        {
            reportError("character.expected", new Object[] {
                new Character('R'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 116)
        {
            reportError("character.expected", new Object[] {
                new Character('t'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 105)
        {
            reportError("character.expected", new Object[] {
                new Character('i'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 111)
        {
            reportError("character.expected", new Object[] {
                new Character('o'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        parsePreserveAspectRatio();
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        continue; /* Loop/switch isn't completed */
_L5:
        flag = false;
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 110)
        {
            reportError("character.expected", new Object[] {
                new Character('n'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 115)
        {
            reportError("character.expected", new Object[] {
                new Character('s'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 102)
        {
            reportError("character.expected", new Object[] {
                new Character('f'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 111)
        {
            reportError("character.expected", new Object[] {
                new Character('o'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 114)
        {
            reportError("character.expected", new Object[] {
                new Character('r'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 109)
        {
            reportError("character.expected", new Object[] {
                new Character('m'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        fragmentIdentifierHandler.startTransformList();
_L9:
        current = reader.read();
        current;
        JVM INSTR lookupswitch 5: default 3405
    //                   44: 3296
    //                   109: 3299
    //                   114: 3306
    //                   115: 3320
    //                   116: 3313;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L10:
        parseMatrix();
          goto _L9
_L11:
        parseRotate();
          goto _L9
_L13:
        parseTranslate();
          goto _L9
_L12:
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
          goto _L9
        ParseException parseexception;
        parseexception;
        errorHandler.error(parseexception);
        skipTransform();
          goto _L9
_L8:
        fragmentIdentifierHandler.endTransformList();
        continue; /* Loop/switch isn't completed */
_L7:
        flag = false;
        current = reader.read();
        if(current != 111)
        {
            reportError("character.expected", new Object[] {
                new Character('o'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 111)
        {
            reportError("character.expected", new Object[] {
                new Character('o'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 109)
        {
            reportError("character.expected", new Object[] {
                new Character('m'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 65)
        {
            reportError("character.expected", new Object[] {
                new Character('A'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 110)
        {
            reportError("character.expected", new Object[] {
                new Character('n'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 100)
        {
            reportError("character.expected", new Object[] {
                new Character('d'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 80)
        {
            reportError("character.expected", new Object[] {
                new Character('P'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 97)
        {
            reportError("character.expected", new Object[] {
                new Character('a'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 110)
        {
            reportError("character.expected", new Object[] {
                new Character('n'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(current != 40)
        {
            reportError("character.expected", new Object[] {
                new Character('('), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        switch(current)
        {
        case 109: // 'm'
            current = reader.read();
            if(current != 97)
            {
                reportError("character.expected", new Object[] {
                    new Character('a'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 103)
            {
                reportError("character.expected", new Object[] {
                    new Character('g'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 110)
            {
                reportError("character.expected", new Object[] {
                    new Character('n'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 105)
            {
                reportError("character.expected", new Object[] {
                    new Character('i'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 102)
            {
                reportError("character.expected", new Object[] {
                    new Character('f'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 121)
            {
                reportError("character.expected", new Object[] {
                    new Character('y'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            fragmentIdentifierHandler.zoomAndPan(true);
            break;

        case 100: // 'd'
            current = reader.read();
            if(current != 105)
            {
                reportError("character.expected", new Object[] {
                    new Character('i'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 115)
            {
                reportError("character.expected", new Object[] {
                    new Character('s'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 97)
            {
                reportError("character.expected", new Object[] {
                    new Character('a'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 98)
            {
                reportError("character.expected", new Object[] {
                    new Character('b'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 108)
            {
                reportError("character.expected", new Object[] {
                    new Character('l'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            if(current != 101)
            {
                reportError("character.expected", new Object[] {
                    new Character('e'), new Integer(current)
                });
                break; /* Loop/switch isn't completed */
            }
            current = reader.read();
            fragmentIdentifierHandler.zoomAndPan(false);
            break;

        default:
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        if(current != 41)
        {
            reportError("character.expected", new Object[] {
                new Character(')'), new Integer(current)
            });
            break; /* Loop/switch isn't completed */
        }
        current = reader.read();
        if(true) goto _L15; else goto _L14
_L14:
    }

    protected void parseIdentifier()
        throws ParseException, IOException
    {
        for(; current != -1 && XMLUtilities.isXMLNameCharacter((char)current); current = reader.read())
            bufferize();

    }

    protected String getBufferContent()
    {
        return new String(buffer, 0, bufferSize);
    }

    protected void bufferize()
    {
        if(bufferSize >= buffer.length)
        {
            char ac[] = new char[buffer.length * 2];
            for(int i = 0; i < bufferSize; i++)
                ac[i] = buffer[i];

            buffer = ac;
        }
        buffer[bufferSize++] = (char)current;
    }

    protected void skipSpaces()
        throws IOException
    {
        if(current == 44)
            current = reader.read();
    }

    protected void skipCommaSpaces()
        throws IOException
    {
        if(current == 44)
            current = reader.read();
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
            fragmentIdentifierHandler.matrix(f, f1, f2, f3, f4, f5);
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
            fragmentIdentifierHandler.rotate(f);
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
            fragmentIdentifierHandler.rotate(f, f1, f2);
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
            fragmentIdentifierHandler.translate(f);
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
            fragmentIdentifierHandler.translate(f, f1);
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
            fragmentIdentifierHandler.scale(f);
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
            fragmentIdentifierHandler.scale(f, f1);
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
            fragmentIdentifierHandler.skewX(f);
        else
            fragmentIdentifierHandler.skewY(f);
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

    protected void parsePreserveAspectRatio()
        throws ParseException, IOException
    {
        fragmentIdentifierHandler.startPreserveAspectRatio();
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
                        fragmentIdentifierHandler.none();
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
                        fragmentIdentifierHandler.xMaxYMax();
                        current = reader.read();
                    }
                    break label0;

                case 105: // 'i'
                    current = reader.read();
                    switch(current)
                    {
                    case 100: // 'd'
                        fragmentIdentifierHandler.xMaxYMid();
                        current = reader.read();
                        break;

                    case 110: // 'n'
                        fragmentIdentifierHandler.xMaxYMin();
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
                            fragmentIdentifierHandler.xMidYMax();
                            current = reader.read();
                        }
                        break label0;

                    case 105: // 'i'
                        current = reader.read();
                        switch(current)
                        {
                        case 100: // 'd'
                            fragmentIdentifierHandler.xMidYMid();
                            current = reader.read();
                            break;

                        case 110: // 'n'
                            fragmentIdentifierHandler.xMidYMin();
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
                            fragmentIdentifierHandler.xMinYMax();
                            current = reader.read();
                        }
                        break label0;

                    case 105: // 'i'
                        current = reader.read();
                        switch(current)
                        {
                        case 100: // 'd'
                            fragmentIdentifierHandler.xMinYMid();
                            current = reader.read();
                            break;

                        case 110: // 'n'
                            fragmentIdentifierHandler.xMinYMin();
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
        default:
            break;

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
                        fragmentIdentifierHandler.meet();
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
                fragmentIdentifierHandler.slice();
                current = reader.read();
            }
            break;
        }
        fragmentIdentifierHandler.endPreserveAspectRatio();
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

            case -1: 
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                current = reader.read();
                break;
            }
            break;
        } while(true);
    }

    protected char buffer[];
    protected int bufferSize;
    protected FragmentIdentifierHandler fragmentIdentifierHandler;
}
