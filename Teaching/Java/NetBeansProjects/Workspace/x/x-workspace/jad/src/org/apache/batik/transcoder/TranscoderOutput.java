// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.io.OutputStream;
import java.io.Writer;
import org.w3c.dom.Document;
import org.xml.sax.XMLFilter;

public class TranscoderOutput
{

    public TranscoderOutput()
    {
    }

    public TranscoderOutput(XMLFilter xmlfilter)
    {
        xmlFilter = xmlfilter;
    }

    public TranscoderOutput(OutputStream outputstream)
    {
        ostream = outputstream;
    }

    public TranscoderOutput(Writer writer1)
    {
        writer = writer1;
    }

    public TranscoderOutput(Document document1)
    {
        document = document1;
    }

    public TranscoderOutput(String s)
    {
        uri = s;
    }

    public void setXMLFilter(XMLFilter xmlfilter)
    {
        xmlFilter = xmlfilter;
    }

    public XMLFilter getXMLFilter()
    {
        return xmlFilter;
    }

    public void setOutputStream(OutputStream outputstream)
    {
        ostream = outputstream;
    }

    public OutputStream getOutputStream()
    {
        return ostream;
    }

    public void setWriter(Writer writer1)
    {
        writer = writer1;
    }

    public Writer getWriter()
    {
        return writer;
    }

    public void setDocument(Document document1)
    {
        document = document1;
    }

    public Document getDocument()
    {
        return document;
    }

    public void setURI(String s)
    {
        uri = s;
    }

    public String getURI()
    {
        return uri;
    }

    protected XMLFilter xmlFilter;
    protected OutputStream ostream;
    protected Writer writer;
    protected Document document;
    protected String uri;
}
