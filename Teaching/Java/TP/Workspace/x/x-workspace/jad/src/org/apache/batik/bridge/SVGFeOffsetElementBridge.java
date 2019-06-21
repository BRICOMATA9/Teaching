// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeContext

public class SVGFeOffsetElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeOffsetElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feOffset";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = filter1.getBounds2D();
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            float f = convertNumber(element, "dx", 0.0F);
            float f1 = convertNumber(element, "dy", 0.0F);
            AffineTransform affinetransform = AffineTransform.getTranslateInstance(f, f1);
            PadRable8Bit padrable8bit = new PadRable8Bit(filter1, rectangle2d2, PadMode.ZERO_PAD);
            Object obj = new AffineRable8Bit(padrable8bit, affinetransform);
            obj = new PadRable8Bit(((Filter) (obj)), rectangle2d2, PadMode.ZERO_PAD);
            handleColorInterpolationFilters(((Filter) (obj)), element);
            updateFilterMap(element, ((Filter) (obj)), map);
            return ((Filter) (obj));
        }
    }
}
