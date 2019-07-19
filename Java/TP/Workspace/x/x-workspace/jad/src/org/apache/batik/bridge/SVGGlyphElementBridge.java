// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.batik.gvt.font.GVTFontFace;
import org.apache.batik.gvt.font.Glyph;
import org.apache.batik.gvt.text.TextPaintInfo;
import org.apache.batik.parser.*;
import org.w3c.dom.*;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ErrorConstants, CSSUtilities, BridgeException, 
//            BridgeContext, GVTBuilder, SVGUtilities

public class SVGGlyphElementBridge extends AbstractSVGBridge
    implements ErrorConstants
{

    protected SVGGlyphElementBridge()
    {
    }

    public String getLocalName()
    {
        return "glyph";
    }

    public Glyph createGlyph(BridgeContext bridgecontext, Element element, Element element1, int i, float f, GVTFontFace gvtfontface, TextPaintInfo textpaintinfo)
    {
        float f2;
        AffineTransform affinetransform;
        java.awt.Shape shape;
        Exception exception;
        java.awt.Shape shape3;
        float f1 = gvtfontface.getUnitsPerEm();
        f2 = f / f1;
        affinetransform = AffineTransform.getScaleInstance(f2, -f2);
        String s = element.getAttributeNS(null, "d");
        shape = null;
        if(s.length() != 0)
        {
            AWTPathProducer awtpathproducer = new AWTPathProducer();
            awtpathproducer.setWindingRule(CSSUtilities.convertFillRule(element1));
            java.awt.Shape shape1;
            java.awt.Shape shape2;
            try
            {
                PathParser pathparser = new PathParser();
                pathparser.setPathHandler(awtpathproducer);
                pathparser.parse(s);
            }
            catch(ParseException parseexception)
            {
                throw new BridgeException(element, "attribute.malformed", new Object[] {
                    "d"
                });
            }
            finally
            {
                shape3 = awtpathproducer.getShape();
            }
            shape1 = awtpathproducer.getShape();
            shape2 = affinetransform.createTransformedShape(shape1);
            shape = shape2;
        }
        break MISSING_BLOCK_LABEL_159;
        java.awt.Shape shape4 = affinetransform.createTransformedShape(shape3);
        shape = shape4;
        throw exception;
        NodeList nodelist = element.getChildNodes();
        int j = nodelist.getLength();
        int k = 0;
        for(int l = 0; l < j; l++)
        {
            Node node = nodelist.item(l);
            if(node.getNodeType() == 1)
                k++;
        }

        CompositeGraphicsNode compositegraphicsnode = null;
        if(k > 0)
        {
            GVTBuilder gvtbuilder = bridgecontext.getGVTBuilder();
            compositegraphicsnode = new CompositeGraphicsNode();
            Element element2 = (Element)element.getParentNode().cloneNode(false);
            NamedNodeMap namednodemap = element.getParentNode().getAttributes();
            int i1 = namednodemap.getLength();
            for(int j1 = 0; j1 < i1; j1++)
                element2.setAttributeNode((Attr)namednodemap.item(j1));

            Element element3 = (Element)element.cloneNode(true);
            element2.appendChild(element3);
            element1.appendChild(element2);
            CompositeGraphicsNode compositegraphicsnode1 = new CompositeGraphicsNode();
            compositegraphicsnode1.setTransform(affinetransform);
            NodeList nodelist1 = element3.getChildNodes();
            int k1 = nodelist1.getLength();
            for(int l1 = 0; l1 < k1; l1++)
            {
                Node node1 = nodelist1.item(l1);
                if(node1.getNodeType() == 1)
                {
                    Element element5 = (Element)node1;
                    org.apache.batik.gvt.GraphicsNode graphicsnode = gvtbuilder.build(bridgecontext, element5);
                    compositegraphicsnode1.add(graphicsnode);
                }
            }

            compositegraphicsnode.add(compositegraphicsnode1);
            element1.removeChild(element2);
        }
        String s1 = element.getAttributeNS(null, "unicode");
        String s2 = element.getAttributeNS(null, "glyph-name");
        Vector vector = new Vector();
        for(StringTokenizer stringtokenizer = new StringTokenizer(s2, " ,"); stringtokenizer.hasMoreTokens(); vector.add(stringtokenizer.nextToken()));
        String s3 = element.getAttributeNS(null, "orientation");
        String s4 = element.getAttributeNS(null, "arabic-form");
        String s5 = element.getAttributeNS(null, "lang");
        Element element4 = (Element)element.getParentNode();
        String s6 = element.getAttributeNS(null, "horiz-adv-x");
        if(s6.length() == 0)
        {
            s6 = element4.getAttributeNS(null, "horiz-adv-x");
            if(s6.length() == 0)
                throw new BridgeException(element4, "attribute.missing", new Object[] {
                    "horiz-adv-x"
                });
        }
        float f3;
        try
        {
            f3 = SVGUtilities.convertSVGNumber(s6) * f2;
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "horiz-adv-x", s6
            });
        }
        s6 = element.getAttributeNS(null, "vert-adv-y");
        if(s6.length() == 0)
        {
            s6 = element4.getAttributeNS(null, "vert-adv-y");
            if(s6.length() == 0)
                s6 = String.valueOf(gvtfontface.getUnitsPerEm());
        }
        float f4;
        try
        {
            f4 = SVGUtilities.convertSVGNumber(s6) * f2;
        }
        catch(NumberFormatException numberformatexception1)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "vert-adv-y", s6
            });
        }
        s6 = element.getAttributeNS(null, "vert-origin-x");
        if(s6.length() == 0)
        {
            s6 = element4.getAttributeNS(null, "vert-origin-x");
            if(s6.length() == 0)
                s6 = Float.toString(f3 / 2.0F);
        }
        float f5;
        try
        {
            f5 = SVGUtilities.convertSVGNumber(s6) * f2;
        }
        catch(NumberFormatException numberformatexception2)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "vert-origin-x", s6
            });
        }
        s6 = element.getAttributeNS(null, "vert-origin-y");
        if(s6.length() == 0)
        {
            s6 = element4.getAttributeNS(null, "vert-origin-y");
            if(s6.length() == 0)
                s6 = String.valueOf(gvtfontface.getAscent());
        }
        float f6;
        try
        {
            f6 = SVGUtilities.convertSVGNumber(s6) * -f2;
        }
        catch(NumberFormatException numberformatexception3)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "vert-origin-y", s6
            });
        }
        java.awt.geom.Point2D.Float float1 = new java.awt.geom.Point2D.Float(f5, f6);
        s6 = element4.getAttributeNS(null, "horiz-origin-x");
        if(s6.length() == 0)
            s6 = "0";
        float f7;
        try
        {
            f7 = SVGUtilities.convertSVGNumber(s6) * f2;
        }
        catch(NumberFormatException numberformatexception4)
        {
            throw new BridgeException(element4, "attribute.malformed", new Object[] {
                "horiz-origin-x", s6
            });
        }
        s6 = element4.getAttributeNS(null, "horiz-origin-y");
        if(s6.length() == 0)
            s6 = "0";
        float f8;
        try
        {
            f8 = SVGUtilities.convertSVGNumber(s6) * -f2;
        }
        catch(NumberFormatException numberformatexception5)
        {
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "horiz-origin-y", s6
            });
        }
        java.awt.geom.Point2D.Float float2 = new java.awt.geom.Point2D.Float(f7, f8);
        return new Glyph(s1, vector, s3, s4, s5, float2, float1, f3, f4, i, textpaintinfo, shape, compositegraphicsnode);
    }
}
