// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.batik.dom.svg.SVGOMElement;
import org.apache.batik.dom.svg.SVGSVGContext;
import org.apache.batik.ext.awt.image.renderable.ClipRable8Bit;
import org.apache.batik.gvt.CanvasGraphicsNode;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.ShapeNode;
import org.apache.batik.gvt.TextNode;
import org.apache.batik.gvt.text.GVTAttributedCharacterIterator;
import org.apache.batik.parser.UnitProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.events.MutationEvent;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGRect;

// Referenced classes of package org.apache.batik.bridge:
//            SVGGElementBridge, SVGTextElementBridge, BridgeContext, SVGUtilities, 
//            UnitProcessor, CSSUtilities, ViewBox, UserAgent, 
//            Bridge, Viewport

public class SVGSVGElementBridge extends SVGGElementBridge
    implements SVGSVGContext
{
    public static class SVGSVGElementViewport
        implements Viewport
    {

        public float getWidth()
        {
            return width;
        }

        public float getHeight()
        {
            return height;
        }

        private float width;
        private float height;

        public SVGSVGElementViewport(float f, float f1)
        {
            width = f;
            height = f1;
        }
    }


    public SVGSVGElementBridge()
    {
    }

    public String getLocalName()
    {
        return "svg";
    }

    public Bridge getInstance()
    {
        return new SVGSVGElementBridge();
    }

    protected GraphicsNode instantiateGraphicsNode()
    {
        return new CanvasGraphicsNode();
    }

    public GraphicsNode createGraphicsNode(BridgeContext bridgecontext, Element element)
    {
        if(!SVGUtilities.matchUserAgent(element, bridgecontext.getUserAgent()))
            return null;
        CanvasGraphicsNode canvasgraphicsnode = (CanvasGraphicsNode)instantiateGraphicsNode();
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        boolean flag = svgdocument.getRootElement() == element;
        float f = 0.0F;
        float f1 = 0.0F;
        if(!flag)
        {
            String s = element.getAttributeNS(null, "x");
            if(s.length() != 0)
                f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x", context);
            s = element.getAttributeNS(null, "y");
            if(s.length() != 0)
                f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s, "y", context);
        }
        String s1 = element.getAttributeNS(null, "width");
        if(s1.length() == 0)
            s1 = "100%";
        float f2 = UnitProcessor.svgHorizontalLengthToUserSpace(s1, "width", context);
        s1 = element.getAttributeNS(null, "height");
        if(s1.length() == 0)
            s1 = "100%";
        float f3 = UnitProcessor.svgVerticalLengthToUserSpace(s1, "height", context);
        canvasgraphicsnode.setVisible(CSSUtilities.convertVisibility(element));
        AffineTransform affinetransform = ViewBox.getPreserveAspectRatioTransform(element, f2, f3);
        float f4 = f2;
        float f5 = f3;
        try
        {
            AffineTransform affinetransform1 = affinetransform.createInverse();
            f4 = (float)((double)f2 * affinetransform1.getScaleX());
            f5 = (float)((double)f3 * affinetransform1.getScaleY());
        }
        catch(NoninvertibleTransformException noninvertibletransformexception) { }
        AffineTransform affinetransform2 = AffineTransform.getTranslateInstance(f, f1);
        if(!flag)
            canvasgraphicsnode.setPositionTransform(affinetransform2);
        else
        if(svgdocument == bridgecontext.getDocument())
            bridgecontext.setDocumentSize(new Dimension((int)(f2 + 0.5F), (int)(f3 + 0.5F)));
        canvasgraphicsnode.setViewingTransform(affinetransform);
        Object obj = null;
        if(CSSUtilities.convertOverflow(element))
        {
            float af[] = CSSUtilities.convertClip(element);
            if(af == null)
                obj = new java.awt.geom.Rectangle2D.Float(f, f1, f2, f3);
            else
                obj = new java.awt.geom.Rectangle2D.Float(f + af[3], f1 + af[0], f2 - af[1] - af[3], f3 - af[2] - af[0]);
        }
        if(obj != null)
            try
            {
                AffineTransform affinetransform3 = new AffineTransform(affinetransform2);
                affinetransform3.concatenate(affinetransform);
                affinetransform3 = affinetransform3.createInverse();
                obj = affinetransform3.createTransformedShape(((Shape) (obj)));
                org.apache.batik.ext.awt.image.renderable.Filter filter = canvasgraphicsnode.getGraphicsNodeRable(true);
                canvasgraphicsnode.setClip(new ClipRable8Bit(filter, ((Shape) (obj))));
            }
            catch(NoninvertibleTransformException noninvertibletransformexception1) { }
        java.awt.RenderingHints renderinghints = null;
        renderinghints = CSSUtilities.convertColorRendering(element, renderinghints);
        if(renderinghints != null)
            canvasgraphicsnode.setRenderingHints(renderinghints);
        Rectangle2D rectangle2d = CSSUtilities.convertEnableBackground(element);
        if(rectangle2d != null)
            canvasgraphicsnode.setBackgroundEnable(rectangle2d);
        bridgecontext.openViewport(element, new SVGSVGElementViewport(f4, f5));
        return canvasgraphicsnode;
    }

    public void buildGraphicsNode(BridgeContext bridgecontext, Element element, GraphicsNode graphicsnode)
    {
        graphicsnode.setComposite(CSSUtilities.convertOpacity(element));
        graphicsnode.setFilter(CSSUtilities.convertFilter(element, graphicsnode, bridgecontext));
        graphicsnode.setMask(CSSUtilities.convertMask(element, graphicsnode, bridgecontext));
        graphicsnode.setPointerEventType(CSSUtilities.convertPointerEvents(element));
        initializeDynamicSupport(bridgecontext, element, graphicsnode);
        bridgecontext.closeViewport(element);
    }

    public void dispose()
    {
        ctx.removeViewport(e);
        super.dispose();
    }

    public void handleDOMAttrModifiedEvent(MutationEvent mutationevent)
    {
        String s = mutationevent.getAttrName();
        boolean flag = false;
        if(s.equals("width") || s.equals("height"))
            flag = true;
        else
        if(s.equals("x") || s.equals("y"))
        {
            SVGDocument svgdocument = (SVGDocument)e.getOwnerDocument();
            boolean flag1 = svgdocument.getRootElement() == e;
            if(!flag1)
            {
                float f = 0.0F;
                float f1 = 0.0F;
                org.apache.batik.parser.UnitProcessor.Context context1 = UnitProcessor.createContext(ctx, e);
                String s3 = e.getAttributeNS(null, "x");
                if(s3.length() != 0)
                    f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s3, "x", context1);
                s3 = e.getAttributeNS(null, "y");
                if(s3.length() != 0)
                    f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s3, "y", context1);
                AffineTransform affinetransform = AffineTransform.getTranslateInstance(f, f1);
                CanvasGraphicsNode canvasgraphicsnode = (CanvasGraphicsNode)node;
                canvasgraphicsnode.setPositionTransform(affinetransform);
            }
        } else
        if(s.equals("viewBox") || s.equals("preserveAspectRatio"))
        {
            SVGDocument svgdocument1 = (SVGDocument)e.getOwnerDocument();
            boolean flag2 = svgdocument1.getRootElement() == e;
            org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(ctx, e);
            float f2 = 0.0F;
            float f3 = 0.0F;
            if(!flag2)
            {
                String s1 = e.getAttributeNS(null, "x");
                if(s1.length() != 0)
                    f2 = UnitProcessor.svgHorizontalCoordinateToUserSpace(s1, "x", context);
                s1 = e.getAttributeNS(null, "y");
                if(s1.length() != 0)
                    f3 = UnitProcessor.svgVerticalCoordinateToUserSpace(s1, "y", context);
            }
            String s2 = e.getAttributeNS(null, "width");
            if(s2.length() == 0)
                s2 = "100%";
            float f4 = UnitProcessor.svgHorizontalLengthToUserSpace(s2, "width", context);
            s2 = e.getAttributeNS(null, "height");
            if(s2.length() == 0)
                s2 = "100%";
            float f5 = UnitProcessor.svgVerticalLengthToUserSpace(s2, "height", context);
            CanvasGraphicsNode canvasgraphicsnode1 = (CanvasGraphicsNode)node;
            AffineTransform affinetransform1 = ViewBox.getPreserveAspectRatioTransform(e, f4, f5);
            AffineTransform affinetransform2 = canvasgraphicsnode1.getViewingTransform();
            if(affinetransform1.getScaleX() != affinetransform2.getScaleX() || affinetransform1.getScaleY() != affinetransform2.getScaleY() || affinetransform1.getShearX() != affinetransform2.getShearX() || affinetransform1.getShearY() != affinetransform2.getShearY())
            {
                flag = true;
            } else
            {
                canvasgraphicsnode1.setViewingTransform(affinetransform1);
                Object obj = null;
                if(CSSUtilities.convertOverflow(e))
                {
                    float af[] = CSSUtilities.convertClip(e);
                    if(af == null)
                        obj = new java.awt.geom.Rectangle2D.Float(f2, f3, f4, f5);
                    else
                        obj = new java.awt.geom.Rectangle2D.Float(f2 + af[3], f3 + af[0], f4 - af[1] - af[3], f5 - af[2] - af[0]);
                }
                if(obj != null)
                    try
                    {
                        AffineTransform affinetransform3 = canvasgraphicsnode1.getPositionTransform();
                        affinetransform3 = new AffineTransform(affinetransform3);
                        affinetransform3.concatenate(affinetransform1);
                        affinetransform3 = affinetransform3.createInverse();
                        obj = affinetransform3.createTransformedShape(((Shape) (obj)));
                        org.apache.batik.ext.awt.image.renderable.Filter filter = canvasgraphicsnode1.getGraphicsNodeRable(true);
                        canvasgraphicsnode1.setClip(new ClipRable8Bit(filter, ((Shape) (obj))));
                    }
                    catch(NoninvertibleTransformException noninvertibletransformexception) { }
            }
        }
        if(flag)
        {
            CompositeGraphicsNode compositegraphicsnode = node.getParent();
            compositegraphicsnode.remove(node);
            disposeTree(e);
            handleElementAdded(compositegraphicsnode, e.getParentNode(), e);
        }
    }

    public java.util.List getIntersectionList(SVGRect svgrect, Element element)
    {
        ArrayList arraylist = new ArrayList();
        java.awt.geom.Rectangle2D.Float float1 = new java.awt.geom.Rectangle2D.Float(svgrect.getX(), svgrect.getY(), svgrect.getWidth(), svgrect.getHeight());
        GraphicsNode graphicsnode = ctx.getGraphicsNode(e);
        if(graphicsnode == null)
            return arraylist;
        Rectangle2D rectangle2d = graphicsnode.getSensitiveBounds();
        if(rectangle2d == null)
            return arraylist;
        if(!float1.intersects(rectangle2d))
            return arraylist;
        Element element1 = e;
        AffineTransform affinetransform = graphicsnode.getGlobalTransform();
        try
        {
            affinetransform = affinetransform.createInverse();
        }
        catch(NoninvertibleTransformException noninvertibletransformexception) { }
        Node node;
        for(node = element1.getFirstChild(); node != null && !(node instanceof Element); node = node.getNextSibling());
        if(node == null)
            return arraylist;
        Element element2 = (Element)node;
        Set set = null;
        if(element != null)
        {
            set = getAncestors(element, element1);
            if(set == null)
                element = null;
        }
        do
        {
            if(element2 == null)
                break;
            String s = element2.getNamespaceURI();
            String s1 = element2.getLocalName();
            boolean flag = "http://www.w3.org/2000/svg".equals(s) && ("g".equals(s1) || "svg".equals(s1) || "a".equals(s1));
            GraphicsNode graphicsnode1 = ctx.getGraphicsNode(element2);
            if(graphicsnode1 == null)
            {
                if(set != null && set.contains(element2))
                    break;
                element2 = getNext(element2, element1, element);
                continue;
            }
            AffineTransform affinetransform1 = graphicsnode1.getGlobalTransform();
            Rectangle2D rectangle2d1 = graphicsnode1.getSensitiveBounds();
            affinetransform1.preConcatenate(affinetransform);
            if(rectangle2d1 != null)
                rectangle2d1 = affinetransform1.createTransformedShape(rectangle2d1).getBounds2D();
            if(rectangle2d1 == null || !float1.intersects(rectangle2d1))
            {
                if(set != null && set.contains(element2))
                    break;
                element2 = getNext(element2, element1, element);
                continue;
            }
            if(flag)
            {
                Node node1;
                for(node1 = element2.getFirstChild(); node1 != null && !(node1 instanceof Element); node1 = node1.getNextSibling());
                if(node1 != null)
                {
                    element2 = (Element)node1;
                    continue;
                }
            } else
            {
                if(element2 == element)
                    break;
                if("http://www.w3.org/2000/svg".equals(s) && "use".equals(s1) && float1.contains(rectangle2d1))
                    arraylist.add(element2);
                if(graphicsnode1 instanceof ShapeNode)
                {
                    ShapeNode shapenode = (ShapeNode)graphicsnode1;
                    Shape shape = shapenode.getSensitiveArea();
                    if(shape != null)
                    {
                        shape = affinetransform1.createTransformedShape(shape);
                        if(shape.intersects(float1))
                            arraylist.add(element2);
                    }
                } else
                if(graphicsnode1 instanceof TextNode)
                {
                    SVGOMElement svgomelement = (SVGOMElement)element2;
                    SVGTextElementBridge svgtextelementbridge = (SVGTextElementBridge)svgomelement.getSVGContext();
                    Set set1 = svgtextelementbridge.getTextIntersectionSet(affinetransform1, float1);
                    if(set != null && set.contains(element2))
                        filterChildren(element2, element, set1, arraylist);
                    else
                        arraylist.addAll(set1);
                } else
                {
                    arraylist.add(element2);
                }
            }
            element2 = getNext(element2, element1, element);
        } while(true);
        return arraylist;
    }

    public java.util.List getEnclosureList(SVGRect svgrect, Element element)
    {
        ArrayList arraylist = new ArrayList();
        java.awt.geom.Rectangle2D.Float float1 = new java.awt.geom.Rectangle2D.Float(svgrect.getX(), svgrect.getY(), svgrect.getWidth(), svgrect.getHeight());
        GraphicsNode graphicsnode = ctx.getGraphicsNode(e);
        if(graphicsnode == null)
            return arraylist;
        Rectangle2D rectangle2d = graphicsnode.getSensitiveBounds();
        if(rectangle2d == null)
            return arraylist;
        if(!float1.intersects(rectangle2d))
            return arraylist;
        Element element1 = e;
        AffineTransform affinetransform = graphicsnode.getGlobalTransform();
        try
        {
            affinetransform = affinetransform.createInverse();
        }
        catch(NoninvertibleTransformException noninvertibletransformexception) { }
        Node node;
        for(node = element1.getFirstChild(); node != null && !(node instanceof Element); node = node.getNextSibling());
        if(node == null)
            return arraylist;
        Element element2 = (Element)node;
        Set set = null;
        if(element != null)
        {
            set = getAncestors(element, element1);
            if(set == null)
                element = null;
        }
        do
        {
            if(element2 == null)
                break;
            String s = element2.getNamespaceURI();
            String s1 = element2.getLocalName();
            boolean flag = "http://www.w3.org/2000/svg".equals(s) && ("g".equals(s1) || "svg".equals(s1) || "a".equals(s1));
            GraphicsNode graphicsnode1 = ctx.getGraphicsNode(element2);
            if(graphicsnode1 == null)
            {
                if(set != null && set.contains(element2))
                    break;
                element2 = getNext(element2, element1, element);
                continue;
            }
            AffineTransform affinetransform1 = graphicsnode1.getGlobalTransform();
            Rectangle2D rectangle2d1 = graphicsnode1.getSensitiveBounds();
            affinetransform1.preConcatenate(affinetransform);
            if(rectangle2d1 != null)
                rectangle2d1 = affinetransform1.createTransformedShape(rectangle2d1).getBounds2D();
            if(rectangle2d1 == null || !float1.intersects(rectangle2d1))
            {
                if(set != null && set.contains(element2))
                    break;
                element2 = getNext(element2, element1, element);
                continue;
            }
            if(flag)
            {
                Node node1;
                for(node1 = element2.getFirstChild(); node1 != null && !(node1 instanceof Element); node1 = node1.getNextSibling());
                if(node1 != null)
                {
                    element2 = (Element)node1;
                    continue;
                }
            } else
            {
                if(element2 == element)
                    break;
                if("http://www.w3.org/2000/svg".equals(s) && "use".equals(s1))
                {
                    if(float1.contains(rectangle2d1))
                        arraylist.add(element2);
                } else
                if(graphicsnode1 instanceof TextNode)
                {
                    SVGOMElement svgomelement = (SVGOMElement)element2;
                    SVGTextElementBridge svgtextelementbridge = (SVGTextElementBridge)svgomelement.getSVGContext();
                    Set set1 = svgtextelementbridge.getTextEnclosureSet(affinetransform1, float1);
                    if(set != null && set.contains(element2))
                        filterChildren(element2, element, set1, arraylist);
                    else
                        arraylist.addAll(set1);
                } else
                if(float1.contains(rectangle2d1))
                    arraylist.add(element2);
            }
            element2 = getNext(element2, element1, element);
        } while(true);
        return arraylist;
    }

    public boolean checkIntersection(Element element, SVGRect svgrect)
    {
        GraphicsNode graphicsnode = ctx.getGraphicsNode(e);
        if(graphicsnode == null)
            return false;
        java.awt.geom.Rectangle2D.Float float1 = new java.awt.geom.Rectangle2D.Float(svgrect.getX(), svgrect.getY(), svgrect.getWidth(), svgrect.getHeight());
        AffineTransform affinetransform = graphicsnode.getGlobalTransform();
        try
        {
            affinetransform = affinetransform.createInverse();
        }
        catch(NoninvertibleTransformException noninvertibletransformexception) { }
        Object obj = null;
        if(element instanceof SVGOMElement)
        {
            org.apache.batik.dom.svg.SVGContext svgcontext = ((SVGOMElement)element).getSVGContext();
            if((svgcontext instanceof SVGTextElementBridge) || (svgcontext instanceof SVGTextElementBridge.AbstractTextChildSVGContext))
                return SVGTextElementBridge.getTextIntersection(ctx, element, affinetransform, float1, true);
        }
        Rectangle2D rectangle2d = null;
        GraphicsNode graphicsnode1 = ctx.getGraphicsNode(element);
        if(graphicsnode1 != null)
            rectangle2d = graphicsnode1.getSensitiveBounds();
        if(rectangle2d == null)
            return false;
        AffineTransform affinetransform1 = graphicsnode1.getGlobalTransform();
        affinetransform1.preConcatenate(affinetransform);
        rectangle2d = affinetransform1.createTransformedShape(rectangle2d).getBounds2D();
        if(!float1.intersects(rectangle2d))
            return false;
        if(!(graphicsnode1 instanceof ShapeNode))
            return true;
        ShapeNode shapenode = (ShapeNode)graphicsnode1;
        Shape shape = shapenode.getSensitiveArea();
        if(shape == null)
            return false;
        shape = affinetransform1.createTransformedShape(shape);
        return shape.intersects(float1);
    }

    public boolean checkEnclosure(Element element, SVGRect svgrect)
    {
        GraphicsNode graphicsnode = ctx.getGraphicsNode(element);
        Rectangle2D rectangle2d = null;
        Object obj = null;
        if(element instanceof SVGOMElement)
        {
            org.apache.batik.dom.svg.SVGContext svgcontext = ((SVGOMElement)element).getSVGContext();
            if((svgcontext instanceof SVGTextElementBridge) || (svgcontext instanceof SVGTextElementBridge.AbstractTextChildSVGContext))
            {
                rectangle2d = SVGTextElementBridge.getTextBounds(ctx, element, true);
                for(Element element1 = (Element)element.getParentNode(); element1 != null && graphicsnode == null; element1 = (Element)element1.getParentNode())
                    graphicsnode = ctx.getGraphicsNode(element1);

            } else
            if(graphicsnode != null)
                rectangle2d = graphicsnode.getSensitiveBounds();
        } else
        if(graphicsnode != null)
            rectangle2d = graphicsnode.getSensitiveBounds();
        if(rectangle2d == null)
            return false;
        GraphicsNode graphicsnode1 = ctx.getGraphicsNode(e);
        if(graphicsnode1 == null)
            return false;
        java.awt.geom.Rectangle2D.Float float1 = new java.awt.geom.Rectangle2D.Float(svgrect.getX(), svgrect.getY(), svgrect.getWidth(), svgrect.getHeight());
        AffineTransform affinetransform = graphicsnode1.getGlobalTransform();
        try
        {
            affinetransform = affinetransform.createInverse();
        }
        catch(NoninvertibleTransformException noninvertibletransformexception) { }
        AffineTransform affinetransform1 = graphicsnode.getGlobalTransform();
        affinetransform1.preConcatenate(affinetransform);
        rectangle2d = affinetransform1.createTransformedShape(rectangle2d).getBounds2D();
        return float1.contains(rectangle2d);
    }

    public boolean filterChildren(Element element, Element element1, Set set, java.util.List list)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
            if((node instanceof Element) && filterChildren((Element)node, element1, set, list))
                return true;

        if(element == element1)
            return true;
        if(set.contains(element))
            list.add(element);
        return false;
    }

    protected Set getAncestors(Element element, Element element1)
    {
        HashSet hashset = new HashSet();
        Element element2 = element;
        do
        {
            hashset.add(element2);
            element2 = (Element)element2.getParentNode();
        } while(element2 != null && element2 != element1);
        if(element2 == null)
            return null;
        else
            return hashset;
    }

    protected Element getNext(Element element, Element element1, Element element2)
    {
        Node node;
        for(node = element.getNextSibling(); node != null && !(node instanceof Element); node = node.getNextSibling());
        do
        {
            if(node != null)
                break;
            element = (Element)element.getParentNode();
            if(element == element2 || element == element1)
            {
                node = null;
                break;
            }
            node = element.getNextSibling();
            while(node != null && !(node instanceof Element)) 
                node = node.getNextSibling();
        } while(true);
        return (Element)node;
    }

    public void deselectAll()
    {
        ctx.getUserAgent().deselectAll();
    }

    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER;

    static 
    {
        TEXT_COMPOUND_DELIMITER = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.TEXT_COMPOUND_DELIMITER;
    }
}
