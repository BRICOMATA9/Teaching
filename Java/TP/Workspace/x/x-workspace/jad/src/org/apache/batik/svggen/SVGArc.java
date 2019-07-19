// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGGraphicObjectConverter, SVGLine, SVGGeneratorContext

public class SVGArc extends SVGGraphicObjectConverter
{

    public SVGArc(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public Element toSVG(Arc2D arc2d)
    {
        if(arc2d.getWidth() == 0.0D || arc2d.getHeight() == 0.0D)
        {
            java.awt.geom.Line2D.Double double1 = new java.awt.geom.Line2D.Double(arc2d.getX(), arc2d.getY(), arc2d.getX() + arc2d.getWidth(), arc2d.getY() + arc2d.getHeight());
            if(svgLine == null)
                svgLine = new SVGLine(generatorContext);
            return svgLine.toSVG(double1);
        }
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "path");
        StringBuffer stringbuffer = new StringBuffer("");
        Point2D point2d = arc2d.getStartPoint();
        Point2D point2d1 = arc2d.getEndPoint();
        double d = arc2d.getAngleExtent();
        int i = arc2d.getArcType();
        stringbuffer.append("M");
        stringbuffer.append(doubleString(point2d.getX()));
        stringbuffer.append(" ");
        stringbuffer.append(doubleString(point2d.getY()));
        stringbuffer.append(" ");
        stringbuffer.append("A");
        stringbuffer.append(doubleString(arc2d.getWidth() / 2D));
        stringbuffer.append(" ");
        stringbuffer.append(doubleString(arc2d.getHeight() / 2D));
        stringbuffer.append(" ");
        stringbuffer.append("0");
        stringbuffer.append(" ");
        if(d > 180D)
            stringbuffer.append("1");
        else
            stringbuffer.append("0");
        stringbuffer.append(" ");
        if(d > 0.0D)
            stringbuffer.append("0");
        else
            stringbuffer.append("1");
        stringbuffer.append(" ");
        stringbuffer.append(doubleString(point2d1.getX()));
        stringbuffer.append(" ");
        stringbuffer.append(doubleString(point2d1.getY()));
        if(i == 1)
            stringbuffer.append("Z");
        else
        if(i == 2)
        {
            double d1 = arc2d.getX() + arc2d.getWidth() / 2D;
            double d2 = arc2d.getY() + arc2d.getHeight() / 2D;
            stringbuffer.append("L");
            stringbuffer.append(" ");
            stringbuffer.append(doubleString(d1));
            stringbuffer.append(" ");
            stringbuffer.append(doubleString(d2));
            stringbuffer.append(" ");
            stringbuffer.append("Z");
        }
        element.setAttributeNS(null, "d", stringbuffer.toString());
        return element;
    }

    private SVGLine svgLine;
}
