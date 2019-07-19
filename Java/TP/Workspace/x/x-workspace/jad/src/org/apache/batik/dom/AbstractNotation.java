// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;
import org.w3c.dom.Notation;

// Referenced classes of package org.apache.batik.dom:
//            AbstractNode, AbstractDocument

public abstract class AbstractNotation extends AbstractNode
    implements Notation
{

    public AbstractNotation()
    {
    }

    public short getNodeType()
    {
        return 12;
    }

    public void setNodeName(String s)
    {
        nodeName = s;
    }

    public String getNodeName()
    {
        return nodeName;
    }

    public String getPublicId()
    {
        return publicId;
    }

    public void setPublicId(String s)
    {
        publicId = s;
    }

    public String getSystemId()
    {
        return systemId;
    }

    public void setSystemId(String s)
    {
        systemId = s;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractNotation abstractnotation = (AbstractNotation)node;
        abstractnotation.nodeName = nodeName;
        abstractnotation.publicId = publicId;
        abstractnotation.systemId = systemId;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractNotation abstractnotation = (AbstractNotation)node;
        abstractnotation.nodeName = nodeName;
        abstractnotation.publicId = publicId;
        abstractnotation.systemId = systemId;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractNotation abstractnotation = (AbstractNotation)node;
        abstractnotation.nodeName = nodeName;
        abstractnotation.publicId = publicId;
        abstractnotation.systemId = systemId;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractNotation abstractnotation = (AbstractNotation)node;
        abstractnotation.nodeName = nodeName;
        abstractnotation.publicId = publicId;
        abstractnotation.systemId = systemId;
        return node;
    }

    protected String nodeName;
    protected String publicId;
    protected String systemId;
}
