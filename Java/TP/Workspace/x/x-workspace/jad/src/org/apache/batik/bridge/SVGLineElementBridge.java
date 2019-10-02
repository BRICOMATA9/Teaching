// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.gvt.ShapePainter;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            SVGDecoratedShapeElementBridge, PaintServer, UnitProcessor, Bridge, 
//            BridgeContext

public class SVGLineElementBridge extends SVGDecoratedShapeElementBridge
{

    public SVGLineElementBridge()
    {
    }

    public String getLocalName()
    {
        return "line";
    }

    public Bridge getInstance()
    {
        return new SVGLineElementBridge();
    }

    protected ShapePainter createFillStrokePainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        return PaintServer.convertStrokePainter(element, shapenode, bridgecontext);
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        String s = element.getAttributeNS(null, "x1");
        float f = 0.0F;
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x1", context);
        s = element.getAttributeNS(null, "y1");
        float f1 = 0.0F;
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y1", context);
        s = element.getAttributeNS(null, "x2");
        float f2 = 0.0F;
        if(s.length() != 0)
            f2 = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x2", context);
        s = element.getAttributeNS(null, "y2");
        float f3 = 0.0F;
        if(s.length() != 0)
            f3 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y2", context);
        shapenode.setShape(new java.awt.geom.Line2D.Float(f, f1, f2, f3));
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("x1") || s.equals("y1") || s.equals("x2") || s.equals("y2"))
        {
            buildShape(ctx, e, (ShapeNode)node);
            handleGeometryChanged();
        } else
        {
            super.handleDOMAttrModifiedEvent(mutationevent);
        }
    }
}
