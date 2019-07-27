// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;


// Referenced classes of package org.graphdrawing.graphml.writer:
//            GraphMLWriteContext, XmlWriter

public interface OutputHandler
{

    public abstract void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printDataAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);

    public abstract void printDataOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter);
}
