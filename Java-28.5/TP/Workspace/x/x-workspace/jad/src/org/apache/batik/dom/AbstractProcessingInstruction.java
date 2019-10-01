// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractChildNode, AbstractParentNode, AbstractDocument

public abstract class AbstractProcessingInstruction extends AbstractChildNode
    implements ProcessingInstruction
{

    public AbstractProcessingInstruction()
    {
    }

    public String getNodeName()
    {
        return getTarget();
    }

    public short getNodeType()
    {
        return 7;
    }

    public String getNodeValue()
        throws DOMException
    {
        return getData();
    }

    public void setNodeValue(String s)
        throws DOMException
    {
        setData(s);
    }

    public String getData()
    {
        return data;
    }

    public void setData(String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s1 = data;
        data = s;
        fireDOMCharacterDataModifiedEvent(s1, data);
        if(getParentNode() != null)
            ((AbstractParentNode)getParentNode()).fireDOMSubtreeModifiedEvent();
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        AbstractProcessingInstruction abstractprocessinginstruction = (AbstractProcessingInstruction)super.export(node, abstractdocument);
        abstractprocessinginstruction.data = data;
        return abstractprocessinginstruction;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        AbstractProcessingInstruction abstractprocessinginstruction = (AbstractProcessingInstruction)super.deepExport(node, abstractdocument);
        abstractprocessinginstruction.data = data;
        return abstractprocessinginstruction;
    }

    protected Node copyInto(Node node)
    {
        AbstractProcessingInstruction abstractprocessinginstruction = (AbstractProcessingInstruction)super.copyInto(node);
        abstractprocessinginstruction.data = data;
        return abstractprocessinginstruction;
    }

    protected Node deepCopyInto(Node node)
    {
        AbstractProcessingInstruction abstractprocessinginstruction = (AbstractProcessingInstruction)super.deepCopyInto(node);
        abstractprocessinginstruction.data = data;
        return abstractprocessinginstruction;
    }

    protected String data;
}
