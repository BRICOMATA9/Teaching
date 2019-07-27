// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.H.A.C;
import C.H.A.N;
import C.J.Y;
import C.J.g;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            b, I

public class f extends b
{

    public f()
    {
    }

    public String A()
    {
        return "ShapeNode";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.g.class;
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(y, xmlwriter, graphmlwritecontext);
        g g1 = (g)y;
        xmlwriter.writeStartElement("Shape", "http://www.yworks.com/xml/graphml").writeAttribute("type", C.E(g1.E3())).writeEndElement();
        if(g1.E2())
        {
            xmlwriter.writeStartElement("DropShadow", "http://www.yworks.com/xml/graphml").writeAttribute("offsetX", String.valueOf(g1.E4())).writeAttribute("offsetY", String.valueOf(g1.E6()));
            I.A(xmlwriter, "color", g1.E5());
            xmlwriter.writeEndElement();
        }
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        g g1 = (g)y;
        super.A(g1, node, graphmlparsecontext);
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1)
                    continue;
                String s = node1.getLocalName();
                if("Shape".equals(s))
                {
                    NamedNodeMap namednodemap = node1.getAttributes();
                    Node node2 = namednodemap.getNamedItem("type");
                    if(node2 != null)
                        g1.D(N.J(node2.getNodeValue()));
                    continue;
                }
                if(!"DropShadow".equals(s))
                    continue;
                NamedNodeMap namednodemap1 = node1.getAttributes();
                Node node3 = namednodemap1.getNamedItem("offsetX");
                if(node3 != null)
                    g1.B(Byte.parseByte(node3.getNodeValue()));
                node3 = namednodemap1.getNamedItem("offsetY");
                if(node3 != null)
                    g1.C(Byte.parseByte(node3.getNodeValue()));
                node3 = namednodemap1.getNamedItem("color");
                if(node3 != null)
                    g1.F(B.D.D.I.C(node3.getNodeValue()));
            }

        }
    }

    public boolean B(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }
}
