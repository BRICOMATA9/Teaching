// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractDocument, GenericElement, GenericDocumentFragment, GenericText, 
//            GenericComment, GenericCDATASection, GenericProcessingInstruction, GenericAttr, 
//            GenericEntityReference, GenericElementNS, GenericAttrNS

public class GenericDocument extends AbstractDocument
{

    protected GenericDocument()
    {
    }

    public GenericDocument(DocumentType documenttype, DOMImplementation domimplementation)
    {
        super(documenttype, domimplementation);
    }

    public boolean isReadonly()
    {
        return readonly;
    }

    public void setReadonly(boolean flag)
    {
        readonly = flag;
    }

    public boolean isId(Attr attr)
    {
        if(attr.getNamespaceURI() != null)
            return false;
        else
            return "id".equals(attr.getNodeName());
    }

    public Element createElement(String s)
        throws DOMException
    {
        return new GenericElement(s.intern(), this);
    }

    public DocumentFragment createDocumentFragment()
    {
        return new GenericDocumentFragment(this);
    }

    public Text createTextNode(String s)
    {
        return new GenericText(s, this);
    }

    public Comment createComment(String s)
    {
        return new GenericComment(s, this);
    }

    public CDATASection createCDATASection(String s)
        throws DOMException
    {
        return new GenericCDATASection(s, this);
    }

    public ProcessingInstruction createProcessingInstruction(String s, String s1)
        throws DOMException
    {
        return new GenericProcessingInstruction(s, s1, this);
    }

    public Attr createAttribute(String s)
        throws DOMException
    {
        return new GenericAttr(s.intern(), this);
    }

    public EntityReference createEntityReference(String s)
        throws DOMException
    {
        return new GenericEntityReference(s, this);
    }

    public Element createElementNS(String s, String s1)
        throws DOMException
    {
        if(s == null)
            return new GenericElement(s1.intern(), this);
        else
            return new GenericElementNS(s.intern(), s1.intern(), this);
    }

    public Attr createAttributeNS(String s, String s1)
        throws DOMException
    {
        if(s == null)
            return new GenericAttr(s1.intern(), this);
        else
            return new GenericAttrNS(s.intern(), s1.intern(), this);
    }

    protected Node newNode()
    {
        return new GenericDocument();
    }

    protected static final String ATTR_ID = "id";
    protected boolean readonly;
}
