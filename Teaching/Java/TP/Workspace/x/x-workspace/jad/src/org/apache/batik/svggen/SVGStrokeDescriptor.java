// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax, SVGGraphics2DRuntimeException

public class SVGStrokeDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGStrokeDescriptor(String s, String s1, String s2, String s3, String s4, String s5)
    {
        if(s == null || s1 == null || s2 == null || s3 == null || s4 == null || s5 == null)
        {
            throw new SVGGraphics2DRuntimeException("none of the stroke description parameters should be null");
        } else
        {
            strokeWidth = s;
            capStyle = s1;
            joinStyle = s2;
            miterLimit = s3;
            dashArray = s4;
            dashOffset = s5;
            return;
        }
    }

    String getStrokeWidth()
    {
        return strokeWidth;
    }

    String getCapStyle()
    {
        return capStyle;
    }

    String getJoinStyle()
    {
        return joinStyle;
    }

    String getMiterLimit()
    {
        return miterLimit;
    }

    String getDashArray()
    {
        return dashArray;
    }

    String getDashOffset()
    {
        return dashOffset;
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("stroke-width", strokeWidth);
        map.put("stroke-linecap", capStyle);
        map.put("stroke-linejoin", joinStyle);
        map.put("stroke-miterlimit", miterLimit);
        map.put("stroke-dasharray", dashArray);
        map.put("stroke-dashoffset", dashOffset);
        return map;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        return list;
    }

    private String strokeWidth;
    private String capStyle;
    private String joinStyle;
    private String miterLimit;
    private String dashArray;
    private String dashOffset;
}
