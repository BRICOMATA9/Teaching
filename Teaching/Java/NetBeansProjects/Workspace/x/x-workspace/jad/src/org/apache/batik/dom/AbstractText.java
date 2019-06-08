// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractCharacterData

public abstract class AbstractText extends AbstractCharacterData
    implements Text
{

    public AbstractText()
    {
    }

    public Text splitText(int i)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s = getNodeValue();
        if(i < 0 || i >= s.length())
            throw createDOMException((short)1, "offset", new Object[] {
                new Integer(i)
            });
        Node node = getParentNode();
        if(node == null)
            throw createDOMException((short)1, "need.parent", new Object[0]);
        String s1 = s.substring(i);
        Text text = createTextNode(s1);
        Node node1 = getNextSibling();
        if(node1 != null)
            node.insertBefore(text, node1);
        else
            node.appendChild(text);
        setNodeValue(s.substring(0, i));
        return text;
    }

    protected abstract Text createTextNode(String s);
}
