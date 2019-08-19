// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.List;
import java.util.Map;

public interface SVGDescriptor
{

    public abstract Map getAttributeMap(Map map);

    public abstract List getDefinitionSet(List list);
}
