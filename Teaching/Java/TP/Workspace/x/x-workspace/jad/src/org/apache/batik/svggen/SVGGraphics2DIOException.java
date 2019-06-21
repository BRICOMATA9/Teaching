// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.io.IOException;

public class SVGGraphics2DIOException extends IOException
{

    public SVGGraphics2DIOException(String s)
    {
        this(s, null);
    }

    public SVGGraphics2DIOException(IOException ioexception)
    {
        this(null, ioexception);
    }

    public SVGGraphics2DIOException(String s, IOException ioexception)
    {
        super(s);
        embedded = ioexception;
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

    public IOException getException()
    {
        return embedded;
    }

    private IOException embedded;
}
