// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.image.BufferedImageOp;

// Referenced classes of package org.apache.batik.svggen:
//            ExtensionHandler, SVGGeneratorContext, SVGPaintDescriptor, SVGCompositeDescriptor, 
//            SVGFilterDescriptor

public class DefaultExtensionHandler
    implements ExtensionHandler
{

    public DefaultExtensionHandler()
    {
    }

    public SVGPaintDescriptor handlePaint(Paint paint, SVGGeneratorContext svggeneratorcontext)
    {
        return null;
    }

    public SVGCompositeDescriptor handleComposite(Composite composite, SVGGeneratorContext svggeneratorcontext)
    {
        return null;
    }

    public SVGFilterDescriptor handleFilter(BufferedImageOp bufferedimageop, Rectangle rectangle, SVGGeneratorContext svggeneratorcontext)
    {
        return null;
    }
}
