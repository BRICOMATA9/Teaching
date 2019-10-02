// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractElement, AbstractDocument

public class GenericElement extends AbstractElement
{

    protected GenericElement()
    {
    }

    public GenericElement(String s, AbstractDocument abstractdocument)
        throws DOMException
    {
        super(s, abstractdocument);
        nodeName = s;
    }

    public void setNodeName(String s)
    {
        nodeName = s;
    }

    public String getNodeName()
    {
        return nodeName;
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        GenericElement genericelement = (GenericElement)node;
        genericelement.nodeName = nodeName;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        GenericElement genericelement = (GenericElement)node;
        genericelement.nodeName = nodeName;
        return node;
    }

    protected Node copyInto(Node node)
    {
        GenericElement genericelement = (GenericElement)super.copyInto(node);
        genericelement.nodeName = nodeName;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        GenericElement genericelement = (GenericElement)super.deepCopyInto(node);
        genericelement.nodeName = nodeName;
        return node;
    }

    protected Node newNode()
    {
        return new GenericElement();
    }

    protected String nodeName;
    protected boolean readonly;
}
