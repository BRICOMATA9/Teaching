// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.Ellipse2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGGeneratorContext, SVGLine

public class SVGEllipse extends SVGGraphicObjectConverter
{

    public SVGEllipse(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public Element toSVG(Ellipse2D ellipse2d)
    {
        if(ellipse2d.getWidth() < 0.0D || ellipse2d.getHeight() < 0.0D)
            return null;
        if(ellipse2d.getWidth() == ellipse2d.getHeight())
            return toSVGCircle(ellipse2d);
        else
            return toSVGEllipse(ellipse2d);
    }

    private Element toSVGCircle(Ellipse2D ellipse2d)
    {
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "circle");
        element.setAttributeNS(null, "cx", doubleString(ellipse2d.getX() + ellipse2d.getWidth() / 2D));
        element.setAttributeNS(null, "cy", doubleString(ellipse2d.getY() + ellipse2d.getHeight() / 2D));
        element.setAttributeNS(null, "r", doubleString(ellipse2d.getWidth() / 2D));
        return element;
    }

    private Element toSVGEllipse(Ellipse2D ellipse2d)
    {
        if(ellipse2d.getWidth() > 0.0D && ellipse2d.getHeight() > 0.0D)
        {
            Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "ellipse");
            element.setAttributeNS(null, "cx", doubleString(ellipse2d.getX() + ellipse2d.getWidth() / 2D));
            element.setAttributeNS(null, "cy", doubleString(ellipse2d.getY() + ellipse2d.getHeight() / 2D));
            element.setAttributeNS(null, "rx", doubleString(ellipse2d.getWidth() / 2D));
            element.setAttributeNS(null, "ry", doubleString(ellipse2d.getHeight() / 2D));
            return element;
        }
        if(ellipse2d.getWidth() == 0.0D && ellipse2d.getHeight() > 0.0D)
        {
            java.awt.geom.Line2D.Double double1 = new java.awt.geom.Line2D.Double(ellipse2d.getX(), ellipse2d.getY(), ellipse2d.getX(), ellipse2d.getY() + ellipse2d.getHeight());
            if(svgLine == null)
                svgLine = new SVGLine(generatorContext);
            return svgLine.toSVG(double1);
        }
        if(ellipse2d.getWidth() > 0.0D && ellipse2d.getHeight() == 0.0D)
        {
            java.awt.geom.Line2D.Double double2 = new java.awt.geom.Line2D.Double(ellipse2d.getX(), ellipse2d.getY(), ellipse2d.getX() + ellipse2d.getWidth(), ellipse2d.getY());
            if(svgLine == null)
                svgLine = new SVGLine(generatorContext);
            return svgLine.toSVG(double2);
        } else
        {
            return null;
        }
    }

    private SVGLine svgLine;
}
