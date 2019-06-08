// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.gvt;

import java.util.List;

// Referenced classes of package org.apache.batik.gvt:
//            GraphicsNode, CompositeGraphicsNode

public class GVTTreeWalker
{

    public GVTTreeWalker(GraphicsNode graphicsnode)
    {
        gvtRoot = graphicsnode.getRoot();
        treeRoot = graphicsnode;
        currentNode = graphicsnode;
    }

    public GraphicsNode getRoot()
    {
        return treeRoot;
    }

    public GraphicsNode getGVTRoot()
    {
        return gvtRoot;
    }

    public void setCurrentGraphicsNode(GraphicsNode graphicsnode)
    {
        if(graphicsnode.getRoot() != gvtRoot)
        {
            throw new IllegalArgumentException("The node " + graphicsnode + " is not part of the document " + gvtRoot);
        } else
        {
            currentNode = graphicsnode;
            return;
        }
    }

    public GraphicsNode getCurrentGraphicsNode()
    {
        return currentNode;
    }

    public GraphicsNode previousGraphicsNode()
    {
        GraphicsNode graphicsnode = getPreviousGraphicsNode(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    public GraphicsNode nextGraphicsNode()
    {
        GraphicsNode graphicsnode = getNextGraphicsNode(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    public GraphicsNode parentGraphicsNode()
    {
        if(currentNode == treeRoot)
            return null;
        CompositeGraphicsNode compositegraphicsnode = currentNode.getParent();
        if(compositegraphicsnode != null)
            currentNode = compositegraphicsnode;
        return compositegraphicsnode;
    }

    public GraphicsNode getNextSibling()
    {
        GraphicsNode graphicsnode = getNextSibling(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    public GraphicsNode getPreviousSibling()
    {
        GraphicsNode graphicsnode = getPreviousSibling(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    public GraphicsNode firstChild()
    {
        GraphicsNode graphicsnode = getFirstChild(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    public GraphicsNode lastChild()
    {
        GraphicsNode graphicsnode = getLastChild(currentNode);
        if(graphicsnode != null)
            currentNode = graphicsnode;
        return graphicsnode;
    }

    protected GraphicsNode getNextGraphicsNode(GraphicsNode graphicsnode)
    {
        if(graphicsnode == null)
            return null;
        GraphicsNode graphicsnode1 = getFirstChild(graphicsnode);
        if(graphicsnode1 != null)
            return graphicsnode1;
        graphicsnode1 = getNextSibling(graphicsnode);
        if(graphicsnode1 != null)
            return graphicsnode1;
        for(Object obj = graphicsnode; (obj = ((GraphicsNode) (obj)).getParent()) != null && obj != treeRoot;)
        {
            GraphicsNode graphicsnode2 = getNextSibling(((GraphicsNode) (obj)));
            if(graphicsnode2 != null)
                return graphicsnode2;
        }

        return null;
    }

    protected GraphicsNode getPreviousGraphicsNode(GraphicsNode graphicsnode)
    {
        if(graphicsnode == null)
            return null;
        if(graphicsnode == treeRoot)
            return null;
        GraphicsNode graphicsnode1 = getPreviousSibling(graphicsnode);
        if(graphicsnode1 == null)
            return graphicsnode.getParent();
        GraphicsNode graphicsnode2;
        while((graphicsnode2 = getLastChild(graphicsnode1)) != null) 
            graphicsnode1 = graphicsnode2;
        return graphicsnode1;
    }

    protected static GraphicsNode getLastChild(GraphicsNode graphicsnode)
    {
        if(!(graphicsnode instanceof CompositeGraphicsNode))
            return null;
        CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)graphicsnode;
        List list = compositegraphicsnode.getChildren();
        if(list == null)
            return null;
        if(list.size() >= 1)
            return (GraphicsNode)list.get(list.size() - 1);
        else
            return null;
    }

    protected static GraphicsNode getPreviousSibling(GraphicsNode graphicsnode)
    {
        CompositeGraphicsNode compositegraphicsnode = graphicsnode.getParent();
        if(compositegraphicsnode == null)
            return null;
        List list = compositegraphicsnode.getChildren();
        if(list == null)
            return null;
        int i = list.indexOf(graphicsnode);
        if(i - 1 >= 0)
            return (GraphicsNode)list.get(i - 1);
        else
            return null;
    }

    protected static GraphicsNode getFirstChild(GraphicsNode graphicsnode)
    {
        if(!(graphicsnode instanceof CompositeGraphicsNode))
            return null;
        CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)graphicsnode;
        List list = compositegraphicsnode.getChildren();
        if(list == null)
            return null;
        if(list.size() >= 1)
            return (GraphicsNode)list.get(0);
        else
            return null;
    }

    protected static GraphicsNode getNextSibling(GraphicsNode graphicsnode)
    {
        CompositeGraphicsNode compositegraphicsnode = graphicsnode.getParent();
        if(compositegraphicsnode == null)
            return null;
        List list = compositegraphicsnode.getChildren();
        if(list == null)
            return null;
        int i = list.indexOf(graphicsnode);
        if(i + 1 < list.size())
            return (GraphicsNode)list.get(i + 1);
        else
            return null;
    }

    protected GraphicsNode gvtRoot;
    protected GraphicsNode treeRoot;
    protected GraphicsNode currentNode;
}
