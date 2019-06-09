// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.A.T;
import C.J.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.*;

// Referenced classes of package B.D.D:
//            b, I

public class K extends B.D.D.b
{

    public K()
    {
    }

    public String A()
    {
        return "ImageNode";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.y.class;
    }

    public void B(Y y1, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        super.B(y1, xmlwriter, graphmlwritecontext);
        y y2 = (y)y1;
        URL url = y2._();
        java.awt.Image image = y2.c();
        xmlwriter.writeStartElement("Image", "http://www.yworks.com/xml/graphml");
        if(url == null)
        {
            I.A(image, url, xmlwriter, "refid", graphmlwritecontext);
        } else
        {
            xmlwriter.writeAttribute("href", url.toString());
            I.A(image, url, xmlwriter, "refid", graphmlwritecontext);
        }
        if(y2.Z())
            xmlwriter.writeAttribute("alphaImage", "true");
        xmlwriter.writeEndElement();
    }

    public void A(Y y1, Node node, GraphMLParseContext graphmlparsecontext)
    {
        y y2 = (y)y1;
        super.A(y2, node, graphmlparsecontext);
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() != 1)
                    continue;
                String s = node1.getLocalName();
                if(!"Image".equals(s))
                    continue;
                NamedNodeMap namednodemap = node1.getAttributes();
                java.awt.Image image = null;
                Node node2 = namednodemap.getNamedItem("refid");
                if(node2 != null && B(graphmlparsecontext))
                    image = I.A(node, node2.getNodeValue(), graphmlparsecontext);
                if(image != null)
                {
                    y2.B(image);
                } else
                {
                    URL url = null;
                    node2 = namednodemap.getNamedItem("href");
                    if(node2 != null)
                    {
                        try
                        {
                            url = new URL(node2.getNodeValue());
                            y2.C(url);
                            image = y2.c();
                        }
                        catch(MalformedURLException malformedurlexception)
                        {
                            try
                            {
                                T t = (T)graphmlparsecontext.getCurrentContainer();
                                URL url1 = ((b)t._()).e();
                                url = new URL(url1, node2.getNodeValue());
                                y2.C(url);
                                image = y2.c();
                            }
                            catch(Exception exception) { }
                        }
                        if(image == null)
                        {
                            A = graphmlparsecontext.getErrorHandler();
                            A.warning("yext.graphml.graph2D.ImageNodeRealizerSerializer#parse", "Cannot load image from: " + node2.getNodeValue() + ", trying embedded representation instead", null, graphmlparsecontext);
                            node2 = namednodemap.getNamedItem("refid");
                            if(node2 != null)
                            {
                                java.awt.Image image1 = I.A(node, node2.getNodeValue(), graphmlparsecontext);
                                if(image1 != null)
                                    if(url != null)
                                    {
                                        y.a().put(url, image1);
                                        y2.C(url);
                                    } else
                                    {
                                        y2.B(image1);
                                    }
                            }
                        }
                    }
                }
                node2 = namednodemap.getNamedItem("alphaImage");
                if(node2 != null)
                    y2.D("true".equalsIgnoreCase(node2.getNodeValue()));
            }

        }
    }

    public boolean B(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }

    private boolean B(GraphMLParseContext graphmlparsecontext)
    {
        Boolean boolean1 = (Boolean)graphmlparsecontext.getProperty("useEmbeddedResources");
        if(boolean1 == null)
            return true;
        else
            return boolean1.booleanValue();
    }

    public GraphMLParseErrorHandler A;
}
