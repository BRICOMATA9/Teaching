// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.List;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGCompositeDescriptor, SVGGeneratorContext, ExtensionHandler, 
//            SVGDescriptor

public class SVGCustomComposite extends AbstractSVGConverter
{

    public SVGCustomComposite(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getComposite());
    }

    public SVGCompositeDescriptor toSVG(java.awt.Composite composite)
    {
        if(composite == null)
            throw new NullPointerException();
        SVGCompositeDescriptor svgcompositedescriptor = (SVGCompositeDescriptor)descMap.get(composite);
        if(svgcompositedescriptor == null)
        {
            SVGCompositeDescriptor svgcompositedescriptor1 = generatorContext.extensionHandler.handleComposite(composite, generatorContext);
            if(svgcompositedescriptor1 != null)
            {
                org.w3c.dom.Element element = svgcompositedescriptor1.getDef();
                if(element != null)
                    defSet.add(element);
                descMap.put(composite, svgcompositedescriptor1);
            }
        }
        return svgcompositedescriptor;
    }
}
