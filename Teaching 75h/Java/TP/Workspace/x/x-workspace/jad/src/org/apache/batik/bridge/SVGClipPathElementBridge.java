// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.RenderingHints;
import java.awt.geom.*;
import org.apache.batik.css.engine.CSSImportNode;
import org.apache.batik.dom.svg.SVGOMCSSImportedElementRoot;
import org.apache.batik.ext.awt.image.renderable.ClipRable;
import org.apache.batik.ext.awt.image.renderable.ClipRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.ShapeNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ClipBridge, SVGUtilities, BridgeContext, 
//            GVTBuilder, CSSUtilities

public class SVGClipPathElementBridge extends AbstractSVGBridge
    implements ClipBridge
{

    public SVGClipPathElementBridge()
    {
    }

    public String getLocalName()
    {
        return "clipPath";
    }

    public ClipRable createClip(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode)
    {
        String s = element.getAttributeNS(null, "transform");
        AffineTransform affinetransform;
        if(s.length() != 0)
            affinetransform = SVGUtilities.convertTransform(element, "transform", s);
        else
            affinetransform = new AffineTransform();
        s = element.getAttributeNS(null, "clipPathUnits");
        short word0;
        if(s.length() == 0)
            word0 = 1;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element, "clipPathUnits", s);
        if(word0 == 2)
            affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
        Area area = new Area();
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        boolean flag = false;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            GraphicsNode graphicsnode1 = gvtbuilder.build(bridgecontext, element2);
            if(graphicsnode1 == null)
                continue;
            flag = true;
            if(element2 instanceof CSSImportNode)
            {
                SVGOMCSSImportedElementRoot svgomcssimportedelementroot = (SVGOMCSSImportedElementRoot)((CSSImportNode)element2).getCSSImportedElementRoot();
                if(svgomcssimportedelementroot != null)
                {
                    Node node1 = svgomcssimportedelementroot.getFirstChild();
                    if(node1 != null && node1.getNodeType() == 1)
                        element2 = (Element)node1;
                }
            }
            int i = CSSUtilities.convertClipRule(element2);
            GeneralPath generalpath = new GeneralPath(graphicsnode1.getOutline());
            generalpath.setWindingRule(i);
            AffineTransform affinetransform1 = graphicsnode1.getTransform();
            if(affinetransform1 == null)
                affinetransform1 = affinetransform;
            else
                affinetransform1.preConcatenate(affinetransform);
            Object obj1 = affinetransform1.createTransformedShape(generalpath);
            ShapeNode shapenode1 = new ShapeNode();
            shapenode1.setShape(((java.awt.Shape) (obj1)));
            ClipRable cliprable1 = CSSUtilities.convertClipPath(element2, shapenode1, bridgecontext);
            if(cliprable1 != null)
            {
                Area area1 = new Area(((java.awt.Shape) (obj1)));
                area1.subtract(new Area(cliprable1.getClipPath()));
                obj1 = area1;
            }
            area.add(new Area(((java.awt.Shape) (obj1))));
        }

        if(!flag)
            return null;
        ShapeNode shapenode = new ShapeNode();
        shapenode.setShape(area);
        ClipRable cliprable = CSSUtilities.convertClipPath(element, shapenode, bridgecontext);
        if(cliprable != null)
            area.subtract(new Area(cliprable.getClipPath()));
        org.apache.batik.ext.awt.image.renderable.Filter filter = graphicsnode.getFilter();
        if(filter == null)
            filter = graphicsnode.getGraphicsNodeRable(true);
        boolean flag1 = false;
        RenderingHints renderinghints = CSSUtilities.convertShapeRendering(element, null);
        if(renderinghints != null)
        {
            Object obj = renderinghints.get(RenderingHints.KEY_ANTIALIASING);
            flag1 = obj == RenderingHints.VALUE_ANTIALIAS_ON;
        }
        return new ClipRable8Bit(filter, area, flag1);
    }
}
