// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.events.NodeEventTarget;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface ExtendedNode
    extends Node, NodeEventTarget
{

    public abstract void setNodeName(String s);

    public abstract boolean isReadonly();

    public abstract void setReadonly(boolean flag);

    public abstract void setOwnerDocument(Document document);

    public abstract void setParentNode(Node node);

    public abstract void setPreviousSibling(Node node);

    public abstract void setNextSibling(Node node);

    public abstract void setSpecified(boolean flag);
}
