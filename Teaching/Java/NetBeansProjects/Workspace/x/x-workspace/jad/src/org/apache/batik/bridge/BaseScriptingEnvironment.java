// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.script.*;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.*;
import org.w3c.dom.events.*;
import org.w3c.dom.svg.*;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, BridgeExtension, DocumentJarClassLoader, UserAgent, 
//            DocumentLoader, Messages

public class BaseScriptingEnvironment
{
    protected class Window
        implements org.apache.batik.script.Window
    {

        public Object setInterval(String s, long l)
        {
            return null;
        }

        public Object setInterval(Runnable runnable, long l)
        {
            return null;
        }

        public void clearInterval(Object obj)
        {
        }

        public Object setTimeout(String s, long l)
        {
            return null;
        }

        public Object setTimeout(Runnable runnable, long l)
        {
            return null;
        }

        public void clearTimeout(Object obj)
        {
        }

        public Node parseXML(String s, Document document1)
        {
            return null;
        }

        public void getURL(String s, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler)
        {
            getURL(s, urlresponsehandler, "UTF8");
        }

        public void getURL(String s, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler, String s1)
        {
        }

        public void postURL(String s, String s1, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler)
        {
            postURL(s, s1, urlresponsehandler, "text/plain", null);
        }

        public void postURL(String s, String s1, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler, String s2)
        {
            postURL(s, s1, urlresponsehandler, s2, null);
        }

        public void postURL(String s, String s1, org.apache.batik.script.Window.URLResponseHandler urlresponsehandler, String s2, String s3)
        {
        }

        public void alert(String s)
        {
        }

        public boolean confirm(String s)
        {
            return false;
        }

        public String prompt(String s)
        {
            return null;
        }

        public String prompt(String s, String s1)
        {
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

        public Window(Interpreter interpreter1, String s)
        {
            interpreter = interpreter1;
            language = s;
        }
    }


    public static boolean isDynamicDocument(BridgeContext bridgecontext, Document document1)
    {
        Element element = document1.getDocumentElement();
        if(element != null && "http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
        {
            if(element.getAttributeNS(null, "onabort").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onerror").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onresize").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onunload").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onscroll").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onzoom").length() > 0)
                return true;
            else
                return isDynamicElement(bridgecontext, document1.getDocumentElement());
        } else
        {
            return false;
        }
    }

    public static boolean isDynamicElement(BridgeContext bridgecontext, Element element)
    {
        List list = bridgecontext.getBridgeExtensions(element.getOwnerDocument());
        return isDynamicElement(element, bridgecontext, list);
    }

    public static boolean isDynamicElement(Element element, BridgeContext bridgecontext, List list)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            BridgeExtension bridgeextension = (BridgeExtension)iterator.next();
            if(bridgeextension.isDynamicElement(element))
                return true;
        }

