// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.reader;


// Referenced classes of package org.graphdrawing.graphml.reader:
//            GraphMLParseContext

public interface GraphElementFactory
{

    public abstract Object createGraphML(GraphMLParseContext graphmlparsecontext);

    public abstract Object createGraph(GraphMLParseContext graphmlparsecontext, String s, int i);

    public abstract Object createNode(GraphMLParseContext graphmlparsecontext, String s);

    public abstract Object createPort(GraphMLParseContext graphmlparsecontext, Object obj, String s);

    public abstract Object createEdge(GraphMLParseContext graphmlparsecontext, String s, Object obj, Object obj1, Object obj2, Object obj3, boolean flag);

    public abstract Object createHyperEdge(GraphMLParseContext graphmlparsecontext, String s);

    public abstract Object createEndPoint(GraphMLParseContext graphmlparsecontext, String s, Object obj, Object obj1, int i);

    public static final int EDGEDEFAULT_DIRECTED = 0;
    public static final int EDGEDEFAULT_UNDIRECTED = 1;
    public static final int HYPEREDGE_TYPE_INT = 0;
    public static final int HYPEREDGE_TYPE_OUT = 1;
    public static final int HYPEREDGE_TYPE_UNDIR = 2;
}
