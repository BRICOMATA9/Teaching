// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.font.GVTFontFace;
import org.apache.batik.gvt.text.ArabicTextHandler;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, SVGGVTFont, BridgeContext

public class SVGFontElementBridge extends AbstractSVGBridge
{

    public SVGFontElementBridge()
    {
    }

    public String getLocalName()
    {
        return "font";
    }

    public SVGGVTFont createFont(BridgeContext bridgecontext, Element element, Element element1, float f, GVTFontFace gvtfontface)
    {
        NodeList nodelist = element.getElementsByTagNameNS("http://www.w3.org/2000/svg", "glyph");
        int i = nodelist.getLength();
        String as[] = new String[i];
        String as1[] = new String[i];
        String as2[] = new String[i];
        String as3[] = new String[i];
        String as4[] = new String[i];
        Element aelement[] = new Element[i];
        for(int j = 0; j < i; j++)
        {
            Element element2 = (Element)nodelist.item(j);
            as[j] = element2.getAttributeNS(null, "unicode");
            if(as[j].length() > 1 && ArabicTextHandler.arabicChar(as[j].charAt(0)))
                as[j] = (new StringBuffer(as[j])).reverse().toString();
            as1[j] = element2.getAttributeNS(null, "glyph-name");
            as2[j] = element2.getAttributeNS(null, "lang");
            as3[j] = element2.getAttributeNS(null, "orientation");
            as4[j] = element2.getAttributeNS(null, "arabic-form");
            aelement[j] = element2;
        }

        NodeList nodelist1 = element.getElementsByTagNameNS("http://www.w3.org/2000/svg", "missing-glyph");
        Element element3 = null;
        if(nodelist1.getLength() > 0)
            element3 = (Element)nodelist1.item(0);
        NodeList nodelist2 = element.getElementsByTagNameNS("http://www.w3.org/2000/svg", "hkern");
        Element aelement1[] = new Element[nodelist2.getLength()];
        for(int k = 0; k < aelement1.length; k++)
        {
            Element element4 = (Element)nodelist2.item(k);
            aelement1[k] = element4;
        }

        NodeList nodelist3 = element.getElementsByTagNameNS("http://www.w3.org/2000/svg", "vkern");
        Element aelement2[] = new Element[nodelist3.getLength()];
        for(int l = 0; l < aelement2.length; l++)
        {
            Element element5 = (Element)nodelist3.item(l);
            aelement2[l] = element5;
        }

        return new SVGGVTFont(f, gvtfontface, as, as1, as2, as3, as4, bridgecontext, aelement, element3, aelement1, aelement2, element1);
    }
}
