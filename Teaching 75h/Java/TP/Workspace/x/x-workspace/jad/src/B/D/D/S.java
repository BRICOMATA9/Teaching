// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.U;
import C.J.c;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            Y

public class S extends Y
{

    public S()
    {
    }

    public String A()
    {
        return "PolyLineEdge";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.c.class;
    }

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        super.A(u, node, graphmlparsecontext);
        c c1 = (c)u;
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1)
                    continue;
                String s = node1.getLocalName();
                if(!"BendStyle".equals(s))
                    continue;
                NamedNodeMap namednodemap = node1.getAttributes();
                Node node2 = namednodemap.getNamedItem("smoothed");
                if(node2 != null)
                    c1.I(Boolean.valueOf(node2.getNodeValue()).booleanValue());
            }

        }
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    public void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(u, xmlwriter, graphmlwritecontext);
        c c1 = (c)u;
        xmlwriter.writeStartElement("BendStyle", "http://www.yworks.com/xml/graphml").writeAttribute("smoothed", String.valueOf(c1.C8())).writeEndElement();
    }
}
