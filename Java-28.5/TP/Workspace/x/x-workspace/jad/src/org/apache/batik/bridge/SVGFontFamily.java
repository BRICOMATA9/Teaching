// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.text.AttributedCharacterIterator;
import java.util.Map;
import org.apache.batik.gvt.font.*;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, SVGFontElementBridge, GraphicsNodeBridge

public class SVGFontFamily
    implements GVTFontFamily
{

    public SVGFontFamily(GVTFontFace gvtfontface, Element element, BridgeContext bridgecontext)
    {
        complex = null;
        fontFace = gvtfontface;
        fontElement = element;
        ctx = bridgecontext;
    }

    public String getFamilyName()
    {
        return fontFace.getFamilyName();
    }

    public GVTFontFace getFontFace()
    {
        return fontFace;
    }

    public GVTFont deriveFont(float f, AttributedCharacterIterator attributedcharacteriterator)
    {
        return deriveFont(f, attributedcharacteriterator.getAttributes());
    }

    public GVTFont deriveFont(float f, Map map)
    {
        SVGFontElementBridge svgfontelementbridge = (SVGFontElementBridge)ctx.getBridge(fontElement);
        Element element = (Element)map.get(TEXT_COMPOUND_DELIMITER);
        return svgfontelementbridge.createFont(ctx, fontElement, element, f, fontFace);
    }

    public boolean isComplex()
    {
        if(complex != null)
        {
            return complex.booleanValue();
        } else
        {
            boolean flag = isComplex(fontElement, ctx);
            complex = new Boolean(flag);
            return flag;
        }
    }

    public static boolean isComplex(Element element, BridgeContext bridgecontext)
    {
        NodeList nodelist = element.getElementsByTagNameNS("http://www.w3.org/2000/svg", "glyph");
        int i = nodelist.getLength();
        for(int j = 0; j < i; j++)
        {
            Element element1 = (Element)nodelist.item(j);
            for(Node node = element1.getFirstChild(); node != null; node = node.getNextSibling())
            {
                if(node.getNodeType() != 1)
                    continue;
                Element element2 = (Element)node;
                Bridge bridge = bridgecontext.getBridge(element2);
                if(bridge != null && (bridge instanceof GraphicsNodeBridge))
                    return true;
            }

        }

        return false;
    }

    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER;
    protected GVTFontFace fontFace;
    protected Element fontElement;
    protected BridgeContext ctx;
    protected Boolean complex;

    static 
    {
        TEXT_COMPOUND_DELIMITER = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.TEXT_COMPOUND_DELIMITER;
    }
}
