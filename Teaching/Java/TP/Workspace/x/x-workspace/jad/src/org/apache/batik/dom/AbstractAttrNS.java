// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractAttr, AbstractDocument

public abstract class AbstractAttrNS extends AbstractAttr
{

    protected AbstractAttrNS()
    {
    }

    protected AbstractAttrNS(String s, String s1, AbstractDocument abstractdocument)
        throws DOMException
    {
        super(s1, abstractdocument);
        namespaceURI = s;
        String s2 = DOMUtilities.getPrefix(s1);
        if(s2 != null)
        {
            if(s == null || s.equals("") || "xml".equals(s2) && !"http://www.w3.org/XML/1998/namespace".equals(s) || "xmlns".equals(s2) && !"http://www.w3.org/2000/xmlns/".equals(s))
                throw createDOMException((short)14, "namespace.uri", new Object[] {
                    new Integer(getNodeType()), getNodeName(), s
                });
        } else
        if("xmlns".equals(s1) && !"http://www.w3.org/2000/xmlns/".equals(s))
            throw createDOMException((short)14, "namespace.uri", new Object[] {
                new Integer(getNodeType()), getNodeName(), s
            });
    }

    public String getNamespaceURI()
    {
        return namespaceURI;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractAttrNS abstractattrns = (AbstractAttrNS)node;
        abstractattrns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractAttrNS abstractattrns = (AbstractAttrNS)node;
        abstractattrns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractAttrNS abstractattrns = (AbstractAttrNS)node;
        abstractattrns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractAttrNS abstractattrns = (AbstractAttrNS)node;
        abstractattrns.namespaceURI = namespaceURI;
        return node;
    }

    protected String namespaceURI;
}
