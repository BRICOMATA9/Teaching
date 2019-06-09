// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractParentNode, AbstractDocument, AbstractElement

public abstract class AbstractAttr extends AbstractParentNode
    implements Attr
{

    protected AbstractAttr()
    {
    }

    protected AbstractAttr(String s, AbstractDocument abstractdocument)
        throws DOMException
    {
        ownerDocument = abstractdocument;
        if(!DOMUtilities.isValidName(s))
            throw createDOMException((short)5, "xml.name", new Object[] {
                s
            });
        else
            return;
    }

    public boolean isId()
    {
        return isIdAttr;
    }

    public void setIsId(boolean flag)
    {
        isIdAttr = flag;
    }

    public void setNodeName(String s)
    {
        nodeName = s;
        isIdAttr = ownerDocument.isId(this);
    }

    public String getNodeName()
    {
        return nodeName;
    }

    public short getNodeType()
    {
        return 2;
    }

    public String getNodeValue()
        throws DOMException
    {
        Node node = getFirstChild();
        if(node == null)
            return "";
        Node node1 = node.getNextSibling();
        if(node1 == null)
            return node.getNodeValue();
        StringBuffer stringbuffer = new StringBuffer(node.getNodeValue());
        do
        {
            stringbuffer.append(node1.getNodeValue());
            node1 = node1.getNextSibling();
        } while(node1 != null);
        return stringbuffer.toString();
    }

    public void setNodeValue(String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s1 = getNodeValue();
        Object obj;
        while((obj = getFirstChild()) != null) 
            removeChild(((Node) (obj)));
        String s2 = s != null ? s : "";
        obj = getOwnerDocument().createTextNode(s2);
        appendChild(((Node) (obj)));
        if(ownerElement != null)
            ownerElement.fireDOMAttrModifiedEvent(nodeName, this, s1, s2, (short)1);
    }

    public String getName()
    {
        return getNodeName();
    }

    public boolean getSpecified()
    {
        return !unspecified;
    }

    public void setSpecified(boolean flag)
    {
        unspecified = !flag;
    }

    public String getValue()
    {
        return getNodeValue();
    }

    public void setValue(String s)
        throws DOMException
    {
        setNodeValue(s);
    }

    public void setOwnerElement(AbstractElement abstractelement)
    {
        ownerElement = abstractelement;
    }

    public Element getOwnerElement()
    {
        return ownerElement;
    }

    protected void nodeAdded(Node node)
    {
        setSpecified(true);
    }

    protected void nodeToBeRemoved(Node node)
    {
        setSpecified(true);
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractAttr abstractattr = (AbstractAttr)node;
        abstractattr.nodeName = nodeName;
        abstractattr.unspecified = false;
        abstractattr.isIdAttr = abstractdocument.isId(abstractattr);
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractAttr abstractattr = (AbstractAttr)node;
        abstractattr.nodeName = nodeName;
        abstractattr.unspecified = false;
        abstractattr.isIdAttr = abstractdocument.isId(abstractattr);
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractAttr abstractattr = (AbstractAttr)node;
        abstractattr.nodeName = nodeName;
        abstractattr.unspecified = unspecified;
        abstractattr.isIdAttr = isIdAttr;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractAttr abstractattr = (AbstractAttr)node;
        abstractattr.nodeName = nodeName;
        abstractattr.unspecified = unspecified;
        abstractattr.isIdAttr = isIdAttr;
        return node;
    }

    protected void checkChildType(Node node, boolean flag)
    {
        switch(node.getNodeType())
        {
        default:
            throw createDOMException((short)3, "child.type", new Object[] {
                new Integer(getNodeType()), getNodeName(), new Integer(node.getNodeType()), node.getNodeName()
            });

        case 3: // '\003'
        case 5: // '\005'
        case 11: // '\013'
            return;
        }
    }

    protected void fireDOMSubtreeModifiedEvent()
    {
        AbstractDocument abstractdocument = getCurrentDocument();
        if(abstractdocument.getEventsEnabled())
        {
            super.fireDOMSubtreeModifiedEvent();
            if(getOwnerElement() != null)
                ((AbstractElement)getOwnerElement()).fireDOMSubtreeModifiedEvent();
        }
    }

    protected String nodeName;
    protected boolean unspecified;
    protected boolean isIdAttr;
    protected AbstractElement ownerElement;
}
