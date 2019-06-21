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

public class SVGEllipseElementBridge extends SVGShapeElementBridge
{

    public SVGEllipseElementBridge()
    {
    }

    public String getLocalName()
    {
        return "ellipse";
    }

    public Bridge getInstance()
    {
        return new SVGEllipseElementBridge();
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
        s = element.getAttributeNS(null, "rx");
        float f2;
        if(s.length() != 0)
            f2 = UnitProcessor.svgHorizontalLengthToUserSpace(s, "rx", context);
        else
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "rx", s
            });
        s = element.getAttributeNS(null, "ry");
        float f3;
        if(s.length() != 0)
            f3 = UnitProcessor.svgVerticalLengthToUserSpace(s, "ry", context);
        else
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "ry", s
            });
        shapenode.setShape(new java.awt.geom.Ellipse2D.Float(f - f2, f1 - f3, f2 * 2.0F, f3 * 2.0F));
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("cx") || s.equals("cy") || s.equals("rx") || s.equals("ry"))
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
