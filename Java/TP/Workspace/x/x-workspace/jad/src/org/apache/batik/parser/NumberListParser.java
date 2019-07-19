// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            NumberParser, DefaultNumberListHandler, ParseException, NumberListHandler

public class NumberListParser extends NumberParser
{

    public NumberListParser()
    {
        numberListHandler = DefaultNumberListHandler.INSTANCE;
    }

    public void setNumberListHandler(NumberListHandler numberlisthandler)
    {
        numberListHandler = numberlisthandler;
    }

    public NumberListHandler getNumberListHandler()
    {
        return numberListHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        numberListHandler.startNumberList();
        current = reader.read();
        skipSpaces();
        try
        {
            do
            {
                numberListHandler.startNumber();
                float f = parseFloat();
                numberListHandler.numberValue(f);
                numberListHandler.endNumber();
                skipCommaSpaces();
            } while(current != -1);
        }
        catch(NumberFormatException numberformatexception)
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
        }
        numberListHandler.endNumberList();
    }

    protected NumberListHandler numberListHandler;
}
