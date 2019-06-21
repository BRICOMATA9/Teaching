// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;


public class TranscoderException extends Exception
{

    public TranscoderException(String s)
    {
        TranscoderException(s, null);
    }

    public TranscoderException(Exception exception)
    {
        TranscoderException(null, exception);
    }

    public TranscoderException(String s, Exception exception)
    {
        Exception(s);
        ex = exception;
    }

    public String getMessage()
    {
        String s = getMessage();
        if(ex != null)
        {
            s = s + "\nEnclosed Exception:\n";
            s = s + ex.getMessage();
        }
        return s;
    }

    public Exception getException()
    {
        return ex;
    }

    protected Exception ex;
}
