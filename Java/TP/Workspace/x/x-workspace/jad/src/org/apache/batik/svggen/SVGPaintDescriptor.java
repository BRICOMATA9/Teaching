// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax

public class SVGPaintDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGPaintDescriptor(String s, String s1)
    {
        paintValue = s;
        opacityValue = s1;
    }

    public SVGPaintDescriptor(String s, String s1, Element element)
    {
        this(s, s1);
        def = element;
    }

    public String getPaintValue()
    {
        return paintValue;
    }

    public String getOpacityValue()
    {
        return opacityValue;
    }

    public Element getDef()
    {
        return def;
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("fill", paintValue);
        map.put("stroke", paintValue);
        map.put("fill-opacity", opacityValue);
        map.put("stroke-opacity", opacityValue);
        return map;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        if(def != null)
            list.add(def);
        return list;
    }

    private Element def;
    private String paintValue;
    private String opacityValue;
}
