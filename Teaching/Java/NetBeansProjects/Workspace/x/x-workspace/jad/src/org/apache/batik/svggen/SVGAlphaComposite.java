// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.awt.AlphaComposite;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            AbstractSVGConverter, SVGCompositeDescriptor, SVGGeneratorContext, SVGDescriptor

public class SVGAlphaComposite extends AbstractSVGConverter
{

    public SVGAlphaComposite(SVGGeneratorContext svggeneratorcontext)
    {
        super(svggeneratorcontext);
        compositeDefsMap = new HashMap();
        backgroundAccessRequired = false;
        compositeDefsMap.put(AlphaComposite.Src, compositeToSVG(AlphaComposite.Src));
        compositeDefsMap.put(AlphaComposite.SrcIn, compositeToSVG(AlphaComposite.SrcIn));
        compositeDefsMap.put(AlphaComposite.SrcOut, compositeToSVG(AlphaComposite.SrcOut));
        compositeDefsMap.put(AlphaComposite.DstIn, compositeToSVG(AlphaComposite.DstIn));
        compositeDefsMap.put(AlphaComposite.DstOut, compositeToSVG(AlphaComposite.DstOut));
        compositeDefsMap.put(AlphaComposite.DstOver, compositeToSVG(AlphaComposite.DstOver));
        compositeDefsMap.put(AlphaComposite.Clear, compositeToSVG(AlphaComposite.Clear));
    }

    public java.util.List getAlphaCompositeFilterSet()
    {
        return new LinkedList(compositeDefsMap.values());
    }

    public boolean requiresBackgroundAccess()
    {
        return backgroundAccessRequired;
    }

    public SVGDescriptor toSVG(GraphicContext graphiccontext)
    {
        return toSVG((AlphaComposite)graphiccontext.getComposite());
    }

    public SVGCompositeDescriptor toSVG(AlphaComposite alphacomposite)
    {
        SVGCompositeDescriptor svgcompositedescriptor = (SVGCompositeDescriptor)descMap.get(alphacomposite);
        if(svgcompositedescriptor == null)
        {
            String s = doubleString(alphacomposite.getAlpha());
            String s1 = null;
            Element element = null;
            if(alphacomposite.getRule() != 3)
            {
                AlphaComposite alphacomposite1 = AlphaComposite.getInstance(alphacomposite.getRule());
                element = (Element)compositeDefsMap.get(alphacomposite1);
                defSet.add(element);
                StringBuffer stringbuffer = new StringBuffer("url(");
                stringbuffer.append("#");
                stringbuffer.append(element.getAttributeNS(null, "id"));
                stringbuffer.append(")");
                s1 = stringbuffer.toString();
            } else
            {
                s1 = "none";
            }
            svgcompositedescriptor = new SVGCompositeDescriptor(s, s1, element);
            descMap.put(alphacomposite, svgcompositedescriptor);
        }
        if(alphacomposite.getRule() != 3)
            backgroundAccessRequired = true;
        return svgcompositedescriptor;
    }

    private Element compositeToSVG(AlphaComposite alphacomposite)
    {
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = "0";
        String s4 = null;
        switch(alphacomposite.getRule())
        {
        case 1: // '\001'
            s = "arithmetic";
            s1 = "SourceGraphic";
            s2 = "BackgroundImage";
            s4 = "alphaCompositeClear";
            break;

        case 2: // '\002'
            s = "arithmetic";
            s1 = "SourceGraphic";
            s2 = "BackgroundImage";
            s4 = "alphaCompositeSrc";
            s3 = "1";
            break;

        case 5: // '\005'
            s = "in";
            s1 = "SourceGraphic";
            s2 = "BackgroundImage";
            s4 = "alphaCompositeSrcIn";
            break;

        case 7: // '\007'
            s = "out";
            s1 = "SourceGraphic";
            s2 = "BackgroundImage";
            s4 = "alphaCompositeSrcOut";
            break;

        case 6: // '\006'
            s = "in";
            s2 = "SourceGraphic";
            s1 = "BackgroundImage";
            s4 = "alphaCompositeDstIn";
            break;

        case 8: // '\b'
            s = "out";
            s2 = "SourceGraphic";
            s1 = "BackgroundImage";
            s4 = "alphaCompositeDstOut";
            break;

        case 4: // '\004'
            s = "over";
            s2 = "SourceGraphic";
            s1 = "BackgroundImage";
            s4 = "alphaCompositeDstOver";
            break;

        case 3: // '\003'
        default:
            throw new Error();
        }
        Element element = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "filter");
        element.setAttributeNS(null, "id", s4);
        element.setAttributeNS(null, "filterUnits", "objectBoundingBox");
        element.setAttributeNS(null, "x", "0%");
        element.setAttributeNS(null, "y", "0%");
        element.setAttributeNS(null, "width", "100%");
        element.setAttributeNS(null, "height", "100%");
        Element element1 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "feComposite");
        element1.setAttributeNS(null, "operator", s);
        element1.setAttributeNS(null, "in", s1);
        element1.setAttributeNS(null, "in2", s2);
        element1.setAttributeNS(null, "k2", s3);
        element1.setAttributeNS(null, "result", "composite");
        Element element2 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "feFlood");
        element2.setAttributeNS(null, "flood-color", "white");
        element2.setAttributeNS(null, "flood-opacity", "1");
        element2.setAttributeNS(null, "result", "flood");
        Element element3 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "feMerge");
        Element element4 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "feMergeNode");
        element4.setAttributeNS(null, "in", "flood");
        Element element5 = generatorContext.domFactory.createElementNS("http://www.w3.org/2000/svg", "feMergeNode");
        element5.setAttributeNS(null, "in", "composite");
        element3.appendChild(element4);
        element3.appendChild(element5);
        element.appendChild(element2);
        element.appendChild(element1);
        element.appendChild(element3);
        return element;
    }

    private Map compositeDefsMap;
    private boolean backgroundAccessRequired;
}
