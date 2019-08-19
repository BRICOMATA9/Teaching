// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.HashMap;
import java.util.Map;

public class SVGIDGenerator
{

    public SVGIDGenerator()
    {
        prefixMap = new HashMap();
    }

    public String generateID(String s)
    {
        Integer integer = (Integer)prefixMap.get(s);
        if(integer == null)
        {
            integer = new Integer(0);
            prefixMap.put(s, integer);
        }
        integer = new Integer(integer.intValue() + 1);
        prefixMap.put(s, integer);
        return s + integer;
    }

    private Map prefixMap;
}
