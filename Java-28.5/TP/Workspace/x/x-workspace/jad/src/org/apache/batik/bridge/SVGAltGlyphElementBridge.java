// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.text.AttributedCharacterIterator;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.gvt.font.Glyph;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.gvt.text.TextPaintInfo;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ErrorConstants, BridgeException, BridgeContext, 
//            UserAgent, CSSUtilities, SVGFontFaceElementBridge, SVGGlyphElementBridge

public class SVGAltGlyphElementBridge extends AbstractSVGBridge
    implements ErrorConstants
{

    public SVGAltGlyphElementBridge()
    {
    }

    public String getLocalName()
    {
        return "altGlyph";
    }

    public Glyph[] createAltGlyphArray(BridgeContext bridgecontext, Element element, float f, AttributedCharacterIterator attributedcharacteriterator)
    {
        String s = XLinkSupport.getXLinkHref(element);
        Element element1 = null;
        try
        {
            element1 = bridgecontext.getReferencedElement(element, s);
        }
        catch(BridgeException bridgeexception)
        {
            if("uri.unsecure".equals(bridgeexception.getCode()))
                bridgecontext.getUserAgent().displayError(bridgeexception);
        }
        if(element1 == null)
            return null;
        if(!"http://www.w3.org/2000/svg".equals(element1.getNamespaceURI()))
            return null;
        if(element1.getLocalName().equals("glyph"))
        {
            Glyph glyph = getGlyph(bridgecontext, s, element, f, attributedcharacteriterator);
            if(glyph == null)
            {
                return null;
            } else
            {
                Glyph aglyph[] = new Glyph[1];
                aglyph[0] = glyph;
                return aglyph;
            }
        }
        if(element1.getLocalName().equals("altGlyphDef"))
        {
            SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
            SVGOMDocument svgomdocument1 = (SVGOMDocument)element1.getOwnerDocument();
            boolean flag = svgomdocument1 == svgomdocument;
            Element element2 = flag ? element1 : (Element)svgomdocument.importNode(element1, true);
            if(!flag)
            {
                String s1 = XMLBaseSupport.getCascadedXMLBase(element);
                Element element3 = svgomdocument.createElementNS("http://www.w3.org/2000/svg", "g");
                element3.appendChild(element2);
                element3.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:base", s1);
                CSSUtilities.computeStyleAndURIs(element1, element2, s);
            }
            NodeList nodelist = element2.getChildNodes();
            boolean flag1 = false;
            int i = nodelist.getLength();
            for(int j = 0; j < i; j++)
            {
                Node node = nodelist.item(j);
                if(node.getNodeType() != 1)
                    continue;
                Element element4 = (Element)node;
                if(!"http://www.w3.org/2000/svg".equals(element4.getNamespaceURI()) || !"glyphRef".equals(element4.getLocalName()))
                    continue;
                flag1 = true;
                break;
            }

            if(flag1)
            {
                NodeList nodelist1 = element2.getElementsByTagNameNS("http://www.w3.org/2000/svg", "glyphRef");
                int k = nodelist1.getLength();
                Glyph aglyph1[] = new Glyph[k];
                for(int i1 = 0; i1 < k; i1++)
                {
                    Element element5 = (Element)nodelist1.item(i1);
                    String s2 = XLinkSupport.getXLinkHref(element5);
                    Glyph glyph1 = getGlyph(bridgecontext, s2, element5, f, attributedcharacteriterator);
                    if(glyph1 == null)
                        return null;
                    aglyph1[i1] = glyph1;
                }

                return aglyph1;
            }
            NodeList nodelist2 = element2.getElementsByTagNameNS("http://www.w3.org/2000/svg", "altGlyphItem");
            int l = nodelist2.getLength();
            if(l > 0)
            {
                boolean flag2 = false;
                Glyph aglyph2[] = null;
label0:
                for(int j1 = 0; j1 < l && !flag2; j1++)
                {
                    Element element6 = (Element)nodelist2.item(j1);
                    NodeList nodelist3 = element6.getElementsByTagNameNS("http://www.w3.org/2000/svg", "glyphRef");
                    int k1 = nodelist3.getLength();
                    aglyph2 = new Glyph[k1];
                    flag2 = true;
                    int l1 = 0;
                    do
                    {
                        if(l1 >= k1)
                            continue label0;
                        Element element7 = (Element)nodelist3.item(l1);
                        String s3 = XLinkSupport.getXLinkHref(element7);
                        Glyph glyph2 = getGlyph(bridgecontext, s3, element7, f, attributedcharacteriterator);
                        if(glyph2 != null)
                        {
                            aglyph2[l1] = glyph2;
                        } else
                        {
                            flag2 = false;
                            continue label0;
                        }
                        l1++;
                    } while(true);
                }

                if(!flag2)
                    return null;
                else
                    return aglyph2;
            }
        }
        return null;
    }

    private Glyph getGlyph(BridgeContext bridgecontext, String s, Element element, float f, AttributedCharacterIterator attributedcharacteriterator)
    {
        Element element1 = null;
        try
        {
            element1 = bridgecontext.getReferencedElement(element, s);
        }
        catch(BridgeException bridgeexception)
        {
            if("uri.unsecure".equals(bridgeexception.getCode()))
                bridgecontext.getUserAgent().displayError(bridgeexception);
        }
        if(element1 == null || !"http://www.w3.org/2000/svg".equals(element1.getNamespaceURI()) || !"glyph".equals(element1.getLocalName()))
            return null;
        SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
        SVGOMDocument svgomdocument1 = (SVGOMDocument)element1.getOwnerDocument();
        boolean flag = svgomdocument1 == svgomdocument;
        Element element2 = null;
        Element element3 = null;
        Object obj = null;
        if(flag)
        {
            element2 = element1;
            Element element4 = (Element)element2.getParentNode();
            NodeList nodelist = element4.getElementsByTagNameNS("http://www.w3.org/2000/svg", "font-face");
            if(nodelist.getLength() > 0)
                element3 = (Element)nodelist.item(0);
        } else
        {
            Element element5 = (Element)svgomdocument.importNode(element1.getParentNode(), true);
            String s1 = XMLBaseSupport.getCascadedXMLBase(element);
            Element element6 = svgomdocument.createElementNS("http://www.w3.org/2000/svg", "g");
            element6.appendChild(element5);
            element6.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:base", s1);
            CSSUtilities.computeStyleAndURIs((Element)element1.getParentNode(), element5, s);
            String s2 = element1.getAttributeNS(null, "id");
            NodeList nodelist1 = element5.getElementsByTagNameNS("http://www.w3.org/2000/svg", "glyph");
            int i = 0;
            do
            {
                if(i >= nodelist1.getLength())
                    break;
                Element element7 = (Element)nodelist1.item(i);
                if(element7.getAttributeNS(null, "id").equals(s2))
                {
                    element2 = element7;
                    break;
                }
                i++;
            } while(true);
            NodeList nodelist2 = element5.getElementsByTagNameNS("http://www.w3.org/2000/svg", "font-face");
            if(nodelist2.getLength() > 0)
                element3 = (Element)nodelist2.item(0);
        }
        if(element2 == null || element3 == null)
        {
            return null;
        } else
        {
            SVGFontFaceElementBridge svgfontfaceelementbridge = (SVGFontFaceElementBridge)bridgecontext.getBridge(element3);
            SVGFontFace svgfontface = svgfontfaceelementbridge.createFontFace(bridgecontext, element3);
            SVGGlyphElementBridge svgglyphelementbridge = (SVGGlyphElementBridge)bridgecontext.getBridge(element2);
            attributedcharacteriterator.first();
            TextPaintInfo textpaintinfo = (TextPaintInfo)attributedcharacteriterator.getAttribute(PAINT_INFO);
            return svgglyphelementbridge.createGlyph(bridgecontext, element2, element, -1, f, svgfontface, textpaintinfo);
        }
    }

    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO;

    static 
    {
        PAINT_INFO = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.PAINT_INFO;
    }
}
