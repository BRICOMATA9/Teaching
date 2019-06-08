// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.parser.*;
import org.w3c.dom.Element;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            SVGDecoratedShapeElementBridge, CSSUtilities, BridgeException, Bridge, 
//            BridgeContext

public class SVGPolygonElementBridge extends SVGDecoratedShapeElementBridge
{

    public SVGPolygonElementBridge()
    {
    }

    public String getLocalName()
    {
        return "polygon";
    }

    public Bridge getInstance()
    {
        return new SVGPolygonElementBridge();
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        Exception exception;
        String s = element.getAttributeNS(null, "points");
        if(s.length() != 0)
        {
            AWTPolygonProducer awtpolygonproducer = new AWTPolygonProducer();
            awtpolygonproducer.setWindingRule(CSSUtilities.convertFillRule(element));
            try
            {
                PointsParser pointsparser = new PointsParser();
                pointsparser.setPointsHandler(awtpolygonproducer);
                pointsparser.parse(s);
            }
            catch(ParseException parseexception)
            {
                BridgeException bridgeexception = new BridgeException(element, "attribute.malformed", new Object[] {
                    "points"
                });
                bridgeexception.setGraphicsNode(shapenode);
                throw bridgeexception;
            }
            finally
            {
                shapenode.setShape(awtpolygonproducer.getShape());
            }
            shapenode.setShape(awtpolygonproducer.getShape());
        }
        break MISSING_BLOCK_LABEL_118;
        throw exception;
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("points"))
        {
            if(mutationevent.getNewValue().length() == 0)
                ((ShapeNode)node).setShape(DEFAULT_SHAPE);
            else
                buildShape(ctx, e, (ShapeNode)node);
            handleGeometryChanged();
        } else
        {
            super.handleDOMAttrModifiedEvent(mutationevent);
        }
    }

    protected void handleCSSPropertyChanged(int i)
    {
        switch(i)
        {
        case 17: // '\021'
            buildShape(ctx, e, (ShapeNode)node);
            handleGeometryChanged();
            break;

        default:
            super.handleCSSPropertyChanged(i);
            break;
        }
    }

    protected static final Shape DEFAULT_SHAPE = new GeneralPath();

}
