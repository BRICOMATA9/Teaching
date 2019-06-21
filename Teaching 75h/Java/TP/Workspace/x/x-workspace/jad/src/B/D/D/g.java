// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import org.graphdrawing.graphml.reader.GraphMLParseContext;
import org.w3c.dom.Node;

// Referenced classes of package B.D.D:
//            Y

public class g extends Y
{

    public g()
    {
    }

    public String A()
    {
        return "BezierEdge";
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public Class B()
    {
        return C.J.z.class;
    }

    public boolean A(Node node, GraphMLParseContext graphmlparsecontext)
    {
        return node.getNamespaceURI().equals(A(graphmlparsecontext)) && node.getLocalName().equals(A());
    }
}
