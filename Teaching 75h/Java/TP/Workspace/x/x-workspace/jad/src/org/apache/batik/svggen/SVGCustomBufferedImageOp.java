// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGFilterConverter, SVGFilterDescriptor, SVGGeneratorContext, ExtensionHandler

public class SVGCustomBufferedImageOp extends AbstractSVGFilterConverter
{

    public SVGCustomBufferedImageOp(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp bufferedimageop, java.awt.Rectangle rectangle)
    {
        SVGFilterDescriptor svgfilterdescriptor = (SVGFilterDescriptor)descMap.get(bufferedimageop);
        if(svgfilterdescriptor == null)
        {
            svgfilterdescriptor = generatorContext.extensionHandler.handleFilter(bufferedimageop, rectangle, generatorContext);
            if(svgfilterdescriptor != null)
            {
                org.w3c.dom.Element element = svgfilterdescriptor.getDef();
                if(element != null)
                    defSet.add(element);
                descMap.put(bufferedimageop, svgfilterdescriptor);
            } else
            {
                System.err.println("SVGCustomBufferedImageOp:: ExtensionHandler could not convert filter");
            }
        }
        return svgfilterdescriptor;
    }

    private static final String ERROR_EXTENSION = "SVGCustomBufferedImageOp:: ExtensionHandler could not convert filter";
}
