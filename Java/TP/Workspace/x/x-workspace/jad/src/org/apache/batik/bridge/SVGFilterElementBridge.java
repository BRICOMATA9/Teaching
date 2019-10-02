// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.XLinkSupport;
import org.apache.batik.ext.awt.image.PadMode;
import org.apache.batik.ext.awt.image.renderable.Filter;
import org.apache.batik.ext.awt.image.renderable.FilterChainRable;
import org.apache.batik.ext.awt.image.renderable.FilterChainRable8Bit;
import org.apache.batik.ext.awt.image.renderable.PadRable8Bit;
import org.apache.batik.gvt.GraphicsNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package org.apache.batik.bridge:
//            AbstractSVGBridge, FilterBridge, ErrorConstants, SVGUtilities, 
//            BridgeException, BridgeContext, FilterPrimitiveBridge

public class SVGFilterElementBridge extends AbstractSVGBridge
    implements FilterBridge, ErrorConstants
{

    public SVGFilterElementBridge()
    {
    }

    public String getLocalName()
    {
        return "filter";
    }

    public Filter createFilter(BridgeContext bridgecontext, Element element, Element element1, GraphicsNode graphicsnode)
    {
        java.awt.geom.Rectangle2D rectangle2d = SVGUtilities.convertFilterChainRegion(element, element1, graphicsnode, bridgecontext);
        Object obj = graphicsnode.getGraphicsNodeRable(true);
        obj = new PadRable8Bit(((Filter) (obj)), rectangle2d, PadMode.ZERO_PAD);
        FilterChainRable8Bit filterchainrable8bit = new FilterChainRable8Bit(((Filter) (obj)), rectangle2d);
        float af[] = SVGUtilities.convertFilterRes(element, bridgecontext);
        filterchainrable8bit.setFilterResolutionX((int)af[0]);
        filterchainrable8bit.setFilterResolutionY((int)af[1]);
        HashMap hashmap = new HashMap(11);
        hashmap.put("SourceGraphic", obj);
        Filter filter = buildFilterPrimitives(element, rectangle2d, element1, graphicsnode, ((Filter) (obj)), hashmap, bridgecontext);
        if(filter == null || filter == obj)
        {
            return null;
        } else
        {
            filterchainrable8bit.setSource(filter);
            return filterchainrable8bit;
        }
    }

    protected static Filter buildFilterPrimitives(Element element, java.awt.geom.Rectangle2D rectangle2d, Element element1, GraphicsNode graphicsnode, Filter filter, Map map, BridgeContext bridgecontext)
    {
        LinkedList linkedlist = new LinkedList();
        do
        {
            Filter filter1 = buildLocalFilterPrimitives(element, rectangle2d, element1, graphicsnode, filter, map, bridgecontext);
            if(filter1 != filter)
                return filter1;
            String s = XLinkSupport.getXLinkHref(element);
            if(s.length() == 0)
                return filter;
            SVGOMDocument svgomdocument = (SVGOMDocument)element.getOwnerDocument();
            URL url;
            try
            {
                url = new URL(svgomdocument.getURLObject(), s);
            }
            catch(MalformedURLException malformedurlexception)
            {
                throw new BridgeException(element, "uri.malformed", new Object[] {
                    s
                });
            }
            if(contains(linkedlist, url))
                throw new BridgeException(element, "xlink.href.circularDependencies", new Object[] {
                    s
                });
            linkedlist.add(url);
            element = bridgecontext.getReferencedElement(element, s);
        } while(true);
    }

    protected static Filter buildLocalFilterPrimitives(Element element, java.awt.geom.Rectangle2D rectangle2d, Element element1, GraphicsNode graphicsnode, Filter filter, Map map, BridgeContext bridgecontext)
    {
        for(Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
        {
            if(node.getNodeType() != 1)
                continue;
            Element element2 = (Element)node;
            Bridge bridge = bridgecontext.getBridge(element2);
            if(bridge == null || !(bridge instanceof FilterPrimitiveBridge))
                continue;
            FilterPrimitiveBridge filterprimitivebridge = (FilterPrimitiveBridge)bridge;
            Filter filter1 = filterprimitivebridge.createFilter(bridgecontext, element2, element1, graphicsnode, filter, rectangle2d, map);
            if(filter1 == null)
                return null;
            filter = filter1;
        }

        return filter;
    }

    private static boolean contains(List list, URL url)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            URL url1 = (URL)iterator.next();
            if(url1.sameFile(url) && url1.getRef().equals(url.getRef()))
                return true;
        }

        return false;
    }
}
