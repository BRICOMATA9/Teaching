// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.List;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.filter.Mask;
import org.apache.batik.gvt.filter.MaskRable8Bit;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, MaskBridge, SVGUtilities, BridgeContext, 
//            GVTBuilder

public class SVGMaskElementBridge extends AbstractSVGBridge
    implements MaskBridge
{

    public SVGMaskElementBridge()
    {
    }

    public String getLocalName()
    {
        return "mask";
    }

    public Mask createMask(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode)
    {
        java.awt.geom.Rectangle2D rectangle2d = SVGUtilities.convertMaskRegion(element, element1, graphicsnode, bridgecontext);
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        CompositeGraphicsNode compositegraphicsnode = new CompositeGraphicsNode();
        CompositeGraphicsNode compositegraphicsnode1 = new CompositeGraphicsNode();
        compositegraphicsnode.getChildren().add(compositegraphicsnode1);
        boolean flag = false;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            GraphicsNode graphicsnode1 = gvtbuilder.build(bridgecontext, element2);
            if(graphicsnode1 != null)
            {
                flag = true;
                compositegraphicsnode1.getChildren().add(graphicsnode1);
            }
        }

        if(!flag)
            return null;
        String s = element.getAttributeNS(null, "transform");
        java.awt.geom.AffineTransform affinetransform;
        if(s.length() != 0)
            affinetransform = SVGUtilities.convertTransform(element, "transform", s);
        else
            affinetransform = new java.awt.geom.AffineTransform();
        s = element.getAttributeNS(null, "maskContentUnits");
        short word0;
        if(s.length() == 0)
            word0 = 1;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element, "maskContentUnits", s);
        if(word0 == 2)
            affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
        compositegraphicsnode1.setTransform(affinetransform);
        org.apache.batik.ext.awt.image.renderable.Filter filter = graphicsnode.getFilter();
        if(filter == null)
            filter = graphicsnode.getGraphicsNodeRable(true);
        return new MaskRable8Bit(filter, compositegraphicsnode, rectangle2d);
    }
}
