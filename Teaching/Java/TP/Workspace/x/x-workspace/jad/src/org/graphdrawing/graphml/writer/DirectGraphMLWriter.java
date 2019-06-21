// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.graphdrawing.graphml.writer;

import java.io.IOException;
import java.util.*;

// Referenced classes of package org.graphdrawing.graphml.writer:
//            ResourceOutputHandler, XmlWriter, GraphMLWriteException, XMLAttributesProvider, 
//            OutputHandler, GraphElementProvider, GraphMLWriteContext, GraphMLWriteErrorHandler, 
//            IdProvider, XMLAttributesProviderAdapter

public class DirectGraphMLWriter
{
    private class ParseInfoXMLAttributeProvider extends XMLAttributesProviderAdapter
    {

        public void printGraphAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
        {
            GraphElementProvider graphelementprovider = (GraphElementProvider)graphmlwritecontext.lookup(DirectGraphMLWriter.class$org$graphdrawing$graphml$writer$GraphElementProvider != null ? DirectGraphMLWriter.class$org$graphdrawing$graphml$writer$GraphElementProvider : (DirectGraphMLWriter.class$org$graphdrawing$graphml$writer$GraphElementProvider = DirectGraphMLWriter._mthclass$("org.graphdrawing.graphml.writer.GraphElementProvider")));
            if(graphelementprovider != null && graphmlwritecontext.getContainers().size() == 1)
            {
                int i = graphelementprovider.getNodeCount();
                int j = graphelementprovider.getEdgeCount();
                xmlwriter.writeAttribute("parse.nodes", i);
                xmlwriter.writeAttribute("parse.edges", j);
                xmlwriter.writeAttribute("parse.order", "free");
            }
        }

        private ParseInfoXMLAttributeProvider()
        {
        }

    }

    private class SchemaLocationProvider extends XMLAttributesProviderAdapter
    {

        public void printGraphMLAttributes(GraphMLWriteContext graphmlwritecontext, XmlWriter xmlwriter)
        {
            String s;
            String s1;
            for(Iterator iterator = schemaLocations.entrySet().iterator(); iterator.hasNext(); xmlwriter.writeAttribute("xsi", "schemaLocation", "http://www.w3.org/2001/XMLSchema-instance", s1 + " " + s))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                s = (String)entry.getValue();
                s1 = (String)entry.getKey();
            }

        }

