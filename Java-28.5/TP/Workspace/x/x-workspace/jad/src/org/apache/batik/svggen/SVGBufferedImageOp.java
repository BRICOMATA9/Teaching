// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGFilterConverter, SVGLookupOp, SVGRescaleOp, SVGConvolveOp, 
//            SVGCustomBufferedImageOp, SVGGeneratorContext, SVGFilterDescriptor

public class SVGBufferedImageOp extends AbstractSVGFilterConverter
{

    public SVGBufferedImageOp(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        svgLookupOp = new SVGLookupOp(svggeneratorcontext);
        svgRescaleOp = new SVGRescaleOp(svggeneratorcontext);
        svgConvolveOp = new SVGConvolveOp(svggeneratorcontext);
        svgCustomBufferedImageOp = new SVGCustomBufferedImageOp(svggeneratorcontext);
    }

    public List getDefinitionSet()
    {
        LinkedList linkedlist = new LinkedList(svgLookupOp.getDefinitionSet());
        linkedlist.addAll(svgRescaleOp.getDefinitionSet());
        linkedlist.addAll(svgConvolveOp.getDefinitionSet());
        linkedlist.addAll(svgCustomBufferedImageOp.getDefinitionSet());
        return linkedlist;
    }

    public SVGLookupOp getLookupOpConverter()
    {
        return svgLookupOp;
    }

    public SVGRescaleOp getRescaleOpConverter()
    {
        return svgRescaleOp;
    }

    public SVGConvolveOp getConvolveOpConverter()
    {
        return svgConvolveOp;
    }

    public SVGCustomBufferedImageOp getCustomBufferedImageOpConverter()
    {
        return svgCustomBufferedImageOp;
    }

    public SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp bufferedimageop, java.awt.Rectangle rectangle)
    {
        SVGFilterDescriptor svgfilterdescriptor = svgCustomBufferedImageOp.toSVG(bufferedimageop, rectangle);
        if(svgfilterdescriptor == null)
            if(bufferedimageop instanceof java.awt.image.LookupOp)
                svgfilterdescriptor = svgLookupOp.toSVG((java.awt.image.LookupOp)bufferedimageop, rectangle);
            else
            if(bufferedimageop instanceof java.awt.image.RescaleOp)
                svgfilterdescriptor = svgRescaleOp.toSVG((java.awt.image.RescaleOp)bufferedimageop, rectangle);
            else
            if(bufferedimageop instanceof java.awt.image.ConvolveOp)
                svgfilterdescriptor = svgConvolveOp.toSVG((java.awt.image.ConvolveOp)bufferedimageop, rectangle);
        return svgfilterdescriptor;
    }

    private SVGLookupOp svgLookupOp;
    private SVGRescaleOp svgRescaleOp;
    private SVGConvolveOp svgConvolveOp;
    private SVGCustomBufferedImageOp svgCustomBufferedImageOp;
}
