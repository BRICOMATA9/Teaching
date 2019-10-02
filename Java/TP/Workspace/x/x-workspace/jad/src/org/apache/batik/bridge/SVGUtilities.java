// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.dom.util.XMLSupport;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.parser.AWTTransformProducer;
import org.apache.batik.parser.ParseException;
import org.apache.batik.parser.UnitProcessor;
import org.apache.batik.util.ParsedURL;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;

// Referenced classes of package org.apache.batik.bridge:
//            ErrorConstants, UserAgent, BridgeContext, BridgeException, 
//            URIResolver, UnitProcessor

public abstract class SVGUtilities
    implements SVGConstants, ErrorConstants
{

    protected SVGUtilities()
    {
    }

    public static Node getImportedChild(Node node)
    {
        return CSSEngine.getImportedChild(node);
    }

    public static Element getParentElement(Element element)
    {
        return CSSEngine.getParentElement(element);
    }

    public static float[] convertSVGNumberList(SVGNumberList svgnumberlist)
    {
        int i = svgnumberlist.getNumberOfItems();
        if(i == 0)
            return null;
        float af[] = new float[i];
        for(int j = 0; j < i; j++)
            af[j] = svgnumberlist.getItem(j).getValue();

        return af;
    }

    public static float convertSVGNumber(String s)
    {
        return Float.parseFloat(s);
    }

    public static int convertSVGInteger(String s)
    {
        return Integer.parseInt(s);
    }

    public static float convertRatio(String s)
    {
        float f = 1.0F;
        if(s.endsWith("%"))
        {
            s = s.substring(0, s.length() - 1);
            f = 100F;
        }
        float f1 = Float.parseFloat(s) / f;
        if(f1 < 0.0F)
            f1 = 0.0F;
        else
        if(f1 > 1.0F)
            f1 = 1.0F;
        return f1;
    }

    public static String getDescription(SVGElement svgelement)
    {
        String s = "";
        boolean flag = false;
        Node node = svgelement.getFirstChild();
        if(node != null && node.getNodeType() == 1)
        {
            String s1 = node.getPrefix() != null ? node.getLocalName() : node.getNodeName();
            if(s1.equals("desc"))
            {
                flag = ((SVGLangSpace)node).getXMLspace().equals("preserve");
                for(node = node.getFirstChild(); node != null; node = node.getNextSibling())
                    if(node.getNodeType() == 3)
                        s = s + node.getNodeValue();

            }
        }
        return flag ? XMLSupport.preserveXMLSpace(s) : XMLSupport.defaultXMLSpace(s);
    }

    public static boolean matchUserAgent(Element element, UserAgent useragent)
    {
label0:
        {
            if(!element.hasAttributeNS(null, "systemLanguage"))
                break label0;
            String s = element.getAttributeNS(null, "systemLanguage");
            if(s.length() == 0)
                return false;
            for(StringTokenizer stringtokenizer = new StringTokenizer(s, ", "); stringtokenizer.hasMoreTokens();)
            {
                String s3 = stringtokenizer.nextToken();
                if(matchUserLanguage(s3, useragent.getLanguages()))
                    break label0;
            }

            return false;
        }
label1:
        {
            if(!element.hasAttributeNS(null, "requiredFeatures"))
                break label1;
            String s1 = element.getAttributeNS(null, "requiredFeatures");
            if(s1.length() == 0)
                return false;
            StringTokenizer stringtokenizer1 = new StringTokenizer(s1, " ");
            String s4;
            do
            {
                if(!stringtokenizer1.hasMoreTokens())
                    break label1;
                s4 = stringtokenizer1.nextToken();
            } while(useragent.hasFeature(s4));
            return false;
        }
label2:
        {
            if(!element.hasAttributeNS(null, "requiredExtensions"))
                break label2;
            String s2 = element.getAttributeNS(null, "requiredExtensions");
            if(s2.length() == 0)
                return false;
            StringTokenizer stringtokenizer2 = new StringTokenizer(s2, " ");
            String s5;
            do
            {
                if(!stringtokenizer2.hasMoreTokens())
                    break label2;
                s5 = stringtokenizer2.nextToken();
            } while(useragent.supportExtension(s5));
            return false;
        }
        return true;
    }

    protected static boolean matchUserLanguage(String s, String s1)
    {
        for(StringTokenizer stringtokenizer = new StringTokenizer(s1, ", "); stringtokenizer.hasMoreTokens();)
        {
            String s2 = stringtokenizer.nextToken();
            if(s.startsWith(s2))
                if(s.length() > s2.length())
                    return s.charAt(s2.length()) == '-';
                else
                    return true;
        }

        return false;
    }

    public static String getChainableAttributeNS(Element element, String s, String s1, BridgeContext bridgecontext)
    {
        DocumentLoader documentloader = bridgecontext.getDocumentLoader();
        Element element1 = element;
        LinkedList linkedlist = new LinkedList();
        do
        {
            String s2 = element1.getAttributeNS(s, s1);
            if(s2.length() > 0)
                return s2;
            String s3 = XLinkSupport.getXLinkHref(element1);
            if(s3.length() == 0)
                return "";
            SVGDocument svgdocument = (SVGDocument)element1.getOwnerDocument();
            String s4 = ((SVGOMDocument)svgdocument).getURL();
            ParsedURL parsedurl = new ParsedURL(s4, s3);
            if(!parsedurl.complete())
                throw new BridgeException(element1, "uri.malformed", new Object[] {
                    s3
                });
            for(Iterator iterator = linkedlist.iterator(); iterator.hasNext();)
                if(parsedurl.equals(iterator.next()))
                    throw new BridgeException(element1, "xlink.href.circularDependencies", new Object[] {
                        s3
                    });

            try
            {
                URIResolver uriresolver = new URIResolver(svgdocument, documentloader);
                element1 = uriresolver.getElement(parsedurl.toString(), element1);
                linkedlist.add(parsedurl);
            }
            catch(IOException ioexception)
            {
                throw new BridgeException(element1, "uri.io", new Object[] {
                    s3
                });
            }
            catch(SecurityException securityexception)
            {
                throw new BridgeException(element1, "uri.unsecure", new Object[] {
                    s3
                });
            }
        } while(true);
    }

    public static java.awt.geom.Point2D convertPoint(String s, String s1, String s2, String s3, short word0, org.apache.batik.parser.UnitProcessor.Context context)
    {
        float f;
        float f1;
        switch(word0)
        {
        case 2: // '\002'
            f = UnitProcessor.svgHorizontalCoordinateToObjectBoundingBox(s, s1, context);
            f1 = UnitProcessor.svgVerticalCoordinateToObjectBoundingBox(s2, s3, context);
            break;

        case 1: // '\001'
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, s1, context);
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s2, s3, context);
            break;

        default:
            throw new Error();
        }
        return new java.awt.geom.Point2D.Float(f, f1);
    }

    public static float convertLength(String s, String s1, short word0, org.apache.batik.parser.UnitProcessor.Context context)
    {
        switch(word0)
        {
        case 2: // '\002'
            return UnitProcessor.svgOtherLengthToObjectBoundingBox(s, s1, context);

        case 1: // '\001'
            return UnitProcessor.svgOtherLengthToUserSpace(s, s1, context);
        }
        throw new Error();
    }

    public static java.awt.geom.Rectangle2D convertMaskRegion(Element element, Element element1, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        String s = element.getAttributeNS(null, "x");
        if(s.length() == 0)
            s = "-10%";
        String s1 = element.getAttributeNS(null, "y");
        if(s1.length() == 0)
            s1 = "-10%";
        String s2 = element.getAttributeNS(null, "width");
        if(s2.length() == 0)
            s2 = "120%";
        String s3 = element.getAttributeNS(null, "height");
        if(s3.length() == 0)
            s3 = "120%";
        String s4 = element.getAttributeNS(null, "maskUnits");
        short word0;
        if(s4.length() == 0)
            word0 = 2;
        else
            word0 = parseCoordinateSystem(element, "maskUnits", s4);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element1);
        return convertRegion(s, s1, s2, s3, word0, graphicsnode, context);
    }

    public static java.awt.geom.Rectangle2D convertPatternRegion(Element element, Element element1, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        String s = getChainableAttributeNS(element, null, "x", bridgecontext);
        if(s.length() == 0)
            s = "0";
        String s1 = getChainableAttributeNS(element, null, "y", bridgecontext);
        if(s1.length() == 0)
            s1 = "0";
        String s2 = getChainableAttributeNS(element, null, "width", bridgecontext);
        if(s2.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "width"
            });
        String s3 = getChainableAttributeNS(element, null, "height", bridgecontext);
        if(s3.length() == 0)
            throw new BridgeException(element, "attribute.missing", new Object[] {
                "height"
            });
        String s4 = getChainableAttributeNS(element, null, "patternUnits", bridgecontext);
        short word0;
        if(s4.length() == 0)
            word0 = 2;
        else
            word0 = parseCoordinateSystem(element, "patternUnits", s4);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element1);
        return convertRegion(s, s1, s2, s3, word0, graphicsnode, context);
    }

    public static float[] convertFilterRes(Element element, BridgeContext bridgecontext)
    {
        float af[] = new float[2];
        String s = getChainableAttributeNS(element, null, "filterRes", bridgecontext);
        Float afloat[] = convertSVGNumberOptionalNumber(element, "filterRes", s);
        if(af[0] < 0.0F || af[1] < 0.0F)
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "filterRes", s
            });
        if(afloat[0] == null)
        {
            af[0] = -1F;
        } else
        {
            af[0] = afloat[0].floatValue();
            if(af[0] < 0.0F)
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "filterRes", s
                });
        }
        if(afloat[1] == null)
        {
            af[1] = af[0];
        } else
        {
            af[1] = afloat[1].floatValue();
            if(af[1] < 0.0F)
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "filterRes", s
                });
        }
        return af;
    }

    public static Float[] convertSVGNumberOptionalNumber(Element element, String s, String s1)
    {
        Float afloat[] = new Float[2];
        if(s1.length() == 0)
            return afloat;
        try
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s1, " ");
            afloat[0] = new Float(Float.parseFloat(stringtokenizer.nextToken()));
            if(stringtokenizer.hasMoreTokens())
                afloat[1] = new Float(Float.parseFloat(stringtokenizer.nextToken()));
            if(stringtokenizer.hasMoreTokens())
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    s, s1
                });
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                s, s1, numberformatexception
            });
        }
        return afloat;
    }

    public static java.awt.geom.Rectangle2D convertFilterChainRegion(Element element, Element element1, GraphicsNode graphicsnode, BridgeContext bridgecontext)
    {
        String s = getChainableAttributeNS(element, null, "x", bridgecontext);
        if(s.length() == 0)
            s = "-10%";
        String s1 = getChainableAttributeNS(element, null, "y", bridgecontext);
        if(s1.length() == 0)
            s1 = "-10%";
        String s2 = getChainableAttributeNS(element, null, "width", bridgecontext);
        if(s2.length() == 0)
            s2 = "120%";
        String s3 = getChainableAttributeNS(element, null, "height", bridgecontext);
        if(s3.length() == 0)
            s3 = "120%";
        String s4 = getChainableAttributeNS(element, null, "filterUnits", bridgecontext);
        short word0;
        if(s4.length() == 0)
            word0 = 2;
        else
            word0 = parseCoordinateSystem(element, "filterUnits", s4);
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element1);
        java.awt.geom.Rectangle2D rectangle2d = convertRegion(s, s1, s2, s3, word0, graphicsnode, context);
        s4 = getChainableAttributeNS(element, null, "filterMarginsUnits", bridgecontext);
        if(s4.length() == 0)
            word0 = 1;
        else
            word0 = parseCoordinateSystem(element, "filterMarginsUnits", s4);
        String s5 = element.getAttributeNS(null, "mx");
        if(s5.length() == 0)
            s5 = "0";
        String s6 = element.getAttributeNS(null, "my");
        if(s6.length() == 0)
            s6 = "0";
        String s7 = element.getAttributeNS(null, "mw");
        if(s7.length() == 0)
            s7 = "0";
        String s8 = element.getAttributeNS(null, "mh");
        if(s8.length() == 0)
            s8 = "0";
        return extendRegion(s5, s6, s7, s8, word0, graphicsnode, rectangle2d, context);
    }

    protected static java.awt.geom.Rectangle2D extendRegion(String s, String s1, String s2, String s3, short word0, GraphicsNode graphicsnode, java.awt.geom.Rectangle2D rectangle2d, org.apache.batik.parser.UnitProcessor.Context context)
    {
        float f;
        float f1;
        float f2;
        float f3;
        switch(word0)
        {
        case 1: // '\001'
            f = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "mx", context);
            f1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s1, "my", context);
            f2 = UnitProcessor.svgHorizontalCoordinateToUserSpace(s2, "mw", context);
            f3 = UnitProcessor.svgVerticalCoordinateToUserSpace(s3, "mh", context);
            break;

        case 2: // '\002'
            java.awt.geom.Rectangle2D rectangle2d1 = graphicsnode.getGeometryBounds();
            if(rectangle2d1 == null)
            {
                f = f1 = f2 = f3 = 0.0F;
            } else
            {
                f = UnitProcessor.svgHorizontalCoordinateToObjectBoundingBox(s, "mx", context);
                f = (float)((double)f * rectangle2d1.getWidth());
                f1 = UnitProcessor.svgVerticalCoordinateToObjectBoundingBox(s1, "my", context);
                f1 = (float)((double)f1 * rectangle2d1.getHeight());
                f2 = UnitProcessor.svgHorizontalCoordinateToObjectBoundingBox(s2, "mw", context);
                f2 = (float)((double)f2 * rectangle2d1.getWidth());
                f3 = UnitProcessor.svgVerticalCoordinateToObjectBoundingBox(s3, "mh", context);
                f3 = (float)((double)f3 * rectangle2d1.getHeight());
            }
            break;

        default:
            throw new Error();
        }
        rectangle2d.setRect(rectangle2d.getX() + (double)f, rectangle2d.getY() + (double)f1, rectangle2d.getWidth() + (double)f2, rectangle2d.getHeight() + (double)f3);
        return rectangle2d;
    }

    public static java.awt.geom.Rectangle2D convertFilterPrimitiveRegion(Element element, Element element1, GraphicsNode graphicsnode, java.awt.geom.Rectangle2D rectangle2d, java.awt.geom.Rectangle2D rectangle2d1, BridgeContext bridgecontext)
    {
        Node node = element.getParentNode();
        String s = "";
        if(node != null && node.getNodeType() == 1)
        {
            Element element2 = (Element)node;
            s = getChainableAttributeNS(element2, null, "primitiveUnits", bridgecontext);
        }
        short word0;
        if(s.length() == 0)
            word0 = 1;
        else
            word0 = parseCoordinateSystem(element, "filterUnits", s);
        String s1 = element.getAttributeNS(null, "x");
        String s2 = element.getAttributeNS(null, "y");
        String s3 = element.getAttributeNS(null, "width");
        String s4 = element.getAttributeNS(null, "height");
        double d = rectangle2d.getX();
        double d1 = rectangle2d.getY();
        double d2 = rectangle2d.getWidth();
        double d3 = rectangle2d.getHeight();
        org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element1);
        switch(word0)
        {
        case 2: // '\002'
            java.awt.geom.Rectangle2D rectangle2d2 = graphicsnode.getGeometryBounds();
            if(rectangle2d2 != null)
            {
                if(s1.length() != 0)
                {
                    d = UnitProcessor.svgHorizontalCoordinateToObjectBoundingBox(s1, "x", context);
                    d = rectangle2d2.getX() + d * rectangle2d2.getWidth();
                }
                if(s2.length() != 0)
                {
                    d1 = UnitProcessor.svgVerticalCoordinateToObjectBoundingBox(s2, "y", context);
                    d1 = rectangle2d2.getY() + d1 * rectangle2d2.getHeight();
                }
                if(s3.length() != 0)
                {
                    d2 = UnitProcessor.svgHorizontalLengthToObjectBoundingBox(s3, "width", context);
                    d2 *= rectangle2d2.getWidth();
                }
                if(s4.length() != 0)
                {
                    d3 = UnitProcessor.svgVerticalLengthToObjectBoundingBox(s4, "height", context);
                    d3 *= rectangle2d2.getHeight();
                }
            }
            break;

        case 1: // '\001'
            if(s1.length() != 0)
                d = UnitProcessor.svgHorizontalCoordinateToUserSpace(s1, "x", context);
            if(s2.length() != 0)
                d1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s2, "y", context);
            if(s3.length() != 0)
                d2 = UnitProcessor.svgHorizontalLengthToUserSpace(s3, "width", context);
            if(s4.length() != 0)
                d3 = UnitProcessor.svgVerticalLengthToUserSpace(s4, "height", context);
            break;

        default:
            throw new Error();
        }
        Object obj = new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3);
        s = "";
        if(node != null && node.getNodeType() == 1)
        {
            Element element3 = (Element)node;
            s = getChainableAttributeNS(element3, null, "filterPrimitiveMarginsUnits", bridgecontext);
        }
        if(s.length() == 0)
            word0 = 1;
        else
            word0 = parseCoordinateSystem(element, "filterPrimitiveMarginsUnits", s);
        String s5 = element.getAttributeNS(null, "mx");
        if(s5.length() == 0)
            s5 = "0";
        String s6 = element.getAttributeNS(null, "my");
        if(s6.length() == 0)
            s6 = "0";
        String s7 = element.getAttributeNS(null, "mw");
        if(s7.length() == 0)
            s7 = "0";
        String s8 = element.getAttributeNS(null, "mh");
        if(s8.length() == 0)
            s8 = "0";
        obj = extendRegion(s5, s6, s7, s8, word0, graphicsnode, ((java.awt.geom.Rectangle2D) (obj)), context);
        java.awt.geom.Rectangle2D.intersect(((java.awt.geom.Rectangle2D) (obj)), rectangle2d1, ((java.awt.geom.Rectangle2D) (obj)));
        return ((java.awt.geom.Rectangle2D) (obj));
    }

    public static short parseCoordinateSystem(Element element, String s, String s1)
    {
        if("userSpaceOnUse".equals(s1))
            return 1;
        if("objectBoundingBox".equals(s1))
            return 2;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                s, s1
            });
    }

    public static short parseMarkerCoordinateSystem(Element element, String s, String s1)
    {
        if("userSpaceOnUse".equals(s1))
            return 1;
        if("strokeWidth".equals(s1))
            return 3;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                s, s1
            });
    }

    protected static java.awt.geom.Rectangle2D convertRegion(String s, String s1, String s2, String s3, short word0, GraphicsNode graphicsnode, org.apache.batik.parser.UnitProcessor.Context context)
    {
        double d;
        double d1;
        double d2;
        double d3;
        switch(word0)
        {
        case 2: // '\002'
            d = UnitProcessor.svgHorizontalCoordinateToObjectBoundingBox(s, "x", context);
            d1 = UnitProcessor.svgVerticalCoordinateToObjectBoundingBox(s1, "y", context);
            d2 = UnitProcessor.svgHorizontalLengthToObjectBoundingBox(s2, "width", context);
            d3 = UnitProcessor.svgVerticalLengthToObjectBoundingBox(s3, "height", context);
            java.awt.geom.Rectangle2D rectangle2d = graphicsnode.getGeometryBounds();
            if(rectangle2d != null)
            {
                d = rectangle2d.getX() + d * rectangle2d.getWidth();
                d1 = rectangle2d.getY() + d1 * rectangle2d.getHeight();
                d2 *= rectangle2d.getWidth();
                d3 *= rectangle2d.getHeight();
            } else
            {
                d = d1 = d2 = d3 = 0.0D;
            }
            break;

        case 1: // '\001'
            d = UnitProcessor.svgHorizontalCoordinateToUserSpace(s, "x", context);
            d1 = UnitProcessor.svgVerticalCoordinateToUserSpace(s1, "y", context);
            d2 = UnitProcessor.svgHorizontalLengthToUserSpace(s2, "width", context);
            d3 = UnitProcessor.svgVerticalLengthToUserSpace(s3, "height", context);
            break;

        default:
            throw new Error();
        }
        return new java.awt.geom.Rectangle2D.Double(d, d1, d2, d3);
    }

    public static java.awt.geom.AffineTransform convertTransform(Element element, String s, String s1)
    {
        return AWTTransformProducer.createAffineTransform(s1);
        ParseException parseexception;
        parseexception;
        throw new BridgeException(element, "attribute.malformed", new Object[] {
            s, s1, parseexception
        });
    }

    public static java.awt.geom.AffineTransform toObjectBBox(java.awt.geom.AffineTransform affinetransform, GraphicsNode graphicsnode)
    {
        java.awt.geom.AffineTransform affinetransform1 = new java.awt.geom.AffineTransform();
        java.awt.geom.Rectangle2D rectangle2d = graphicsnode.getGeometryBounds();
        if(rectangle2d != null)
        {
            affinetransform1.translate(rectangle2d.getX(), rectangle2d.getY());
            affinetransform1.scale(rectangle2d.getWidth(), rectangle2d.getHeight());
        }
        affinetransform1.concatenate(affinetransform);
        return affinetransform1;
    }

    public static java.awt.geom.Rectangle2D toObjectBBox(java.awt.geom.Rectangle2D rectangle2d, GraphicsNode graphicsnode)
    {
        java.awt.geom.Rectangle2D rectangle2d1 = graphicsnode.getGeometryBounds();
        if(rectangle2d1 != null)
            return new java.awt.geom.Rectangle2D.Double(rectangle2d1.getX() + rectangle2d.getX() * rectangle2d1.getWidth(), rectangle2d1.getY() + rectangle2d.getY() * rectangle2d1.getHeight(), rectangle2d.getWidth() * rectangle2d1.getWidth(), rectangle2d.getHeight() * rectangle2d1.getHeight());
        else
            return new java.awt.geom.Rectangle2D.Double();
    }

    public static final short USER_SPACE_ON_USE = 1;
    public static final short OBJECT_BOUNDING_BOX = 2;
    public static final short STROKE_WIDTH = 3;
}
