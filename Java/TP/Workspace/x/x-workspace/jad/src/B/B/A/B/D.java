// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;

import C.E.B;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package B.B.A.B:
//            A, C, F, B, 
//            G

public class D
{
    private static final class _A extends InputStream
    {

        public int available()
            throws IOException
        {
            return A.available();
        }

        public synchronized void reset()
            throws IOException
        {
            A.reset();
        }

        public boolean markSupported()
        {
            return A.markSupported();
        }

        public synchronized void mark(int i)
        {
            A.mark(i);
        }

        public long skip(long l)
            throws IOException
        {
            return A.skip(l);
        }

        public int read(byte abyte0[])
            throws IOException
        {
            return A.read(abyte0);
        }

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            return A.read(abyte0, i, j);
        }

        public int read()
            throws IOException
        {
            return A.read();
        }

        public void close()
            throws IOException
        {
        }

        private final InputStream A;

        _A(InputStream inputstream)
        {
            A = inputstream;
        }
    }


    public D()
    {
    }

    public void A(C c, InputStream inputstream)
        throws IOException
    {
        DocumentBuilderFactory documentbuilderfactory;
        documentbuilderfactory = DocumentBuilderFactory.newInstance();
        documentbuilderfactory.setNamespaceAware(true);
        BufferedInputStream bufferedinputstream = null;
        Document document;
        bufferedinputstream = new BufferedInputStream(new _A(inputstream));
        DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
        document = documentbuilder.parse(bufferedinputstream);
        if(bufferedinputstream != null)
            bufferedinputstream.close();
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        if(bufferedinputstream != null)
            bufferedinputstream.close();
        throw exception;
        if(document != null)
            B(c, document.getDocumentElement());
        break MISSING_BLOCK_LABEL_122;
        Object obj;
        obj;
        throw new IOException(((ParserConfigurationException) (obj)).getMessage());
        obj;
        throw new IOException(((SAXException) (obj)).getMessage());
    }

    public void A(C c, Node node)
    {
        if(1 == node.getNodeType())
        {
            Element element = (Element)node;
            String s = element.getLocalName();
            if("NodeStyle".equals(s))
                A(c.F(), element);
            else
            if("EdgeStyle".equals(s))
                A(c.E(), element);
        }
    }

    public void B(C c, Node node)
    {
        c.B();
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
            A(c, node1);

    }

    private void A(F f, Element element)
    {
        String s = element.getAttribute("styleId");
        A a = f.A(s);
        if(element.hasAttribute("styleRef"))
        {
            String s1 = element.getAttribute("styleRef");
            if(s1.length() > 0)
                a.A(f.A(s1));
        }
        Map map = B(a);
        NamedNodeMap namednodemap = element.getAttributes();
        int i = 0;
        for(int j = namednodemap.getLength(); i < j; i++)
        {
            Node node = namednodemap.item(i);
            String s2 = node.getLocalName();
            if("styleId".equals(s2) || "styleRef".equals(s2) || "xmlns".equals(s2))
                continue;
            A._A _la = (A._A)map.get(s2);
            if(_la == null)
                throw new B.B.A.B.B(s2, a.B(), a.C());
            a.A(s2, A(node.getNodeValue(), _la.B()));
        }

    }

    private Map B(A a)
    {
        switch(a.B())
        {
        case 0: // '\0'
            if(A == null)
                A = A(a);
            return A;

        case 1: // '\001'
            if(B == null)
                B = A(a);
            return B;
        }
        throw new IllegalArgumentException(Byte.toString(a.B()));
    }

    private static Map A(A a)
    {
        HashMap hashmap = new HashMap();
        A._A _la;
        for(Iterator iterator = a.A(); iterator.hasNext(); hashmap.put(_la.A(), _la))
            _la = (A._A)iterator.next();

        return hashmap;
    }

    private static Object A(String s, Class class1)
    {
        B b = G.A(class1);
        if(b != null)
        {
            return b.A(s, class1);
        } else
        {
            String s1 = "No suitable ObjectStringConverter found for " + s + " [" + class1 + "]";
            throw new IllegalArgumentException(s1);
        }
    }

    private Map B;
    private Map A;
}
