// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.TileRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeContext

public class SVGFeTileElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeTileElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feTile";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Rectangle2D rectangle2d1 = rectangle2d;
        Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            TileRable8Bit tilerable8bit = new TileRable8Bit(filter1, rectangle2d2, filter1.getBounds2D(), false);
            handleColorInterpolationFilters(tilerable8bit, element);
            updateFilterMap(element, tilerable8bit, map);
            return tilerable8bit;
        }
    }
}
