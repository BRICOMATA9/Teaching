// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;
import org.apache.batik.ext.awt.image.CompositeRule;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.PadRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeBlendElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeBlendElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feBlend";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        CompositeRule compositerule = convertMode(element);
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
            return null;
        Filter filter2 = getIn2(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter2 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = (Rectangle2D)filter1.getBounds2D().clone();
            rectangle2d1.add(filter2.getBounds2D());
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            ArrayList arraylist = new ArrayList(2);
            arraylist.add(filter2);
            arraylist.add(filter1);
            Object obj = new CompositeRable8Bit(arraylist, compositerule, true);
            handleColorInterpolationFilters(((Filter) (obj)), element);
            obj = new PadRable8Bit(((Filter) (obj)), rectangle2d2, PadMode.ZERO_PAD);
            updateFilterMap(element, ((Filter) (obj)), map);
            return ((Filter) (obj));
        }
    }

    protected static CompositeRule convertMode(Element element)
    {
        String s = element.getAttributeNS(null, "mode");
        if(s.length() == 0)
            return CompositeRule.OVER;
        if("normal".equals(s))
            return CompositeRule.OVER;
        if("multiply".equals(s))
            return CompositeRule.MULTIPLY;
        if("screen".equals(s))
            return CompositeRule.SCREEN;
        if("darken".equals(s))
            return CompositeRule.DARKEN;
        if("lighten".equals(s))
            return CompositeRule.LIGHTEN;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "mode", s
            });
    }
}
