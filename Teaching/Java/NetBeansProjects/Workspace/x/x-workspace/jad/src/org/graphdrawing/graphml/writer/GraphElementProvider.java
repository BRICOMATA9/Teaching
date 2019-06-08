// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.util.Iterator;

public interface GraphElementProvider
{

    public abstract boolean isDefaultDirected();

    public abstract int getNodeCount();

    public abstract int getEdgeCount();

    public abstract int getHyperEdgeCount();

    public abstract Object getGraphObject();

    public abstract Iterator getNodeObjects();

    public abstract Iterator getEdgeObjects();

    public abstract GraphElementProvider getNodeSubgraph(Object obj);

    public abstract Object getSourceNode(Object obj);

    public abstract Object getTargetNode(Object obj);

    public abstract Object getSourcePort(Object obj);

    public abstract Object getTargetPort(Object obj);

    public abstract boolean isDirected(Object obj);

    public abstract Iterator getEndpointObjects(Object obj);

    public abstract Iterator getHyperEdgeObjects();

    public abstract Iterator getPortObjects(Object obj);
}
