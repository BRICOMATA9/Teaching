// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction;
import org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit;
import org.apache.batik.gvt.AbstractGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.PatternPaint;
import org.apache.batik.gvt.RootGraphicsNode;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, PaintBridge, ErrorConstants, BridgeContext, 
//            SVGUtilities, CSSUtilities, ViewBox, BridgeException, 
//            GVTBuilder

public class SVGPatternElementBridge extends AbstractSVGBridge
    implements PaintBridge, ErrorConstants
{
    public static class PatternGraphicsNode extends AbstractGraphicsNode
    {

        public void primitivePaint(Graphics2D graphics2d)
        {
            pcn.paint(graphics2d);
        }

        public Rectangle2D getPrimitiveBounds()
        {
            if(pBounds != null)
            {
                return pBounds;
            } else
            {
                pBounds = pcn.getTransformedBounds(GraphicsNode.IDENTITY);
                return pBounds;
            }
        }

        public Rectangle2D getGeometryBounds()
        {
            if(gBounds != null)
            {
                return gBounds;
            } else
            {
                gBounds = pcn.getTransformedGeometryBounds(GraphicsNode.IDENTITY);
                return gBounds;
            }
        }

        public Rectangle2D getSensitiveBounds()
        {
            if(sBounds != null)
            {
                return sBounds;
            } else
            {
                sBounds = pcn.getTransformedSensitiveBounds(GraphicsNode.IDENTITY);
                return sBounds;
            }
        }

        public Shape getOutline()
        {
            if(oShape != null)
                return oShape;
            oShape = pcn.getOutline();
            AffineTransform affinetransform = pcn.getTransform();
            if(affinetransform != null)
                oShape = affinetransform.createTransformedShape(oShape);
            return oShape;
        }

        protected void invalidateGeometryCache()
        {
            pBounds = null;
            gBounds = null;
            sBounds = null;
            oShape = null;
            super.invalidateGeometryCache();
        }

        GraphicsNode pcn;
        Rectangle2D pBounds;
        Rectangle2D gBounds;
        Rectangle2D sBounds;
        Shape oShape;

        public PatternGraphicsNode(GraphicsNode graphicsnode)
        {
            pcn = graphicsnode;
        }
    }


    public SVGPatternElementBridge()
    {
    }

    public String getLocalName()
    {
        return "pattern";
    }

    public Paint createPaint(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, float f)
    {
        RootGraphicsNode rootgraphicsnode = (RootGraphicsNode)bridgecontext.getElementData(element);
        if(rootgraphicsnode == null)
        {
            rootgraphicsnode = extractPatternContent(element, bridgecontext);
            bridgecontext.setElementData(element, rootgraphicsnode);
        }
        if(rootgraphicsnode == null)
            return null;
        Rectangle2D rectangle2d = SVGUtilities.convertPatternRegion(element, element1, graphicsnode, bridgecontext);
        String s = SVGUtilities.getChainableAttributeNS(element, null, "patternTransform", bridgecontext);
        AffineTransform affinetransform;
        if(s.length() != 0)
            affinetransform = SVGUtilities.convertTransform(element, "patternTransform", s);
        else
            affinetransform = new AffineTransform();
        boolean flag = CSSUtilities.convertOverflow(element);
        s = SVGUtilities.getChainableAttributeNS(element, null, "patternContentUnits", bridgecontext);
        short word0;
        if(s.length() == 0)
            word0 = 1;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element, "patternContentUnits", s);
        AffineTransform affinetransform1 = new AffineTransform();
        affinetransform1.translate(rectangle2d.getX(), rectangle2d.getY());
        String s1 = SVGUtilities.getChainableAttributeNS(element, null, "viewBox", bridgecontext);
        if(s1.length() > 0)
        {
            String s2 = SVGUtilities.getChainableAttributeNS(element, null, "preserveAspectRatio", bridgecontext);
            float f1 = (float)rectangle2d.getWidth();
            float f2 = (float)rectangle2d.getHeight();
            AffineTransform affinetransform3 = ViewBox.getPreserveAspectRatioTransform(element, s1, s2, f1, f2);
            affinetransform1.concatenate(affinetransform3);
        } else
        if(word0 == 2)
        {
            AffineTransform affinetransform2 = new AffineTransform();
            Rectangle2D rectangle2d1 = graphicsnode.getGeometryBounds();
            affinetransform2.translate(rectangle2d1.getX(), rectangle2d1.getY());
            affinetransform2.scale(rectangle2d1.getWidth(), rectangle2d1.getHeight());
            affinetransform1.concatenate(affinetransform2);
        }
        PatternGraphicsNode patterngraphicsnode = new PatternGraphicsNode(rootgraphicsnode);
        patterngraphicsnode.setTransform(affinetransform1);
        if(f != 1.0F)
        {
            Object obj = patterngraphicsnode.getGraphicsNodeRable(true);
            obj = new ComponentTransferRable8Bit(((org.apache.batik.ext.awt.image.renderable.Filter) (obj)), ConcreteComponentTransferFunction.getLinearTransfer(f, 0.0F), ConcreteComponentTransferFunction.getIdentityTransfer(), ConcreteComponentTransferFunction.getIdentityTransfer(), ConcreteComponentTransferFunction.getIdentityTransfer());
            patterngraphicsnode.setFilter(((org.apache.batik.ext.awt.image.renderable.Filter) (obj)));
        }
        return new PatternPaint(patterngraphicsnode, rectangle2d, !flag, affinetransform);
    }

    protected static RootGraphicsNode extractPatternContent(Element element, BridgeContext bridgecontext)
    {
        LinkedList linkedlist = new LinkedList();
        do
        {
            RootGraphicsNode rootgraphicsnode = extractLocalPatternContent(element, bridgecontext);
            if(rootgraphicsnode != null)
                return rootgraphicsnode;
            String s = XLinkSupport.getXLinkHref(element);
            if(s.length() == 0)
                return null;
            SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
            ParsedURL parsedurl = new ParsedURL(svgomdocument.getURL(), s);
            if(!parsedurl.complete())
                throw new BridgeException(element, "uri.malformed", new Object[] {
                    s
                });
            if(contains(linkedlist, parsedurl))
                throw new BridgeException(element, "xlink.href.circularDependencies", new Object[] {
                    s
                });
            linkedlist.add(parsedurl);
            element = bridgecontext.getReferencedElement(element, s);
        } while(true);
    }

    protected static RootGraphicsNode extractLocalPatternContent(Element element, BridgeContext bridgecontext)
    {
        GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
        RootGraphicsNode rootgraphicsnode = null;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            GraphicsNode graphicsnode = gvtbuilder.build(bridgecontext, (Element)node);
            if(graphicsnode == null)
                continue;
            if(rootgraphicsnode == null)
                rootgraphicsnode = new RootGraphicsNode();
            rootgraphicsnode.getChildren().add(graphicsnode);
        }

        return rootgraphicsnode;
    }

    private static boolean contains(java.util.List list, ParsedURL parsedurl)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
            if(parsedurl.equals(iterator.next()))
                return true;

        return false;
    }
}
