// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.Shape;
import java.awt.geom.*;
import java.util.Map;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.ext.awt.image.spi.ImageTagRegistry;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, BridgeException, SVGUtilities, BridgeContext, 
//            GVTBuilder

public class SVGFeImageElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{

    public SVGFeImageElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feImage";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Rectangle2D rectangle2d, Map map)
    {
        String s = XLinkSupport.getXLinkHref(element);
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "xlink:href"
            });
        Document document = element.getOwnerDocument();
        boolean flag = s.indexOf("#") != -1;
        Element element2 = null;
        if(flag)
            element2 = document.createElementNS("http://www.w3.org/2000/svg", "use");
        else
            element2 = document.createElementNS("http://www.w3.org/2000/svg", "image");
        element2.setAttributeNS("http://www.w3.org/1999/xlink", "xlink:href", s);
        Element element3 = document.createElementNS("http://www.w3.org/2000/svg", "g");
        element3.appendChild(element2);
        Rectangle2D rectangle2d1 = rectangle2d;
        AffineTransform affinetransform = new AffineTransform();
        Element element4 = (Element)element.getParentNode();
        boolean flag1 = false;
        String s1 = SVGUtilities.getChainableAttributeNS(element4, null, "primitiveUnits", bridgecontext);
        short word0;
        if(s1.length() == 0)
            word0 = 1;
        else
            word0 = SVGUtilities.parseCoordinateSystem(element4, "primitiveUnits", s1);
        if(word0 == 2)
        {
            flag1 = true;
            affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
        }
        Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        Rectangle2D rectangle2d3 = rectangle2d2;
        if(flag1)
            try
            {
                AffineTransform affinetransform1 = affinetransform.createInverse();
                rectangle2d3 = affinetransform1.createTransformedShape(rectangle2d3).getBounds2D();
            }
            catch(NoninvertibleTransformException noninvertibletransformexception)
            {
                throw new Error();
            }
        element2.setAttributeNS(null, "x", "" + rectangle2d3.getX());
        element2.setAttributeNS(null, "y", "" + rectangle2d3.getY());
        element2.setAttributeNS(null, "width", "" + rectangle2d3.getWidth());
        element2.setAttributeNS(null, "height", "" + rectangle2d3.getHeight());
        GraphicsNode graphicsnode1 = bridgecontext.getGVTBuilder().build(bridgecontext, element3);
        Object obj = graphicsnode1.getGraphicsNodeRable(true);
        obj = new AffineRable8Bit(((Filter) (obj)), affinetransform);
        handleColorInterpolationFilters(((Filter) (obj)), element);
        obj = new PadRable8Bit(((Filter) (obj)), rectangle2d2, PadMode.ZERO_PAD);
        updateFilterMap(element, ((Filter) (obj)), map);
        return ((Filter) (obj));
    }

    protected static Filter createSVGFeImage(BridgeContext bridgecontext, Rectangle2D rectangle2d, Element element, boolean flag, Element element1, GraphicsNode graphicsnode)
    {
        GraphicsNode graphicsnode1 = bridgecontext.getGVTBuilder().build(bridgecontext, element);
        Filter filter = graphicsnode1.getGraphicsNodeRable(true);
        AffineTransform affinetransform = new AffineTransform();
        if(flag)
        {
            Element element2 = (Element)element1.getParentNode();
            String s = SVGUtilities.getChainableAttributeNS(element2, null, "primitiveUnits", bridgecontext);
            short word0;
            if(s.length() == 0)
                word0 = 1;
            else
                word0 = SVGUtilities.parseCoordinateSystem(element2, "primitiveUnits", s);
            if(word0 == 2)
                affinetransform = SVGUtilities.toObjectBBox(affinetransform, graphicsnode);
            Rectangle2D rectangle2d1 = graphicsnode.getGeometryBounds();
            affinetransform.preConcatenate(AffineTransform.getTranslateInstance(rectangle2d.getX() - rectangle2d1.getX(), rectangle2d.getY() - rectangle2d1.getY()));
        } else
        {
            affinetransform.translate(rectangle2d.getX(), rectangle2d.getY());
        }
        return new AffineRable8Bit(filter, affinetransform);
    }

    protected static Filter createRasterFeImage(BridgeContext bridgecontext, Rectangle2D rectangle2d, ParsedURL parsedurl)
    {
        Filter filter = ImageTagRegistry.getRegistry().readURL(parsedurl);
        Rectangle2D rectangle2d1 = filter.getBounds2D();
        AffineTransform affinetransform = new AffineTransform();
        affinetransform.translate(rectangle2d.getX(), rectangle2d.getY());
        affinetransform.scale(rectangle2d.getWidth() / (rectangle2d1.getWidth() - 1.0D), rectangle2d.getHeight() / (rectangle2d1.getHeight() - 1.0D));
        affinetransform.translate(-rectangle2d1.getX(), -rectangle2d1.getY());
        return new AffineRable8Bit(filter, affinetransform);
    }
}
