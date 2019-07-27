// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.List;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGPaintDescriptor, SVGGeneratorContext, ExtensionHandler, 
//            SVGDescriptor

public class SVGCustomPaint extends AbstractSVGConverter
{

    public SVGCustomPaint(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getPaint());
    }

    public SVGPaintDescriptor toSVG(java.awt.Paint paint)
    {
        SVGPaintDescriptor svgpaintdescriptor = (SVGPaintDescriptor)descMap.get(paint);
        if(svgpaintdescriptor == null)
        {
            svgpaintdescriptor = generatorContext.extensionHandler.handlePaint(paint, generatorContext);
            if(svgpaintdescriptor != null)
            {
                org.w3c.dom.Element element = svgpaintdescriptor.getDef();
                if(element != null)
                    defSet.add(element);
                descMap.put(paint, svgpaintdescriptor);
            }
        }
        return svgpaintdescriptor;
    }
}
