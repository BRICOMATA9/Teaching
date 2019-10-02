// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.*;
import java.awt.image.BufferedImageOp;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGeneratorContext, SVGPaintDescriptor, SVGCompositeDescriptor, SVGFilterDescriptor

public interface ExtensionHandler
{

    public abstract SVGPaintDescriptor handlePaint(Paint paint, SVGGeneratorContext svggeneratorcontext);

    public abstract SVGCompositeDescriptor handleComposite(Composite composite, SVGGeneratorContext svggeneratorcontext);

    public abstract SVGFilterDescriptor handleFilter(BufferedImageOp bufferedimageop, Rectangle rectangle, SVGGeneratorContext svggeneratorcontext);
}
