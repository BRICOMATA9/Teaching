// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractChildNode, AbstractParentNode, AbstractDocument

public abstract class AbstractCharacterData extends AbstractChildNode
    implements CharacterData
{

    public AbstractCharacterData()
    {
        nodeValue = "";
    }

    public String getNodeValue()
        throws DOMException
    {
        return nodeValue;
    }

    public void setNodeValue(String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        String s1 = nodeValue;
        nodeValue = s != null ? s : "";
        fireDOMCharacterDataModifiedEvent(s1, nodeValue);
        if(getParentNode() != null)
            ((AbstractParentNode)getParentNode()).fireDOMSubtreeModifiedEvent();
    }

    public String getData()
        throws DOMException
    {
        return getNodeValue();
    }

    public void setData(String s)
        throws DOMException
    {
        setNodeValue(s);
    }

    public int getLength()
    {
        return nodeValue.length();
    }

    public String substringData(int i, int j)
        throws DOMException
    {
        checkOffsetCount(i, j);
        String s = getNodeValue();
        return s.substring(i, Math.min(s.length(), i + j));
    }

    public void appendData(String s)
        throws DOMException
    {
        if(isReadonly())
        {
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        } else
        {
            setNodeValue(getNodeValue() + (s != null ? s : ""));
            return;
        }
    }

    public void insertData(int i, String s)
        throws DOMException
    {
        if(isReadonly())
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        if(i < 0 || i > getLength())
        {
            throw createDOMException((short)1, "offset", new Object[] {
                new Integer(i)
            });
        } else
        {
            String s1 = getNodeValue();
            setNodeValue(s1.substring(0, i) + s + s1.substring(i, s1.length()));
            return;
        }
    }

    public void deleteData(int i, int j)
        throws DOMException
    {
        if(isReadonly())
        {
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        } else
        {
            checkOffsetCount(i, j);
            String s = getNodeValue();
            setNodeValue(s.substring(0, i) + s.substring(Math.min(s.length(), i + j), s.length()));
            return;
        }
    }

    public void replaceData(int i, int j, String s)
        throws DOMException
    {
        if(isReadonly())
        {
            throw createDOMException((short)7, "readonly.node", new Object[] {
                new Integer(getNodeType()), getNodeName()
            });
        } else
        {
            checkOffsetCount(i, j);
            String s1 = getNodeValue();
            setNodeValue(s1.substring(0, i) + s + s1.substring(Math.min(s1.length(), i + j), s1.length()));
            return;
        }
    }

    protected void checkOffsetCount(int i, int j)
        throws DOMException
    {
        if(i < 0 || i >= getLength())
            throw createDOMException((short)1, "offset", new Object[] {
                new Integer(i)
            });
        if(j < 0)
            throw createDOMException((short)1, "negative.count", new Object[] {
                new Integer(j)
            });
        else
            return;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractCharacterData abstractcharacterdata = (AbstractCharacterData)node;
        abstractcharacterdata.nodeValue = nodeValue;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractCharacterData abstractcharacterdata = (AbstractCharacterData)node;
        abstractcharacterdata.nodeValue = nodeValue;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractCharacterData abstractcharacterdata = (AbstractCharacterData)node;
        abstractcharacterdata.nodeValue = nodeValue;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractCharacterData abstractcharacterdata = (AbstractCharacterData)node;
        abstractcharacterdata.nodeValue = nodeValue;
        return node;
    }

    protected String nodeValue;
}
