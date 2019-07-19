// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.batik.dom.util.DOMUtilities;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.filter.GraphicsNodeRable8Bit;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, UserAgentAdapter, DocumentLoader, BridgeContext, 
//            GVTBuilder, Messages, UserAgent

public class SVGBrokenLinkProvider extends DefaultBrokenLinkProvider
    implements ErrorConstants
{

    public SVGBrokenLinkProvider()
    {
        gvtRoot = null;
        userAgent = new UserAgentAdapter();
        loader = new DocumentLoader(userAgent);
        ctx = new BridgeContext(userAgent, loader);
        Class class1 = org.apache.batik.bridge.SVGBrokenLinkProvider.class;
        URL url = class1.getResource("BrokenLink.svg");
        if(url == null)
            return;
        GVTBuilder gvtbuilder = new GVTBuilder();
        try
        {
            svgDoc = (SVGDocument)loader.loadDocument(url.toString());
            gvtRoot = gvtbuilder.build(ctx, svgDoc);
        }
        catch(Exception exception) { }
    }

    public Filter getBrokenLinkImage(Object obj, String s, Object aobj[])
    {
        if(gvtRoot == null)
        {
            return null;
        } else
        {
            String s1 = formatMessage(obj, s, aobj);
            SVGDocument svgdocument = getBrokenLinkDocument(s1);
            HashMap hashmap = new HashMap();
            hashmap.put("org.apache.batik.BrokenLinkImage", s1);
            hashmap.put("org.apache.batik.bridge.BrokenLinkDocument", svgdocument);
            return new GraphicsNodeRable8Bit(gvtRoot, hashmap);
        }
    }

    public SVGDocument getBrokenLinkDocument(Object obj, String s, Object aobj[])
    {
        String s1 = formatMessage(obj, s, aobj);
        return getBrokenLinkDocument(s1);
    }

    public SVGDocument getBrokenLinkDocument(String s)
    {
        SVGDocument svgdocument = (SVGDocument)DOMUtilities.deepCloneDocument(svgDoc, svgDoc.getImplementation());
        Element element = svgdocument.getElementById("__More_About");
        Element element1 = svgdocument.createElementNS("http://www.w3.org/2000/svg", "title");
        element1.appendChild(svgdocument.createTextNode(Messages.formatMessage("broken.link.title", null)));
        Element element2 = svgdocument.createElementNS("http://www.w3.org/2000/svg", "desc");
        element2.appendChild(svgdocument.createTextNode(s));
        element.insertBefore(element2, element.getFirstChild());
        element.insertBefore(element1, element2);
        return svgdocument;
    }

    public static final String SVG_BROKEN_LINK_DOCUMENT_PROPERTY = "org.apache.batik.bridge.BrokenLinkDocument";
    UserAgent userAgent;
    DocumentLoader loader;
    BridgeContext ctx;
    GraphicsNode gvtRoot;
    SVGDocument svgDoc;
}
