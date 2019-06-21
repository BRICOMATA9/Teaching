// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentChildNode, AbstractDocument

public abstract class AbstractEntityReference extends AbstractParentChildNode
    implements EntityReference
{

    protected AbstractEntityReference()
    {
    }

    protected AbstractEntityReference(String s, AbstractDocument abstractdocument)
        throws DOMException
    {
        ownerDocument = abstractdocument;
        if(!DOMUtilities.isValidName(s))
        {
            throw createDOMException((short)5, "xml.name", new Object[] {
                s
            });
        } else
        {
            nodeName = s;
            return;
        }
    }

    public short getNodeType()
    {
        return 5;
    }

    public void setNodeName(String s)
    {
        nodeName = s;
    }

    public String getNodeName()
    {
        return nodeName;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractEntityReference abstractentityreference = (AbstractEntityReference)node;
        abstractentityreference.nodeName = nodeName;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractEntityReference abstractentityreference = (AbstractEntityReference)node;
        abstractentityreference.nodeName = nodeName;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractEntityReference abstractentityreference = (AbstractEntityReference)node;
        abstractentityreference.nodeName = nodeName;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractEntityReference abstractentityreference = (AbstractEntityReference)node;
        abstractentityreference.nodeName = nodeName;
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
}
