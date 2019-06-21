// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import org.apache.batik.dom.svg.SVGPathContext;
import org.apache.batik.ext.awt.geom.PathLength;
import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.parser.*;
import org.w3c.dom.Element;
import org.w3c.dom.events.MutationEvent;

// Referenced classes of package org.apache.batik.bridge:
//            SVGDecoratedShapeElementBridge, CSSUtilities, BridgeException, Bridge, 
//            BridgeContext

public class SVGPathElementBridge extends SVGDecoratedShapeElementBridge
    implements SVGPathContext
{

    public SVGPathElementBridge()
    {
        pathLengthShape = null;
        pathLength = null;
    }

    public String getLocalName()
    {
        return "path";
    }

    public Bridge getInstance()
    {
        return new SVGPathElementBridge();
    }

    protected void buildShape(BridgeContext bridgecontext, Element element, ShapeNode shapenode)
    {
        Exception exception;
        String s = element.getAttributeNS(null, "d");
        if(s.length() != 0)
        {
            AWTPathProducer awtpathproducer = new AWTPathProducer();
            awtpathproducer.setWindingRule(CSSUtilities.convertFillRule(element));
            try
            {
                PathParser pathparser = new PathParser();
                pathparser.setPathHandler(awtpathproducer);
                pathparser.parse(s);
            }
            catch(ParseException parseexception)
            {
                BridgeException bridgeexception = new BridgeException(element, "attribute.malformed", new Object[] {
                    "d"
                });
                bridgeexception.setGraphicsNode(shapenode);
                throw bridgeexception;
            }
            finally
            {
                shapenode.setShape(awtpathproducer.getShape());
            }
            shapenode.setShape(awtpathproducer.getShape());
        }
        break MISSING_BLOCK_LABEL_118;
        throw exception;
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        if(s.equals("d"))
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

    PathLength getPathLengthObj()
    {
        Shape shape = ((ShapeNode)node).getShape();
        if(pathLengthShape != shape)
        {
            pathLength = new PathLength(shape);
            pathLengthShape = shape;
        }
        return pathLength;
    }

    public float getTotalLength()
    {
        PathLength pathlength = getPathLengthObj();
        return pathlength.lengthOfPath();
    }

    public Point2D getPointAtLength(float f)
    {
        PathLength pathlength = getPathLengthObj();
        return pathlength.pointAtLength(f);
    }

    protected static final Shape DEFAULT_SHAPE = new GeneralPath();
    Shape pathLengthShape;
    PathLength pathLength;

}
