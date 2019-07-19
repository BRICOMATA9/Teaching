// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.reader;

import java.io.IOException;

public class GraphMLParseException extends IOException
{

    public GraphMLParseException()
    {
    }

    public GraphMLParseException(String s)
    {
        super(s);
    }

    public GraphMLParseException(String s, Exception exception)
    {
        innerException = exception;
        source = s;
    }

    public Exception getInnerException()
    {
        return innerException;
    }

    public String getSource()
    {
        return source;
    }

    private Exception innerException;
    private String source;
}