        if("http://www.w3.org/2000/svg".equals(element.getNamespaceURI()))
        {
            if(element.getAttributeNS(null, "onkeyup").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onkeydown").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onkeypress").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onload").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onerror").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onactivate").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onclick").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onfocusin").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onfocusout").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onmousedown").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onmousemove").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onmouseout").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onmouseover").length() > 0)
                return true;
            if(element.getAttributeNS(null, "onmouseup").length() > 0)
                return true;
        }
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1 && isDynamicElement(bridgecontext, (Element)node))
                return true;

        return false;
    }

    public BaseScriptingEnvironment(BridgeContext bridgecontext)
    {
        languages = new HashSet();
        bridgeContext = bridgecontext;
        document = bridgecontext.getDocument();
        docPURL = new ParsedURL(((SVGDocument)document).getURL());
        userAgent = bridgeContext.getUserAgent();
    }

    public org.apache.batik.script.Window createWindow(Interpreter interpreter1, String s)
    {
        return new Window(interpreter1, s);
    }

    public org.apache.batik.script.Window createWindow()
    {
        return createWindow(null, null);
    }

    public Interpreter getInterpreter()
    {
        if(interpreter != null)
        {
            return interpreter;
        } else
        {
            SVGSVGElement svgsvgelement = (SVGSVGElement)document.getDocumentElement();
            String s = svgsvgelement.getContentScriptType();
            return getInterpreter(s);
        }
    }

    public Interpreter getInterpreter(String s)
    {
        interpreter = bridgeContext.getInterpreter(s);
        if(interpreter == null)
            if(languages.contains(s))
            {
                return null;
            } else
            {
                languages.add(s);
                return null;
            }
        if(!languages.contains(s))
        {
            languages.add(s);
            initializeEnvironment(interpreter, s);
        }
        return interpreter;
    }

    public void initializeEnvironment(Interpreter interpreter1, String s)
    {
        interpreter1.bindObject("window", createWindow(interpreter1, s));
    }

    public void loadScripts()
    {
        org.apache.batik.script.Window window;
        NodeList nodelist;
        int i;
        int j;
        window = null;
        nodelist = document.getElementsByTagNameNS("http://www.w3.org/2000/svg", "script");
        i = nodelist.getLength();
        if(i == 0)
            return;
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        Element element;
        String s;
        element = (Element)nodelist.item(j);
        s = element.getAttributeNS(null, "type");
        if(s.length() == 0)
            s = "text/ecmascript";
        if(!s.equals("application/java-archive"))
            break MISSING_BLOCK_LABEL_333;
        String s1 = XLinkSupport.getXLinkHref(element);
        ParsedURL parsedurl = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(element), s1);
        checkCompatibleScriptURL(s, parsedurl);
        URL url = null;
        try
        {
            url = new URL(docPURL.toString());
        }
        catch(MalformedURLException malformedurlexception) { }
        DocumentJarClassLoader documentjarclassloader = new DocumentJarClassLoader(new URL(parsedurl.toString()), url);
        URL url1 = documentjarclassloader.findResource("META-INF/MANIFEST.MF");
        if(url1 == null)
            continue; /* Loop/switch isn't completed */
        try
        {
            Manifest manifest = new Manifest(url1.openStream());
            String s4 = manifest.getMainAttributes().getValue("Script-Handler");
            if(s4 != null)
            {
                ScriptHandler scripthandler = (ScriptHandler)documentjarclassloader.loadClass(s4).newInstance();
                if(window == null)
                    window = createWindow();
                scripthandler.run(document, window);
            }
            s4 = manifest.getMainAttributes().getValue("SVG-Handler-Class");
            if(s4 == null)
                continue; /* Loop/switch isn't completed */
            EventListenerInitializer eventlistenerinitializer = (EventListenerInitializer)documentjarclassloader.loadClass(s4).newInstance();
            if(window == null)
                window = createWindow();
            eventlistenerinitializer.initializeEventListeners((SVGDocument)document);
            continue; /* Loop/switch isn't completed */
        }
        catch(Exception exception)
        {
            if(userAgent != null)
                userAgent.displayError(exception);
        }
        continue; /* Loop/switch isn't completed */
        Interpreter interpreter1;
        interpreter1 = getInterpreter(s);
        if(interpreter1 == null)
            continue; /* Loop/switch isn't completed */
        String s3;
        Object obj;
        String s2 = XLinkSupport.getXLinkHref(element);
        s3 = null;
        if(s2.length() > 0)
        {
            s3 = s2;
            ParsedURL parsedurl1 = new ParsedURL(XMLBaseSupport.getCascadedXMLBase(element), s2);
            checkCompatibleScriptURL(s, parsedurl1);
            obj = new InputStreamReader(parsedurl1.openStream());
        } else
        {
            checkCompatibleScriptURL(s, docPURL);
            DocumentLoader documentloader = bridgeContext.getDocumentLoader();
            Element element1 = element;
            SVGDocument svgdocument = (SVGDocument)element1.getOwnerDocument();
            int k = documentloader.getLineNumber(element);
            s3 = Messages.formatMessage("BaseScriptingEnvironment.constant.inline.script.description", new Object[] {
                svgdocument.getURL(), "<" + element.getNodeName() + ">", new Integer(k)
            });
            Node node = element.getFirstChild();
            if(node == null)
                continue; /* Loop/switch isn't completed */
            StringBuffer stringbuffer = new StringBuffer();
            for(; node != null; node = node.getNextSibling())
                if(node.getNodeType() == 4 || node.getNodeType() == 3)
                    stringbuffer.append(node.getNodeValue());

            obj = new StringReader(stringbuffer.toString());
        }
        try
        {
            interpreter1.evaluate(((java.io.Reader) (obj)), s3);
            continue; /* Loop/switch isn't completed */
        }
        catch(IOException ioexception)
        {
            if(userAgent != null)
                userAgent.displayError(ioexception);
            return;
        }
        catch(InterpreterException interpreterexception)
        {
            System.err.println("InterpExcept: " + interpreterexception);
            handleInterpreterException(interpreterexception);
            return;
        }
        catch(SecurityException securityexception)
        {
            if(userAgent != null)
                userAgent.displayError(securityexception);
        }
        j++;
          goto _L3
