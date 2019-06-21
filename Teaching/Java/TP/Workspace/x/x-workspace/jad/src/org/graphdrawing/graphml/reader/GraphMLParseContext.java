// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.reader;

import java.util.*;
import org.graphdrawing.graphml.util.Lookup;
import org.w3c.dom.Node;

// Referenced classes of package org.graphdrawing.graphml.reader:
//            GraphMLParseErrorHandler

public abstract class GraphMLParseContext
    implements Lookup
{
    public static interface ResourceDecoder
    {

        public abstract Object decode(Node node, GraphMLParseContext graphmlparsecontext);
    }

    public static interface ResourceHandler
    {

        public abstract Object getResourceForID(String s, ResourceDecoder resourcedecoder, GraphMLParseContext graphmlparsecontext);

        public abstract void addResourceNode(Node node);
    }


    protected GraphMLParseContext()
    {
        properties = new HashMap();
        containers = new LinkedList();
        lookupMap = new HashMap();
    }

    public void pushGraphMLElement(Object obj)
    {
        containers.addLast(obj);
    }

    public void popGraphMLElement()
    {
        containers.removeLast();
    }

    public List getContainers()
    {
        return containers;
    }

    public Object getCurrentContainer()
    {
        return containers.getLast();
    }

    public Object getSecondToCurrentContainer()
    {
        return containers.listIterator(containers.size() - 1).previous();
    }

    public Object lookup(Class class1)
    {
        return lookupMap.get(class1);
    }

    public void setLookup(Class class1, Object obj)
    {
        lookupMap.put(class1, obj);
    }

    public abstract GraphMLParseErrorHandler getErrorHandler();

    public abstract String getAttributeValue(String s);

    public void setProperty(String s, Object obj)
    {
        properties.put(s, obj);
    }

    public Object getProperty(String s)
    {
        return properties.get(s);
    }

    private LinkedList containers;
    public static final String PROPERTY_YWORKS_EXT_NS = "org.graphdrawing.graphml.reader.dom.YFILES_EXT_NS";
    private HashMap lookupMap;
    private HashMap properties;
}
