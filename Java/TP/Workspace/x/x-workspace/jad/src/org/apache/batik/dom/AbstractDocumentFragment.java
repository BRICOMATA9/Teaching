// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentNode

public abstract class AbstractDocumentFragment extends AbstractParentNode
    implements DocumentFragment
{

    public AbstractDocumentFragment()
    {
    }

    public String getNodeName()
    {
        return "#document-fragment";
    }

    public short getNodeType()
    {
        return 11;
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
}
