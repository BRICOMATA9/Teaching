// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.DOMUtilities;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.dom:
//            AbstractElement, AbstractDocument

public abstract class AbstractElementNS extends AbstractElement
{

    protected AbstractElementNS()
    {
    }

    protected AbstractElementNS(String s, String s1, AbstractDocument abstractdocument)
        throws DOMException
    {
        super(s1, abstractdocument);
        namespaceURI = s;
        String s2 = DOMUtilities.getPrefix(s1);
        if(s2 != null && (s == null || s.equals("") || "xml".equals(s2) && !"http://www.w3.org/XML/1998/namespace".equals(s)))
            throw createDOMException((short)14, "namespace.uri", new Object[] {
                new Integer(getNodeType()), getNodeName(), s
            });
        else
            return;
    }

    public String getNamespaceURI()
    {
        return namespaceURI;
    }

    protected Node export(Node node, AbstractDocument abstractdocument)
    {
        super.export(node, abstractdocument);
        AbstractElementNS abstractelementns = (AbstractElementNS)node;
        abstractelementns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node deepExport(Node node, AbstractDocument abstractdocument)
    {
        super.deepExport(node, abstractdocument);
        AbstractElementNS abstractelementns = (AbstractElementNS)node;
        abstractelementns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node copyInto(Node node)
    {
        super.copyInto(node);
        AbstractElementNS abstractelementns = (AbstractElementNS)node;
        abstractelementns.namespaceURI = namespaceURI;
        return node;
    }

    protected Node deepCopyInto(Node node)
    {
        super.deepCopyInto(node);
        AbstractElementNS abstractelementns = (AbstractElementNS)node;
        abstractelementns.namespaceURI = namespaceURI;
        return node;
    }

    protected String namespaceURI;
}
