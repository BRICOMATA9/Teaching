// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractProcessingInstruction, AbstractDocument

public class GenericProcessingInstruction extends AbstractProcessingInstruction
{

    protected GenericProcessingInstruction()
    {
    }

    public GenericProcessingInstruction(String s, String s1, AbstractDocument abstractdocument)
    {
        ownerDocument = abstractdocument;
        setTarget(s);
        setData(s1);
    }

    public void setNodeName(String s)
    {
        setTarget(s);
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    public String getTarget()
    {
        return target;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        GenericProcessingInstruction genericprocessinginstruction = (GenericProcessingInstruction)super.export(node, abstractdocument);
        genericprocessinginstruction.setTarget(getTarget());
        return genericprocessinginstruction;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        GenericProcessingInstruction genericprocessinginstruction = (GenericProcessingInstruction)super.deepExport(node, abstractdocument);
        genericprocessinginstruction.setTarget(getTarget());
        return genericprocessinginstruction;
    }

    protected Node copyInto(Node node)
    {
        GenericProcessingInstruction genericprocessinginstruction = (GenericProcessingInstruction)super.copyInto(node);
        genericprocessinginstruction.setTarget(getTarget());
        return genericprocessinginstruction;
    }

    protected Node deepCopyInto(Node node)
    {
        GenericProcessingInstruction genericprocessinginstruction = (GenericProcessingInstruction)super.deepCopyInto(node);
        genericprocessinginstruction.setTarget(getTarget());
        return genericprocessinginstruction;
    }

    protected Node newNode()
    {
        return new GenericProcessingInstruction();
    }

    protected String target;
    protected boolean readonly;
}
