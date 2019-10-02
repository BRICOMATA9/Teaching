// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGDescriptor, SVGSyntax, SVGGraphics2DRuntimeException

public class SVGFontDescriptor
    implements SVGDescriptor, SVGSyntax
{

    public SVGFontDescriptor(String s, String s1, String s2, String s3, Element element)
    {
        if(s == null || s1 == null || s2 == null || s3 == null)
        {
            throw new SVGGraphics2DRuntimeException("none of the font description parameters should be null");
        } else
        {
            fontSize = s;
            fontWeight = s1;
            fontStyle = s2;
            fontFamily = s3;
            def = element;
            return;
        }
    }

    public Map getAttributeMap(Map map)
    {
        if(map == null)
            map = new HashMap();
        map.put("font-size", fontSize);
        map.put("font-weight", fontWeight);
        map.put("font-style", fontStyle);
        map.put("font-family", fontFamily);
        return map;
    }

    public Element getDef()
    {
        return def;
    }

    public List getDefinitionSet(List list)
    {
        if(list == null)
            list = new LinkedList();
        if(def != null && !list.contains(def))
            list.add(def);
        return list;
    }

    private Element def;
    private String fontSize;
    private String fontWeight;
    private String fontStyle;
    private String fontFamily;
}
