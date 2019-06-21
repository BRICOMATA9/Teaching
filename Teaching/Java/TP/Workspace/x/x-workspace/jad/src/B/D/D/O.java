// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.E.L;
import C.J.EA;
import C.J.U;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.writer.*;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            Y

public class O extends Y
{

    public O()
    {
    }

    public String A()
    {
        return "GenericEdge";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.EA.class;
    }

    public void A(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.A(u, xmlwriter, graphmlwritecontext);
        EA ea = (EA)u;
        xmlwriter.writeAttribute("configuration", ea.D9());
    }

    public void B(U u, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(u, xmlwriter, graphmlwritecontext);
        EA ea = (EA)u;
        A(ea, xmlwriter, graphmlwritecontext);
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    protected void A(EA ea, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        if(ea.DA() != null)
            try
            {
                String s = L.B().A(ea.DA(), ea.DA().getClass());
                xmlwriter.writeStartElement("UserData", "http://www.yworks.com/xml/graphml").writeAttribute("class", ea.DA().getClass().getName()).writeAttribute("value", s).writeEndElement();
            }
            catch(Exception exception)
            {
                graphmlwritecontext.getErrorHandler().warning("ext.graphml.graph2D.GenericEdgeRealizerSerializer#writeUserData", "Could not write userdata " + ea.DA(), exception, graphmlwritecontext);
            }
    }

    public void A(U u, Node node, GraphMLParseContext graphmlparsecontext)
    {
        EA ea = (EA)u;
        super.A(ea, node, graphmlparsecontext);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("configuration");
        if(node1 != null)
            try
            {
                ea.C(node1.getNodeValue());
            }
            catch(IllegalArgumentException illegalargumentexception)
            {
                Node node2 = (Node)graphmlparsecontext.lookup(org.w3c.dom.Node.class);
                graphmlparsecontext.setLookup(org.w3c.dom.Node.class, node);
                graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.GenericEdgeRealizerSerializer#parse", "Invalid value for configuration " + node1.getNodeValue(), illegalargumentexception, graphmlparsecontext);
                graphmlparsecontext.setLookup(org.w3c.dom.Node.class, node2);
            }
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node3 = nodelist.item(i);
                if(node3.getNodeType() == 1)
                    A(ea, node3, graphmlparsecontext);
            }

        }
    }

    protected void A(EA ea, Node node, GraphMLParseContext graphmlparsecontext)
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
            ea.A(obj);
        }
        catch(Exception exception)
        {
            graphmlparsecontext.getErrorHandler().warning("yext.graphml.graph2D.GenericEdgeRealizerSerializer#parseUserData", "Could not parse userdata " + s2, exception, graphmlparsecontext);
        }
    }
}
