// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


public class ParseException extends RuntimeException
{

    public ParseException(String s, int i, int j)
    {
        super(s);
        exception = null;
        lineNumber = i;
        columnNumber = j;
    }

    public ParseException(Exception exception1)
    {
        exception = exception1;
        lineNumber = -1;
        columnNumber = -1;
    }

    public ParseException(String s, Exception exception1)
    {
        super(s);
        exception = exception1;
    }

    public String getMessage()
    {
        String s = super.getMessage();
        if(s == null && exception != null)
            return exception.getMessage();
        else
            return s;
    }

    public Exception getException()
    {
        return exception;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }

    public int getColumnNumber()
    {
        return columnNumber;
    }

    protected Exception exception;
    protected int lineNumber;
    protected int columnNumber;
}
