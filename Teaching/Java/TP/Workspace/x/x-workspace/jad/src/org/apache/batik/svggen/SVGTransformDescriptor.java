// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax

public class SVGTransformDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGTransformDescriptor(String s)
    {
        transform = s;
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("transform", transform);
        return map;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        return list;
    }

    private String transform;
}
