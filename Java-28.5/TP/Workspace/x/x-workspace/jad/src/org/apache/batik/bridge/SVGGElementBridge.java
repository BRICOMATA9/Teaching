// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractGraphicsNodeBridge, CSSUtilities, BridgeContext, GVTBuilder, 
//            Bridge

public class SVGGElementBridge extends AbstractGraphicsNodeBridge
{

    public SVGGElementBridge()
    {
    }

    public String getLocalName()
    {
        return "g";
    }

    public Bridge getInstance()
    {
        return new SVGGElementBridge();
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)super.createGraphicsNode(bridgecontext, element);
        if(compositegraphicsnode == null)
            return null;
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        if(renderinghints != null)
            compositegraphicsnode.setRenderingHints(renderinghints);
        java.awt.geom.Rectangle2D rectangle2d = CSSUtilities.convertEnableBackground(element);
        if(rectangle2d != null)
            compositegraphicsnode.setBackgroundEnable(rectangle2d);
        return compositegraphicsnode;
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return new CompositeGraphicsNode();
    }

    public boolean isComposite()
    {
        return true;
    }

    public void handleDOMNodeInsertedEvent(MutationEvent mutationevent)
    {
        if(mutationevent.getTarget() instanceof Element)
            handleElementAdded((CompositeGraphicsNode)node, e, (Element)mutationevent.getTarget());
    }

    public void handleElementAdded(CompositeGraphicsNode compositegraphicsnode, Node node, Element element)
    {
        GVTBuilder gvtbuilder = ctx.getGVTBuilder();
        GraphicsNode graphicsnode = gvtbuilder.build(ctx, element);
        if(graphicsnode == null)
            return;
        int i = -1;
        for(Node node1 = element.getPreviousSibling(); node1 != null; node1 = node1.getPreviousSibling())
        {
            if(node1.getNodeType() != 1)
                continue;
            Element element1 = (Element)node1;
            Object obj;
            for(obj = ctx.getGraphicsNode(element1); obj != null && ((GraphicsNode) (obj)).getParent() != compositegraphicsnode; obj = ((GraphicsNode) (obj)).getParent());
            if(obj == null)
                continue;
            i = compositegraphicsnode.indexOf(obj);
            if(i != -1)
                break;
        }

        i++;
        compositegraphicsnode.add(i, graphicsnode);
    }
}
