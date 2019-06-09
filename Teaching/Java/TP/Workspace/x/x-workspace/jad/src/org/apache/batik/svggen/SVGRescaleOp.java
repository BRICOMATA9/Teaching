// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Rectangle;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGFilterConverter, SVGFilterDescriptor, SVGGeneratorContext, SVGGraphics2DRuntimeException, 
//            SVGIDGenerator

public class SVGRescaleOp extends AbstractSVGFilterConverter
{

    public SVGRescaleOp(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGFilterDescriptor toSVG(BufferedImageOp bufferedimageop, Rectangle rectangle)
    {
        if(bufferedimageop instanceof RescaleOp)
            return toSVG((RescaleOp)bufferedimageop);
        else
            return null;
    }

    public SVGFilterDescriptor toSVG(RescaleOp rescaleop)
    {
        SVGFilterDescriptor svgfilterdescriptor = (SVGFilterDescriptor)descMap.get(rescaleop);
        Document document = generatorContext.domFactory;
        if(svgfilterdescriptor == null)
        {
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "filter");
            Element element1 = document.createElementNS("http://www.w3.org/2000/svg", "feComponentTransfer");
            float af[] = rescaleop.getOffsets(null);
            float af1[] = rescaleop.getScaleFactors(null);
            if(af.length != af1.length)
                throw new SVGGraphics2DRuntimeException("RescapeOp offsets and scaleFactor array length do not match");
            if(af.length != 1 && af.length != 3 && af.length != 4)
                throw new SVGGraphics2DRuntimeException("BufferedImage RescaleOp should have 1, 3 or 4 scale factors");
            Element element2 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncR");
            Element element3 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncG");
            Element element4 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncB");
            Element element5 = null;
            String s = "linear";
            if(af.length == 1)
            {
                String s1 = doubleString(af1[0]);
                String s2 = doubleString(af[0]);
                element2.setAttributeNS(null, "type", s);
                element3.setAttributeNS(null, "type", s);
                element4.setAttributeNS(null, "type", s);
                element2.setAttributeNS(null, "slope", s1);
                element3.setAttributeNS(null, "slope", s1);
                element4.setAttributeNS(null, "slope", s1);
                element2.setAttributeNS(null, "intercept", s2);
                element3.setAttributeNS(null, "intercept", s2);
                element4.setAttributeNS(null, "intercept", s2);
            } else
            if(af.length >= 3)
            {
                element2.setAttributeNS(null, "type", s);
                element3.setAttributeNS(null, "type", s);
                element4.setAttributeNS(null, "type", s);
                element2.setAttributeNS(null, "slope", doubleString(af1[0]));
                element3.setAttributeNS(null, "slope", doubleString(af1[1]));
                element4.setAttributeNS(null, "slope", doubleString(af1[2]));
                element2.setAttributeNS(null, "intercept", doubleString(af[0]));
                element3.setAttributeNS(null, "intercept", doubleString(af[1]));
                element4.setAttributeNS(null, "intercept", doubleString(af[2]));
                if(af.length == 4)
                {
                    element5 = document.createElementNS("http://www.w3.org/2000/svg", "feFuncA");
                    element5.setAttributeNS(null, "type", s);
                    element5.setAttributeNS(null, "slope", doubleString(af1[3]));
                    element5.setAttributeNS(null, "intercept", doubleString(af[3]));
                }
            }
            element1.appendChild(element2);
            element1.appendChild(element3);
            element1.appendChild(element4);
            if(element5 != null)
                element1.appendChild(element5);
            element.appendChild(element1);
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("componentTransfer"));
            StringBuffer stringbuffer = new StringBuffer("url(");
            stringbuffer.append("#");
            stringbuffer.append(element.getAttributeNS(null, "id"));
            stringbuffer.append(")");
            svgfilterdescriptor = new SVGFilterDescriptor(stringbuffer.toString(), element);
            defSet.add(element);
            descMap.put(rescaleop, svgfilterdescriptor);
        }
        return svgfilterdescriptor;
    }
}
