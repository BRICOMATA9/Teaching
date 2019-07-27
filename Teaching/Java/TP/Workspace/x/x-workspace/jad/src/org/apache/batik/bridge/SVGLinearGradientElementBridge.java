// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import org.apache.batik.ext.awt.LinearGradientPaint;
import org.apache.batik.ext.awt.MultipleGradientPaint;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGGradientElementBridge, SVGUtilities, UnitProcessor, BridgeContext

public class SVGLinearGradientElementBridge extends AbstractSVGGradientElementBridge
{

    public SVGLinearGradientElementBridge()
    {
    }

    public String getLocalName()
    {
        return "linearGradient";
    }

    protected Paint buildGradient(Element element, Element element1, GraphicsNode graphicsnode, org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cyclemethodenum, org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorspaceenum, AffineTransform affinetransform, Color acolor[], 
            float af[], BridgeContext bridgecontext)
    {
        String s = SVGUtilities.getChainableAttributeNS(element, null, "x1", bridgecontext);
        if(s.length() == 0)
            s = "0%";
        String s1 = SVGUtilities.getChainableAttributeNS(element, null, "y1", bridgecontext);
        if(s1.length() == 0)
            s1 = "0%";
        String s2 = SVGUtilities.getChainableAttributeNS(element, null, "x2", bridgecontext);
        if(s2.length() == 0)
            s2 = "100%";
        String s3 = SVGUtilities.getChainableAttributeNS(element, null, "y2", bridgecontext);
        if(s3.length() == 0)
            s3 = "0%";
        String s4 = SVGUtilities.getChainableAttributeNS(element, null, "gradientUnits", bridgecontext);
        short word0;
        if(s4.length() == 0)
            word0 = 2;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element, "gradientUnits", s4);
        if(word0 == 2)
            affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        Point2D point2d = SVGUtilities.convertPoint(s, "x1", s1, "y1", word0, context);
        Point2D point2d1 = SVGUtilities.convertPoint(s2, "x2", s3, "y2", word0, context);
        if(point2d.getX() == point2d1.getX() && point2d.getY() == point2d1.getY())
            return acolor[acolor.length - 1];
        else
            return new LinearGradientPaint(point2d, point2d1, af, acolor, cyclemethodenum, colorspaceenum, affinetransform);
    }
}
