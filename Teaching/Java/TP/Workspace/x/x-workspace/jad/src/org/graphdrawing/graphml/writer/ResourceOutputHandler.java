// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.util.*;

// Referenced classes of package org.graphdrawing.graphml.writer:
//            OutputHandler, GraphMLWriteContext, XmlWriter

class ResourceOutputHandler
    implements OutputHandler
{

    ResourceOutputHandler()
    {
    }

    private void writeResources(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        GraphMLWriteContext.ResourceHandler resourcehandler = (GraphMLWriteContext.ResourceHandler)graphmlwritecontext.lookup(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandler.class);
        GraphMLWriteContext.ResourceHandlerAccessor resourcehandleraccessor = (GraphMLWriteContext.ResourceHandlerAccessor)graphmlwritecontext.lookup(org.graphdrawing.graphml.writer.GraphMLWriteContext$ResourceHandlerAccessor.class);
        if(resourcehandler != null && resourcehandleraccessor != null)
        {
            HashMap hashmap = resourcehandleraccessor.getRegisteredResources();
            ArrayList arraylist = new ArrayList(hashmap.keySet());
            Collections.sort(arraylist);
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); xmlwriter.writeEndElement())
            {
                Object obj = iterator.next();
                GraphMLWriteContext.ResourceDescriptor resourcedescriptor = resourcehandleraccessor.getDescriptor(obj);
                xmlwriter.writeStartElement("Resource", "http://www.yworks.com/xml/graphml");
                xmlwriter.writeAttribute("id", resourcedescriptor.getId()).writeAttribute("type", resourcedescriptor.getClassName());
                HashMap hashmap1 = resourcedescriptor.getExtraAttributes();
                if(hashmap1 != null)
                {
                    java.util.Map.Entry entry;
                    for(Iterator iterator1 = hashmap1.entrySet().iterator(); iterator1.hasNext(); xmlwriter.writeAttribute((String)entry.getKey(), (String)entry.getValue()))
                        entry = (java.util.Map.Entry)iterator1.next();

                }
                resourcedescriptor.getEncoder().encode(hashmap.get(obj), xmlwriter, graphmlwritecontext);
            }

        }
    }

    public void printKeyAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeAttribute("yfiles.type", "resources");
    }

    public void printKeyOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printDataAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
    }

    public void printDataOutput(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
    {
        xmlwriter.writeStartElement("Resources", "http://www.yworks.com/xml/graphml");
        writeResources(graphmlwritecontext, xmlwriter);
        xmlwriter.writeEndElement();
    }
}
