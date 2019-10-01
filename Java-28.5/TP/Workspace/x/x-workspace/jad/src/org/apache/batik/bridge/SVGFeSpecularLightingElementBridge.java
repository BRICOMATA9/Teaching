// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.SpecularLightingRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGLightingElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeSpecularLightingElementBridge extends AbstractSVGLightingElementBridge
{

    public SVGFeSpecularLightingElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feSpecularLighting";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        float f = convertNumber(element, "surfaceScale", 1.0F);
        float f1 = convertNumber(element, "specularConstant", 1.0F);
        float f2 = convertSpecularExponent(element);
        org.apache.batik.ext.awt.image.Light light = extractLight(element, bridgecontext);
        double ad[] = convertKernelUnitLength(element);
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = filter1.getBounds2D();
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            SpecularLightingRable8Bit specularlightingrable8bit = new SpecularLightingRable8Bit(filter1, rectangle2d2, light, f1, f2, f, ad);
            handleColorInterpolationFilters(specularlightingrable8bit, element);
            updateFilterMap(element, specularlightingrable8bit, map);
            return specularlightingrable8bit;
        }
    }

    protected static float convertSpecularExponent(Element element)
    {
        String s;
        s = element.getAttributeNS(null, "specularExponent");
        if(s.length() == 0)
            return 1.0F;
        float f;
        f = SVGUtilities.convertSVGNumber(s);
        if(f < 1.0F || f > 128F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "specularConstant", s
            });
        return f;
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            "specularConstant", s, numberformatexception
        });
    }
}
