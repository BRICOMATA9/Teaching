// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGShape, ClipKey, SVGClipDescriptor, 
//            SVGGeneratorContext, SVGIDGenerator, SVGDescriptor

public class SVGClip extends AbstractSVGConverter
{

    public SVGClip(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        shapeConverter = new SVGShape(svggeneratorcontext);
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        Shape shape = graphiccontext.getClip();
        SVGClipDescriptor svgclipdescriptor = null;
        if(shape != null)
        {
            StringBuffer stringbuffer = new StringBuffer("url(");
            GeneralPath generalpath = new GeneralPath(shape);
            ClipKey clipkey = new ClipKey(generalpath, generatorContext);
            svgclipdescriptor = (SVGClipDescriptor)descMap.get(clipkey);
            if(svgclipdescriptor == null)
            {
                Element element = clipToSVG(shape);
                if(element == null)
                {
                    svgclipdescriptor = NO_CLIP;
                } else
                {
                    stringbuffer.append("#");
                    stringbuffer.append(element.getAttributeNS(null, "id"));
                    stringbuffer.append(")");
                    svgclipdescriptor = new SVGClipDescriptor(stringbuffer.toString(), element);
                    descMap.put(clipkey, svgclipdescriptor);
                    defSet.add(element);
                }
            }
        } else
        {
            svgclipdescriptor = NO_CLIP;
        }
        return svgclipdescriptor;
    }

    private Element clipToSVG(Shape shape)
    {
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "clipPath");
        element.setAttributeNS(null, "clipPathUnits", "userSpaceOnUse");
        element.setAttributeNS(null, "id", generatorContext.idGenerator.generateID("clipPath"));
        Element element1 = shapeConverter.toSVG(shape);
        if(element1 != null)
        {
            element.appendChild(element1);
            return element;
        } else
        {
            element.appendChild(shapeConverter.toSVG(ORIGIN));
            return element;
        }
    }

    public static final Shape ORIGIN = new java.awt.geom.Line2D.Float(0.0F, 0.0F, 0.0F, 0.0F);
    public static final SVGClipDescriptor NO_CLIP = new SVGClipDescriptor("none", null);
    private SVGShape shapeConverter;

}
