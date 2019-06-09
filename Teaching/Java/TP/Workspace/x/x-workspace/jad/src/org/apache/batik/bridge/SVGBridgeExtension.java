// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            BridgeExtension, SVGFeComponentTransferElementBridge, AbstractSVGLightingElementBridge, SVGFeMergeElementBridge, 
//            AbstractSVGGradientElementBridge, SVGAElementBridge, BridgeContext, SVGAltGlyphElementBridge, 
//            SVGCircleElementBridge, SVGClipPathElementBridge, SVGColorProfileElementBridge, SVGDescElementBridge, 
//            SVGEllipseElementBridge, SVGFeBlendElementBridge, SVGFeColorMatrixElementBridge, SVGFeCompositeElementBridge, 
//            SVGFeConvolveMatrixElementBridge, SVGFeDiffuseLightingElementBridge, SVGFeDisplacementMapElementBridge, SVGFeFloodElementBridge, 
//            SVGFeGaussianBlurElementBridge, SVGFeImageElementBridge, SVGFeMorphologyElementBridge, SVGFeOffsetElementBridge, 
//            SVGFeSpecularLightingElementBridge, SVGFeTileElementBridge, SVGFeTurbulenceElementBridge, SVGFontElementBridge, 
//            SVGFontFaceElementBridge, SVGFilterElementBridge, SVGGElementBridge, SVGGlyphElementBridge, 
//            SVGHKernElementBridge, SVGImageElementBridge, SVGLineElementBridge, SVGLinearGradientElementBridge, 
//            SVGMarkerElementBridge, SVGMaskElementBridge, SVGMissingGlyphElementBridge, SVGPathElementBridge, 
//            SVGPatternElementBridge, SVGPolylineElementBridge, SVGPolygonElementBridge, SVGRadialGradientElementBridge, 
//            SVGRectElementBridge, SVGSVGElementBridge, SVGSwitchElementBridge, SVGTextElementBridge, 
//            SVGTextPathElementBridge, SVGTitleElementBridge, SVGUseElementBridge, SVGVKernElementBridge

public class SVGBridgeExtension
    implements BridgeExtension
{

    public SVGBridgeExtension()
    {
    }

    public float getPriority()
    {
        return 0.0F;
    }

    public Iterator getImplementedExtensions()
    {
        return Collections.EMPTY_LIST.iterator();
    }

    public String getAuthor()
    {
        return "The Apache Batik Team.";
    }

    public String getContactAddress()
    {
        return "batik-dev@xmlgraphics.apache.org";
    }

    public String getURL()
    {
        return "http://xml.apache.org/batik";
    }

    public String getDescription()
    {
        return "The required SVG 1.0 tags";
    }

    public void registerTags(BridgeContext bridgecontext)
    {
        bridgecontext.putBridge(new SVGAElementBridge());
        bridgecontext.putBridge(new SVGAltGlyphElementBridge());
        bridgecontext.putBridge(new SVGCircleElementBridge());
        bridgecontext.putBridge(new SVGClipPathElementBridge());
        bridgecontext.putBridge(new SVGColorProfileElementBridge());
        bridgecontext.putBridge(new SVGDescElementBridge());
        bridgecontext.putBridge(new SVGEllipseElementBridge());
        bridgecontext.putBridge(new SVGFeBlendElementBridge());
        bridgecontext.putBridge(new SVGFeColorMatrixElementBridge());
        bridgecontext.putBridge(new SVGFeComponentTransferElementBridge());
        bridgecontext.putBridge(new SVGFeCompositeElementBridge());
        bridgecontext.putBridge(new SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge());
        bridgecontext.putBridge(new SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge());
        bridgecontext.putBridge(new SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge());
        bridgecontext.putBridge(new SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge());
        bridgecontext.putBridge(new SVGFeConvolveMatrixElementBridge());
        bridgecontext.putBridge(new SVGFeDiffuseLightingElementBridge());
        bridgecontext.putBridge(new SVGFeDisplacementMapElementBridge());
        bridgecontext.putBridge(new AbstractSVGLightingElementBridge.SVGFeDistantLightElementBridge());
        bridgecontext.putBridge(new SVGFeFloodElementBridge());
        bridgecontext.putBridge(new SVGFeGaussianBlurElementBridge());
        bridgecontext.putBridge(new SVGFeImageElementBridge());
        bridgecontext.putBridge(new SVGFeMergeElementBridge());
        bridgecontext.putBridge(new SVGFeMergeElementBridge.SVGFeMergeNodeElementBridge());
        bridgecontext.putBridge(new SVGFeMorphologyElementBridge());
        bridgecontext.putBridge(new SVGFeOffsetElementBridge());
        bridgecontext.putBridge(new AbstractSVGLightingElementBridge.SVGFePointLightElementBridge());
        bridgecontext.putBridge(new SVGFeSpecularLightingElementBridge());
        bridgecontext.putBridge(new AbstractSVGLightingElementBridge.SVGFeSpotLightElementBridge());
        bridgecontext.putBridge(new SVGFeTileElementBridge());
        bridgecontext.putBridge(new SVGFeTurbulenceElementBridge());
        bridgecontext.putBridge(new SVGFontElementBridge());
        bridgecontext.putBridge(new SVGFontFaceElementBridge());
        bridgecontext.putBridge(new SVGFilterElementBridge());
        bridgecontext.putBridge(new SVGGElementBridge());
        bridgecontext.putBridge(new SVGGlyphElementBridge());
        bridgecontext.putBridge(new SVGHKernElementBridge());
        bridgecontext.putBridge(new SVGImageElementBridge());
        bridgecontext.putBridge(new SVGLineElementBridge());
        bridgecontext.putBridge(new SVGLinearGradientElementBridge());
        bridgecontext.putBridge(new SVGMarkerElementBridge());
        bridgecontext.putBridge(new SVGMaskElementBridge());
        bridgecontext.putBridge(new SVGMissingGlyphElementBridge());
        bridgecontext.putBridge(new SVGPathElementBridge());
        bridgecontext.putBridge(new SVGPatternElementBridge());
        bridgecontext.putBridge(new SVGPolylineElementBridge());
        bridgecontext.putBridge(new SVGPolygonElementBridge());
        bridgecontext.putBridge(new SVGRadialGradientElementBridge());
        bridgecontext.putBridge(new SVGRectElementBridge());
        bridgecontext.putBridge(new AbstractSVGGradientElementBridge.SVGStopElementBridge());
        bridgecontext.putBridge(new SVGSVGElementBridge());
        bridgecontext.putBridge(new SVGSwitchElementBridge());
        bridgecontext.putBridge(new SVGTextElementBridge());
        bridgecontext.putBridge(new SVGTextPathElementBridge());
        bridgecontext.putBridge(new SVGTitleElementBridge());
        bridgecontext.putBridge(new SVGUseElementBridge());
        bridgecontext.putBridge(new SVGVKernElementBridge());
    }

    public boolean isDynamicElement(Element element)
    {
        String s = element.getNamespaceURI();
        if(!"http://www.w3.org/2000/svg".equals(s))
            return false;
        String s1 = element.getLocalName();
        return s1.equals("script") || s1.startsWith("animate") || s1.equals("set");
    }
}
