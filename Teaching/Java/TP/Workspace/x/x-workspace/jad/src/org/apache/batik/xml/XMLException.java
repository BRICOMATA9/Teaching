// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.xml;

import java.io.PrintStream;
import java.io.PrintWriter;

public class XMLException extends RuntimeException
{

    public XMLException(String s)
    {
        RuntimeException(s);
        exception = null;
    }

    public XMLException(Exception exception1)
    {
        exception = exception1;
    }

    public XMLException(String s, Exception exception1)
    {
        RuntimeException(s);
        exception = exception1;
    }

    public String getMessage()
    {
        String s = getMessage();
        if(s == null && exception != null)
            return exception.getMessage();
        else
            return s;
    }

    public Exception getException()
    {
        return exception;
    }

    public void printStackTrace()
    {
        if(exception == null)
            printStackTrace();
        else
            synchronized(System.err)
            {
                System.err.println(this);
                printStackTrace();
            }
    }

    public void printStackTrace(PrintStream printstream)
    {
        if(exception == null)
            printStackTrace(printstream);
        else
            synchronized(printstream)
            {
                printstream.println(this);
                printStackTrace();
            }
    }

    public void printStackTrace(PrintWriter printwriter)
    {
        if(exception == null)
            printStackTrace(printwriter);
        else
            synchronized(printwriter)
            {
                printwriter.println(this);
                printStackTrace(printwriter);
            }
    }

    protected Exception exception;
}
