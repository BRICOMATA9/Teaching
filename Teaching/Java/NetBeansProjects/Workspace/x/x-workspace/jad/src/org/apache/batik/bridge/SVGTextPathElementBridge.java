// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.gvt.text.TextPath;
import org.apache.batik.parser.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, ErrorConstants, BridgeContext, BridgeException, 
//            CSSUtilities, SVGUtilities, UnitProcessor

public class SVGTextPathElementBridge extends AbstractSVGBridge
    implements ErrorConstants
{

    public SVGTextPathElementBridge()
    {
    }

    public String getLocalName()
    {
        return "textPath";
    }

    public TextPath createTextPath(BridgeContext bridgecontext, Element element)
    {
        Element element1;
        java.awt.Shape shape;
        String s = XLinkSupport.getXLinkHref(element);
        element1 = bridgecontext.getReferencedElement(element, s);
        if(element1 == null || !"http://www.w3.org/2000/svg".equals(element1.getNamespaceURI()) || !element1.getLocalName().equals("path"))
            throw new BridgeException(element, "uri.badTarget", new Object[] {
                s
            });
        String s1 = element1.getAttributeNS(null, "d");
        shape = null;
        Exception exception;
        if(s1.length() != 0)
        {
            AWTPathProducer awtpathproducer = new AWTPathProducer();
            awtpathproducer.setWindingRule(CSSUtilities.convertFillRule(element1));
            try
            {
                PathParser pathparser = new PathParser();
                pathparser.setPathHandler(awtpathproducer);
                pathparser.parse(s1);
            }
            catch(ParseException parseexception)
            {
                throw new BridgeException(element1, "attribute.malformed", new Object[] {
                    "d"
                });
            }
            finally
            {
                shape = awtpathproducer.getShape();
            }
            shape = awtpathproducer.getShape();
        } else
        {
            throw new BridgeException(element1, "attribute.missing", new Object[] {
                "d"
            });
        }
        break MISSING_BLOCK_LABEL_198;
        throw exception;
        String s2 = element1.getAttributeNS(null, "transform");
        if(s2.length() != 0)
        {
            AffineTransform affinetransform = SVGUtilities.convertTransform(element1, "transform", s2);
            shape = affinetransform.createTransformedShape(shape);
        }
        TextPath textpath = new TextPath(new GeneralPath(shape));
        s2 = element.getAttributeNS(null, "startOffset");
        if(s2.length() > 0)
        {
            float f = 0.0F;
            int i = s2.indexOf("%");
            if(i != -1)
            {
                float f1 = textpath.lengthOfPath();
                String s3 = s2.substring(0, i);
                float f2 = 0.0F;
                try
                {
                    f2 = SVGUtilities.convertSVGNumber(s3);
                }
                catch(NumberFormatException numberformatexception)
                {
                    f2 = -1F;
                }
                if(f2 < 0.0F)
                    throw new BridgeException(element, "attribute.malformed", new Object[] {
                        "startOffset", s2
                    });
                f = (float)((double)(f2 * f1) / 100D);
            } else
            {
                org.apache.batik.parser.UnitProcessor.Context context = UnitProcessor.createContext(bridgecontext, element);
                f = UnitProcessor.svgOtherLengthToUserSpace(s2, "startOffset", context);
            }
            textpath.setStartOffset(f);
        }
        return textpath;
    }
}
