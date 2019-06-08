// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.RenderingHints;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGHintsDescriptor, SVGGeneratorContext, SVGDescriptor

public class SVGRenderingHints extends AbstractSVGConverter
{

    public SVGRenderingHints(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getRenderingHints());
    }

    public static SVGHintsDescriptor toSVG(RenderingHints renderinghints)
    {
        String s = "auto";
        String s1 = "auto";
        String s2 = "auto";
        String s3 = "auto";
        String s4 = "auto";
        if(renderinghints != null)
        {
            Object obj = renderinghints.get(RenderingHints.KEY_RENDERING);
            if(obj == RenderingHints.VALUE_RENDER_DEFAULT)
            {
                s = "auto";
                s1 = "auto";
                s2 = "auto";
                s3 = "auto";
                s4 = "auto";
            } else
            if(obj == RenderingHints.VALUE_RENDER_SPEED)
            {
                s = "sRGB";
                s1 = "optimizeSpeed";
                s2 = "optimizeSpeed";
                s3 = "geometricPrecision";
                s4 = "optimizeSpeed";
            } else
            if(obj == RenderingHints.VALUE_RENDER_QUALITY)
            {
                s = "linearRGB";
                s1 = "optimizeQuality";
                s2 = "optimizeQuality";
                s3 = "geometricPrecision";
                s4 = "optimizeQuality";
            }
            Object obj1 = renderinghints.get(RenderingHints.KEY_FRACTIONALMETRICS);
            if(obj1 == RenderingHints.VALUE_FRACTIONALMETRICS_ON)
            {
                s2 = "optimizeQuality";
                s3 = "geometricPrecision";
            } else
            if(obj1 == RenderingHints.VALUE_FRACTIONALMETRICS_OFF)
            {
                s2 = "optimizeSpeed";
                s3 = "optimizeSpeed";
            } else
            if(obj1 == RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT)
            {
                s2 = "auto";
                s3 = "auto";
            }
            Object obj2 = renderinghints.get(RenderingHints.KEY_ANTIALIASING);
            if(obj2 == RenderingHints.VALUE_ANTIALIAS_ON)
            {
                s2 = "optimizeLegibility";
                s3 = "auto";
            } else
            if(obj2 == RenderingHints.VALUE_ANTIALIAS_OFF)
            {
                s2 = "geometricPrecision";
                s3 = "crispEdges";
            } else
            if(obj2 == RenderingHints.VALUE_ANTIALIAS_DEFAULT)
            {
                s2 = "auto";
                s3 = "auto";
            }
            Object obj3 = renderinghints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
            if(obj3 == RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
                s2 = "geometricPrecision";
            else
            if(obj3 == RenderingHints.VALUE_TEXT_ANTIALIAS_OFF)
                s2 = "optimizeSpeed";
            else
            if(obj3 == RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT)
                s2 = "auto";
            Object obj4 = renderinghints.get(RenderingHints.KEY_COLOR_RENDERING);
            if(obj4 == RenderingHints.VALUE_COLOR_RENDER_DEFAULT)
                s1 = "auto";
            else
            if(obj4 == RenderingHints.VALUE_COLOR_RENDER_QUALITY)
                s1 = "optimizeQuality";
            else
            if(obj4 == RenderingHints.VALUE_COLOR_RENDER_SPEED)
                s1 = "optimizeSpeed";
            Object obj5 = renderinghints.get(RenderingHints.KEY_INTERPOLATION);
            if(obj5 == RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR)
                s4 = "optimizeSpeed";
            else
            if(obj5 == RenderingHints.VALUE_INTERPOLATION_BICUBIC || obj5 == RenderingHints.VALUE_INTERPOLATION_BILINEAR)
                s4 = "optimizeQuality";
        }
        return new SVGHintsDescriptor(s, s1, s2, s3, s4);
    }
}
