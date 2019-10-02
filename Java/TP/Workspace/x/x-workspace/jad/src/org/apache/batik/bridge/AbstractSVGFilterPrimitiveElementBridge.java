// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.filter.BackgroundRable8Bit;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, FilterPrimitiveBridge, ErrorConstants, BridgeException, 
//            CSSUtilities, PaintServer, SVGUtilities, BridgeContext

public abstract class AbstractSVGFilterPrimitiveElementBridge extends AbstractSVGBridge
    implements FilterPrimitiveBridge, ErrorConstants
{

    protected AbstractSVGFilterPrimitiveElementBridge()
    {
    }

    protected static Filter getIn(Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Map map, BridgeContext bridgecontext)
    {
        String s = element.getAttributeNS(null, "in");
        if(s.length() == 0)
            return filter;
        else
            return getFilterSource(element, s, element1, graphicsnode, map, bridgecontext);
    }

    protected static Filter getIn2(Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Map map, BridgeContext bridgecontext)
    {
        String s = element.getAttributeNS(null, "in2");
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "in2"
            });
        else
            return getFilterSource(element, s, element1, graphicsnode, map, bridgecontext);
    }

    protected static void updateFilterMap(Element element, Filter filter, Map map)
    {
        String s = element.getAttributeNS(null, "result");
        if(s.length() != 0 && s.trim().length() != 0)
            map.put(s, filter);
    }

    protected static void handleColorInterpolationFilters(Filter filter, Element element)
    {
        if(filter instanceof FilterColorInterpolation)
        {
            boolean flag = CSSUtilities.convertColorInterpolationFilters(element);
            ((FilterColorInterpolation)filter).setColorSpaceLinear(flag);
        }
    }

    static Filter getFilterSource(Element element, String s, Element element1, GraphicsNode graphicsnode, Map map, BridgeContext bridgecontext)
    {
        Filter filter = (Filter)map.get("SourceGraphic");
        Rectangle2D rectangle2d = filter.getBounds2D();
        int i = s.length();
        Object obj = null;
        switch(i)
        {
        case 13: // '\r'
            if("SourceGraphic".equals(s))
                obj = filter;
            break;

        case 11: // '\013'
            if(s.charAt(1) == "SourceAlpha".charAt(1))
            {
                if("SourceAlpha".equals(s))
                {
                    obj = filter;
                    obj = new FilterAlphaRable(((Filter) (obj)));
                }
            } else
            if("StrokePaint".equals(s))
            {
                java.awt.Paint paint = PaintServer.convertStrokePaint(element1, graphicsnode, bridgecontext);
                obj = new FloodRable8Bit(rectangle2d, paint);
            }
            break;

        case 15: // '\017'
            if(s.charAt(10) == "BackgroundImage".charAt(10))
            {
                if("BackgroundImage".equals(s))
                {
                    obj = new BackgroundRable8Bit(graphicsnode);
                    obj = new PadRable8Bit(((Filter) (obj)), rectangle2d, PadMode.ZERO_PAD);
                }
            } else
            if("BackgroundAlpha".equals(s))
            {
                obj = new BackgroundRable8Bit(graphicsnode);
                obj = new FilterAlphaRable(((Filter) (obj)));
                obj = new PadRable8Bit(((Filter) (obj)), rectangle2d, PadMode.ZERO_PAD);
            }
            break;

        case 9: // '\t'
            if("FillPaint".equals(s))
            {
                Object obj1 = PaintServer.convertFillPaint(element1, graphicsnode, bridgecontext);
                if(obj1 == null)
                    obj1 = new Color(0, 0, 0, 0);
                obj = new FloodRable8Bit(rectangle2d, ((java.awt.Paint) (obj1)));
            }
            break;
        }
        if(obj == null)
            obj = (Filter)map.get(s);
        return ((Filter) (obj));
    }

    protected static int convertInteger(Element element, String s, int i)
    {
        String s1;
        s1 = element.getAttributeNS(null, s);
        if(s1.length() == 0)
            return i;
        return SVGUtilities.convertSVGInteger(s1);
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            s, s1
        });
    }

    protected static float convertNumber(Element element, String s, float f)
    {
        String s1;
        s1 = element.getAttributeNS(null, s);
        if(s1.length() == 0)
            return f;
        return SVGUtilities.convertSVGNumber(s1);
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            s, s1, numberformatexception
        });
    }

    static final Rectangle2D INFINITE_FILTER_REGION = new java.awt.geom.Rectangle2D.Float(-1.701412E+38F, -1.701412E+38F, 3.402823E+38F, 3.402823E+38F);

}
