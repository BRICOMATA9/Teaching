// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.NamespaceSupport;

// Referenced classes of package org.graphdrawing.graphml.writer:
//            XmlWriter, GraphMLWriteException

public class DomXmlWriter
    implements XmlWriter
{

    public DomXmlWriter(OutputStream outputstream)
    {
        this(createResult(outputstream));
    }

    public DomXmlWriter(Writer writer)
    {
        this(createResult(writer));
    }

    public DomXmlWriter(Result result1)
    {
        elements = null;
        sysId = null;
        encoding = "UTF-8";
        writeDecl = true;
        result = result1;
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        documentbuilderfactory.setValidating(false);
        documentbuilderfactory.setNamespaceAware(false);
        try
        {
            rawBuilder = documentbuilderfactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException parserconfigurationexception)
        {
            parserconfigurationexception.printStackTrace();
        }
        namespaces = new HashMap();
    }

    public void addNamespace(String s, String s1)
    {
        namespaces.put(s, s1);
    }

    public void setDTD(String s)
    {
        sysId = s;
    }

    public void setDTD(String s, String s1)
    {
        sysId = s;
        publicId = s1;
    }

    public void setEncoding(String s)
    {
        encoding = s;
    }

    public void setWriteXmlDeclaration(boolean flag)
    {
        writeDecl = flag;
    }

    public XmlWriter writeComment(String s)
    {
        org.w3c.dom.Comment comment = buffer.createComment(s);
        Object obj = elements.getLast();
        if(obj instanceof Node)
            ((Node)obj).appendChild(comment);
        return this;
    }

    public XmlWriter writeProcessingInstruction(String s, String s1)
    {
        org.w3c.dom.ProcessingInstruction processinginstruction = buffer.createProcessingInstruction(s, s1);
        Object obj = elements.getLast();
        if(obj instanceof Node)
            ((Node)obj).appendChild(processinginstruction);
        return this;
    }

    public XmlWriter writeStartDocument(String s, String s1, String s2)
        throws GraphMLWriteException
    {
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        documentbuilderfactory.setNamespaceAware(true);
        elements = new LinkedList();
        try
        {
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            DOMImplementation domimplementation = documentbuilder.getDOMImplementation();
            if(s == null && s2 != null)
                s = (String)namespaces.get(s2);
            org.w3c.dom.DocumentType documenttype = null;
            if(s == null || "".equals(s))
                buffer = domimplementation.createDocument(s2, s1, documenttype);
            else
                buffer = domimplementation.createDocument(s2, s + ":" + s1, documenttype);
            namespaceSupport = new NamespaceSupport();
            namespaceSupport.pushContext();
            Element element = buffer.getDocumentElement();
            for(Iterator iterator = namespaces.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s3 = (String)entry.getValue();
                String s4 = (String)entry.getKey();
                if(s3 == null || s3.length() == 0)
                {
                    element.setAttribute("xmlns", s4);
                    namespaceSupport.declarePrefix("", s4);
                } else
                {
                    element.setAttribute("xmlns:" + s3, s4);
                    namespaceSupport.declarePrefix(s3, s4);
                }
            }

            elements.addLast(element);
        }
        catch(ParserConfigurationException parserconfigurationexception)
        {
            throw new GraphMLWriteException(getClass().getName(), parserconfigurationexception);
        }
        return this;
    }

    public XmlWriter writeEndDocument()
        throws GraphMLWriteException
    {
        elements.removeLast();
        namespaceSupport.popContext();
        elements = null;
        writeToResult();
        return this;
    }

    public void writeToResult()
        throws GraphMLWriteException
    {
        Transformer transformer = createTransformer();
        try
        {
            configureTransformer(transformer);
            DOMSource domsource = new DOMSource(buffer);
            transformer.transform(domsource, result);
        }
        catch(TransformerException transformerexception)
        {
            throw new GraphMLWriteException(getClass().getName(), transformerexception);
        }
    }

    protected void configureTransformer(Transformer transformer)
    {
        if(!writeDecl)
            transformer.setOutputProperty("omit-xml-declaration", "yes");
        transformer.setOutputProperty("method", "xml");
        transformer.setOutputProperty("indent", "yes");
        if(sysId != null)
            transformer.setOutputProperty("doctype-system", sysId);
        if(publicId != null && sysId != null)
            transformer.setOutputProperty("doctype-public", publicId);
        transformer.setOutputProperty("encoding", encoding);
        try
        {
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        }
        catch(IllegalArgumentException illegalargumentexception) { }
    }

    protected Transformer createTransformer()
        throws GraphMLWriteException
    {
        TransformerFactory transformerfactory = TransformerFactory.newInstance();
        try
        {
            transformerfactory.setAttribute("indent-number", "2");
        }
        catch(IllegalArgumentException illegalargumentexception) { }
        Transformer transformer;
        try
        {
            transformer = transformerfactory.newTransformer();
        }
        catch(TransformerConfigurationException transformerconfigurationexception)
        {
            throw new GraphMLWriteException(getClass().getName(), transformerconfigurationexception);
        }
        return transformer;
    }

    private static Result createResult(OutputStream outputstream)
    {
        return new StreamResult(outputstream);
    }

    private static Result createResult(Writer writer)
    {
        return new StreamResult(writer);
    }

    public XmlWriter writeStartElement(String s, String s1, String s2)
    {
        if(elements != null)
            break MISSING_BLOCK_LABEL_24;
        return writeStartDocument(s, s1, s2);
        GraphMLWriteException graphmlwriteexception;
        graphmlwriteexception;
        graphmlwriteexception.printStackTrace();
        return this;
        namespaceSupport.pushContext();
        String s3 = null;
        boolean flag = false;
        if(s2 != null && s != null)
        {
            if(s2.equals(namespaceSupport.getURI("")))
            {
                if("".equals(s))
                {
                    s3 = "";
                    flag = true;
                } else
                {
                    namespaceSupport.declarePrefix(s, s2);
                    s3 = s;
                }
            } else
            {
                String s4 = namespaceSupport.getPrefix(s2);
                String s6 = namespaceSupport.getURI(s);
                if(!s2.equals(s6) || !s.equals(s4))
                {
                    namespaceSupport.declarePrefix(s, s2);
                    flag = false;
                } else
                {
                    flag = true;
                }
                s3 = s;
            }
        } else
        if(s2 != null)
            if(s2.equals(namespaceSupport.getURI("")))
            {
                s3 = "";
                flag = true;
            } else
            {
                s3 = namespaceSupport.getPrefix(s2);
                if(s3 == null)
                {
                    namespaceSupport.declarePrefix("", s2);
                    s3 = "";
                } else
                {
                    String s5 = namespaceSupport.getURI(s3);
                    if(!(flag = s5.equals(s2)))
                        namespaceSupport.declarePrefix("", s2);
                }
            }
        Element element;
        if(s3 == null || "".equals(s3))
            element = buffer.createElementNS(s2, s1);
        else
            element = buffer.createElementNS(s2, s3 + ":" + s1);
        if(!flag && s3 != null)
            if("".equals(s3))
                element.setAttribute("xmlns", s2);
            else
                element.setAttribute("xmlns:" + s3, s2);
        Object obj = elements.getLast();
        if(obj instanceof Node)
        {
            ((Node)obj).appendChild(element);
            elements.addLast(element);
        }
        return this;
    }

    public XmlWriter writeStartElement(String s, String s1)
    {
        return writeStartElement(null, s, s1);
    }

    public XmlWriter writeEndElement()
    {
        if(elements.size() == 1)
        {
            try
            {
                writeEndDocument();
            }
            catch(GraphMLWriteException graphmlwriteexception)
            {
                graphmlwriteexception.printStackTrace();
            }
            return this;
        } else
        {
            elements.removeLast();
            namespaceSupport.popContext();
            return this;
        }
    }

    public XmlWriter writeAttribute(String s, String s1, String s2, String s3)
    {
        Object obj = elements.getLast();
        if(obj instanceof Element)
            ((Element)obj).setAttributeNS(s2, s + ":" + s1, s3);
        return this;
    }

    public XmlWriter writeAttribute(String s, String s1)
    {
        Object obj = elements.getLast();
        if(obj instanceof Element)
            ((Element)obj).setAttribute(s, s1);
        return this;
    }

    public XmlWriter writeAttribute(String s, double d)
    {
        return writeAttribute(s, String.valueOf(d));
    }

    public XmlWriter writeAttribute(String s, long l)
    {
        return writeAttribute(s, String.valueOf(l));
    }

    public XmlWriter writeAttribute(String s, boolean flag)
    {
        return writeAttribute(s, String.valueOf(flag));
    }

    public XmlWriter writeText(String s)
    {
        org.w3c.dom.Text text = buffer.createTextNode(String.valueOf(s));
        Object obj = elements.getLast();
        if(obj instanceof Node)
            ((Node)obj).appendChild(text);
        return this;
    }

    public XmlWriter writeCDATA(String s)
    {
        org.w3c.dom.CDATASection cdatasection = buffer.createCDATASection(s);
        Object obj = elements.getLast();
        if(obj instanceof Node)
            ((Node)obj).appendChild(cdatasection);
        return this;
    }

    public XmlWriter writeRaw(String s)
        throws GraphMLWriteException
    {
        if(rawBuilder != null)
            try
            {
                Document document = rawBuilder.parse(new InputSource(new StringReader("<fragment>" + s + "</fragment>")));
                Object obj = elements.getLast();
                if(obj instanceof Node)
                {
                    Node node = (Node)obj;
                    NodeList nodelist = document.getDocumentElement().getChildNodes();
                    for(int i = 0; i < nodelist.getLength(); i++)
                    {
                        Node node1 = buffer.importNode(nodelist.item(i), true);
                        node.appendChild(node1);
                    }

                }
            }
            catch(Exception exception)
            {
                throw new GraphMLWriteException(getClass().getName(), exception);
            }
        return this;
    }

    public XmlWriter writeDocumentFragment(DocumentFragment documentfragment)
    {
        Object obj = elements.getLast();
        if(obj instanceof Node)
        {
            Node node = (Node)obj;
            node.appendChild(documentfragment);
        }
        return this;
    }

    private Document buffer;
    private LinkedList elements;
    private HashMap namespaces;
    private NamespaceSupport namespaceSupport;
    private String sysId;
    private String encoding;
    private Result result;
    private boolean writeDecl;
    private String publicId;
    private DocumentBuilder rawBuilder;
}
