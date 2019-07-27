// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.attr;

import org.graphdrawing.graphml.reader.dom.DOMGraphMLParseContext;
import org.graphdrawing.graphml.reader.dom.DOMInputHandler;
import org.w3c.dom.*;

// Referenced classes of package org.graphdrawing.graphml.attr:
//            AttributeFactory

public class AttributeInputHandler
    implements DOMInputHandler
{

    public AttributeInputHandler(String s, AttributeFactory attributefactory)
    {
        attributeFactory = null;
        scope = 0;
        name = s;
        attributeFactory = attributefactory;
    }

    public AttributeInputHandler(String s, AttributeFactory attributefactory, int i)
    {
        this(s, attributefactory);
        scope = i;
    }

    public void setAttributeFactory(AttributeFactory attributefactory)
    {
        attributeFactory = attributefactory;
    }

    public boolean acceptKey(NamedNodeMap namednodemap, int i)
    {
        Node node = namednodemap.getNamedItem("attr.name");
        Node node1 = namednodemap.getNamedItem("attr.type");
        if(scope != 0 && i != scope)
            return false;
        if(node == null || node1 == null)
            return false;
        String s = node.getNodeValue();
        if(!s.equals(name))
            return false;
        String s1 = node1.getNodeValue();
        byte byte0 = -1;
        if("double".equals(s1))
            byte0 = 4;
        else
        if("int".equals(s1))
            byte0 = 1;
        else
        if("long".equals(s1))
            byte0 = 2;
        else
        if("float".equals(s1))
            byte0 = 3;
        else
        if("string".equals(s1))
            byte0 = 5;
        else
        if("boolean".equals(s1))
            byte0 = 6;
        if(byte0 == -1)
        {
            throw new RuntimeException("Type: " + s1 + " is not supported !");
        } else
        {
            attributeFactory.defineAttribute(name, byte0, i);
            return true;
        }
    }

    public void parseData(DOMGraphMLParseContext domgraphmlparsecontext, boolean flag, Node node)
    {
        if(flag)
        {
            NodeList nodelist = node.getChildNodes();
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Node node1 = nodelist.item(i);
                if(node1.getNodeType() == 1 && "default".equals(node1.getLocalName()))
                    defaultValue = node1.getFirstChild().getNodeValue();
            }

        } else
        {
            if(node.getFirstChild() == null)
                return;
            String s = node.getFirstChild().getNodeValue();
            if(attributeFactory != null)
                attributeFactory.createAttribute(domgraphmlparsecontext, name, s);
        }
    }

    public void applyDefault(DOMGraphMLParseContext domgraphmlparsecontext)
    {
        attributeFactory.createAttribute(domgraphmlparsecontext, name, defaultValue);
    }

    protected AttributeFactory attributeFactory;
    protected String name;
    protected String defaultValue;
    protected int scope;
}
