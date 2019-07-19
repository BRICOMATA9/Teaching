// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.List;
import org.apache.batik.gvt.font.GVTFontFamily;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            FontFace, SVGUtilities, SVGFontFamily, BridgeContext

public class SVGFontFace extends FontFace
{

    public SVGFontFace(Element element, List list, String s, float f, String s1, String s2, String s3, 
            String s4, float f1, String s5, float f2, float f3, float f4, float f5, 
            float f6, float f7, float f8, float f9)
    {
        super(list, s, f, s1, s2, s3, s4, f1, s5, f2, f3, f4, f5, f6, f7, f8, f9);
        fontFamily = null;
        fontFaceElement = element;
    }

    public GVTFontFamily getFontFamily(BridgeContext bridgecontext)
    {
        if(fontFamily != null)
            return fontFamily;
        Element element = SVGUtilities.getParentElement(fontFaceElement);
        if(element.getNamespaceURI().equals("http://www.w3.org/2000/svg") && element.getLocalName().equals("font"))
        {
            return new SVGFontFamily(this, element, bridgecontext);
        } else
        {
            fontFamily = super.getFontFamily(bridgecontext);
            return fontFamily;
        }
    }

    public Element getFontFaceElement()
    {
        return fontFaceElement;
    }

    protected Element getBaseElement(BridgeContext bridgecontext)
    {
        if(fontFaceElement != null)
            return fontFaceElement;
        else
            return super.getBaseElement(bridgecontext);
    }

    Element fontFaceElement;
    GVTFontFamily fontFamily;
}
