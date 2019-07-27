// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.FloodRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, CSSUtilities, BridgeContext

public class SVGFeFloodElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeFloodElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feFlood";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Rectangle2D rectangle2d1 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d, rectangle2d, bridgecontext);
        java.awt.Color color = CSSUtilities.convertFloodColor(element, bridgecontext);
        FloodRable8Bit floodrable8bit = new FloodRable8Bit(rectangle2d1, color);
        handleColorInterpolationFilters(floodrable8bit, element);
        updateFilterMap(element, floodrable8bit, map);
        return floodrable8bit;
    }
}
