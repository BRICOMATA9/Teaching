// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.Line2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGGeneratorContext

public class SVGLine extends SVGGraphicObjectConverter
{

    public SVGLine(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public Element toSVG(Line2D line2d)
    {
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "line");
        element.setAttributeNS(null, "x1", doubleString(line2d.getX1()));
        element.setAttributeNS(null, "y1", doubleString(line2d.getY1()));
        element.setAttributeNS(null, "x2", doubleString(line2d.getX2()));
        element.setAttributeNS(null, "y2", doubleString(line2d.getY2()));
        return element;
    }
}
