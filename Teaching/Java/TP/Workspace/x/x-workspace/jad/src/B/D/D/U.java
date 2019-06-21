// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.E.L;
import C.J.HA;
import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.writer.*;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            b

public class U extends b
{

    public U()
    {
    }

    public String A()
    {
        return "GenericNode";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.HA.class;
    }

    public void A(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.A(y, xmlwriter, graphmlwritecontext);
        HA ha = (HA)y;
        xmlwriter.writeAttribute("configuration", ha.DF());
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(y, xmlwriter, graphmlwritecontext);
        HA ha = (HA)y;
        A(ha, xmlwriter, graphmlwritecontext);
    }

    protected void A(HA ha, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        if(ha.E0() != null)
            try
            {
                String s = L.B().A(ha.E0(), ha.E0().getClass());
                xmlwriter.writeStartElement("UserData", "http://www.yworks.com/xml/graphml").writeAttribute("class", ha.E0().getClass().getName()).writeAttribute("value", s).writeEndElement();
            }
            catch(Exception exception)
            {
                graphmlwritecontext.getErrorHandler().warning("ext.graphml.graph2D.GenericNodeRealizerSerializer#writeUserData", "Could not write userdata " + ha.E0(), exception, graphmlwritecontext);
            }
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        HA ha = (HA)y;
        super.A(ha, node, graphmlparsecontext);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("configuration");
        if(node1 != null)
            try
            {
                ha.D(node1.getNodeValue());
            }
            catch(IllegalArgumentException illegalargumentexception)
            {
                Node node2 = (Node)graphmlparsecontext.lookup(org.w3c.dom.Node.class);
                graphmlparsecontext.setLookup(org.w3c.dom.Node.class, node);
                graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.GenericNodeRealizerSerializer#parse", "Invalid value for configuration " + node1.getNodeValue(), illegalargumentexception, graphmlparsecontext);
                graphmlparsecontext.setLookup(org.w3c.dom.Node.class, node2);
            }
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node3 = nodelist.item(i);
                if(node3.getNodeType() == 1)
                    A(ha, node3, graphmlparsecontext);
            }

        }
    }

    public boolean B(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    protected void A(HA ha, Node node, GraphMLParseContext graphmlparsecontext)
    {
        String s = node.getLocalName();
        if(s == null || !"userdata".equals(s.toLowerCase()))
            return;
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("class");
        String s1 = null;
        if(node1 != null)
            s1 = node1.getNodeValue();
        node1 = namednodemap.getNamedItem("value");
        String s2 = null;
        if(node1 != null)
            s2 = node1.getNodeValue();
        try
        {
            Object obj = L.B().A(s2, Class.forName(s1));
            ha.B(obj);
        }
        catch(Exception exception)
        {
            graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.GenericNodeRealizerSerializer#parseUserData", "Could not parse userdata " + s2, exception, graphmlparsecontext);
        }
    }
}
