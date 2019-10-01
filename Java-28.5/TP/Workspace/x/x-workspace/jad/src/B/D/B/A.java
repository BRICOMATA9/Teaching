// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.D.B;

import B.D.A.C;
import C.A.D;
import C.D.Y;
import C.D.g;
import C.J.b;
import java.util.Properties;
import org.graphdrawing.graphml.reader.GraphMLParseErrorHandler;
import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.Precedence;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class A extends C
    implements Precedence
{

    public A()
    {
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        if(i != 3)
            return false;
        Node node = namednodemap.getNamedItem("yfiles.type");
        if(node == null)
            return false;
        return "postprocessors".equals(node.getNodeValue());
    }

    public int getPrecedence()
    {
        return 1;
    }

    String B(Node node, String s)
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

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj, boolean flag, Node node)
    {
        if(flag)
            return;
        if(!(d instanceof b))
            return;
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
        {
            if(!"Postprocessors".equals(node1.getLocalName()))
                continue;
            for(Node node2 = node1.getFirstChild(); node2 != null; node2 = node2.getNextSibling())
            {
                if(!"Processor".equals(node2.getLocalName()))
                    continue;
                String s = B(node2, "class");
                if(s == null)
                {
                    domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "<y:Processor>: attribute \"class\" missing", new RuntimeException("<y:Processor>: attribute \"class\" missing"), domgraphmlparsecontext);
                    return;
                }
                C.B.A a = null;
                try
                {
                    a = (C.B.A)Class.forName(s).newInstance();
                }
                catch(Exception exception)
                {
                    domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "Exception occured: " + exception.getLocalizedMessage(), exception, domgraphmlparsecontext);
                    return;
                }
                catch(NoClassDefFoundError noclassdeffounderror)
                {
                    domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "No Class found occured: " + noclassdeffounderror.getLocalizedMessage(), new RuntimeException(noclassdeffounderror.getLocalizedMessage()), domgraphmlparsecontext);
                    return;
                }
                Y y = a.C();
                if(y == null)
                    continue;
                Properties properties = new Properties();
                String s1 = y.N() + '.';
                for(Node node3 = node2.getFirstChild(); node3 != null; node3 = node3.getNextSibling())
                {
                    if(!"Option".equals(node3.getLocalName()))
                        continue;
                    String s2 = B(node3, "name");
                    String s3 = B(node3, "value");
                    if(s2 == null)
                    {
                        domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "<y:Option>: attribute \"name\" missing", new RuntimeException("<y:Option>: attribute \"name\" missing"), domgraphmlparsecontext);
                        return;
                    }
                    if(s3 == null)
                    {
                        domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "<y:Option>: attribute \"value\" missing", new RuntimeException("<y:Option>: attribute \"value\" missing"), domgraphmlparsecontext);
                        return;
                    }
                    properties.setProperty(s1 + s2, s3);
                }

                y.A(new g(properties));
                try
                {
                    a.A((b)d);
                }
                catch(Exception exception1)
                {
                    domgraphmlparsecontext.getErrorHandler().warning("yext.graphml.processor.PostprocessorInputHandler#parseData", "Exception occured: " + exception1.getLocalizedMessage(), exception1, domgraphmlparsecontext);
                }
            }

        }

    }

    protected void A(DOMGraphMLParseContext domgraphmlparsecontext, D d, Object obj)
    {
    }
}
