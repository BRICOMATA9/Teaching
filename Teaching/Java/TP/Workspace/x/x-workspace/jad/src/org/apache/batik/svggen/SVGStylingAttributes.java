// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax

public class SVGStylingAttributes
    implements SVGSyntax
{

    public SVGStylingAttributes()
    {
    }

    static Set attrSet;
    public static final Set set;

    static 
    {
        attrSet = new HashSet();
        attrSet.add("clip-path");
        attrSet.add("color-interpolation");
        attrSet.add("color-rendering");
        attrSet.add("enable-background");
        attrSet.add("fill");
        attrSet.add("fill-opacity");
        attrSet.add("fill-rule");
        attrSet.add("filter");
        attrSet.add("flood-color");
        attrSet.add("flood-opacity");
        attrSet.add("font-family");
        attrSet.add("font-size");
        attrSet.add("font-weight");
        attrSet.add("font-style");
        attrSet.add("image-rendering");
        attrSet.add("mask");
        attrSet.add("opacity");
        attrSet.add("shape-rendering");
        attrSet.add("stop-color");
        attrSet.add("stop-opacity");
        attrSet.add("stroke");
        attrSet.add("stroke-opacity");
        attrSet.add("stroke-dasharray");
        attrSet.add("stroke-dashoffset");
        attrSet.add("stroke-linecap");
        attrSet.add("stroke-linejoin");
        attrSet.add("stroke-miterlimit");
        attrSet.add("stroke-width");
        attrSet.add("text-rendering");
        set = attrSet;
    }
}
