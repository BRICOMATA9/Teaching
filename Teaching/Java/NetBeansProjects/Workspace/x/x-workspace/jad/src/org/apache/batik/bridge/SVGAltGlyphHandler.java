// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.font.FontRenderContext;
import java.text.AttributedCharacterIterator;
import org.apache.batik.gvt.font.*;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeContext, SVGAltGlyphElementBridge, UserAgent

public class SVGAltGlyphHandler
    implements AltGlyphHandler, SVGConstants
{

    public SVGAltGlyphHandler(BridgeContext bridgecontext, Element element)
    {
        ctx = bridgecontext;
        textElement = element;
    }

    public GVTGlyphVector createGlyphVector(FontRenderContext fontrendercontext, float f, AttributedCharacterIterator attributedcharacteriterator)
    {
        org.apache.batik.gvt.font.Glyph aglyph[];
        if(!"http://www.w3.org/2000/svg".equals(textElement.getNamespaceURI()) || !"altGlyph".equals(textElement.getLocalName()))
            break MISSING_BLOCK_LABEL_106;
        SVGAltGlyphElementBridge svgaltglyphelementbridge = (SVGAltGlyphElementBridge)ctx.getBridge(textElement);
        aglyph = svgaltglyphelementbridge.createAltGlyphArray(ctx, textElement, f, attributedcharacteriterator);
        if(aglyph != null)
            return new SVGGVTGlyphVector(null, aglyph, fontrendercontext);
        break MISSING_BLOCK_LABEL_106;
        SecurityException securityexception;
        securityexception;
        ctx.getUserAgent().displayError(securityexception);
        throw securityexception;
        return null;
    }

    private BridgeContext ctx;
    private Element textElement;
}
