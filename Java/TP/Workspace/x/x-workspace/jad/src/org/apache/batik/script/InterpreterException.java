// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.script;


public class InterpreterException extends Exception
{

    public InterpreterException(String s, int i, int j)
    {
        super(s);
        line = -1;
        column = -1;
        embedded = null;
        line = i;
        column = j;
    }

    public InterpreterException(Exception exception, String s, int i, int j)
    {
        this(s, i, j);
        embedded = exception;
    }

    public int getLineNumber()
    {
        return line;
    }

    public int getColumnNumber()
    {
        return column;
    }

    public Exception getException()
    {
        return embedded;
    }

    public String getMessage()
    {
        String s = super.getMessage();
        if(s != null)
            return s;
        if(embedded != null)
            return embedded.getMessage();
        else
            return null;
    }

    private int line;
    private int column;
    private Exception embedded;
}
