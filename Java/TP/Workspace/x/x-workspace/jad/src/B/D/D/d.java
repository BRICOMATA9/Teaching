// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.A.B;
import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            f, I

public class d extends f
{

    public d()
    {
    }

    public String A()
    {
        return "GroupNode";
    }

    public Class B()
    {
        return C.J.A.B.class;
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(y, xmlwriter, graphmlwritecontext);
        B b = (B)y;
        xmlwriter.writeStartElement("State", "http://www.yworks.com/xml/graphml").writeAttribute("closed", String.valueOf(b.FA())).writeAttribute("innerGraphDisplayEnabled", String.valueOf(b._mth0104())).writeEndElement();
        I.A(xmlwriter, "Insets", b._mth0102());
        I.A(xmlwriter, "BorderInsets", b.F8());
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        B b = (B)y;
        b.K(true);
        super.A(b, node, graphmlparsecontext);
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1)
                    continue;
                String s = node1.getLocalName();
                if("State".equals(s))
                {
                    NamedNodeMap namednodemap = node1.getAttributes();
                    Node node2 = namednodemap.getNamedItem("closed");
                    if(node2 != null)
                        b.K(Boolean.valueOf(node2.getNodeValue()).booleanValue());
                    node2 = namednodemap.getNamedItem("innerGraphDisplayEnabled");
                    if(node2 != null)
                        b.L(Boolean.valueOf(node2.getNodeValue()).booleanValue());
                }
                if("Insets".equals(s))
                    b.C(B.D.D.I.B(node1));
                if("BorderInsets".equals(s))
                    b.B(B.D.D.I.B(node1));
            }

        }
    }
}
