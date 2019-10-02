// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package A.D;

import B.D.A.C;
import C.A.D;
import C.A.J;
import C.A.T;
import C.J.b;
import java.util.HashMap;
import java.util.Map;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

final class A extends C
    implements Precedence
{

    A(int i)
    {
        F = i;
    }

    public int getPrecedence()
    {
        return F;
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i != 2 && i != 1)
        {
            return false;
        } else
        {
            Node node = namednodemap.getNamedItem("yfiles.type");
            return node != null && "umlentityinformation".equals(node.getNodeValue());
        }
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node)
    {
        if(obj instanceof J)
            A(d, (J)obj, node);
        else
        if(obj instanceof T)
            A(d, (T)obj, node);
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj)
    {
    }

    private void A(D d, J j, Node node)
    {
        Node node1 = node.getFirstChild();
        do
        {
            if(node1 == null)
                break;
            if("EdgeInfo".equals(node1.getLocalName()))
            {
                Element element = (Element)node1;
                A.C._C _lc = (A.C._C)H.get(element.getAttribute("type"));
                boolean flag = "true".equalsIgnoreCase(element.getAttribute("foreign"));
                int i = 0;
                try
                {
                    i = Integer.parseInt(element.getAttribute("multiplicity"));
                }
                catch(NumberFormatException numberformatexception)
                {
                    i = 0;
                }
                A.C.A a = A.C.A.A((b)d);
                a.A(j, _lc == null ? A.C.A.F : _lc, flag, i);
                break;
            }
            node1 = node1.getNextSibling();
        } while(true);
    }

    private void A(D d, T t, Node node)
    {
        Node node1 = node.getFirstChild();
        do
        {
            if(node1 == null)
                break;
            if("NodeInfo".equals(node1.getLocalName()))
            {
                Element element = (Element)node1;
                String s = element.getAttribute("name");
                String s1 = element.getAttribute("namespace");
                A.C._A _la = (A.C._A)G.get(element.getAttribute("type"));
                boolean flag = "true".equalsIgnoreCase(element.getAttribute("foreign"));
                boolean flag1 = "true".equalsIgnoreCase(element.getAttribute("detailed"));
                int i = 0;
                try
                {
                    i = Integer.parseInt(element.getAttribute("relationcount"));
                }
                catch(NumberFormatException numberformatexception)
                {
                    i = 0;
                }
                A.C.A a = A.C.A.A((b)d);
                a.A(t, s, s1, _la == null ? A.C.A.M : _la, flag, flag1, i);
                break;
            }
            node1 = node1.getNextSibling();
        } while(true);
    }

    private static final Map H;
    private static final Map G;
    private final int F;

    static 
    {
        H = new HashMap();
        H.put(A.C.A.W.toString(), A.C.A.W);
        H.put(A.C.A.E.toString(), A.C.A.E);
        H.put(A.C.A.P.toString(), A.C.A.P);
        H.put(A.C.A.J.toString(), A.C.A.J);
        H.put(A.C.A.T.toString(), A.C.A.T);
        H.put(A.C.A.F.toString(), A.C.A.F);
        G = new HashMap();
        G.put(A.C.A.I.toString(), A.C.A.I);
        G.put(A.C.A.Q.toString(), A.C.A.Q);
        G.put(A.C.A.B.toString(), A.C.A.B);
        G.put(A.C.A.N.toString(), A.C.A.N);
        G.put(A.C.A.G.toString(), A.C.A.G);
        G.put(A.C.A.C.toString(), A.C.A.C);
        G.put(A.C.A.O.toString(), A.C.A.O);
        G.put(A.C.A.S.toString(), A.C.A.S);
        G.put(A.C.A.R.toString(), A.C.A.R);
        G.put(A.C.A.M.toString(), A.C.A.M);
    }
}
