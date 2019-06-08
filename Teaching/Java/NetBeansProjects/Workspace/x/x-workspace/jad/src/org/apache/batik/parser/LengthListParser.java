// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.IOException;
import org.apache.batik.util.io.NormalizingReader;

// Referenced classes of package org.apache.batik.parser:
//            LengthParser, DefaultLengthListHandler, LengthListHandler, ParseException, 
//            LengthHandler

public class LengthListParser extends LengthParser
{

    public LengthListParser()
    {
        lengthHandler = DefaultLengthListHandler.INSTANCE;
    }

    public void setLengthListHandler(LengthListHandler lengthlisthandler)
    {
        lengthHandler = lengthlisthandler;
    }

    public LengthListHandler getLengthListHandler()
    {
        return (LengthListHandler)lengthHandler;
    }

    protected void doParse()
        throws ParseException, IOException
    {
        ((LengthListHandler)lengthHandler).startLengthList();
        current = reader.read();
        skipSpaces();
        try
        {
            do
            {
                lengthHandler.startLength();
                parseLength();
                lengthHandler.endLength();
                skipCommaSpaces();
            } while(current != -1);
        }
        catch(NumberFormatException numberformatexception)
        {
            reportError("character.unexpected", new Object[] {
                new Integer(current)
            });
        }
        ((LengthListHandler)lengthHandler).endLengthList();
    }
}
