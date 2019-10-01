// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, BridgeException, SVGUtilities, BridgeContext

public class SVGFeGaussianBlurElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeGaussianBlurElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feGaussianBlur";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        float af[] = convertStdDeviation(element);
        if(af[0] < 0.0F || af[1] < 0.0F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "stdDeviation", "" + af[0] + af[1]
            });
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = filter1.getBounds2D();
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            PadRable8Bit padrable8bit = new PadRable8Bit(filter1, rectangle2d2, PadMode.ZERO_PAD);
            GaussianBlurRable8Bit gaussianblurrable8bit = new GaussianBlurRable8Bit(padrable8bit, af[0], af[1]);
            handleColorInterpolationFilters(gaussianblurrable8bit, element);
            PadRable8Bit padrable8bit1 = new PadRable8Bit(gaussianblurrable8bit, rectangle2d2, PadMode.ZERO_PAD);
            updateFilterMap(element, padrable8bit1, map);
            return padrable8bit1;
        }
    }

    protected static float[] convertStdDeviation(Element element)
    {
        String s = element.getAttributeNS(null, "stdDeviation");
        if(s.length() == 0)
            return (new float[] {
                0.0F, 0.0F
            });
        float af[] = new float[2];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        try
        {
            af[0] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            if(stringtokenizer.hasMoreTokens())
                af[1] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            else
                af[1] = af[0];
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "stdDeviation", s, numberformatexception
            });
        }
        if(stringtokenizer.hasMoreTokens())
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "stdDeviation", s
            });
        else
            return af;
    }
}
