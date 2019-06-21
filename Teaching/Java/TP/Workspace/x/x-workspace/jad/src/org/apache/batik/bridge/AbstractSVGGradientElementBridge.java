// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.MultipleGradientPaint;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.util.ParsedURL;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, PaintBridge, ErrorConstants, SVGUtilities, 
//            CSSUtilities, BridgeException, BridgeContext, Bridge

public abstract class AbstractSVGGradientElementBridge extends AbstractSVGBridge
    implements PaintBridge, ErrorConstants
{
    public static class SVGStopElementBridge extends AbstractSVGBridge
        implements Bridge
    {

        public String getLocalName()
        {
            return "stop";
        }

        public Stop createStop(BridgeContext bridgecontext, Element element, Element element1, float f)
        {
            String s = element1.getAttributeNS(null, "offset");
            if(s.length() == 0)
                throw new BridgeException(element1, "attribute.missing", new Object[] {
                    "offset"
                });
            float f1;
            try
            {
                f1 = SVGUtilities.convertRatio(s);
            }
            catch(NumberFormatException numberformatexception)
            {
                throw new BridgeException(element1, "attribute.malformed", new Object[] {
                    "offset", s, numberformatexception
                });
            }
            java.awt.Color color = CSSUtilities.convertStopColor(element1, f, bridgecontext);
            return new Stop(color, f1);
        }

        public SVGStopElementBridge()
        {
        }
    }

    public static class Stop
    {

        public java.awt.Color color;
        public float offset;

        public Stop(java.awt.Color color1, float f)
        {
            color = color1;
            offset = f;
        }
    }


    protected AbstractSVGGradientElementBridge()
    {
    }

    public java.awt.Paint createPaint(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, float f)
    {
        List list = extractStop(element, f, bridgecontext);
        if(list == null)
            return null;
        int i = list.size();
        if(i == 1)
            return ((Stop)list.get(0)).color;
        float af[] = new float[i];
        java.awt.Color acolor[] = new java.awt.Color[i];
        Iterator iterator = list.iterator();
        for(int j = 0; iterator.hasNext(); j++)
        {
            Stop stop = (Stop)iterator.next();
            af[j] = stop.offset;
            acolor[j] = stop.color;
        }

        org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cyclemethodenum = MultipleGradientPaint.NO_CYCLE;
        String s = SVGUtilities.getChainableAttributeNS(element, null, "spreadMethod", bridgecontext);
        if(s.length() != 0)
            cyclemethodenum = convertSpreadMethod(element, s);
        org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorspaceenum = CSSUtilities.convertColorInterpolation(element);
        s = SVGUtilities.getChainableAttributeNS(element, null, "gradientTransform", bridgecontext);
        java.awt.geom.AffineTransform affinetransform;
        if(s.length() != 0)
            affinetransform = SVGUtilities.convertTransform(element, "gradientTransform", s);
        else
            affinetransform = new java.awt.geom.AffineTransform();
        java.awt.Paint paint = buildGradient(element, element1, graphicsnode, cyclemethodenum, colorspaceenum, affinetransform, acolor, af, bridgecontext);
        return paint;
    }

    protected abstract java.awt.Paint buildGradient(Element element, Element element1, GraphicsNode graphicsnode, org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cyclemethodenum, org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorspaceenum, java.awt.geom.AffineTransform affinetransform, java.awt.Color acolor[], 
            float af[], BridgeContext bridgecontext);

    protected static org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum convertSpreadMethod(Element element, String s)
    {
        if("repeat".equals(s))
            return MultipleGradientPaint.REPEAT;
        if("reflect".equals(s))
            return MultipleGradientPaint.REFLECT;
        if("pad".equals(s))
            return MultipleGradientPaint.NO_CYCLE;
        else
            throw new BridgeException(element, "attribute.malformed", new Object[] {
                "spreadMethod", s
            });
    }

    protected static List extractStop(Element element, float f, BridgeContext bridgecontext)
    {
        LinkedList linkedlist = new LinkedList();
        do
        {
            List list = extractLocalStop(element, f, bridgecontext);
            if(list != null)
                return list;
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

    protected static List extractLocalStop(Element element, float f, BridgeContext bridgecontext)
    {
        LinkedList linkedlist = null;
        Stop stop = null;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element1 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element1);
            if(bridge == null || !(bridge instanceof SVGStopElementBridge))
                continue;
            Stop stop1 = ((SVGStopElementBridge)bridge).createStop(bridgecontext, element, element1, f);
            if(linkedlist == null)
                linkedlist = new LinkedList();
            if(stop != null && stop1.offset < stop.offset)
                stop1.offset = stop.offset;
            linkedlist.add(stop1);
            stop = stop1;
        }

        return linkedlist;
    }

    private static boolean contains(List list, ParsedURL parsedurl)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
            if(parsedurl.equals(iterator.next()))
                return true;

        return false;
    }
}
