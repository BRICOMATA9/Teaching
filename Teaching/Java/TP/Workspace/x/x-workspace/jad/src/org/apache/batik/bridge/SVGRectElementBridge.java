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

public class SVGRectElementBridge extends SVGShapeElementBridge
{

    public SVGRectElementBridge()
    {
    }

    public String getLocalName()
    {
        return "rect";
    }

    public Bridge getInstance()
    {
        return new SVGRectElementBridge();
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        String s = element.getAttributeNS(null, "x");
        float f = 0.0F;
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x", context);
        s = element.getAttributeNS(null, "y");
        float f1 = 0.0F;
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y", context);
        s = element.getAttributeNS(null, "width");
        float f2;
        if(s.length() != 0)
            f2 = UnitProcessor.svgHorizontalLengthToUserSpace(s, "width", context);
        else
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "width", s
            });
        s = element.getAttributeNS(null, "height");
        float f3;
        if(s.length() != 0)
            f3 = UnitProcessor.svgVerticalLengthToUserSpace(s, "height", context);
        else
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "height", s
            });
        s = element.getAttributeNS(null, "rx");
        boolean flag = s.length() != 0;
        float f4 = 0.0F;
        if(flag)
            f4 = UnitProcessor.svgHorizontalLengthToUserSpace(s, "rx", context);
        f4 = f4 <= f2 / 2.0F ? f4 : f2 / 2.0F;
        s = element.getAttributeNS(null, "ry");
        boolean flag1 = s.length() != 0;
        float f5 = 0.0F;
        if(flag1)
            f5 = UnitProcessor.svgVerticalLengthToUserSpace(s, "ry", context);
        f5 = f5 <= f3 / 2.0F ? f5 : f3 / 2.0F;
        Object obj = null;
        if(flag && flag1)
        {
            if(f4 == 0.0F || f5 == 0.0F)
                obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
            else
                obj = new java.awt.geom.RoundRectangle2D.Float(f, f1, f2, f3, f4 * 2.0F, f5 * 2.0F);
        } else
        if(flag)
        {
            if(f4 == 0.0F)
                obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
            else
                obj = new java.awt.geom.RoundRectangle2D.Float(f, f1, f2, f3, f4 * 2.0F, f4 * 2.0F);
        } else
        if(flag1)
        {
            if(f5 == 0.0F)
                obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
            else
                obj = new java.awt.geom.RoundRectangle2D.Float(f, f1, f2, f3, f5 * 2.0F, f5 * 2.0F);
        } else
        {
            obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
        }
        shapenode.setShape(((Shape) (obj)));
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("x") || s.equals("y") || s.equals("width") || s.equals("height") || s.equals("rx") || s.equals("ry"))
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
        Shape shape = shapenode.getShape();
        Rectangle2D rectangle2d = shape.getBounds2D();
        if(rectangle2d.getWidth() == 0.0D || rectangle2d.getHeight() == 0.0D)
            return null;
        else
            return super.createShapePainter(bridgecontext, element, shapenode);
    }
}
