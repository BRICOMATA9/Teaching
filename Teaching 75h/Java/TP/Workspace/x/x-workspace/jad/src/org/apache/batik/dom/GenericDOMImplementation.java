// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.dom:
//            AbstractDOMImplementation, GenericDocument

public class GenericDOMImplementation extends AbstractDOMImplementation
{

    public GenericDOMImplementation()
    {
    }

    public static DOMImplementation getDOMImplementation()
    {
        return DOM_IMPLEMENTATION;
    }

    public DocumentType createDocumentType(String s, String s1, String s2)
    {
        throw new DOMException((short)9, "Doctype not supported");
    }

    public Document createDocument(String s, String s1, DocumentType documenttype)
        throws DOMException
    {
        GenericDocument genericdocument = new GenericDocument(documenttype, this);
        genericdocument.appendChild(genericdocument.createElementNS(s, s1));
        return genericdocument;
    }

    protected static final DOMImplementation DOM_IMPLEMENTATION = new GenericDOMImplementation();

}
