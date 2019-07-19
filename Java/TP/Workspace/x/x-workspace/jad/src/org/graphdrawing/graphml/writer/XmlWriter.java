// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import org.w3c.dom.DocumentFragment;

// Referenced classes of package org.graphdrawing.graphml.writer:
//            GraphMLWriteException

public interface XmlWriter
{

    public abstract XmlWriter writeComment(String s);

    public abstract XmlWriter writeProcessingInstruction(String s, String s1);

    public abstract XmlWriter writeStartDocument(String s, String s1, String s2)
        throws GraphMLWriteException;

    public abstract XmlWriter writeEndDocument()
        throws GraphMLWriteException;

    public abstract XmlWriter writeStartElement(String s, String s1, String s2);

    public abstract XmlWriter writeStartElement(String s, String s1);

    public abstract XmlWriter writeEndElement();

    public abstract XmlWriter writeAttribute(String s, String s1, String s2, String s3);

    public abstract XmlWriter writeAttribute(String s, String s1);

    public abstract XmlWriter writeAttribute(String s, double d);

    public abstract XmlWriter writeAttribute(String s, long l);

    public abstract XmlWriter writeAttribute(String s, boolean flag);

    public abstract XmlWriter writeText(String s);

    public abstract XmlWriter writeRaw(String s)
        throws GraphMLWriteException;

    public abstract XmlWriter writeDocumentFragment(DocumentFragment documentfragment);

    public abstract XmlWriter writeCDATA(String s);

    public abstract void addNamespace(String s, String s1);

    public abstract void setDTD(String s);

    public abstract void setEncoding(String s);

    public abstract void setWriteXmlDeclaration(boolean flag);

    public abstract void setDTD(String s, String s1);
}
