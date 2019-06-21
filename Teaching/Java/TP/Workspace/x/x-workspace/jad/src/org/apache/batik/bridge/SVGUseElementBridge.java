// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.List;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.dom.svg.SVGOMCSSImportedElementRoot;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.SVGOMUseElement;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractGraphicsNodeBridge, BridgeContext, SVGUtilities, BridgeException, 
//            CSSUtilities, GVTBuilder, UnitProcessor, Bridge, 
//            UserAgent

public class SVGUseElementBridge extends AbstractGraphicsNodeBridge
{
    public class ReferencedElementMutationListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            buildCompositeGraphicsNode(ctx, e, (CompositeGraphicsNode)node);
        }

        EventTarget target;

        public ReferencedElementMutationListener()
        {
        }
    }

    public static class CursorMouseOverListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Element element = (Element)event.getCurrentTarget();
            if(!CSSUtilities.isAutoCursor(element))
            {
                java.awt.Cursor cursor = CSSUtilities.convertCursor(element, ctx);
                if(cursor != null)
                    ctx.getUserAgent().setSVGCursor(cursor);
            }
        }

        protected BridgeContext ctx;

        public CursorMouseOverListener(BridgeContext bridgecontext)
        {
            ctx = bridgecontext;
        }
    }


    public SVGUseElementBridge()
    {
        subCtx = null;
    }

    public String getLocalName()
    {
        return "use";
    }

    public Bridge getInstance()
    {
        return new SVGUseElementBridge();
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()))
        {
            return null;
        } else
        {
            CompositeGraphicsNode compositegraphicsnode = buildCompositeGraphicsNode(bridgecontext, element, null);
            return compositegraphicsnode;
        }
    }

    public CompositeGraphicsNode buildCompositeGraphicsNode(BridgeContext bridgecontext, Element element, CompositeGraphicsNode compositegraphicsnode)
    {
        String s = XLinkSupport.getXLinkHref(element);
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "xlink:href"
            });
        Element element1 = bridgecontext.getReferencedElement(element, s);
        SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
        SVGOMDocument svgomdocument1 = (SVGOMDocument)element1.getOwnerDocument();
        boolean flag = svgomdocument1 == svgomdocument;
        BridgeContext bridgecontext1 = bridgecontext;
        subCtx = null;
        if(!flag)
        {
            CSSEngine cssengine = svgomdocument1.getCSSEngine();
            subCtx = (BridgeContext)svgomdocument1.getCSSEngine().getCSSContext();
            bridgecontext1 = subCtx;
        }
        Element element2 = (Element)svgomdocument.importNode(element1, true, true);
        if("symbol".equals(element2.getLocalName()))
        {
            Element element3 = svgomdocument.createElementNS("http://www.w3.org/2000/svg", "svg");
            NamedNodeMap namednodemap = element2.getAttributes();
            int j = namednodemap.getLength();
            for(int i1 = 0; i1 < j; i1++)
            {
                Attr attr = (Attr)namednodemap.item(i1);
                element3.setAttributeNS(attr.getNamespaceURI(), attr.getName(), attr.getValue());
            }

            for(Node node = element2.getFirstChild(); node != null; node = element2.getFirstChild())
                element3.appendChild(node);

            element2 = element3;
        }
        if("svg".equals(element2.getLocalName()))
        {
            String s1 = element.getAttributeNS(null, "width");
            if(s1.length() != 0)
                element2.setAttributeNS(null, "width", s1);
            String s2 = element.getAttributeNS(null, "height");
            if(s2.length() != 0)
                element2.setAttributeNS(null, "height", s2);
        }
        SVGOMCSSImportedElementRoot svgomcssimportedelementroot = new SVGOMCSSImportedElementRoot(svgomdocument, element, flag);
        svgomcssimportedelementroot.appendChild(element2);
        if(compositegraphicsnode == null)
        {
            compositegraphicsnode = new CompositeGraphicsNode();
        } else
        {
            int i = compositegraphicsnode.size();
            for(int k = 0; k < i; k++)
                compositegraphicsnode.remove(0);

        }
        SVGOMUseElement svgomuseelement = (SVGOMUseElement)element;
        org.apache.batik.css.engine.CSSImportedElementRoot cssimportedelementroot = svgomuseelement.getCSSImportedElementRoot();
        if(cssimportedelementroot != null)
            disposeTree(cssimportedelementroot);
        svgomuseelement.setCSSImportedElementRoot(svgomcssimportedelementroot);
        Element element4 = element2;
        CSSUtilities.computeStyleAndURIs(element1, element2, s);
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        GraphicsNode graphicsnode = gvtbuilder.build(bridgecontext, element4);
        compositegraphicsnode.getChildren().add(graphicsnode);
        compositegraphicsnode.setTransform(computeTransform(element, bridgecontext));
        compositegraphicsnode.setVisible(CSSUtilities.convertVisibility(element));
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        if(renderinghints != null)
            compositegraphicsnode.setRenderingHints(renderinghints);
        java.awt.geom.Rectangle2D rectangle2d = CSSUtilities.convertEnableBackground(element);
        if(rectangle2d != null)
            compositegraphicsnode.setBackgroundEnable(rectangle2d);
        if(l != null)
        {
            EventTarget eventtarget = l.target;
            eventtarget.removeEventListener("DOMAttrModified", l, true);
            eventtarget.removeEventListener("DOMNodeInserted", l, true);
            eventtarget.removeEventListener("DOMNodeRemoved", l, true);
            eventtarget.removeEventListener("DOMCharacterDataModified", l, true);
            l = null;
        }
        if(flag && bridgecontext.isDynamic())
        {
            l = new ReferencedElementMutationListener();
            EventTarget eventtarget1 = (EventTarget)element1;
            l.target = eventtarget1;
            eventtarget1.addEventListener("DOMAttrModified", l, true);
            bridgecontext1.storeEventListener(eventtarget1, "DOMAttrModified", l, true);
            eventtarget1.addEventListener("DOMNodeInserted", l, true);
            bridgecontext1.storeEventListener(eventtarget1, "DOMNodeInserted", l, true);
            eventtarget1.addEventListener("DOMNodeRemoved", l, true);
            bridgecontext1.storeEventListener(eventtarget1, "DOMNodeRemoved", l, true);
            eventtarget1.addEventListener("DOMCharacterDataModified", l, true);
            bridgecontext1.storeEventListener(eventtarget1, "DOMCharacterDataModified", l, true);
        }
        return compositegraphicsnode;
    }

    public void dispose()
    {
        if(l != null)
        {
            EventTarget eventtarget = l.target;
            eventtarget.removeEventListener("DOMAttrModified", l, true);
            eventtarget.removeEventListener("DOMNodeInserted", l, true);
            eventtarget.removeEventListener("DOMNodeRemoved", l, true);
            eventtarget.removeEventListener("DOMCharacterDataModified", l, true);
            l = null;
        }
        SVGOMUseElement svgomuseelement = (SVGOMUseElement)e;
        if(svgomuseelement != null && svgomuseelement.getCSSImportedElementRoot() != null)
            disposeTree(svgomuseelement.getCSSImportedElementRoot());
        super.dispose();
        subCtx = null;
    }

    protected java.awt.geom.AffineTransform computeTransform(Element element, BridgeContext bridgecontext)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        float f = 0.0F;
        String s = element.getAttributeNS(null, "x");
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x", context);
        float f1 = 0.0F;
        s = element.getAttributeNS(null, "y");
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y", context);
        s = element.getAttributeNS(null, "transform");
        java.awt.geom.AffineTransform affinetransform = java.awt.geom.AffineTransform.getTranslateInstance(f, f1);
        if(s.length() != 0)
            affinetransform.preConcatenate(SVGUtilities.convertTransform(element, "transform", s));
        return affinetransform;
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return null;
    }

    public boolean isComposite()
    {
        return false;
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        super.buildGraphicsNode(bridgecontext, element, graphicsnode);
        if(bridgecontext.isInteractive())
        {
            EventTarget eventtarget = (EventTarget)element;
            CursorMouseOverListener cursormouseoverlistener = new CursorMouseOverListener(bridgecontext);
            eventtarget.addEventListener("mouseover", cursormouseoverlistener, false);
            bridgecontext.storeEventListener(eventtarget, "mouseover", cursormouseoverlistener, false);
        }
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        Node node = mutationevent.getRelatedNode();
        if(node.getNamespaceURI() == null && (s.equals("x") || s.equals("y") || s.equals("transform")))
        {
            this.node.setTransform(computeTransform(e, ctx));
            handleGeometryChanged();
        } else
        if(node.getNamespaceURI() == null && (s.equals("width") || s.equals("height")) || "http://www.w3.org/1999/xlink".equals(node.getNamespaceURI()) && "href".equals(node.getLocalName()))
            buildCompositeGraphicsNode(ctx, e, (CompositeGraphicsNode)this.node);
    }

    protected ReferencedElementMutationListener l;
    protected BridgeContext subCtx;
}
