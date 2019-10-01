// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.gvt.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            SVGShapeElementBridge, PaintServer, BridgeContext

public abstract class SVGDecoratedShapeElementBridge extends SVGShapeElementBridge
{

    protected SVGDecoratedShapeElementBridge()
    {
    }

    ShapePainter createFillStrokePainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        return super.createShapePainter(bridgecontext, element, shapenode);
    }

    ShapePainter createMarkerPainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        return PaintServer.convertMarkers(element, shapenode, bridgecontext);
    }

    protected ShapePainter createShapePainter(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        ShapePainter shapepainter = createFillStrokePainter(bridgecontext, element, shapenode);
        ShapePainter shapepainter1 = createMarkerPainter(bridgecontext, element, shapenode);
        java.awt.Shape shape = shapenode.getShape();
        Object obj;
        if(shapepainter1 != null)
        {
            if(shapepainter != null)
            {
                CompositeShapePainter compositeshapepainter = new CompositeShapePainter(shape);
                compositeshapepainter.addShapePainter(shapepainter);
                compositeshapepainter.addShapePainter(shapepainter1);
                obj = compositeshapepainter;
            } else
            {
                obj = shapepainter1;
            }
        } else
        {
            obj = shapepainter;
        }
        return ((ShapePainter) (obj));
    }

    protected void handleCSSPropertyChanged(int i)
    {
        switch(i)
        {
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
            if(!hasNewShapePainter)
            {
                hasNewShapePainter = true;
                ShapeNode shapenode = (ShapeNode)node;
                shapenode.setShapePainter(createShapePainter(ctx, e, shapenode));
            }
            break;

        default:
            super.handleCSSPropertyChanged(i);
            break;
        }
    }
}
