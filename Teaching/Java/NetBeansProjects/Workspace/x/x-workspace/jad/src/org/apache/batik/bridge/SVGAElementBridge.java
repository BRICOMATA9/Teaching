// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Cursor;
import org.apache.batik.dom.events.AbstractEvent;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.events.*;
import org.w3c.dom.svg.SVGAElement;

// Referenced classes of package org.apache.batik.bridge:
//            SVGGElementBridge, BridgeContext, Bridge, UserAgent, 
//            CSSUtilities, CursorManager

public class SVGAElementBridge extends SVGGElementBridge
{
    public static class CursorMouseOutListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            if(AbstractEvent.getEventPreventDefault(event))
                return;
            SVGAElement svgaelement = (SVGAElement)event.getCurrentTarget();
            if(svgaelement != null)
                userAgent.displayMessage("");
        }

        protected UserAgent userAgent;

        public CursorMouseOutListener(UserAgent useragent)
        {
            userAgent = useragent;
        }
    }

    public static class CursorMouseOverListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            if(AbstractEvent.getEventPreventDefault(event))
                return;
            Element element = (Element)event.getTarget();
            if(CSSUtilities.isAutoCursor(element))
                userAgent.setSVGCursor(CursorManager.ANCHOR_CURSOR);
            SVGAElement svgaelement = (SVGAElement)event.getCurrentTarget();
            if(svgaelement != null)
            {
                String s = XLinkSupport.getXLinkHref(svgaelement);
                userAgent.displayMessage(s);
            }
        }

        protected UserAgent userAgent;

        public CursorMouseOverListener(UserAgent useragent)
        {
            userAgent = useragent;
        }
    }

    public static class AnchorListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            if(AbstractEvent.getEventPreventDefault(event))
            {
                return;
            } else
            {
                SVGAElement svgaelement = (SVGAElement)event.getCurrentTarget();
                Cursor cursor = Cursor.getPredefinedCursor(0);
                userAgent.setSVGCursor(cursor);
                userAgent.openLink(svgaelement);
                event.stopPropagation();
                return;
            }
        }

        protected UserAgent userAgent;

        public AnchorListener(UserAgent useragent)
        {
            userAgent = useragent;
        }
    }


    public SVGAElementBridge()
    {
    }

    public String getLocalName()
    {
        return "a";
    }

    public Bridge getInstance()
    {
        return new SVGAElementBridge();
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        super.buildGraphicsNode(bridgecontext, element, graphicsnode);
        if(bridgecontext.isInteractive())
        {
            EventTarget eventtarget = (EventTarget)element;
            Object obj = new AnchorListener(bridgecontext.getUserAgent());
            eventtarget.addEventListener("click", ((EventListener) (obj)), false);
            bridgecontext.storeEventListener(eventtarget, "click", ((EventListener) (obj)), false);
            obj = new CursorMouseOverListener(bridgecontext.getUserAgent());
            eventtarget.addEventListener("mouseover", ((EventListener) (obj)), false);
            bridgecontext.storeEventListener(eventtarget, "mouseover", ((EventListener) (obj)), false);
            obj = new CursorMouseOutListener(bridgecontext.getUserAgent());
            eventtarget.addEventListener("mouseout", ((EventListener) (obj)), false);
            bridgecontext.storeEventListener(eventtarget, "mouseout", ((EventListener) (obj)), false);
        }
    }

    public boolean isComposite()
    {
        return true;
    }
}
