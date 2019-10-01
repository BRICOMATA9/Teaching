// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.GradientPaint;
import java.awt.geom.Point2D;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGPaintDescriptor, SVGGeneratorContext, SVGColor, 
//            SVGIDGenerator, SVGDescriptor

public class SVGLinearGradient extends AbstractSVGConverter
{

    public SVGLinearGradient(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        java.awt.Paint paint = graphiccontext.getPaint();
        return toSVG((GradientPaint)paint);
    }

    public SVGPaintDescriptor toSVG(GradientPaint gradientpaint)
    {
        SVGPaintDescriptor svgpaintdescriptor = (SVGPaintDescriptor)descMap.get(gradientpaint);
        Document document = generatorContext.domFactory;
        if(svgpaintdescriptor == null)
        {
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "linearGradient");
            element.setAttributeNS(null, "gradientUnits", "userSpaceOnUse");
            Point2D point2d = gradientpaint.getPoint1();
            Point2D point2d1 = gradientpaint.getPoint2();
            element.setAttributeNS(null, "x1", "" + doubleString(point2d.getX()));
            element.setAttributeNS(null, "y1", "" + doubleString(point2d.getY()));
            element.setAttributeNS(null, "x2", "" + doubleString(point2d1.getX()));
            element.setAttributeNS(null, "y2", "" + doubleString(point2d1.getY()));
            String s = "pad";
            if(gradientpaint.isCyclic())
                s = "reflect";
            element.setAttributeNS(null, "spreadMethod", s);
            Element element1 = document.createElementNS("http://www.w3.org/2000/svg", "stop");
            element1.setAttributeNS(null, "offset", "0%");
            SVGPaintDescriptor svgpaintdescriptor1 = SVGColor.toSVG(gradientpaint.getColor1(), generatorContext);
            element1.setAttributeNS(null, "stop-color", svgpaintdescriptor1.getPaintValue());
            element1.setAttributeNS(null, "stop-opacity", svgpaintdescriptor1.getOpacityValue());
            element.appendChild(element1);
            element1 = document.createElementNS("http://www.w3.org/2000/svg", "stop");
            element1.setAttributeNS(null, "offset", "100%");
            svgpaintdescriptor1 = SVGColor.toSVG(gradientpaint.getColor2(), generatorContext);
            element1.setAttributeNS(null, "stop-color", svgpaintdescriptor1.getPaintValue());
            element1.setAttributeNS(null, "stop-opacity", svgpaintdescriptor1.getOpacityValue());
            element.appendChild(element1);
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("linearGradient"));
            StringBuffer stringbuffer = new StringBuffer("url(");
            stringbuffer.append("#");
            stringbuffer.append(element.getAttributeNS(null, "id"));
            stringbuffer.append(")");
            svgpaintdescriptor = new SVGPaintDescriptor(stringbuffer.toString(), "1", element);
            descMap.put(gradientpaint, svgpaintdescriptor);
            defSet.add(element);
        }
        return svgpaintdescriptor;
    }
}
