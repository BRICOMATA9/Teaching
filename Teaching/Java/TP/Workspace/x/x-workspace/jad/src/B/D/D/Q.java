// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.X;
import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            b, D, E

public class Q extends b
{

    public Q()
    {
    }

    public String A()
    {
        return "ProxyShapeNode";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.X.class;
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        X x = (X)y;
        int i = 0;
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int j = 0; j < nodelist.getLength(); j++)
            {
                Node node1 = nodelist.item(j);
                if(node1.getNodeType() == 1 && "Realizers".equals(node1.getLocalName()))
                {
                    NamedNodeMap namednodemap = node1.getAttributes();
                    i = Integer.parseInt(namednodemap.getNamedItem("active").getNodeValue());
                    A(x, node1, graphmlparsecontext);
                }
            }

        }
        x.C(x.F(i));
    }

    public void A(X x, Node node, GraphMLParseContext graphmlparsecontext)
    {
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() == 1)
                {
                    Y y = B.D.D.D.A(node1, graphmlparsecontext);
                    x.D(y);
                }
            }

        }
    }

    public boolean B(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        X x = (X)y;
        int i = 0;
        for(int k = 0; k < x.F5(); k++)
        {
            Y y1 = x.F(k);
            if(y1 == x.F6())
                i = k;
        }

        xmlwriter.writeStartElement("Realizers", "http://www.yworks.com/xml/graphml").writeAttribute("active", String.valueOf(i));
        for(int l = 0; l < x.F5(); l++)
        {
            Y y2 = x.F(l);
            E.A(y2, xmlwriter, graphmlwritecontext);
            int j;
            if(y2 == x.F6())
                j = l;
        }

        xmlwriter.writeEndElement();
    }
}
