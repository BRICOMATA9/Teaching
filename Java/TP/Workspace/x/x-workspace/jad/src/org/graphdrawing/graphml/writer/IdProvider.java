// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;


// Referenced classes of package org.graphdrawing.graphml.writer:
//            GraphMLWriteContext

public interface IdProvider
{

    public abstract String getGraphId(Object obj, GraphMLWriteContext graphmlwritecontext);

    public abstract String getNodeId(Object obj, GraphMLWriteContext graphmlwritecontext);

    public abstract String getEdgeId(Object obj, GraphMLWriteContext graphmlwritecontext);

    public abstract String getPortId(Object obj, Object obj1, GraphMLWriteContext graphmlwritecontext);

    public abstract String getHyperedgeId(Object obj, GraphMLWriteContext graphmlwritecontext);
}
