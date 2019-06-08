// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.E;
import B.B.B.B;
import B.B.B.G;
import B.D.D.I;
import C.J.Y;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.Node;

// Referenced classes of package B.B.C:
//            A

public class H extends A
{

    public H()
    {
    }

    public String A()
    {
        return "ClassifierRealizer";
    }

    public Class B()
    {
        return B.B.A.E.class;
    }

    void A(XmlWriter xmlwriter, int i)
    {
        xmlwriter.writeStartElement("Modifiers", D());
        if(Modifier.isPublic(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "public").writeEndElement();
        else
        if(Modifier.isProtected(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "protected").writeEndElement();
        else
        if(Modifier.isPrivate(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "private").writeEndElement();
        if(Modifier.isAbstract(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "abstract").writeEndElement();
        else
        if(Modifier.isFinal(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "final").writeEndElement();
        else
        if(Modifier.isStatic(i))
            xmlwriter.writeStartElement("Modifier", D()).writeAttribute("value", "static").writeEndElement();
        xmlwriter.writeEndElement();
    }

    int A(Node node)
    {
        int i = 0;
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if(!"Modifier".equals(node1.getLocalName()))
                continue;
            String s = B(node1, "value");
            if("public".equals(s))
            {
                i |= 1;
                continue;
            }
            if("protected".equals(s))
            {
                i |= 4;
                continue;
            }
            if("private".equals(s))
            {
                i |= 2;
                continue;
            }
            if("abstract".equals(s))
            {
                i |= 0x400;
                continue;
            }
            if("static".equals(s))
            {
                i |= 8;
                continue;
            }
            if("final".equals(s))
                i |= 0x10;
        }

        return i;
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        I.A(xmlwriter, y);
        E e = (E)y;
        B.B.B.E e1 = e.EE();
        xmlwriter.writeStartElement("Classifier", D());
        if(e1.B() == 0)
            xmlwriter.writeAttribute("type", "class");
        else
        if(e1.B() == 1)
            xmlwriter.writeAttribute("type", "interface");
        else
            xmlwriter.writeAttribute("type", "unknown");
        xmlwriter.writeAttribute("name", e1.E());
        xmlwriter.writeAttribute("namespace", e1.D());
        A(xmlwriter, e1.C());
        List list = e1.F();
        if(list != null && !list.isEmpty())
        {
            xmlwriter.writeStartElement("Attributes", D());
            for(Iterator iterator = list.iterator(); iterator.hasNext(); xmlwriter.writeEndElement())
            {
                B b = (B)iterator.next();
                xmlwriter.writeStartElement("Attribute", D());
                xmlwriter.writeAttribute("name", b.C());
                xmlwriter.writeAttribute("type", b.B());
                A(xmlwriter, b.D());
            }

            xmlwriter.writeEndElement();
        }
        List list1 = e1.A();
        if(list1 != null && !list1.isEmpty())
        {
            xmlwriter.writeStartElement("Operations", D());
            for(Iterator iterator1 = list1.iterator(); iterator1.hasNext(); xmlwriter.writeEndElement())
            {
                G g = (G)iterator1.next();
                xmlwriter.writeStartElement("Operation", D());
                xmlwriter.writeAttribute("name", g.C());
                xmlwriter.writeAttribute("type", g.B());
                A(xmlwriter, g.D());
                List list2 = g.E();
                if(list2 == null || list2.isEmpty())
                    continue;
                xmlwriter.writeStartElement("Parameters", D());
                for(Iterator iterator2 = list2.iterator(); iterator2.hasNext(); xmlwriter.writeEndElement())
                {
                    B.B.B.I i = (B.B.B.I)iterator2.next();
                    xmlwriter.writeStartElement("Parameter", D());
                    if(i.B() != null && i.B().length() > 0)
                        xmlwriter.writeAttribute("name", i.B());
                    if(i.A() != null && i.A().length() > 0)
                        xmlwriter.writeAttribute("type", i.A());
                }

                xmlwriter.writeEndElement();
            }

            xmlwriter.writeEndElement();
        }
        xmlwriter.writeEndElement();
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        B.B.B.E e = new B.B.B.E();
label0:
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if("Classifier".equals(node1.getLocalName()))
            {
                String s = B(node1, "name");
                if(s != null)
                    e.A(s);
                else
                    e.A("");
                String s4 = B(node1, "namespace");
                if(s4 != null)
                    e.B(s4);
                else
                    e.B("");
                String s5 = B(node1, "type");
                if("class".equals(s5))
                    e.A((byte)0);
                else
                if("interface".equals(s5))
                    e.A((byte)1);
                else
                    e.A((byte)127);
                Node node2 = node1.getFirstChild();
                do
                {
                    if(node2 == null)
                        continue label0;
                    if("Modifiers".equals(node2.getLocalName()))
                        e.A(A(node2));
                    else
                    if("Attributes".equals(node2.getLocalName()))
                    {
                        for(Node node3 = node2.getFirstChild(); node3 != null; node3 = node3.getNextSibling())
                            if("Attribute".equals(node3.getLocalName()))
                            {
                                B b = new B();
                                String s1 = B(node3, "name");
                                if(s1 != null)
                                    b.B(s1);
                                else
                                    b.B("");
                                String s6 = B(node3, "type");
                                if(s6 != null)
                                    b.A(s6);
                                else
                                    b.A("");
                                for(Node node5 = node3.getFirstChild(); node5 != null; node5 = node5.getNextSibling())
                                    if("Modifiers".equals(node5.getLocalName()))
                                        b.A(A(node5));

                                e.F().add(b);
                            }

                    } else
                    if("Operations".equals(node2.getLocalName()))
                    {
                        for(Node node4 = node2.getFirstChild(); node4 != null; node4 = node4.getNextSibling())
                        {
                            if(!"Operation".equals(node4.getLocalName()))
                                continue;
                            G g = new G();
                            String s2 = B(node4, "name");
                            if(s2 != null)
                                g.B(s2);
                            else
                                g.B("");
                            String s7 = B(node4, "type");
                            if(s7 != null)
                                g.A(s7);
                            else
                                g.A("");
                            for(Node node6 = node4.getFirstChild(); node6 != null; node6 = node6.getNextSibling())
                            {
                                if("Modifiers".equals(node6.getLocalName()))
                                {
                                    g.A(A(node6));
                                    continue;
                                }
                                if(!"Parameters".equals(node6.getLocalName()))
                                    continue;
                                for(Node node7 = node6.getFirstChild(); node7 != null; node7 = node7.getNextSibling())
                                {
                                    if(!"Parameter".equals(node7.getLocalName()))
                                        continue;
                                    B.B.B.I i = new B.B.B.I();
                                    String s3 = B(node7, "name");
                                    if(s3 != null)
                                        i.B(s3);
                                    else
                                        i.B("");
                                    String s8 = B(node7, "type");
                                    if(s8 != null)
                                        i.A(s8);
                                    else
                                        i.A("");
                                    if(g.E() == null)
                                        g.A(new ArrayList());
                                    g.E().add(i);
                                }

                            }

                            e.A().add(g);
                        }

                    }
                    node2 = node2.getNextSibling();
                } while(true);
            }
            if("Geometry".equals(node1.getLocalName()))
                I.A(node1, y);
        }

        ((E)y).A(e);
    }
}
