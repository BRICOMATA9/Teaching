// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.gvt.ShapePainter;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            SVGShapeElementBridge, UnitProcessor, BridgeException, Bridge, 
//            BridgeContext

public class SVGCircleElementBridge extends SVGShapeElementBridge
{

    public SVGCircleElementBridge()
    {
    }

    public String getLocalName()
    {
        return "circle";
    }

    public Bridge getInstance()
    {
        return new SVGCircleElementBridge();
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        String s = element.getAttributeNS(null, "cx");
        float f = 0.0F;
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "cx", context);
        s = element.getAttributeNS(null, "cy");
        float f1 = 0.0F;
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "cy", context);
        s = element.getAttributeNS(null, "r");
        float f2;
        if(s.length() != 0)
            f2 = UnitProcessor.svgOtherLengthToUserSpace(s, "r", context);
        else
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "r", s
            });
        float f3 = f - f2;
        float f4 = f1 - f2;
        float f5 = f2 * 2.0F;
        shapenode.setShape(new java.awt.geom.Ellipse2D.Float(f3, f4, f5, f5));
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("cx") || s.equals("cy") || s.equals("r"))
        {
            buildShape(ctx, e, (ShapeNode)node);
            handleGeometryChanged();
        } else
        {
            super.handleDOMAttrModifiedEvent(mutationevent);
        }
    }

    protected ShapePainter createShapePainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        Rectangle2D rectangle2d = shapenode.getShape().getBounds2D();
        if(rectangle2d.getWidth() == 0.0D || rectangle2d.getHeight() == 0.0D)
            return null;
        else
            return super.createShapePainter(bridgecontext, element, shapenode);
    }
}
