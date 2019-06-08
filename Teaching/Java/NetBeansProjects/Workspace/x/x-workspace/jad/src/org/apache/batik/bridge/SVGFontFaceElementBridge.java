// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.LinkedList;
import java.util.List;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ErrorConstants, SVGUtilities, BridgeException, 
//            SVGFontFace, BridgeContext

public class SVGFontFaceElementBridge extends AbstractSVGBridge
    implements ErrorConstants
{

    public SVGFontFaceElementBridge()
    {
    }

    public String getLocalName()
    {
        return "font-face";
    }

    public SVGFontFace createFontFace(BridgeContext bridgecontext, Element element)
    {
        String s = element.getAttributeNS(null, "font-family");
        String s1 = element.getAttributeNS(null, "units-per-em");
        if(s1.length() == 0)
            s1 = "1000";
        float f;
        try
        {
            f = SVGUtilities.convertSVGNumber(s1);
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "units-per-em", s1
            });
        }
        String s2 = element.getAttributeNS(null, "font-weight");
        if(s2.length() == 0)
            s2 = "all";
        String s3 = element.getAttributeNS(null, "font-style");
        if(s3.length() == 0)
            s3 = "all";
        String s4 = element.getAttributeNS(null, "font-variant");
        if(s4.length() == 0)
            s4 = "normal";
        String s5 = element.getAttributeNS(null, "font-stretch");
        if(s5.length() == 0)
            s5 = "normal";
        String s6 = element.getAttributeNS(null, "slope");
        if(s6.length() == 0)
            s6 = "0";
        float f1;
        try
        {
            f1 = SVGUtilities.convertSVGNumber(s6);
        }
        catch(NumberFormatException numberformatexception1)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s6
            });
        }
        String s7 = element.getAttributeNS(null, "panose-1");
        if(s7.length() == 0)
            s7 = "0 0 0 0 0 0 0 0 0 0";
        String s8 = element.getAttributeNS(null, "ascent");
        if(s8.length() == 0)
            s8 = String.valueOf((double)f * 0.80000000000000004D);
        float f2;
        try
        {
            f2 = SVGUtilities.convertSVGNumber(s8);
        }
        catch(NumberFormatException numberformatexception2)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s8
            });
        }
        String s9 = element.getAttributeNS(null, "descent");
        if(s9.length() == 0)
            s9 = String.valueOf((double)f * 0.20000000000000001D);
        float f3;
        try
        {
            f3 = SVGUtilities.convertSVGNumber(s9);
        }
        catch(NumberFormatException numberformatexception3)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s9
            });
        }
        String s10 = element.getAttributeNS(null, "underline-position");
        if(s10.length() == 0)
            s10 = String.valueOf((-3F * f) / 40F);
        float f4;
        try
        {
            f4 = SVGUtilities.convertSVGNumber(s10);
        }
        catch(NumberFormatException numberformatexception4)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s10
            });
        }
        String s11 = element.getAttributeNS(null, "underline-thickness");
        if(s11.length() == 0)
            s11 = String.valueOf(f / 20F);
        float f5;
        try
        {
            f5 = SVGUtilities.convertSVGNumber(s11);
        }
        catch(NumberFormatException numberformatexception5)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s11
            });
        }
        String s12 = element.getAttributeNS(null, "strikethrough-position");
        if(s12.length() == 0)
            s12 = String.valueOf((3F * f2) / 8F);
        float f6;
        try
        {
            f6 = SVGUtilities.convertSVGNumber(s12);
        }
        catch(NumberFormatException numberformatexception6)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s12
            });
        }
        String s13 = element.getAttributeNS(null, "strikethrough-thickness");
        if(s13.length() == 0)
            s13 = String.valueOf(f / 20F);
        float f7;
        try
        {
            f7 = SVGUtilities.convertSVGNumber(s13);
        }
        catch(NumberFormatException numberformatexception7)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s13
            });
        }
        String s14 = element.getAttributeNS(null, "overline-position");
        if(s14.length() == 0)
            s14 = String.valueOf(f2);
        float f8;
        try
        {
            f8 = SVGUtilities.convertSVGNumber(s14);
        }
        catch(NumberFormatException numberformatexception8)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s14
            });
        }
        String s15 = element.getAttributeNS(null, "overline-thickness");
        if(s15.length() == 0)
            s15 = String.valueOf(f / 20F);
        float f9;
        try
        {
            f9 = SVGUtilities.convertSVGNumber(s15);
        }
        catch(NumberFormatException numberformatexception9)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "0", s15
            });
        }
        List list = null;
        Element element1 = SVGUtilities.getParentElement(element);
        if(!element1.getNamespaceURI().equals("http://www.w3.org/2000/svg") || !element1.getLocalName().equals("font"))
            list = getFontFaceSrcs(element);
        return new SVGFontFace(element, list, s, f, s2, s3, s4, s5, f1, s7, f2, f3, f6, f7, f4, f5, f8, f9);
    }

    public List getFontFaceSrcs(Element element)
    {
        Element element1 = null;
        Object obj = element.getFirstChild();
        do
        {
            if(obj == null)
                break;
            if(((Node) (obj)).getNodeType() == 1 && ((Node) (obj)).getNamespaceURI().equals("http://www.w3.org/2000/svg") && ((Node) (obj)).getLocalName().equals("font-face-src"))
            {
                element1 = (Element)obj;
                break;
            }
            obj = ((Node) (obj)).getNextSibling();
        } while(true);
        if(element1 == null)
            return null;
        obj = new LinkedList();
        for(Node node = element1.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1 || !node.getNamespaceURI().equals("http://www.w3.org/2000/svg"))
                continue;
            if(node.getLocalName().equals("font-face-uri"))
            {
                Element element2 = (Element)node;
                String s = XLinkSupport.getXLinkHref(element2);
                String s2 = XMLBaseSupport.getCascadedXMLBase(element2);
                ParsedURL parsedurl;
                if(s2 != null)
                    parsedurl = new ParsedURL(s2, s);
                else
                    parsedurl = new ParsedURL(s);
                ((List) (obj)).add(parsedurl);
                continue;
            }
            if(!node.getLocalName().equals("font-face-name"))
                continue;
            Element element3 = (Element)node;
            String s1 = element3.getAttribute("name");
            if(s1.length() != 0)
                ((List) (obj)).add(s1);
        }

        return ((List) (obj));
    }
}
