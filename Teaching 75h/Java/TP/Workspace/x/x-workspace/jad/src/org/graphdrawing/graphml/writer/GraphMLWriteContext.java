// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.util.*;
import org.graphdrawing.graphml.util.Lookup;

// Referenced classes of package org.graphdrawing.graphml.writer:
//            DirectGraphMLWriter, GraphMLWriteErrorHandler, XmlWriter

public class GraphMLWriteContext
    implements Lookup
{
    public static interface ResourceDescriptor
    {

        public abstract String getClassName();

        public abstract String getId();

        public abstract ResourceEncoder getEncoder();

        public abstract void addExtraAttribute(String s, String s1);

        public abstract HashMap getExtraAttributes();
    }

    static interface ResourceHandlerAccessor
    {

        public abstract HashMap getRegisteredResources();

        public abstract ResourceDescriptor getDescriptor(Object obj);
    }

    public static interface ResourceHandler
    {

        public abstract ResourceDescriptor registerResource(Object obj, ResourceEncoder resourceencoder);

        public abstract boolean isRegistered(Object obj);
    }

    public static interface ResourceEncoder
    {

        public abstract void encode(Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext);
    }

    private static class ResourceHandlerImpl
        implements ResourceHandler, ResourceHandlerAccessor
    {
        private static class ResourceDescriptorImpl
            implements ResourceDescriptor
        {

            public String getClassName()
            {
                return className;
            }

            public String getId()
            {
                return id;
            }

            public ResourceEncoder getEncoder()
            {
                return encoder;
            }

            public void addExtraAttribute(String s, String s1)
            {
                if(attributes == null)
                    attributes = new HashMap();
                attributes.put(s, s1);
            }

            public HashMap getExtraAttributes()
            {
                return attributes;
            }

            private String id;
            private ResourceEncoder encoder;
            private String className;
            private HashMap attributes;

            public ResourceDescriptorImpl(String s, String s1, ResourceEncoder resourceencoder)
            {
                id = s;
                encoder = resourceencoder;
                className = s1;
            }
        }


        public ResourceDescriptor registerResource(Object obj, ResourceEncoder resourceencoder)
        {
            if(isRegistered(obj))
            {
                return (ResourceDescriptor)resource2desc.get(obj);
            } else
            {
                maxId++;
                String s = String.valueOf(maxId);
                ResourceDescriptorImpl resourcedescriptorimpl = new ResourceDescriptorImpl(s, obj.getClass().getName(), resourceencoder);
                resource2desc.put(obj, resourcedescriptorimpl);
                id2descriptor.put(s, obj);
                return resourcedescriptorimpl;
            }
        }

        public HashMap getRegisteredResources()
        {
            return id2descriptor;
        }

        public boolean isRegistered(Object obj)
        {
            return resource2desc.containsKey(obj);
        }

        public ResourceDescriptor getDescriptor(Object obj)
        {
            return (ResourceDescriptor)resource2desc.get(id2descriptor.get(obj));
        }

        private int maxId;
        private HashMap resource2desc;
        private HashMap id2descriptor;

        private ResourceHandlerImpl()
        {
            maxId = 0;
            resource2desc = new HashMap();
            id2descriptor = new HashMap();
        }

    }


    public GraphMLWriteContext(DirectGraphMLWriter directgraphmlwriter)
    {
        preferEmbedded = true;
        properties = new HashMap();
        containers = new LinkedList();
        ResourceHandlerImpl resourcehandlerimpl = new ResourceHandlerImpl();
        lookupMap = new HashMap();
        lookupMap.put(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandler.class, resourcehandlerimpl);
        lookupMap.put(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandlerAccessor.class, resourcehandlerimpl);
        lookupMap.put(org.graphdrawing.graphml.writer.DirectGraphMLWriter.class, directgraphmlwriter);
        setProperty("useEmbeddedResources", Boolean.FALSE);
    }

    public void pushGraphMLElement(Object obj)
    {
        containers.addLast(obj);
    }

    public void popGraphMLElement()
    {
        containers.removeLast();
    }

    public Object getCurrentContainer()
    {
        return containers.getLast();
    }

    public Object getSecondToCurrentContainer()
    {
        return containers.listIterator(containers.size() - 1).previous();
    }

    public List getContainers()
    {
        return containers;
    }

    public Object lookup(Class class1)
    {
        if(class1 == (org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandler.class) && !preferEmbedded)
            return null;
        else
            return lookupMap.get(class1);
    }

    public void setLookup(Class class1, Object obj)
    {
        lookupMap.put(class1, obj);
    }

    public GraphMLWriteErrorHandler getErrorHandler()
    {
        DirectGraphMLWriter directgraphmlwriter = (DirectGraphMLWriter)lookup(org.graphdrawing.graphml.writer.DirectGraphMLWriter.class);
        if(directgraphmlwriter != null)
            return directgraphmlwriter.getWriteErrorHandler();
        else
            return null;
    }

    public void setProperty(String s, Object obj)
    {
        if("useEmbeddedResources".equals(s))
            preferEmbedded = ((Boolean)obj).booleanValue();
        properties.put(s, obj);
    }

    public Object getProperty(String s)
    {
        return properties.get(s);
    }

    private LinkedList containers;
    private HashMap lookupMap;
    private boolean preferEmbedded;
    private HashMap properties;
}