        private SchemaLocationProvider()
        {
        }

    }

    private class DefaultIdProvider
        implements IdProvider
    {

        public String getGraphId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            return graphIdStack.size() != 0 ? graphIdStack.getLast().toString() : "G";
        }

        public String getNodeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            String s = (String)nodeIds.get(obj);
            if(s == null)
            {
                String s1 = graphIdStack.size() != 0 ? graphIdStack.getLast().toString() : "G";
                String s2 = graphIdStack.size() != 0 ? s1.toString() + ":" : "";
                Integer integer = (Integer)maxNodeIds.get(s1);
                if(integer == null)
                {
                    s = s2 + "n" + 0;
                    integer = new Integer(1);
                } else
                {
                    s = s2 + "n" + integer;
                    integer = new Integer(integer.intValue() + 1);
                }
                maxNodeIds.put(s1, integer);
                nodeIds.put(obj, s);
            }
            return s;
        }

        public String getEdgeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            String s = (String)edgeIds.get(obj);
            if(s == null)
            {
                String s1 = graphIdStack.size() != 0 ? graphIdStack.getLast().toString() : "G";
                String s2 = graphIdStack.size() != 0 ? s1.toString() + ":" : "";
                Integer integer = (Integer)maxEdgeIds.get(s1);
                if(integer == null)
                {
                    s = s2 + "e" + 0;
                    integer = new Integer(1);
                } else
                {
                    s = s2 + "e" + integer;
                    integer = new Integer(integer.intValue() + 1);
                }
                maxEdgeIds.put(s1, integer);
                edgeIds.put(obj, s);
            }
            return s;
        }

        public String getPortId(Object obj, Object obj1, GraphMLWriteContext graphmlwritecontext)
        {
            String s = (String)portIds.get(obj);
            if(s == null)
            {
                Integer integer = (Integer)maxPortIds.get(obj1);
                if(integer == null)
                {
                    s = "p0";
                    integer = new Integer(1);
                } else
                {
                    s = "p" + integer;
                    integer = new Integer(integer.intValue() + 1);
                }
                maxPortIds.put(obj1, integer);
                portIds.put(obj, s);
            }
            return s;
        }

        public String getHyperedgeId(Object obj, GraphMLWriteContext graphmlwritecontext)
        {
            return null;
        }

        private HashMap nodeIds;
        private HashMap edgeIds;
        private HashMap portIds;
        private HashMap maxNodeIds;
        private HashMap maxEdgeIds;
        private HashMap maxPortIds;

        private DefaultIdProvider()
        {
            nodeIds = new HashMap();
            edgeIds = new HashMap();
            portIds = new HashMap();
            maxNodeIds = new HashMap();
            maxEdgeIds = new HashMap();
            maxPortIds = new HashMap();
        }

    }

    private static class GraphMLWriteErrorHandlerImpl
        implements GraphMLWriteErrorHandler
    {

        public void error(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext)
            throws GraphMLWriteException
        {
            throw new GraphMLWriteException(obj.toString(), exception);
        }

        public void fatal(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext)
            throws GraphMLWriteException
        {
            throw new GraphMLWriteException(obj.toString(), exception);
        }

        public void warning(Object obj, String s, Exception exception, GraphMLWriteContext graphmlwritecontext)
        {
        }

        private GraphMLWriteErrorHandlerImpl()
        {
        }

    }


    public void setWriteXMLSchemaEnabled(boolean flag)
    {
        writeXMLSchemaEnabled = flag;
    }

    public boolean isWriteXMLSchemaEnabled()
    {
        return writeXMLSchemaEnabled;
    }

    public IdProvider getIdProvider()
    {
        if(idProvider == null)
            idProvider = new DefaultIdProvider();
        return idProvider;
    }

    public void setIdProvider(IdProvider idprovider)
    {
        idProvider = idprovider;
    }

    public String getDtd()
    {
        return dtd;
    }

    public void setDtd(String s)
    {
        dtd = s;
    }

    public void setWriteErrorHandler(GraphMLWriteErrorHandler graphmlwriteerrorhandler)
    {
        customWriteErrorHandler = graphmlwriteerrorhandler;
    }

    public GraphMLWriteErrorHandler getWriteErrorHandler()
    {
        if(customWriteErrorHandler == null)
            customWriteErrorHandler = new GraphMLWriteErrorHandlerImpl();
        return customWriteErrorHandler;
    }

    public void addSchemaLocation(String s, String s1)
    {
        schemaLocations.put(s, s1);
    }

    public void addNamespace(String s, String s1)
    {
        namespaces.put(s, s1);
    }

    public String getGraphmlCoreNS()
    {
        return graphmlCoreNS;
    }

    public void setGraphmlCoreNS(String s)
    {
        graphmlCoreNS = s;
    }

    public DirectGraphMLWriter()
    {
        writeXMLSchemaEnabled = true;
        dtd = null;
        customWriteErrorHandler = new GraphMLWriteErrorHandlerImpl();
        schemaLocations = new HashMap();
        graphmlCoreNS = "http://graphml.graphdrawing.org/xmlns/graphml";
        graphElementProviders = new ArrayList();
        nodeOutputHandlers = new ArrayList();
        edgeOutputHandlers = new ArrayList();
        graphOutputHandlers = new ArrayList();
        hyperEdgeOutputHandlers = new ArrayList();
        scopeOutputHandler = new ArrayList[8];
        xmlAttributeProviders = new ArrayList();
        resourceOutputHandler = new ResourceOutputHandler();
        schemaProvider = new SchemaLocationProvider();
        parseInfoProvider = new ParseInfoXMLAttributeProvider();
        contextLookupMap = new HashMap();
        contextProperties = new HashMap();
        graphIdStack = new LinkedList();
        for(int i = 0; i < scopeOutputHandler.length; i++)
            scopeOutputHandler[i] = new ArrayList();

        namespaces = new HashMap();
    }

    public void setGraphElementProvider(GraphElementProvider graphelementprovider)
    {
        clearGraphElementProviders();
        graphElementProviders.add(graphelementprovider);
    }

    public void clearGraphElementProviders()
    {
        graphElementProviders.clear();
    }

    public void addGraphElementProvider(GraphElementProvider graphelementprovider)
    {
        graphElementProviders.add(graphelementprovider);
    }

    protected String getHandlerIds(OutputHandler outputhandler)
    {
        return ids.get(outputhandler).toString();
    }

    public void addNodeOutputHandler(OutputHandler outputhandler)
    {
        addOutputHandler(outputhandler, 1);
    }

    public void addEdgeOutputHandler(OutputHandler outputhandler)
    {
        addOutputHandler(outputhandler, 2);
    }

    public void addGraphOutputHandler(OutputHandler outputhandler)
    {
        addOutputHandler(outputhandler, 3);
    }

    public void addOutputHandler(OutputHandler outputhandler, int i)
    {
        if(i == 2 || i == 0)
            edgeOutputHandlers.add(outputhandler);
        if(i == 1 || i == 0)
            nodeOutputHandlers.add(outputhandler);
        if(i == 3 || i == 0)
            graphOutputHandlers.add(outputhandler);
        if(i == 4 || i == 0)
            hyperEdgeOutputHandlers.add(outputhandler);
        scopeOutputHandler[i].add(outputhandler);
    }

    public void addXMLAttributeProvider(XMLAttributesProvider xmlattributesprovider)
    {
        xmlAttributeProviders.add(xmlattributesprovider);
    }

    public void write(XmlWriter xmlwriter)
        throws IOException
    {
        if(xmlwriter == null)
            return;
        if(writeXMLSchemaEnabled)
            xmlAttributeProviders.add(schemaProvider);
        xmlAttributeProviders.add(parseInfoProvider);
        GraphMLWriteContext graphmlwritecontext = createGraphMLWriteContext();
        String s;
        String s1;
        for(Iterator iterator = namespaces.keySet().iterator(); iterator.hasNext(); xmlwriter.addNamespace(s, s1))
        {
            s = iterator.next().toString();
            s1 = (String)namespaces.get(s);
        }

        writeData(xmlwriter, graphmlwritecontext);
        xmlAttributeProviders.remove(parseInfoProvider);
        if(writeXMLSchemaEnabled)
            xmlAttributeProviders.remove(schemaProvider);
    }

    protected void writeData(XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException
    {
        xmlwriter.setDTD(dtd);
        xmlwriter.writeStartDocument(null, "graphml", graphmlCoreNS);
        writeRootElement(xmlwriter, graphmlwritecontext);
        xmlwriter.writeEndDocument();
    }

    protected void writeRootElement(XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException
    {
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); ((XMLAttributesProvider)iterator.next()).printGraphMLAttributes(graphmlwritecontext, xmlwriter));
        writeKeyDefinitions(xmlwriter, graphmlwritecontext);
        OutputHandler outputhandler;
        for(Iterator iterator1 = scopeOutputHandler[7].iterator(); iterator1.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator1.next();

        GraphElementProvider graphelementprovider;
        for(Iterator iterator2 = graphElementProviders.iterator(); iterator2.hasNext(); writeGraphElement(graphelementprovider, xmlwriter, true, graphmlwritecontext))
        {
            graphelementprovider = (GraphElementProvider)iterator2.next();
            graphmlwritecontext.setLookup(org.graphdrawing.graphml.writer.GraphElementProvider.class, graphelementprovider);
        }

        if(((Boolean)graphmlwritecontext.getProperty("useEmbeddedResources")).booleanValue())
            writeDataElement(resourceOutputHandler, xmlwriter, graphmlwritecontext);
    }

    protected void writeKeyDefinitions(XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException
    {
        int i = 0;
        ids = new HashMap();
        for(int j = 0; j < scopeOutputHandler.length; j++)
        {
            for(Iterator iterator = scopeOutputHandler[j].iterator(); iterator.hasNext();)
            {
                OutputHandler outputhandler = (OutputHandler)iterator.next();
                ids.put(outputhandler, "d" + i);
                writeKeyDefinition(outputhandler, xmlwriter, j, graphmlwritecontext);
                i++;
            }

        }

        if(((Boolean)graphmlwritecontext.getProperty("useEmbeddedResources")).booleanValue())
        {
            ids.put(resourceOutputHandler, "d" + i);
            writeKeyDefinition(resourceOutputHandler, xmlwriter, 7, graphmlwritecontext);
        }
    }

    protected void writeKeyDefinition(OutputHandler outputhandler, XmlWriter xmlwriter, int i, GraphMLWriteContext graphmlwritecontext)
        throws GraphMLWriteException
    {
        String s = getHandlerIds(outputhandler);
        String s1 = null;
        switch(i)
        {
        case 0: // '\0'
            s1 = "all";
            break;

        case 7: // '\007'
            s1 = "graphml";
            break;

        case 3: // '\003'
            s1 = "graph";
            break;

        case 1: // '\001'
            s1 = "node";
            break;

        case 2: // '\002'
            s1 = "edge";
            break;

        case 4: // '\004'
            s1 = "hyperedge";
            break;

        case 5: // '\005'
            s1 = "endpoint";
            break;

        case 6: // '\006'
            s1 = "port";
            break;

        default:
            getWriteErrorHandler().error("org.graphdrawing.graphml.writer.DirectGraphMLWriter#writeKeyDefinition", "Undefined scope: " + i, null, graphmlwritecontext);
            break;
        }
        xmlwriter.writeStartElement("key", graphmlCoreNS);
        xmlwriter.writeAttribute("id", s);
        xmlwriter.writeAttribute("for", s1);
        outputhandler.printKeyAttributes(graphmlwritecontext, xmlwriter);
        xmlwriter.writeEndElement();
    }

    protected void writeDataElement(OutputHandler outputhandler, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        String s = getHandlerIds(outputhandler);
        xmlwriter.writeStartElement("data", graphmlCoreNS);
        xmlwriter.writeAttribute("key", s);
        outputhandler.printDataAttributes(graphmlwritecontext, xmlwriter);
        outputhandler.printDataOutput(graphmlwritecontext, xmlwriter);
        xmlwriter.writeEndElement();
    }

    protected void writeGraphElement(GraphElementProvider graphelementprovider, XmlWriter xmlwriter, boolean flag, GraphMLWriteContext graphmlwritecontext)
    {
        xmlwriter.writeStartElement("graph", graphmlCoreNS);
        Object obj = graphelementprovider.getGraphObject();
        graphmlwritecontext.pushGraphMLElement(obj);
        xmlwriter.writeAttribute("edgedefault", graphelementprovider.isDefaultDirected() ? "directed" : "undirected");
        xmlwriter.writeAttribute("id", getIdProvider().getGraphId(obj, graphmlwritecontext));
        XMLAttributesProvider xmlattributesprovider;
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); xmlattributesprovider.printGraphAttributes(graphmlwritecontext, xmlwriter))
            xmlattributesprovider = (XMLAttributesProvider)iterator.next();

        OutputHandler outputhandler;
        for(Iterator iterator1 = graphOutputHandlers.iterator(); iterator1.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator1.next();

        Object obj1;
        for(Iterator iterator2 = graphelementprovider.getNodeObjects(); iterator2.hasNext(); writeNode(graphelementprovider, obj1, xmlwriter, graphmlwritecontext))
            obj1 = iterator2.next();

        Object obj2;
        for(Iterator iterator3 = graphelementprovider.getEdgeObjects(); iterator3.hasNext(); writeEdge(graphelementprovider, obj2, xmlwriter, graphmlwritecontext))
            obj2 = iterator3.next();

        Object obj3;
        for(Iterator iterator4 = graphelementprovider.getHyperEdgeObjects(); iterator4.hasNext(); writeHyperEdge(graphelementprovider, obj3, xmlwriter, graphmlwritecontext))
            obj3 = iterator4.next();

        xmlwriter.writeEndElement();
        graphmlwritecontext.popGraphMLElement();
    }

    protected void writeEdge(GraphElementProvider graphelementprovider, Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        Object obj1 = graphelementprovider.getSourceNode(obj);
        Object obj2 = graphelementprovider.getTargetNode(obj);
        String s = getIdProvider().getNodeId(obj1, graphmlwritecontext);
        String s1 = getIdProvider().getNodeId(obj2, graphmlwritecontext);
        Object obj3 = graphelementprovider.getSourcePort(obj);
        Object obj4 = graphelementprovider.getTargetPort(obj);
        xmlwriter.writeStartElement("edge", graphmlCoreNS);
        String s2 = getIdProvider().getEdgeId(obj, graphmlwritecontext);
        xmlwriter.writeAttribute("id", s2);
        xmlwriter.writeAttribute("source", s);
        xmlwriter.writeAttribute("target", s1);
        if(obj3 != null)
        {
            String s3 = getIdProvider().getPortId(obj3, obj1, graphmlwritecontext);
            xmlwriter.writeAttribute("sourceport", s3);
        }
        if(obj4 != null)
        {
            String s4 = getIdProvider().getPortId(obj4, obj2, graphmlwritecontext);
            xmlwriter.writeAttribute("targetport", s4);
        }
        if(graphelementprovider.isDefaultDirected() != graphelementprovider.isDirected(obj))
            xmlwriter.writeAttribute("directed", String.valueOf(graphelementprovider.isDirected(obj)));
        graphmlwritecontext.pushGraphMLElement(obj);
        XMLAttributesProvider xmlattributesprovider;
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); xmlattributesprovider.printEdgeAttributes(graphmlwritecontext, xmlwriter))
            xmlattributesprovider = (XMLAttributesProvider)iterator.next();

        OutputHandler outputhandler;
        for(Iterator iterator1 = edgeOutputHandlers.iterator(); iterator1.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator1.next();

        xmlwriter.writeEndElement();
        graphmlwritecontext.popGraphMLElement();
    }

    protected void writeNode(GraphElementProvider graphelementprovider, Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        String s = getIdProvider().getNodeId(obj, graphmlwritecontext);
        xmlwriter.writeStartElement("node", graphmlCoreNS);
        xmlwriter.writeAttribute("id", s);
        graphmlwritecontext.pushGraphMLElement(obj);
        XMLAttributesProvider xmlattributesprovider;
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); xmlattributesprovider.printNodeAttributes(graphmlwritecontext, xmlwriter))
            xmlattributesprovider = (XMLAttributesProvider)iterator.next();

        OutputHandler outputhandler;
        for(Iterator iterator1 = nodeOutputHandlers.iterator(); iterator1.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator1.next();

        for(Iterator iterator2 = graphelementprovider.getPortObjects(obj); iterator2.hasNext(); writePort(graphelementprovider, iterator2.next(), xmlwriter, graphmlwritecontext));
        GraphElementProvider graphelementprovider1 = graphelementprovider.getNodeSubgraph(obj);
        if(graphelementprovider1 != null)
        {
            graphIdStack.addLast(s + ":");
            writeGraphElement(graphelementprovider1, xmlwriter, false, graphmlwritecontext);
            graphIdStack.removeLast();
        }
        xmlwriter.writeEndElement();
        graphmlwritecontext.popGraphMLElement();
    }

    protected void writePort(GraphElementProvider graphelementprovider, Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        String s = getIdProvider().getPortId(obj, graphmlwritecontext.getCurrentContainer(), graphmlwritecontext);
        xmlwriter.writeStartElement("port", graphmlCoreNS);
        xmlwriter.writeAttribute("name", s);
        graphmlwritecontext.pushGraphMLElement(obj);
        XMLAttributesProvider xmlattributesprovider;
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); xmlattributesprovider.printPortAttributes(graphmlwritecontext, xmlwriter))
            xmlattributesprovider = (XMLAttributesProvider)iterator.next();

        OutputHandler outputhandler;
        for(Iterator iterator1 = scopeOutputHandler[6].iterator(); iterator1.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator1.next();

        xmlwriter.writeEndElement();
        graphmlwritecontext.popGraphMLElement();
    }

    protected void writeHyperEdge(GraphElementProvider graphelementprovider, Object obj, XmlWriter xmlwriter, GraphMLWriteContext graphmlwritecontext)
    {
        xmlwriter.writeStartElement("hyperedge", graphmlCoreNS);
        String s = getIdProvider().getHyperedgeId(obj, graphmlwritecontext);
        xmlwriter.writeAttribute("id", s);
        graphmlwritecontext.pushGraphMLElement(obj);
        XMLAttributesProvider xmlattributesprovider;
        for(Iterator iterator = xmlAttributeProviders.iterator(); iterator.hasNext(); xmlattributesprovider.printHyperEdgeAttributes(graphmlwritecontext, xmlwriter))
            xmlattributesprovider = (XMLAttributesProvider)iterator.next();

        String s1;
        for(Iterator iterator1 = graphelementprovider.getEndpointObjects(obj); iterator1.hasNext(); xmlwriter.writeStartElement("endpoint", graphmlCoreNS).writeAttribute("node", s1).writeEndElement())
        {
            Object obj1 = iterator1.next();
            s1 = getIdProvider().getNodeId(obj1, graphmlwritecontext);
        }

        OutputHandler outputhandler;
        for(Iterator iterator2 = hyperEdgeOutputHandlers.iterator(); iterator2.hasNext(); writeDataElement(outputhandler, xmlwriter, graphmlwritecontext))
            outputhandler = (OutputHandler)iterator2.next();

        xmlwriter.writeEndElement();
        graphmlwritecontext.popGraphMLElement();
    }

    protected GraphMLWriteContext createGraphMLWriteContext()
    {
        GraphMLWriteContext graphmlwritecontext = new GraphMLWriteContext(this);
        if(contextLookupMap != null)
        {
            java.util.Map.Entry entry;
            for(Iterator iterator = contextLookupMap.entrySet().iterator(); iterator.hasNext(); graphmlwritecontext.setLookup((Class)entry.getKey(), entry.getValue()))
                entry = (java.util.Map.Entry)iterator.next();

        }
        if(contextProperties != null)
        {
            java.util.Map.Entry entry1;
            for(Iterator iterator1 = contextProperties.entrySet().iterator(); iterator1.hasNext(); graphmlwritecontext.setProperty((String)entry1.getKey(), entry1.getValue()))
                entry1 = (java.util.Map.Entry)iterator1.next();

        }
        return graphmlwritecontext;
    }

    public void setContextLookup(Class class1, Object obj)
    {
        contextLookupMap.put(class1, obj);
    }

    public void setContextProperty(String s, Object obj)
    {
        contextProperties.put(s, obj);
    }

    private boolean writeXMLSchemaEnabled;
    private HashMap namespaces;
    private IdProvider idProvider;
    private String dtd;
    private GraphMLWriteErrorHandler customWriteErrorHandler;
    private HashMap schemaLocations;
    private String graphmlCoreNS;
    private List graphElementProviders;
    private Map ids;
    private List nodeOutputHandlers;
    private List edgeOutputHandlers;
    private List graphOutputHandlers;
    private List hyperEdgeOutputHandlers;
    private List scopeOutputHandler[];
    private List xmlAttributeProviders;
    private OutputHandler resourceOutputHandler;
    private XMLAttributesProvider schemaProvider;
    private XMLAttributesProvider parseInfoProvider;
    private Map contextLookupMap;
    private Map contextProperties;
    private LinkedList graphIdStack;


}
