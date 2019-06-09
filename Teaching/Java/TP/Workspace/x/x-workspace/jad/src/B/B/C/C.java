// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.E;
import B.D.D.I;
import C.A.D;
import C.A.T;
import C.J.Y;
import C.J.b;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class C extends B.D.A.C
    implements Precedence
{

    public C(int i)
    {
        B = i;
    }

    public int getPrecedence()
    {
        return B;
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node)
    {
        if(flag || !(obj instanceof T))
            return;
        Y y = ((b)d).U((T)obj);
        if(!(y instanceof E))
            return;
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if(!"ClassifierLabels".equals(node1.getLocalName()))
                continue;
            int i = y.L();
            int j = 0;
            for(Node node2 = node1.getFirstChild(); node2 != null && j < i; node2 = node2.getNextSibling())
                if("NodeLabel".equals(node2.getLocalName()))
                    I.A(node2, y.A(j++));

        }

    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj)
    {
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i != 1)
        {
            return false;
        } else
        {
            Node node = namednodemap.getNamedItem("yfiles.type");
            return node != null && "classifierlabels".equals(node.getNodeValue());
        }
    }

    private final int B;
}
