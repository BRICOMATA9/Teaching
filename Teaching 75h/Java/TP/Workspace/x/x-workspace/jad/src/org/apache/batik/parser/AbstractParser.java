// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;

import java.io.*;
import java.util.Locale;
import java.util.MissingResourceException;
import org.apache.batik.i18n.LocalizableSupport;
import org.apache.batik.util.io.*;

// Referenced classes of package org.apache.batik.parser:
//            Parser, DefaultErrorHandler, ParseException, ErrorHandler

public abstract class AbstractParser
    implements Parser
{

    public AbstractParser()
    {
        errorHandler = new DefaultErrorHandler();
        localizableSupport = new LocalizableSupport("org.apache.batik.parser.resources.Messages", (org.apache.batik.parser.AbstractParser.class).getClassLoader());
    }

    public int getCurrent()
    {
        return current;
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

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        errorHandler = errorhandler;
    }

    public void parse(Reader reader1)
        throws ParseException
    {
        try
        {
            reader = new StreamNormalizingReader(reader1);
            doParse();
        }
        catch(IOException ioexception)
        {
            errorHandler.error(new ParseException(createErrorMessage("io.exception", null), ioexception));
        }
    }

    public void parse(InputStream inputstream, String s)
        throws ParseException
    {
        try
        {
            reader = new StreamNormalizingReader(inputstream, s);
            doParse();
        }
        catch(IOException ioexception)
        {
            errorHandler.error(new ParseException(createErrorMessage("io.exception", null), ioexception));
        }
    }

    public void parse(String s)
        throws ParseException
    {
        try
        {
            reader = new StringNormalizingReader(s);
            doParse();
        }
        catch(IOException ioexception)
        {
            errorHandler.error(new ParseException(createErrorMessage("io.exception", null), ioexception));
        }
    }

    protected abstract void doParse()
        throws ParseException, IOException;

    protected void reportError(String s, Object aobj[])
        throws ParseException
    {
        errorHandler.error(new ParseException(createErrorMessage(s, aobj), reader.getLine(), reader.getColumn()));
    }

    protected String createErrorMessage(String s, Object aobj[])
    {
        return formatMessage(s, aobj);
        MissingResourceException missingresourceexception;
        missingresourceexception;
        return s;
    }

    protected String getBundleClassName()
    {
        return "org.apache.batik.parser.resources.Messages";
    }

    protected void skipSpaces()
        throws IOException
    {
        do
            switch(current)
            {
            default:
                return;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                current = reader.read();
                break;
            }
        while(true);
    }

    protected void skipCommaSpaces()
        throws IOException
    {
label0:
        do
            switch(current)
            {
            default:
                break label0;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                current = reader.read();
                break;
            }
        while(true);
        if(current == 44)
label1:
            do
                switch(current = reader.read())
                {
                default:
                    break label1;

                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    break;
                }
            while(true);
    }

    public static final String BUNDLE_CLASSNAME = "org.apache.batik.parser.resources.Messages";
    protected ErrorHandler errorHandler;
    protected LocalizableSupport localizableSupport;
    protected NormalizingReader reader;
    protected int current;
}
