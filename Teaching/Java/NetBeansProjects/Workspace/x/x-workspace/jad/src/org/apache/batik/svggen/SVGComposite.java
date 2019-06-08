// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.LinkedList;
import java.util.List;
import org.apache.batik.ext.awt.g2d.GraphicContext;

// Referenced classes of package org.apache.batik.svggen:
//            SVGConverter, SVGAlphaComposite, SVGCustomComposite, SVGGeneratorContext, 
//            SVGDescriptor, SVGCompositeDescriptor

public class SVGComposite
    implements SVGConverter
{

    public SVGComposite(SVGGeneratorContext svggeneratorcontext)
    {
        svgAlphaComposite = new SVGAlphaComposite(svggeneratorcontext);
        svgCustomComposite = new SVGCustomComposite(svggeneratorcontext);
        generatorContext = svggeneratorcontext;
    }

    public List getDefinitionSet()
    {
        LinkedList linkedlist = new LinkedList(svgAlphaComposite.getDefinitionSet());
        linkedlist.addAll(svgCustomComposite.getDefinitionSet());
        return linkedlist;
    }

    public SVGAlphaComposite getAlphaCompositeConverter()
    {
        return svgAlphaComposite;
    }

    public SVGCustomComposite getCustomCompositeConverter()
    {
        return svgCustomComposite;
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG(graphiccontext.getComposite());
    }

    public SVGCompositeDescriptor toSVG(java.awt.Composite composite)
    {
        if(composite instanceof java.awt.AlphaComposite)
            return svgAlphaComposite.toSVG((java.awt.AlphaComposite)composite);
        else
            return svgCustomComposite.toSVG(composite);
    }

    private SVGAlphaComposite svgAlphaComposite;
    private SVGCustomComposite svgCustomComposite;
    private SVGGeneratorContext generatorContext;
}
