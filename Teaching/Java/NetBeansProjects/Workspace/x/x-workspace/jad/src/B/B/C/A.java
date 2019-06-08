// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.C;

import B.D.D.b;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class A extends b
{

    public A()
    {
    }

    public String D()
    {
        return "http://www.yworks.com/xml/graphml";
    }

    public String C()
    {
        return "y";
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
}
