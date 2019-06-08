// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import org.w3c.dom.Element;

public class SVGFilterDescriptor
{

    public SVGFilterDescriptor(String s)
    {
        filterValue = s;
    }

    public SVGFilterDescriptor(String s, Element element)
    {
        this(s);
        def = element;
    }

    public String getFilterValue()
    {
        return filterValue;
    }

    public Element getDef()
    {
        return def;
    }

    private Element def;
    private String filterValue;
}
