// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.K;
import B.B.B.A;
import C.J.Y;
import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.graphdrawing.graphml.writer.GraphMLWriteContext;
import org.graphdrawing.graphml.writer.XmlWriter;
import org.w3c.dom.Node;

// Referenced classes of package B.B.C:
//            A

public class I extends B.B.C.A
{

    public I()
    {
    }

    public String A()
    {
        return "NoteRealizer";
    }

    public Class B()
    {
        return B.B.A.K.class;
    }

    public void B(Y y, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        A a = ((K)y).EC();
        xmlwriter.writeStartElement("Note", D());
        xmlwriter.writeText(a.H());
        xmlwriter.writeEndElement();
        B.D.D.I.A(xmlwriter, y);
    }

    public void A(Y y, Node node, GraphMLParseContext graphmlparsecontext)
    {
        A a = new A();
label0:
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if("Note".equals(node1.getLocalName()))
            {
                Node node2 = node1.getFirstChild();
                do
                {
                    if(node2 == null)
                        continue label0;
                    if(node2.getNodeType() == 3)
                        a.D(node2.getNodeValue());
                    node2 = node2.getNextSibling();
                } while(true);
            }
            if("Geometry".equals(node1.getLocalName()))
                B.D.D.I.A(node1, y);
        }

        ((K)y).A(a);
    }
}
