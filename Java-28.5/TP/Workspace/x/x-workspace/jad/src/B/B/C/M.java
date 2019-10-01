// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.B.A.B.D;
import B.B.A.H;
import B.D.A.C;
import C.J.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package B.B.C:
//            B

public class M extends C
    implements Precedence
{

    public M(int i)
    {
        D = i;
    }

    public int getPrecedence()
    {
        return D;
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i != 3)
            return false;
        Node node = namednodemap.getNamedItem("yfiles.type");
        if(node == null)
            return false;
        return "uml-style".equals(node.getNodeValue());
    }

    String A(Node node, String s)
    {
        NamedNodeMap namednodemap = node.getAttributes();
        if(namednodemap == null)
            return null;
        Node node1 = namednodemap.getNamedItem(s);
        if(node1 == null)
            return null;
        else
            return node1.getNodeValue();
    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, C.A.D d, Object obj, boolean flag, Node node)
    {
        if(flag || domgraphmlparsecontext.getContainers().size() > 1)
            return;
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if(!"StyleDefinition".equals(node1.getLocalName()))
                continue;
            D d1 = new D();
            B.B.A.B.C c = A((b)d);
            if(c == null)
                c = H.C().A();
            String s = A(node1, "link");
            if(s != null)
            {
                URL url = ((b)d).e();
                if(url != null)
                {
                    String s1 = url.getFile();
                    int i = s1.lastIndexOf('/');
                    String s2 = s1.substring(0, i + 1) + s;
                    InputStream inputstream = null;
                    try
                    {
                        URL url1 = new URL(url.getProtocol(), url.getHost(), url.getPort(), s2);
                        inputstream = url1.openStream();
                        d1.A(c, inputstream);
                    }
                    catch(MalformedURLException malformedurlexception)
                    {
                        malformedurlexception.printStackTrace();
                    }
                    catch(IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                    finally
                    {
                        if(inputstream != null)
                            try
                            {
                                inputstream.close();
                            }
                            catch(IOException ioexception1)
                            {
                                ioexception1.printStackTrace();
                            }
                    }
                }
            }
            d1.B(c, node1);
        }

    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, C.A.D d, Object obj)
    {
    }

    protected B.B.A.B.C A(b b1)
    {
        C.A.M m = b1.B(B.C3);
        return m == null ? null : (B.B.A.B.C)m.D(b1);
    }

    private final int D;
}
