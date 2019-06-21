// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.Map;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGeneratorContext

public interface StyleHandler
{

    public abstract void setStyle(Element element, Map map, SVGGeneratorContext svggeneratorcontext);
}
