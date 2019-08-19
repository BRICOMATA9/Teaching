// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.Hashtable;
import java.util.Map;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.dom.svg.XMLBaseSupport;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.*;
import org.apache.batik.ext.awt.image.spi.ImageTagRegistry;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.parser.UnitProcessor;
import org.apache.batik.util.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, CSSUtilities, BridgeException, BridgeContext, 
//            UnitProcessor, URIResolver, GVTBuilder, ViewBox

public class CursorManager
    implements SVGConstants, ErrorConstants
{
    static class CursorCache extends SoftReferenceCache
    {

        public Cursor getCursor(CursorDescriptor cursordescriptor)
        {
            return (Cursor)requestImpl(cursordescriptor);
        }

        public void putCursor(CursorDescriptor cursordescriptor, Cursor cursor)
        {
            putImpl(cursordescriptor, cursor);
        }

        public void clearCursor(CursorDescriptor cursordescriptor)
        {
            clearImpl(cursordescriptor);
        }

        public CursorCache()
        {
        }
    }

    static class CursorDescriptor
    {

        public boolean equals(Object obj)
        {
            if(obj == null || !(obj instanceof CursorDescriptor))
            {
                return false;
            } else
            {
                CursorDescriptor cursordescriptor = (CursorDescriptor)obj;
                boolean flag = purl.equals(cursordescriptor.purl) && x == cursordescriptor.x && y == cursordescriptor.y;
                return flag;
            }
        }

        public String toString()
        {
            return desc;
        }

        public int hashCode()
        {
            return desc.hashCode();
        }

        ParsedURL purl;
        float x;
        float y;
        String desc;

        public CursorDescriptor(ParsedURL parsedurl, float f, float f1)
        {
            if(parsedurl == null)
            {
                throw new IllegalArgumentException();
            } else
            {
                purl = parsedurl;
                x = f;
                y = f1;
                desc = getClass().getName() + "\n\t:[" + purl + "]\n\t:[" + f + "]:[" + f1 + "]";
                return;
            }
        }
    }


    public CursorManager(BridgeContext bridgecontext)
    {
        cursorCache = new CursorCache();
        ctx = bridgecontext;
    }

    public static Cursor getPredefinedCursor(String s)
    {
        return (Cursor)cursorMap.get(s);
    }

    public Cursor convertCursor(Element element)
    {
        Value value = CSSUtilities.getComputedStyle(element, 10);
        String s = "auto";
        if(value != null)
        {
            if(value.getCssValueType() == 1 && value.getPrimitiveType() == 21)
            {
                s = value.getStringValue();
                return convertBuiltInCursor(element, s);
            }
            if(value.getCssValueType() == 2)
            {
                int i = value.getLength();
                if(i == 1)
                {
                    value = value.item(0);
                    if(value.getPrimitiveType() == 21)
                    {
                        s = value.getStringValue();
                        return convertBuiltInCursor(element, s);
                    }
                } else
                if(i > 1)
                    return convertSVGCursor(element, value);
            }
        }
        return convertBuiltInCursor(element, s);
    }

    public Cursor convertBuiltInCursor(Element element, String s)
    {
        Cursor cursor = null;
        if(s.charAt(0) == 'a')
        {
            String s1 = element.getNamespaceURI();
            if("http://www.w3.org/2000/svg".equals(s1))
            {
                String s2 = element.getLocalName();
                if("a".equals(s2))
                    cursor = ANCHOR_CURSOR;
                else
                if("text".equals(s2) || "tspan".equals(s2) || "tref".equals(s2))
                {
                    cursor = TEXT_CURSOR;
                } else
                {
                    if("image".equals(s2))
                        return null;
                    cursor = DEFAULT_CURSOR;
                }
            } else
            {
                cursor = DEFAULT_CURSOR;
            }
        } else
        {
            cursor = getPredefinedCursor(s);
        }
        return cursor;
    }

    public Cursor convertSVGCursor(Element element, Value value)
    {
        int i = value.getLength();
        Element element1 = null;
        for(int j = 0; j < i - 1; j++)
        {
            Value value2 = value.item(j);
            if(value2.getPrimitiveType() != 20)
                continue;
            String s1 = value2.getStringValue();
            try
            {
                element1 = ctx.getReferencedElement(element, s1);
            }
            catch(BridgeException bridgeexception)
            {
                if(!"uri.badTarget".equals(bridgeexception.getCode()))
                    throw bridgeexception;
            }
            if(element1 == null)
                continue;
            String s2 = element1.getNamespaceURI();
            if(!"http://www.w3.org/2000/svg".equals(s2) || !"cursor".equals(element1.getLocalName()))
                continue;
            Cursor cursor = convertSVGCursorElement(element1);
            if(cursor != null)
                return cursor;
        }

        Value value1 = value.item(i - 1);
        String s = "auto";
        if(value1.getPrimitiveType() == 21)
            s = value1.getStringValue();
        return convertBuiltInCursor(element, s);
    }

    public Cursor convertSVGCursorElement(Element element)
    {
        String s = XLinkSupport.getXLinkHref(element);
        if(s.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "xlink:href"
            });
        String s1 = XMLBaseSupport.getCascadedXMLBase(element);
        ParsedURL parsedurl;
        if(s1 == null)
            parsedurl = new ParsedURL(s);
        else
            parsedurl = new ParsedURL(s1, s);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(ctx, element);
        String s2 = element.getAttributeNS(null, "x");
        float f = 0.0F;
        if(s2.length() != 0)
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s2, "x", context);
        s2 = element.getAttributeNS(null, "y");
        float f1 = 0.0F;
        if(s2.length() != 0)
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s2, "y", context);
        CursorDescriptor cursordescriptor = new CursorDescriptor(parsedurl, f, f1);
        Cursor cursor = cursorCache.getCursor(cursordescriptor);
        if(cursor != null)
            return cursor;
        java.awt.geom.Point2D.Float float1 = new java.awt.geom.Point2D.Float(f, f1);
        Filter filter = cursorHrefToFilter(element, parsedurl, float1);
        if(filter == null)
        {
            cursorCache.clearCursor(cursordescriptor);
            return null;
        }
        Rectangle rectangle = filter.getBounds2D().getBounds();
        RenderedImage renderedimage = filter.createScaledRendering(rectangle.width, rectangle.height, null);
        Image image = null;
        if(renderedimage instanceof Image)
            image = (Image)renderedimage;
        else
            image = renderedImageToImage(renderedimage);
        float1.x = float1.x >= 0.0F ? float1.x : 0.0F;
        float1.y = float1.y >= 0.0F ? float1.y : 0.0F;
        float1.x = float1.x <= (float)(rectangle.width - 1) ? float1.x : rectangle.width - 1;
        float1.y = float1.y <= (float)(rectangle.height - 1) ? float1.y : rectangle.height - 1;
        Cursor cursor1 = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(Math.round(float1.x), Math.round(float1.y)), parsedurl.toString());
        cursorCache.putCursor(cursordescriptor, cursor1);
        return cursor1;
    }

    protected Filter cursorHrefToFilter(Element element, ParsedURL parsedurl, Point2D point2d)
    {
        AffineRable8Bit affinerable8bit = null;
        String s = parsedurl.toString();
        Dimension dimension = null;
        DocumentLoader documentloader = ctx.getDocumentLoader();
        SVGDocument svgdocument = (SVGDocument)element.getOwnerDocument();
        URIResolver uriresolver = new URIResolver(svgdocument, documentloader);
        try
        {
            org.w3c.dom.svg.SVGSVGElement svgsvgelement = null;
            Node node = uriresolver.getNode(s, element);
            if(node.getNodeType() == 9)
            {
                SVGDocument svgdocument1 = (SVGDocument)node;
                ctx.initializeDocument(svgdocument1);
                svgsvgelement = svgdocument1.getRootElement();
            } else
            {
                throw new BridgeException(element, "uri.image.invalid", new Object[] {
                    s
                });
            }
            GraphicsNode graphicsnode = ctx.getGVTBuilder().build(ctx, svgsvgelement);
            float f = 32F;
            float f1 = 32F;
            org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(ctx, svgsvgelement);
            String s1 = svgsvgelement.getAttribute("width");
            if(s1.length() != 0)
                f = UnitProcessor.svgHorizontalLengthToUserSpace(s1, "width", context);
            s1 = svgsvgelement.getAttribute("height");
            if(s1.length() != 0)
                f1 = UnitProcessor.svgVerticalLengthToUserSpace(s1, "height", context);
            dimension = Toolkit.getDefaultToolkit().getBestCursorSize(Math.round(f), Math.round(f1));
            AffineTransform affinetransform2 = ViewBox.getPreserveAspectRatioTransform(svgsvgelement, dimension.width, dimension.height);
            Filter filter1 = graphicsnode.getGraphicsNodeRable(true);
            affinerable8bit = new AffineRable8Bit(filter1, affinetransform2);
        }
        catch(BridgeException bridgeexception)
        {
            throw bridgeexception;
        }
        catch(SecurityException securityexception)
        {
            throw new BridgeException(element, "uri.unsecure", new Object[] {
                s
            });
        }
        catch(Exception exception) { }
        if(affinerable8bit == null)
        {
            ImageTagRegistry imagetagregistry = ImageTagRegistry.getRegistry();
            Filter filter = imagetagregistry.readURL(parsedurl);
            if(filter == null)
                return null;
            if(filter.getProperty("org.apache.batik.bridge.BrokenLinkDocument") != null)
                return null;
            Rectangle rectangle1 = filter.getBounds2D().getBounds();
            dimension = Toolkit.getDefaultToolkit().getBestCursorSize(rectangle1.width, rectangle1.height);
            if(rectangle1 != null && rectangle1.width > 0 && rectangle1.height > 0)
            {
                AffineTransform affinetransform1 = new AffineTransform();
                if(rectangle1.width > dimension.width || rectangle1.height > dimension.height)
                    affinetransform1 = ViewBox.getPreserveAspectRatioTransform(new float[] {
                        0.0F, 0.0F, (float)rectangle1.width, (float)rectangle1.height
                    }, (short)2, true, dimension.width, dimension.height);
                affinerable8bit = new AffineRable8Bit(filter, affinetransform1);
            } else
            {
                return null;
            }
        }
        AffineTransform affinetransform = affinerable8bit.getAffine();
        affinetransform.transform(point2d, point2d);
        Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
        PadRable8Bit padrable8bit = new PadRable8Bit(affinerable8bit, rectangle, PadMode.ZERO_PAD);
        return padrable8bit;
    }

    protected Image renderedImageToImage(RenderedImage renderedimage)
    {
        int i = renderedimage.getMinX();
        int j = renderedimage.getMinY();
        java.awt.image.SampleModel samplemodel = renderedimage.getSampleModel();
        ColorModel colormodel = renderedimage.getColorModel();
        java.awt.image.WritableRaster writableraster = Raster.createWritableRaster(samplemodel, new Point(i, j));
        renderedimage.copyData(writableraster);
        return new BufferedImage(colormodel, writableraster, colormodel.isAlphaPremultiplied(), null);
    }

    protected static Map cursorMap;
    public static final Cursor DEFAULT_CURSOR = Cursor.getPredefinedCursor(0);
    public static final Cursor ANCHOR_CURSOR = Cursor.getPredefinedCursor(12);
    public static final Cursor TEXT_CURSOR = Cursor.getPredefinedCursor(2);
    public static final int DEFAULT_PREFERRED_WIDTH = 32;
    public static final int DEFAULT_PREFERRED_HEIGHT = 32;
    protected BridgeContext ctx;
    protected CursorCache cursorCache;

    static 
    {
        cursorMap = new Hashtable();
        cursorMap.put("crosshair", Cursor.getPredefinedCursor(1));
        cursorMap.put("default", Cursor.getPredefinedCursor(0));
        cursorMap.put("pointer", Cursor.getPredefinedCursor(12));
        cursorMap.put("move", Cursor.getPredefinedCursor(13));
        cursorMap.put("e-resize", Cursor.getPredefinedCursor(11));
        cursorMap.put("ne-resize", Cursor.getPredefinedCursor(7));
        cursorMap.put("nw-resize", Cursor.getPredefinedCursor(6));
        cursorMap.put("n-resize", Cursor.getPredefinedCursor(8));
        cursorMap.put("se-resize", Cursor.getPredefinedCursor(5));
        cursorMap.put("sw-resize", Cursor.getPredefinedCursor(4));
        cursorMap.put("s-resize", Cursor.getPredefinedCursor(9));
        cursorMap.put("w-resize", Cursor.getPredefinedCursor(10));
        cursorMap.put("text", Cursor.getPredefinedCursor(2));
        cursorMap.put("wait", Cursor.getPredefinedCursor(3));
        cursorMap.put("help", Cursor.getPredefinedCursor(12));
    }
}
