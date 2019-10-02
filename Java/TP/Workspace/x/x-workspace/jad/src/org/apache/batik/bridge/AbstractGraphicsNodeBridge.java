// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.lang.ref.SoftReference;
import org.apache.batik.css.engine.CSSEngineEvent;
import org.apache.batik.css.engine.SVGCSSEngine;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.svg.SVGContext;
import org.apache.batik.dom.svg.SVGOMElement;
import org.apache.batik.ext.awt.geom.SegmentList;
import org.apache.batik.gvt.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.MutationEvent;
import org.w3c.dom.svg.SVGFitToViewBox;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, BridgeUpdateHandler, GraphicsNodeBridge, ErrorConstants, 
//            BridgeContext, SVGUtilities, CSSUtilities, GenericBridge, 
//            UserAgent

public abstract class AbstractGraphicsNodeBridge extends AbstractSVGBridge
    implements SVGContext, BridgeUpdateHandler, GraphicsNodeBridge, ErrorConstants
{

    protected AbstractGraphicsNodeBridge()
    {
        bboxShape = null;
        bbox = null;
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()))
            return null;
        GraphicsNode graphicsnode = instantiateGraphicsNode();
        String s = element.getAttributeNS(null, "transform");
        if(s.length() != 0)
            graphicsnode.setTransform(SVGUtilities.convertTransform(element, "transform", s));
        graphicsnode.setVisible(CSSUtilities.convertVisibility(element));
        return graphicsnode;
    }

    protected abstract GraphicsNode instantiateGraphicsNode();

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        graphicsnode.setComposite(CSSUtilities.convertOpacity(element));
        graphicsnode.setFilter(CSSUtilities.convertFilter(element, graphicsnode, bridgecontext));
        graphicsnode.setMask(CSSUtilities.convertMask(element, graphicsnode, bridgecontext));
        graphicsnode.setClip(CSSUtilities.convertClipPath(element, graphicsnode, bridgecontext));
        graphicsnode.setPointerEventType(CSSUtilities.convertPointerEvents(element));
        initializeDynamicSupport(bridgecontext, element, graphicsnode);
    }

    public boolean getDisplay(Element element)
    {
        return CSSUtilities.convertDisplay(element);
    }

    protected void initializeDynamicSupport(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        if(!bridgecontext.isInteractive())
            return;
        bridgecontext.bind(element, graphicsnode);
        if(bridgecontext.isDynamic())
        {
            e = element;
            node = graphicsnode;
            ctx = bridgecontext;
            ((SVGOMElement)element).setSVGContext(this);
        }
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("transform"))
        {
            String s1 = mutationevent.getNewValue();
            AffineTransform affinetransform = GraphicsNode.IDENTITY;
            if(s1.length() != 0)
                affinetransform = SVGUtilities.convertTransform(e, "transform", s1);
            node.setTransform(affinetransform);
            handleGeometryChanged();
        }
    }

    protected void handleGeometryChanged()
    {
        node.setFilter(CSSUtilities.convertFilter(e, node, ctx));
        node.setMask(CSSUtilities.convertMask(e, node, ctx));
        node.setClip(CSSUtilities.convertClipPath(e, node, ctx));
    }

    public void handleDOMNodeInsertedEvent(MutationEvent mutationevent)
    {
        if(mutationevent.getTarget() instanceof Element)
        {
            Element element = (Element)mutationevent.getTarget();
            Bridge bridge = ctx.getBridge(element);
            if(bridge instanceof GenericBridge)
                ((GenericBridge)bridge).handleElement(ctx, element);
        }
    }

    public void handleDOMNodeRemovedEvent(MutationEvent mutationevent)
    {
        CompositeGraphicsNode compositegraphicsnode = node.getParent();
        compositegraphicsnode.remove(node);
        disposeTree(e);
    }

    public void handleDOMCharacterDataModified(MutationEvent mutationevent)
    {
    }

    public void dispose()
    {
        SVGOMElement svgomelement = (SVGOMElement)e;
        svgomelement.setSVGContext(null);
        ctx.unbind(e);
    }

    static void disposeTree(Node node1)
    {
        if(node1 instanceof SVGOMElement)
        {
            SVGOMElement svgomelement = (SVGOMElement)node1;
            BridgeUpdateHandler bridgeupdatehandler = (BridgeUpdateHandler)svgomelement.getSVGContext();
            if(bridgeupdatehandler != null)
                bridgeupdatehandler.dispose();
        }
        for(Node node2 = node1.getFirstChild(); node2 != null; node2 = node2.getNextSibling())
            disposeTree(node2);

    }

    public void handleCSSEngineEvent(CSSEngineEvent cssengineevent)
    {
        try
        {
            int ai[] = cssengineevent.getProperties();
            for(int i = 0; i < ai.length; i++)
                handleCSSPropertyChanged(ai[i]);

        }
        catch(Exception exception)
        {
            ctx.getUserAgent().displayError(exception);
        }
    }

    protected void handleCSSPropertyChanged(int i)
    {
        switch(i)
        {
        default:
            break;

        case 57: // '9'
            node.setVisible(CSSUtilities.convertVisibility(e));
            break;

        case 38: // '&'
            node.setComposite(CSSUtilities.convertOpacity(e));
            break;

        case 18: // '\022'
            node.setFilter(CSSUtilities.convertFilter(e, node, ctx));
            break;

        case 37: // '%'
            node.setMask(CSSUtilities.convertMask(e, node, ctx));
            break;

        case 3: // '\003'
            node.setClip(CSSUtilities.convertClipPath(e, node, ctx));
            break;

        case 40: // '('
            node.setPointerEventType(CSSUtilities.convertPointerEvents(e));
            break;

        case 12: // '\f'
            if(!getDisplay(e))
            {
                CompositeGraphicsNode compositegraphicsnode = node.getParent();
                int j = compositegraphicsnode.indexOf(node);
                compositegraphicsnode.remove(node);
                disposeTree(e);
            }
            break;
        }
    }

    public float getPixelUnitToMillimeter()
    {
        return ctx.getUserAgent().getPixelUnitToMillimeter();
    }

    public float getPixelToMM()
    {
        return getPixelUnitToMillimeter();
    }

    public Rectangle2D getBBox()
    {
        java.awt.Shape shape = node.getOutline();
        if(bboxShape != null && shape == bboxShape.get())
            return bbox;
        bboxShape = new SoftReference(shape);
        bbox = null;
        if(shape == null)
        {
            return bbox;
        } else
        {
            SegmentList segmentlist = new SegmentList(shape);
            bbox = segmentlist.getBounds2D();
            return bbox;
        }
    }

    public AffineTransform getCTM()
    {
        Object obj = node;
        AffineTransform affinetransform = new AffineTransform();
        for(Object obj1 = e; obj1 != null;)
        {
            if(obj1 instanceof SVGFitToViewBox)
            {
                AffineTransform affinetransform1;
                if(obj instanceof CanvasGraphicsNode)
                    affinetransform1 = ((CanvasGraphicsNode)obj).getViewingTransform();
                else
                    affinetransform1 = ((GraphicsNode) (obj)).getTransform();
                if(affinetransform1 != null)
                    affinetransform.preConcatenate(affinetransform1);
                break;
            }
            AffineTransform affinetransform2 = ((GraphicsNode) (obj)).getTransform();
            if(affinetransform2 != null)
                affinetransform.preConcatenate(affinetransform2);
            obj1 = SVGCSSEngine.getParentCSSStylableElement(((Element) (obj1)));
            obj = ((GraphicsNode) (obj)).getParent();
        }

        return affinetransform;
    }

    public AffineTransform getScreenTransform()
    {
        return ctx.getUserAgent().getTransform();
    }

    public void setScreenTransform(AffineTransform affinetransform)
    {
        ctx.getUserAgent().setTransform(affinetransform);
    }

    public AffineTransform getGlobalTransform()
    {
        return node.getGlobalTransform();
    }

    public float getViewportWidth()
    {
        return ctx.getBlockWidth(e);
    }

    public float getViewportHeight()
    {
        return ctx.getBlockHeight(e);
    }

    public float getFontSize()
    {
        return CSSUtilities.getComputedStyle(e, 22).getFloatValue();
    }

    protected Element e;
    protected GraphicsNode node;
    protected BridgeContext ctx;
    protected SoftReference bboxShape;
    protected Rectangle2D bbox;
}
