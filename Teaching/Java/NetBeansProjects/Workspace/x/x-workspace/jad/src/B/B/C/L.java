// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.B;
import B.B.B.F;
import B.D.D.I;
import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package B.B.C:
//            A

public class L extends A
{

    public L()
    {
    }

    public String A()
    {
        return "PackageRealizer";
    }

    public Class B()
    {
        return B.B.A.B.class;
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        I.A(xmlwriter, y);
        B b = (B)y;
        F f = b.F2();
        I.A(xmlwriter, "AutoBoundsInsets", b.E8());
        xmlwriter.writeStartElement("Package", D()).writeAttribute("name", f.G()).writeEndElement();
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        B b = (B)y;
        b.J(B(node));
        F f = new F();
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            String s = node1.getLocalName();
            if("Package".equals(s))
            {
                String s1 = B(node1, "name");
                if(s1 != null)
                    f.C(s1);
                else
                    f.C("");
                continue;
            }
            if("Geometry".equals(s))
            {
                I.A(node1, b);
                continue;
            }
            if("AutoBoundsInsets".equals(s))
                b.A(I.B(node1));
        }

        b.A(f);
    }

    private static boolean B(Node node)
    {
        Node node1;
        for(node1 = node; node1 != null && !"node".equals(node1.getLocalName()); node1 = node1.getParentNode());
        Node node2 = node1 == null ? null : node1.getAttributes().getNamedItem("yfiles.foldertype");
        return node2 != null && "group".equals(node2.getNodeValue());
    }
}
