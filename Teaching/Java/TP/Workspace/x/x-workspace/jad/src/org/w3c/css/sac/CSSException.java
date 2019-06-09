// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


public class CSSException extends RuntimeException
{

    public CSSException()
    {
    }

    public CSSException(String s1)
    {
        code = SAC_UNSPECIFIED_ERR;
        s = s1;
    }

    public CSSException(Exception exception)
    {
        code = SAC_UNSPECIFIED_ERR;
        e = exception;
    }

    public CSSException(short word0)
    {
        code = word0;
    }

    public CSSException(short word0, String s1, Exception exception)
    {
        code = word0;
        s = s1;
        e = exception;
    }

    public String getMessage()
    {
        if(s != null)
            return s;
        if(e != null)
            return e.getMessage();
        else
            return null;
    }

    public short getCode()
    {
        return code;
    }

    public Exception getException()
    {
        return e;
    }

    protected String s;
    public static short SAC_UNSPECIFIED_ERR = 0;
    public static short SAC_NOT_SUPPORTED_ERR = 1;
    public static short SAC_SYNTAX_ERR = 2;
    protected Exception e;
    protected short code;

}
