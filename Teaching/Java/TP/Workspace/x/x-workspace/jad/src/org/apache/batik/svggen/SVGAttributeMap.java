// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package org.apache.batik.svggen:
//            SVGAttribute

public class SVGAttributeMap
{

    public SVGAttributeMap()
    {
    }

    public static SVGAttribute get(String s)
    {
        return (SVGAttribute)attrMap.get(s);
    }

    private static Map attrMap = new HashMap();

}
