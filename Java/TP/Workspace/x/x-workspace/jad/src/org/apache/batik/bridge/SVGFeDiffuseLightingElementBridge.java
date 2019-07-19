// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable8Bit;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGLightingElementBridge, SVGUtilities, BridgeContext

public class SVGFeDiffuseLightingElementBridge extends AbstractSVGLightingElementBridge
{

    public SVGFeDiffuseLightingElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feDiffuseLighting";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        float f = convertNumber(element, "surfaceScale", 1.0F);
        float f1 = convertNumber(element, "diffuseConstant", 1.0F);
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
            DiffuseLightingRable8Bit diffuselightingrable8bit = new DiffuseLightingRable8Bit(filter1, rectangle2d2, light, f1, f, ad);
            handleColorInterpolationFilters(diffuselightingrable8bit, element);
            updateFilterMap(element, diffuselightingrable8bit, map);
            return diffuselightingrable8bit;
        }
    }
}
