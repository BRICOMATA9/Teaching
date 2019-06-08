// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.batik.ext.awt.image.CompositeRule;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.PadRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGFilterPrimitiveElementBridge, SVGUtilities, BridgeContext, AbstractSVGBridge

public class SVGFeMergeElementBridge extends AbstractSVGFilterPrimitiveElementBridge
{
    public static class SVGFeMergeNodeElementBridge extends AbstractSVGBridge
    {

        public String getLocalName()
        {
            return "feMergeNode";
        }

        public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Map map)
        {
            return AbstractSVGFilterPrimitiveElementBridge.getIn(element, element1, graphicsnode, filter, map, bridgecontext);
        }

        public SVGFeMergeNodeElementBridge()
        {
        }
    }


    public SVGFeMergeElementBridge()
    {
    }

    public String getLocalName()
    {
        return "feMerge";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode, Filter filter, java.awt.geom.Rectangle2D rectangle2d, Map map)
    {
        List list = extractFeMergeNode(element, element1, graphicsnode, filter, map, bridgecontext);
        if(list == null)
            return null;
        if(list.size() == 0)
            return null;
        Iterator iterator = list.iterator();
        java.awt.geom.Rectangle2D rectangle2d1 = (java.awt.geom.Rectangle2D)((Filter)iterator.next()).getBounds2D().clone();
        for(; iterator.hasNext(); rectangle2d1.add(((Filter)iterator.next()).getBounds2D()));
        java.awt.geom.Rectangle2D rectangle2d2 = SVGUtilities.convertFilterPrimitiveRegion(element, element1, graphicsnode, rectangle2d1, rectangle2d, bridgecontext);
        Object obj = new CompositeRable8Bit(list, CompositeRule.OVER, true);
        handleColorInterpolationFilters(((Filter) (obj)), element);
        obj = new PadRable8Bit(((Filter) (obj)), rectangle2d2, PadMode.ZERO_PAD);
        updateFilterMap(element, ((Filter) (obj)), map);
        return ((Filter) (obj));
    }

    protected static List extractFeMergeNode(Element element, Element element1, GraphicsNode graphicsnode, Filter filter, Map map, BridgeContext bridgecontext)
    {
        LinkedList linkedlist = null;
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element2);
            if(bridge == null || !(bridge instanceof SVGFeMergeNodeElementBridge))
                continue;
            Filter filter1 = ((SVGFeMergeNodeElementBridge)bridge).createFilter(bridgecontext, element2, element1, graphicsnode, filter, map);
            if(filter1 == null)
                continue;
            if(linkedlist == null)
                linkedlist = new LinkedList();
            linkedlist.add(filter1);
        }

        return linkedlist;
    }
}
