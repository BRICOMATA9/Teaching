// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Rectangle;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGFilterConverter, SVGFilterDescriptor, SVGGeneratorContext, SVGIDGenerator

public class SVGConvolveOp extends AbstractSVGFilterConverter
{

    public SVGConvolveOp(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGFilterDescriptor toSVG(BufferedImageOp bufferedimageop, Rectangle rectangle)
    {
        if(bufferedimageop instanceof ConvolveOp)
            return toSVG((ConvolveOp)bufferedimageop);
        else
            return null;
    }

    public SVGFilterDescriptor toSVG(ConvolveOp convolveop)
    {
        SVGFilterDescriptor svgfilterdescriptor = (SVGFilterDescriptor)descMap.get(convolveop);
        Document document = generatorContext.domFactory;
        if(svgfilterdescriptor == null)
        {
            Kernel kernel = convolveop.getKernel();
            Element element = document.createElementNS("http://www.w3.org/2000/svg", "filter");
            Element element1 = document.createElementNS("http://www.w3.org/2000/svg", "feConvolveMatrix");
            element1.setAttributeNS(null, "order", kernel.getWidth() + " " + kernel.getHeight());
            StringBuffer stringbuffer = new StringBuffer();
            float af[] = kernel.getKernelData(null);
            for(int i = 0; i < af.length; i++)
            {
                stringbuffer.append(doubleString(af[i]));
                stringbuffer.append(" ");
            }

            element1.setAttributeNS(null, "kernelMatrix", stringbuffer.toString().trim());
            element.appendChild(element1);
            element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("convolve"));
            if(convolveop.getEdgeCondition() == 1)
                element1.setAttributeNS(null, "edgeMode", "duplicate");
            else
                element1.setAttributeNS(null, "edgeMode", "none");
            StringBuffer stringbuffer1 = new StringBuffer("url(");
            stringbuffer1.append("#");
            stringbuffer1.append(element.getAttributeNS(null, "id"));
            stringbuffer1.append(")");
            svgfilterdescriptor = new SVGFilterDescriptor(stringbuffer1.toString(), element);
            defSet.add(element);
            descMap.put(convolveop, svgfilterdescriptor);
        }
        return svgfilterdescriptor;
    }
}
