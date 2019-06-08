// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;


// Referenced classes of package org.graphdrawing.graphml.writer:
//            GraphMLWriteContext, XmlWriter

public interface XMLAttributesProvider
{

    public abstract void printNodeAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printEdgeAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printPortAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printHyperEdgeAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printGraphAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printGraphMLAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);
}
