// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.J.*;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseException;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            P, I, N

public abstract class Y
    implements P
{

    public Y()
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

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        if("true".equals(A(node, "selected")))
            u.G(true);
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            String s = A(graphmlparsecontext);
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1 || !s.equals(node1.getNamespaceURI()))
                    continue;
                String s1 = node1.getLocalName();
                if("Path".equals(s1))
                    I.A(node1, u);
                if("EdgeLabel".equals(s1))
                {
                    C.J.N n = u.C5();
                    u.B(n);
                    I.A(node1, n, graphmlparsecontext);
                }
                if("LineStyle".equals(s1))
                {
                    u.B(I.C(node1));
                    NamedNodeMap namednodemap = node1.getAttributes();
                    Node node2 = namednodemap.getNamedItem("hasColor");
                    if(node2 == null || !"false".equalsIgnoreCase(node2.getNodeValue()))
                    {
                        Node node3 = namednodemap.getNamedItem("color");
                        if(node3 != null)
                            u.D(I.C(node3.getNodeValue()));
                    } else
                    {
                        u.D(null);
                    }
                }
                if("Arrows".equals(s1))
                {
                    u.A(I.A(node1, "source"));
                    u.C(I.A(node1, "target"));
                }
                if("SourcePort".equals(s1))
                {
                    n n1 = C(node1, graphmlparsecontext);
                    if(n1 != null)
                        u.B(n1);
                }
                if(!"TargetPort".equals(s1))
                    continue;
                n n2 = C(node1, graphmlparsecontext);
                if(n2 != null)
                    u.A(n2);
            }

        }
    }

    private n C(Node node, GraphMLParseContext graphmlparsecontext)
    {
        Node node1 = node.getAttributes().getNamedItem("type");
        if(node1 != null && "InterfacePort".equals(node1.getNodeValue()))
        {
            NodeList nodelist = node.getChildNodes();
            Object obj = null;
            if(nodelist != null)
            {
                String s = A(graphmlparsecontext);
                for(int i = 0; i < nodelist.getLength(); i++)
                {
                    Node node2 = nodelist.item(i);
                    if(node2.getNodeType() != 1 || !s.equals(node2.getNamespaceURI()))
                        continue;
                    String s1 = node2.getLocalName();
                    if(!"Icon".equals(s1))
                        continue;
                    Node node3 = node2.getAttributes().getNamedItem("href");
                    if(node3 != null)
                    {
                        obj = I.A(node3.getNodeValue(), graphmlparsecontext);
                        continue;
                    }
                    node3 = node2.getAttributes().getNamedItem("image");
                    if(node3 != null)
                    {
                        java.awt.Image image = I.A(node2, node3.getNodeValue(), graphmlparsecontext);
                        if(image != null)
                            obj = new ImageIcon(image);
                        continue;
                    }
                    node3 = node2.getAttributes().getNamedItem("iconData");
                    if(node3 == null)
                        continue;
                    Serializable serializable = I.B(node2, node3.getNodeValue(), graphmlparsecontext);
                    if(serializable != null && (serializable instanceof Icon))
                        obj = (Icon)serializable;
                }

            }
            if(obj != null)
                return new CA(((Icon) (obj)));
            else
                return null;
        } else
        {
            return null;
        }
    }

    String A(GraphMLParseContext graphmlparsecontext)
    {
        String s = graphmlparsecontext.getProperty("org.graphdrawing.graphml.reader.dom.YFILES_EXT_NS").toString();
        if(s == null)
            s = "http://www.yworks.com/xml/graphml";
        return s;
    }

    public void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        Object obj = graphmlwritecontext.getProperty("writeSelectionState");
        if(obj != null && (obj instanceof Boolean) && ((Boolean)obj).booleanValue())
            xmlwriter.writeAttribute("selected", String.valueOf(u.A4()));
    }

    public void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        I.A(xmlwriter, u);
        I.A(xmlwriter, "LineStyle", u.AA(), u.A3());
        I.A(xmlwriter, "Arrows", u.z(), u.A5());
        for(int i = 0; i < u.w(); i++)
            I.A(xmlwriter, u.D(i), graphmlwritecontext);

        A(u.k(), xmlwriter, graphmlwritecontext, true);
        A(u.s(), xmlwriter, graphmlwritecontext, false);
    }

    private void A(n n, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext, boolean flag)
    {
        if(n instanceof CA)
        {
            CA ca = (CA)n;
            xmlwriter.writeStartElement(flag ? "SourcePort" : "TargetPort", "http://www.yworks.com/xml/graphml");
            xmlwriter.writeAttribute("type", "InterfacePort");
            Icon icon = ca.G();
            xmlwriter.writeStartElement("Icon", "http://www.yworks.com/xml/graphml");
            if(icon instanceof N)
                xmlwriter.writeAttribute("href", ((N)icon).A());
            else
            if(icon instanceof ImageIcon)
                I.A(((ImageIcon)icon).getImage(), null, xmlwriter, "image", graphmlwritecontext);
            else
            if(icon instanceof Serializable)
                I.A((Serializable)icon, xmlwriter, "iconData", graphmlwritecontext);
            xmlwriter.writeEndElement();
            xmlwriter.writeEndElement();
        }
    }

    public boolean A(U u, GraphMLWriteContext graphmlwritecontext)
    {
        return u.getClass() == B();
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(D()) && node.getLocalName().equals(A());
    }

    public U B(Node node, GraphMLParseContext graphmlparsecontext)
        throws GraphMLParseException
    {
        return (U)B().newInstance();
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
