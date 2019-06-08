// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractElementNS, AbstractDocument

public class GenericElementNS extends AbstractElementNS
{

    protected GenericElementNS()
    {
    }

    public GenericElementNS(String s, String s1, AbstractDocument abstractdocument)
    {
        super(s, s1, abstractdocument);
        nodeName = s1;
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
        GenericElementNS genericelementns = (GenericElementNS)super.export(node, abstractdocument);
        genericelementns.nodeName = nodeName;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        GenericElementNS genericelementns = (GenericElementNS)super.deepExport(node, abstractdocument);
        genericelementns.nodeName = nodeName;
        return node;
    }

    protected Node copyInto(Node node)
    {
        GenericElementNS genericelementns = (GenericElementNS)super.copyInto(node);
        genericelementns.nodeName = nodeName;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        GenericElementNS genericelementns = (GenericElementNS)super.deepCopyInto(node);
        genericelementns.nodeName = nodeName;
        return node;
    }

    protected Node newNode()
    {
        return new GenericElementNS();
    }

    protected String nodeName;
    protected boolean readonly;
}
