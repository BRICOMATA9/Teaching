// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Entity;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentNode, AbstractDocument

public abstract class AbstractEntity extends AbstractParentNode
    implements Entity
{

    public AbstractEntity()
    {
    }

    public short getNodeType()
    {
        return 6;
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

    public String getNotationName()
    {
        return getNodeName();
    }

    public void setNotationName(String s)
    {
        setNodeName(s);
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractEntity abstractentity = (AbstractEntity)node;
        abstractentity.nodeName = nodeName;
        abstractentity.publicId = publicId;
        abstractentity.systemId = systemId;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractEntity abstractentity = (AbstractEntity)node;
        abstractentity.nodeName = nodeName;
        abstractentity.publicId = publicId;
        abstractentity.systemId = systemId;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractEntity abstractentity = (AbstractEntity)node;
        abstractentity.nodeName = nodeName;
        abstractentity.publicId = publicId;
        abstractentity.systemId = systemId;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractEntity abstractentity = (AbstractEntity)node;
        abstractentity.nodeName = nodeName;
        abstractentity.publicId = publicId;
        abstractentity.systemId = systemId;
        return node;
    }

    protected void checkChildType(Node node, boolean flag)
    {
        switch(node.getNodeType())
        {
        case 2: // '\002'
        case 6: // '\006'
        case 9: // '\t'
        case 10: // '\n'
        default:
            throw createDOMException((short)3, "child.type", new Object[] {
                new Integer(getNodeType()), getNodeName(), new Integer(node.getNodeType()), node.getNodeName()
            });

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        case 8: // '\b'
        case 11: // '\013'
            return;
        }
    }

    protected String nodeName;
    protected String publicId;
    protected String systemId;
}
