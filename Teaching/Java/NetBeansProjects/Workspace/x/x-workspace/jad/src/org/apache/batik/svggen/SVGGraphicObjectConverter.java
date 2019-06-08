// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;


// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, SVGGraphics2DRuntimeException, SVGGeneratorContext

public abstract class SVGGraphicObjectConverter
    implements SVGSyntax
{

    public SVGGraphicObjectConverter(SVGGeneratorContext svggeneratorcontext)
    {
        if(svggeneratorcontext == null)
        {
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        } else
        {
            generatorContext = svggeneratorcontext;
            return;
        }
    }

    public final String doubleString(double d)
    {
        return generatorContext.doubleString(d);
    }

    protected SVGGeneratorContext generatorContext;
}
