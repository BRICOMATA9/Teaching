// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.SAXDocumentFactory;
import org.apache.batik.script.*;
import org.apache.batik.util.*;
import org.w3c.dom.*;
import org.w3c.dom.events.*;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            BaseScriptingEnvironment, BridgeContext, UpdateManager, DocumentLoader, 
//            Messages, SVGUtilities, UserAgent

public class ScriptingEnvironment extends BaseScriptingEnvironment
{
    protected class ScriptingEventListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            Element element = (Element)event.getCurrentTarget();
            String s = element.getAttributeNS(null, attribute);
            if(s.length() == 0)
                return;
            DocumentLoader documentloader = bridgeContext.getDocumentLoader();
            SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
            int i = documentloader.getLineNumber(element);
            String s1 = Messages.formatMessage("BaseScriptingEnvironment.constant.event.script.description", new Object[] {
                svgdocument.getURL(), attribute, new Integer(i)
            });
            Element element1;
            for(element1 = element; element1 != null && (!"http://www.w3.org/2000/svg".equals(element1.getNamespaceURI()) || !"svg".equals(element1.getLocalName())); element1 = SVGUtilities.getParentElement(element1));
            if(element1 == null)
            {
                return;
            } else
            {
                String s2 = element1.getAttributeNS(null, "contentScriptType");
                runEventHandler(s, event, s2, s1);
                return;
            }
        }

        protected String attribute;

        public ScriptingEventListener(String s)
        {
            attribute = s;
        }
    }

    protected class DOMAttrModifiedListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            MutationEvent mutationevent = (MutationEvent)event;
            if(mutationevent.getAttrChange() != 1)
                updateScriptingListeners((Element)mutationevent.getTarget(), mutationevent.getAttrName());
        }

        protected DOMAttrModifiedListener()
        {
        }
    }

    protected class DOMNodeRemovedListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            removeScriptingListeners((Node)event.getTarget());
        }

        protected DOMNodeRemovedListener()
        {
        }
    }

    protected class DOMNodeInsertedListener
        implements EventListener
    {

        public void handleEvent(Event event)
        {
            addScriptingListeners((Node)event.getTarget());
        }

        protected DOMNodeInsertedListener()
        {
        }
    }

    protected class Window
        implements org.apache.batik.script.Window
    {

        public Object setInterval(final String script, long l)
        {
            TimerTask timertask = new TimerTask() {

                public void run()
                {
label0:
                    {
                        synchronized(eir)
                        {
                            if(eir.count <= 1)
                                break label0;
                        }
                        return;
                    }
                    eir.count++;
                    evaluateintervalrunnable;
                    JVM INSTR monitorexit ;
                      goto _L1
                    exception;
                    throw exception;
_L1:
label1:
                    {
                        synchronized(updateRunnableQueue.getIteratorLock())
                        {
                            if(updateRunnableQueue.getThread() != null)
                                break label1;
                            cancel();
                        }
                        return;
                    }
                    updateRunnableQueue.invokeLater(eir);
                    obj;
                    JVM INSTR monitorexit ;
                      goto _L2
                    exception1;
                    throw exception1;
_L2:
                    synchronized(eir)
                    {
                        if(eir.error)
                            cancel();
                    }
                    return;
                }

                EvaluateIntervalRunnable eir;

                
                {
                    eir = new EvaluateIntervalRunnable(script, interpreter);
                }
            };
            timer.schedule(timertask, l, l);
            return timertask;
        }

        public Object setInterval(final Runnable r, long l)
        {
            TimerTask timertask = new TimerTask() {

                public void run()
                {
label0:
                    {
                        synchronized(eihr)
                        {
                            if(eihr.count <= 1)
                                break label0;
                        }
                        return;
                    }
                    eihr.count++;
                    evaluaterunnablerunnable;
                    JVM INSTR monitorexit ;
                      goto _L1
                    exception;
                    throw exception;
_L1:
                    updateRunnableQueue.invokeLater(eihr);
                    synchronized(eihr)
                    {
                        if(eihr.error)
                            cancel();
                    }
                    return;
                }

                EvaluateRunnableRunnable eihr;

                
                {
                    eihr = new EvaluateRunnableRunnable(r);
                }
            };
            timer.schedule(timertask, l, l);
            return timertask;
        }

        public void clearInterval(Object obj)
        {
            if(obj == null)
            {
                return;
            } else
            {
                ((TimerTask)obj).cancel();
                return;
            }
        }

        public Object setTimeout(final String script, long l)
        {
            TimerTask timertask = new TimerTask() {

                public void run()
                {
                    updateRunnableQueue.invokeLater(new EvaluateRunnable(script, interpreter));
                }

            };
            timer.schedule(timertask, l);
            return timertask;
        }

        public Object setTimeout(final Runnable r, long l)
        {
            TimerTask timertask = new TimerTask() {

                public void run()
                {
                    updateRunnableQueue.invokeLater(new Runnable() {

                        public void run()
                        {
                            try
                            {
                                r.run();
                            }
                            catch(Exception exception)
                            {
                                if(userAgent != null)
                                    userAgent.displayError(exception);
                            }
                        }

                    });
                }



            };
            timer.schedule(timertask, l);
            return timertask;
        }

        public void clearTimeout(Object obj)
        {
            if(obj == null)
            {
                return;
            } else
            {
                ((TimerTask)obj).cancel();
                return;
            }
        }

        public Node parseXML(String s, Document document)
        {
            SAXSVGDocumentFactory saxsvgdocumentfactory;
            String s1;
            saxsvgdocumentfactory = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());
            URL url = null;
            if(document != null && (document instanceof SVGOMDocument))
                url = ((SVGOMDocument)document).getURLObject();
            if(url == null)
                url = ((SVGOMDocument)bridgeContext.getDocument()).getURLObject();
            s1 = url != null ? url.toString() : "";
            Object obj = saxsvgdocumentfactory.createDocument(s1, new StringReader(s));
            if(document == null)
                return ((Node) (obj));
            Object obj1;
            obj1 = document.createDocumentFragment();
            ((Node) (obj1)).appendChild(document.importNode(((Document) (obj)).getDocumentElement(), true));
            return ((Node) (obj1));
            Exception exception;
            exception;
            if(document == null || !(document instanceof SVGOMDocument))
                break MISSING_BLOCK_LABEL_301;
            exception = new StringBuffer("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'>".length() + s.length() + "</svg>".length());
            exception.append("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'>");
            exception.append(s);
            exception.append("</svg>");
            obj1 = exception.toString();
            Node node;
            Document document1 = saxsvgdocumentfactory.createDocument(s1, new StringReader(((String) (obj1))));
            if(document == null)
                document = document1;
            node = document1.getDocumentElement().getFirstChild();
_L1:
            org.w3c.dom.DocumentFragment documentfragment1;
            if(node == null)
                break MISSING_BLOCK_LABEL_301;
            if(node.getNodeType() != 1)
                break MISSING_BLOCK_LABEL_284;
            node = document.importNode(node, true);
            documentfragment1 = document.createDocumentFragment();
            documentfragment1.appendChild(node);
            return documentfragment1;
            node = node.getNextSibling();
              goto _L1
            Exception exception2;
            exception2;
            if(document != null)
                exception = new SAXDocumentFactory(document.getImplementation(), XMLResourceDescriptor.getXMLParserClassName());
            else
                exception = new SAXDocumentFactory(new GenericDOMImplementation(), XMLResourceDescriptor.getXMLParserClassName());
            obj1 = exception.createDocument(s1, new StringReader(s));
            if(document == null)
                return ((Node) (obj1));
            org.w3c.dom.DocumentFragment documentfragment;
            documentfragment = document.createDocumentFragment();
            documentfragment.appendChild(document.importNode(((Document) (obj1)).getDocumentElement(), true));
            return documentfragment;
            Exception exception1;
            exception1;
            if(userAgent != null)
                userAgent.displayError(exception1);
            return null;
        }

        public void getURL(String s, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler)
        {
            getURL(s, urlresponsehandler, null);
        }

        public void getURL(final String uri, final org.apache.batik.script.Window.URLResponseHandler h, final String enc)
        {
            Thread thread = new Thread() {

                public void run()
                {
                    try
                    {
                        URL url = ((SVGOMDocument)document).getURLObject();
                        final ParsedURL purl = new ParsedURL(url, uri);
                        String s = null;
                        if(enc != null)
                        {
                            s = EncodingUtilities.javaEncoding(enc);
                            s = s != null ? s : enc;
                        }
                        java.io.InputStream inputstream = purl.openStream();
                        Object obj;
                        if(s == null)
                            obj = new InputStreamReader(inputstream);
                        else
                            try
                            {
                                obj = new InputStreamReader(inputstream, s);
                            }
                            catch(UnsupportedEncodingException unsupportedencodingexception)
                            {
                                obj = new InputStreamReader(inputstream);
                            }
                        obj = new BufferedReader(((Reader) (obj)));
                        final StringBuffer sb = new StringBuffer();
                        char ac[] = new char[4096];
                        int i;
                        while((i = ((Reader) (obj)).read(ac, 0, ac.length)) != -1) 
                            sb.append(ac, 0, i);
                        ((Reader) (obj)).close();
                        updateRunnableQueue.invokeLater(new Runnable() {

                            public void run()
                            {
                                try
                                {
                                    h.getURLDone(true, purl.getContentType(), sb.toString());
                                }
                                catch(Exception exception1)
                                {
                                    if(userAgent != null)
                                        userAgent.displayError(exception1);
                                }
                            }

                        });
                    }
                    catch(Exception exception)
                    {
                        if(exception instanceof SecurityException)
                            userAgent.displayError(exception);
                        updateRunnableQueue.invokeLater(new Runnable() {

                            public void run()
                            {
                                try
                                {
                                    h.getURLDone(false, null, null);
                                }
                                catch(Exception exception1)
                                {
                                    if(userAgent != null)
                                        userAgent.displayError(exception1);
                                }
                            }

                        });
                    }
                }



            };
            thread.setPriority(1);
            thread.start();
        }

        public void postURL(String s, String s1, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler)
        {
            postURL(s, s1, urlresponsehandler, "text/plain", null);
        }

        public void postURL(String s, String s1, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler, String s2)
        {
            postURL(s, s1, urlresponsehandler, s2, null);
        }

        public void postURL(final String uri, final String content, final org.apache.batik.script.Window.URLResponseHandler h, final String mimeType, final String fEnc)
        {
            Thread thread = new Thread() {

                public void run()
                {
                    try
                    {
                        URL url = ((SVGOMDocument)document).getURLObject();
                        URL url1;
                        if(url != null)
                            url1 = new URL(url, uri);
                        else
                            url1 = new URL(uri);
                        final URLConnection conn = url1.openConnection();
                        conn.setDoOutput(true);
                        conn.setDoInput(true);
                        conn.setUseCaches(false);
                        conn.setRequestProperty("Content-Type", mimeType);
                        Object obj = conn.getOutputStream();
                        String s = null;
                        String s1 = fEnc;
                        if(s1 != null)
                        {
                            if(s1.startsWith("deflate"))
                            {
                                obj = new DeflaterOutputStream(((OutputStream) (obj)));
                                if(s1.length() > "deflate".length())
                                    s1 = s1.substring("deflate".length() + 1);
                                else
                                    s1 = "";
                                conn.setRequestProperty("Content-Encoding", "deflate");
                            }
                            if(s1.startsWith("gzip"))
                            {
                                obj = new GZIPOutputStream(((OutputStream) (obj)));
                                if(s1.length() > "gzip".length())
                                    s1 = s1.substring("gzip".length() + 1);
                                else
                                    s1 = "";
                                conn.setRequestProperty("Content-Encoding", "deflate");
                            }
                            if(s1.length() != 0)
                            {
                                s = EncodingUtilities.javaEncoding(s1);
                                if(s == null)
                                    s = "UTF-8";
                            } else
                            {
                                s = "UTF-8";
                            }
                        }
                        OutputStreamWriter outputstreamwriter;
                        if(s == null)
                            outputstreamwriter = new OutputStreamWriter(((OutputStream) (obj)));
                        else
                            outputstreamwriter = new OutputStreamWriter(((OutputStream) (obj)), s);
                        outputstreamwriter.write(content);
                        outputstreamwriter.flush();
                        outputstreamwriter.close();
                        ((OutputStream) (obj)).close();
                        java.io.InputStream inputstream = conn.getInputStream();
                        s = "UTF-8";
                        Object obj1;
                        if(s == null)
                            obj1 = new InputStreamReader(inputstream);
                        else
                            obj1 = new InputStreamReader(inputstream, s);
                        obj1 = new BufferedReader(((Reader) (obj1)));
                        final StringBuffer sb = new StringBuffer();
                        char ac[] = new char[4096];
                        int i;
                        while((i = ((Reader) (obj1)).read(ac, 0, ac.length)) != -1) 
                            sb.append(ac, 0, i);
                        ((Reader) (obj1)).close();
                        updateRunnableQueue.invokeLater(new Runnable() {

                            public void run()
                            {
                                try
                                {
                                    h.getURLDone(true, conn.getContentType(), sb.toString());
                                }
                                catch(Exception exception1)
                                {
                                    if(userAgent != null)
                                        userAgent.displayError(exception1);
                                }
                            }

                        });
                    }
                    catch(Exception exception)
                    {
                        if(exception instanceof SecurityException)
                            userAgent.displayError(exception);
                        updateRunnableQueue.invokeLater(new Runnable() {

                            public void run()
                            {
                                try
                                {
                                    h.getURLDone(false, null, null);
                                }
                                catch(Exception exception1)
                                {
                                    if(userAgent != null)
                                        userAgent.displayError(exception1);
                                }
                            }

                        });
                    }
                }



            };
            thread.setPriority(1);
            thread.start();
        }

        public void alert(String s)
        {
            if(userAgent != null)
                userAgent.showAlert(s);
        }

        public boolean confirm(String s)
        {
            if(userAgent != null)
                return userAgent.showConfirm(s);
            else
                return false;
        }

        public String prompt(String s)
        {
            if(userAgent != null)
                return userAgent.showPrompt(s);
            else
                return null;
        }

        public String prompt(String s, String s1)
        {
            if(userAgent != null)
                return userAgent.showPrompt(s, s1);
            else
                return null;
        }

        public BridgeContext getBridgeContext()
        {
            return bridgeContext;
        }

        public Interpreter getInterpreter()
        {
            return interpreter;
        }

        protected Interpreter interpreter;
        protected String language;
        static final String DEFLATE = "deflate";
        static final String GZIP = "gzip";
        static final String UTF_8 = "UTF-8";


        public Window(Interpreter interpreter1, String s)
        {
            interpreter = interpreter1;
            language = s;
        }
    }

    protected class EvaluateRunnableRunnable
        implements Runnable
    {

        public void run()
        {
label0:
            {
                synchronized(this)
                {
                    if(!error)
                        break label0;
                }
                return;
            }
            count--;
            evaluaterunnablerunnable;
            JVM INSTR monitorexit ;
              goto _L1
            exception1;
            throw exception1;
_L1:
            try
            {
                runnable.run();
            }
            catch(Exception exception)
            {
                if(userAgent != null)
                    userAgent.displayError(exception);
                else
                    exception.printStackTrace();
                synchronized(this)
                {
                    error = true;
                }
            }
            return;
        }

        public int count;
        public boolean error;
        protected Runnable runnable;

        public EvaluateRunnableRunnable(Runnable runnable1)
        {
            runnable = runnable1;
        }
    }

    protected class EvaluateIntervalRunnable
        implements Runnable
    {

        public void run()
        {
label0:
            {
                synchronized(this)
                {
                    if(!error)
                        break label0;
                }
                return;
            }
            count--;
            evaluateintervalrunnable;
            JVM INSTR monitorexit ;
              goto _L1
            exception1;
            throw exception1;
_L1:
            try
            {
                interpreter.evaluate(script);
            }
            catch(InterpreterException interpreterexception)
            {
                handleInterpreterException(interpreterexception);
                synchronized(this)
                {
                    error = true;
                }
            }
            catch(Exception exception)
            {
                if(userAgent != null)
                    userAgent.displayError(exception);
                else
                    exception.printStackTrace();
                synchronized(this)
                {
                    error = true;
                }
            }
            return;
        }

        public int count;
        public boolean error;
        protected Interpreter interpreter;
        protected String script;

        public EvaluateIntervalRunnable(String s, Interpreter interpreter1)
        {
            interpreter = interpreter1;
            script = s;
        }
    }

    protected class EvaluateRunnable
        implements Runnable
    {

        public void run()
        {
            try
            {
                interpreter.evaluate(script);
            }
            catch(InterpreterException interpreterexception)
            {
                handleInterpreterException(interpreterexception);
            }
        }

        protected Interpreter interpreter;
        protected String script;

        public EvaluateRunnable(String s, Interpreter interpreter1)
        {
            interpreter = interpreter1;
            script = s;
        }
    }


    public ScriptingEnvironment(BridgeContext bridgecontext)
    {
        super(bridgecontext);
        timer = new Timer(true);
        domNodeInsertedListener = new DOMNodeInsertedListener();
        domNodeRemovedListener = new DOMNodeRemovedListener();
        domAttrModifiedListener = new DOMAttrModifiedListener();
        svgAbortListener = new ScriptingEventListener("onabort");
        svgErrorListener = new ScriptingEventListener("onerror");
        svgResizeListener = new ScriptingEventListener("onresize");
        svgScrollListener = new ScriptingEventListener("onscroll");
        svgUnloadListener = new ScriptingEventListener("onunload");
        svgZoomListener = new ScriptingEventListener("onzoom");
        beginListener = new ScriptingEventListener("onbegin");
        endListener = new ScriptingEventListener("onend");
        repeatListener = new ScriptingEventListener("onrepeat");
        focusinListener = new ScriptingEventListener("onfocusin");
        focusoutListener = new ScriptingEventListener("onfocusout");
        activateListener = new ScriptingEventListener("onactivate");
        clickListener = new ScriptingEventListener("onclick");
        mousedownListener = new ScriptingEventListener("onmousedown");
        mouseupListener = new ScriptingEventListener("onmouseup");
        mouseoverListener = new ScriptingEventListener("onmouseover");
        mouseoutListener = new ScriptingEventListener("onmouseout");
        mousemoveListener = new ScriptingEventListener("onmousemove");
        keypressListener = new ScriptingEventListener("onkeypress");
        keydownListener = new ScriptingEventListener("onkeydown");
        keyupListener = new ScriptingEventListener("onkeyup");
        listeners = (new EventListener[] {
            svgAbortListener, svgErrorListener, svgResizeListener, svgScrollListener, svgUnloadListener, svgZoomListener, beginListener, endListener, repeatListener, focusinListener, 
            focusoutListener, activateListener, clickListener, mousedownListener, mouseupListener, mouseoverListener, mouseoutListener, mousemoveListener, keypressListener, keydownListener, 
            keyupListener
        });
        attrToDOMEvent = new HashMap(SVG_EVENT_ATTRS.length);
        attrToListener = new HashMap(SVG_EVENT_ATTRS.length);
        for(int i = 0; i < SVG_EVENT_ATTRS.length; i++)
        {
            attrToDOMEvent.put(SVG_EVENT_ATTRS[i], SVG_DOM_EVENT[i]);
            attrToListener.put(SVG_EVENT_ATTRS[i], listeners[i]);
        }

        updateManager = bridgecontext.getUpdateManager();
        updateRunnableQueue = updateManager.getUpdateRunnableQueue();
        addScriptingListeners(document.getDocumentElement());
        EventTarget eventtarget = (EventTarget)document;
        eventtarget.addEventListener("DOMNodeInserted", domNodeInsertedListener, false);
        eventtarget.addEventListener("DOMNodeRemoved", domNodeRemovedListener, false);
        eventtarget.addEventListener("DOMAttrModified", domAttrModifiedListener, false);
    }

    public org.apache.batik.script.Window createWindow(Interpreter interpreter, String s)
    {
        return new Window(interpreter, s);
    }

    public void runEventHandler(String s, Event event, String s1, String s2)
    {
        Interpreter interpreter = getInterpreter(s1);
        if(interpreter == null)
            return;
        try
        {
            checkCompatibleScriptURL(s1, docPURL);
            interpreter.bindObject("event", event);
            interpreter.bindObject("evt", event);
            interpreter.evaluate(new StringReader(s), s2);
        }
        catch(IOException ioexception) { }
        catch(InterpreterException interpreterexception)
        {
            handleInterpreterException(interpreterexception);
        }
        catch(SecurityException securityexception)
        {
            handleSecurityException(securityexception);
        }
    }

    public void interrupt()
    {
        timer.cancel();
        removeScriptingListeners(document.getDocumentElement());
        EventTarget eventtarget = (EventTarget)document;
        eventtarget.removeEventListener("DOMNodeInserted", domNodeInsertedListener, false);
        eventtarget.removeEventListener("DOMNodeRemoved", domNodeRemovedListener, false);
        eventtarget.removeEventListener("DOMAttrModified", domAttrModifiedListener, false);
    }

    protected void addScriptingListeners(Node node)
    {
        if(node.getNodeType() == 1)
        {
            Element element = (Element)node;
            EventTarget eventtarget = (EventTarget)element;
            if("http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
                if("svg".equals(element.getLocalName()))
                {
                    if(element.hasAttributeNS(null, "onabort"))
                        eventtarget.addEventListener("SVGAbort", svgAbortListener, false);
                    if(element.hasAttributeNS(null, "onerror"))
                        eventtarget.addEventListener("SVGError", svgErrorListener, false);
                    if(element.hasAttributeNS(null, "onresize"))
                        eventtarget.addEventListener("SVGResize", svgResizeListener, false);
                    if(element.hasAttributeNS(null, "onscroll"))
                        eventtarget.addEventListener("SVGScroll", svgScrollListener, false);
                    if(element.hasAttributeNS(null, "onunload"))
                        eventtarget.addEventListener("SVGUnload", svgUnloadListener, false);
                    if(element.hasAttributeNS(null, "onzoom"))
                        eventtarget.addEventListener("SVGZoom", svgZoomListener, false);
                } else
                {
                    String s = element.getLocalName();
                    if(s.equals("set") || s.startsWith("animate"))
                    {
                        if(element.hasAttributeNS(null, "onbegin"))
                            eventtarget.addEventListener("beginEvent", beginListener, false);
                        if(element.hasAttributeNS(null, "onend"))
                            eventtarget.addEventListener("endEvent", endListener, false);
                        if(element.hasAttributeNS(null, "onrepeat"))
                            eventtarget.addEventListener("repeatEvent", repeatListener, false);
                        return;
                    }
                }
            if(element.hasAttributeNS(null, "onfocusin"))
                eventtarget.addEventListener("DOMFocusIn", focusinListener, false);
            if(element.hasAttributeNS(null, "onfocusout"))
                eventtarget.addEventListener("DOMFocusOut", focusoutListener, false);
            if(element.hasAttributeNS(null, "onactivate"))
                eventtarget.addEventListener("DOMActivate", activateListener, false);
            if(element.hasAttributeNS(null, "onclick"))
                eventtarget.addEventListener("click", clickListener, false);
            if(element.hasAttributeNS(null, "onmousedown"))
                eventtarget.addEventListener("mousedown", mousedownListener, false);
            if(element.hasAttributeNS(null, "onmouseup"))
                eventtarget.addEventListener("mouseup", mouseupListener, false);
            if(element.hasAttributeNS(null, "onmouseover"))
                eventtarget.addEventListener("mouseover", mouseoverListener, false);
            if(element.hasAttributeNS(null, "onmouseout"))
                eventtarget.addEventListener("mouseout", mouseoutListener, false);
            if(element.hasAttributeNS(null, "onmousemove"))
                eventtarget.addEventListener("mousemove", mousemoveListener, false);
            if(element.hasAttributeNS(null, "onkeypress"))
                eventtarget.addEventListener("keypress", keypressListener, false);
            if(element.hasAttributeNS(null, "onkeydown"))
                eventtarget.addEventListener("keydown", keydownListener, false);
            if(element.hasAttributeNS(null, "onkeyup"))
                eventtarget.addEventListener("keyup", keyupListener, false);
        }
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
            addScriptingListeners(node1);

    }

    protected void removeScriptingListeners(Node node)
    {
        if(node.getNodeType() == 1)
        {
            Element element = (Element)node;
            EventTarget eventtarget = (EventTarget)element;
            if("http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
                if("svg".equals(element.getLocalName()))
                {
                    eventtarget.removeEventListener("SVGAbort", svgAbortListener, false);
                    eventtarget.removeEventListener("SVGError", svgErrorListener, false);
                    eventtarget.removeEventListener("SVGResize", svgResizeListener, false);
                    eventtarget.removeEventListener("SVGScroll", svgScrollListener, false);
                    eventtarget.removeEventListener("SVGUnload", svgUnloadListener, false);
                    eventtarget.removeEventListener("SVGZoom", svgZoomListener, false);
                } else
                {
                    String s = element.getLocalName();
                    if(s.equals("set") || s.startsWith("animate"))
                    {
                        eventtarget.removeEventListener("beginEvent", beginListener, false);
                        eventtarget.removeEventListener("endEvent", endListener, false);
                        eventtarget.removeEventListener("repeatEvent", repeatListener, false);
                        return;
                    }
                }
            eventtarget.removeEventListener("DOMFocusIn", focusinListener, false);
            eventtarget.removeEventListener("DOMFocusOut", focusoutListener, false);
            eventtarget.removeEventListener("DOMActivate", activateListener, false);
            eventtarget.removeEventListener("click", clickListener, false);
            eventtarget.removeEventListener("mousedown", mousedownListener, false);
            eventtarget.removeEventListener("mouseup", mouseupListener, false);
            eventtarget.removeEventListener("mouseover", mouseoverListener, false);
            eventtarget.removeEventListener("mouseout", mouseoutListener, false);
            eventtarget.removeEventListener("mousemove", mousemoveListener, false);
            eventtarget.removeEventListener("keypress", keypressListener, false);
            eventtarget.removeEventListener("keydown", keydownListener, false);
            eventtarget.removeEventListener("keyup", keyupListener, false);
        }
        for(Node node1 = node.getFirstChild(); node1 != null; node1 = node1.getNextSibling())
            removeScriptingListeners(node1);

    }

    protected void updateScriptingListeners(Element element, String s)
    {
        String s1 = (String)attrToDOMEvent.get(s);
        if(s1 == null)
            return;
        EventListener eventlistener = (EventListener)attrToListener.get(s);
        EventTarget eventtarget = (EventTarget)element;
        if(element.hasAttributeNS(null, s))
            eventtarget.addEventListener(s1, eventlistener, false);
        else
            eventtarget.removeEventListener(s1, eventlistener, false);
    }

    protected static final String FRAGMENT_PREFIX = "<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'>";
    protected static final String FRAGMENT_SUFFIX = "</svg>";
    public static final String SVG_EVENT_ATTRS[] = {
        "onabort", "onerror", "onresize", "onscroll", "onunload", "onzoom", "onbegin", "onend", "onrepeat", "onfocusin", 
        "onfocusout", "onactivate", "onclick", "onmousedown", "onmouseup", "onmouseover", "onmouseout", "onmousemove", "onkeypress", "onkeydown", 
        "onkeyup"
    };
    public static final String SVG_DOM_EVENT[] = {
        "SVGAbort", "SVGError", "SVGResize", "SVGScroll", "SVGUnload", "SVGZoom", "beginEvent", "endEvent", "repeatEvent", "DOMFocusIn", 
        "DOMFocusOut", "DOMActivate", "click", "mousedown", "mouseup", "mouseover", "mouseout", "mousemove", "keypress", "keydown", 
        "keyup"
    };
    protected Timer timer;
    protected UpdateManager updateManager;
    protected RunnableQueue updateRunnableQueue;
    protected EventListener domNodeInsertedListener;
    protected EventListener domNodeRemovedListener;
    protected EventListener domAttrModifiedListener;
    protected EventListener svgAbortListener;
    protected EventListener svgErrorListener;
    protected EventListener svgResizeListener;
    protected EventListener svgScrollListener;
    protected EventListener svgUnloadListener;
    protected EventListener svgZoomListener;
    protected EventListener beginListener;
    protected EventListener endListener;
    protected EventListener repeatListener;
    protected EventListener focusinListener;
    protected EventListener focusoutListener;
    protected EventListener activateListener;
    protected EventListener clickListener;
    protected EventListener mousedownListener;
    protected EventListener mouseupListener;
    protected EventListener mouseoverListener;
    protected EventListener mouseoutListener;
    protected EventListener mousemoveListener;
    protected EventListener keypressListener;
    protected EventListener keydownListener;
    protected EventListener keyupListener;
    protected EventListener listeners[];
    Map attrToDOMEvent;
    Map attrToListener;

}
