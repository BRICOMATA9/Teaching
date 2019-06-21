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

public class SVGPolylineElementBridge extends SVGDecoratedShapeElementBridge
{

    public SVGPolylineElementBridge()
    {
    }

    public String getLocalName()
    {
        return "polyline";
    }

    public Bridge getInstance()
    {
        return new SVGPolylineElementBridge();
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        Exception exception;
        String s = element.getAttributeNS(null, "points");
        if(s.length() != 0)
        {
            AWTPolylineProducer awtpolylineproducer = new AWTPolylineProducer();
            awtpolylineproducer.setWindingRule(CSSUtilities.convertFillRule(element));
            try
            {
                PointsParser pointsparser = new PointsParser();
                pointsparser.setPointsHandler(awtpolylineproducer);
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
                shapenode.setShape(awtpolylineproducer.getShape());
            }
            shapenode.setShape(awtpolylineproducer.getShape());
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
