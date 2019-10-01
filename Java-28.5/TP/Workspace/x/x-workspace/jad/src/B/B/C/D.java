// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.H;
import B.B.A.J;
import B.D.D.I;
import B.D.D.Y;
import C.J.U;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class D extends Y
{

    public D()
    {
    }

    public String A()
    {
        return "RelationshipRealizer";
    }

    public Class B()
    {
        return B.B.A.J.class;
    }

    String B(Node node, String s)
    {
        NamedNodeMap namednodemap = node.getAttributes();
        if(namednodemap == null)
            return null;
        Node node1 = namednodemap.getNamedItem(s);
        if(node1 == null)
            return null;
        else
            return node1.getNodeValue();
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public String C()
    {
        return "y";
    }

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        B.B.B.D d = new B.B.B.D();
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if("Relationship".equals(node1.getLocalName()))
            {
                d.B(B(node1, "name"));
                d.A(B(B(node1, "type")));
                d.C(B(node1, "targetRole"));
                d.D(B(node1, "sourceRole"));
                d.E(B(node1, "targetMultiplicity"));
                d.A(B(node1, "sourceMultiplicity"));
                continue;
            }
            if("Path".equals(node1.getLocalName()))
                I.A(node1, u);
        }

        ((J)u).A(d);
    }

    byte B(String s)
    {
        if("aggregation".equals(s))
            return 0;
        if("association".equals(s))
            return 1;
        if("composition".equals(s))
            return 2;
        if("dependency".equals(s))
            return 3;
        if("generalization".equals(s))
            return 4;
        if("navigation".equals(s))
            return 5;
        return ((byte)(!"realization".equals(s) ? 1 : 6));
    }

    public void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        I.A(xmlwriter, u);
        H h = H.C();
        B.B.B.D d = ((J)u).CA();
        String s = d.F();
        xmlwriter.writeStartElement("Relationship", D()).writeAttribute("type", h.A(d));
        s = d.F();
        if(s != null && s.length() > 0)
            xmlwriter.writeAttribute("name", s);
        s = d.E();
        if(s != null && s.length() > 0)
            xmlwriter.writeAttribute("sourceMultiplicity", s);
        s = d.C();
        if(s != null && s.length() > 0)
            xmlwriter.writeAttribute("targetMultiplicity", s);
        s = d.B();
        if(s != null && s.length() > 0)
            xmlwriter.writeAttribute("sourceRole", s);
        s = d.A();
        if(s != null && s.length() > 0)
            xmlwriter.writeAttribute("targetRole", s);
        xmlwriter.writeEndElement();
    }

    public void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
    }
}
