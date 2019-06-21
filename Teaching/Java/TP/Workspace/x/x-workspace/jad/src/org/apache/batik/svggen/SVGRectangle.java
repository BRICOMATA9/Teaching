// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGLine, SVGGeneratorContext

public class SVGRectangle extends SVGGraphicObjectConverter
{

    public SVGRectangle(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        svgLine = new SVGLine(svggeneratorcontext);
    }

    public Element toSVG(Rectangle2D rectangle2d)
    {
        return toSVG(((RectangularShape) (rectangle2d)));
    }

    public Element toSVG(RoundRectangle2D roundrectangle2d)
    {
        Element element = toSVG(((RectangularShape) (roundrectangle2d)));
        if(element != null && element.getTagName() == "rect")
        {
            element.setAttributeNS(null, "rx", doubleString(Math.abs(roundrectangle2d.getArcWidth() / 2D)));
            element.setAttributeNS(null, "ry", doubleString(Math.abs(roundrectangle2d.getArcHeight() / 2D)));
        }
        return element;
    }

    private Element toSVG(RectangularShape rectangularshape)
    {
        if(rectangularshape.getWidth() > 0.0D && rectangularshape.getHeight() > 0.0D)
        {
            Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "rect");
            element.setAttributeNS(null, "x", doubleString(rectangularshape.getX()));
            element.setAttributeNS(null, "y", doubleString(rectangularshape.getY()));
            element.setAttributeNS(null, "width", doubleString(rectangularshape.getWidth()));
            element.setAttributeNS(null, "height", doubleString(rectangularshape.getHeight()));
            return element;
        }
        if(rectangularshape.getWidth() == 0.0D && rectangularshape.getHeight() > 0.0D)
        {
            java.awt.geom.Line2D.Double double1 = new java.awt.geom.Line2D.Double(rectangularshape.getX(), rectangularshape.getY(), rectangularshape.getX(), rectangularshape.getY() + rectangularshape.getHeight());
            return svgLine.toSVG(double1);
        }
        if(rectangularshape.getWidth() > 0.0D && rectangularshape.getHeight() == 0.0D)
        {
            java.awt.geom.Line2D.Double double2 = new java.awt.geom.Line2D.Double(rectangularshape.getX(), rectangularshape.getY(), rectangularshape.getX() + rectangularshape.getWidth(), rectangularshape.getY());
            return svgLine.toSVG(double2);
        } else
        {
            return null;
        }
    }

    private SVGLine svgLine;
}
