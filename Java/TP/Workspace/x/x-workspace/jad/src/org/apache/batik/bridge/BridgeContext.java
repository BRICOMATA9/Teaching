// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.batik.bridge.svg12.SVG12BridgeExtension;
import org.apache.batik.css.engine.CSSContext;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.CSSEngineEvent;
import org.apache.batik.css.engine.CSSEngineListener;
import org.apache.batik.css.engine.CSSEngineUserAgent;
import org.apache.batik.css.engine.SystemColorSupport;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.svg.SVGContext;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.SVGOMElement;
import org.apache.batik.dom.svg.SVGStylableElement;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.TextPainter;
import org.apache.batik.script.Interpreter;
import org.apache.batik.script.InterpreterPool;
import org.apache.batik.util.CleanerThread;
import org.apache.batik.util.ParsedURL;
import org.apache.batik.util.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.events.MutationEvent;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, CursorManager, DocumentLoader, UserAgentViewport, 
//            UserAgent, URIResolver, BridgeException, InterruptedBridgeException, 
//            Viewport, SVGUtilities, GraphicsNodeBridge, Bridge, 
//            FocusManager, BridgeUpdateHandler, BaseScriptingEnvironment, BridgeExtension, 
//            SVGBridgeExtension, GVTBuilder, UpdateManager, CSSUtilities

