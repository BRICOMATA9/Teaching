// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.apache.batik.ext.awt.g2d.TransformStackElement;

// Referenced classes of package org.apache.batik.svggen:
//            SVGConverter, SVGGraphics2DRuntimeException, SVGTransform, SVGPaint, 
//            SVGBasicStroke, SVGComposite, SVGClip, SVGRenderingHints, 
//            SVGFont, SVGDescriptor, SVGGraphicContext, SVGGeneratorContext

public class SVGGraphicContextConverter
{

    public SVGTransform getTransformConverter()
    {
        return transformConverter;
    }

    public SVGPaint getPaintConverter()
    {
        return paintConverter;
    }

    public SVGBasicStroke getStrokeConverter()
    {
        return strokeConverter;
    }

    public SVGComposite getCompositeConverter()
    {
        return compositeConverter;
    }

    public SVGClip getClipConverter()
    {
        return clipConverter;
    }

    public SVGRenderingHints getHintsConverter()
    {
        return hintsConverter;
    }

    public SVGFont getFontConverter()
    {
        return fontConverter;
    }

    public SVGGraphicContextConverter(SVGGeneratorContext svggeneratorcontext)
    {
        converters = new SVGConverter[6];
        if(svggeneratorcontext == null)
        {
            throw new SVGGraphics2DRuntimeException("generatorContext should not be null");
        } else
        {
            transformConverter = new SVGTransform(svggeneratorcontext);
            paintConverter = new SVGPaint(svggeneratorcontext);
            strokeConverter = new SVGBasicStroke(svggeneratorcontext);
            compositeConverter = new SVGComposite(svggeneratorcontext);
            clipConverter = new SVGClip(svggeneratorcontext);
            hintsConverter = new SVGRenderingHints(svggeneratorcontext);
            fontConverter = new SVGFont(svggeneratorcontext);
            int i = 0;
            converters[i++] = paintConverter;
            converters[i++] = strokeConverter;
            converters[i++] = compositeConverter;
            converters[i++] = clipConverter;
            converters[i++] = hintsConverter;
            converters[i++] = fontConverter;
            return;
        }
    }

    public String toSVG(TransformStackElement atransformstackelement[])
    {
        return transformConverter.toSVGTransform(atransformstackelement);
    }

    public SVGGraphicContext toSVG(GraphicContext graphiccontext)
    {
        HashMap hashmap = new HashMap();
        for(int i = 0; i < converters.length; i++)
        {
            SVGDescriptor svgdescriptor = converters[i].toSVG(graphiccontext);
            if(svgdescriptor != null)
                svgdescriptor.getAttributeMap(hashmap);
        }

        return new SVGGraphicContext(hashmap, graphiccontext.getTransformStack());
    }

    public List getDefinitionSet()
    {
        LinkedList linkedlist = new LinkedList();
        for(int i = 0; i < converters.length; i++)
            linkedlist.addAll(converters[i].getDefinitionSet());

        return linkedlist;
    }

    private static final int GRAPHIC_CONTEXT_CONVERTER_COUNT = 6;
    private SVGTransform transformConverter;
    private SVGPaint paintConverter;
    private SVGBasicStroke strokeConverter;
    private SVGComposite compositeConverter;
    private SVGClip clipConverter;
    private SVGRenderingHints hintsConverter;
    private SVGFont fontConverter;
    private SVGConverter converters[];
}
