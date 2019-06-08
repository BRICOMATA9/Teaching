// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.List;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.ext.awt.image.renderable.ClipRable8Bit;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.Marker;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, MarkerBridge, ErrorConstants, BridgeContext, 
//            GVTBuilder, UnitProcessor, SVGUtilities, BridgeException, 
//            CSSUtilities, ViewBox

public class SVGMarkerElementBridge extends AbstractSVGBridge
    implements MarkerBridge, ErrorConstants
{

    protected SVGMarkerElementBridge()
    {
    }

    public String getLocalName()
    {
        return "marker";
    }

    public Marker createMarker(BridgeContext bridgecontext, Element element, Element element1)
    {
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        boolean flag = false;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            org.apache.batik.gvt.GraphicsNode graphicsnode = gvtbuilder.build(bridgecontext, element2);
            if(graphicsnode != null)
            {
                flag = true;
                compositegraphicsnode.getChildren().add(graphicsnode);
            }
        }

        if(!flag)
            return null;
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element1);
        float f = 3F;
        String s = element.getAttributeNS(null, "markerWidth");
        if(s.length() != 0)
            f = UnitProcessor.svgHorizontalLengthToUserSpace(s, "markerWidth", context);
        if(f == 0.0F)
            return null;
        float f1 = 3F;
        s = element.getAttributeNS(null, "markerHeight");
        if(s.length() != 0)
            f1 = UnitProcessor.svgVerticalLengthToUserSpace(s, "markerHeight", context);
        if(f1 == 0.0F)
            return null;
        s = element.getAttributeNS(null, "orient");
        double d;
        if(s.length() == 0)
            d = 0.0D;
        else
        if("auto".equals(s))
            d = (0.0D / 0.0D);
        else
            try
            {
                d = SVGUtilities.convertSVGNumber(s);
            }
            catch(NumberFormatException numberformatexception)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "orient", s
                });
            }
        Value value = CSSUtilities.getComputedStyle(element1, 52);
        float f2 = value.getFloatValue();
        s = element.getAttributeNS(null, "markerUnits");
        short word0;
        if(s.length() == 0)
            word0 = 3;
        else
            word0 = SVGUtilities.parseMarkerCoordinateSystem(element, "markerUnits", s);
        java.awt.geom.AffineTransform affinetransform;
        if(word0 == 3)
        {
            affinetransform = new java.awt.geom.AffineTransform();
            affinetransform.scale(f2, f2);
        } else
        {
            affinetransform = new java.awt.geom.AffineTransform();
        }
        java.awt.geom.AffineTransform affinetransform1 = ViewBox.getPreserveAspectRatioTransform(element, f, f1);
        if(affinetransform1 == null)
            return null;
        affinetransform.concatenate(affinetransform1);
        compositegraphicsnode.setTransform(affinetransform);
        if(CSSUtilities.convertOverflow(element))
        {
            float af[] = CSSUtilities.convertClip(element);
            java.awt.geom.Rectangle2D.Float float1;
            if(af == null)
                float1 = new java.awt.geom.Rectangle2D.Float(0.0F, 0.0F, f2 * f, f2 * f1);
            else
                float1 = new java.awt.geom.Rectangle2D.Float(af[3], af[0], f2 * f - af[1] - af[3], f2 * f1 - af[2] - af[0]);
            CompositeGraphicsNode compositegraphicsnode1 = new CompositeGraphicsNode();
            compositegraphicsnode1.getChildren().add(compositegraphicsnode);
            org.apache.batik.ext.awt.image.renderable.Filter filter = compositegraphicsnode1.getGraphicsNodeRable(true);
            compositegraphicsnode1.setClip(new ClipRable8Bit(filter, float1));
            compositegraphicsnode = compositegraphicsnode1;
        }
        float f3 = 0.0F;
        s = element.getAttributeNS(null, "refX");
        if(s.length() != 0)
            f3 = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "refX", context);
        float f4 = 0.0F;
        s = element.getAttributeNS(null, "refY");
        if(s.length() != 0)
            f4 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "refY", context);
        float af1[] = {
            f3, f4
        };
        affinetransform.transform(af1, 0, af1, 0, 1);
        Marker marker = new Marker(compositegraphicsnode, new java.awt.geom.Point2D.Float(af1[0], af1[1]), d);
        return marker;
    }
}
