// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGTests;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, GraphicsNodeBridge, BridgeContext, SVGUtilities, 
//            GVTBuilder, CSSUtilities, Bridge

public class SVGSwitchElementBridge extends AbstractSVGBridge
    implements GraphicsNodeBridge
{

    public SVGSwitchElementBridge()
    {
    }

    public String getLocalName()
    {
        return "switch";
    }

    public Bridge getInstance()
    {
        return this;
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        GraphicsNode graphicsnode = null;
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            if(!(node instanceof SVGTests) || !SVGUtilities.matchUserAgent(element1, bridgecontext.getUserAgent()))
                continue;
            graphicsnode = gvtbuilder.build(bridgecontext, element1);
            break;
        }

        if(graphicsnode == null)
            return null;
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        compositegraphicsnode.add(graphicsnode);
        String s = element.getAttributeNS(null, "transform");
        if(s.length() != 0)
            compositegraphicsnode.setTransform(SVGUtilities.convertTransform(element, "transform", s));
        return compositegraphicsnode;
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        if(bridgecontext.isInteractive())
            bridgecontext.bind(element, graphicsnode);
    }

    public boolean getDisplay(Element element)
    {
        return CSSUtilities.convertDisplay(element);
    }

    public boolean isComposite()
    {
        return false;
    }
}
