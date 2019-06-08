// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import org.apache.batik.ext.awt.MultipleGradientPaint;
import org.apache.batik.ext.awt.RadialGradientPaint;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGGradientElementBridge, SVGUtilities, UnitProcessor, BridgeContext

public class SVGRadialGradientElementBridge extends AbstractSVGGradientElementBridge
{

    public SVGRadialGradientElementBridge()
    {
    }

    public String getLocalName()
    {
        return "radialGradient";
    }

    protected Paint buildGradient(Element element, Element element1, GraphicsNode graphicsnode, org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cyclemethodenum, org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorspaceenum, AffineTransform affinetransform, Color acolor[], 
            float af[], BridgeContext bridgecontext)
    {
        String s = SVGUtilities.getChainableAttributeNS(element, null, "cx", bridgecontext);
        if(s.length() == 0)
            s = "50%";
        String s1 = SVGUtilities.getChainableAttributeNS(element, null, "cy", bridgecontext);
        if(s1.length() == 0)
            s1 = "50%";
        String s2 = SVGUtilities.getChainableAttributeNS(element, null, "r", bridgecontext);
        if(s2.length() == 0)
            s2 = "50%";
        String s3 = SVGUtilities.getChainableAttributeNS(element, null, "fx", bridgecontext);
        if(s3.length() == 0)
            s3 = s;
        String s4 = SVGUtilities.getChainableAttributeNS(element, null, "fy", bridgecontext);
        if(s4.length() == 0)
            s4 = s1;
        String s5 = SVGUtilities.getChainableAttributeNS(element, null, "gradientUnits", bridgecontext);
        short word0;
        if(s5.length() == 0)
            word0 = 2;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element, "gradientUnits", s5);
        if(word0 == 2)
            affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        float f = SVGUtilities.convertLength(s2, "r", word0, context);
        if(f == 0.0F)
        {
            return acolor[acolor.length - 1];
        } else
        {
            java.awt.geom.Point2D point2d = SVGUtilities.convertPoint(s, "cx", s1, "cy", word0, context);
            java.awt.geom.Point2D point2d1 = SVGUtilities.convertPoint(s3, "fx", s4, "fy", word0, context);
            return new RadialGradientPaint(point2d, f, point2d1, af, acolor, cyclemethodenum, RadialGradientPaint.SRGB, affinetransform);
        }
    }
}