_L2:
    }

    protected void checkCompatibleScriptURL(String s, ParsedURL parsedurl)
    {
        userAgent.checkLoadScript(s, parsedurl, docPURL);
    }

    public void dispatchSVGLoadEvent()
    {
        SVGSVGElement svgsvgelement = (SVGSVGElement)document.getDocumentElement();
        String s = svgsvgelement.getContentScriptType();
        dispatchSVGLoad(svgsvgelement, true, s);
    }

    protected void dispatchSVGLoad(Element element, boolean flag, String s1)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if(node.getNodeType() == 1)
                dispatchSVGLoad((Element)node, flag, s1);

        DocumentEvent documentevent = (DocumentEvent)element.getOwnerDocument();
        Event event = documentevent.createEvent("SVGEvents");
        event.initEvent("SVGLoad", false, false);
        EventTarget eventtarget = (EventTarget)element;
        final String s = element.getAttributeNS(null, "onload");
        if(s.length() == 0)
        {
            eventtarget.dispatchEvent(event);
            return;
        }
        final Interpreter interp = getInterpreter();
        if(interp == null)
        {
            eventtarget.dispatchEvent(event);
            return;
        }
        if(flag)
        {
            checkCompatibleScriptURL(s1, docPURL);
            flag = false;
        }
        DocumentLoader documentloader = bridgeContext.getDocumentLoader();
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        int i = documentloader.getLineNumber(element);
        final String desc = Messages.formatMessage("BaseScriptingEnvironment.constant.event.script.description", new Object[] {
            svgdocument.getURL(), "onload", new Integer(i)
        });
        EventListener eventlistener = new EventListener() {

            public void handleEvent(Event event1)
            {
                try
                {
                    interp.bindObject("event", event1);
                    interp.bindObject("evt", event1);
                    interp.evaluate(new StringReader(s), desc);
                }
                catch(IOException ioexception) { }
                catch(InterpreterException interpreterexception)
                {
                    handleInterpreterException(interpreterexception);
                }
            }

        };
        eventtarget.addEventListener("SVGLoad", eventlistener, false);
        eventtarget.dispatchEvent(event);
        eventtarget.removeEventListener("SVGLoad", eventlistener, false);
    }

    protected void dispatchSVGZoomEvent()
    {
        dispatchSVGDocEvent("SVGZoom");
    }

    protected void dispatchSVGScrollEvent()
    {
        dispatchSVGDocEvent("SVGScroll");
    }

    protected void dispatchSVGResizeEvent()
    {
        dispatchSVGDocEvent("SVGResize");
    }

    protected void dispatchSVGDocEvent(String s)
    {
        SVGSVGElement svgsvgelement = (SVGSVGElement)document.getDocumentElement();
        SVGSVGElement svgsvgelement1 = svgsvgelement;
        DocumentEvent documentevent = (DocumentEvent)document;
        Event event = documentevent.createEvent("SVGEvents");
        event.initEvent(s, false, false);
        svgsvgelement1.dispatchEvent(event);
    }

    protected void handleInterpreterException(InterpreterException interpreterexception)
    {
        if(userAgent != null)
        {
            Exception exception = interpreterexception.getException();
            userAgent.displayError(((Exception) (exception != null ? exception : ((Exception) (interpreterexception)))));
        }
    }

    protected void handleSecurityException(SecurityException securityexception)
    {
        if(userAgent != null)
            userAgent.displayError(securityexception);
    }

    public static final String INLINE_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.inline.script.description";
    public static final String EVENT_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.event.script.description";
    protected static final String EVENT_NAME = "event";
    protected static final String ALTERNATE_EVENT_NAME = "evt";
    protected BridgeContext bridgeContext;
    protected UserAgent userAgent;
    protected Document document;
    protected ParsedURL docPURL;
    protected Set languages;
    protected Interpreter interpreter;
}
