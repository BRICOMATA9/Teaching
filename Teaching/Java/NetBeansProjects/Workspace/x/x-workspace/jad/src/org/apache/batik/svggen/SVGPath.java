// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Shape;
import java.awt.geom.PathIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGGeneratorContext

public class SVGPath extends SVGGraphicObjectConverter
{

    public SVGPath(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public Element toSVG(Shape shape)
    {
        String s = toSVGPathData(shape, generatorContext);
        if(s == null || s.length() == 0)
            return null;
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "path");
        element.setAttributeNS(null, "d", s);
        if(shape.getPathIterator(null).getWindingRule() == 0)
            element.setAttributeNS(null, "fill-rule", "evenodd");
        return element;
    }

    public static String toSVGPathData(Shape shape, SVGGeneratorContext svggeneratorcontext)
    {
        StringBuffer stringbuffer = new StringBuffer("");
        PathIterator pathiterator = shape.getPathIterator(null);
        float af[] = new float[6];
        boolean flag = false;
        for(; !pathiterator.isDone(); pathiterator.next())
        {
            int i = pathiterator.currentSegment(af);
            switch(i)
            {
            case 0: // '\0'
                stringbuffer.append("M");
                appendPoint(stringbuffer, af[0], af[1], svggeneratorcontext);
                break;

            case 1: // '\001'
                stringbuffer.append("L");
                appendPoint(stringbuffer, af[0], af[1], svggeneratorcontext);
                break;

            case 4: // '\004'
                stringbuffer.append("Z");
                break;

            case 2: // '\002'
                stringbuffer.append("Q");
                appendPoint(stringbuffer, af[0], af[1], svggeneratorcontext);
                appendPoint(stringbuffer, af[2], af[3], svggeneratorcontext);
                break;

            case 3: // '\003'
                stringbuffer.append("C");
                appendPoint(stringbuffer, af[0], af[1], svggeneratorcontext);
                appendPoint(stringbuffer, af[2], af[3], svggeneratorcontext);
                appendPoint(stringbuffer, af[4], af[5], svggeneratorcontext);
                break;

            default:
                throw new Error();
            }
        }

        if(stringbuffer.length() > 0)
            return stringbuffer.toString().trim();
        else
            return "";
    }

    private static void appendPoint(StringBuffer stringbuffer, float f, float f1, SVGGeneratorContext svggeneratorcontext)
    {
        stringbuffer.append(svggeneratorcontext.doubleString(f));
        stringbuffer.append(" ");
        stringbuffer.append(svggeneratorcontext.doubleString(f1));
        stringbuffer.append(" ");
    }
}
