// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.A.P;
import C.A.T;
import C.A.Y;
import C.G.f;
import C.H.A.J;
import C.H.A.K;
import C.H.A.L;
import C.H.A.Z;
import C.J.DA;
import C.J.N;
import C.J.O;
import C.J.U;
import C.J._;
import C.J.b;
import C.J.k;
import C.K.B;
import C.K.M;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package B.D.D:
//            N, H, A

public class I
{

    public static void A(M m, XmlWriter xmlwriter)
    {
        if(m != null)
        {
            xmlwriter.writeAttribute("x", String.valueOf(m.B()));
            xmlwriter.writeAttribute("y", String.valueOf(m.A()));
        }
    }

    public static void A(B b1, XmlWriter xmlwriter)
    {
        if(b1 != null)
        {
            xmlwriter.writeAttribute("width", String.valueOf(b1.Q()));
            xmlwriter.writeAttribute("height", String.valueOf(b1.R()));
        }
    }

    public static void A(XmlWriter xmlwriter, String s, M m)
    {
        if(m == null)
        {
            return;
        } else
        {
            xmlwriter.writeStartElement(s, "http://www.yworks.com/xml/graphml");
            A(m, xmlwriter);
            xmlwriter.writeEndElement();
            return;
        }
    }

    public static void A(XmlWriter xmlwriter, C.G.M m)
    {
        if(m == null)
            return;
        M m1 = m.f();
        M m2 = m.g();
        xmlwriter.writeStartElement("Path", "http://www.yworks.com/xml/graphml");
        if((m instanceof U) && ((U)m).v())
            xmlwriter.writeAttribute("reversedPathRendering", "true");
        xmlwriter.writeAttribute("sx", String.valueOf(m1.B()));
        xmlwriter.writeAttribute("sy", String.valueOf(m1.A()));
        xmlwriter.writeAttribute("tx", String.valueOf(m2.B()));
        xmlwriter.writeAttribute("ty", String.valueOf(m2.A()));
        for(int i = 0; i < m.e(); i++)
            A(xmlwriter, "Point", m.B(i));

        xmlwriter.writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, f f1)
    {
        xmlwriter.writeStartElement("Geometry", "http://www.yworks.com/xml/graphml");
        A(new M(f1.C(), f1.A()), xmlwriter);
        A(new B(f1.B(), f1.D()), xmlwriter);
        xmlwriter.writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, String s, O o, Color color)
    {
        String s1 = C.H.A.M.C(o.A());
        xmlwriter.writeStartElement(s, "http://www.yworks.com/xml/graphml");
        xmlwriter.writeAttribute("type", s1);
        xmlwriter.writeAttribute("width", String.valueOf(o.getLineWidth()));
        if(color != null)
            A(xmlwriter, "color", color);
        else
            xmlwriter.writeAttribute("hasColor", "false");
        xmlwriter.writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, String s, _ _p, _ _p1)
    {
        xmlwriter.writeStartElement(s, "http://www.yworks.com/xml/graphml").writeAttribute("source", C.H.A.M.A(_p)).writeAttribute("target", C.H.A.M.A(_p1)).writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, String s, Color color)
    {
        if(color != null)
        {
            StringBuffer stringbuffer = new StringBuffer(9);
            stringbuffer.append('#');
            String s1 = Integer.toHexString(color.getRed()).toUpperCase();
            for(int i = 2 - s1.length(); i > 0; i--)
                stringbuffer.append('0');

            stringbuffer.append(s1);
            s1 = Integer.toHexString(color.getGreen()).toUpperCase();
            for(int j = 2 - s1.length(); j > 0; j--)
                stringbuffer.append('0');

            stringbuffer.append(s1);
            s1 = Integer.toHexString(color.getBlue()).toUpperCase();
            for(int l = 2 - s1.length(); l > 0; l--)
                stringbuffer.append('0');

            stringbuffer.append(s1);
            if(color.getAlpha() != 255)
            {
                String s2 = Integer.toHexString(color.getAlpha()).toUpperCase();
                for(int i1 = 2 - s2.length(); i1 > 0; i1--)
                    stringbuffer.append('0');

                stringbuffer.append(s2);
            }
            xmlwriter.writeAttribute(s, stringbuffer.toString());
        }
    }

