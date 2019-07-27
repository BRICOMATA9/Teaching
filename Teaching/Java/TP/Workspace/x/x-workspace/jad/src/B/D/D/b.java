// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseException;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            W, I

public abstract class b
    implements W
{

    public b()
    {
    }

    private static String A(Node node, String s)
    {
        NamedNodeMap namednodemap = node.getAttributes();
        for(int i = 0; i < namednodemap.getLength(); i++)
        {
            Node node1 = namednodemap.item(i);
            if(node1.getNodeName().equals(s))
                return node1.getNodeValue();
        }

        return null;
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        if("true".equals(A(node, "selected")))
            y.A(true);
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            String s = A(graphmlparsecontext);
            int i = 0;
            for(int j = 0; j < nodelist.getLength(); j++)
            {
                Node node1 = nodelist.item(j);
                if(node1.getNodeType() != 1 || !s.equals(node1.getNamespaceURI()))
                    continue;
                String s1 = node1.getLocalName();
                if("Geometry".equals(s1))
                    I.A(node1, y);
                if("NodeLabel".equals(s1))
                {
                    C.J.DA da;
                    for(; y.L() <= i; y.C(da))
                        da = y.E();

                    I.A(node1, y.A(i++), graphmlparsecontext);
                }
                if("Fill".equals(s1))
                {
                    NamedNodeMap namednodemap = node1.getAttributes();
                    Node node2 = namednodemap.getNamedItem("hasColor");
                    if(node2 == null || !"false".equalsIgnoreCase(node2.getNodeValue()))
                    {
                        node2 = namednodemap.getNamedItem("color");
                        if(node2 != null)
                            y.B(I.C(node2.getNodeValue()));
                    } else
                    {
                        y.B(null);
                    }
                    node2 = namednodemap.getNamedItem("color2");
                    if(node2 != null)
                        y.C(I.C(node2.getNodeValue()));
                    node2 = namednodemap.getNamedItem("transparent");
                    if(node2 != null)
                        y.C("true".equalsIgnoreCase(node2.getNodeValue()));
                }
                if(!"BorderStyle".equals(s1))
                    continue;
                y.A(I.C(node1));
                NamedNodeMap namednodemap1 = node1.getAttributes();
                Node node3 = namednodemap1.getNamedItem("hasColor");
                if(node3 == null || !"false".equalsIgnoreCase(node3.getNodeValue()))
                {
                    Node node4 = namednodemap1.getNamedItem("color");
                    if(node4 != null)
                        y.A(I.C(node4.getNodeValue()));
                } else
                {
                    y.A(null);
                }
            }

        }
    }

    String A(GraphMLParseContext graphmlparsecontext)
    {
        String s = graphmlparsecontext.getProperty("org.graphdrawing.graphml.reader.dom.YFILES_EXT_NS").toString();
        if(s == null)
            s = "http://www.yworks.com/xml/graphml";
        return s;
    }

    public void A(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        Object obj = graphmlwritecontext.getProperty("writeSelectionState");
        if(obj != null && (obj instanceof Boolean) && ((Boolean)obj).booleanValue())
            xmlwriter.writeAttribute("selected", String.valueOf(y.I()));
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        I.A(xmlwriter, y);
        A(xmlwriter, y);
        I.A(xmlwriter, "BorderStyle", y.J(), y.Y());
        for(int i = 0; i < y.L(); i++)
            I.A(xmlwriter, y.A(i), graphmlwritecontext);

    }

    protected void A(XmlWriter xmlwriter, Y y)
    {
        xmlwriter.writeStartElement("Fill", "http://www.yworks.com/xml/graphml");
        if(y.M() == null)
            xmlwriter.writeAttribute("hasColor", "false");
        else
            I.A(xmlwriter, "color", y.M());
        if(y.U() != null)
            I.A(xmlwriter, "color2", y.U());
        xmlwriter.writeAttribute("transparent", String.valueOf(y.W()));
        xmlwriter.writeEndElement();
    }

    public boolean A(Y y, GraphMLWriteContext graphmlwritecontext)
    {
        return y.getClass() == B();
    }

    public boolean B(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(D()) && node.getLocalName().equals(A());
    }

    public Y A(Node node, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException
    {
        return (Y)B().newInstance();
        Object obj;
        obj;
        throw new GraphMLParseException(getClass().getName(), ((Exception) (obj)));
        obj;
        throw new GraphMLParseException(getClass().getName(), ((Exception) (obj)));
    }

    public String C()
    {
        return null;
    }
}
