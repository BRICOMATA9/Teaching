// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentNode

public abstract class AbstractParentChildNode extends AbstractParentNode
{

    public AbstractParentChildNode()
    {
    }

    public Node getParentNode()
    {
        return parentNode;
    }

    public void setParentNode(Node node)
    {
        parentNode = node;
    }

    public void setPreviousSibling(Node node)
    {
        previousSibling = node;
    }

    public Node getPreviousSibling()
    {
        return previousSibling;
    }

    public void setNextSibling(Node node)
    {
        nextSibling = node;
    }

    public Node getNextSibling()
    {
        return nextSibling;
    }

    protected Node parentNode;
    protected Node previousSibling;
    protected Node nextSibling;
}
