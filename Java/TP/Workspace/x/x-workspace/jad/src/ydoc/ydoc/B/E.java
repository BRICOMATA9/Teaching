// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.B;

import com.sun.tools.doclets.internal.toolkit.taglets.Taglet;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ydoc.A.A;
import ydoc.A.D;

// Referenced classes of package ydoc.B:
//            B, F

public class E
{

    public E()
    {
        try
        {
            A a = ydoc.A.A.B();
            if(!a.E("taglet_templates_filename") || !a.E("taglet_definitions_filename"))
            {
                String s = "Could not find xml resources. Please check your -docletpath and -resourcepath options.";
                throw new MissingResourceException("Could not find xml resources. Please check your -docletpath and -resourcepath options.", "", "");
            }
            B(A(a.H("taglet_templates_filename")));
            A(A(a.H("taglet_definitions_filename")));
        }
        catch(Exception exception)
        {
            D.A(exception);
        }
    }

    public Taglet[] B()
    {
        int i = 0;
        Taglet ataglet[] = new Taglet[C.size()];
        for(Iterator iterator = C.iterator(); iterator.hasNext();)
        {
            ataglet[i] = (Taglet)iterator.next();
            i++;
        }

        return ataglet;
    }

    private DocumentBuilder A()
        throws ParserConfigurationException
    {
        if(A == null)
        {
            A = DocumentBuilderFactory.newInstance();
            A.setValidating(true);
            A.setIgnoringComments(true);
            A.setIgnoringElementContentWhitespace(true);
            A.setCoalescing(false);
        }
        return A.newDocumentBuilder();
    }

    private Document A(String s)
    {
        DocumentBuilder documentbuilder = null;
        Document document = null;
        try
        {
            documentbuilder = A();
        }
        catch(ParserConfigurationException parserconfigurationexception)
        {
            D.A(parserconfigurationexception);
        }
        if(documentbuilder != null)
        {
            documentbuilder.setErrorHandler(null);
            try
            {
                document = documentbuilder.parse(new File(s));
            }
            catch(SAXException saxexception)
            {
                D.A(saxexception);
            }
            catch(IOException ioexception)
            {
                D.A(ioexception);
            }
        }
        return document;
    }

    private void B(Document document)
    {
        Element element = document.getDocumentElement();
        NodeList nodelist = element.getChildNodes();
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Element element1 = (Element)nodelist.item(i);
            B.put(element1.getAttribute("name"), A(element1));
        }

    }

    private B A(Element element)
    {
        Element element1 = (Element)element.getElementsByTagName("headline").item(0);
        String s = "";
        if(element1.hasChildNodes())
            s = ((CharacterData)element1.getFirstChild()).getData();
        element1 = (Element)element.getElementsByTagName("content").item(0);
        String s1 = element1.getAttribute("separator");
        if(s1.length() == 0)
            s1 = "none";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        NodeList nodelist = element1.getChildNodes();
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Element element2 = (Element)nodelist.item(i);
            if(!element2.hasChildNodes())
                continue;
            String s6 = element2.getTagName();
            if("content-item".equals(s6))
            {
                s2 = ((CharacterData)element2.getFirstChild()).getData();
                continue;
            }
            if("content-start".equals(s6))
            {
                s3 = ((CharacterData)element2.getFirstChild()).getData();
                continue;
            }
            if("content-end".equals(s6))
            {
                s4 = ((CharacterData)element2.getFirstChild()).getData();
                continue;
            }
            if("content-sep".equals(s6))
                s5 = ((CharacterData)element2.getFirstChild()).getData();
        }

        return new B(s, s1, s3, s2, s4, s5);
    }

    private void A(Document document)
    {
        Element element = document.getDocumentElement();
        NodeList nodelist = element.getChildNodes();
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Element element1 = (Element)nodelist.item(i);
            String s = element1.getAttribute("template");
            B b = (B)B.get(s);
            if(b != null)
            {
                C.add(A(element1, b));
            } else
            {
                String s1 = (new StringBuilder()).append("Taglet ").append(element1.getAttribute("name")).append("could not be created: ").append("No template <").append(s).append("> exists.").toString();
                D.B(s1);
            }
        }

    }

    private Taglet A(Element element, B b)
    {
        Element element1 = (Element)element.getElementsByTagName("usage").item(0);
        Element element2 = (Element)element.getElementsByTagName("headline").item(0);
        String s = null;
        String s1 = "";
        NodeList nodelist = element2.getChildNodes();
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Element element3 = (Element)nodelist.item(i);
            if(!element3.hasChildNodes())
                continue;
            String s2 = element3.getTagName();
            if("singular".equals(s2))
            {
                s1 = ((CharacterData)element3.getFirstChild()).getData();
                continue;
            }
            if("plural".equals(s2))
                s = ((CharacterData)element3.getFirstChild()).getData();
        }

        if(s == null)
            s = s1;
        return new F(element.getAttribute("name"), b, Boolean.valueOf(element.getAttribute("allowMultipleTags")).booleanValue(), Boolean.valueOf(element1.getAttribute("inField")).booleanValue(), Boolean.valueOf(element1.getAttribute("inConstructor")).booleanValue(), Boolean.valueOf(element1.getAttribute("inMethod")).booleanValue(), Boolean.valueOf(element1.getAttribute("inOverview")).booleanValue(), Boolean.valueOf(element1.getAttribute("inPackage")).booleanValue(), Boolean.valueOf(element1.getAttribute("inType")).booleanValue(), Boolean.valueOf(element1.getAttribute("isInlineTag")).booleanValue(), s1, s);
    }

    private DocumentBuilderFactory A;
    private final Map B = new HashMap();
    private final List C = new ArrayList();
}
