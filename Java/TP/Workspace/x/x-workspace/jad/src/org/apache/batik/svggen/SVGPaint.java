// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.LinkedList;
import java.util.List;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            SVGConverter, SVGLinearGradient, SVGTexturePaint, SVGCustomPaint, 
//            SVGColor, SVGGeneratorContext, SVGDescriptor, SVGPaintDescriptor

public class SVGPaint
    implements SVGConverter
{

    public SVGPaint(SVGGeneratorContext svggeneratorcontext)
    {
        svgLinearGradient = new SVGLinearGradient(svggeneratorcontext);
        svgTexturePaint = new SVGTexturePaint(svggeneratorcontext);
        svgCustomPaint = new SVGCustomPaint(svggeneratorcontext);
        svgColor = new SVGColor(svggeneratorcontext);
        generatorContext = svggeneratorcontext;
    }

    public List getDefinitionSet()
    {
        LinkedList linkedlist = new LinkedList(svgLinearGradient.getDefinitionSet());
        linkedlist.addAll(svgTexturePaint.getDefinitionSet());
        linkedlist.addAll(svgCustomPaint.getDefinitionSet());
        linkedlist.addAll(svgColor.getDefinitionSet());
        return linkedlist;
    }

    public SVGTexturePaint getTexturePaintConverter()
    {
        return svgTexturePaint;
    }

    public SVGLinearGradient getGradientPaintConverter()
    {
        return svgLinearGradient;
    }

    public SVGCustomPaint getCustomPaintConverter()
    {
        return svgCustomPaint;
    }

    public SVGColor getColorConverter()
    {
        return svgColor;
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getPaint());
    }

    public SVGPaintDescriptor toSVG(java.awt.Paint paint)
    {
        SVGPaintDescriptor svgpaintdescriptor = svgCustomPaint.toSVG(paint);
        if(svgpaintdescriptor == null)
            if(paint instanceof java.awt.Color)
                svgpaintdescriptor = SVGColor.toSVG((java.awt.Color)paint, generatorContext);
            else
            if(paint instanceof java.awt.GradientPaint)
                svgpaintdescriptor = svgLinearGradient.toSVG((java.awt.GradientPaint)paint);
            else
            if(paint instanceof java.awt.TexturePaint)
                svgpaintdescriptor = svgTexturePaint.toSVG((java.awt.TexturePaint)paint);
        return svgpaintdescriptor;
    }

    private SVGLinearGradient svgLinearGradient;
    private SVGTexturePaint svgTexturePaint;
    private SVGColor svgColor;
    private SVGCustomPaint svgCustomPaint;
    private SVGGeneratorContext generatorContext;
}
