// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.List;
import org.apache.batik.gvt.*;
import org.apache.batik.util.HaltingThread;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeException, BridgeContext, GraphicsNodeBridge, DocumentLoader, 
//            BridgeEventSupport, GenericBridge, InterruptedBridgeException, CSSUtilities

public class GVTBuilder
    implements SVGConstants
{

    public GVTBuilder()
    {
    }

    public GraphicsNode build(BridgeContext bridgecontext, Document document)
    {
        RootGraphicsNode rootgraphicsnode;
        Element element;
        bridgecontext.setDocument(document);
        bridgecontext.initializeDocument(document);
        bridgecontext.setGVTBuilder(this);
        rootgraphicsnode = new RootGraphicsNode();
        element = document.getDocumentElement();
        Object obj = null;
        Bridge bridge = bridgecontext.getBridge(element);
        if(bridge == null || !(bridge instanceof GraphicsNodeBridge))
            return null;
        GraphicsNode graphicsnode;
        GraphicsNodeBridge graphicsnodebridge;
        graphicsnodebridge = (GraphicsNodeBridge)bridge;
        graphicsnode = graphicsnodebridge.createGraphicsNode(bridgecontext, element);
        if(graphicsnode == null)
            return null;
        try
        {
            rootgraphicsnode.getChildren().add(graphicsnode);
            buildComposite(bridgecontext, element, (CompositeGraphicsNode)graphicsnode);
            graphicsnodebridge.buildGraphicsNode(bridgecontext, element, graphicsnode);
        }
        catch(BridgeException bridgeexception)
        {
            bridgeexception.setGraphicsNode(rootgraphicsnode);
            Element element1 = bridgeexception.getElement();
            bridgeexception.setLineNumber(bridgecontext.getDocumentLoader().getLineNumber(element1));
            throw bridgeexception;
        }
        if(bridgecontext.isInteractive())
        {
            bridgecontext.addUIEventListeners(document);
            BridgeEventSupport.addGVTListener(bridgecontext, document);
        }
        if(bridgecontext.isDynamic())
            bridgecontext.addDOMListeners();
        return rootgraphicsnode;
    }

    public GraphicsNode build(BridgeContext bridgecontext, Element element)
    {
        Bridge bridge = bridgecontext.getBridge(element);
        if(bridge instanceof GenericBridge)
        {
            ((GenericBridge)bridge).handleElement(bridgecontext, element);
            return null;
        }
        if(bridge == null || !(bridge instanceof GraphicsNodeBridge))
            return null;
        GraphicsNodeBridge graphicsnodebridge = (GraphicsNodeBridge)bridge;
        if(!graphicsnodebridge.getDisplay(element))
            return null;
        GraphicsNode graphicsnode = graphicsnodebridge.createGraphicsNode(bridgecontext, element);
        if(graphicsnode != null)
        {
            if(graphicsnodebridge.isComposite())
                buildComposite(bridgecontext, element, (CompositeGraphicsNode)graphicsnode);
            else
                handleGenericBridges(bridgecontext, element);
            graphicsnodebridge.buildGraphicsNode(bridgecontext, element, graphicsnode);
        }
        if(!bridgecontext.isDynamic());
        return graphicsnode;
    }

    protected void buildComposite(BridgeContext bridgecontext, Element element, CompositeGraphicsNode compositegraphicsnode)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1)
                buildGraphicsNode(bridgecontext, (Element)node, compositegraphicsnode);

    }

    protected void buildGraphicsNode(BridgeContext bridgecontext, Element element, CompositeGraphicsNode compositegraphicsnode)
    {
        if(HaltingThread.hasBeenHalted())
            throw new InterruptedBridgeException();
        Bridge bridge = bridgecontext.getBridge(element);
        if(bridge instanceof GenericBridge)
        {
            ((GenericBridge)bridge).handleElement(bridgecontext, element);
            return;
        }
        if(bridge == null || !(bridge instanceof GraphicsNodeBridge))
            return;
        if(!CSSUtilities.convertDisplay(element))
            return;
        GraphicsNodeBridge graphicsnodebridge = (GraphicsNodeBridge)bridge;
        try
        {
            GraphicsNode graphicsnode = graphicsnodebridge.createGraphicsNode(bridgecontext, element);
            if(graphicsnode != null)
            {
                compositegraphicsnode.getChildren().add(graphicsnode);
                if(graphicsnodebridge.isComposite())
                    buildComposite(bridgecontext, element, (CompositeGraphicsNode)graphicsnode);
                else
                    handleGenericBridges(bridgecontext, element);
                graphicsnodebridge.buildGraphicsNode(bridgecontext, element, graphicsnode);
            }
        }
        catch(BridgeException bridgeexception)
        {
            GraphicsNode graphicsnode1 = bridgeexception.getGraphicsNode();
            if(graphicsnode1 != null)
            {
                compositegraphicsnode.getChildren().add(graphicsnode1);
                graphicsnodebridge.buildGraphicsNode(bridgecontext, element, graphicsnode1);
                bridgeexception.setGraphicsNode(null);
            }
            throw bridgeexception;
        }
    }

    protected void handleGenericBridges(BridgeContext bridgecontext, Element element)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(!(node instanceof Element))
                continue;
            Element element1 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge instanceof GenericBridge)
                ((GenericBridge)bridge).handleElement(bridgecontext, element1);
        }

    }
}
