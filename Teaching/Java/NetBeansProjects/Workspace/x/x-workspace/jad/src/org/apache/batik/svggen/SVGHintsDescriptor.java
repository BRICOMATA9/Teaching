// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax, SVGGraphics2DRuntimeException

public class SVGHintsDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGHintsDescriptor(String s, String s1, String s2, String s3, String s4)
    {
        if(s == null || s1 == null || s2 == null || s3 == null || s4 == null)
        {
            throw new SVGGraphics2DRuntimeException("none of the hints description parameters should be null");
        } else
        {
            colorInterpolation = s;
            colorRendering = s1;
            textRendering = s2;
            shapeRendering = s3;
            imageRendering = s4;
            return;
        }
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("color-interpolation", colorInterpolation);
        map.put("color-rendering", colorRendering);
        map.put("text-rendering", textRendering);
        map.put("shape-rendering", shapeRendering);
        map.put("image-rendering", imageRendering);
        return map;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        return list;
    }

    private String colorInterpolation;
    private String colorRendering;
    private String textRendering;
    private String shapeRendering;
    private String imageRendering;
}
