// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;

// Referenced classes of package org.apache.batik.svggen:
//            SVGConverter, ErrorConstants, SVGGraphics2DRuntimeException, SVGGeneratorContext

public abstract class AbstractSVGConverter
    implements SVGConverter, ErrorConstants
{

    public AbstractSVGConverter(SVGGeneratorContext svggeneratorcontext)
    {
        descMap = new HashMap();
        defSet = new LinkedList();
        if(svggeneratorcontext == null)
        {
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        } else
        {
            generatorContext = svggeneratorcontext;
            return;
        }
    }

    public List getDefinitionSet()
    {
        return defSet;
    }

    public final String doubleString(double d)
    {
        return generatorContext.doubleString(d);
    }

    protected SVGGeneratorContext generatorContext;
    protected Map descMap;
    protected List defSet;
}
