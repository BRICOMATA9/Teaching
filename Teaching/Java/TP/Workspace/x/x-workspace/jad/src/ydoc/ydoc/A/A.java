// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.A;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package ydoc.A:
//            D, H, J

public class A
{
    private final class _C
        implements Iterator
    {

        public boolean hasNext()
        {
            return B < D;
        }

        public Object next()
        {
            if(hasNext())
                return new _A((Element)C.item(B++));
            else
                throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new UnsupportedOperationException("remove");
        }

        private final NodeList C;
        private final int D;
        private int B;
        final A A;

        _C()
        {
            A = A.this;
            super();
            C = A.A(A.this).getElementsByTagName("property");
            D = C.getLength();
            B = 0;
        }
    }

    private static final class _A
        implements _B
    {

        public String B()
        {
            return A.getAttribute("name");
        }

        public String A()
        {
            return A.getAttribute("value");
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getName()).append("[name=").append(B()).append(";value=").append(A()).append("]").toString();
        }

        private final Element A;

        _A(Element element)
        {
            A = element;
        }
    }

    public static interface _B
    {

        public abstract String B();

        public abstract String A();
    }


    public static A A(ClassLoader classloader, String s)
    {
        if(B.A && classloader != null)
        {
            URL url = classloader.getResource(s);
            if(url != null)
                B.B(url);
            URL url1 = classloader.getResource("taglet_templates.xml");
            URL url2 = classloader.getResource("taglet_definitions.xml");
            if(url1 == null || url2 == null)
            {
                String s1 = "Could not find xml resources. Please check your -docletpath and -resourcepath options.";
                ydoc.A.D.A(new MissingResourceException("Could not find xml resources. Please check your -docletpath and -resourcepath options.", "", ""));
            } else
            {
                B.D.put("taglet_templates_filename", ydoc.A.H.A(url1.getFile()));
                B.D.put("taglet_definitions_filename", ydoc.A.H.A(url2.getFile()));
            }
        }
        return B;
    }

    public static A B()
    {
        return B;
    }

    public static boolean A(String s)
    {
        return "true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s);
    }

    private static Document A(URL url)
    {
        DocumentBuilder documentbuilder;
        Document document;
        documentbuilder = null;
        document = null;
        try
        {
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            documentbuilderfactory.setValidating(false);
            documentbuilderfactory.setIgnoringComments(true);
            documentbuilderfactory.setIgnoringElementContentWhitespace(true);
            documentbuilderfactory.setCoalescing(false);
            documentbuilder = documentbuilderfactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException parserconfigurationexception)
        {
            ydoc.A.D.A(parserconfigurationexception);
        }
        if(documentbuilder == null)
            break MISSING_BLOCK_LABEL_136;
        documentbuilder.setErrorHandler(null);
        InputStream inputstream = null;
        inputstream = url.openStream();
        document = documentbuilder.parse(inputstream);
        if(inputstream != null)
            inputstream.close();
        break MISSING_BLOCK_LABEL_136;
        SAXException saxexception;
        saxexception;
        ydoc.A.D.A(saxexception, (new StringBuilder()).append("Malformed XML: ").append(url).toString());
        document = null;
        if(inputstream != null)
            inputstream.close();
        break MISSING_BLOCK_LABEL_136;
        Exception exception;
        exception;
        if(inputstream != null)
            inputstream.close();
        throw exception;
        IOException ioexception;
        ioexception;
        ydoc.A.D.A(ioexception);
        document = null;
        return document;
    }

    private A()
    {
        A = true;
        C = null;
        E = null;
    }

    private void B(URL url)
    {
        E = url;
        Document document = A(url);
        if(document != null)
            C = document.getDocumentElement();
        A = false;
    }

    public void F(String s)
    {
        D.put("formats.fileformat", s);
    }

    public String H(String s)
    {
        return G(s);
    }

    public int A(String s, int i)
    {
        String s1;
        s1 = G(s);
        if(s1 == null)
            return i;
        return Integer.parseInt(s1);
        NumberFormatException numberformatexception;
        numberformatexception;
        return i;
    }

    public float A(String s, float f)
    {
        String s1;
        s1 = G(s);
        if(s1 == null)
            return f;
        return Float.parseFloat(s1);
        NumberFormatException numberformatexception;
        numberformatexception;
        return f;
    }

    public boolean A(String s, boolean flag)
    {
        String s1 = G(s);
        if(s1 == null)
            return flag;
        else
            return A(s1);
    }

    public URL I(String s)
    {
        String s1;
        if(E == null)
            return null;
        s1 = G(s);
        if(s1 == null)
            return null;
        return new URL(E, J.A(s1));
        MalformedURLException malformedurlexception;
        malformedurlexception;
        ydoc.A.D.A(malformedurlexception);
        return null;
    }

    public Iterator A()
    {
        return new _C();
    }

    public A[] D(String s)
    {
        Element element = A(s, "group");
        if(element == null)
            return F;
        String s1 = element.getAttribute("name");
        ArrayList arraylist = new ArrayList();
        for(Object obj = element; obj != null; obj = ((Node) (obj)).getNextSibling())
        {
            if(1 != ((Node) (obj)).getNodeType())
                continue;
            Element element1 = (Element)obj;
            if(s1.equals(element1.getAttribute("name")))
            {
                A a = new A();
                a.E = E;
                a.C = element1;
                a.A = false;
                arraylist.add(a);
            }
        }

        return (A[])(A[])arraylist.toArray(F);
    }

    public A B(String s)
    {
        Element element = A(s, "group");
        if(element != null)
        {
            A a = new A();
            a.E = E;
            a.C = element;
            a.A = false;
            return a;
        } else
        {
            return null;
        }
    }

    public boolean C(String s)
    {
        return B(s) != null;
    }

    public boolean E(String s)
    {
        return G(s) != null;
    }

    private String G(String s)
    {
        String s1 = (String)D.get(s);
        if(s1 != null)
            return s1;
        Element element = A(s, "property");
        if(element != null)
        {
            String s2 = element.getAttribute("value");
            if(s2.length() > 0)
                return s2;
            else
                return null;
        } else
        {
            return null;
        }
    }

    private Element A(String s, String s1)
    {
        if(s == null || C == null)
            return null;
        if(s.indexOf('.') < 0)
        {
            NodeList nodelist = C.getElementsByTagName(s1);
            int i = 0;
            for(int j = nodelist.getLength(); i < j; i++)
            {
                Element element = (Element)nodelist.item(i);
                if(s.equals(element.getAttribute("name")))
                    return element;
            }

        } else
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, ".");
            if(!stringtokenizer.hasMoreTokens())
                return null;
            String s2 = stringtokenizer.nextToken();
            for(Node node = C.getFirstChild(); node != null; node = node.getNextSibling())
            {
                if(1 != node.getNodeType())
                    continue;
                Element element1 = (Element)node;
                if(!s2.equals(element1.getAttribute("name")))
                    continue;
                if(stringtokenizer.hasMoreTokens())
                {
                    s2 = stringtokenizer.nextToken();
                    node = node.getFirstChild();
                } else
                {
                    return element1;
                }
            }

        }
        return null;
    }

    static Element A(A a)
    {
        return a.C;
    }

    private static final A B = new A();
    private static final A F[] = new A[0];
    private boolean A;
    private Element C;
    private URL E;
    private final Map D = new HashMap();

}
