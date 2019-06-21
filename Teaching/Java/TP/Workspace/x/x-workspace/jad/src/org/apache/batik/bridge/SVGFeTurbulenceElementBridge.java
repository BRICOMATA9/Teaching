// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeTurbulenceElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeTurbulenceElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feTurbulence";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
        {
            return null;
        } else
        {
            Rectangle2D rectangle2d1 = rectangle2d;
            Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
            float af[] = convertBaseFrenquency(element);
            int i = convertInteger(element, "numOctaves", 1);
            int j = convertInteger(element, "seed", 0);
            boolean flag = convertStitchTiles(element);
            boolean flag1 = convertType(element);
            TurbulenceRable8Bit turbulencerable8bit = new TurbulenceRable8Bit(rectangle2d2);
            turbulencerable8bit.setBaseFrequencyX(af[0]);
            turbulencerable8bit.setBaseFrequencyY(af[1]);
            turbulencerable8bit.setNumOctaves(i);
            turbulencerable8bit.setSeed(j);
            turbulencerable8bit.setStitched(flag);
            turbulencerable8bit.setFractalNoise(flag1);
            handleColorInterpolationFilters(turbulencerable8bit, element);
            updateFilterMap(element, turbulencerable8bit, map);
            return turbulencerable8bit;
        }
    }

    protected static float[] convertBaseFrenquency(Element element)
    {
        String s = element.getAttributeNS(null, "baseFrequency");
        if(s.length() == 0)
            return (new float[] {
                0.001F, 0.001F
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
            if(stringtokenizer.hasMoreTokens())
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "baseFrequency", s
                });
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "baseFrequency", s
            });
        }
        if(af[0] < 0.0F || af[1] < 0.0F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "baseFrequency", s
            });
        else
            return af;
    }

    protected static boolean convertStitchTiles(Element element)
    {
        String s = element.getAttributeNS(null, "stitchTiles");
        if(s.length() == 0)
            return false;
        if("stitch".equals(s))
            return true;
        if("noStitch".equals(s))
            return false;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "stitchTiles", s
            });
    }

    protected static boolean convertType(Element element)
    {
        String s = element.getAttributeNS(null, "type");
        if(s.length() == 0)
            return false;
        if("fractalNoise".equals(s))
            return true;
        if("turbulence".equals(s))
            return false;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "type", s
            });
    }
}
