// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.HashSet;
import java.util.Set;

public class SVGAttribute
{

    public SVGAttribute(Set set, boolean flag)
    {
        if(set == null)
            set = new HashSet();
        applicabilitySet = set;
        isSetInclusive = flag;
    }

    public boolean appliesTo(String s)
    {
        boolean flag = applicabilitySet.contains(s);
        if(isSetInclusive)
            return flag;
        else
            return !flag;
    }

    private String name;
    private Set applicabilitySet;
    private boolean isSetInclusive;
}
