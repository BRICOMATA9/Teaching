// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;

import C.E.B;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package B.B.A.B:
//            C, A, G

public class E
    implements C._D
{
    private static final class _D extends DefaultHandler
    {

        public void endElement(String s, String s1, String s2)
            throws SAXException
        {
            if("node-style-property-descriptors".equals(s1))
                F = null;
            else
            if("edge-style-property-descriptors".equals(s1))
                F = null;
            else
            if("property".equals(s1))
            {
                if(B != null && F != null)
                {
                    F.add(B);
                    B = null;
                }
            } else
            if("enumeration".equals(s1))
            {
                if(B != null)
                    ((_B)B).A(H.toArray(E.D));
                H = null;
            } else
            if("value".equals(s1))
            {
                A(D.toString());
                D = null;
                A = false;
            }
        }

        public void startElement(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if("node-style-property-descriptors".equals(s1))
                F = C;
            else
            if("edge-style-property-descriptors".equals(s1))
                F = E;
            else
            if("property".equals(s1))
            {
                String s3 = attributes.getValue("name");
                String s4 = attributes.getValue("type");
                try
                {
                    B = new _C(s3, Class.forName(s4));
                }
                catch(ClassNotFoundException classnotfoundexception)
                {
                    classnotfoundexception.printStackTrace();
                    B = null;
                }
            } else
            if("enumeration".equals(s1))
            {
                if(B != null)
                {
                    B = new _B(B);
                    H = new ArrayList();
                }
            } else
            if("value".equals(s1))
            {
                A = true;
                D = new StringBuffer();
            }
        }

        public void characters(char ac[], int i, int j)
            throws SAXException
        {
            if(!A)
                return;
            int k = i;
            for(int l = i + j; k < l; k++)
                D.append(ac[k]);

        }

        private void A(String s)
        {
            Matcher matcher = G.matcher(s);
            if(matcher.matches())
            {
                String s1 = matcher.group(1);
                int i = Integer.parseInt(matcher.group(2));
                for(int j = Integer.parseInt(matcher.group(3)) + 1; i < j; i++)
                    A(s1 + i, B.B());

            } else
            {
                A(s, B.B());
            }
        }

        private void A(String s, Class class1)
        {
            B b = B.B.A.B.G.A(class1);
            if(b != null)
            {
                H.add(b.A(s, class1));
            } else
            {
                String s1 = "No suitable ObjectStringConverter found for " + s + " [" + class1 + "]";
                throw new IllegalArgumentException(s1);
            }
        }

        private static final Pattern G = Pattern.compile("(?m)(\\D.*_)\\[(\\d+)-(\\d+)\\]$");
        private final List C;
        private final List E;
        private List F;
        private A._A B;
        private List H;
        private StringBuffer D;
        private boolean A;


        public _D(List list, List list1)
        {
            C = list;
            E = list1;
            F = null;
            B = null;
            H = null;
            D = null;
            A = false;
        }
    }

    private static final class _B extends _C
    {

        void A(Object aobj[])
        {
            C = aobj;
        }

        private Object C[];

        _B(A._A _pa)
        {
            super(_pa.A(), _pa.B());
            C = E.D;
        }
    }

    private static class _C
        implements A._A
    {

        public String A()
        {
            return A;
        }

        public Class B()
        {
            return B;
        }

        public String toString()
        {
            return getClass().getName() + "[name=" + A + ";type=" + B + "]";
        }

        private final String A;
        private final Class B;

        _C(String s, Class class1)
        {
            A = s;
            B = class1;
        }
    }

    private static final class _A
        implements Iterator
    {

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return B < A.length;
        }

        public Object next()
        {
            if(hasNext())
                return A[B++];
            else
                throw new NoSuchElementException();
        }

        private final Object A[];
        private int B;

        _A(Object aobj[])
        {
            A = aobj;
            B = 0;
        }
    }


    private E(Object aobj[], Object aobj1[])
    {
        A = aobj;
        C = aobj1;
    }

    public Iterator A()
    {
        return new _A(A);
    }

    public Iterator B()
    {
        return new _A(C);
    }

    public static E A(URL url)
    {
        ArrayList arraylist = new ArrayList(30);
        ArrayList arraylist1 = new ArrayList(5);
        if(url != null)
        {
            _D _ld = new _D(arraylist, arraylist1);
            try
            {
                A(url, ((DefaultHandler) (_ld)));
            }
            catch(Exception exception)
            {
                if(exception instanceof RuntimeException)
                    throw (RuntimeException)exception;
                exception.printStackTrace();
                arraylist.clear();
                arraylist1.clear();
            }
        }
        return new E(arraylist.toArray(D), arraylist1.toArray(D));
    }

    static E D()
    {
        if(B == null)
            B = C();
        return B;
    }

    private static E C()
    {
        ArrayList arraylist = new ArrayList(30);
        ArrayList arraylist1 = new ArrayList(5);
        URL url = (B.B.A.B.E.class).getResource("property-descriptors.xml");
        if(url != null)
        {
            _D _ld = new _D(arraylist, arraylist1);
            try
            {
                A(url, _ld);
            }
            catch(Exception exception)
            {
                if(exception instanceof RuntimeException)
                    throw (RuntimeException)exception;
                exception.printStackTrace();
                arraylist.clear();
                arraylist1.clear();
            }
        } else
        {
            try
            {
                throw new MissingResourceException("property-descriptors.xml", null, null);
            }
            catch(MissingResourceException missingresourceexception)
            {
                missingresourceexception.printStackTrace();
            }
        }
        return new E(arraylist.toArray(D), arraylist1.toArray(D));
    }

    private static void A(URL url, DefaultHandler defaulthandler)
        throws IOException, ParserConfigurationException, SAXException
    {
        InputStream inputstream = null;
        inputstream = url.openStream();
        SAXParserFactory saxparserfactory = SAXParserFactory.newInstance();
        saxparserfactory.setNamespaceAware(true);
        SAXParser saxparser = saxparserfactory.newSAXParser();
        saxparser.parse(inputstream, defaulthandler);
        if(inputstream != null)
            inputstream.close();
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        if(inputstream != null)
            inputstream.close();
        throw exception;
    }

    private static final Object D[] = new Object[0];
    private static E B;
    private final Object A[];
    private final Object C[];


}