    public static void A(XmlWriter xmlwriter, k k1, GraphMLWriteContext graphmlwritecontext)
    {
        xmlwriter.writeAttribute("x", String.valueOf(k1.R()));
        xmlwriter.writeAttribute("y", String.valueOf(k1.U()));
        xmlwriter.writeAttribute("width", String.valueOf(k1.r()));
        xmlwriter.writeAttribute("height", String.valueOf(k1.O()));
        xmlwriter.writeAttribute("visible", String.valueOf(k1.b()));
        xmlwriter.writeAttribute("alignment", C.H.A.K.A(k1.c()));
        xmlwriter.writeAttribute("fontFamily", k1.P());
        xmlwriter.writeAttribute("fontSize", String.valueOf(k1.W()));
        xmlwriter.writeAttribute("fontStyle", C.H.A.K.A(k1.k()));
        A(xmlwriter, "textColor", k1.S());
        if(k1.M() != null)
            A(xmlwriter, "backgroundColor", k1.M());
        else
            xmlwriter.writeAttribute("hasBackgroundColor", "false");
        if(k1.e() != null)
            A(xmlwriter, "lineColor", k1.e());
        else
            xmlwriter.writeAttribute("hasLineColor", "false");
        if(k1.X() != null)
            xmlwriter.writeAttribute("configuration", k1.X());
        if(k1.a() != 0)
            xmlwriter.writeAttribute("autoSizePolicy", C.H.A.L.B(k1.a()));
        Icon icon = k1.j();
        if(icon != null)
        {
            if(icon instanceof B.D.D.N)
                xmlwriter.writeAttribute("icon", ((B.D.D.N)k1.j()).A());
            else
            if(icon instanceof ImageIcon)
                A(((ImageIcon)icon).getImage(), null, xmlwriter, "image", graphmlwritecontext);
            else
            if(icon instanceof Serializable)
                A((Serializable)icon, xmlwriter, "iconData", graphmlwritecontext);
            xmlwriter.writeAttribute("horizontalTextPosition", A(k1.Q()));
            xmlwriter.writeAttribute("verticalTextPosition", B(k1.h()));
            xmlwriter.writeAttribute("iconTextGap", String.valueOf(k1.s()));
        }
        if(k1.i() != 0.0D)
            xmlwriter.writeAttribute("rotationAngle", String.valueOf(k1.i()));
        if(k1.Y())
            xmlwriter.writeAttribute("underlinedText", "true");
    }

    public static void A(XmlWriter xmlwriter, DA da, GraphMLWriteContext graphmlwritecontext)
    {
        xmlwriter.writeStartElement("NodeLabel", "http://www.yworks.com/xml/graphml");
        byte byte0 = da.m();
        String s;
        if(byte0 == 6)
            s = "edge_opposite";
        else
            s = (String)K.get(new Byte(byte0));
        if(s != null)
            xmlwriter.writeAttribute("modelName", s);
        String s1;
        s1 = s1 = (String)I.get(new Byte(da.p()));
        if(s1 != null)
            xmlwriter.writeAttribute("modelPosition", s1);
        xmlwriter.writeAttribute("autoSizePolicy", C.H.A.L.B(da.a()));
        A(xmlwriter, ((k) (da)), graphmlwritecontext);
        xmlwriter.writeText(da.f());
        xmlwriter.writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, N n, GraphMLWriteContext graphmlwritecontext)
    {
        xmlwriter.writeStartElement("EdgeLabel", "http://www.yworks.com/xml/graphml");
        String s = (String)J.get(new Byte(n.m()));
        if(s != null)
            xmlwriter.writeAttribute("modelName", s);
        String s1 = (String)M.get(new Byte(n.p()));
        if(s1 != null)
            xmlwriter.writeAttribute("modelPosition", s1);
        Object obj = H.get(new Byte(n.L()));
        if(obj != null)
            xmlwriter.writeAttribute("preferredPlacement", obj.toString());
        xmlwriter.writeAttribute("distance", String.valueOf(n.A2()));
        xmlwriter.writeAttribute("ratio", String.valueOf(n.A4()));
        A(xmlwriter, ((k) (n)), graphmlwritecontext);
        xmlwriter.writeText(n.f());
        xmlwriter.writeEndElement();
    }

