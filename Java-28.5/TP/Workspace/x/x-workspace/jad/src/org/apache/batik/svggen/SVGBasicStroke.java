// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.BasicStroke;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGStrokeDescriptor, SVGGeneratorContext, SVGDescriptor

public class SVGBasicStroke extends AbstractSVGConverter
{

    public SVGBasicStroke(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        if(graphiccontext.getStroke() instanceof BasicStroke)
            return toSVG((BasicStroke)graphiccontext.getStroke());
        else
            return null;
    }

    public final SVGStrokeDescriptor toSVG(BasicStroke basicstroke)
    {
        String s = doubleString(basicstroke.getLineWidth());
        String s1 = endCapToSVG(basicstroke.getEndCap());
        String s2 = joinToSVG(basicstroke.getLineJoin());
        String s3 = doubleString(basicstroke.getMiterLimit());
        float af[] = basicstroke.getDashArray();
        String s4 = null;
        if(af != null)
            s4 = dashArrayToSVG(af);
        else
            s4 = "none";
        String s5 = doubleString(basicstroke.getDashPhase());
        return new SVGStrokeDescriptor(s, s1, s2, s3, s4, s5);
    }

    private final String dashArrayToSVG(float af[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        if(af.length > 0)
            stringbuffer.append(doubleString(af[0]));
        for(int i = 1; i < af.length; i++)
        {
            stringbuffer.append(",");
            stringbuffer.append(doubleString(af[i]));
        }

        return stringbuffer.toString();
    }

    private static String joinToSVG(int i)
    {
        switch(i)
        {
        case 2: // '\002'
            return "bevel";

        case 1: // '\001'
            return "round";

        case 0: // '\0'
        default:
            return "miter";
        }
    }

    private static String endCapToSVG(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return "butt";

        case 1: // '\001'
            return "round";

        case 2: // '\002'
        default:
            return "square";
        }
    }
}
