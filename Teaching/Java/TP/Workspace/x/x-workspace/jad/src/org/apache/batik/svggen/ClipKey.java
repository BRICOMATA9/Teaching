// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.GeneralPath;

// Referenced classes of package org.apache.batik.svggen:
//            SVGPath, SVGGeneratorContext

class ClipKey
{

    public ClipKey(GeneralPath generalpath, SVGGeneratorContext svggeneratorcontext)
    {
        hashCodeValue = 0;
        String s = SVGPath.toSVGPathData(generalpath, svggeneratorcontext);
        hashCodeValue = s.hashCode();
    }

    public int hashCode()
    {
        return hashCodeValue;
    }

    public boolean equals(Object obj)
    {
        boolean flag = false;
        if(obj != null && (obj instanceof ClipKey))
            flag = hashCodeValue == ((ClipKey)obj).hashCodeValue;
        return flag;
    }

    int hashCodeValue;
}
