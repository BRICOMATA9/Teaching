// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGDocumentFactory;
import org.apache.batik.dom.util.DocumentDescriptor;
import org.apache.batik.util.CleanerThread;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            UserAgent

public class DocumentLoader
{
    private class DocumentState extends org.apache.batik.util.CleanerThread.SoftReferenceCleared
    {

        public void cleared()
        {
            synchronized(cacheMap)
            {
                cacheMap.remove(uri);
            }
        }

        public DocumentDescriptor getDocumentDescriptor()
        {
            return desc;
        }

        public String getURI()
        {
            return uri;
        }

        public Document getDocument()
        {
            return (Document)get();
        }

        private String uri;
        private DocumentDescriptor desc;


        public DocumentState(String s, Document document, DocumentDescriptor documentdescriptor)
        {
            super(document);
            uri = s;
            desc = documentdescriptor;
        }
    }


    protected DocumentLoader()
    {
        cacheMap = new HashMap();
    }

    public DocumentLoader(UserAgent useragent)
    {
        cacheMap = new HashMap();
        userAgent = useragent;
        documentFactory = new SAXSVGDocumentFactory(useragent.getXMLParserClassName(), true);
        documentFactory.setValidating(useragent.isXMLParserValidating());
    }

    public Document checkCache(String s)
    {
        int i = s.lastIndexOf('/');
        if(i == -1)
            i = 0;
        i = s.indexOf('#', i);
        if(i != -1)
            s = s.substring(0, i);
        DocumentState documentstate;
        synchronized(cacheMap)
        {
            documentstate = (DocumentState)cacheMap.get(s);
        }
        if(documentstate != null)
            return documentstate.getDocument();
        else
            return null;
    }

    public Document loadDocument(String s)
        throws IOException
    {
        Document document = checkCache(s);
        if(document != null)
            return document;
        SVGDocument svgdocument = documentFactory.createSVGDocument(s);
        DocumentDescriptor documentdescriptor = documentFactory.getDocumentDescriptor();
        DocumentState documentstate = new DocumentState(s, svgdocument, documentdescriptor);
        synchronized(cacheMap)
        {
            cacheMap.put(s, documentstate);
        }
        return documentstate.getDocument();
    }

    public Document loadDocument(String s, InputStream inputstream)
        throws IOException
    {
        Document document = checkCache(s);
        if(document != null)
            return document;
        SVGDocument svgdocument = documentFactory.createSVGDocument(s, inputstream);
        DocumentDescriptor documentdescriptor = documentFactory.getDocumentDescriptor();
        DocumentState documentstate = new DocumentState(s, svgdocument, documentdescriptor);
        synchronized(cacheMap)
        {
            cacheMap.put(s, documentstate);
        }
        return documentstate.getDocument();
    }

    public UserAgent getUserAgent()
    {
        return userAgent;
    }

    public void dispose()
    {
        synchronized(cacheMap)
        {
            cacheMap.clear();
        }
    }

    public int getLineNumber(Element element)
    {
        String s = ((SVGDocument)element.getOwnerDocument()).getURL();
        DocumentState documentstate;
        synchronized(cacheMap)
        {
            documentstate = (DocumentState)cacheMap.get(s);
        }
        if(documentstate == null)
            return -1;
        else
            return documentstate.desc.getLocationLine(element);
    }

    protected SVGDocumentFactory documentFactory;
    protected HashMap cacheMap;
    protected UserAgent userAgent;
}
