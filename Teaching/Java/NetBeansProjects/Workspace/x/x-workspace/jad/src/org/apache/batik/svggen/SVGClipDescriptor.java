// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax, SVGGraphics2DRuntimeException

public class SVGClipDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGClipDescriptor(String s, Element element)
    {
        if(s == null)
        {
            throw new SVGGraphics2DRuntimeException("clipPathValue should not be null");
        } else
        {
            clipPathValue = s;
            clipPathDef = element;
            return;
        }
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("clip-path", clipPathValue);
        return map;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        if(clipPathDef != null)
            list.add(clipPathDef);
        return list;
    }

    private String clipPathValue;
    private Element clipPathDef;
}
