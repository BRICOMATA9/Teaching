// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.reader;


// Referenced classes of package org.graphdrawing.graphml.reader:
//            GraphMLParseException, GraphMLParseContext

public interface GraphMLParseErrorHandler
{

    public abstract void error(Object obj, String s, Exception exception, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException;

    public abstract void fatal(Object obj, String s, Exception exception, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException;

    public abstract void warning(Object obj, String s, Exception exception, GraphMLParseContext graphmlparsecontext);
}