    public static void A(XmlWriter xmlwriter, String s, Insets insets)
    {
        xmlwriter.writeStartElement(s, "http://www.yworks.com/xml/graphml").writeAttribute("top", String.valueOf(insets.top)).writeAttribute("bottom", String.valueOf(insets.bottom)).writeAttribute("left", String.valueOf(insets.left)).writeAttribute("right", String.valueOf(insets.right)).writeEndElement();
    }

    private static URL A(GraphMLParseContext graphmlparsecontext)
    {
        java.util.List list;
        if(graphmlparsecontext == null)
            return null;
        list = graphmlparsecontext.getContainers();
        ListIterator listiterator = list.listIterator(list.size());
_L1:
        Object obj;
        if(!listiterator.hasPrevious())
            break MISSING_BLOCK_LABEL_62;
        obj = listiterator.previous();
        if(obj instanceof b)
            return ((b)obj).e();
          goto _L1
        Exception exception;
        exception;
        return null;
    }

    static Icon A(String s, GraphMLParseContext graphmlparsecontext)
    {
        URL url = null;
        URL url1 = A(graphmlparsecontext);
        try
        {
            url = new URL(s);
        }
        catch(MalformedURLException malformedurlexception)
        {
            try
            {
                url = new URL(url1, s);
            }
            catch(Exception exception)
            {
                graphmlparsecontext.getErrorHandler().warning("B.D.D.I", "Cannot load image from resource " + url1 + ":" + s, exception, graphmlparsecontext);
            }
        }
        return new B.D.D.N(url, s);
    }

