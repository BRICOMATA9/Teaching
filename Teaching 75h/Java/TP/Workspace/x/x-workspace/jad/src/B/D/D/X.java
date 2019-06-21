// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.U;
import C.J.e;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package B.D.D:
//            Y

public class X extends Y
{

    public X()
    {
    }

    public String A()
    {
        return "QuadCurveEdge";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.e.class;
    }

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        super.A(u, node, graphmlparsecontext);
        e e1 = (e)u;
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("straightness");
        if(node1 != null)
            e1.E(Double.parseDouble(node1.getNodeValue()));
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    public void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.A(u, xmlwriter, graphmlwritecontext);
        e e1 = (e)u;
        xmlwriter.writeAttribute("straightness", String.valueOf(e1.CB()));
    }
}
