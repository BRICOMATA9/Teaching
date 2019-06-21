// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Polygon;
import java.awt.geom.PathIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGGeneratorContext

public class SVGPolygon extends SVGGraphicObjectConverter
{

    public SVGPolygon(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public Element toSVG(Polygon polygon)
    {
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "polygon");
        StringBuffer stringbuffer = new StringBuffer(" ");
        PathIterator pathiterator = polygon.getPathIterator(null);
        float af[] = new float[6];
        boolean flag = false;
        for(; !pathiterator.isDone(); pathiterator.next())
        {
            int i = pathiterator.currentSegment(af);
            switch(i)
            {
            case 0: // '\0'
                appendPoint(stringbuffer, af[0], af[1]);
                break;

            case 1: // '\001'
                appendPoint(stringbuffer, af[0], af[1]);
                break;

            case 2: // '\002'
            case 3: // '\003'
            default:
                throw new Error();

            case 4: // '\004'
                break;
            }
        }

        element.setAttributeNS(null, "points", stringbuffer.substring(0, stringbuffer.length() - 1));
        return element;
    }

    private void appendPoint(StringBuffer stringbuffer, float f, float f1)
    {
        stringbuffer.append(doubleString(f));
        stringbuffer.append(" ");
        stringbuffer.append(doubleString(f1));
        stringbuffer.append(" ");
    }
}
