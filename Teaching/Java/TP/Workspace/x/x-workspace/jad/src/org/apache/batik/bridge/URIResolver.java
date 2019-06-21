// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.*;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            DocumentLoader, UserAgent

public class URIResolver
{

    public URIResolver(SVGDocument svgdocument, DocumentLoader documentloader)
    {
        document = (SVGOMDocument)svgdocument;
        documentLoader = documentloader;
    }

    public Element getElement(String s, Element element)
        throws MalformedURLException, IOException
    {
        Node node = getNode(s, element);
        if(node == null)
            return null;
        if(node.getNodeType() == 9)
            throw new IllegalArgumentException();
        else
            return (Element)node;
    }

    public Node getNode(String s, Element element)
        throws MalformedURLException, IOException, SecurityException
    {
        String s1 = XMLBaseSupport.getCascadedXMLBase(element);
        if(s1 == null && s.startsWith("#"))
            return document.getElementById(s.substring(1));
        ParsedURL parsedurl = new ParsedURL(s1, s);
        if(documentURI == null)
            documentURI = document.getURL();
        String s2 = parsedurl.getRef();
        if(s2 != null && documentURI != null)
        {
            ParsedURL parsedurl1 = new ParsedURL(documentURI);
            if(parsedurl1.sameFile(parsedurl))
                return document.getElementById(s2);
        }
        ParsedURL parsedurl2 = null;
        if(documentURI != null)
            parsedurl2 = new ParsedURL(documentURI);
        UserAgent useragent = documentLoader.getUserAgent();
        useragent.checkLoadExternalResource(parsedurl, parsedurl2);
        String s3 = parsedurl.toString();
        if(s2 != null)
            s3 = s3.substring(0, s3.length() - (s2.length() + 1));
        Document document1 = documentLoader.loadDocument(s3);
        if(s2 != null)
            return document1.getElementById(s2);
        else
            return document1;
    }

    protected SVGOMDocument document;
    protected String documentURI;
    protected DocumentLoader documentLoader;
}
