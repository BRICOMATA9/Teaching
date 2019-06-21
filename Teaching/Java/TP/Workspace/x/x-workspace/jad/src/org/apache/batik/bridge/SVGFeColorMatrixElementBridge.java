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

public class SVGFeColorMatrixElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeColorMatrixElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feColorMatrix";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
            return null;
        Rectangle2D rectangle2d1 = filter1.getBounds2D();
        Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        int i = convertType(element);
        ColorMatrixRable colormatrixrable;
        switch(i)
        {
        case 2: // '\002'
            float f = convertValuesToHueRotate(element);
            colormatrixrable = ColorMatrixRable8Bit.buildHueRotate(f);
            break;

        case 3: // '\003'
            colormatrixrable = ColorMatrixRable8Bit.buildLuminanceToAlpha();
            break;

        case 0: // '\0'
            float af[][] = convertValuesToMatrix(element);
            colormatrixrable = ColorMatrixRable8Bit.buildMatrix(af);
            break;

        case 1: // '\001'
            float f1 = convertValuesToSaturate(element);
            colormatrixrable = ColorMatrixRable8Bit.buildSaturate(f1);
            break;

        default:
            throw new Error();
        }
        colormatrixrable.setSource(filter1);
        handleColorInterpolationFilters(colormatrixrable, element);
        PadRable8Bit padrable8bit = new PadRable8Bit(colormatrixrable, rectangle2d2, PadMode.ZERO_PAD);
        updateFilterMap(element, padrable8bit, map);
        return padrable8bit;
    }

    protected static float[][] convertValuesToMatrix(Element element)
    {
        String s = element.getAttributeNS(null, "values");
        float af[][] = new float[4][5];
        if(s.length() == 0)
        {
            af[0][0] = 1.0F;
            af[1][1] = 1.0F;
            af[2][2] = 1.0F;
            af[3][3] = 1.0F;
            return af;
        }
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        int i = 0;
        try
        {
            while(i < 20 && stringtokenizer.hasMoreTokens()) 
            {
                af[i / 5][i % 5] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
                i++;
            }
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "values", s, numberformatexception
            });
        }
        if(i != 20 || stringtokenizer.hasMoreTokens())
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "values", s
            });
        for(int j = 0; j < 4; j++)
            af[j][4] *= 255F;

        return af;
    }

    protected static float convertValuesToSaturate(Element element)
    {
        String s;
        s = element.getAttributeNS(null, "values");
        if(s.length() == 0)
            return 1.0F;
        return SVGUtilities.convertSVGNumber(s);
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            "values", s
        });
    }

    protected static float convertValuesToHueRotate(Element element)
    {
        String s;
        s = element.getAttributeNS(null, "values");
        if(s.length() == 0)
            return 0.0F;
        return (float)((double)SVGUtilities.convertSVGNumber(s) * 3.1415926535897931D) / 180F;
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            "values", s
        });
    }

    protected static int convertType(Element element)
    {
        String s = element.getAttributeNS(null, "type");
        if(s.length() == 0)
            return 0;
        if("hueRotate".equals(s))
            return 2;
        if("luminanceToAlpha".equals(s))
            return 3;
        if("matrix".equals(s))
            return 0;
        if("saturate".equals(s))
            return 1;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "type", s
            });
    }
}
