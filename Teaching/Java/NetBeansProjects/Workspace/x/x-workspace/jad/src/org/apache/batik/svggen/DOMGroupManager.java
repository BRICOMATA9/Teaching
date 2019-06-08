// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.svggen;

import java.util.*;
import org.apache.batik.ext.awt.g2d.GraphicContext;
import org.apache.batik.ext.awt.g2d.TransformStackElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package org.apache.batik.svggen:
//            SVGSyntax, ErrorConstants, SVGGraphics2DRuntimeException, DOMTreeManager, 
//            SVGGraphicContextConverter, SVGGraphicContext, StyleHandler, SVGAttributeMap, 
//            SVGAttribute

public class DOMGroupManager
    implements SVGSyntax, ErrorConstants
{

    public DOMGroupManager(GraphicContext graphiccontext, DOMTreeManager domtreemanager)
    {
        if(graphiccontext == null)
            throw new SVGGraphics2DRuntimeException("gc should not be null");
        if(domtreemanager == null)
        {
            throw new SVGGraphics2DRuntimeException("domTreeManager should not be null");
        } else
        {
            gc = graphiccontext;
            domTreeManager = domtreemanager;
            recycleCurrentGroup();
            groupGC = domtreemanager.gcConverter.toSVG(graphiccontext);
            return;
        }
    }

    void recycleCurrentGroup()
    {
        currentGroup = domTreeManager.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "g");
    }

    public void addElement(Element element)
    {
        addElement(element, (short)17);
    }

    public void addElement(Element element, short word0)
    {
        if(!currentGroup.hasChildNodes())
        {
            currentGroup.appendChild(element);
            groupGC = domTreeManager.gcConverter.toSVG(gc);
            SVGGraphicContext svggraphiccontext = processDeltaGC(groupGC, domTreeManager.defaultGC);
            domTreeManager.getStyleHandler().setStyle(currentGroup, svggraphiccontext.getGroupContext(), domTreeManager.getGeneratorContext());
            if((word0 & 1) == 0)
                svggraphiccontext.getGraphicElementContext().put("stroke", "none");
            if((word0 & 0x10) == 0)
                svggraphiccontext.getGraphicElementContext().put("fill", "none");
            domTreeManager.getStyleHandler().setStyle(element, svggraphiccontext.getGraphicElementContext(), domTreeManager.getGeneratorContext());
            setTransform(currentGroup, svggraphiccontext.getTransformStack());
            domTreeManager.appendGroup(currentGroup, this);
        } else
        if(gc.isTransformStackValid())
        {
            SVGGraphicContext svggraphiccontext1 = domTreeManager.gcConverter.toSVG(gc);
            SVGGraphicContext svggraphiccontext2 = processDeltaGC(svggraphiccontext1, groupGC);
            trimContextForElement(svggraphiccontext2, element);
            if(countOverrides(svggraphiccontext2) <= domTreeManager.maxGCOverrides)
            {
                currentGroup.appendChild(element);
                if((word0 & 1) == 0)
                    svggraphiccontext2.getContext().put("stroke", "none");
                if((word0 & 0x10) == 0)
                    svggraphiccontext2.getContext().put("fill", "none");
                domTreeManager.getStyleHandler().setStyle(element, svggraphiccontext2.getContext(), domTreeManager.getGeneratorContext());
                setTransform(element, svggraphiccontext2.getTransformStack());
            } else
            {
                currentGroup = domTreeManager.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "g");
                addElement(element, word0);
            }
        } else
        {
            currentGroup = domTreeManager.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "g");
            gc.validateTransformStack();
            addElement(element, word0);
        }
    }

    protected int countOverrides(SVGGraphicContext svggraphiccontext)
    {
        return svggraphiccontext.getGroupContext().size();
    }

    protected void trimContextForElement(SVGGraphicContext svggraphiccontext, Element element)
    {
        String s = element.getTagName();
        Map map = svggraphiccontext.getGroupContext();
        if(s != null)
        {
            Iterator iterator = map.keySet().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                String s1 = (String)iterator.next();
                SVGAttribute svgattribute = SVGAttributeMap.get(s1);
                if(svgattribute != null && !svgattribute.appliesTo(s))
                    map.remove(s1);
            } while(true);
        }
    }

    protected void setTransform(Element element, TransformStackElement atransformstackelement[])
    {
        String s = domTreeManager.gcConverter.toSVG(atransformstackelement).trim();
        if(s.length() > 0)
            element.setAttributeNS(null, "transform", s);
    }

    protected SVGGraphicContext processDeltaGC(SVGGraphicContext svggraphiccontext, SVGGraphicContext svggraphiccontext1)
    {
        Map map = processDeltaMap(svggraphiccontext.getGroupContext(), svggraphiccontext1.getGroupContext());
        Map map1 = svggraphiccontext.getGraphicElementContext();
        TransformStackElement atransformstackelement[] = svggraphiccontext.getTransformStack();
        TransformStackElement atransformstackelement1[] = svggraphiccontext1.getTransformStack();
        int i = atransformstackelement.length - atransformstackelement1.length;
        TransformStackElement atransformstackelement2[] = new TransformStackElement[i];
        System.arraycopy(atransformstackelement, atransformstackelement1.length, atransformstackelement2, 0, i);
        SVGGraphicContext svggraphiccontext2 = new SVGGraphicContext(map, map1, atransformstackelement2);
        return svggraphiccontext2;
    }

    protected Map processDeltaMap(Map map, Map map1)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            String s1 = (String)map.get(s);
            String s2 = (String)map1.get(s);
            if(!s1.equals(s2))
                hashmap.put(s, s1);
        } while(true);
        return hashmap;
    }

    public static final short DRAW = 1;
    public static final short FILL = 16;
    protected GraphicContext gc;
    protected DOMTreeManager domTreeManager;
    protected SVGGraphicContext groupGC;
    protected Element currentGroup;
}
