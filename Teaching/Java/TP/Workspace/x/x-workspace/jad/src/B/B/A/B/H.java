// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.B;

import C.E.B;
import C.E.O;
import java.io.IOException;
import java.util.*;
import org.graphdrawing.graphml.writer.XmlWriter;

// Referenced classes of package B.B.A.B:
//            A, C, F, G

public class H
{

    public H()
    {
        C = false;
        B = null;
        A = null;
    }

    public String A()
    {
        return A;
    }

    public boolean C()
    {
        return C;
    }

    public void A(boolean flag)
    {
        C = flag;
    }

    public void A(C c, XmlWriter xmlwriter)
        throws IOException
    {
        if(C())
        {
            xmlwriter.writeStartElement("StyleDefinition", B());
        } else
        {
            xmlwriter.addNamespace(B(), null);
            if(A() != null)
                xmlwriter.addNamespace("http://www.w3.org/2001/XMLSchema-instance", "xsi");
            xmlwriter.writeStartDocument(null, "StyleDefinition", B());
            if(A() != null)
                xmlwriter.writeAttribute("xsi", "schemaLocation", "http://www.w3.org/2001/XMLSchema-instance", B() + " " + A());
        }
        A(c.F(), "NodeStyle", xmlwriter);
        A(c.E(), "EdgeStyle", xmlwriter);
        if(C())
            xmlwriter.writeEndElement();
        else
            xmlwriter.writeEndDocument();
    }

    private void A(F f, String s, XmlWriter xmlwriter)
    {
        Set set = f.A();
        O o = new O(set, set.size());
        HashSet hashset = new HashSet(set.size());
        while(!o.B()) 
        {
            String s1 = (String)o.D();
            A a = f.A(s1).D();
            if(a != null && !hashset.contains(a.C()))
            {
                o.A(s1);
            } else
            {
                hashset.add(s1);
                A(f.A(s1), s, xmlwriter);
            }
        }
    }

    private void A(A a, String s, XmlWriter xmlwriter)
    {
        xmlwriter.writeStartElement(s, B());
        xmlwriter.writeAttribute("styleId", a.C());
        A a1 = a.D();
        if(a1 != null)
            xmlwriter.writeAttribute("styleRef", a1.C());
        Iterator iterator = a.A();
        do
        {
            if(!iterator.hasNext())
                break;
            A._A _la = (A._A)iterator.next();
            if(a.B(_la.A()))
            {
                Object obj = a.A(_la.A(), false);
                try
                {
                    xmlwriter.writeAttribute(_la.A(), A(obj, _la.B()));
                }
                catch(IllegalArgumentException illegalargumentexception)
                {
                    illegalargumentexception.printStackTrace();
                }
            }
        } while(true);
        xmlwriter.writeEndElement();
    }

    private static String A(Object obj, Class class1)
    {
        B b = G.A(class1);
        if(b != null)
        {
            return b.A(obj, class1);
        } else
        {
            String s = "No suitable ObjectStringConverter found for " + obj + " [" + class1 + "]";
            throw new IllegalArgumentException(s);
        }
    }

    private String B()
    {
        return B == null ? "http://www.yworks.com/xml/graphuml" : B;
    }

    private boolean C;
    private String B;
    private String A;
}
