// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.D;

import B.D.A.C;
import C.A.*;
import C.E.V;
import C.J.*;
import java.util.HashMap;
import java.util.Map;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package A.D:
//            D

final class B extends C
    implements Precedence
{

    public B(int i)
    {
        A = i;
    }

    public int getPrecedence()
    {
        return A;
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node)
    {
        if(flag)
            return;
        if(obj instanceof T)
        {
            Y y = ((b)d).U((T)obj);
            for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
                if("LabelReferences".equals(node1.getLocalName()))
                {
                    int i = y.L();
                    int k = 0;
                    for(Node node3 = node1.getFirstChild(); node3 != null && k < i; node3 = node3.getNextSibling())
                    {
                        if(!"Link".equals(node3.getLocalName()))
                            continue;
                        if(node3.hasAttributes())
                        {
                            Node node5 = node3.getAttributes().getNamedItem("href");
                            if(node5 != null)
                                A(d).put(y.A(k), node5.getNodeValue());
                        }
                        k++;
                    }

                }

        } else
        if(obj instanceof J)
        {
            U u = ((b)d).R((J)obj);
            for(Node node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling())
            {
                if(!"LabelReferences".equals(node2.getLocalName()))
                    continue;
                int j = u.w();
                int l = 0;
                for(Node node4 = node2.getFirstChild(); node4 != null && l < j; node4 = node4.getNextSibling())
                {
                    if(!"Link".equals(node4.getLocalName()))
                        continue;
                    if(node4.hasAttributes())
                    {
                        Node node6 = node4.getAttributes().getNamedItem("href");
                        if(node6 != null)
                            A(d).put(u.D(l), node6.getNodeValue());
                    }
                    l++;
                }

            }

        }
    }

    private Map A(D d)
    {
        M m = d.B(D.C4);
        if(m == null)
        {
            m = V.A(new HashMap());
            d.A(D.C4, m);
        }
        return (Map)m.D(d);
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj)
    {
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i != 1 && i != 2)
        {
            return false;
        } else
        {
            Node node = namednodemap.getNamedItem("yfiles.type");
            return node != null && "labelreferences".equals(node.getNodeValue());
        }
    }

    private final int A;
}
