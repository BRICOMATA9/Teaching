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
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeMorphologyElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeMorphologyElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feMorphology";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        float af[] = convertRadius(element);
        if(af[0] == 0.0F || af[1] == 0.0F)
            return null;
        boolean flag = convertOperator(element);
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = filter1.getBounds2D();
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            PadRable8Bit padrable8bit = new PadRable8Bit(filter1, rectangle2d2, PadMode.ZERO_PAD);
            MorphologyRable8Bit morphologyrable8bit = new MorphologyRable8Bit(padrable8bit, af[0], af[1], flag);
            handleColorInterpolationFilters(morphologyrable8bit, element);
            PadRable8Bit padrable8bit1 = new PadRable8Bit(morphologyrable8bit, rectangle2d2, PadMode.ZERO_PAD);
            updateFilterMap(element, padrable8bit1, map);
            return padrable8bit1;
        }
    }

    protected static float[] convertRadius(Element element)
    {
        String s = element.getAttributeNS(null, "radius");
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
                "radius", s, numberformatexception
            });
        }
        if(stringtokenizer.hasMoreTokens() || af[0] < 0.0F || af[1] < 0.0F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "radius", s
            });
        else
            return af;
    }

    protected static boolean convertOperator(Element element)
    {
        String s = element.getAttributeNS(null, "operator");
        if(s.length() == 0)
            return false;
        if("erode".equals(s))
            return false;
        if("dilate".equals(s))
            return true;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "operator", s
            });
    }
}
