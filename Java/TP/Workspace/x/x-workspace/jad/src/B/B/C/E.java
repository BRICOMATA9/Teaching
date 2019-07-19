// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.D.A.C;
import C.A.D;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class E extends C
    implements Precedence
{

    public E(int i)
    {
        C = i;
    }

    public int getPrecedence()
    {
        return C;
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj)
    {
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i == 2)
            return true;
        if(i == 1)
        {
            Node node = namednodemap.getNamedItem("yfiles.type");
            return node != null && "nodegraphics".equals(node.getNodeValue());
        } else
        {
            return false;
        }
    }

    private final int C;
}
