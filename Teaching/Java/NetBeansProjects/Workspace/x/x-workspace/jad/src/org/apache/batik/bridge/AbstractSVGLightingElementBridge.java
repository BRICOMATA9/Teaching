// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Color;
import java.util.StringTokenizer;
import org.apache.batik.ext.awt.image.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, CSSUtilities, BridgeContext, SVGUtilities, 
//            BridgeException, AbstractSVGBridge

public abstract class AbstractSVGLightingElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{
    public static class SVGFePointLightElementBridge extends AbstractSVGLightElementBridge
    {

        public String getLocalName()
        {
            return "fePointLight";
        }

        public Light createLight(BridgeContext bridgecontext, Element element, Element element1, Color color)
        {
            double d = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "x", 0.0F);
            double d1 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "y", 0.0F);
            double d2 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "z", 0.0F);
            return new PointLight(d, d1, d2, color);
        }

        public SVGFePointLightElementBridge()
        {
        }
    }

    public static class SVGFeDistantLightElementBridge extends AbstractSVGLightElementBridge
    {

        public String getLocalName()
        {
            return "feDistantLight";
        }

        public Light createLight(BridgeContext bridgecontext, Element element, Element element1, Color color)
        {
            double d = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "azimuth", 0.0F);
            double d1 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "elevation", 0.0F);
            return new DistantLight(d, d1, color);
        }

        public SVGFeDistantLightElementBridge()
        {
        }
    }

    public static class SVGFeSpotLightElementBridge extends AbstractSVGLightElementBridge
    {

        public String getLocalName()
        {
            return "feSpotLight";
        }

        public Light createLight(BridgeContext bridgecontext, Element element, Element element1, Color color)
        {
            double d = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "x", 0.0F);
            double d1 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "y", 0.0F);
            double d2 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "z", 0.0F);
            double d3 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "pointsAtX", 0.0F);
            double d4 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "pointsAtY", 0.0F);
            double d5 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "pointsAtZ", 0.0F);
            double d6 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "specularExponent", 1.0F);
            double d7 = AbstractSVGFilterPrimitiveElementBridge.convertNumber(element1, "limitingConeAngle", 90F);
            return new SpotLight(d, d1, d2, d3, d4, d5, d6, d7, color);
        }

        public SVGFeSpotLightElementBridge()
        {
        }
    }

    protected static abstract class AbstractSVGLightElementBridge extends AbstractSVGBridge
    {

        public abstract Light createLight(BridgeContext bridgecontext, Element element, Element element1, Color color);

        protected AbstractSVGLightElementBridge()
        {
        }
    }


    protected AbstractSVGLightingElementBridge()
    {
    }

    protected static Light extractLight(Element element, BridgeContext bridgecontext)
    {
        Color color = CSSUtilities.convertLightingColor(element, bridgecontext);
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge != null && (bridge instanceof AbstractSVGLightElementBridge))
                return ((AbstractSVGLightElementBridge)bridge).createLight(bridgecontext, element, element1, color);
        }

        return null;
    }

    protected static double[] convertKernelUnitLength(Element element)
    {
        String s = element.getAttributeNS(null, "kernelUnitLength");
        if(s.length() == 0)
            return null;
        double ad[] = new double[2];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        try
        {
            ad[0] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            if(stringtokenizer.hasMoreTokens())
                ad[1] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            else
                ad[1] = ad[0];
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelUnitLength", s
            });
        }
        if(stringtokenizer.hasMoreTokens() || ad[0] <= 0.0D || ad[1] <= 0.0D)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelUnitLength", s
            });
        else
            return ad;
    }
}
