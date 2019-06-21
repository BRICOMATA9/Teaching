// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import org.apache.batik.dom.events.DOMKeyEvent;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.TextNode;
import org.apache.batik.gvt.event.EventDispatcher;
import org.apache.batik.gvt.event.GraphicsNodeKeyEvent;
import org.apache.batik.gvt.event.GraphicsNodeKeyListener;
import org.apache.batik.gvt.event.GraphicsNodeMouseEvent;
import org.apache.batik.gvt.event.GraphicsNodeMouseListener;
import org.apache.batik.gvt.renderer.StrokingTextPainter;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.gvt.text.TextSpanLayout;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, UserAgent, FocusManager

public class BridgeEventSupport
    implements SVGConstants
{
    protected static class Listener
        implements GraphicsNodeMouseListener, GraphicsNodeKeyListener
    {

        public void keyPressed(GraphicsNodeKeyEvent graphicsnodekeyevent)
        {
            if(!isDown)
            {
                isDown = true;
                dispatchKeyEvent("keydown", graphicsnodekeyevent);
            }
            if(graphicsnodekeyevent.getKeyChar() == '\uFFFF')
                dispatchKeyEvent("keypress", graphicsnodekeyevent);
        }

        public void keyReleased(GraphicsNodeKeyEvent graphicsnodekeyevent)
        {
            dispatchKeyEvent("keyup", graphicsnodekeyevent);
            isDown = false;
        }

        public void keyTyped(GraphicsNodeKeyEvent graphicsnodekeyevent)
        {
            dispatchKeyEvent("keypress", graphicsnodekeyevent);
        }

        protected void dispatchKeyEvent(String s, GraphicsNodeKeyEvent graphicsnodekeyevent)
        {
            FocusManager focusmanager = context.getFocusManager();
            if(focusmanager == null)
                return;
            Element element = (Element)focusmanager.getCurrentEventTarget();
            if(element == null)
                return;
            DocumentEvent documentevent = (DocumentEvent)element.getOwnerDocument();
            DOMKeyEvent domkeyevent = (DOMKeyEvent)documentevent.createEvent("KeyEvents");
            domkeyevent.initKeyEvent(s, true, true, graphicsnodekeyevent.isControlDown(), graphicsnodekeyevent.isAltDown(), graphicsnodekeyevent.isShiftDown(), graphicsnodekeyevent.isMetaDown(), mapKeyCode(graphicsnodekeyevent.getKeyCode()), graphicsnodekeyevent.getKeyChar(), null);
            try
            {
                ((EventTarget)element).dispatchEvent(domkeyevent);
            }
            catch(RuntimeException runtimeexception)
            {
                ua.displayError(runtimeexception);
            }
        }

        protected final int mapKeyCode(int i)
        {
            switch(i)
            {
            case 10: // '\n'
                return 13;

            case 262: 
                return 0;

            case 263: 
                return 0;
            }
            return i;
        }

        public void mouseClicked(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            dispatchMouseEvent("click", graphicsnodemouseevent, true);
        }

        public void mousePressed(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            dispatchMouseEvent("mousedown", graphicsnodemouseevent, true);
        }

        public void mouseReleased(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            dispatchMouseEvent("mouseup", graphicsnodemouseevent, true);
        }

        public void mouseEntered(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            dispatchMouseEvent("mouseover", graphicsnodemouseevent, true);
        }

        public void mouseExited(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            Point point = graphicsnodemouseevent.getClientPoint();
            GraphicsNode graphicsnode = graphicsnodemouseevent.getRelatedNode();
            Element element = getEventTarget(graphicsnode, point);
            if(lastTargetElement != null)
                dispatchMouseEvent("mouseout", lastTargetElement, element, point, graphicsnodemouseevent, true);
        }

        public void mouseDragged(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            dispatchMouseEvent("mousemove", graphicsnodemouseevent, false);
        }

        public void mouseMoved(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            Point point = graphicsnodemouseevent.getClientPoint();
            GraphicsNode graphicsnode = graphicsnodemouseevent.getGraphicsNode();
            Element element = getEventTarget(graphicsnode, point);
            Element element1 = lastTargetElement;
            if(element1 != element)
            {
                if(element1 != null)
                    dispatchMouseEvent("mouseout", element1, element, point, graphicsnodemouseevent, true);
                if(element != null)
                    dispatchMouseEvent("mouseover", element, element1, point, graphicsnodemouseevent, true);
            }
            dispatchMouseEvent("mousemove", element, null, point, graphicsnodemouseevent, false);
        }

        protected void dispatchMouseEvent(String s, GraphicsNodeMouseEvent graphicsnodemouseevent, boolean flag)
        {
            Point point = graphicsnodemouseevent.getClientPoint();
            GraphicsNode graphicsnode = graphicsnodemouseevent.getGraphicsNode();
            Element element = getEventTarget(graphicsnode, new java.awt.geom.Point2D.Float(graphicsnodemouseevent.getX(), graphicsnodemouseevent.getY()));
            Element element1 = getRelatedElement(graphicsnodemouseevent);
            dispatchMouseEvent(s, element, element1, point, graphicsnodemouseevent, flag);
        }

        protected void dispatchMouseEvent(String s, Element element, Element element1, Point point, GraphicsNodeMouseEvent graphicsnodemouseevent, boolean flag)
        {
            MouseEvent mouseevent;
            if(element == null)
                return;
            short word0 = getButton(graphicsnodemouseevent);
            Point point1 = graphicsnodemouseevent.getScreenPoint();
            DocumentEvent documentevent = (DocumentEvent)element.getOwnerDocument();
            mouseevent = (MouseEvent)documentevent.createEvent("MouseEvents");
            mouseevent.initMouseEvent(s, true, flag, null, graphicsnodemouseevent.getClickCount(), point1.x, point1.y, point.x, point.y, graphicsnodemouseevent.isControlDown(), graphicsnodemouseevent.isAltDown(), graphicsnodemouseevent.isShiftDown(), graphicsnodemouseevent.isMetaDown(), word0, (EventTarget)element1);
            ((EventTarget)element).dispatchEvent(mouseevent);
            lastTargetElement = element;
            break MISSING_BLOCK_LABEL_159;
            RuntimeException runtimeexception;
            runtimeexception;
            ua.displayError(runtimeexception);
            lastTargetElement = element;
            break MISSING_BLOCK_LABEL_159;
            Exception exception;
            exception;
            lastTargetElement = element;
            throw exception;
        }

        protected Element getRelatedElement(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            GraphicsNode graphicsnode = graphicsnodemouseevent.getRelatedNode();
            Element element = null;
            if(graphicsnode != null)
                element = context.getElement(graphicsnode);
            return element;
        }

        protected short getButton(GraphicsNodeMouseEvent graphicsnodemouseevent)
        {
            short word0 = 1;
            if((0x10 & graphicsnodemouseevent.getModifiers()) != 0)
                word0 = 0;
            else
            if((4 & graphicsnodemouseevent.getModifiers()) != 0)
                word0 = 2;
            return word0;
        }

        protected Element getEventTarget(GraphicsNode graphicsnode, Point2D point2d)
        {
            Element element = context.getElement(graphicsnode);
            if(element != null && (graphicsnode instanceof TextNode))
            {
                TextNode textnode = (TextNode)graphicsnode;
                java.util.List list = textnode.getTextRuns();
                Point2D point2d1 = (Point2D)point2d.clone();
                try
                {
                    graphicsnode.getGlobalTransform().createInverse().transform(point2d1, point2d1);
                }
                catch(NoninvertibleTransformException noninvertibletransformexception) { }
                if(list != null)
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textrun = (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)list.get(i);
                        AttributedCharacterIterator attributedcharacteriterator = textrun.getACI();
                        TextSpanLayout textspanlayout = textrun.getLayout();
                        float f = (float)point2d1.getX();
                        float f1 = (float)point2d1.getY();
                        org.apache.batik.gvt.text.TextHit texthit = textspanlayout.hitTestChar(f, f1);
                        Rectangle2D rectangle2d = textspanlayout.getBounds2D();
                        if(texthit == null || rectangle2d == null || !rectangle2d.contains(f, f1))
                            continue;
                        Object obj = attributedcharacteriterator.getAttribute(org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.TEXT_COMPOUND_DELIMITER);
                        if(obj instanceof Element)
                            return (Element)obj;
                    }

                }
            }
            return element;
        }

        protected BridgeContext context;
        protected UserAgent ua;
        protected Element lastTargetElement;
        protected boolean isDown;

        public Listener(BridgeContext bridgecontext, UserAgent useragent)
        {
            context = bridgecontext;
            ua = useragent;
        }
    }

    protected static class GVTUnloadListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            dispatcher.removeGraphicsNodeMouseListener(listener);
            dispatcher.removeGraphicsNodeKeyListener(listener);
            event.getTarget().removeEventListener("SVGUnload", this, false);
        }

        protected EventDispatcher dispatcher;
        protected Listener listener;

        public GVTUnloadListener(EventDispatcher eventdispatcher, Listener listener1)
        {
            dispatcher = eventdispatcher;
            listener = listener1;
        }
    }


    private BridgeEventSupport()
    {
    }

    public static void addGVTListener(BridgeContext bridgecontext, Document document)
    {
        UserAgent useragent = bridgecontext.getUserAgent();
        if(useragent != null)
        {
            EventDispatcher eventdispatcher = useragent.getEventDispatcher();
            if(eventdispatcher != null)
            {
                Listener listener = new Listener(bridgecontext, useragent);
                eventdispatcher.addGraphicsNodeMouseListener(listener);
                eventdispatcher.addGraphicsNodeKeyListener(listener);
                GVTUnloadListener gvtunloadlistener = new GVTUnloadListener(eventdispatcher, listener);
                EventTarget eventtarget = (EventTarget)document;
                eventtarget.addEventListener("SVGUnload", gvtunloadlistener, false);
                bridgecontext.storeEventListener(eventtarget, "SVGUnload", gvtunloadlistener, false);
            }
        }
    }
}
