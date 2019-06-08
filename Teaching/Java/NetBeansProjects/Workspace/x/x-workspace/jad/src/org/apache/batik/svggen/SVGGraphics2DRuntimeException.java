// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;


public class SVGGraphics2DRuntimeException extends RuntimeException
{

    public SVGGraphics2DRuntimeException(String s)
    {
        this(s, null);
    }

    public SVGGraphics2DRuntimeException(Exception exception)
    {
        this(null, exception);
    }

    public SVGGraphics2DRuntimeException(String s, Exception exception)
    {
        super(s);
        embedded = exception;
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

    public Exception getException()
    {
        return embedded;
    }

    private Exception embedded;
}
