// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;


// Referenced classes of package org.graphdrawing.graphml.writer:
//            GraphMLWriteException, GraphMLWriteContext

public interface GraphMLWriteErrorHandler
{

    public abstract void error(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException;

    public abstract void fatal(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException;

    public abstract void warning(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext);
}
