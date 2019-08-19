// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.D;

import C.A.T;
import C.J.A.G;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.XMLAttributesParserAdapter;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class a extends XMLAttributesParserAdapter
{

    public a(G g)
    {
        A = g;
    }

    public void parseNodeAttributes(DOMGraphMLParseContext domgraphmlparsecontext)
    {
        NamedNodeMap namednodemap = domgraphmlparsecontext.getAttributes();
        Node node = namednodemap.getNamedItem("yfiles.foldertype");
        if(node == null)
            return;
        String s = node.getNodeValue().toString();
        if(s == null)
            return;
        T t = (T)domgraphmlparsecontext.getCurrentContainer();
        if("folder".equals(s.toLowerCase()))
            A.I(t);
        else
        if("group".equals(s.toLowerCase()))
            A.G(t);
    }

    private G A;
}
