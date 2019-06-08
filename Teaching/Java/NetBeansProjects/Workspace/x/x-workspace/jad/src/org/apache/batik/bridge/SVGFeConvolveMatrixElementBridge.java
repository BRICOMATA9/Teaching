// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.Kernel;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeException, BridgeContext

public class SVGFeConvolveMatrixElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeConvolveMatrixElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feConvolveMatrix";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        int ai[] = convertOrder(element);
        float af[] = convertKernelMatrix(element, ai);
        float f = convertDivisor(element, af);
        float f1 = convertNumber(element, "bias", 0.0F);
        int ai1[] = convertTarget(element, ai);
        PadMode padmode = convertEdgeMode(element);
        double ad[] = convertKernelUnitLength(element);
        boolean flag = convertPreserveAlpha(element);
        Filter filter1 = getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        if(filter1 == null)
            return null;
        Rectangle2D rectangle2d1 = filter1.getBounds2D();
        Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        PadRable8Bit padrable8bit = new PadRable8Bit(filter1, rectangle2d2, PadMode.ZERO_PAD);
        ConvolveMatrixRable8Bit convolvematrixrable8bit = new ConvolveMatrixRable8Bit(padrable8bit);
        for(int i = 0; i < af.length; i++)
            af[i] /= f;

        convolvematrixrable8bit.setKernel(new Kernel(ai[0], ai[1], af));
        convolvematrixrable8bit.setTarget(new Point(ai1[0], ai1[1]));
        convolvematrixrable8bit.setBias(f1);
        convolvematrixrable8bit.setEdgeMode(padmode);
        convolvematrixrable8bit.setKernelUnitLength(ad);
        convolvematrixrable8bit.setPreserveAlpha(flag);
        handleColorInterpolationFilters(convolvematrixrable8bit, element);
        PadRable8Bit padrable8bit1 = new PadRable8Bit(convolvematrixrable8bit, rectangle2d2, PadMode.ZERO_PAD);
        updateFilterMap(element, padrable8bit1, map);
        return padrable8bit1;
    }

    protected static int[] convertOrder(Element element)
    {
        String s = element.getAttributeNS(null, "order");
        if(s.length() == 0)
            return (new int[] {
                3, 3
            });
        int ai[] = new int[2];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        try
        {
            ai[0] = SVGUtilities.convertSVGInteger(stringtokenizer.nextToken());
            if(stringtokenizer.hasMoreTokens())
                ai[1] = SVGUtilities.convertSVGInteger(stringtokenizer.nextToken());
            else
                ai[1] = ai[0];
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "order", s, numberformatexception
            });
        }
        if(stringtokenizer.hasMoreTokens() || ai[0] <= 0 || ai[1] <= 0)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "order", s
            });
        else
            return ai;
    }

    protected static float[] convertKernelMatrix(Element element, int ai[])
    {
        String s = element.getAttributeNS(null, "kernelMatrix");
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "kernelMatrix"
            });
        int i = ai[0] * ai[1];
        float af[] = new float[i];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        int j = 0;
        try
        {
            while(stringtokenizer.hasMoreTokens() && j < i) 
                af[j++] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelMatrix", s, numberformatexception
            });
        }
        if(j != i)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelMatrix", s
            });
        else
            return af;
    }

    protected static float convertDivisor(Element element, float af[])
    {
        String s;
        s = element.getAttributeNS(null, "divisor");
        if(s.length() == 0)
        {
            float f = 0.0F;
            for(int i = 0; i < af.length; i++)
                f += af[i];

            return f != 0.0F ? f : 1.0F;
        }
        return SVGUtilities.convertSVGNumber(s);
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            "divisor", s, numberformatexception
        });
    }

    protected static int[] convertTarget(Element element, int ai[])
    {
        int ai1[] = new int[2];
        String s = element.getAttributeNS(null, "targetX");
        if(s.length() == 0)
            ai1[0] = ai[0] / 2;
        else
            try
            {
                int i = SVGUtilities.convertSVGInteger(s);
                if(i < 0 || i >= ai[0])
                    throw new BridgeException(element, "attribute.malformed", new Object[] {
                        "targetX", s
                    });
                ai1[0] = i;
            }
            catch(NumberFormatException numberformatexception)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "targetX", s, numberformatexception
                });
            }
        s = element.getAttributeNS(null, "targetY");
        if(s.length() == 0)
            ai1[1] = ai[1] / 2;
        else
            try
            {
                int j = SVGUtilities.convertSVGInteger(s);
                if(j < 0 || j >= ai[1])
                    throw new BridgeException(element, "attribute.malformed", new Object[] {
                        "targetY", s
                    });
                ai1[1] = j;
            }
            catch(NumberFormatException numberformatexception1)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "targetY", s, numberformatexception1
                });
            }
        return ai1;
    }

    protected static double[] convertKernelUnitLength(Element element)
    {
        String s = element.getAttributeNS(null, "kernelUnitLength");
        if(s.length() == 0)
            return null;
        double ad[] = new double[2];
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ,");
        try
        {
            ad[0] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            if(stringtokenizer.hasMoreTokens())
                ad[1] = SVGUtilities.convertSVGNumber(stringtokenizer.nextToken());
            else
                ad[1] = ad[0];
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelUnitLength", s
            });
        }
        if(stringtokenizer.hasMoreTokens() || ad[0] <= 0.0D || ad[1] <= 0.0D)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "kernelUnitLength", s
            });
        else
            return ad;
    }

    protected static PadMode convertEdgeMode(Element element)
    {
        String s = element.getAttributeNS(null, "edgeMode");
        if(s.length() == 0)
            return PadMode.REPLICATE;
        if("duplicate".equals(s))
            return PadMode.REPLICATE;
        if("wrap".equals(s))
            return PadMode.WRAP;
        if("none".equals(s))
            return PadMode.ZERO_PAD;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "edgeMode", s
            });
    }

    protected static boolean convertPreserveAlpha(Element element)
    {
        String s = element.getAttributeNS(null, "preserveAlpha");
        if(s.length() == 0)
            return false;
        if("true".equals(s))
            return true;
        if("false".equals(s))
            return false;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "preserveAlpha", s
            });
    }
}