    public static String D(Node node)
    {
        NodeList nodelist = node.getChildNodes();
        StringBuffer stringbuffer = new StringBuffer();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                stringbuffer.append(node1.getNodeValue());
            }

        }
        return stringbuffer.toString();
    }

    public static Insets B(Node node)
    {
        Insets insets = new Insets(0, 0, 0, 0);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("top");
        if(node1 != null)
            insets.top = Integer.parseInt(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("bottom");
        if(node1 != null)
            insets.bottom = Integer.parseInt(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("left");
        if(node1 != null)
            insets.left = Integer.parseInt(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("right");
        if(node1 != null)
            insets.right = Integer.parseInt(node1.getNodeValue());
        return insets;
    }

    public static void A(Node node, f f1)
    {
        double d = f1.C();
        double d1 = f1.A();
        double d2 = f1.B();
        double d3 = f1.D();
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("x");
        if(node1 != null)
            d = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("y");
        if(node1 != null)
            d1 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("width");
        if(node1 != null)
            d2 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("height");
        if(node1 != null)
            d3 = Double.parseDouble(node1.getNodeValue());
        if(d2 != f1.B() || d3 != f1.D())
            f1.B(d2, d3);
        if(d != f1.C() || d1 != f1.A())
            f1.A(d, d1);
    }

    public static void A(Node node, C.G.M m)
    {
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        NamedNodeMap namednodemap = node.getAttributes();
        if(m instanceof U)
        {
            Node node1 = namednodemap.getNamedItem("reversedPathRendering");
            if(node1 != null)
                ((U)m).H(Boolean.valueOf(node1.getNodeValue()).booleanValue());
        }
        Node node2 = namednodemap.getNamedItem("sx");
        if(node2 != null)
            d = Double.parseDouble(node2.getNodeValue());
        node2 = namednodemap.getNamedItem("sy");
        if(node2 != null)
            d1 = Double.parseDouble(node2.getNodeValue());
        node2 = namednodemap.getNamedItem("tx");
        if(node2 != null)
            d2 = Double.parseDouble(node2.getNodeValue());
        node2 = namednodemap.getNamedItem("ty");
        if(node2 != null)
            d3 = Double.parseDouble(node2.getNodeValue());
        m.A(new M(d, d1));
        m.B(new M(d2, d3));
        NodeList nodelist = node.getChildNodes();
        if(nodelist != null)
        {
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node3 = nodelist.item(i);
                if(node3.getNodeType() != 1)
                    continue;
                String s = node3.getLocalName();
                if("Point".equals(s))
                {
                    M m1 = A(node3);
                    m.E(m1.B(), m1.A());
                }
            }

        }
    }

    public static M A(Node node)
    {
        double d = 0.0D;
        double d1 = 0.0D;
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("x");
        if(node1 != null)
            d = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("y");
        if(node1 != null)
            d1 = Double.parseDouble(node1.getNodeValue());
        return new M(d, d1);
    }

    public static O C(Node node)
    {
        String s = "line";
        double d = 1.0D;
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("type");
        if(node1 != null)
            s = node1.getNodeValue();
        node1 = namednodemap.getNamedItem("width");
        if(node1 != null)
            d = Double.parseDouble(node1.getNodeValue());
        return O.A((int)d, C.H.A.J.G(s));
    }

    public static _ A(Node node, String s)
    {
        _ _l = null;
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem(s);
        if(node1 != null)
            _l = C.H.A.J.H(node1.getNodeValue());
        if(_l == null)
            _l = _.K;
        return _l;
    }

    public static void A(Node node, k k1, GraphMLParseContext graphmlparsecontext)
    {
        k1.B(D(node));
        double d = (0.0D / 0.0D);
        double d1 = (0.0D / 0.0D);
        double d2 = (0.0D / 0.0D);
        double d3 = (0.0D / 0.0D);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("x");
        if(node1 != null)
            d = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("y");
        if(node1 != null)
            d1 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("w");
        if(node1 != null)
            d2 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("h");
        if(node1 != null)
            d3 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("autoSizePolicy");
        if(node1 != null)
            k1.H(Z.L(node1.getNodeValue()));
        if(!Double.isNaN(d2) && !Double.isNaN(d3))
        {
            k1.A(d3);
            k1.C(d2);
            k1.C(d2, d3);
        }
        if(!Double.isNaN(d) && !Double.isNaN(d1))
            k1.E(d, d1);
        node1 = namednodemap.getNamedItem("width");
        if(node1 != null)
            d2 = Double.parseDouble(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("height");
        if(node1 != null)
            d3 = Double.parseDouble(node1.getNodeValue());
        if(!Double.isNaN(d2) && !Double.isNaN(d3))
            k1.C(d2, d3);
        node1 = namednodemap.getNamedItem("visible");
        if(node1 != null)
            k1.A(Boolean.valueOf(node1.getNodeValue()).booleanValue());
        node1 = namednodemap.getNamedItem("alignment");
        if(node1 != null)
            k1.D(Z.N(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("textColor");
        if(node1 != null)
            k1.C(C(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("backgroundColor");
        if(node1 != null)
            k1.B(C(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("hasBackgroundColor");
        if(node1 != null && Boolean.valueOf(node1.getNodeValue()).equals(Boolean.FALSE))
        {
            k1.B(null);
        } else
        {
            node1 = namednodemap.getNamedItem("backgroundColor");
            if(node1 != null)
                k1.B(C(node1.getNodeValue()));
        }
        node1 = namednodemap.getNamedItem("hasLineColor");
        if(node1 != null && Boolean.valueOf(node1.getNodeValue()).equals(Boolean.FALSE))
        {
            k1.A(null);
        } else
        {
            node1 = namednodemap.getNamedItem("lineColor");
            if(node1 != null)
                k1.A(C(node1.getNodeValue()));
        }
        node1 = namednodemap.getNamedItem("fontFamily");
        if(node1 != null)
            k1.A(node1.getNodeValue());
        node1 = namednodemap.getNamedItem("fontSize");
        if(node1 != null)
            k1.B(Integer.parseInt(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("fontStyle");
        if(node1 != null)
            k1.A(Z.M(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("icon");
        if(node1 != null)
        {
            k1.A(A(node1.getNodeValue(), graphmlparsecontext));
        } else
        {
            node1 = namednodemap.getNamedItem("image");
            if(node1 != null)
            {
                Image image = A(node, node1.getNodeValue(), graphmlparsecontext);
                if(image != null)
                    k1.A(new ImageIcon(image));
            } else
            {
                node1 = namednodemap.getNamedItem("iconData");
                if(node1 != null)
                {
                    Serializable serializable = B(node, node1.getNodeValue(), graphmlparsecontext);
                    if(serializable != null && (serializable instanceof Icon))
                        k1.A((Icon)serializable);
                }
            }
        }
        node1 = namednodemap.getNamedItem("horizontalTextPosition");
        if(node1 != null)
            k1.E(B(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("verticalTextPosition");
        if(node1 != null)
            k1.C(A(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("iconTextGap");
        if(node1 != null)
            k1.G(Byte.parseByte(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("rotationAngle");
        if(node1 != null)
            k1.B(Double.parseDouble(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("underlinedText");
        if(node1 != null)
            k1.B(Boolean.valueOf(node1.getNodeValue()).booleanValue());
        node1 = namednodemap.getNamedItem("configuration");
        if(node1 != null && node1.getNodeValue() != null && node1.getNodeValue().length() > 0)
            k1.C(node1.getNodeValue());
        Node node2 = namednodemap.getNamedItem("userdata");
        Node node3 = namednodemap.getNamedItem("userdataclass");
        if(node2 != null && node3 != null)
        {
            String s = node2.getNodeValue();
            String s1 = node3.getNodeValue();
            try
            {
                Object obj = C.E.L.B().A(s, Class.forName(s1));
                k1.B(obj);
            }
            catch(Exception exception)
            {
                graphmlparsecontext.getErrorHandler().warning("B.D.D.I", "Could not parse userdata " + s + " [" + s1 + "] ", exception, graphmlparsecontext);
            }
        }
    }

    public static void A(Node node, DA da)
    {
        A(node, da, ((GraphMLParseContext) (null)));
    }

    static void A(Node node, DA da, GraphMLParseContext graphmlparsecontext)
    {
        A(node, ((k) (da)), graphmlparsecontext);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("modelName");
        if(node1 != null)
        {
            String s = node1.getNodeValue();
            if("edge_opposite".equals(s))
            {
                da.B((byte)6);
                T t = (T)graphmlparsecontext.getCurrentContainer();
                C.G.I i = (C.G.I)t._();
                C.G.U u = new C.G.U(i, t);
                da.A(u);
                da.A(u.A());
            } else
            {
                Object obj1 = E.get(s);
                if(obj1 instanceof Byte)
                {
                    byte byte0 = ((Byte)obj1).byteValue();
                    da.B(byte0);
                    if(byte0 == 6)
                    {
                        T t1 = (T)graphmlparsecontext.getCurrentContainer();
                        C.G.I j = (C.G.I)t1._();
                        C.G.U u1 = new C.G.U(j, t1);
                        da.A(u1);
                        da.A(u1.A());
                    }
                }
            }
        }
        node1 = namednodemap.getNamedItem("modelPosition");
        if(node1 != null)
        {
            Object obj = B.get(node1.getNodeValue());
            if(obj instanceof Byte)
                da.F(((Byte)obj).byteValue());
        }
    }

    static void A(Node node, N n, GraphMLParseContext graphmlparsecontext)
    {
        A(node, ((k) (n)), graphmlparsecontext);
        NamedNodeMap namednodemap = node.getAttributes();
        Node node1 = namednodemap.getNamedItem("modelName");
        if(node1 != null)
        {
            Object obj = A.get(node1.getNodeValue());
            if(obj instanceof Byte)
                n.B(((Byte)obj).byteValue());
        }
        node1 = namednodemap.getNamedItem("modelPosition");
        if(node1 != null)
        {
            Object obj1 = F.get(node1.getNodeValue());
            if(obj1 instanceof Byte)
                n.F(((Byte)obj1).byteValue());
        }
        node1 = namednodemap.getNamedItem("preferredPlacement");
        if(node1 != null)
        {
            Object obj2 = G.get(node1.getNodeValue());
            if(obj2 instanceof Byte)
                n.I(((Byte)obj2).byteValue());
        }
        node1 = namednodemap.getNamedItem("distance");
        if(node1 != null)
            n.F(Double.parseDouble(node1.getNodeValue()));
        node1 = namednodemap.getNamedItem("ratio");
        if(node1 != null)
            n.E(Double.parseDouble(node1.getNodeValue()));
        switch(n.m())
        {
        case 5: // '\005'
        case 6: // '\006'
            Node node2 = namednodemap.getNamedItem("x");
            Node node3 = namednodemap.getNamedItem("y");
            if(node2 != null && node3 != null)
            {
                U u = n.A3();
                if(u != null)
                {
                    Point2D point2d = u.u();
                    double d = point2d.getX() + Double.parseDouble(node2.getNodeValue());
                    double d1 = point2d.getY() + Double.parseDouble(node3.getNodeValue());
                    Object obj3 = n.F(d, d1);
                    if(obj3 != null)
                        n.A(obj3);
                }
            }
            break;
        }
    }

    public static Color C(String s)
    {
        if(s.length() < 1 || s.charAt(0) != '#')
            return Color.BLACK;
        int i;
        if(s.length() > 7)
        {
            i = Integer.parseInt(s.substring(1, 7), 16);
            int j = Integer.parseInt(s.substring(7), 16);
            i += (j & 0xff) << 24;
        } else
        {
            int l = Integer.parseInt(s.substring(1), 16);
            i = l + 0xff000000;
        }
        for(P p = C.I(); p != null; p = p.C())
        {
            Color color1 = (Color)p.A();
            if(color1.getRGB() == i)
            {
                C.A(p);
                C.C(p);
                return color1;
            }
        }

        Color color = new Color(i, true);
        if(C.size() >= 32)
        {
            P p1 = C.G();
            C.A(p1);
            p1.A(color);
            C.C(p1);
        } else
        {
            C.B(color);
        }
        return color;
    }

    private static byte B(String s)
    {
        if("left".equals(s))
            return 8;
        if("right".equals(s))
            return 16;
        if("left_aligned".equals(s))
            return 32;
        return ((byte)(!"right_aligned".equals(s) ? 2 : 64));
    }

    private static byte A(String s)
    {
        if("top".equals(s))
            return 1;
        return ((byte)(!"center".equals(s) ? 4 : 2));
    }

    private static String A(byte byte0)
    {
        switch(byte0)
        {
        case 8: // '\b'
            return "left";

        case 16: // '\020'
            return "right";

        case 2: // '\002'
            return "center";

        case 32: // ' '
            return "left_aligned";

        case 64: // '@'
            return "right_aligned";
        }
        return "center";
    }

    private static String B(byte byte0)
    {
        switch(byte0)
        {
        case 1: // '\001'
            return "top";

        case 4: // '\004'
            return "bottom";

        case 2: // '\002'
        case 3: // '\003'
        default:
            return "bottom";
        }
    }

    static void A(Image image, URL url, XmlWriter xmlwriter, String s, GraphMLWriteContext graphmlwritecontext)
    {
        if(graphmlwritecontext == null || image == null || image.getHeight(null) == 0 || image.getWidth(null) == 0)
            return;
        org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceHandler resourcehandler = (org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceHandler)graphmlwritecontext.lookup(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandler.class);
        if(resourcehandler != null)
        {
            org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceDescriptor resourcedescriptor = resourcehandler.registerResource(image, L);
            if(resourcedescriptor != null)
                xmlwriter.writeAttribute(s, resourcedescriptor.getId());
        }
    }

    static void A(Serializable serializable, XmlWriter xmlwriter, String s, GraphMLWriteContext graphmlwritecontext)
    {
        if(graphmlwritecontext == null || serializable == null)
            return;
        org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceHandler resourcehandler = (org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceHandler)graphmlwritecontext.lookup(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandler.class);
        if(resourcehandler != null)
        {
            org.graphdrawing.graphml.writer.GraphMLWriteContext.ResourceDescriptor resourcedescriptor = resourcehandler.registerResource(serializable, D);
            if(resourcedescriptor != null)
                xmlwriter.writeAttribute(s, resourcedescriptor.getId());
        }
    }

    static Image A(Node node, String s, GraphMLParseContext graphmlparsecontext)
    {
        if(graphmlparsecontext == null)
            return null;
        org.graphdrawing.graphml.reader.GraphMLParseContext.ResourceHandler resourcehandler = (org.graphdrawing.graphml.reader.GraphMLParseContext.ResourceHandler)graphmlparsecontext.lookup(org.graphdrawing.graphml.reader.GraphMLParseContext$ResourceHandler.class);
        if(resourcehandler != null)
            return (Image)resourcehandler.getResourceForID(s, L, graphmlparsecontext);
        else
            return null;
    }

    static Serializable B(Node node, String s, GraphMLParseContext graphmlparsecontext)
    {
        if(graphmlparsecontext == null)
            return null;
        org.graphdrawing.graphml.reader.GraphMLParseContext.ResourceHandler resourcehandler = (org.graphdrawing.graphml.reader.GraphMLParseContext.ResourceHandler)graphmlparsecontext.lookup(org.graphdrawing.graphml.reader.GraphMLParseContext$ResourceHandler.class);
        if(resourcehandler != null)
            return (Serializable)resourcehandler.getResourceForID(s, D, graphmlparsecontext);
        else
            return null;
    }

    static final Map I;
    static final Map K;
    static final Map M;
    static final Map J;
    static final Map H;
    static final Map B;
    static final Map E;
    static final Map F;
    static final Map A;
    static final Map G;
    private static final H L = new H();
    private static final A D = new A();
    private static Y C;

    static 
    {
        I = L.C;
        K = L.D;
        M = C.H.A.P.F;
        J = C.H.A.P.G;
        H = C.H.A.P.E;
        B = new HashMap();
        E = Z.l;
        F = Z.j;
        A = Z.k;
        G = Z.h;
        B.put("n", new Byte((byte)108));
        B.put("nw", new Byte((byte)104));
        B.put("ne", new Byte((byte)105));
        B.put("w", new Byte((byte)111));
        B.put("e", new Byte((byte)110));
        B.put("sw", new Byte((byte)107));
        B.put("s", new Byte((byte)109));
        B.put("se", new Byte((byte)106));
        B.put("c", new Byte((byte)100));
        B.put("t", new Byte((byte)102));
        B.put("tl", new Byte((byte)117));
        B.put("tr", new Byte((byte)118));
        B.put("r", new Byte((byte)116));
        B.put("l", new Byte((byte)115));
        B.put("bl", new Byte((byte)119));
        B.put("b", new Byte((byte)101));
        B.put("br", new Byte((byte)120));
        B.put("anywhere", new Byte((byte)114));
        B.put("dynamic", new Byte((byte)112));
        C = new Y();
        C.add(Color.BLACK);
        C.add(Color.RED);
        C.add(Color.BLUE);
        C.add(Color.YELLOW);
        C.add(Color.GREEN);
        C.add(Color.WHITE);
    }
}
