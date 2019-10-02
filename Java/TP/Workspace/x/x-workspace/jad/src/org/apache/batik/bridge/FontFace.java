// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.gvt.font.AWTFontFamily;
import org.apache.batik.gvt.font.FontFamilyResolver;
import org.apache.batik.gvt.font.GVTFontFace;
import org.apache.batik.gvt.font.GVTFontFamily;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, CSSFontFace, BridgeException, BridgeContext, 
//            UserAgent, CSSUtilities, SVGFontFaceElementBridge, SVGFontFamily

public abstract class FontFace extends GVTFontFace
    implements ErrorConstants
{

    public FontFace(List list, String s, float f, String s1, String s2, String s3, String s4, 
            float f1, String s5, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8, float f9)
    {
        super(s, f, s1, s2, s3, s4, f1, s5, f2, f3, f4, f5, f6, f7, f8, f9);
        srcs = list;
    }

    protected FontFace(String s)
    {
        super(s);
    }

    public static CSSFontFace createFontFace(String s, FontFace fontface)
    {
        return new CSSFontFace(new LinkedList(fontface.srcs), s, fontface.unitsPerEm, fontface.fontWeight, fontface.fontStyle, fontface.fontVariant, fontface.fontStretch, fontface.slope, fontface.panose1, fontface.ascent, fontface.descent, fontface.strikethroughPosition, fontface.strikethroughThickness, fontface.underlinePosition, fontface.underlineThickness, fontface.overlinePosition, fontface.overlineThickness);
    }

    public GVTFontFamily getFontFamily(BridgeContext bridgecontext)
    {
        Iterator iterator;
        String s = FontFamilyResolver.lookup(familyName);
        if(s != null)
        {
            CSSFontFace cssfontface = createFontFace(s, this);
            return new AWTFontFamily(cssfontface);
        }
        iterator = srcs.iterator();
_L2:
        Object obj;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        obj = iterator.next();
        if(obj instanceof String)
        {
            String s2 = (String)obj;
            String s1 = FontFamilyResolver.lookup(s2);
            if(s1 != null)
            {
                CSSFontFace cssfontface1 = createFontFace(s2, this);
                return new AWTFontFamily(cssfontface1);
            }
            continue; /* Loop/switch isn't completed */
        }
        if(!(obj instanceof ParsedURL))
            continue; /* Loop/switch isn't completed */
        GVTFontFamily gvtfontfamily = getFontFamily(bridgecontext, (ParsedURL)obj);
        if(gvtfontfamily != null)
            return gvtfontfamily;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        bridgecontext.getUserAgent().displayError(((Exception) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        if("uri.unsecure".equals(((BridgeException) (obj1)).getCode()))
            bridgecontext.getUserAgent().displayError(((Exception) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        if(true) goto _L2; else goto _L1
_L1:
        return new AWTFontFamily(this);
    }

    protected GVTFontFamily getFontFamily(BridgeContext bridgecontext, ParsedURL parsedurl)
    {
        String s = parsedurl.toString();
        Element element = getBaseElement(bridgecontext);
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        String s1 = svgdocument.getURL();
        ParsedURL parsedurl1 = null;
        if(s1 != null)
            parsedurl1 = new ParsedURL(s1);
        String s2 = XMLBaseSupport.getCascadedXMLBase(element);
        parsedurl = new ParsedURL(s2, s);
        UserAgent useragent = bridgecontext.getUserAgent();
        try
        {
            useragent.checkLoadExternalResource(parsedurl, parsedurl1);
        }
        catch(SecurityException securityexception)
        {
            useragent.displayError(securityexception);
            return null;
        }
        if(parsedurl.getRef() != null)
        {
            Element element1 = bridgecontext.getReferencedElement(element, s);
            if(!element1.getNamespaceURI().equals("http://www.w3.org/2000/svg") || !element1.getLocalName().equals("font"))
                return null;
            SVGDocument svgdocument1 = (SVGDocument)element.getOwnerDocument();
            SVGDocument svgdocument2 = (SVGDocument)element1.getOwnerDocument();
            Element element2 = element1;
            if(svgdocument1 != svgdocument2)
            {
                element2 = (Element)svgdocument1.importNode(element1, true);
                String s3 = XMLBaseSupport.getCascadedXMLBase(element1);
                Element element4 = svgdocument1.createElementNS("http://www.w3.org/2000/svg", "g");
                element4.appendChild(element2);
                element4.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:base", s3);
                CSSUtilities.computeStyleAndURIs(element1, element2, s);
            }
            Element element3 = null;
            Object obj = element2.getFirstChild();
            do
            {
                if(obj == null)
                    break;
                if(((Node) (obj)).getNodeType() == 1 && ((Node) (obj)).getNamespaceURI().equals("http://www.w3.org/2000/svg") && ((Node) (obj)).getLocalName().equals("font-face"))
                {
                    element3 = (Element)obj;
                    break;
                }
                obj = ((Node) (obj)).getNextSibling();
            } while(true);
            obj = (SVGFontFaceElementBridge)bridgecontext.getBridge("http://www.w3.org/2000/svg", "font-face");
            SVGFontFace svgfontface = ((SVGFontFaceElementBridge) (obj)).createFontFace(bridgecontext, element3);
            return new SVGFontFamily(svgfontface, element2, bridgecontext);
        }
        java.awt.Font font = java.awt.Font.createFont(0, parsedurl.openStream());
        return new AWTFontFamily(this, font);
        Exception exception;
        exception;
        return null;
    }

    protected Element getBaseElement(BridgeContext bridgecontext)
    {
        SVGDocument svgdocument = (SVGDocument)bridgecontext.getDocument();
        return svgdocument.getRootElement();
    }

    List srcs;
}
