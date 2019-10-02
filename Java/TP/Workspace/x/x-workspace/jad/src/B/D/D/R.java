// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.U;
import C.J.l;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            Y

public class R extends Y
{

    public R()
    {
    }

    public String A()
    {
        return "ArcEdge";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.l.class;
    }

    public void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(u, xmlwriter, graphmlwritecontext);
        l l1 = (l)u;
        xmlwriter.writeStartElement("Arc", "http://www.yworks.com/xml/graphml").writeAttribute("type", A(l1.D0())).writeAttribute("height", String.valueOf(l1.CC())).writeAttribute("ratio", String.valueOf(l1.CE())).writeEndElement();
    }

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        l l1 = (l)u;
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1)
                    continue;
                String s = node1.getLocalName();
                if(!s.equals("Arc"))
                    continue;
                NamedNodeMap namednodemap = node1.getAttributes();
                Node node2 = namednodemap.getNamedItem("type");
                if(node2 != null)
                    l1.A(A(node2.getNodeValue()));
                node2 = namednodemap.getNamedItem("height");
                if(node2 != null)
                    l1.B((float)Double.parseDouble(node2.getNodeValue()));
                node2 = namednodemap.getNamedItem("ratio");
                if(node2 != null)
                    l1.A((float)Double.parseDouble(node2.getNodeValue()));
            }

        }
        super.A(l1, node, graphmlparsecontext);
    }

    static String A(byte byte0)
    {
        String s = "fixedRatio";
        if(byte0 == 0)
            s = "fixedHeight";
        return s;
    }

    static byte A(String s)
    {
        return ((byte)(!"fixedHeight".equals(s) ? 1 : 0));
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }
}
