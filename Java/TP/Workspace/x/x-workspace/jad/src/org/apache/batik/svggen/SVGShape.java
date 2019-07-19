// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.*;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGArc, SVGEllipse, SVGLine, 
//            SVGPath, SVGPolygon, SVGRectangle, SVGGeneratorContext

public class SVGShape extends SVGGraphicObjectConverter
{

    public SVGShape(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        svgArc = new SVGArc(svggeneratorcontext);
        svgEllipse = new SVGEllipse(svggeneratorcontext);
        svgLine = new SVGLine(svggeneratorcontext);
        svgPath = new SVGPath(svggeneratorcontext);
        svgPolygon = new SVGPolygon(svggeneratorcontext);
        svgRectangle = new SVGRectangle(svggeneratorcontext);
    }

    public Element toSVG(Shape shape)
    {
        if(shape instanceof Polygon)
            return svgPolygon.toSVG((Polygon)shape);
        if(shape instanceof Rectangle2D)
            return svgRectangle.toSVG((Rectangle2D)shape);
        if(shape instanceof RoundRectangle2D)
            return svgRectangle.toSVG((RoundRectangle2D)shape);
        if(shape instanceof Ellipse2D)
            return svgEllipse.toSVG((Ellipse2D)shape);
        if(shape instanceof Line2D)
            return svgLine.toSVG((Line2D)shape);
        if(shape instanceof Arc2D)
            return svgArc.toSVG((Arc2D)shape);
        else
            return svgPath.toSVG(shape);
    }

    private SVGArc svgArc;
    private SVGEllipse svgEllipse;
    private SVGLine svgLine;
    private SVGPath svgPath;
    private SVGPolygon svgPolygon;
    private SVGRectangle svgRectangle;
}
