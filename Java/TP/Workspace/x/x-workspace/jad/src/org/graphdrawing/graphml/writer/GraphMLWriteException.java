// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.io.IOException;

public class GraphMLWriteException extends IOException
{

    public GraphMLWriteException()
    {
    }

    public GraphMLWriteException(String s)
    {
        super(s);
    }

    public GraphMLWriteException(String s, Exception exception)
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
