// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;
import org.apache.batik.ext.awt.image.ARGBChannel;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.DisplacementMapRable8Bit;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.PadRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeDisplacementMapElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeDisplacementMapElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feDisplacementMap";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        float f = convertNumber(element, "scale", 0.0F);
        ARGBChannel argbchannel = convertChannelSelector(element, "xChannelSelector", ARGBChannel.A);
        ARGBChannel argbchannel1 = convertChannelSelector(element, "yChannelSelector", ARGBChannel.A);
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
            PadRable8Bit padrable8bit = new PadRable8Bit(filter1, rectangle2d2, PadMode.ZERO_PAD);
            ArrayList arraylist = new ArrayList(2);
            arraylist.add(padrable8bit);
            arraylist.add(filter2);
            DisplacementMapRable8Bit displacementmaprable8bit = new DisplacementMapRable8Bit(arraylist, f, argbchannel, argbchannel1);
            handleColorInterpolationFilters(displacementmaprable8bit, element);
            PadRable8Bit padrable8bit1 = new PadRable8Bit(displacementmaprable8bit, rectangle2d2, PadMode.ZERO_PAD);
            updateFilterMap(element, padrable8bit1, map);
            return padrable8bit1;
        }
    }

    protected static ARGBChannel convertChannelSelector(Element element, String s, ARGBChannel argbchannel)
    {
        String s1 = element.getAttributeNS(null, s);
        if(s1.length() == 0)
            return argbchannel;
        if("A".equals(s1))
            return ARGBChannel.A;
        if("R".equals(s1))
            return ARGBChannel.R;
        if("G".equals(s1))
            return ARGBChannel.G;
        if("B".equals(s1))
            return ARGBChannel.B;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                s, s1
            });
    }
}
