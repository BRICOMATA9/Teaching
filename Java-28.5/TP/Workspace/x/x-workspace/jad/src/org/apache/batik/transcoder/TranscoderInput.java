// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.transcoder;

import java.io.InputStream;
import java.io.Reader;
import org.w3c.dom.Document;
import org.xml.sax.XMLReader;

public class TranscoderInput
{

    public TranscoderInput()
    {
    }

    public TranscoderInput(XMLReader xmlreader)
    {
        xmlReader = xmlreader;
    }

    public TranscoderInput(InputStream inputstream)
    {
        istream = inputstream;
    }

    public TranscoderInput(Reader reader1)
    {
        reader = reader1;
    }

    public TranscoderInput(Document document1)
    {
        document = document1;
    }

    public TranscoderInput(String s)
    {
        uri = s;
    }

    public void setXMLReader(XMLReader xmlreader)
    {
        xmlReader = xmlreader;
    }

    public XMLReader getXMLReader()
    {
        return xmlReader;
    }

    public void setInputStream(InputStream inputstream)
    {
        istream = inputstream;
    }

    public InputStream getInputStream()
    {
        return istream;
    }

    public void setReader(Reader reader1)
    {
        reader = reader1;
    }

    public Reader getReader()
    {
        return reader;
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

    protected XMLReader xmlReader;
    protected InputStream istream;
    protected Reader reader;
    protected Document document;
    protected String uri;
}