public class BridgeContext
    implements ErrorConstants, CSSContext
{
    public static class CSSEngineUserAgentWrapper
        implements CSSEngineUserAgent
    {

        public void displayError(Exception exception)
        {
            ua.displayError(exception);
        }

        public void displayMessage(String s)
        {
            ua.displayMessage(s);
        }

        UserAgent ua;

        CSSEngineUserAgentWrapper(UserAgent useragent)
        {
            ua = useragent;
        }
    }

    protected class CSSPropertiesChangedListener
        implements CSSEngineListener
    {

        public void propertiesChanged(CSSEngineEvent cssengineevent)
        {
            Element element = cssengineevent.getElement();
            SVGContext svgcontext = BridgeContext.getSVGContext(element);
            if(svgcontext == null)
            {
                GraphicsNode graphicsnode = getGraphicsNode((Element)element.getParentNode());
                if(graphicsnode == null || !(graphicsnode instanceof CompositeGraphicsNode))
                    return;
                CompositeGraphicsNode compositegraphicsnode = (CompositeGraphicsNode)graphicsnode;
                int ai[] = cssengineevent.getProperties();
                int i = 0;
                do
                {
                    if(i >= ai.length)
                        break;
                    if(ai[i] == 12)
                    {
                        if(CSSUtilities.convertDisplay(element))
                        {
                            GVTBuilder gvtbuilder = getGVTBuilder();
                            GraphicsNode graphicsnode1 = gvtbuilder.build(BridgeContext.this, element);
                            if(graphicsnode1 != null)
                            {
                                int j = -1;
                                for(Node node = element.getPreviousSibling(); node != null; node = node.getPreviousSibling())
                                {
                                    if(node.getNodeType() != 1)
                                        continue;
                                    Element element1 = (Element)node;
                                    GraphicsNode graphicsnode2 = getGraphicsNode(element1);
                                    if(graphicsnode2 == null)
                                        continue;
                                    j = compositegraphicsnode.indexOf(graphicsnode2);
                                    if(j != -1)
                                        break;
                                }

                                j++;
                                compositegraphicsnode.add(j, graphicsnode1);
                            }
                        }
                        break;
                    }
                    i++;
                } while(true);
            }
            if(svgcontext != null && (svgcontext instanceof BridgeUpdateHandler))
                ((BridgeUpdateHandler)svgcontext).handleCSSEngineEvent(cssengineevent);
        }

        protected CSSPropertiesChangedListener()
        {
        }
    }

    protected class DOMCharacterDataModifiedListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Node node;
            for(node = (Node)event.getTarget(); node != null && !(node instanceof SVGOMElement); node = node.getParentNode());
            BridgeUpdateHandler bridgeupdatehandler = BridgeContext.getBridgeUpdateHandler(node);
            if(bridgeupdatehandler != null)
                try
                {
                    bridgeupdatehandler.handleDOMCharacterDataModified((MutationEvent)event);
                }
                catch(Exception exception)
                {
                    userAgent.displayError(exception);
                }
        }

        protected DOMCharacterDataModifiedListener()
        {
        }
    }

    protected class DOMNodeRemovedEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Node node = (Node)event.getTarget();
            BridgeUpdateHandler bridgeupdatehandler = BridgeContext.getBridgeUpdateHandler(node);
            if(bridgeupdatehandler != null)
                try
                {
                    bridgeupdatehandler.handleDOMNodeRemovedEvent((MutationEvent)event);
                }
                catch(Exception exception)
                {
                    userAgent.displayError(exception);
                }
        }

        protected DOMNodeRemovedEventListener()
        {
        }
    }

    protected class DOMNodeInsertedEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            MutationEvent mutationevent = (MutationEvent)event;
            BridgeUpdateHandler bridgeupdatehandler = BridgeContext.getBridgeUpdateHandler(mutationevent.getRelatedNode());
            if(bridgeupdatehandler != null)
                try
                {
                    bridgeupdatehandler.handleDOMNodeInsertedEvent(mutationevent);
                }
                catch(InterruptedBridgeException interruptedbridgeexception) { }
                catch(Exception exception)
                {
                    userAgent.displayError(exception);
                }
        }

        protected DOMNodeInsertedEventListener()
        {
        }
    }

    protected class DOMMouseOverEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Element element = (Element)event.getTarget();
            java.awt.Cursor cursor = CSSUtilities.convertCursor(element, BridgeContext.this);
            if(cursor != null)
                userAgent.setSVGCursor(cursor);
        }

        protected DOMMouseOverEventListener()
        {
        }
    }

    protected class DOMMouseOutEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            MouseEvent mouseevent = (MouseEvent)event;
            Element element = (Element)mouseevent.getRelatedTarget();
            java.awt.Cursor cursor = CursorManager.DEFAULT_CURSOR;
            if(element != null)
                cursor = CSSUtilities.convertCursor(element, BridgeContext.this);
            if(cursor == null)
                cursor = CursorManager.DEFAULT_CURSOR;
            userAgent.setSVGCursor(cursor);
        }

        protected DOMMouseOutEventListener()
        {
        }
    }

    protected class DOMAttrModifiedEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Node node = (Node)event.getTarget();
            BridgeUpdateHandler bridgeupdatehandler = BridgeContext.getBridgeUpdateHandler(node);
            if(bridgeupdatehandler != null)
                try
                {
                    bridgeupdatehandler.handleDOMAttrModifiedEvent((MutationEvent)event);
                }
                catch(Exception exception)
                {
                    userAgent.displayError(exception);
                }
        }

        protected DOMAttrModifiedEventListener()
        {
        }
    }

    protected static class EventListenerMememto
    {

        public EventListener getListener()
        {
            return (EventListener)listener.get();
        }

        public EventTarget getTarget()
        {
            return (EventTarget)target.get();
        }

        public boolean getUseCapture()
        {
            return useCapture;
        }

        public String getEventType()
        {
            return eventType;
        }

        public SoftReference target;
        public SoftReference listener;
        public boolean useCapture;
        public String eventType;

        public EventListenerMememto(EventTarget eventtarget, String s, EventListener eventlistener, boolean flag, BridgeContext bridgecontext)
        {
            Set set = bridgecontext.eventListenerSet;
            target = new SoftReferenceMememto(eventtarget, this, set);
            listener = new SoftReferenceMememto(eventlistener, this, set);
            eventType = s;
            useCapture = flag;
        }
    }

    public static class SoftReferenceMememto extends org.apache.batik.util.CleanerThread.SoftReferenceCleared
    {

        public void cleared()
        {
            synchronized(set)
            {
                set.remove(mememto);
                mememto = null;
                set = null;
            }
        }

        Object mememto;
        Set set;

        SoftReferenceMememto(Object obj, Object obj1, Set set1)
        {
            super(obj);
            mememto = obj1;
            set = set1;
        }
    }


    protected BridgeContext()
    {
        interpreterMap = new HashMap(7);
        viewportMap = new WeakHashMap();
        viewportStack = new LinkedList();
        dynamicStatus = 0;
        eventListenerSet = new HashSet();
        cursorManager = new CursorManager(this);
        extensions = null;
    }

    public BridgeContext(UserAgent useragent)
    {
        this(useragent, sharedPool, new DocumentLoader(useragent));
    }

    public BridgeContext(UserAgent useragent, DocumentLoader documentloader)
    {
        this(useragent, sharedPool, documentloader);
    }

    public BridgeContext(UserAgent useragent, InterpreterPool interpreterpool, DocumentLoader documentloader)
    {
        interpreterMap = new HashMap(7);
        viewportMap = new WeakHashMap();
        viewportStack = new LinkedList();
        dynamicStatus = 0;
        eventListenerSet = new HashSet();
        cursorManager = new CursorManager(this);
        extensions = null;
        userAgent = useragent;
        viewportMap.put(useragent, new UserAgentViewport(useragent));
        interpreterPool = interpreterpool;
        documentLoader = documentloader;
    }

    protected void initializeDocument(Document document1)
    {
        SVGOMDocument svgomdocument = (SVGOMDocument)document1;
        CSSEngine cssengine = svgomdocument.getCSSEngine();
        if(cssengine == null)
        {
            SVGDOMImplementation svgdomimplementation = (SVGDOMImplementation)svgomdocument.getImplementation();
            CSSEngine cssengine1 = svgdomimplementation.createCSSEngine(svgomdocument, this);
            cssengine1.setCSSEngineUserAgent(new CSSEngineUserAgentWrapper(userAgent));
            svgomdocument.setCSSEngine(cssengine1);
            cssengine1.setMedia(userAgent.getMedia());
            String s = userAgent.getUserStyleSheetURI();
            if(s != null)
                try
                {
                    URL url = new URL(s);
                    cssengine1.setUserAgentStyleSheet(cssengine1.parseStyleSheet(url, "all"));
                }
                catch(MalformedURLException malformedurlexception)
                {
                    userAgent.displayError(malformedurlexception);
                }
            cssengine1.setAlternateStyleSheet(userAgent.getAlternateStyleSheet());
        }
    }

    public CSSEngine getCSSEngineForElement(Element element)
    {
        SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
        return svgomdocument.getCSSEngine();
    }

    public void setTextPainter(TextPainter textpainter)
    {
        textPainter = textpainter;
    }

    public TextPainter getTextPainter()
    {
        return textPainter;
    }

    public Document getDocument()
    {
        return document;
    }

    protected void setDocument(Document document1)
    {
        if(document != document1)
            fontFamilyMap = null;
        document = document1;
        registerSVGBridges();
    }

    public Map getFontFamilyMap()
    {
        if(fontFamilyMap == null)
            fontFamilyMap = new HashMap();
        return fontFamilyMap;
    }

    protected void setFontFamilyMap(Map map)
    {
        fontFamilyMap = map;
    }

    public void setElementData(Node node, Object obj)
    {
        if(elementDataMap == null)
            elementDataMap = new WeakHashMap();
        elementDataMap.put(node, new SoftReference(obj));
    }

    public Object getElementData(Node node)
    {
        if(elementDataMap == null)
            return null;
        Object obj = elementDataMap.get(node);
        if(obj == null)
            return null;
        SoftReference softreference = (SoftReference)obj;
        obj = softreference.get();
        if(obj == null)
            elementDataMap.remove(node);
        return obj;
    }

    public UserAgent getUserAgent()
    {
        return userAgent;
    }

    protected void setUserAgent(UserAgent useragent)
    {
        userAgent = useragent;
    }

    public GVTBuilder getGVTBuilder()
    {
        return gvtBuilder;
    }

    protected void setGVTBuilder(GVTBuilder gvtbuilder)
    {
        gvtBuilder = gvtbuilder;
    }

    public InterpreterPool getInterpreterPool()
    {
        return interpreterPool;
    }

    public FocusManager getFocusManager()
    {
        return focusManager;
    }

    public CursorManager getCursorManager()
    {
        return cursorManager;
    }

    protected void setInterpreterPool(InterpreterPool interpreterpool)
    {
        interpreterPool = interpreterpool;
    }

    public Interpreter getInterpreter(String s)
    {
        if(document == null)
            throw new RuntimeException("Unknown document");
        Interpreter interpreter = (Interpreter)interpreterMap.get(s);
        if(interpreter == null)
            try
            {
                interpreter = interpreterPool.createInterpreter(document, s);
                interpreterMap.put(s, interpreter);
            }
            catch(Exception exception)
            {
                if(userAgent != null)
                {
                    userAgent.displayError(exception);
                    return null;
                }
            }
        if(interpreter == null && userAgent != null)
            userAgent.displayError(new Exception("Unknown language: " + s));
        return interpreter;
    }

    public DocumentLoader getDocumentLoader()
    {
        return documentLoader;
    }

    protected void setDocumentLoader(DocumentLoader documentloader)
    {
        documentLoader = documentloader;
    }

    public java.awt.geom.Dimension2D getDocumentSize()
    {
        return documentSize;
    }

    protected void setDocumentSize(java.awt.geom.Dimension2D dimension2d)
    {
        documentSize = dimension2d;
    }

    public boolean isDynamic()
    {
        return dynamicStatus == 2;
    }

    public boolean isInteractive()
    {
        return dynamicStatus != 0;
    }

    public void setDynamicState(int i)
    {
        dynamicStatus = i;
    }

    public void setDynamic(boolean flag)
    {
        if(flag)
            setDynamicState(2);
        else
            setDynamicState(0);
    }

    public void setInteractive(boolean flag)
    {
        if(flag)
            setDynamicState(1);
        else
            setDynamicState(0);
    }

    public UpdateManager getUpdateManager()
    {
        return updateManager;
    }

    protected void setUpdateManager(UpdateManager updatemanager)
    {
        updateManager = updatemanager;
    }

    public Element getReferencedElement(Element element, String s)
    {
        Element element1;
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        URIResolver uriresolver = new URIResolver(svgdocument, documentLoader);
        element1 = uriresolver.getElement(s, element);
        if(element1 == null)
            throw new BridgeException(element, "uri.badTarget", new Object[] {
                s
            });
        SVGOMDocument svgomdocument = (SVGOMDocument)element1.getOwnerDocument();
        if(svgomdocument != svgdocument)
        {
            CSSEngine cssengine = svgomdocument.getCSSEngine();
            if(cssengine == null)
            {
                BridgeContext bridgecontext = new BridgeContext(getUserAgent(), getDocumentLoader());
                bridgecontext.setGVTBuilder(getGVTBuilder());
                bridgecontext.setDocument(svgomdocument);
                bridgecontext.initializeDocument(svgomdocument);
            }
        }
        return element1;
        Object obj;
        obj;
        throw new BridgeException(element, "uri.malformed", new Object[] {
            s
        });
        obj;
        throw new InterruptedBridgeException();
        obj;
        throw new BridgeException(element, "uri.io", new Object[] {
            s
        });
        obj;
        throw new BridgeException(element, "uri.referenceDocument", new Object[] {
            s
        });
        obj;
        throw new BridgeException(element, "uri.unsecure", new Object[] {
            s
        });
    }

    public Viewport getViewport(Element element)
    {
        if(viewportStack != null)
            if(viewportStack.size() == 0)
                return (Viewport)viewportMap.get(userAgent);
            else
                return (Viewport)viewportStack.get(0);
        for(element = SVGUtilities.getParentElement(element); element != null; element = SVGUtilities.getParentElement(element))
        {
            Viewport viewport = (Viewport)viewportMap.get(element);
            if(viewport != null)
                return viewport;
        }

        return (Viewport)viewportMap.get(userAgent);
    }

    public void openViewport(Element element, Viewport viewport)
    {
        viewportMap.put(element, viewport);
        if(viewportStack == null)
            viewportStack = new LinkedList();
        viewportStack.add(0, viewport);
    }

    public void removeViewport(Element element)
    {
        viewportMap.remove(element);
    }

    public void closeViewport(Element element)
    {
        viewportStack.remove(0);
        if(viewportStack.size() == 0)
            viewportStack = null;
    }

    public void bind(Element element, GraphicsNode graphicsnode)
    {
        if(elementNodeMap == null)
        {
            elementNodeMap = new WeakHashMap();
            nodeElementMap = new WeakHashMap();
        }
        elementNodeMap.put(element, new SoftReference(graphicsnode));
        nodeElementMap.put(graphicsnode, new SoftReference(element));
    }

    public void unbind(Element element)
    {
        if(elementNodeMap == null)
            return;
        GraphicsNode graphicsnode = null;
        SoftReference softreference = (SoftReference)elementNodeMap.get(element);
        if(softreference != null)
            graphicsnode = (GraphicsNode)softreference.get();
        elementNodeMap.remove(element);
        if(graphicsnode != null)
            nodeElementMap.remove(graphicsnode);
    }

    public GraphicsNode getGraphicsNode(Element element)
    {
        if(elementNodeMap != null)
        {
            SoftReference softreference = (SoftReference)elementNodeMap.get(element);
            if(softreference != null)
                return (GraphicsNode)softreference.get();
        }
        return null;
    }

    public Element getElement(GraphicsNode graphicsnode)
    {
        if(nodeElementMap != null)
        {
            SoftReference softreference = (SoftReference)nodeElementMap.get(graphicsnode);
            if(softreference != null)
                return (Element)softreference.get();
        }
        return null;
    }

    public boolean hasGraphicsNodeBridge(Element element)
    {
        if(namespaceURIMap == null || element == null)
            return false;
        String s = element.getLocalName();
        String s1 = element.getNamespaceURI();
        s1 = s1 != null ? s1 : "";
        HashMap hashmap = (HashMap)namespaceURIMap.get(s1);
        if(hashmap == null)
            return false;
        else
            return hashmap.get(s) instanceof GraphicsNodeBridge;
    }

    public Bridge getBridge(Element element)
    {
        if(namespaceURIMap == null || element == null)
        {
            return null;
        } else
        {
            String s = element.getLocalName();
            String s1 = element.getNamespaceURI();
            s1 = s1 != null ? s1 : "";
            return getBridge(s1, s);
        }
    }

    public Bridge getBridge(String s, String s1)
    {
        HashMap hashmap = (HashMap)namespaceURIMap.get(s);
        if(hashmap == null)
            return null;
        Bridge bridge = (Bridge)hashmap.get(s1);
        if(isDynamic())
            return bridge != null ? bridge.getInstance() : null;
        else
            return bridge;
    }

    public void putBridge(String s, String s1, Bridge bridge)
    {
        if(!s.equals(bridge.getNamespaceURI()) || !s1.equals(bridge.getLocalName()))
            throw new Error("Invalid Bridge: " + s + "/" + bridge.getNamespaceURI() + " " + s1 + "/" + bridge.getLocalName() + " " + bridge.getClass());
        if(namespaceURIMap == null)
            namespaceURIMap = new HashMap();
        s = s != null ? s : "";
        HashMap hashmap = (HashMap)namespaceURIMap.get(s);
        if(hashmap == null)
        {
            hashmap = new HashMap();
            namespaceURIMap.put(s, hashmap);
        }
        hashmap.put(s1, bridge);
    }

    public void putBridge(Bridge bridge)
    {
        putBridge(bridge.getNamespaceURI(), bridge.getLocalName(), bridge);
    }

    public void removeBridge(String s, String s1)
    {
        if(namespaceURIMap == null)
            return;
        s = s != null ? s : "";
        HashMap hashmap = (HashMap)namespaceURIMap.get(s);
        if(hashmap != null)
        {
            hashmap.remove(s1);
            if(hashmap.isEmpty())
            {
                namespaceURIMap.remove(s);
                if(namespaceURIMap.isEmpty())
                    namespaceURIMap = null;
            }
        }
    }

    public void addUIEventListeners(Document document1)
    {
        EventTarget eventtarget = (EventTarget)document1.getDocumentElement();
        DOMMouseOverEventListener dommouseovereventlistener = new DOMMouseOverEventListener();
        eventtarget.addEventListener("mouseover", dommouseovereventlistener, true);
        storeEventListener(eventtarget, "mouseover", dommouseovereventlistener, true);
        DOMMouseOutEventListener dommouseouteventlistener = new DOMMouseOutEventListener();
        eventtarget.addEventListener("mouseout", dommouseouteventlistener, true);
        storeEventListener(eventtarget, "mouseout", dommouseouteventlistener, true);
    }

    public void removeUIEventListeners(Document document1)
    {
        EventTarget eventtarget = (EventTarget)document1.getDocumentElement();
        synchronized(eventListenerSet)
        {
            Iterator iterator = eventListenerSet.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                EventListenerMememto eventlistenermememto = (EventListenerMememto)iterator.next();
                EventTarget eventtarget1 = eventlistenermememto.getTarget();
                if(eventtarget1 == eventtarget)
                {
                    EventListener eventlistener = eventlistenermememto.getListener();
                    boolean flag = eventlistenermememto.getUseCapture();
                    String s = eventlistenermememto.getEventType();
                    if(eventtarget1 != null && eventlistener != null && s != null)
                        eventtarget1.removeEventListener(s, eventlistener, flag);
                }
            } while(true);
        }
    }

    public void addDOMListeners()
    {
        EventTarget eventtarget = (EventTarget)document;
        domAttrModifiedEventListener = new DOMAttrModifiedEventListener();
        eventtarget.addEventListener("DOMAttrModified", domAttrModifiedEventListener, true);
        domNodeInsertedEventListener = new DOMNodeInsertedEventListener();
        eventtarget.addEventListener("DOMNodeInserted", domNodeInsertedEventListener, true);
        domNodeRemovedEventListener = new DOMNodeRemovedEventListener();
        eventtarget.addEventListener("DOMNodeRemoved", domNodeRemovedEventListener, true);
        domCharacterDataModifiedListener = new DOMCharacterDataModifiedListener();
        eventtarget.addEventListener("DOMCharacterDataModified", domCharacterDataModifiedListener, true);
        focusManager = new FocusManager(document);
        SVGOMDocument svgomdocument = (SVGOMDocument)document;
        CSSEngine cssengine = svgomdocument.getCSSEngine();
        cssPropertiesChangedListener = new CSSPropertiesChangedListener();
        cssengine.addCSSEngineListener(cssPropertiesChangedListener);
    }

    protected void storeEventListener(EventTarget eventtarget, String s, EventListener eventlistener, boolean flag)
    {
        synchronized(eventListenerSet)
        {
            eventListenerSet.add(new EventListenerMememto(eventtarget, s, eventlistener, flag, this));
        }
    }

    public void dispose()
    {
        synchronized(eventListenerSet)
        {
            Iterator iterator1 = eventListenerSet.iterator();
            do
            {
                if(!iterator1.hasNext())
                    break;
                EventListenerMememto eventlistenermememto = (EventListenerMememto)iterator1.next();
                EventTarget eventtarget1 = eventlistenermememto.getTarget();
                EventListener eventlistener = eventlistenermememto.getListener();
                boolean flag = eventlistenermememto.getUseCapture();
                String s = eventlistenermememto.getEventType();
                if(eventtarget1 != null && eventlistener != null && s != null)
                    eventtarget1.removeEventListener(s, eventlistener, flag);
            } while(true);
        }
        if(document != null)
        {
            EventTarget eventtarget = (EventTarget)document;
            eventtarget.removeEventListener("DOMAttrModified", domAttrModifiedEventListener, true);
            eventtarget.removeEventListener("DOMNodeInserted", domNodeInsertedEventListener, true);
            eventtarget.removeEventListener("DOMNodeRemoved", domNodeRemovedEventListener, true);
            eventtarget.removeEventListener("DOMCharacterDataModified", domCharacterDataModifiedListener, true);
            SVGOMDocument svgomdocument = (SVGOMDocument)document;
            CSSEngine cssengine = svgomdocument.getCSSEngine();
            if(cssengine != null)
            {
                cssengine.removeCSSEngineListener(cssPropertiesChangedListener);
                cssengine.dispose();
                svgomdocument.setCSSEngine(null);
            }
        }
        Iterator iterator = interpreterMap.values().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Interpreter interpreter = (Interpreter)iterator.next();
            if(interpreter != null)
                interpreter.dispose();
        } while(true);
        interpreterMap.clear();
        if(focusManager != null)
            focusManager.dispose();
    }

    protected static SVGContext getSVGContext(Node node)
    {
        if(node instanceof SVGOMElement)
            return ((SVGOMElement)node).getSVGContext();
        else
            return null;
    }

    protected static BridgeUpdateHandler getBridgeUpdateHandler(Node node)
    {
        SVGContext svgcontext = getSVGContext(node);
        return svgcontext != null ? (BridgeUpdateHandler)svgcontext : null;
    }

    public Value getSystemColor(String s)
    {
        return SystemColorSupport.getSystemColor(s);
    }

    public Value getDefaultFontFamily()
    {
        SVGOMDocument svgomdocument = (SVGOMDocument)document;
        SVGStylableElement svgstylableelement = (SVGStylableElement)svgomdocument.getRootElement();
        String s = userAgent.getDefaultFontFamily();
        return svgomdocument.getCSSEngine().parsePropertyValue(svgstylableelement, "font-family", s);
    }

    public float getLighterFontWeight(float f)
    {
        return userAgent.getLighterFontWeight(f);
    }

    public float getBolderFontWeight(float f)
    {
        return userAgent.getBolderFontWeight(f);
    }

    public float getPixelUnitToMillimeter()
    {
        return userAgent.getPixelUnitToMillimeter();
    }

    public float getPixelToMillimeter()
    {
        return getPixelUnitToMillimeter();
    }

    public float getMediumFontSize()
    {
        return userAgent.getMediumFontSize();
    }

    public float getBlockWidth(Element element)
    {
        return getViewport(element).getWidth();
    }

    public float getBlockHeight(Element element)
    {
        return getViewport(element).getHeight();
    }

    public void checkLoadExternalResource(ParsedURL parsedurl, ParsedURL parsedurl1)
        throws SecurityException
    {
        userAgent.checkLoadExternalResource(parsedurl, parsedurl1);
    }

    public boolean isDynamicDocument(Document document1)
    {
        return BaseScriptingEnvironment.isDynamicDocument(this, document1);
    }

    public boolean isInteractiveDocument(Document document1)
    {
        org.w3c.dom.svg.SVGSVGElement svgsvgelement = ((SVGDocument)document1).getRootElement();
        if(!"http://www.w3.org/2000/svg".equals(svgsvgelement.getNamespaceURI()))
            return false;
        else
            return checkInteractiveElement(svgsvgelement);
    }

    public boolean checkInteractiveElement(Element element)
    {
        return checkInteractiveElement((SVGDocument)element.getOwnerDocument(), element);
    }

    public boolean checkInteractiveElement(SVGDocument svgdocument, Element element)
    {
        String s = element.getLocalName();
        if("a".equals(s))
            return true;
        if("title".equals(s))
            return element.getParentNode() != svgdocument.getRootElement();
        if("desc".equals(s))
            return element.getParentNode() != svgdocument.getRootElement();
        if("cursor".equals(s))
            return true;
        if(element.getAttribute("cursor").length() > 0)
            return true;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            if("http://www.w3.org/2000/svg".equals(element1.getNamespaceURI()) && checkInteractiveElement(element1))
                return true;
        }

        return false;
    }

    public void registerSVGBridges()
    {
        UserAgent useragent = getUserAgent();
        List list = getBridgeExtensions(document);
        BridgeExtension bridgeextension;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); useragent.registerExtension(bridgeextension))
        {
            bridgeextension = (BridgeExtension)iterator.next();
            bridgeextension.registerTags(this);
        }

    }

    public List getBridgeExtensions(Document document1)
    {
        org.w3c.dom.svg.SVGSVGElement svgsvgelement = ((SVGOMDocument)document1).getRootElement();
        String s = svgsvgelement.getAttributeNS(null, "version");
        Object obj;
        if(s.length() == 0 || s.equals("1.0") || s.equals("1.1"))
            obj = new SVGBridgeExtension();
        else
            obj = new SVG12BridgeExtension();
        float f = ((BridgeExtension) (obj)).getPriority();
        extensions = new LinkedList(getGlobalBridgeExtensions());
        ListIterator listiterator = extensions.listIterator();
        do
        {
            if(!listiterator.hasNext())
            {
                listiterator.add(obj);
                break;
            }
            BridgeExtension bridgeextension = (BridgeExtension)listiterator.next();
            if(bridgeextension.getPriority() <= f)
                continue;
            listiterator.previous();
            listiterator.add(obj);
            break;
        } while(true);
        return extensions;
    }

    public static synchronized List getGlobalBridgeExtensions()
    {
        if(globalExtensions != null)
            return globalExtensions;
        globalExtensions = new LinkedList();
        Iterator iterator = Service.providers(org.apache.batik.bridge.BridgeExtension.class);
label0:
        do
        {
            if(!iterator.hasNext())
                break;
            BridgeExtension bridgeextension = (BridgeExtension)iterator.next();
            float f = bridgeextension.getPriority();
            ListIterator listiterator = globalExtensions.listIterator();
            BridgeExtension bridgeextension1;
            do
            {
                if(!listiterator.hasNext())
                {
                    listiterator.add(bridgeextension);
                    continue label0;
                }
                bridgeextension1 = (BridgeExtension)listiterator.next();
            } while(bridgeextension1.getPriority() <= f);
            listiterator.previous();
            listiterator.add(bridgeextension);
        } while(true);
        return globalExtensions;
    }

    protected Document document;
    protected GVTBuilder gvtBuilder;
    protected Map interpreterMap;
    private Map fontFamilyMap;
    protected Map viewportMap;
    protected List viewportStack;
    protected UserAgent userAgent;
    protected Map elementNodeMap;
    protected Map nodeElementMap;
    protected Map namespaceURIMap;
    protected Map elementDataMap;
    protected InterpreterPool interpreterPool;
    protected DocumentLoader documentLoader;
    protected java.awt.geom.Dimension2D documentSize;
    protected TextPainter textPainter;
    public static final int STATIC = 0;
    public static final int INTERACTIVE = 1;
    public static final int DYNAMIC = 2;
    protected int dynamicStatus;
    protected UpdateManager updateManager;
    private static InterpreterPool sharedPool = new InterpreterPool();
    protected Set eventListenerSet;
    protected EventListener domCharacterDataModifiedListener;
    protected EventListener domAttrModifiedEventListener;
    protected EventListener domNodeInsertedEventListener;
    protected EventListener domNodeRemovedEventListener;
    protected CSSEngineListener cssPropertiesChangedListener;
    protected FocusManager focusManager;
    protected CursorManager cursorManager;
    protected List extensions;
    protected static List globalExtensions = null;

}
